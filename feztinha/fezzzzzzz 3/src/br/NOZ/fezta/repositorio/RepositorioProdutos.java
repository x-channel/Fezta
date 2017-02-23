package br.NOZ.fezta.repositorio;

import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.dados.IRepositorioProdutos;
import br.NOZ.fezta.exceptions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
import Repositorio.Beans.Evento;
import Repositorio.Beans.Produto;
*/
public class RepositorioProdutos implements IRepositorioProdutos, Serializable{

	private static RepositorioProdutos instance;
	private RepositorioFuncionario repFuncionario;

	private ArrayList<Produto> repprod = new ArrayList<Produto>();
	// private int qtdProdutos = 0;

	private RepositorioProdutos() /*throws IOException */ {
		this.repprod = new ArrayList();
		repFuncionario  = RepositorioFuncionario.getInstance();
	}
	
	public ArrayList<Produto> getProdutos()
	{
		return repprod;
	}

//mudei aqui*************************
	public static RepositorioProdutos getInstance() /*throws IOException*/ {

		
		if(instance==null)
			instance = Ler();
			//instance = new RepositorioProdutos();}
	//	System.out.println(instance.getQTDProdutos());
		return instance;
		
	}
	
	
	public static RepositorioProdutos Ler() 
	{
		
		FileInputStream entrada = null;
		ObjectInputStream obj = null;
		
		try{
			entrada = new FileInputStream("produtos.arq");
			 obj = new ObjectInputStream(entrada);
			
			return (RepositorioProdutos) obj.readObject();
			
		}
		catch(Exception e)
		{
			return new RepositorioProdutos();
		}
	}
	
	public void Escrever(RepositorioProdutos x) {
		
		FileOutputStream saida = null;
		ObjectOutputStream obj = null;
		try {
			 saida = new FileOutputStream(new File("produtos.arq"));
			
				obj = new ObjectOutputStream(saida);
		
				obj.writeObject(this.instance);
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
		
////********************************************
	public void cadastrarProduto(Produto item, String login, String senha)
			throws ProdutoJaExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		/*
		 * if(item!=null ){ repprod.add(item); qtdProdutos += 1; //return true;
		 * } //observe que o repositório não tem controle nenhum sobre a GUI.
		 * então não coloquem prinf dentro desses métodos else{
		 * //System.out.println("Nao ha como cadastrar o produto."); //return
		 * false; }
		 */
		int r = repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			if (item == null || !(item instanceof Produto)) {
				throw new ObjetoInvalido("Produto");
			}
			try {
				procurarProduto(item);
				throw new ProdutoJaExiste(item.getCodigo());
			} catch (ProdutoNaoExiste e) {
				repprod.add(item);
				//try {
					Escrever(this.instance);
				//} catch (IOException x) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
				// qtdProdutos += 1;]
				
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}
	/*
	 * public Produto procurarProduto(int i) throws ProdutoNaoExiste { if (i < 0
	 * || i > repprod.size()) { new ProdutoNaoExiste("*"); } return
	 * repprod.get(i); }
	 */

	public Produto procurarProduto(String code) throws ProdutoNaoExiste {
		Produto auxiliar = null;
		if (code != null) {
			if (this.repprod.size() > 0) {
				for (int i = 0; i < repprod.size(); i++) {
					if (code.equals(this.repprod.get(i).getCodigo())) {
						auxiliar = this.repprod.get(i);
						
					}
				}
			}
		} else {
			throw new ProdutoNaoExiste("*");
		}
		if (auxiliar == null) {
			throw new ProdutoNaoExiste(code);
		}

		return auxiliar;
	}

	public Produto procurarProduto(Produto produto) throws ProdutoNaoExiste {
		Produto auxiliar = null;
		if (produto != null) {
			auxiliar = procurarProduto(produto.getCodigo());
		} else {
			throw new ProdutoNaoExiste("*");
		}
		return auxiliar;
	}

	public void removerProduto(Produto item, String login, String senha)
			throws ProdutoNaoExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean removido = false;
		/*
		 * if(item!= null){ repprod.remove(item); removido = true; }
		 */
		// return removido;
		int r = this.repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			if (item instanceof Produto) {
				Produto prod = procurarProduto(item);
				repprod.remove(prod);
				//try {
					Escrever(this.instance);
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
				// qtdProdutos -= 1;
			} else {
				throw new ObjetoInvalido("Produto");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}

	}

	public void atualizarProduto(Produto velho, Produto novo, String login, String senha)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		/*
		 * int i; for(i = 0; i <repprod.size(); i++) {
		 * if(velho.equals(repprod.get(i))) { repprod.remove(velho);
		 * repprod.add(novo); //return true; } } //return false;
		 */
		int r = this.repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			if (!(velho instanceof Produto) || velho == null || novo == null || !(novo instanceof Produto)) {
				throw new ObjetoInvalido("Produto");
			} else {
				Produto prod = procurarProduto(velho);
				repprod.remove(prod);
				repprod.add(novo);
				//try {
					Escrever(this.instance);
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public void retirarItem(String code, int quantidade, String login, String senha)
			throws ProdutoNaoExiste, ProdutoIndisponivel, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		int r = this.repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			Produto auxiliar = procurarProduto(code);

			if (auxiliar.getQuantidade() < quantidade) {
				throw new ProdutoIndisponivel(auxiliar.getCodigo());
			}

			auxiliar.setQuantidade(auxiliar.getQuantidade() - quantidade);
			//try {
				Escrever(this.instance);
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
		} else {
			throw new UsuarioSemPrivilegio();
		}

	}

	public void retirarItem(String code, String login, String senha)
			throws ProdutoNaoExiste, ProdutoIndisponivel, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean retirado = false;
		int r = this.repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			Produto auxiliar = procurarProduto(code);

			if (auxiliar.getQuantidade() <= 0) {
				throw new ProdutoIndisponivel(auxiliar.getCodigo());
			}

			auxiliar.setQuantidade(auxiliar.getQuantidade() - 1);
			//try {
				Escrever(this.instance);
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			// retirado = true;

			// return retirado;
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public int getQTDProdutos() {
		return repprod.size();
	}

	public Produto[] listarProdutos() {
		return listarProdutos("");
	}

	public Produto[] listarProdutos(String cod) {
		ArrayList<Produto> f = new ArrayList<Produto>();
		boolean b = false;
		Produto[] out = null;

		char[] c = cod.toCharArray();

		for (int i = 0; i < repprod.size(); i++) {
			b = true;
			if (cod.equals("")) {
				if (i == 0) {
					out = new Produto[this.repprod.size()];
				}
				out[i] = this.repprod.get(i);

				// f.add(repfun.get(i));
				// s += repfun.get(i).toString();
				// s += "\n";
			} else {
				char[] c2 = repprod.get(i).getCodigo().toCharArray();
				for (int n = 0; n < cod.length(); n++) {
					if (c[n] != c2[n]) {
						b = false;
					}
				}
				if (b == true) {
					f.add(repprod.get(i));
					// s += repfun.get(i).toString();
					// s += "\n";
				}
			}
		}
		if (out == null) {
			out = new Produto[f.size()];
			for (int n = 0; n < f.size(); n++) {
				out[n] = f.get(n);
			}
		}

		return out;
	}

	public void salvar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void carregar() {
		// TODO Auto-generated method stub

	}

	public void atualizarProduto(String velho, Produto novo, String login, String senha)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		/*
		 * int i; for(i = 0; i <repprod.size(); i++) {
		 * if(velho.equals(repprod.get(i))) { repprod.remove(velho);
		 * repprod.add(novo); //return true; } } //return false;
		 */
		int r = this.repFuncionario.acessLevel(login, senha);
		if (r == 0 || r == 1 || r == 2) {
			if (velho == null || novo == null || !(novo instanceof Produto)) {
				throw new ObjetoInvalido("Produto");
			} else {
				Produto prod = procurarProduto(velho);
				repprod.remove(prod);
				repprod.add(novo);
				//try {
					Escrever(this.instance);
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

}
