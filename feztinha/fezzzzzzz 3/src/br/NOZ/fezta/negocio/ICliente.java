package br.NOZ.fezta.negocio;

import java.time.LocalDateTime;

import br.NOZ.fezta.beans.Ingresso;
import br.NOZ.fezta.beans.Produto;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;
import br.NOZ.fezta.repositorio.RepositorioIngresso;

public interface ICliente {
	
	void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios;
	
	void logOff();


	void addConsumo(String cod, Produto consumo, int qtd) throws ClienteNaoExiste ;

	//void venderIngresso(Ingresso ent) throws LoginInvalido, NaoExistemFuncionarios;
	
	void marcarEntrada(Ingresso ent) throws LoginInvalido, NaoExistemFuncionarios, ClienteNaoExiste, UsuarioSemPrivilegio ;

	void marcarSaida(Ingresso saida) throws ClienteNaoExiste ;
	
	String[] CPFCliente();
	
	String[] CPFCliente(String cod);
	
	String[] nomeCliente();
	
	
	String[] nomeCliente(String cod);
	
	Ingresso[] listarCliente();
	
	Ingresso[] listarClientes(String cod);
}
