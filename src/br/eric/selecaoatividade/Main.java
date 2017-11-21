package br.eric.selecaoatividade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Scanner scan;
	private static int QUANTIDADE_ATIVIDADES = 10;
	private static int TOTAL_GERACOES = 0;

	public static void main (String [] args) {
		
		System.out.println("-------------------------------------------------");
        
        GeradorDeAtividades gerador = new GeradorDeAtividades(QUANTIDADE_ATIVIDADES);
        ArrayList<Atividade> atividades = gerador.gerarAtividades();
        
        Collections.sort(atividades);
        Collections.reverse(atividades);
        
        System.out.println("\nATIVIDADES GERADAS " + gerador.getNumeroAtividades());
        
        System.out.println("\n----------INFORMAÇÕES DAS PALESTRAS---------------");
        for (int i = 0; i < atividades.size(); i++) {
        	System.out.println(atividades.get(i).toString());
        } 
        
        scan = new Scanner(System.in);
        System.out.println("\nINFORME O TEMPO DE RESERVA DO AUDITÓRIO?");
        int qtdTempo = scan.nextInt();
        
        AdministradorAuditorio admin = new AdministradorAuditorio(atividades);
        Map<Integer, Integer> mapa = admin.alocarPalestras(qtdTempo);
       
		
		System.out.println("\n-------(ID DA PALESTRA E HORA NECESSÁRIA)--------");
		System.out.println(mapa.toString());
		
		System.out.println("\n-------------------------------------------------");
		
	}
}
