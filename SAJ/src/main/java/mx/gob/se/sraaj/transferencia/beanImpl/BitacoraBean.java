package mx.gob.se.sraaj.transferencia.beanImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bitacoraBean")
@RequestScoped
public class BitacoraBean {
	 
       private int iIdBitacora;
	   private String sAccion;	
	   private String sCreated_Date;
	   private int iIdPerfil;
	   private String sUsuario;
	   
	   public int getiIdBitacora() { return iIdBitacora; }
	   
	   public void setiIdBitacora(int iIdBitacora) { this.iIdBitacora = iIdBitacora; }
	   
	   public String getsAccion() { return sAccion; }
	   
	   public void setsAccion(String sAccion) { this.sAccion = sAccion; }
	
	   public String getsCreated_Date() { return sCreated_Date; }
	   
	   public void setsCreated_Date(String sCreated_Date) { this.sCreated_Date = sCreated_Date; }
	   
	   public int getiIdPerfil() { return iIdPerfil; }
	   
	   public void setiIdPerfil(int iIdPerfil) { this.iIdPerfil = iIdPerfil; }
	   
	   public String getsUsuario() { return sUsuario; }
	   
	   public void setsUsuario(String sUsuario) { this.sUsuario = sUsuario; }
	   
	   

}
