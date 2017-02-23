package br.NOZ.fezta.gerenciador;

import br.NOZ.fezta.repositorio.*;

import java.time.LocalDateTime;
/*
import Repositorio.RepositorioIngresso;
import Repositorio.Beans.Ingresso;
import Repositorio.Beans.Produto;*/
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.negocio.ICliente;

public class GerenciadorCliente implements ICliente{
	
	private String login = null;
	private String senha = null;
	
	private RepositorioIngresso repositorio = RepositorioIngresso.getInstance();
	/*
	public void setLogin(String login)
	{
		this.login = login;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}*/
	
	public GerenciadorCliente() {

	}
	
	public void fazerLogin(String login, String senha) throws LoginInvalido, NaoExistemFuncionarios
	{
		if(RepositorioFuncionario.getInstance().acessLevel(login, senha) >= 0)
		{
			this.login = login;
			this.senha = senha;
		}
	}
	
	public void logOff()
	{
		this.login = null;
		this.senha = null;
	}


	public void addConsumo(String cod, Produto consumo, int qtd) throws ClienteNaoExiste {
		Ingresso aux = null;
		//boolean baux = false;
		aux = RepositorioIngresso.getInstance().procurarIngresso(cod);
		if (aux != null) {
			aux.getCliente().addConsumo(consumo, qtd);
			//baux = true;
			// aux.getCliente().addConsumo(cod,consumo, qtd);
		}
		//return baux;
	}

	public void marcarEntrada(Ingresso ent) throws LoginInvalido, NaoExistemFuncionarios, ClienteNaoExiste, UsuarioSemPrivilegio {
		ent.setEntrada(LocalDateTime.now());
		//boolean aux = false;
		if (ent.getCodigo() == null) {
			RepositorioIngresso.getInstance().cadastrarIngresso(ent, this.login, this.senha);
			//aux = true;
		} else {
			if (RepositorioIngresso.getInstance().procurarIngresso(ent.getCodigo()) != null) {
				RepositorioIngresso.getInstance().procurarIngresso(ent.getCodigo()).setEntrada(LocalDateTime.now());
				//aux = true;
			}
		}
		//return aux;
	}

	public void marcarSaida(Ingresso saida) throws ClienteNaoExiste {
		if (RepositorioIngresso.getInstance().procurarIngresso(saida.getCodigo()) != null) {
			RepositorioIngresso.getInstance().procurarIngresso(saida.getCodigo()).setSaida(LocalDateTime.now());
		}
	}
	
	public String[] CPFCliente()
	{
		return CPFCliente("");
	}
	
	public String[] CPFCliente(String cod)
	{
		//Funcionario[] f = RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		Ingresso[] f = repositorio.listarIngressos(cod);
		String[] n = new String[f.length];
		for(int a = 0; a < f.length; a++)
		{
			n[a] = f[a].getCliente().getCpf();
		}
		return n;
	}
	
	public String[] nomeCliente()
	{
		return nomeCliente("");
	}
	
	public String[] nomeCliente(String cod)
	{
		//Funcionario[] f = RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		Ingresso[] f = repositorio.listarIngressos(cod);
		String[] n = new String[f.length];
		for(int a = 0; a < f.length; a++)
		{
			n[a] = f[a].getCliente().getNome();
		}
		return n;
	}
	
	public Ingresso[] listarCliente()
	{
		return repositorio.listarIngressos();
	}
	
	public Ingresso[] listarClientes(String cod)
	{
		return repositorio.listarIngressos(cod);
	}

}
