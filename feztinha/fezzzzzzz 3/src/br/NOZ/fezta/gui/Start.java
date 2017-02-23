package br.NOZ.fezta.gui;

import javafx.application.Application;
import javafx.stage.Stage;

import java.time.LocalDateTime;

import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.beans.Login;
import br.NOZ.fezta.exceptions.FuncionarioJaExiste;
import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.exceptions.ObjetoInvalido;
import br.NOZ.fezta.exceptions.UsuarioSemPrivilegio;
import br.NOZ.fezta.gui.*;
import br.NOZ.fezta.repositorio.RepositorioEventos;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;
import br.NOZ.fezta.repositorio.RepositorioIngresso;
import br.NOZ.fezta.repositorio.RepositorioProdutos;

public class Start extends Application{
	
	public static void main(String[] args)
	{
		
		RepositorioFuncionario RF = RepositorioFuncionario.getInstance();
		RepositorioEventos RE = RepositorioEventos.getInstance();
		RepositorioIngresso RI = RepositorioIngresso.getInstance();
		RepositorioProdutos RP = RepositorioProdutos.getInstance();
		
	
		
		//RF =  RF.Ler();
		//RF.Ler();
		
		Funcionario adm = new Funcionario();
		Login admlg = new Login("123", "admin");
		adm.setCpf("000");
		adm.setNome("Admin");
		adm.setLogin(admlg);
		
		adm.addEscalamento(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
		
		Funcionario user1 = new Funcionario();
		Login user1lg = new Login("123", "user1");
		user1lg.setAcessLevel(2);
		user1.setCpf("001");
		user1.setNome("User");
		user1.setLogin(user1lg);
		
		Funcionario guest = new Funcionario();
		Login guestlg = new Login("12345", "guest");
		guestlg.setAcessLevel(2);
		guest.setCpf("002");
		guest.setNome("Guest");
		guest.setLogin(guestlg);
		
		try {
			RF.cadastrarFuncionario(adm, "admin", "12345");
			//System.out.println("cadastrou o adm");
		} catch (LoginInvalido | UsuarioSemPrivilegio | ObjetoInvalido | FuncionarioJaExiste e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		RepositorioFuncionario.getInstance().getAL().get(0).getLogin().pLS();
		System.out.println(RepositorioFuncionario.getInstance().getAL().get(0).getCpf());
		
		try{
			RF.cadastrarFuncionario(user1, "admin", "123");
			RF.cadastrarFuncionario(guest, "admin", "123");
		} catch(Exception e)
		{
			//TUDO
		}
		
		//RF.Escrever();/* */
		
		/*
		Login adm = new Login("12345", "admin");
		Funcionario admin = new Funcionario();
		
		admin.setLogin(adm);
		admin.setNome("Admin");
		admin.setCpf("000.000.000-00");
		
		try {
			RepositorioFuncionario.getInstance().acessLevel("admin", "12345");
		} catch (LoginInvalido e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch(NaoExistemFuncionarios e)
		{
			try {
				RepositorioFuncionario.getInstance().cadastrarFuncionario(admin, "admin", "12345");
			} catch (LoginInvalido | UsuarioSemPrivilegio | ObjetoInvalido | FuncionarioJaExiste e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}*/
		launch();
	}

	@Override
	public void start(Stage arg) throws Exception {
		ScreenManager.getInstance().setMainStage(arg);
		ScreenManager.getInstance().callLogin();
		//ScreenManager.getInstance().callADM();
		// TODO Auto-generated method stub
		
	}

}
