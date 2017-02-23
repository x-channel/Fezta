package br.NOZ.fezta.beans;
import java.time.LocalDate;

public class Evento {
	
	private LocalDate dia = LocalDate.now();
	private double receita = 0;
	private double custo = 0;
	private String event;
	private String decoracao;
	private String assinaturaCPF;
	private String codigo;
        
      
	
	public boolean equals(Evento ev)
	{
		if (this.dia.equals(ev.getDia()) && 
				this.receita == ev.getReceita() && 
				this.custo == ev.getCusto() &&
				this.event.equals(ev.getEvento()) &&
				this.decoracao.equals(ev.getDecoracao()) &&
				this.assinaturaCPF.equals(ev.getAssinaturaCPF()) &&
				this.codigo.equals(ev.getCodigo()))
		{
			return true;
		}
		return false;
				
		
	}
	
        
	
	public Evento(LocalDate data, Integer codigo) {
		this.dia = LocalDate.of(data.getYear(), data.getMonth(), data.getDayOfMonth());
		this.codigo = codigo.toString();
		// duvida no int codigo!
	}
	
	public Evento(Integer codigo) {
		dia = LocalDate.now();
		this.codigo = codigo.toString();
	}
	
	public Evento(LocalDate data) {
		this.dia = LocalDate.of(data.getYear(), data.getMonth(), data.getDayOfMonth());
		codigo = "";
	}
	
	public Evento(){
		dia = LocalDate.now();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo.toString();
	}

	public String toString() {
		return "ODia [dia=" + dia + ", receita=" + receita + ", custo=" + custo + ", evento=" + event + ", decoracao="
				+ decoracao + ", assinaturaCPF=" + assinaturaCPF + "]";
	}
	
	public LocalDate getDia() {
		return dia;
	}

	public double getReceita() {
		return receita;
	}

	public double getCusto() {
		return custo;
	}

	public String getEvento() {
		return event;
	}

	public String getDecoracao() {
		return decoracao;
	}

	public String getAssinaturaCPF() {
		return assinaturaCPF;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public void setReceita(double receita) {
		this.receita = receita;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public void setEvento(String event) {
		this.event = event;
	}

	public void setDecoracao(String decoracao) {
		this.decoracao = decoracao;
	}

	public void setAssinaturaCPF(String assinaturaCPF) {
		this.assinaturaCPF = assinaturaCPF;
	}

}
