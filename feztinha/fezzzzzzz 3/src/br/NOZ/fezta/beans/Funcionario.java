 
package br.NOZ.fezta.beans;

import java.io.Serializable;

//import static br.NOZ.fezta.repositorio.beans.Login.*;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

//import javax.swing.JOptionPane;

public class Funcionario implements Serializable{
    
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco residencia;
    private double salario;
   
    private Login login;
    private ArrayList <LocalDateTime> escalamento = new ArrayList<LocalDateTime>();
    
    
    private String funcao;
    
    
  
    public Funcionario()
    {
     int i;
    nome = "";
    cpf="";
    telefone="";
    residencia = new Endereco();
    salario=0;
    funcao="";
    for(i=0; i<=2; i++)
    //escalamento[i]=LocalDate.of(12,12,12);
    login = new Login();
    
    }
    public boolean equals(Funcionario f2)
    {
    	if(this.nome.equals(f2.getNome()) && this.cpf.equals(f2.getCpf()) && this.salario == f2.getSalario())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean equalsx(String usuarioDigitada, String senhaDigitada)
    {
       if(getLogin().entra(usuarioDigitada, senhaDigitada))
    	   {
    	   		return true;
    	   }
       
       else
    	   {
    	   		return false;
    	   }
       
    }
    
    public Funcionario(String nome1, String funcao1, String cpf1, double salario1, 
    		String telefone1, Endereco endereco1, String usuarios1, String senhas1)//, int n)
    {
        
    //this.escalamento=escalamento1;
    this.nome = nome1;
    this.cpf=cpf1;
    this.telefone=telefone1;
    this.residencia=endereco1;
    this.salario=salario1;
    this.funcao=funcao1;
    this.login = new Login(usuarios1, senhas1);//, n);
   
    
    }  
       public Funcionario(String nome1, String funcao1, String cpf1, double salario1, 
    		String telefone1, Endereco endereco1, Login novo)//, int n)
    {
        
    //this.escalamento=escalamento1;
    this.nome = nome1;
    this.cpf=cpf1;
    this.telefone=telefone1;
    this.residencia=endereco1;
    this.salario=salario1;
    this.funcao=funcao1;
    this.login = novo;//, n);
   
    //nome1,funcao1, cpf1, telefone1, endereco1, novo1
    } 
    public String toString()
    {
        String a =  "Nome: "+getNome()+"\nFuncao: "+getFuncao()+"\nCPF: "+getCpf()+"\nTelefone: "+getTelefone()+"\nEndereço: "+getEndereco().getBairro();
        a = a  + "\n \t "+getEndereco().getRua()+"\n \t"+getEndereco().getNumero()+"\n";
        a = a + "\nSalario: "+getSalario()+"\n";
        return a;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return this.residencia;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco1) {
        this.residencia = endereco1;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
/*
    /**
     * @return the senhas
     *
    public login getSenhas() {
        return senhas1;
    }

    /**
     * @param senhas the senhas to set
     * */
    public void setLogin(Login senhas) {
        this.login = senhas;
    }

    /**
     * @return the escalamento
     */
    public ArrayList<LocalDateTime> getEscalamento() {
        return escalamento;
    }

    /**
     * @param escalamento the escalamento to set
     */
    public void setEscalamento(ArrayList<LocalDateTime> escalamento) {
        this.escalamento = escalamento;
    }
    
    public boolean addEscalamento(LocalDateTime inicio, LocalDateTime fim)
    {
    	boolean aux = false;
    	if(this.horarioEscalado(inicio)[0] == null && this.horarioEscalado(fim)[0] == null)
    	{
    		this.escalamento.add(inicio);
    		this.escalamento.add(fim);
    	}
    	return aux;
    	/*
    	this.escalamento.add(inicio);
    	this.escalamento.add(fim);*/
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public LocalDateTime[] horarioEscalado(LocalDateTime e)
    {
    	LocalDateTime[] range = new LocalDateTime[2];
    	for(int i = 0; i < this.escalamento.size(); i+=2)
    	{
    		if(this.escalamento.get(i).isAfter(e) && this.escalamento.get(i+1).isBefore(e))
    		{
    			range[0] = this.escalamento.get(i);
    			range[1] = this.escalamento.get(i + 1);
    		}
    	}
    	return range;
    }
/*
    public static void trocarSenha(OFuncionario[] funcios, int tam, String senhaDigitada1, String usuarioDigitado1)
    {
        int q;
        String novaSenha;
        q = entra(funcios, tam,senhaDigitada1, usuarioDigitado1);
        
        if(q!=-1)
        {
            
            novaSenha = JOptionPane.showInputDialog("DIGITE A NOVA SENHA");
            funcios[q].senhas1.setSenha(novaSenha);
        }
            
    }
    
    */

    /**
     * @return the senhas1
     */
    public Login getLogin() {
        return login;
    }
    
    
}
