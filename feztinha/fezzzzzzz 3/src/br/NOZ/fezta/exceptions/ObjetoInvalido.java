package br.NOZ.fezta.exceptions;

public class ObjetoInvalido extends Exception{
	
	private String tipoValido;
	
	public ObjetoInvalido(String tipo)
	{
		super("Objeto invalido, use um objeto do tipo" + tipo);
		tipoValido = tipo;
	}
	public String getTipoValido()
	{
		return tipoValido;
	}

}
