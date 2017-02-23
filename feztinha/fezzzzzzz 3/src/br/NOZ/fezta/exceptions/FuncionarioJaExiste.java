package br.NOZ.fezta.exceptions;

public class FuncionarioJaExiste extends Exception{

	private String cpfJaCadastrado;
	
	public FuncionarioJaExiste(String cpf)
	{
		super("CPF " + cpf + "Já cadastrado");
		cpfJaCadastrado = cpf;
	}
	
	public String getCpfJacadastrado()
	{
		return cpfJaCadastrado;
	}
}
