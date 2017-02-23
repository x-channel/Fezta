package br.NOZ.fezta.exceptions;

public class FuncionarioLoginDuplicado extends Exception{
	
	private String loginDuplicado;
	
	public FuncionarioLoginDuplicado (String login)
	{
		super("O login " + login + " já está em uso.");
		loginDuplicado = login;
	}

	public String getLoginDuplicado() {
		return loginDuplicado;
	}

}
