package br.NOZ.fezta.exceptions;

public class ProdutoJaExiste extends Exception{

	private String produtoCadastrado;
	
	public ProdutoJaExiste(String cod)
	{
		super("Produto " + cod + " já existe");
		produtoCadastrado = cod;
	}

	public String getProdutoCadastrado() {
		return produtoCadastrado;
	}
	
}
