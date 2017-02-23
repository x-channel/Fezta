package br.NOZ.fezta.repositorio;

import java.time.LocalDateTime;
import java.io.*;
import java.util.ArrayList;
//import java.util.ArrayList.*;
//import Repositorio.Beans.*;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.dados.IRepositorioIngresso;
import br.NOZ.fezta.exceptions.ClienteJaEntrou;
import br.NOZ.fezta.exceptions.ClienteNaoEntrouNaFesta;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public class RepositorioIngresso implements IRepositorioIngresso, Serializable {

	private static RepositorioIngresso instance;
	private RepositorioFuncionario repFuncionarios = RepositorioFuncionario.getInstance();

	private ArrayList<Ingresso> lista;
	private Integer codigos = 0;

	private RepositorioIngresso() /* throws IOException */ {
		this.lista = new ArrayList<Ingresso>();
		// repFuncionarios = RepositorioFuncionario.getInstance();
	}

	// mudei aqui**************************************************
	public static RepositorioIngresso getInstance()/* throws IOException */ {
		if (instance == null) {
			 instance = Ler();
			//instance = new RepositorioIngresso();
		}
		return instance;
	}

	
	public static RepositorioIngresso Ler() 
	{
		
		FileInputStream entrada = null;
		ObjectInputStream obj = null;
		try{
			 entrada = new FileInputStream("ingressos.arq");
			 obj = new ObjectInputStream(entrada);
			return (RepositorioIngresso) obj.readObject();
		}
		catch(Exception e)
		{
			return new RepositorioIngresso();
		}
	}
	
	public void Escrever(RepositorioIngresso x) {
		
		FileOutputStream saida = null;
		ObjectOutputStream obj = null;
		try {
			 saida = new FileOutputStream(new File("ingressos.arq"));
			
				obj = new ObjectOutputStream(saida);
		
			
		
				obj.writeObject(this.instance);
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}	

	////////////////////////////////////////////////////
	public void cadastrarIngresso(Ingresso ingresso, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, ClienteNaoExiste, UsuarioSemPrivilegio {

		int a = 4;
		// System.out.println(repFuncionarios.getAL().get(0).getLogin().getAcessLevel());
		System.out.println(repFuncionarios == null);
		a = repFuncionarios.acessLevel(login, senha);

		if (a == 0 || a == 1 || a == 3 || a == 2) {
			// System.out.println("até quase");
			if (ingresso != null) {
				// System.out.println("até aquis");
				// ingresso.setCodigo(codigos.toString());
				// codigos++;
				lista.add(ingresso);
				// try {
				Escrever(this.instance);
				// } catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			} else {
				throw new ClienteNaoExiste("*");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
		/*
		 * ingresso.setCodigo(this.codigos.toString()); lista.add(ingresso);
		 * this.codigos++;
		 */
	}

	public Ingresso procurarIngresso(String cod) throws ClienteNaoExiste {
		Ingresso auxiliar = null;
		boolean b = false;
		if (cod != null) {
			if (this.lista.size() > 0) {
				for (int i = 0; i < lista.size(); i++) {
					if (cod.equals(this.lista.get(i).getCodigo())) {
						auxiliar = this.lista.get(i);
						b = true;
					}
				}
			}
		} else {
			throw new ClienteNaoExiste("*");
		}
		if (b == false) {
			throw new ClienteNaoExiste(cod);

		}
		return auxiliar;
	}

	public void removerIngresso(String cod, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio, ClienteNaoExiste {
		int a = repFuncionarios.acessLevel(login, senha);
		boolean b = false;
		if (a == 0 || a == 1 || a == 3 || a == 2) {
			if (cod != null && cod.equals("") == false) {
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getCodigo().equals(cod)) { // vocÃª nÃ£o pode
													// comparar duas
													// strings
													// com ==, vocÃª deve
													// usar o equals
						
						lista.remove(i);
						// try {
						Escrever(this.instance);
						// } catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						b = true;
						//break;
					}
				}
			} else {
				throw new ClienteNaoExiste("*");
			}
			if (b == false) {
				throw new ClienteNaoExiste(cod);
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public void atualizarIngresso(Ingresso ingresso, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio, ClienteNaoExiste {
		int a = repFuncionarios.acessLevel(login, senha);
		boolean b = false;
		if (a == 0 || a == 1 || a == 3) {
			if (ingresso != null) {
				for (Ingresso ingresso1 : lista) {
					if (ingresso1.getCodigo().equals(ingresso.getCodigo())) {
						lista.remove(ingresso1);
						lista.add(ingresso);

						// try {
						Escrever(this.instance);
						// } catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						b = true;
					}
				}
			} else {
				throw new ClienteNaoExiste("*");
			}
			if (b == false) {
				throw new ClienteNaoExiste(ingresso.getCodigo());
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public void marcarEntrada(String cod, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, ClienteJaEntrou, ClienteNaoExiste, UsuarioSemPrivilegio {
		int a = repFuncionarios.acessLevel(login, senha);
		boolean b = false;
		// boolean c = false;
		if (a == 0 || a == 1 || a == 3 || a == 2) {
			if (cod != null && cod.equals("")) {
				for (int i = 0; i < this.lista.size(); i++) {
					if (cod.equals(lista.get(i).getCodigo())) {
						if (lista.get(i).getEntrada() == null) {
							lista.get(i).setEntrada(LocalDateTime.now());
							// try {
							Escrever(this.instance);
							// } catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							// }
							b = true;
						} else {
							throw new ClienteJaEntrou(cod);
						}
					}
				}
				if (b == false) {
					throw new ClienteNaoExiste(cod);
				}
			} else {
				throw new ClienteNaoExiste("*");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}

	}

	public void marcarSaida(String cod, String login, String senha) throws LoginInvalido, NaoExistemFuncionarios,
			UsuarioSemPrivilegio, ClienteNaoExiste, ClienteNaoEntrouNaFesta {
		int a = repFuncionarios.acessLevel(login, senha);
		boolean b = false;
		if (a == 0 || a == 1 || a == 3 || a == 2) {
			if (cod != null && cod.equals("")) {
				for (int i = 0; i < this.lista.size(); i++) {
					if (lista.get(i).getCodigo().equals(cod)) {
						if (lista.get(i) != null) {
							lista.get(i).setSaida(LocalDateTime.now());
							// try {
							Escrever(this.instance);
							// } catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							// }
							b = true;
						} else {
							throw new ClienteNaoEntrouNaFesta(cod);
						}
					}
				}
				if (b == false) {
					throw new ClienteNaoExiste(cod);
				}
			} else {
				throw new ClienteNaoExiste("*");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}

	}

	public Ingresso[] listarIngressos() {
		return listarIngressos("");
	}

	public Ingresso[] listarIngressos(String cod) {
		// String s;
		ArrayList<Ingresso> f = new ArrayList<Ingresso>();
		boolean b = false;
		Ingresso[] out = null;

		char[] c = cod.toCharArray();

		for (int i = 0; i < lista.size(); i++) {
			b = true;
			if (cod.equals("")) {
				if (i == 0) {
					out = new Ingresso[this.lista.size()];
				}
				out[i] = this.lista.get(i);

				// f.add(repfun.get(i));
				// s += repfun.get(i).toString();
				// s += "\n";
			} else {
				char[] c2 = lista.get(i).getCodigo().toCharArray();
				for (int n = 0; n < cod.length(); n++) {
					if (c[n] != c2[n]) {
						b = false;
					}
				}
				if (b == true) {
					f.add(lista.get(i));
					// s += repfun.get(i).toString();
					// s += "\n";
				}
			}
		}
		if (out == null) {
			out = new Ingresso[f.size()];
			for (int n = 0; n < f.size(); n++) {
				out[n] = f.get(n);
			}
		}

		return out;
	}
	/*
	 * public ArrayList<Ingresso> getLista() { return this.lista; }
	 */

	@Override
	public void salvar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void carregar() {
		// TODO Auto-generated method stub

	}

}
