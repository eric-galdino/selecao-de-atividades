package br.eric.selecaoatividade;

import java.util.ArrayList;

public class GeradorDeAtividades {

	private int numeroAtividades;
	private int numeroAtdvReaisGeradas;
	private boolean concluido;
	
	public GeradorDeAtividades(int numeroAtividades){
		this.numeroAtividades = numeroAtividades;
	}
	
	
	public int getNumeroAtividades() {
		return numeroAtdvReaisGeradas;
	}


	public void setNumeroAtividades(int numeroAtividades) {
		this.numeroAtividades = numeroAtividades;
	}

	public ArrayList<Atividade> gerarAtividades() {	
		
		//GERAÇÃO DAS ATIVIDADES RANDOMICAMENTE
		ArrayList<Atividade> atividades = new ArrayList<Atividade>(numeroAtividades);
		this.numeroAtdvReaisGeradas = 0;
		int loopsFor = 0;
		do {
			for (int i = 0; i < numeroAtividades; i++) {
				int inicio = (int)(Math.random()*5);
				int fim = (int)(Math.random()*10);
				
				Atividade atvd = new Atividade(i+loopsFor, inicio, fim);
				
				if(atvd.getTempoInicio() < atvd.getTempoFim()){
					atividades.add(atvd);
					numeroAtdvReaisGeradas = numeroAtdvReaisGeradas + 1;
					if(numeroAtdvReaisGeradas == numeroAtividades){
						this.concluido = true;
						break;
					}
				}	
			}
			loopsFor = numeroAtividades + 1;
		} while (this.concluido != true);
		return atividades;	
	}
}
