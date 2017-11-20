package br.eric.selecaoatividade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main (String [] args) {
		
		System.out.println("-------------------------------------------------\n");
		
        scan = new Scanner(System.in);
        System.out.println("INFORME O TEMPO DE RESERVA DO AUDITÓRIO?");
        int qtdTempo = scan.nextInt();
        
        GeradorDeAtividades gerador = new GeradorDeAtividades(10);
        ArrayList<Atividade> atividades = gerador.gerarAtividades();
        Collections.sort(atividades);
        Collections.reverse(atividades);
        
		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		
		//int qtdTempo = 5;
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
		
		System.out.println("\n----------INFORMAÇÕES DAS PALESTRAS---------------");
		for (int i = 0; i < atividades.size(); i++) {
			System.out.println(atividades.get(i).toString());
		}
		
		System.out.println("\n-------(ID DA PALESTRA E HORA NECESSÁRIA)--------");
		System.out.println(mapa.toString());
		
		System.out.println("\n-------------------------------------------------");
		
	}
}
