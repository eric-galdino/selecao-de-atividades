package br.eric.selecaoatividade;

public class Atividade implements Comparable<Atividade>{

	private int id;
	private int tempoInicio;
	private int tempoFim;
	private String nomeAtividade;
	private int hrsNescessarias; 	

	public Atividade(int id, int tempoInicio, int tempoFim){
		this.id = id;
		this.tempoInicio = tempoInicio;
		this.tempoFim = tempoFim;
		this.hrsNescessarias = this.tempoInicio - this.tempoFim;
	}
	
	public Atividade(int tempoInicio, int tempoFim, String nomeAtividade){
		this.tempoInicio = tempoInicio;
		this.tempoFim = tempoFim;
		this.nomeAtividade = nomeAtividade;
		this.hrsNescessarias = this.tempoInicio - this.tempoFim;
	}
	
	public int getHrsNescessarias() {
		return hrsNescessarias;
	}
	
	public void setHrsNescessarias(int hrsNescessarias) {
		this.hrsNescessarias = hrsNescessarias;
	}
	
	public int getTempoInicio() {
		return tempoInicio;
	}
	public void setTempoInicio(int tempoInicio) {
		this.tempoInicio = tempoInicio;
	}
	public int getTempoFim() {
		return tempoFim;
	}
	public void setTempoFim(int tempoFim) {
		this.tempoFim = tempoFim;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		string.append("{ ID: "+ this.id + ", ");
		string.append("Início: " + this.tempoInicio + ", ");
		string.append("Término: " + this.tempoFim + ", ");
		string.append("Horas necessárias: " + Math.abs(this.hrsNescessarias));
		string.append('}');
		
		return string.toString();
	}

	@Override
	public int compareTo(Atividade outraAtividade) {
		if (this.hrsNescessarias < outraAtividade.hrsNescessarias ) {
			return -1;
		}
		if (this.hrsNescessarias > outraAtividade.hrsNescessarias) {
			return 1;
		}
		return 0;
	}
	
}
