package br.NOZ.fezta.beans;
public class Produto {
	
	private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    
    
    public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto(String nome1, String codigo1, double preco1, int quantidade1)
    {
        nome = nome1;
        codigo = codigo1;
        preco = preco1;
        quantidade = quantidade1;
    }
	
	public Produto(Produto pro)
	{
		this.nome = pro.getNome();
		this.codigo = pro.getCodigo();
		this.preco = pro.getPreco();
		this.quantidade = pro.quantidade;
	}

        public Produto()
        {
            
        }
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public double getPreco() {
        return preco;
    }

   
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
