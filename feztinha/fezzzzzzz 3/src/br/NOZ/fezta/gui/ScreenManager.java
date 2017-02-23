package br.NOZ.fezta.gui;

//Copia parcial dos samples do Professor Leandro


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import br.ufrpe.gui.jfx_samples.ScreenManager;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScreenManager {
	
	private static ScreenManager instance;
	//private Stage loginStage;
	private Stage mainStage;
    private Scene login;
    private Scene interfaceADM;
    private Scene interfaceUser;

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        } 
        
        return instance; 
    }
    
    private ScreenManager()
    {
    	try {
			BorderPane login = FXMLLoader.load(getClass().getResource("/br/NOZ/fezta/gui/Login.fxml"));
			this.login = new Scene(login);
			this.login.setRoot(login);
			
			BorderPane usr = FXMLLoader.load(getClass().getResource("/br/NOZ/fezta/gui/InterfaceUser.fxml"));
			this.interfaceUser = new Scene(usr);
			//this.login.setRoot
			//System.out.println(this.login.getRoot().toString());
			//FXMLLoader admLoader = new FXMLLoader(getClass().getResource("/br/NOZ/fezta/gui/InterfaceADM.fxml"));
			//admLoader.setRoot(admLoader);
			//System.out.println(admLoader.getRoot().toString());
			//admLoader.load();
			//BorderPane adm = admLoader.load();
			BorderPane adm = FXMLLoader.load(getClass().getResource("/br/NOZ/fezta/gui/InterfaceADM.fxml"));
			this.interfaceADM = new Scene(adm);/* */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void setMainStage(Stage stg)
    {
    	//loginStage = stg;
    	mainStage = stg;
    	
    }
    
    public void callLogin()
    {
    	mainStage.setScene(this.login);
    	mainStage.show();
    }
    public void callADM()
    {
    	mainStage.setX(100);
    	mainStage.setY(50);
    	mainStage.setScene(this.interfaceADM);
    	//mainStage.show();
    }
    public void callUser()
    {
    	mainStage.setX(100);
    	mainStage.setY(50);
    	mainStage.setScene(this.interfaceUser);
    }
}
