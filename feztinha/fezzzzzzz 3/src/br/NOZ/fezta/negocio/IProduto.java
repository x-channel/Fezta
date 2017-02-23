package br.NOZ.fezta.negocio;

import br.NOZ.fezta.beans.Produto;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.ProdutoJaExiste;
import br.NOZ.fezta.exceptions.ProdutoNaoExiste;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public interface IProduto {
	
	void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios;
	
	void logOff();
	
	void addProduto(String name, String code, double price, int quant)
			throws ProdutoJaExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void removerProduto(String codigo)
			throws ProdutoNaoExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;
	

	void atualizarProduto(String name, String code, double price, int quant, String id)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void atualizarProduto(String code, Produto novo)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	String[] listarTudoProdutos() ;

	String[] listarTudoProdutos(String cod) ;

	Produto[] listarProdutos();

	Produto[] listarProdutos(String cod);

}
