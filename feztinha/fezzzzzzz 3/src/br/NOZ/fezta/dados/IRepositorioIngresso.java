package br.NOZ.fezta.dados;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.NOZ.fezta.beans.Ingresso;
import br.NOZ.fezta.exceptions.ClienteJaEntrou;
import br.NOZ.fezta.exceptions.ClienteNaoEntrouNaFesta;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public interface IRepositorioIngresso {
	
	void cadastrarIngresso(Ingresso ingresso, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, ClienteNaoExiste, UsuarioSemPrivilegio ;

	Ingresso procurarIngresso(String cod) throws ClienteNaoExiste ;

	void removerIngresso(String cod, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio, ClienteNaoExiste ;

	void atualizarIngresso(Ingresso ingresso, String login, String senha) throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio, ClienteNaoExiste ;

	void marcarEntrada(String cod, String login, String senha) throws LoginInvalido, NaoExistemFuncionarios, ClienteJaEntrou, ClienteNaoExiste, UsuarioSemPrivilegio ;

	void marcarSaida(String cod, String login, String senha) throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio, ClienteNaoExiste, ClienteNaoEntrouNaFesta;

	Ingresso[] listarIngressos() ;

	Ingresso[] listarIngressos(String cod) ;

	void salvar();
	
	void carregar();

}
