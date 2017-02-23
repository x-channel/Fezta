package br.NOZ.fezta.exceptions;

public class ClienteNaoExiste extends Exception{

	private String clienteInexistente;
	
	public ClienteNaoExiste(String cliente)
	{
		super("Cliente " + cliente + " não existe.");
		clienteInexistente = cliente;
	}

	public String getClienteInexistente() {
		return clienteInexistente;
	}
	
	
}
