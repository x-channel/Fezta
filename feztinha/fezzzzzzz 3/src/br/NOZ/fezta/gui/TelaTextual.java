/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.NOZ.fezta.gui;

/*import static GUI.CadastrosTextuais.Tevento;
import static GUI.CadastrosTextuais.Tfuncionario;
import static GUI.CadastrosTextuais.Tproduto;
import static GUI.Menus.*;
import Gerenciador.GerenciarEventos;
import Gerenciador.OperarProdutos;
import Gerenciador.GerenciadorFuncionario;
import Gerenciador.OperarCliente;
import java.util.Scanner;
*/

import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.gerenciador.*;
import br.NOZ.fezta.repositorio.*;
import br.NOZ.fezta.gui.*;

    
import java.util.ArrayList;
import java.util.Scanner;
//import Repositorio.RepositorioFuncionario;
//import Repositorio.Beans.*;
//import static Repositorio.Beans.Login.checaTodos;
import java.io.IOException;

   
public class TelaTextual {

	
	public static void limparConsole() {
		/*for (int i = 0; i < 11; i++) {
			System.out.println("\n");
		}*/
	}
        /*
	
	public static void main(String[] args) throws IOException {
            
		boolean fecharPrograma = false;
		Scanner scanf = new Scanner(System.in);
                
                GerenciarEventos eventos = new GerenciarEventos();
                OperarProdutos produtos = new OperarProdutos();
                GerenciadorFuncionario funcionarios = new GerenciadorFuncionario();
                OperarCliente clientes = new OperarCliente();
                funcionarios.admitir("", "dono", "", 0, "", "", "","", "", "dono", "123");
                String testes, nome, senha;
                boolean fechar = false;
                int teste=0;
                do
                {
                System.out.println("Login: ");
                nome = scanf.next();
                System.out.println("Senha: ");
                senha = scanf.next();
                 Login digitado = new Login(nome, senha);
                
                teste = checaTodos(digitado, RepositorioFuncionario.getInstance().getRepfun());
             
             
		int menu = 5;
                
                
                if( teste!=-1){
                if(RepositorioFuncionario.getInstance().getRepfun().get(teste).getFuncao().equals("gerente"))
                    menu = 2;
               else if(RepositorioFuncionario.getInstance().getRepfun().get(teste).getFuncao().equals("dono"))
                    menu=1;
                else 
               {
                   System.out.println("\n\n\t\tMenu de funcionario\n\n1 - Ingressos\n2 - Produtos");
                   teste = scanf.nextInt();
                   if(teste == 1)
                       menu = 3;
                   else if(teste ==2)
                       menu = 4;                   
               }
                    
                
                }
                
		
			        limparConsole();
			
		        
                          
                          switch (menu) {
                              case 0:
                                  fechar = true;
                            case 5: 
                                System.out.println("Usuário ou senha errados");
                                System.in.read();
                                break;
                            case 1:
                            
                                Dono(funcionarios);
                                
                                break;
                            
                            
//dono gerente
                                
                            case 2:
                            
                                Gerente(eventos);
                        
                                  break;
                        
				
                            case 3: 
				
                              FuncionarioIngressos(clientes);
                              break;
                            
                            case 4:
                                
                                FuncionariosProdutos(produtos, clientes);
                                break;
                              
                       
		
                
                
	}
}while(!fechar);
                }*/
}
       
