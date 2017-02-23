package br.NOZ.fezta.repositorio;

import java.io.*;
//import Repositorio.Beans.Endereco;
//import Repositorio.Beans.Evento;
import java.util.ArrayList;
import br.NOZ.fezta.beans.*;
import br.NOZ.fezta.dados.IRepositorioEventos;
import br.NOZ.fezta.exceptions.*;

public class RepositorioEventos implements IRepositorioEventos, Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private static RepositorioEventos instance = RepositorioEventos.getInstance();
	private RepositorioFuncionario repFuncionarios; // mudei aqui a declração pra o construtor ass:larissa

	private String estabelecimento = "";
	private Endereco lugar;
	private ArrayList<Evento> calendario = new ArrayList<Evento>();
	private int eventos = 0;
	private Integer eventoCOD = 1;
	
	public ArrayList<Evento> getCalendario()
	{
		return calendario;
	}

	/*
	 * public estabelecimento(String nome, endereco lugar) {
	 * 
	 * }
	 */

	private RepositorioEventos()   /*throws IOException*/ {//botei o repfun get instance aqui
		lugar = new Endereco();
		
			this.repFuncionarios= RepositorioFuncionario.getInstance();
		
	}
	
	
///mudei aqui***********************************************ass:larissa
	public static RepositorioEventos getInstance() {
		if(instance == null)
		{
			
				instance = Ler();
			
//			instance = new RepositorioEventos();
		}
		return instance;
	}
	
	
	public static RepositorioEventos Ler() 
	{
		FileInputStream entrada = null;
		ObjectInputStream obj = null;
		
		try{
			 entrada = new FileInputStream("eventos.arq");
			 obj = new ObjectInputStream(entrada);
			return (RepositorioEventos) obj.readObject();
		}
		catch(Exception e)
		{
			return new RepositorioEventos();
		}
	}
	
	public void Escrever(RepositorioEventos x) {
	
			FileOutputStream saida = null;
			ObjectOutputStream obj = null;
			try {
				 saida = new FileOutputStream(new File("eventos.arq"));
					obj = new ObjectOutputStream(saida);
					
					obj.writeObject(this.instance);
					obj.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		
		 
	}
//*******************************
	public void addEvento(Evento evento1, String login, String senha)
			throws ObjetoInvalido, LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0 || r == 1) {
			if (evento1 == null || !(evento1 instanceof Evento)) {
				throw new ObjetoInvalido("Evento");
			}
			calendario.add(evento1);
			evento1.setCodigo(eventoCOD);
			eventoCOD++;
			eventos++;
			
			
			
				Escrever(this.instance);
			
			
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public Evento procurarEvento(String code) throws EventoNaoExiste {
		Evento auxiliar = null;
		if (code != null) {
			if (this.calendario.size() > 0) {
				for (int i = 0; i < calendario.size(); i++) {
					if (code.equals(this.calendario.get(i).getCodigo())) {
						auxiliar = this.calendario.get(i);
					}
				}
			}
		}
		if (code == null || auxiliar == null) {
			throw new EventoNaoExiste("*");
		}
		return auxiliar;
	}

	public void removerEvento(Evento este, String login, String senha)
			throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0 || r == 1) {
			int i;
			if (este != null) {
				for (i = 0; i < eventos; i++) {
					if (este.equals(calendario.get(i))) {
						calendario.remove(este);
						eventos -= 1;
						
							Escrever(this.instance);
						
					} else if (i == eventos) {
						throw new EventoNaoExiste(este.getCodigo());
					}
				}
			} else {
				throw new EventoNaoExiste("*");
			}
		} else {
			throw new UsuarioSemPrivilegio();
		}
		// return true;
	}

	public void atualizarEvento(Evento velho, Evento novo, String login, String senha)
			throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0 || r == 1) {
			int i;
			if (velho != null) {
				for (i = 0; i < eventos; i++) {
					if (velho.equals(calendario.get(i))) {
						calendario.remove(velho);
						calendario.add(novo);
					
							Escrever(this.instance);
						
					} else if (i == eventos) {
						throw new EventoNaoExiste(velho.getCodigo());
					}
				}
			} else {
				throw new EventoNaoExiste("*");
			}
		}
		{
			throw new UsuarioSemPrivilegio();
		}
		// return false;
	}
	
	public void atualizarEvento(String velho, Evento novo, String login, String senha)
			throws EventoNaoExiste, NaoExistemFuncionarios, UsuarioSemPrivilegio, LoginInvalido {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0 || r == 1) {
			int i;
			if (velho != null) {
				for (i = 0; i < eventos; i++) {
					if (velho.equals(calendario.get(i).getCodigo())) {
						calendario.remove(i);
						calendario.add(novo);
						
							Escrever(this.instance);
						
					} else if (i == eventos) {
						throw new EventoNaoExiste(velho);
					}
				}
			} else {
				throw new EventoNaoExiste("*");
			}
		}
		{
			throw new UsuarioSemPrivilegio();
		}
		// return false;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0) {
			this.estabelecimento = estabelecimento;
			
				Escrever(this.instance);
			
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public Endereco getEndereco() {
		return lugar;
	}

	public void setEndereco(Endereco endereco, String login, String senha)
			throws LoginInvalido, NaoExistemFuncionarios, UsuarioSemPrivilegio {
		int r = this.repFuncionarios.acessLevel(login, senha);
		if (r == 0) {
			this.lugar = endereco;
			
				Escrever(this.instance);
			
		} else {
			throw new UsuarioSemPrivilegio();
		}
	}

	public int getEventos() {
		return eventos;
	}

	public Integer getEventoCOD() {
		return eventoCOD;
	}
	
	public Evento[] listarEventos()
	{
		return listarEventos("");
	}
	
	public Evento[] listarEventos(String cod) {
		//String s;
		ArrayList<Evento> f = new ArrayList<Evento>();
		boolean b = false;
		Evento[] out = null;

		char[] c = cod.toCharArray();

		for (int i = 0; i < calendario.size(); i++) {
			b = true;
			if (cod.equals("")) {
				if(i == 0)
				{
					out = new Evento[this.calendario.size()];
				}
				out[i] = this.calendario.get(i);
				
				//f.add(repfun.get(i));
				//s += repfun.get(i).toString();
				//s += "\n";
			} else {
				char[] c2 = calendario.get(i).getCodigo().toCharArray();
				for (int n = 0; n < cod.length(); n++) {
					if (c[n] != c2[n]) {
						b = false;
					}
				}
				if (b == true) {
					f.add(calendario.get(i));
					//s += repfun.get(i).toString();
					//s += "\n";
				}
			}
		}
		if(out == null)
		{
			out = new Evento[f.size()];
			for(int n = 0; n < f.size(); n++)
			{
				out[n] = f.get(n);
			}
		}

		return out;
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carregar() {
		// TODO Auto-generated method stub
		
	}
	
}