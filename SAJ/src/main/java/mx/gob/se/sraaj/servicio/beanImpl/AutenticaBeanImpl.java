package mx.gob.se.sraaj.servicio.beanImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.comunes.utils.Utilerias;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaAccesoDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.UsuarioDAOImpl;
import mx.gob.se.sraaj.presentacion.beanImpl.PermisosBeanImpl;
import mx.gob.se.sraaj.servicio.bean.AutenticaBean;
import mx.gob.se.sraaj.transferencia.beanImpl.AccesoBean;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public class AutenticaBeanImpl implements AutenticaBean {
	
       private static final String pEspecial = "Permisos Especiales";
	   private static final String OK = "OK";	
	   private static final String NOK = "NOK";
	
	   private GestionaAccesoDAOImpl gestionaAccesoDAOImpl;
	   private UsuarioDAOImpl usuarioDAOImpl;
	   private SesionBeanImpl sesionBean;

	   public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) { this.usuarioDAOImpl = usuarioDAOImpl; }
 
  	   public void setGestionaAccesoDAOImpl(GestionaAccesoDAOImpl gestionaAccesoDAOImpl) { this.gestionaAccesoDAOImpl = gestionaAccesoDAOImpl; }

	   public void setSesionBean(SesionBeanImpl sesionBean) { this.sesionBean = sesionBean; }

	   
	   public SesionBeanImpl ingresaUsuario(String usuario,String contraseña) throws Exception {
		      
		      sesionBean.setsUser(usuario);
		      		      		      
		      try{
		    	  
		    	  String enPass = Utilerias.encriptaPassword( contraseña ); 
			      			      
			      enPass = enPass.toUpperCase();
			      
			      LoginBean loginBean = new LoginBean();
			      		    	 
		    	  loginBean.setsUsuario(usuario);
		    	  loginBean.setsContrasenia(enPass);		    	  		    	 
		    	  
		    	  AccesoBean accesoBean = gestionaAccesoDAOImpl.accesoSP(loginBean); 
		    	  
		    	  if( Constantes.ERRORDB_EXITO.equals(accesoBean.getErrorBD().getsCodError().trim()) ) {
		    		  
					  Map<String, List<MenuBean>> mnuFinales = obtieneMenus(accesoBean.getMenus());
					  sesionBean.setPermisos(mnuFinales);
					  
					  List<PermisosBeanImpl> listaPermisosBean = new ArrayList<PermisosBeanImpl>();					  					  
					  
					  sesionBean.setPermisosBean(listaPermisosBean);					  					  
					  
					  UsuariosBeanImpl user = usuarioDAOImpl.obtieneInfoUsuario(loginBean.getsUsuario());					  
					  sesionBean.setsNombre(user.getsNombre());
					  sesionBean.setsApellido1(user.getsApellidoPaterno());
					  sesionBean.setsApellido2(user.getsApellidoMaterno());
					  sesionBean.setsNombreCompl(user.getsNombre() + " " + user.getsApellidoPaterno() + " " + user.getsApellidoMaterno());
					  sesionBean.setCorreoElectronico(user.getsCorreoElectronico());
					  					  
					  if( mnuFinales.containsKey(pEspecial) ) {
						  mnuFinales.remove(pEspecial);
						  sesionBean.setsElimina(OK);
					  }else { sesionBean.setsElimina(NOK); }
					  
					}
		    	  
					sesionBean.setsErrorDB(accesoBean.getErrorBD().getsCodError());
					sesionBean.setsDescError(accesoBean.getErrorBD().getsDescError());
		    	  
		      }catch(Exception e){ e.printStackTrace(); }
		      		   
		      return sesionBean;
		      
	   }

	   
	   public Map<String, List<MenuBean>> obtieneMenus(List<MenuBean> permDB) {
		   
			  Set<String> menus = new HashSet<String>();
			  Map<String, List<MenuBean>> mnuFinales = new HashMap<String, List<MenuBean>>();
			  List<MenuBean> listMenus = new ArrayList<MenuBean>();
			  
			  for(MenuBean item : permDB) { menus.add(item.getDescMenu()); }
			
			  for( String sMenu : menus ) {				  
				   for( MenuBean item : permDB ) {
					    if( sMenu.equals(item.getDescMenu()) ) {
						    listMenus.add(item);
					    }
					    
				   }
				   
				   mnuFinales.put(sMenu, listMenus);
				   listMenus = new ArrayList<MenuBean>();
				   
			  }
			  
			  return mnuFinales; 
		     		     
	   }

	   
	   public String asignaNuevaPwd(LoginBean loginDTO) throws Exception {
		   
		      
		   
		      return null;
		      
	   }

}
