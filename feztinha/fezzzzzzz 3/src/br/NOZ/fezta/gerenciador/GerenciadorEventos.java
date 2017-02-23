package br.NOZ.fezta.gerenciador;

import br.NOZ.fezta.repositorio.*;

import java.time.LocalDate;

import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.exceptions.EventoNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.negocio.IEvento;

/*import Repositorio.Estoque;
import Repositorio.Beans.*;
import java.time.LocalDate;
*/
public class GerenciadorEventos implements IEvento {

	private RepositorioEventos rep = RepositorioEventos.getInstance();

	private String login = null;
	private String senha = null;
	/*
	public void setLogin(String login)
	{
		this.login = login;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}*/
	public GerenciadorEventos() {

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
	
	
	/*
	 * public void addEvento(LocalDate day, double receit, double cost, String
	 * event1, String decoration, String assCPF, String code){ //boolean existe
	 * = false; Evento auxiliar = null; try { auxiliar =
	 * rep.procurarEvento(code); } catch(EventoNaoExiste e) { /*if(auxiliar !=
	 * null){ existe = true; }
	 * 
	 * //if (existe==false){ auxiliar = new Evento(); auxiliar.setDia(day);
	 * auxiliar.setReceita(receit); auxiliar.setCusto(cost);
	 * auxiliar.setEvento(event1); auxiliar.setDecoracao(decoration);
	 * auxiliar.setAssinaturaCPF(assCPF); auxiliar.setCodigo(code); try {
	 * this.rep.addEvento(auxiliar); } catch (ObjetoInvalido e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } //} //return existe; }
	 * }
	 */

	public void addEvento(/* String code, */ Evento a) throws ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		// boolean existe = false;
		// Evento auxiliar = rep.procurarEvento(code);
		/*
		 * if(auxiliar != null){ existe = true; } if (existe==false){
		 * 
		 * auxiliar = a;
		 * 
		 * }
		 */
		// return existe;
		rep.addEvento(a, this.login, this.senha);
	}

	public void removerEvento(String codigo) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		// boolean removido =false;
		Evento auxiliar = null;

		if (codigo == null) {
			new EventoNaoExiste("*");
		}

		auxiliar = this.rep.procurarEvento(codigo);
		// if(auxiliar!=null){
		this.rep.removerEvento(auxiliar, this.login, this.senha);
		// removido = true;
		// }
		// return removido;
	}

	public void atualizarEvento(Evento velho, Evento novo) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		RepositorioEventos.getInstance().atualizarEvento(velho, novo, this.login, this.senha);
	}

	public void atualizarEvento(LocalDate day, double receit, double cost, String event1, String decoration,
			String assCPF, String code, String id) throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		// boolean atualizado = false;
		Evento auxiliar = new Evento();
		auxiliar.setDia(day);
		auxiliar.setReceita(receit);
		auxiliar.setCusto(cost);
		auxiliar.setEvento(event1);
		auxiliar.setDecoracao(decoration);
		auxiliar.setAssinaturaCPF(assCPF);
		auxiliar.setCodigo(code);

		this.rep.atualizarEvento(this.rep.procurarEvento(id), auxiliar, this.login, this.senha);
		// atualizado = true;

		// return atualizado;
	}
	
	public String[] listarEventosCod()
	{
		return listarEventosCod("");
	}
	
	public String[] listarEventosCod(String cod)
	{
		//Funcionario[] f = RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		Evento[] f = rep.listarEventos(cod);
		String[] n = new String[f.length];
		for(int a = 0; a < f.length; a++)
		{
			n[a] = f[a].getCodigo();
		}
		return n;
	}
	
	public Evento[] listarEventos()
	{
		return rep.listarEventos();
	}
	
	public Evento[] listarEventos(String cod)
	{
		return rep.listarEventos(cod);
	}

}
