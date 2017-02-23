package br.NOZ.fezta.exceptions;

public class FuncionarioNaoExiste extends Exception {
	
	private String cpfInexistente;
	
	public FuncionarioNaoExiste(String cpf)
	{
		super("CPF " + cpf + " não cadastrado.");
		cpfInexistente = cpf;
	}

	public String getCpfInexistente() {
		return cpfInexistente;
	}
	
}