package br.NOZ.fezta.exceptions;

public class NaoExistemFuncionarios extends Exception{
	
	public NaoExistemFuncionarios()
	{
		super("Não existem funcionários cadastrados.");
	}

}
