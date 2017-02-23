package br.NOZ.fezta.beans;

//import javax.swing.JOptionPane;

import java.util.List;


public class Login {
    
    private String senha;
    private String usuario;
    private int acessLevel = -1;
    //private int n;
    
    public void pLS()
    {
    	//System.out.format("//APENAS PARA DEPURA��O\n//Login: %s\n//Senha: %s\n", usuario, senha);
    }
    
    public int getAcessLevel() {
		return acessLevel;
	}
	public void setAcessLevel(int acessLevel) {
		this.acessLevel = acessLevel;
	}
	public Login(String senha1, String usuario1)//, int n1)
    {
        //setSenha(senha1);
        //setUsuario(usuario1);
       //setN(n1);
       senha = senha1;
       usuario = usuario1;
    }
/*
    public Login(String user, String senha)
    {
        this.usuario = user;
        this.senha = senha;
    }
    */
    public Login()
    {
        senha = "no";
        usuario = "no";
       
    }
    
    public String getUser()
    {
    	return this.usuario;
    }
    
    public boolean checarSenha(String senha1) {
        if(senha1.equals(this.getSenha()))
        {
        	return true;
        }
        return false;
    }

    public boolean setUsuario(String usuarioAntigo, String usuarioN, String senha)
    {
    	if (this.entra(usuarioAntigo, senha))
    	{
    		usuario = usuarioN;
    		return true;
    	}
    	return false;
    }
    
    public boolean setSenha(String usuario, String senhaOriginal, String senhaNova) {
    	if (this.entra(usuario, senhaOriginal))
    	{
    		this.senha = senhaNova;
    		return true;
    	}
    	return false;
    }

   
    public String getUsuario() {
        return usuario;
    }

    /*
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }*/
    
   /*
    public int getN() {
        return n;
    }

  
    public void setN(int n) {
        this.n = n;
    }
    */
    /*
   public static int entra(OFuncionario[] funcios, int tam, String senhaDigitada1, String usuarioDigitado1) 
   {
       int n1=-1;
       
       for(int q  = 0; q<tam;q++)
       {
           if(funcios[q].equalsx(usuarioDigitado1,senhaDigitada1))
           {
                
               
                    n1 = funcios[q].getSenhas().getN();
                   
               
           }
       }
       
         if(n1==-1)
           JOptionPane.showMessageDialog(null,  "Senha ou usuário incorreto","Erro de identificação",JOptionPane.WARNING_MESSAGE);
    
       
       return n1;
       
       
       
   }*/
    

    
    public boolean checarUsuario(String usuario)
    {
    	if(usuario.equals(this.usuario))
    	{
    		return true;
    	}
    	return false;
    }
    
    
    public boolean entra(String usuario, String senha)
    {
    	if(this.checarUsuario(usuario) && this.checarSenha(senha))
    	{
    		return true;
    	}
    	return false;
    }
    public boolean equals(Login ou)
    {
    	//if(this.checarUsuario(ou.getUsuario())&& this.checarSenha(ou.getSenha())) //pensando bem, não deveria ser necessário checar se as senhas são iguais
    	if(this.checarUsuario(ou.getUsuario()))
    	{
    		return true;
    	}
    	return false;
    	
    }

    /**
     * @return the senha
     */
    private String getSenha() {
        return senha;
    }
   
    public static int checaTodos(Login a, List<Funcionario> funcio)
    {
        for(int i = 0; i<funcio.size(); i++)
        {
        	//funcio.get(i).getLogin().pLS();
            if(funcio.get(i).getLogin().equals(a))
                return i;
        }
        
        return -1;
    }
    
    public static int checaTodos(String login, String senha, List<Funcionario> funcio)
    {
    	for(int i = 0; i< funcio.size(); i++)
    	{
    		if(funcio.get(i).getLogin().entra(login, senha))
    		{
    			return i;
    		}
    	}
    	return -1;
    }
            
       
}