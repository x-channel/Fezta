package br.NOZ.fezta.negocio;

import java.time.LocalDateTime;

import br.NOZ.fezta.beans.Endereco;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.FuncionarioNaoExiste;
import br.NOZ.fezta.exceptions.HorarioInexistente;
import br.NOZ.fezta.exceptions.HorarioJaEscalado;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;

public interface IFuncionario {
	
	
	void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios;
	
	void logOff();

	void admitir(String nome1, String funcao1, String cpf1, 
			double salario1, String telefone1, String CEP1, String numero1, 
			String bairro1, String rua1, String usuario1, String senha1) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste;
	
	void admitir(Funcionario a) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste;
	
	void editarFuncionario(Funcionario funcio) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste, NaoExistemFuncionarios;
        
    void editarFuncionario(String cpf, Funcionario funcio) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste, NaoExistemFuncionarios;
       
	void demitir(String CPF) throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste;
	
	void escalarHorario(String cpf, LocalDateTime inicio, LocalDateTime fim) throws FuncionarioNaoExiste, HorarioJaEscalado;
	
	void escalarHorario(Funcionario empregado, LocalDateTime inicio, LocalDateTime fim) throws HorarioJaEscalado;
	
	void editarHorario(Funcionario empregado, LocalDateTime edit, LocalDateTime inicio, LocalDateTime fim) throws HorarioInexistente;
	
	String[] listarNomeDosFuncionarios();
	
	String[] listarNomeDosFuncionarios(String cod);
	
	String[] listarCPFdosFuncionarios();
	
	String[] listarCPFdosFuncionarios(String cod);
	
	Funcionario[] listarFuncionarios();
	
	Funcionario[] listarFuncionarios(String cod);
}
