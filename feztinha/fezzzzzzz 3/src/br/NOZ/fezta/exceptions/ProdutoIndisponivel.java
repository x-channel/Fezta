package br.NOZ.fezta.exceptions;

public class ProdutoIndisponivel extends Exception{

	private String produto;
	
	public ProdutoIndisponivel(String prod) {
		super("Produto" + prod + "indisponivel para essa quantidade");
		produto = prod;
	}
}
