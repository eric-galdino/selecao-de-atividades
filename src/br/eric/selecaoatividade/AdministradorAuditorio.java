package br.eric.selecaoatividade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdministradorAuditorio {

	private ArrayList<Atividade> atividades;
	
	public AdministradorAuditorio(ArrayList<Atividade> atividades){
		this.atividades = atividades;
	}

	public Map<Integer, Integer> alocarPalestras(int qtdTempo) {
		 
		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		
		int qtdGeracoes = 0;
		int horasQFalta = 0;
		for (int i = 0; i < atividades.size(); i++) {
			int hrsAtividade = Math.abs(atividades.get(i).getHrsNescessarias());
			qtdTempo = qtdTempo - hrsAtividade;
			if(qtdTempo >= 0){
					mapa.put(atividades.get(i).getId(), Math.abs(atividades.get(i).getHrsNescessarias()));				
			}else if(qtdTempo < 0){
				horasQFalta = hrsAtividade + qtdTempo;
				//Caso não encontre uma palestra com horas fechadas alocar outra com horario que bata com o horario reservado
			}
		}	
		
		return mapa;
	}
}
