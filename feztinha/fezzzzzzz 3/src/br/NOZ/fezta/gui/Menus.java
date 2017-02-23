/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.NOZ.fezta.gui;
/*
import static GUI.CadastrosTextuais.Tevento;
import static GUI.CadastrosTextuais.Tfuncionario;
import static GUI.CadastrosTextuais.Tproduto;
import static GUI.TelaTextual.limparConsole;
import Gerenciador.GerenciarEventos;
import Gerenciador.OperarProdutos;
import Gerenciador.GerenciadorFuncionario;
import Gerenciador.OperarCliente;
import Repositorio.Beans.Evento;
import Repositorio.Beans.Ingresso;
import Repositorio.Estoque;
import Repositorio.RepositorioFuncionario;
import Repositorio.RepositorioIngresso;
*/

import br.NOZ.fezta.gui.*;
import br.NOZ.fezta.gerenciador.*;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.repositorio.*;


import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Larissa
 */
public class Menus {
    
    
    public static void Dono( GerenciadorFuncionario funcionarios) throws IOException
    {
        int menu;
        String testes;
        int contador;
        Scanner scanf = new Scanner(System.in);
        boolean fechar = false;
        do
                                {
                                  
        		System.out.println("\t\tMenu Principal\n\t\t0 para sair\n\n1 - Adimitir Funcionario\n\n2 - Demitir Funcionario\n\n3 - Editar Funcionario\n\n4 - Visualizar Funcionario\n\n5 - Visualizar Todos Funcionários\n\n6 - Escalar Horário\n\n7 - EditarHorario");
				
                                limparConsole();
                                menu = scanf.nextInt();
                                limparConsole();
                                  
                                    if(menu==0)
                                        fechar = true;
				switch (menu)
                                
                                {
                                    
                                        case 1:
                                        {
                                            limparConsole();

                                                System.out.println("\t\tADIMITIR FUNCIONARIO");

                                                funcionarios.admitir(Tfuncionario());
                                                limparConsole();
                                                 System.out.println("Funcionario Cadastro");
                                                break;
                                        }
                                        
                                        
                                        case 2:
                                        {
                                            limparConsole();

                                                System.out.println("\t\tDEMITIR FUNCIONARIO");

                                                System.out.println("Digite o CPF do funcionario a ser demitido");

                                                testes = scanf.next();

                                                if(funcionarios.demitir(testes))
                                                    System.out.println("Funcionario demitido");
                                                else
                                                    System.out.println("Funcionario não encontrado");
                                                System.in.read();
                                                break;
                                        }
                                        
                                        
                                        case 3:
                                                limparConsole();
                                                System.out.println("\t\tEDITAR FUNCIONARIO");
                                                System.out.println("Digite o CPF do funcionario a ser editado: ");
                                                 testes = scanf.next();
                                                 System.out.println("\t\tAlterar:\n1-Função\n2-Salário\n3-Telefone\n4-Endereço");
                                                 menu = scanf.nextInt();
                                                 if(funcionarios.editarFuncionario(testes, menu))
                                                     System.out.println("Funcionario editado");

                                                 else
                                                   System.out.println("Funcionario não encontrado");
                                                System.in.read();

                                                break;

                                        case 4:
                                            System.out.println("Digite o CPF do funcionario a exibido: ");
                                             testes = scanf.next();
                                            if(RepositorioFuncionario.getInstance().procurarFuncionario(testes) != null)
                                                {
                                                    System.out.println(RepositorioFuncionario.getInstance().procurarFuncionario(testes).toString());
                                                    System.in.read();


                                                }

                                            else 
                                                System.out.println("Funcionário não encontrado");
                                             System.in.read();

                                             break;
                                             
                                             
                                        case 5:
                                            System.out.println("\t\tLista de funcionários");
                                            for(contador = 0; contador< RepositorioFuncionario.getInstance().getRepfun().size(); contador++)
                                            {
                                                System.out.print(contador+1+")");
                                                System.out.println(RepositorioFuncionario.getInstance().getRepfun().get(contador).toString());
                                                System.out.println("\n\n");
                                            }
                                            break;
                                        case 6: 
                                                limparConsole();
                                                System.out.println("\t\tESCALAR HORÁRIO");
                                                /*
                                                 * 
                                                 * 
                                                 */
                                                break;
                                        case 7:
                                                limparConsole();
                                                System.out.println("\t\tEDITAR HORÁRIO");
                                                /*
                                                 * 
                                                 * 
                                                 */
                                                break;
                                        default:
                                                limparConsole();
                                                System.out.println("\nOpção invalida!\n\n");
                                        }

                                }while(!fechar);
    }
    
    
    public static void Gerente(GerenciadorEventos eventos)   throws IOException
    {
        	   int menu;
                   String testes;
                   int contador;
                   Scanner scanf = new Scanner(System.in);
				System.out.println("\t\tGERENTE\n\n1- Adicionar Evento\n\n2 - Remover Evento\n\n3 - Atualizar Evento");
				menu = scanf.nextInt();
				switch (menu) {
				case 1:
					limparConsole();
					System.out.println("\t\tADICIONAR EVENTO");
                                        Evento novo = new Evento();
                                        novo = Tevento();
					eventos.addEvento(novo.getCodigo(), novo);
					break;
				case 2:
					limparConsole();
					System.out.println("\t\tREMOVER EVENTO");
                                          System.out.println("Digite o codigo do evento a ser editado");
                                        
                                          testes = scanf.next();
                                          
                                          if(eventos.removerEvento(testes))
                                              System.out.println("Evento removido");
                                          else 
                                              System.out.println("Evento não encontrado");
                                          System.in.read();
                                          
					break;
				case 3:
					limparConsole();
					System.out.println("\t\tATUALIZAR EVENTO");
					/*
					 * 
					 * 
					 */
					break;
				default:
					limparConsole();
					System.out.println("\nOpção invalida!\n\n");
				}
    }
    
    public static void FuncionarioIngressos(GerenciadorCliente clientes)
    {
        
        	   int menu;
                   String testes;
                   int contador;
                   Scanner scanf = new Scanner(System.in);
                   
                           	System.out.println("\t\tVENDEDOR INGRESSO\n\n1 - Cadastrar Cliente\n\n2 - Marcar Entrada\n\n3 - Marcar saida");
				menu = scanf.nextInt();
				scanf.nextLine();
                                
				switch (menu) {
				case 1:
					limparConsole();
					System.out.println("\t\tCadastras Cliente\n\n");
					
					Ingresso ningresso = CadastrosTextuais.TIngresso();
					if(ningresso != null)
					{
						RepositorioIngresso.getInstance().cadastrarIngresso(ningresso);
						System.out.println("Cliente cadastrado");
					}
					else
					{
						System.out.println("Cliente não cadastrado");
					}
					
                                        
					break;
				case 2:
					limparConsole();
					System.out.println("\t\tMarcar entrada");
					testes = scanf.nextLine();
					System.out.println(testes);
					if(RepositorioIngresso.getInstance().procurarIngresso(testes) != null && RepositorioIngresso.getInstance().procurarIngresso(testes).getEntrada() == null)
					{
						clientes.marcarEntrada(RepositorioIngresso.getInstance().procurarIngresso(testes));
						System.out.println("O cliente entrou");
					}
					else
					{
						System.out.println("Cliente não encontrado");
					}
					/*
					 * 
					 * 
					 */
					break;
				case 3:
					limparConsole();
					System.out.println("\t\tMarcar saida");
					
					testes = scanf.nextLine();
					System.out.println(testes);
					if(RepositorioIngresso.getInstance().procurarIngresso(testes) != null && RepositorioIngresso.getInstance().procurarIngresso(testes).getSaida() == null)
					{
						clientes.marcarEntrada(RepositorioIngresso.getInstance().procurarIngresso(testes));
						System.out.println("O cliente saiu\n\tGerando conta\n");
						//System.out.println(RepositorioIngresso.getInstance().procurarIngresso(testes).getCliente().gerarNota());
					}
					else
					{
						System.out.println("Cliente não encontrado");
					}
					
					/*
					 * 
					 * 
					 */
					break;
				default:
					limparConsole();
					System.out.println("\nOpção invalida!\n\n");
				}
			
                                
    }
    
    public static void FuncionariosProdutos(GerenciadorProdutos produtos, GerenciadorCliente clientes) throws IOException
    {
        int menu;
                   String testes, p1, p2;
                   int contador;
                   Scanner scanf = new Scanner(System.in);
    
        System.out.println("\t\tVENDEDOR BARTENDER\n\n1 - Adicionar Produto\n\n2 - Remover Produto\n\n3 - Atualizar Produto\n\n4 - Vender Produto\n\n5-Trocar  usuário");
				menu = scanf.nextInt();
				scanf.nextLine();
				switch (menu) {
				case 1:
					limparConsole();
					System.out.println("\t\tADICIONAR PRODUTO");
					Tproduto(produtos);
					break;
				case 2:
					limparConsole();
					System.out.println("\t\tREMOVER PRODUTO");
			                System.out.println("Digite o codigo do produto a ser removido");
                                        testes = scanf.nextLine();
                                        if(produtos.removerProduto(testes))
                                            System.out.println("Produto removido com sucesso");
                                        else System.out.println("Produto não encontrado");
                                        System.in.read();
					break;
				case 3:
					limparConsole();
					System.out.println("\t\tATUALIZAR PRODUTO");
					break;
				case 4:
					limparConsole();
					System.out.println("\t\tVender produto");
					System.out.println("\nCliente em atendimento: ");
					p1 = scanf.nextLine();
					//scanf.nextLine();
					System.out.println("\nCodigo do produto: ");
					p2 = scanf.nextLine();
					System.out.println("\nQuantidade: ");
					int i = scanf.nextInt();
					
					System.out.println(RepositorioIngresso.getInstance().procurarIngresso(p1).toString());
					
					if(RepositorioIngresso.getInstance().procurarIngresso(p1) != null && RepositorioProdutos.getInstance().procurarProduto(p2) != null)
					{
						//clientes.addConsumo(p1, p2, i);
					}
					
    }
            
}
    
}
