package br.eric.selecaoatividade;

import java.util.ArrayList;

public class GeradorDeAtividades {

	private int numeroAtividades;
	
	public GeradorDeAtividades(int numeroAtividades){
		this.numeroAtividades = numeroAtividades;
	}
	
	public ArrayList<Atividade> gerarAtividades() {		
		
		ArrayList<Atividade> atividades = new ArrayList<Atividade>(10);

		//Geração das atividades
		for (int i = 0; i < numeroAtividades; i++) {
			int inicio = (int)(Math.random()*5);
			int fim = (int)(Math.random()*10);
			
			Atividade atvd = new Atividade(i, inicio, fim);
			
			if(atvd.getTempoInicio() < atvd.getTempoFim()){
				atividades.add(atvd);
			}	
		}
		return atividades;
	}
	
}
