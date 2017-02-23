package br.NOZ.fezta.beans;
public class Endereco {
	
	private String CEP;
	private String numero;
	private String bairro;
	private String rua;
	
	public Endereco(String CEP1, String numero1, String bairro1, String rua1)
    {
        CEP = CEP1;
        numero = numero1;
        bairro = bairro1;
        rua = rua1;
    }
	
	public Endereco()
    {
        CEP = "";
        numero = "";
        bairro ="";
        rua = "";
    }
	
	public Endereco(String numero1, String bairro1, String rua1)
    {
		CEP = "";
		numero = numero1;
        bairro = bairro1;
        rua = rua1;
    }
	
	public Endereco(String CEP1,String numero1)
    {
		CEP = CEP1;
		numero = numero1;
		bairro ="";
        rua = "";
    }

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Endereco [CEP=" + CEP + ", numero=" + numero + ", bairro=" + bairro + ", rua=" + rua + "]";
	}

}
