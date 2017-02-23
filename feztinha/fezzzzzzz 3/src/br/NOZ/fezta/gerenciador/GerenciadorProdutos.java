package br.NOZ.fezta.gerenciador;

import br.NOZ.fezta.repositorio.*;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.ProdutoJaExiste;
import br.NOZ.fezta.exceptions.ProdutoNaoExiste;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.negocio.IProduto;

public class GerenciadorProdutos implements IProduto{

	private RepositorioProdutos rep = RepositorioProdutos.getInstance();

	private String login = null;
	private String senha = null;
	/*
	 * public void setLogin(String login) { this.login = login; } public void
	 * setSenha(String senha) { this.senha = senha; }
	 */

	public GerenciadorProdutos() {

	}

	public void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios {
		if (RepositorioFuncionario.getInstance().acessLevel(login, senha) >= 0) {
			this.login = login;
			this.senha = senha;
		}
	}

	public void logOff() {
		this.login = null;
		this.senha = null;
	}

	public void addProduto(String name, String code, double price, int quant)
			throws ProdutoJaExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean existe = false;
		Produto auxiliar = null;
		try {
			auxiliar = rep.procurarProduto(code);
		} catch (ProdutoNaoExiste e) {

			/*
			 * if(auxiliar != null){ existe = true; }
			 */

			// if (!existe){
			// mudei a linha
			auxiliar = new Produto();
			auxiliar.setNome(name);
			auxiliar.setCodigo(code);
			auxiliar.setPreco(price);
			auxiliar.setQuantidade(quant);
			this.rep.cadastrarProduto(auxiliar, this.login, this.senha);
			// }

		}
		// return existe;
	}

	public void removerProduto(String codigo)
			throws ProdutoNaoExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean removido =false;
		Produto auxiliar = null;
		auxiliar = this.rep.procurarProduto(codigo);
		if (auxiliar != null) {
			this.rep.removerProduto(auxiliar, this.login, this.senha);
			// removido = true;
		}
		// return removido;
	}

	public void atualizarProduto(String name, String code, double price, int quant, String id)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean atualizado = false;
		Produto auxiliar = new Produto(name, code, price, quant);
		if (auxiliar != null) {
			this.rep.atualizarProduto(this.rep.procurarProduto(id), auxiliar, this.login, this.senha);
			// atualizado = true;
		}
		// return atualizado;
	}

	public void atualizarProduto(String code, Produto novo)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// Produto auxiliar =
		this.rep.atualizarProduto(this.rep.procurarProduto(code), novo, this.login, this.senha);
	}

	public String[] listarTudoProdutos() {
		return listarTudoProdutos("");
	}

	public String[] listarTudoProdutos(String cod) {
		// Funcionario[] f =
		// RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		Produto[] f = rep.listarProdutos(cod);
		String[] n = new String[f.length];
		for (int a = 0; a < f.length; a++) {
			n[a] = "" + f[a].getCodigo() + " " + f[a].getNome() + "    Preço: " + f[a].getPreco();
		}
		return n;
	}

	public Produto[] listarProdutos() {
		return listarProdutos();
	}

	public Produto[] listarProdutos(String cod) {
		return rep.listarProdutos();
	}

}
