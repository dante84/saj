package mx.gob.se.sraaj.comunes.bean;

import java.io.Serializable;

public class DatosLogin implements Serializable{
		   	  
	   private static final long serialVersionUID = 7842792538520129580L;
	   
	   private String usuario;	    
	   private String password;
		
	   public String getUsuario() { return usuario; }
		
	   public void setUsuario(String usuario) { this.usuario = usuario; }
		
	   public String getPassword() { return password; } 
		
	   public void setPassword(String password) { this.password = password; }

}
