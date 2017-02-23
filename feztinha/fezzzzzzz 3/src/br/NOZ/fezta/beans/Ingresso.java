package br.NOZ.fezta.beans;

import java.time.LocalDateTime;

public class Ingresso {
	
	@Override
	public String toString() {
		return "Ingresso [cliente=" + cliente.getNome() +", cpf=" + cliente.getCpf() + ", codigo=" + codigo + ", dia=" + dia + ", preco=" + preco + ", pista="
				+ pista + ", entrada=" + entrada + ", saida=" + saida + "]";
	}

	private Cliente cliente;
	private String nome;


	private String codigo = null;
	//private String cartao;
	private Evento dia;
	private int preco;
	private String pista;
	private LocalDateTime entrada = null;
	private LocalDateTime saida = null;
	
	public Ingresso()
	{
		cliente = new Cliente();
		dia = new Evento();
	}

	public Ingresso(Cliente c, Evento e)
	{
		cliente = c;
		dia = e;
		preco = 0;
		pista = "";
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDia(Evento dia) {
		this.dia = dia;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	
	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getPista() {
		return pista;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getDia() {
		return dia;
	}

	public void setEvento(Evento dia) {
		this.dia = dia;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
