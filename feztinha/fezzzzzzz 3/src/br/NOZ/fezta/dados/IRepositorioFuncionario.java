package br.NOZ.fezta.dados;

import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.FuncionarioNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;

public interface IRepositorioFuncionario {
	
	int acessLevel(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios;
	
	void cadastrarFuncionario(Funcionario funcionarioM, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste;
	
	Funcionario procurarFuncionario(String code) throws FuncionarioNaoExiste;
	
	void removerFuncionario(String code, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste;
	
	void removerFuncionario(Funcionario funcionarioM, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste;
	
	void atualizarFuncionario(String funcionarioCode, Funcionario atualizado, String login, String senha)
			throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, ObjetoInvalido, FuncionarioNaoExiste;
	
	Funcionario[] listarFuncionarios();
	
	Funcionario[] listarFuncionarios(String cod);
	
	void salvar();
	
	void carregar();

}
