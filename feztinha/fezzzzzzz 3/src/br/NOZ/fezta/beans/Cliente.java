package br.NOZ.fezta.beans;
import java.time.LocalDate;

public class Cliente {
	

    private String nome;
    private String cpf;
    //private String codigo;
    private LocalDate visita;
    private Produto[] produtos = new Produto[100];
    private int totalProdutos = 0;
    private float totalPreco = 0;
    
    public String toString()
    {
        return "Nome: "+getNome()+"\nCPF: "+getCpf();//+"\nCodigo: "+getCodigo();
    }
    
    public Cliente(String nome1, String cpf1, LocalDate visita1)
    {
        nome = nome1;
        cpf = cpf1;
        //codigo = codigo1;
       
        visita=visita1;
    }
    
    public void addConsumo(Produto item)
    {
    	produtos[totalProdutos] = new Produto(item);
    	produtos[totalProdutos].setQuantidade(1);
    	totalProdutos++;
    }
    
    public void addConsumo(Produto item, int total)
    {
    	produtos[totalProdutos] = new Produto(item);
    	produtos[totalProdutos].setQuantidade(total);
    	totalProdutos++;
    }
   
    public Cliente()
    {
        nome = "";
        cpf = "";
        //codigo ="";  
    }

   public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /*
    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }*/

   
    public LocalDate getVisita() {
        return visita;
    }

   
    public void setVisita(LocalDate visita) {
        this.visita = visita;
    }

	public float getTotalPreco() {
		return totalPreco;
	}

	public void setTotalPreco(double d) {
		this.totalPreco = (float) d;
	}

	public Produto[] getProdutos()
	{
		return produtos;
	}

	public Cliente vender(Produto produto, int q) {
		Produto np = new Produto(produto);
		np.setQuantidade(q);
		produtos[this.totalProdutos] = np;
		// TODO Auto-generated method stub
		return this;
	}
}
