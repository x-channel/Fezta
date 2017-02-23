package br.NOZ.fezta.dados;

import br.NOZ.fezta.exceptions.EventoNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.repositorio.RepositorioEventos;
import br.NOZ.fezta.beans.*;

public interface IRepositorioEventos {
	
	void addEvento(Evento evento1, String login, String senha)
			throws ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio;
	
	Evento procurarEvento(String code) throws EventoNaoExiste;
	
	void removerEvento(Evento este, String login, String senha) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido;
	
	void atualizarEvento(Evento velho, Evento novo, String login, String senha) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido;
	
	void setEstabelecimento(String estabelecimento, String login, String senha) throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio;
	
	String getEstabelecimento();
	
	Endereco getEndereco();
	
	Evento[] listarEventos();
	
	void salvar();
	
	void carregar();
}
