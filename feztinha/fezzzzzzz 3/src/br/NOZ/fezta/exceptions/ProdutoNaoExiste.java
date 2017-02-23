package br.NOZ.fezta.exceptions;

public class ProdutoNaoExiste extends Exception{

	private String produtoInexistente;
	
	public ProdutoNaoExiste(String produto)
	{
		super("Produto " + produto + " não existe.");
		produtoInexistente = produto;
	}

	public String getProdutoInexistente() {
		return produtoInexistente;
	}
	
}
