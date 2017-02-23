package br.NOZ.fezta.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.NOZ.fezta.exceptions.LoginInvalido;
import br.NOZ.fezta.exceptions.NaoExistemFuncionarios;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TelaLogin implements Initializable{
	
	@FXML
	private TextField loginCaixa;
	
	@FXML
	private PasswordField senhaCaixa;
	/*
	@FXML
	public Button okayLogin;
	*/
	
	@FXML
	private Label textoErro;
	
	//@FXML
	//private Text TXT;
	
	@FXML
	public void fazerLogin(ActionEvent event)
	{
		textoErro.setText(Facade.getInstance().logar(loginCaixa.getText(), senhaCaixa.getText()));
		/*
		//System.out.println(loginCaixa.getText());
		//System.out.println(senhaCaixa.getText());
		try {
			if(RepositorioFuncionario.getInstance().acessLevel(loginCaixa.getText(), senhaCaixa.getText()) <= 1)
			{
				ScreenManager.getInstance().callADM();
			}
			else if(RepositorioFuncionario.getInstance().acessLevel(loginCaixa.getText(), senhaCaixa.getText()) > 1)
			{
				ScreenManager.getInstance().callUser();
			}
		} catch (LoginInvalido | NaoExistemFuncionarios e) {
			// TODO Auto-generated catch block
			textoErro.setText("Login Inválido!");
			//TXT.setText("Never Gonna Give you UP");
		}*/
		
		//loginCaixa.setText("Caralho");
		//TODO
	}
	
	@FXML
	public void naDigitacao()
	{
		//textoErro.setText(loginCaixa.getText());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Facade.getInstance().iniciar();
		// TODO Auto-generated method stub
		
	}
	

}
