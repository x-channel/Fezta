package br.NOZ.fezta.dados;

import java.util.ArrayList;

import br.NOZ.fezta.beans.Produto;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.ProdutoIndisponivel;
import br.NOZ.fezta.exceptions.ProdutoJaExiste;
import br.NOZ.fezta.exceptions.ProdutoNaoExiste;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public interface IRepositorioProdutos {
	
	void cadastrarProduto(Produto item, String login, String senha)
			throws ProdutoJaExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	Produto procurarProduto(String code) throws ProdutoNaoExiste ;

	Produto procurarProduto(Produto produto) throws ProdutoNaoExiste ;

	void removerProduto(Produto item, String login, String senha)
			throws ProdutoNaoExiste, ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void atualizarProduto(Produto velho, Produto novo, String login, String senha)
			throws ObjetoInvalido, ProdutoNaoExiste, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void retirarItem(String code, int quantidade, String login, String senha)
			throws ProdutoNaoExiste, ProdutoIndisponivel, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void retirarItem(String code, String login, String senha)
			throws ProdutoNaoExiste, ProdutoIndisponivel, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	int getQTDProdutos() ;
	
	Produto[] listarProdutos();
	
	Produto[] listarProdutos(String cod) ;
	
	void salvar();
	
	void carregar();

}
