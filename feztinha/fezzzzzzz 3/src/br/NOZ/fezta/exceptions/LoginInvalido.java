package br.NOZ.fezta.exceptions;

public class LoginInvalido extends Exception{
	
	public LoginInvalido()
	{
		super("Login ou Senha invalido.");
	}
}
