package br.NOZ.fezta.gui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import br.NOZ.fezta.beans.Cliente;
import br.NOZ.fezta.beans.Endereco;
import br.NOZ.fezta.beans.Evento;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.beans.Ingresso;
import br.NOZ.fezta.beans.Login;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.gerenciador.GerenciadorCliente;
import br.NOZ.fezta.gerenciador.GerenciadorEventos;
import br.NOZ.fezta.gerenciador.GerenciadorFuncionario;
import br.NOZ.fezta.gerenciador.GerenciadorProdutos;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;

public class Interface {

	public static int menu(String titulo, String[] opcoes) {
		Scanner key = new Scanner(System.in);
		// KeyEvent key = new KeyEvent(source, id, when, modifiers, keyCode)
		String entrada = "o";
		// int resposta = 0;
		int i = 0;
		int a = 0;
		while (entrada.equals("f") == false) {
			System.out.println("Use as teclas 'w' e 's' para navegar\n\n");
			System.out.println(titulo);

			entrada = "o";

			for (i = 0; i < opcoes.length; i++) {
				if (i == a) {
					System.out.format("  * %s\n", opcoes[i]);
				} else {
					System.out.format("    %s\n", opcoes[i]);
				}
			}

			entrada = key.next();
			if (entrada.equals("w") && a > 0) {
				a--;
			} else if (entrada.equals("s") && a < opcoes.length - 1) {
				a++;
			}
		}
		// key.next();
		// key.close();
		return a;
	}

	public static String menuCodigo(String titulo, String[] opcoes, String[] respostas) {
		Scanner key = new Scanner(System.in);
		// KeyEvent key = new KeyEvent(source, id, when, modifiers, keyCode)
		String entrada = "o";
		// int resposta = 0;
		int i = 0;
		int a = 0;
		while (entrada.equals("f") == false) {
			System.out.println("Use as teclas 'w' e 's' para navegar\n\n");
			System.out.println(titulo);

			entrada = "o";

			for (i = 0; i < opcoes.length; i++) {
				if (i == a) {
					System.out.format("  * %s\n", opcoes[i]);
				} else {
					System.out.format("    %s\n", opcoes[i]);
				}
			}

			entrada = key.next();
			if (entrada.equals("w") && a > 0) {
				a--;
			} else if (entrada.equals("s") && a < opcoes.length - 1) {
				a++;
			}
		}
		// key.next();
		// key.close();
		return respostas[i];
	}

	public static ArrayList<LocalDateTime> menuEscalamento(ArrayList<LocalDateTime> escalamento) {
		Scanner key = new Scanner(System.in);

		int marcado = 0;

		String opcao = "o";

		int i;

		LocalDateTime ent = LocalDateTime.now();
		LocalDateTime sai = LocalDateTime.now();

		int[] entrada = new int[5];
		int[] saida = new int[5];

		while (opcao.equals("f") == false || marcado != 0) {
			System.out.println(
					"Use as teclas 'w' e 's' para navegar dentro do menu\n use a tecla 'f' para escolher\n\n\tMenu de escalamento dos funcionários.");

			if (marcado == 0) {
				System.out.format("  * Voltar\n");
			} else {
				System.out.format("    Voltar\n");
			}
			if (marcado == 1) {
				System.out.format("  * Adicionar Horário\n");
				if (opcao.equals("f")) {
					escalamento.add(ent);
					escalamento.add(sai);
				}
			} else {
				System.out.format("    Adicionar Horário\n");
			}

			for (i = 0; i < escalamento.size() - 1; i += 2) {
				if (marcado == (i / 2) + 2) {
					System.out.format("  * Horário de trabalho, de %s até %s", escalamento.get(i).toString(),
							escalamento.get(i + 1).toString());
					if (opcao.equals("f")) {
						escalamento.set(i, ent);
						escalamento.set(i + 1, sai);
					}
				} else {
					System.out.format("    Horário de trabalho, de %s até %s", escalamento.get(i).toString(),
							escalamento.get(i + 1).toString());
				}
			}
			opcao = "o";
			opcao = key.next();
			if (opcao.equals("w") && marcado > 0)
				marcado--;
			else if (opcao.equals("s") && marcado < (escalamento.size()) / 2 + 1)
				marcado++;
			else if (marcado != 0 && opcao.equals("f")) {
				System.out.print("Entrada do funcionário escalado\n");
				System.out.print("Ano: ");
				entrada[0] = key.nextInt();
				if (entrada[0] == 0) {
					entrada[0] = LocalDateTime.now().getYear();
				}
				System.out.print("Mês: ");
				entrada[1] = key.nextInt();
				System.out.print("Dia: ");
				entrada[2] = key.nextInt();
				System.out.print("Hora: ");
				entrada[3] = key.nextInt();
				System.out.print("Minuto: ");
				entrada[4] = key.nextInt();
				System.out.print("\nSaida do funcionário escalado\n");

				System.out.print("Ano: ");
				do {
					saida[0] = key.nextInt();
				} while (entrada[0] > saida[0]);
				System.out.print("Mês: ");
				do {
					saida[1] = key.nextInt();
				} while (entrada[1] > saida[1]);
				System.out.print("Dia: ");
				do {
					saida[2] = key.nextInt();
				} while (entrada[2] > saida[2]);
				System.out.print("Hora: ");
				do {
					saida[3] = key.nextInt();
				} while (entrada[3] >= saida[3]);
				System.out.print("Minuto: ");
				saida[4] = key.nextInt();

				ent = LocalDateTime.of(entrada[0], entrada[1], entrada[2], entrada[3], entrada[4]);
				sai = LocalDateTime.of(saida[0], saida[1], saida[2], saida[3], saida[4]);

			}
		}

		return escalamento;
	}

	public static Login menuLogin(Login login) {
		Scanner key = new Scanner(System.in);

		String opcao = "o";
		String valorLogin = "";
		String valorSenha = "";
		String valorNovo = "";

		int marcado = 0;

		while (opcao.equals("f") == false || marcado != 2) {
			System.out.println(
					"Use as teclas 'w' e 's' para navegar dentro do menu\n use a tecla 'f' para escolher\n\n\tMenu de edição de Login.");

			if (marcado == 0) {
				if (opcao.equals("f")) {
					login.setUsuario(valorLogin, valorNovo, valorSenha);
				}
				System.out.format("  * Login: %s\n", login.getUsuario());
			} else {
				System.out.format("    Login: %s\n", login.getUsuario());
			}

			if (marcado == 1) {
				if (opcao.equals("f")) {
					login.setSenha(valorLogin, valorSenha, valorNovo);
				}
				System.out.format("  * Senha: *****\n");
			} else {
				System.out.format("    Senha: *****\n");
			}

			if (marcado == 2) {
				System.out.print("  * Sair\n");
			} else {
				System.out.print("    Sair\n");
			}

			opcao = "o";

			opcao = key.next();

			if (opcao.equals("w") && marcado > 0) {
				marcado--;
			} else if (opcao.equals("s") && marcado < 2) {
				marcado++;
			} else if (opcao.equals("f") && marcado != 2) {
				System.out.print("Login: ");
				valorLogin = key.next();
				System.out.print("Senha: ");
				valorSenha = key.next();
				System.out.print("Valor Novo: ");
				valorNovo = key.next();
			}
		}

		return login;
	}

	public static Endereco menuEndereco(Endereco endereco) {
		Scanner key = new Scanner(System.in);

		String opcao = "o";
		String valorString = "";
		// int valorInt = 0;
		// double valorDouble = 0.0;

		int marcado = 0;

		while (opcao.equals("f") == false || marcado != 4) {
			System.out.println(
					"Use as teclas 'w' e 's' para navegar dentro do menu\n use a tecla 'f' para escolher\n\n\tMenu de edição de endereço.");

			if (marcado == 0) {
				if (opcao.equals("f"))
					endereco.setCEP(valorString);
				System.out.format("  * CEP: %s\n", endereco.getCEP());
			} else {
				System.out.format("    CEP: %s\n", endereco.getCEP());
			}
			if (marcado == 1) {
				if (opcao.equals("f"))
					endereco.setNumero(valorString);
				System.out.format("  * Numero: %s\n", endereco.getNumero());
			} else {
				System.out.format("    Numero: %s\n", endereco.getNumero());
			}
			if (marcado == 2) {
				if (opcao.equals("f"))
					endereco.setRua(valorString);
				System.out.format("  * Rua: %s\n", endereco.getRua());
			} else {
				System.out.format("    Rua: %s\n", endereco.getRua());
			}
			if (marcado == 3) {
				if (opcao.equals("f"))
					endereco.setBairro(valorString);
				System.out.format("  * Bairro: %s\n", endereco.getBairro());
			} else {
				System.out.format("    Bairro: %s\n", endereco.getBairro());
			}
			if (marcado == 4) {
				System.out.print("  * Sair\n");
			} else {
				System.out.print("    Sair\n");
			}

			opcao = "o";

			opcao = key.next();

			if (opcao.equals("w") && marcado > 0) {
				marcado--;
			} else if (opcao.equals("s") && marcado < 4) {
				marcado++;
			} else if (opcao.equals("f") && marcado != 4) {
				valorString = key.next();
			}

		}
		// key.close();
		return endereco;
	}

	public static Funcionario menuFuncionario(Funcionario funcionario) {
		Scanner key = new Scanner(System.in);
		int marcado = 0;

		double salario = 0;

		String resposta = "";
		String operacao = "o";
		char simbolo = ' ';

		while (operacao.equals("f") == false || marcado != 8) {
			System.out.println(
					"Use as teclas 'w' e 's' para navegar dentro do menu\n use a tecla 'f' para escolher\n\n\tMenu de edição de Funcionário.");

			if (marcado == 0) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setNome(resposta);
			}
			System.out.format("  %c Nome: %s\n", simbolo, funcionario.getNome());
			simbolo = ' ';

			if (marcado == 1) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setCpf(resposta);
			}
			System.out.format("  %c CPF: %s\n", simbolo, funcionario.getCpf());
			simbolo = ' ';

			if (marcado == 2) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setFuncao(resposta);
			}
			System.out.format("  %c Função: %s\n", simbolo, funcionario.getFuncao());
			simbolo = ' ';

			if (marcado == 3) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setTelefone(resposta);
			}
			System.out.format("  %c Telefone: %s\n", simbolo, funcionario.getTelefone());
			simbolo = ' ';

			if (marcado == 4) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setSalario(salario);
			}
			System.out.format("  %c Salario: %s\n", simbolo, funcionario.getSalario());
			simbolo = ' ';

			if (marcado == 5) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setEndereco(menuEndereco(funcionario.getEndereco()));
			}
			System.out.format("      %c Endereço\n", simbolo);
			simbolo = ' ';

			if (marcado == 6) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setEscalamento(menuEscalamento(funcionario.getEscalamento()));
			}
			System.out.format("      %c Escalamento\n", simbolo);
			simbolo = ' ';

			if (marcado == 7) {
				simbolo = '*';
				if (operacao.equals("f"))
					funcionario.setLogin(menuLogin(funcionario.getLogin()));
			}
			System.out.format("      %c Login\n", simbolo);
			simbolo = ' ';

			if (marcado == 8) {
				simbolo = '*';
			}
			System.out.format("  %c Sair\n", simbolo);
			simbolo = ' ';

			operacao = key.next();
			if (operacao.equals("w") && marcado > 0)
				marcado--;
			else if (operacao.equals("s") && marcado < 8)
				marcado++;
			else if (operacao.equals("f") && marcado < 4) {
				resposta = key.next();
			} else if (operacao.equals("f") && marcado == 4) {
				salario = key.nextDouble();
			}
			// System.out.println(operacao.equals("f"));
			// System.out.println(marcado != 8);
		}

		return funcionario;
	}

	public static Evento menuEvento(Evento evento) {
		Scanner key = new Scanner(System.in);

		int marcado = 0;

		String operacao = "o";
		String valorSTR = "";
		double valorDouble = 0;
		int[] dia = new int[5];

		String simbolo = " ";

		while (operacao.equals("f") == false || marcado != 6) {
			System.out.format(
					"Use as teclas 'w' e 's' para navegar dentro do menu\n" + " use a tecla 'f' para escolher\n\n\"" // sera
																														// que
																														// vai
																														// bugar?
							+ "Menu de edição do evento de código %s",
					evento.getCodigo());

			if (marcado == 0) {
				simbolo = "*";
				if (operacao.equals("f"))
					evento.setEvento(valorSTR);
			}
			System.out.format("  %s Evento: %s\n", simbolo, evento.getEvento());
			simbolo = " ";

			if (marcado == 1) {
				simbolo = "*";
				if (operacao.equals("f"))
					evento.setDecoracao(valorSTR);
			}
			System.out.format("  %s Decoracao: %s\n", simbolo, evento.getDecoracao());
			simbolo = " ";

			if (marcado == 2) {
				simbolo = "*";
				if (operacao.equals("f"))
					evento.setAssinaturaCPF(valorSTR);
			}
			System.out.format("  %s Assinatura: %s\n", simbolo, evento.getAssinaturaCPF());
			simbolo = " ";

			if (marcado == 3) {
				simbolo = "*";
				if (operacao.equals("f"))
					evento.setCusto(valorDouble);
			}
			System.out.format("  %s Custo: %d\n", simbolo, evento.getCusto());
			simbolo = " ";

			if (marcado == 4) {
				simbolo = "*";
				if (operacao.equals("f"))
					evento.setReceita(valorDouble);
			}
			System.out.format("  %s Receita: %d\n", simbolo, evento.getReceita());
			simbolo = " ";

			if (marcado == 5) {
				simbolo = "*";
				if (operacao.equals("f")) {
					evento.setDia(LocalDate.of(dia[0], dia[1], dia[2]));
				}
			}
			System.out.format("  %s Data: %d\n", simbolo, evento.getDia().toString());
			simbolo = " ";

			if (marcado == 6) {
				simbolo = "*";
			}
			System.out.format("  %s Sair", simbolo);
			simbolo = " ";

			operacao = key.next();
			if (operacao.equals("w") && marcado > 0)
				marcado--;
			else if (operacao.equals("s") && marcado < 8)
				marcado++;
			else if (operacao.equals("f") && marcado < 3) {
				valorSTR = key.next();
			} else if (operacao.equals("f") && marcado < 5) {
				valorDouble = key.nextDouble();
			} else if (operacao.equals("f") && marcado == 5) {
				System.out.println("Digite o Ano");
				dia[0] = key.nextInt();
				System.out.println("Digite o Mês");
				dia[1] = key.nextInt();
				System.out.println("Digite o Dia");
				dia[2] = key.nextInt();
			}

		}

		return evento;
	}
/*
	public static void main(String[] args) {

		// Login l = new Login();

		String[] menuP = { "Ingresso", "Bar", "Estoque", "Calendario", "Funcion�rio", "Financeiro", "Sair" };

		int v = -1;

		// v = menu("Menu Principal", menuP);

		// System.out.println(l.getUsuario());
		Scanner key = new Scanner(System.in);

		Funcionario first = new Funcionario();
		Funcionario salet = menuFuncionario(first);

		// first.setLogin(new Login("123", "aff"));

		try {
			RepositorioFuncionario.getInstance().cadastrarFuncionario(salet, "1", "1");
		} catch (LoginInvalido | UsuarioSemPrivilegio | ObjetoInvalido | FuncionarioJaExiste e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		int acessLevel = -1;
		String login = "";
		String senha = "";
		while (acessLevel == -1) {
			System.out.print("Login: ");
			login = key.next();
			System.out.print("Senha: ");
			senha = key.next();
			try {
				acessLevel = RepositorioFuncionario.getInstance().acessLevel(login, senha);
			} catch (LoginInvalido | NaoExistemFuncionarios e) {
				// TODO Auto-generated catch block
				System.out.print(e.getMessage());
			}
		}

		GerenciadorCliente GC = new GerenciadorCliente();
		GerenciadorEventos GE = new GerenciadorEventos();
		GerenciadorFuncionario GF = new GerenciadorFuncionario();
		GerenciadorProdutos GP = new GerenciadorProdutos();
		try {
			GC.fazerLogin(login, senha);
			GE.fazerLogin(login, senha);
			GF.fazerLogin(login, senha);
			GP.fazerLogin(login, senha);
		} catch (LoginInvalido | NaoExistemFuncionarios e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}

		Cliente c1 = new Cliente("Fulano", "000", LocalDate.now());
		Cliente c2 = new Cliente("Fulanai", "001", LocalDate.now());
		Cliente c3 = new Cliente("Fulanao", "002", LocalDate.now());

		Evento e1 = new Evento(LocalDate.now(), 1);

		Ingresso i1 = new Ingresso(c1, e1);
		Ingresso i2 = new Ingresso(c2, e1);
		Ingresso i3 = new Ingresso(c3, e1);

		try {
			GC.marcarEntrada(i1);
			GC.marcarEntrada(i2);
			GC.marcarEntrada(i3);
			GE.addEvento(e1);
		} catch (ObjetoInvalido | LoginInvalido | NaoExistemFuncionarios | ClienteNaoExiste | UsuarioSemPrivilegio e) {
			System.out.println(e.getMessage());
		}
		int s = -1;

		String[] menuIngresso = { "Vender", "Marcar Saida", "Ver Clientes", "Sair" };
		String[] menuBar = { "Vender", "Sair" };
		String[] menuEstoque = { "Adicionar", "Retirar", "Consultar", "Sair" };

		while (v != 6) {
			v = menu("Menu Principal", menuP);

			if (v == 0) {
				while (s != 3) {
					s = menu("Ingressos", menuIngresso);
					if (s == 0) {
						// GC.marcarEntrada();
					}
					if (s == 1) {
						try {
							GC.marcarSaida(GC.listarCliente()[menu("Escolha O cliente", GC.nomeCliente())]);
						} catch (ClienteNaoExiste e) {
							// TODO Auto-generated catch block
							System.out.print(e.getMessage());
						}
					}
					if (s == 2) {
						menu("Clientes", GC.nomeCliente());
					}
				}
			}
			if (v == 1) {
				while (s != 1) {
					s = menu("Bar", menuBar);
				}
			}
			if (v == 2) {
				while (s < -1000) {

				}
			}
			if (v == 3) {
				while (s < -1000) {

				}
			}
			if (v == 4) {
				while (s < -1000) {

				}
			}
			if (v == 5) {
				while (s < -1000) {

				}
			}
		}

		/*
		 * int i = 0; while(i != 0) {
		 * 
		 * }
		 *//*
			 * String[] asdf = {"asdf", "asdf", "asdf"};
			 * 
			 * ArrayList<LocalDateTime> lok = new ArrayList<LocalDateTime>();
			 
		// menu("asdf", asdf);

		// System.out.println(menu("asdf", asdf));
		/*
		 * Funcionario fun = new Funcionario();
		 * 
		 * Endereco end = new Endereco();
		 * 
		 * int i = 0;
		 * 
		 * while(i != 5) { System.out.println("**************************"); fun
		 * = menuFuncionario(fun); i++; }
		 
		/*
		 * while (i != 5) { lok = menuEscalamento(lok); i++; }
		 * 
		 * i = 0; while (i != 5) { System.out.println(end.toString()); end =
		 * menuEndereco(end); i++; }
		 */

	//}

}
