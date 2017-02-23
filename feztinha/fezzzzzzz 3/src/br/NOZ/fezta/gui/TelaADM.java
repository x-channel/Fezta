package br.NOZ.fezta.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.NOZ.fezta.beans.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TelaADM implements Initializable{
	
	@FXML
	private TableView<Produto> estoqueTable;
	
	@FXML
	private Text funcionarioNome;
	
	@FXML
	private Text funcaoNaEmpresa;
	
	
	@FXML
	private void botaoClicado(ActionEvent evt){
		
	}
	@FXML
	private void cancelAction(ActionEvent evt){
		
	}
	
	public TelaADM(){
		
	}
	
	public void setRoot(){
		
	}
	
	
	@FXML
	public void sairButton(ActionEvent event)
	{
		int a;
	}
	
	@FXML
	public void novoFuncionario(ActionEvent event)
	{
		int a;
	}
	
	@FXML
	public void novoCliente(ActionEvent event)
	{
		int a;
	}
	
	@FXML
	public void EditarCliente(ActionEvent event)
	{
		int a;
	}
	
	@FXML
	public void novoEvento(ActionEvent event){
		
	}
	
	@FXML
	public void editarEvento(ActionEvent event){
		
	}
	
	@FXML
	public void editarFuncionario(ActionEvent event){
		
	}
	
	@FXML public void editarCliente(ActionEvent event){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
