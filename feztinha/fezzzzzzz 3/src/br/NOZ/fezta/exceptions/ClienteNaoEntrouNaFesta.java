package br.NOZ.fezta.exceptions;

public class ClienteNaoEntrouNaFesta extends Exception{

	private String clienteFora;
	
	public ClienteNaoEntrouNaFesta(String cliente)
	{
		super("Cliente " + cliente + " não entrou na festa.");
		clienteFora = cliente;
	}

	public String getClienteFora() {
		return clienteFora;
	}
	
	
}
