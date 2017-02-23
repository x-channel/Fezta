package br.NOZ.fezta.negocio;

import java.time.LocalDate;

import br.NOZ.fezta.beans.Evento;
import br.NOZ.fezta.exceptions.EventoNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.repositorio.RepositorioEventos;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;

public interface IEvento {
	
	void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios;
	
	void logOff();

	void addEvento(/* String code, */ Evento a) throws ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio ;

	void removerEvento(String codigo) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido ;

	void atualizarEvento(Evento velho, Evento novo) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido ;

	void atualizarEvento(LocalDate day, double receit, double cost, String event1, String decoration,
			String assCPF, String code, String id) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido ;
	
	String[] listarEventosCod();
	
	String[] listarEventosCod(String cod);
	
	Evento[] listarEventos();
	
	Evento[] listarEventos(String cod);

}
