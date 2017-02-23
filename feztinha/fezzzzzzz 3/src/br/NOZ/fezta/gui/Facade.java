package br.NOZ.fezta.gui;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sun.javafx.iio.gif.GIFDescriptor;

import br.NOZ.fezta.beans.Cliente;
import br.NOZ.fezta.beans.Endereco;
import br.NOZ.fezta.beans.Evento;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.beans.Ingresso;
import br.NOZ.fezta.beans.Produto;
import br.NOZ.fezta.exceptions.ClienteNaoExiste;
import br.NOZ.fezta.exceptions.EventoNaoExiste;
import br.NOZ.fezta.exceptions.FuncionarioNaoExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.ProdutoJaExiste;
import br.NOZ.fezta.exceptions.ProdutoNaoExiste;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.gerenciador.GerenciadorCliente;
import br.NOZ.fezta.gerenciador.GerenciadorEventos;
import br.NOZ.fezta.gerenciador.GerenciadorFuncionario;
import br.NOZ.fezta.gerenciador.GerenciadorProdutos;
import br.NOZ.fezta.repositorio.RepositorioEventos;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;
import br.NOZ.fezta.repositorio.RepositorioIngresso;
import br.NOZ.fezta.repositorio.RepositorioProdutos;

public class Facade {
	
	private RepositorioFuncionario RF = RepositorioFuncionario.getInstance();
	private RepositorioEventos RE = RepositorioEventos.getInstance();
	private RepositorioIngresso RI = RepositorioIngresso.getInstance();
	private RepositorioProdutos RP = RepositorioProdutos.getInstance();
	
	private GerenciadorCliente GC;
	private GerenciadorEventos GE;
	private GerenciadorFuncionario GF;
	private GerenciadorProdutos GP;
	
	private String login;
	private String senha;
	private int ac;
	private Funcionario funcionario;
	
	private static Facade instance;
	
	private Facade()
	{
		//instance = new Facade();
	}
	
	public static Facade getInstance()
	{
		if(instance == null)
		{
			instance = new Facade();
		}
		return instance;
	}

	public void iniciar() {
		RF.Ler();
		RE.Ler();
		RI.Ler();
		RP.Ler();
		// TODO Auto-generated method stub
		
	}
	
	public String logar(String login, String senha)
	{
		
		//System.out.println(login);
		//RepositorioFuncionario.getInstance().getAL().get(0).getLogin().pLS();
		try {
			if(RepositorioFuncionario.getInstance().acessLevel(login, senha) <= 1)
			{
				ScreenManager.getInstance().callADM();
				//return "adm";
			}
			else if(RepositorioFuncionario.getInstance().acessLevel(login, senha) > 1)
			{
				ScreenManager.getInstance().callUser();
				//return "Funcionario";
			}
			this.login = login;
			this.senha = senha;
			this.ac = RepositorioFuncionario.getInstance().acessLevel(login, senha);
			try {
				this.funcionario = RF.getInstance().procurarFuncionarioPorLogin(login);
				//System.out.println(funcionario.getCpf());
			} catch (FuncionarioNaoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			GC = new GerenciadorCliente();
			GC.fazerLogin(login, senha);
			
			GE = new GerenciadorEventos();
			GE.fazerLogin(login, senha);
			
			GF = new GerenciadorFuncionario();
			GF.fazerLogin(login, senha);
			
			GP = new GerenciadorProdutos();
			GP.fazerLogin(login, senha);
			
			return "login";
			
		} catch (LoginInvalido | NaoExistemFuncionarios e) {
			return e.getMessage();
			// TODO Auto-generated catch block
			//textoErro.setText("Login Inválido!");
			//TXT.setText("Never Gonna Give you UP");
		}
	}

	public void mudarEmpresa(String empresa, String N, String rua, String bairro, String cep)
	{
		if(this.ac == 0)
		{
			try {
				RE.setEstabelecimento(empresa, login, senha);
				Endereco end = new Endereco();
				end.setBairro(bairro);
				end.setCEP(cep);
				end.setNumero(N);
				end.setRua(rua);
				
				RE.setEndereco(end, login, senha);
			} catch (LoginInvalido | NaoExistemFuncionarios | UsuarioSemPrivilegio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public Funcionario getFuncionario() {
		// TODO Auto-generated method stub
		return this.funcionario;
	}
	
	public ArrayList<LocalDateTime> getInicioExpediente()
	{
		int i;
		ArrayList<LocalDateTime> inicio = new ArrayList<LocalDateTime>();
		for(i = 0; i < funcionario.getEscalamento().size(); i++)
		{
			if(i%2 == 0)
			{
				inicio.add(funcionario.getEscalamento().get(i));
			}
		}
		return inicio;
	}
	public ArrayList<LocalDateTime> getFimExpediente()
	{
		int i;
		ArrayList<LocalDateTime> fim = new ArrayList<LocalDateTime>();
		for(i = 0; i < funcionario.getEscalamento().size(); i++)
		{
			if(i%2 == 1)
			{
				fim.add(funcionario.getEscalamento().get(i));
			}
		}
		return fim;
	}
	
	public Evento procurarEvento(String cod)
	{
		try {
			return RE.procurarEvento(cod);
		} catch (EventoNaoExiste e) {
			return null;
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public void addEvento(Evento event)
	{
		try {
			GE.addEvento(event);
		} catch (ObjetoInvalido | LoginInvalido | NaoExistemFuncionarios | UsuarioSemPrivilegio e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public void atualizarEvento(String v, Evento n)
	{
		try {
			RE.atualizarEvento(v, n, login, senha);
		} catch (EventoNaoExiste | NaoExistemFuncionarios | UsuarioSemPrivilegio | LoginInvalido e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public Produto procurarProduto(String text) {
		// TODO Auto-generated method stub
		try {
			return RP.procurarProduto(text);
		} catch (ProdutoNaoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addProduto(Produto pro) {
		try {
			RP.cadastrarProduto(pro, login, senha);
		} catch (ProdutoJaExiste | ObjetoInvalido | LoginInvalido | NaoExistemFuncionarios | UsuarioSemPrivilegio e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public void editarProduto(String codigo, Produto pro) {
		try {
			RP.atualizarProduto(codigo, pro, login, senha);
		} catch (ObjetoInvalido | ProdutoNaoExiste | LoginInvalido | NaoExistemFuncionarios | UsuarioSemPrivilegio e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

	public void addIngresso(Ingresso novo) {
		try {
			System.out.println("go3");
			RI.cadastrarIngresso(novo, login, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}

	public Ingresso procurarCliente(String text) {
		
		try {
			return RI.procurarIngresso(text);
		} catch (ClienteNaoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public void editarIngresso(String text, Ingresso novo) {
		try {
			RI.removerIngresso(text, login, senha);
			RI.cadastrarIngresso(novo, login, senha);
		} catch (LoginInvalido | NaoExistemFuncionarios | UsuarioSemPrivilegio | ClienteNaoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public void vender(String text, String text2, int q) {
		try {
			Produto produto = RP.procurarProduto(text2);
			Ingresso cliente = RI.procurarIngresso(text);
			if(produto.getQuantidade()>=q){
				cliente.setCliente(cliente.getCliente().vender(produto, q));
				Cliente c = cliente.getCliente();
				c.setTotalPreco(c.getTotalPreco() + produto.getPreco()*q);
				cliente.setCliente(c);
				//cliente.setCliente(cliente.getCliente().setTotalPreco(cliente.getCliente().getTotalPreco() + produto.getPreco()*q));
				produto.setQuantidade(produto.getQuantidade() - q);
			}
			
			
		} catch (ProdutoNaoExiste | ClienteNaoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
