package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.servicio.beanImpl.AutenticaBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.BitacoraBean;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;

@ManagedBean(name = "CLogin")
@RequestScoped
public class ControladorLogin implements Serializable{
		  
	   private static final long serialVersionUID = 1L;
	   
	   private String usuario;
	   private String password;
	   
	   @ManagedProperty(value="#{autenticaBean}")
	   private AutenticaBeanImpl autenticaBean;
	   
	   @ManagedProperty(value="#{sesionBean}")
	   private SesionBeanImpl sesionBean;
	   	  	   	  
	   public void setAutenticaBean(AutenticaBeanImpl autenticaBean) { this.autenticaBean = autenticaBean; }

	   public void setSesionBean(SesionBeanImpl sesionBean) { this.sesionBean = sesionBean; }

	   public AutenticaBeanImpl getAutenticaBean() {
		return autenticaBean;
	}

	public SesionBeanImpl getSesionBean() {
		return sesionBean;
	}

	public String getUsuario() { return usuario; }

	   public void setUsuario(String usuario) { this.usuario = usuario; }

	   public String getPassword() { return password; }

	   public void setPassword(String password) { this.password = password; }
	   	 
	   public String procesaUsuario(){
		   
		      String sPath = "";
		   		      		      		    	 
		      if( this.usuario.trim().equals("") ){
		    	  FacesContext.getCurrentInstance().addMessage( "forma:txtUsuario",new FacesMessage("El Usuario no puede ser vacio") );
		      }else{
		    	    if( this.password.trim().equals("") ){
		    	     	FacesContext.getCurrentInstance().addMessage( "forma:txtUsuario",new FacesMessage("La contraseña no puede ser vacia") );
		    	    }else{		    	    	
		    	    	  
		    	    	  try{ sesionBean = autenticaBean.ingresaUsuario( this.usuario.trim(), this.password.trim()); }
		    	    	  catch (Exception e) { e.printStackTrace(); }		    	    	  		    	    	  
		    	  		
		    		      if( Constantes.ERRORDB_EXITO.equals( sesionBean.getsErrorDB()) ) {
		    			
		    		    	  ServletRequestAttributes requestAttributes = ( ServletRequestAttributes ) RequestContextHolder.currentRequestAttributes();
		    			      HttpSession httpSession = requestAttributes.getRequest().getSession(true);
		    			      //UsuariosLogOn.existeUsuario(sesionVO.getsUser());
		    			      sesionBean.setIdSesion( Constantes.STR_ID_SESION + httpSession.getId() );
		    			      httpSession.setAttribute( Constantes.ATTR_SESION_VO, sesionBean );
		    			      BitacoraBean bitaDTO = new BitacoraBean();
		    			      
		    			      //bitaDTO.setsUsuario( loginBean.getsUsuario() );
		    			      bitaDTO.setsAccion( "Inició Sesion" );
		    			      //String res = bitacoraBO.insABitacora( bitaDTO );
		    			      sPath = "/xhtml/bienvenido";
		    			      
		    			      
		    		      } else if( Constantes.ERRORDB_RENOVAR_PASS.equals( sesionBean.getsErrorDB() ) ) {
		    			      
		    		    	         ServletRequestAttributes requestAttributes = ( ServletRequestAttributes ) RequestContextHolder.currentRequestAttributes();
		    			             HttpSession httpSession = requestAttributes.getRequest().getSession(true);
		    			             httpSession.setAttribute( Constantes.ATTR_SESION_VO, sesionBean );
		    			             sPath = Constantes.PATH_PASS_INGRESO;
		    			             
		    		      }	else { 
		    		    	  
		    		    	       FacesContext.getCurrentInstance().addMessage( "forma:txtUsuario",new FacesMessage("El usuario/contraseña son incorrectos") ); 
		    		    	       try { throw new Exception( sesionBean.getsDescError() ); }
		    		    	       catch (Exception e) { e.printStackTrace(); }
		    		    	       
		    		      }
		    				    	    	  
		    		}
		    	    
		      }
		    	   
		      return sPath;
		      
	   }
		   	   
}
