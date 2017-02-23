package br.NOZ.fezta.exceptions;

public class ClienteJaEntrou extends Exception{

	private String clienteExistente;
	
	public ClienteJaEntrou(String cliente)
	{
		super("Cliente " + cliente + "já existe");
		clienteExistente = cliente;
	}

	public String getClienteExistente() {
		return clienteExistente;
	}
	
}
