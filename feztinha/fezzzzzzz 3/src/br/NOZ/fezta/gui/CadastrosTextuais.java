/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.NOZ.fezta.gui;

/*
import Gerenciador.OperarProdutos;

import Repositorio.Beans.Cliente;
import Repositorio.Beans.Endereco;
import Repositorio.Beans.Evento;
import Repositorio.Beans.Funcionario;
import Repositorio.Beans.Ingresso;
import Repositorio.Beans.Login;
*/
import br.NOZ.fezta.repositorio.*;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.gerenciador.*;


import java.time.LocalDate;
import java.util.Scanner;


public class CadastrosTextuais {
    
    
    
    
    public static  Funcionario Tfuncionario()
    {
        Scanner scanf = new Scanner(System.in);
        
        String  nome1, funcao1, cpf1, telefone1, usuario1, senha1;
        Endereco endereco1;
        double salario1;
        TelaLogin novo1;
        
        System.out.println("Nome: ");
        nome1   = scanf.nextLine();
        
        System.out.println("Função: ");
        funcao1=scanf.nextLine();
        System.out.println("\n");
        System.out.println("Salário: ");
        salario1 = scanf.nextDouble();
        funcao1 = scanf.nextLine();
        System.out.println("CPF: ");
        cpf1   = scanf.nextLine();
        System.out.println("Telefone: ");
        telefone1  = scanf.nextLine();
        novo1 = Tlogin();
        endereco1 = Tendereco();
        
        Funcionario funcio1 = new Funcionario(nome1,funcao1, cpf1,salario1, telefone1, endereco1, novo1);
       
        return funcio1;
    }
        
    public static TelaLogin Tlogin()
    {
        Scanner scanf = new Scanner(System.in);
        String usuario1, senha1;
        System.out.println("Digite novo login: ");
        usuario1  = scanf.nextLine();
        System.out.println("Digite nova senha: ");
        senha1  = scanf.nextLine();
        
        TelaLogin novo = new TelaLogin(usuario1, senha1);
        
       return novo;
    }
    public static Endereco Tendereco(){
    
        Scanner scanf = new Scanner(System.in);
    String cep1, numero1, bairro1, rua1;
    
        System.out.println("CEP: ");
        cep1 = scanf.nextLine();
        System.out.println("Número: ");
        numero1 = scanf.nextLine();
        System.out.println("Bairro: ");
        bairro1 = scanf.nextLine();
        System.out.println("Rua: ");
        rua1 = scanf.nextLine();
        
        Endereco funcioEndereco = new Endereco(cep1, numero1, bairro1, rua1);
        
        return funcioEndereco;
    
    }
    public static Evento Tevento()
    {
         Scanner scanf = new Scanner(System.in);
         Integer codigo;
         LocalDate data;
         int dia, mes,ano;
         
         System.out.println("Codigo do evento: ");
         codigo = scanf.nextInt();
         
         System.out.println("Agende o evento: dd/mm/aa");
         dia = scanf.nextInt();
         mes = scanf.nextInt();
         ano  = scanf.nextInt();
         
         Evento novo = new Evento(LocalDate.of(ano, mes, dia),codigo);
         return novo;
         
         
         
        
    }
    public static Ingresso TIngresso()
	{
		Cliente cli = Tcliente();
		
		Ingresso ing = null;
		
		String cod;
		
		Scanner scanf = new Scanner(System.in);
		System.out.println("Evento: ");
		cod = scanf.nextLine();
		
		if(RepositorioEventos.getInstance().procurarEvento(cod) != null)
		{
			ing = new Ingresso(cli, RepositorioEventos.getInstance().procurarEvento(cod));
		}
		
		return ing;
	}
    
    public static Cliente Tcliente()
	{
		Scanner scanf = new Scanner(System.in);
		
		String nome, cpf;
		
		System.out.println("Nome: ");
                 nome = scanf.nextLine();
		
                System.out.println("CPF: ");
                 cpf   = scanf.nextLine();
        
		//cliente cli = new cliente(nome, cpf, LocalDate.now());
		return new Cliente(nome, cpf, LocalDate.now());
	}
    
    
    public static void Tproduto(GerenciadorProdutos produtos)
    {
        Scanner scanf = new Scanner(System.in);
        String name, code;
        double price;
        int quant;
        
        System.out.println("Nome: ");
        name  = scanf.nextLine();
        System.out.println("Codigo: ");
        code = scanf.nextLine();
        System.out.println("Preço: ");
        price = scanf.nextDouble();
        System.out.println("Quantidade: ");
        quant = scanf.nextInt();
        
        produtos.addProduto(name, code, price, quant);
    }
}
    
    
    

