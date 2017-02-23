package br.NOZ.fezta.repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import Repositorio.Beans.*;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.beans.Login;
import br.NOZ.fezta.dados.IRepositorioFuncionario;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.FuncionarioNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	private static RepositorioFuncionario instance;	

	private ArrayList<Funcionario> repfun;
	
	
	public ArrayList<Funcionario> getAL()
	{
		return repfun;
	}
	
///mudei aqui*********************************
	
	
	 public static RepositorioFuncionario getInstance() {
		if (instance == null) {
			//System.out.println("vish");
		
				instance = Ler();
			
		//	instance = new RepositorioFuncionario();
		}
		return instance;
	}
	
	public static RepositorioFuncionario Ler() 
	{
		
		FileInputStream entrada = null;
			ObjectInputStream obj = null;
		
		try{
			entrada = new FileInputStream("funcionarios.arq");
			obj = new ObjectInputStream(entrada);
			Object x =  obj.readObject();
			return (RepositorioFuncionario) x;
		}
		catch(Exception e)
		{
			return new RepositorioFuncionario();
		}
	}
	
	public void Escrever(RepositorioFuncionario x) {
		
		
		try {
			 	
			FileOutputStream saida = new FileOutputStream(new File("funcionarios.arq"));
			ObjectOutputStream obj = new ObjectOutputStream(saida);
				 
				obj.writeObject(this.instance);
			//	obj.close();
			
			
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		 
	}
///**************************************

	public int acessLevel(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios {
		int u;
		int r = -1;
		// Login l = new Login(login, senha);
		// System.out.println(repfun.isEmpty());
		if (repfun.isEmpty()) {
			//System.out.println("1");
			throw new NaoExistemFuncionarios();	
			// return 0;
		}
		u = Login.checaTodos(login, senha, repfun);
		if (u == -1) {
			//System.out.println("Erro!");
			throw new LoginInvalido();
		}

		// System.out.println("r");

		r = repfun.get(u).getLogin().getAcessLevel();

		// System.out.println(u);
		return r;
	}

	private RepositorioFuncionario() {
		if(this.repfun == null){
			this.repfun = new ArrayList<Funcionario>();// To change body of
													// generated methods, choose
													// Tools | Templates.
		}
	}

	/*
	 * private ArrayList<Funcionario> getRepfun() { return this.repfun; }
	 */

	public void cadastrarFuncionario(Funcionario funcionarioM, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste {
		int r = -1;
		try {
			r = acessLevel(login, senha);
		} catch (NaoExistemFuncionarios e) {
			// TODO Auto-generated catch block
			 //e.printStackTrace();
			if (funcionarioM != null) {
				Login l = funcionarioM.getLogin();
				funcionarioM.getLogin().pLS();
				l.setAcessLevel(0);
				funcionarioM.setLogin(l);
				repfun.add(funcionarioM);
				Escrever(this.instance);
				//r = 0;
			} else {
				throw new ObjetoInvalido("Funcionario");
			}
		}
		if (r == 0) {
			if (funcionarioM == null) {
				throw new ObjetoInvalido("Funcionario");
				// repfun.add(funcionarioM);
				// return true;
			} else {
				try {
					// Funcionario f =
					this.procurarFuncionario(funcionarioM.getCpf());
					throw new FuncionarioJaExiste(funcionarioM.getCpf());
				} catch (FuncionarioNaoExiste e) {
					repfun.add(funcionarioM);
					Escrever(this.instance);
				}
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public Funcionario procurarFuncionario(String code) throws FuncionarioNaoExiste {
		Funcionario auxiliar = null;
		if (code != null) {
			if (this.repfun.size() > 0) {
				for (int i = 0; i < repfun.size(); i++) {
					if (code.equalsIgnoreCase(this.repfun.get(i).getCpf())) {
						auxiliar = this.repfun.get(i);
						return auxiliar;
					}
				}
			}
		}

		throw new FuncionarioNaoExiste(code);
		// return null;

		// return auxiliar;
	}
	
	public Funcionario procurarFuncionarioPorLogin(String code) throws FuncionarioNaoExiste {
		Funcionario auxiliar = null;
		if (code != null) {
			if (this.repfun.size() > 0) {
				for (int i = 0; i < repfun.size(); i++) {
					if (code.equalsIgnoreCase(this.repfun.get(i).getLogin().getUser())) {
						auxiliar = this.repfun.get(i);
						return auxiliar;
					}
				}
			}
		}

		throw new FuncionarioNaoExiste(code);
		// return null;

		// return auxiliar;
	}

	public void removerFuncionario(String code, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste {
		Funcionario funcionarioM = null;
		int r = acessLevel(login, senha);
		if (repfun.isEmpty() == true) {
			throw new NaoExistemFuncionarios();
		}

		if (r == 0) {
			funcionarioM = this.procurarFuncionario(code);
			repfun.remove(funcionarioM);
			
				Escrever(this.instance);
			
			
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public void removerFuncionario(Funcionario funcionarioM, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste {
		if (funcionarioM != null) {
			if (funcionarioM.equals(this.procurarFuncionario(funcionarioM.getCpf()))) {
				this.removerFuncionario(funcionarioM.getCpf(), login, senha);
				
					Escrever(this.instance);
				
			} else {
				throw new FuncionarioNaoExiste(funcionarioM.getCpf());
			}
		} else {
			throw new FuncionarioNaoExiste("*");
		}
	}

	private int procurarIndice(String code) throws FuncionarioNaoExiste {
		// int r = -1;
		for (int i = 0; i < repfun.size(); i++) {
			if (code.equalsIgnoreCase(repfun.get(i).getCpf())) {
				return i;
			}
		}
		throw new FuncionarioNaoExiste(code);
		// return -1;
	}

	public void atualizarFuncionario(String funcionarioCode, Funcionario atualizado, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, ObjetoInvalido, FuncionarioNaoExiste {
		int r = acessLevel(login, senha);
		if (r == 0) {
			if (atualizado != null) {
				// Funcionario f = this.procurarFuncionario(funcionarioCode);
				int i = this.procurarIndice(funcionarioCode);
				repfun.set(i, atualizado);
			
					Escrever(this.instance);
				
			} else {
				throw new ObjetoInvalido("Funcionario");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public Funcionario[] listarFuncionarios() {
		return listarFuncionarios("");
	}

	public Funcionario[] listarFuncionarios(String cod) {
		// String s;
		ArrayList<Funcionario> f = new ArrayList<Funcionario>();
		boolean b = false;
		Funcionario[] out = null;

		char[] c = cod.toCharArray();

		for (int i = 0; i < repfun.size(); i++) {
			b = true;
			if (cod.equals("")) {
				if (i == 0) {
					out = new Funcionario[this.repfun.size()];
				}
				out[i] = this.repfun.get(i);

				// f.add(repfun.get(i));
				// s += repfun.get(i).toString();
				// s += "\n";
			} else {
				char[] c2 = repfun.get(i).getCpf().toCharArray();
				for (int n = 0; n < cod.length(); n++) {
					if (c[n] != c2[n]) {
						b = false;
					}
				}
				if (b == true) {
					f.add(repfun.get(i));
					// s += repfun.get(i).toString();
					// s += "\n";
				}
			}
		}
		if (out == null) {
			out = new Funcionario[f.size()];
			for (int n = 0; n < f.size(); n++) {
				out[n] = f.get(n);
			}
		}

		return out;
	}
	/*
	 * public ArrayList<funcionario> getRepfun() { return this.repfun; }
	 */

	@Override
	public void salvar() {
		//Ler();
		// TODO Auto-generated method stub

	}

	@Override
	public void carregar() {
		//Escrever()
		// TODO Auto-generated method stub

	}

}
