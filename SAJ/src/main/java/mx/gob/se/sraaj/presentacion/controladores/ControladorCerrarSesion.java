package mx.gob.se.sraaj.presentacion.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="CCerraSesion")
@RequestScoped
public class ControladorCerrarSesion {
	
	   public String cerrarSesion(){ 
		    
		      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		       
		      return "/index.xhtml?faces-redirect=true";
		   
	   }

}
