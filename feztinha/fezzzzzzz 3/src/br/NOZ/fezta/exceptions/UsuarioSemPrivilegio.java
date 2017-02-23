package br.NOZ.fezta.exceptions;

public class UsuarioSemPrivilegio extends Exception{
	
	public UsuarioSemPrivilegio() {

		super("Usuário sem privilegio para a ação");
	}

}
