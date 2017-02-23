package br.NOZ.fezta.gerenciador;
//import static GUI.CadastrosTextuais.Tendereco;
import java.time.LocalDateTime;

//import Repositorio.*;
//import Repositorio.Beans.Endereco;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.FuncionarioNaoExiste;
import br.NOZ.fezta.exceptions.HorarioInexistente;
import br.NOZ.fezta.exceptions.HorarioJaEscalado;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.negocio.IFuncionario;
//import Repositorio.Beans.Funcionario;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;

//import java.util.Scanner;

public class GerenciadorFuncionario implements IFuncionario{
	
	private String login = null;
	private String senha = null;
	
	public GerenciadorFuncionario()
	{
		//não recebe
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
	public void setLogin(String login)
	{
		this.login = login;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}*/
	
	
	
	public void admitir(String nome1, String funcao1, String cpf1, 
			double salario1, String telefone1, String CEP1, String numero1, 
			String bairro1, String rua1, String usuario1, String senha1) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste
	{
		//if(RepositorioFuncionario.getInstance().procurarFuncionario(cpf1) == null)
		//{
			Endereco end = new Endereco(CEP1, numero1, bairro1, rua1);
			Funcionario fun = new Funcionario(nome1, funcao1, cpf1, salario1, telefone1, end, usuario1, senha1);
			RepositorioFuncionario.getInstance().cadastrarFuncionario(fun, this.login, this.senha);
			//return true;
		//}
		//else
		//{
			//return false;
		//}
	}
	
	public void admitir(Funcionario a) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste
    {
        if(RepositorioFuncionario.getInstance().procurarFuncionario(a.getCpf()) == null)
        {
            RepositorioFuncionario.getInstance().cadastrarFuncionario(a, this.login, this.senha);
            //return true;
        }
            
        //return false;
            
    }
	
	public void editarFuncionario(Funcionario funcio) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste, NaoExistemFuncionarios
	{
		demitir(funcio.getCpf());
		admitir(funcio);
	}
        
    public void editarFuncionario(String cpf, Funcionario funcio) throws LoginInvalido, UsuarioSemPrivilegio, ObjetoInvalido, FuncionarioJaExiste, FuncionarioNaoExiste, NaoExistemFuncionarios
    {
    	demitir(cpf);
    	admitir(funcio);
	}
        /*
	public boolean editarFuncionario(String cpf1, int op)
	{
            Scanner scanf = new Scanner(System.in);
		boolean aux = false;
		if(RepositorioFuncionario.getInstance().procurarFuncionario(cpf1) != null)
		{
                  
			Funcionario emp = RepositorioFuncionario.getInstance().procurarFuncionario(cpf1);
			if(op == 1)
                        {
                            String funcao1 = scanf.nextLine();
                            emp.setFuncao(funcao1);
                        }
                        else if(op==2)
                        {
                            double salario1 = scanf.nextDouble();
                            emp.setSalario(salario1);
                        }
                        else if(op==3)
                        {
                            String telefone1 = scanf.nextLine();
                            emp.setTelefone(telefone1);
                        }
                        else if(op==3)
                        {
                            Endereco novo = new Endereco();
                            emp.setEndereco(novo);
                        }
			aux = true;
		}
		return aux;
	}*/
	
	public void demitir(String CPF) throws LoginInvalido, UsuarioSemPrivilegio, NaoExistemFuncionarios, FuncionarioNaoExiste
	{
		Funcionario fun = RepositorioFuncionario.getInstance().procurarFuncionario(CPF);
		if(fun != null)
		{
			RepositorioFuncionario.getInstance().removerFuncionario(fun, this.login, this.senha);
		}
	}
	
	public void escalarHorario(String cpf, LocalDateTime inicio, LocalDateTime fim) throws FuncionarioNaoExiste, HorarioJaEscalado
	{
		Funcionario empregado = RepositorioFuncionario.getInstance().procurarFuncionario(cpf);
		if(empregado != null)
		{
			escalarHorario(empregado, inicio, fim);
		}
	}
	
	public void escalarHorario(Funcionario empregado, LocalDateTime inicio, LocalDateTime fim) throws HorarioJaEscalado
	{
		//boolean retorno = false;
		if(empregado != null)
		{
			if(empregado.horarioEscalado(inicio)[0] != null && empregado.horarioEscalado(fim)[0] != null)
			{
				//retorno = false;
				new HorarioJaEscalado();
			}
			else if(empregado.horarioEscalado(inicio)[0] != null)
			{
				//retorno = true;
				LocalDateTime[] emp = empregado.horarioEscalado(inicio);
				emp[0] = inicio;
				emp[1] = fim;
			}
			else if(empregado.horarioEscalado(fim)[0] != null)
			{
				//retorno = true;
				LocalDateTime[] emp = empregado.horarioEscalado(fim);
				emp[0] = inicio;
				emp[1] = fim;
			}
			else
			{
				//retorno = true;
				empregado.addEscalamento(inicio, fim);
			}
		}
		//return retorno;
	}
	public void editarHorario(Funcionario empregado, LocalDateTime edit, LocalDateTime inicio, LocalDateTime fim) throws HorarioInexistente
	{
		//boolean aux = false;
		if(empregado != null && empregado.horarioEscalado(edit)[0] != null)
		{
			LocalDateTime[] at = empregado.horarioEscalado(edit);
			at[0] = inicio;
			at[1] = fim;
		}
		else
		{
			throw new HorarioInexistente();
		}
		//return aux;
	}
	
	public String[] listarNomeDosFuncionarios()
	{
		return listarNomeDosFuncionarios("");
	}
	
	public String[] listarNomeDosFuncionarios(String cod)
	{
		Funcionario[] f = RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		String[] n = new String[f.length];
		for(int a = 0; a < f.length; a++)
		{
			n[a] = f[a].getNome();
		}
		return n;
	}
	
	public String[] listarCPFdosFuncionarios()
	{
		return listarCPFdosFuncionarios("");
	}
	
	public String[] listarCPFdosFuncionarios(String cod)
	{
		Funcionario[] f = RepositorioFuncionario.getInstance().listarFuncionarios(cod);
		String[] n = new String[f.length];
		for(int a = 0; a < f.length; a++)
		{
			n[a] = f[a].getCpf();
		}
		return n;
	}
	
	public Funcionario[] listarFuncionarios()
	{
		return RepositorioFuncionario.getInstance().listarFuncionarios();
	}
	
	public Funcionario[] listarFuncionarios(String cod)
	{
		return RepositorioFuncionario.getInstance().listarFuncionarios("");
	}
}
