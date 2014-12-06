package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.comunes.utils.Utilerias;
import mx.gob.se.sraaj.persistencia.dao.GestionaAccesoDAO;
import mx.gob.se.sraaj.persistencia.sp.AccesoSP;
import mx.gob.se.sraaj.transferencia.beanImpl.AccesoBean;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;

public class GestionaAccesoDAOImpl implements GestionaAccesoDAO {
	
	   private AccesoSP accesoSP;
		   	 	  
	   public AccesoSP getAccesoSP() {
		return accesoSP;
	}


	public void setAccesoSP(AccesoSP accesoSP) { this.accesoSP = accesoSP; }

	   
	   public boolean verificaUsuario(String usuario, String password) {
		   		   
		      Map<String,Object> mapa = null;
		      
		      String enPass = "";
		      
		      try{ enPass = Utilerias.encriptaPassword(password); }
		      catch(Exception e){ e.printStackTrace(); }
		      
		      enPass = enPass.toUpperCase();
		      
		      mapa = accesoSP.execute(usuario, enPass);		      		      
		      		      		      
		      if( mapa.containsKey("pResult") ){
		    	
		    	  Object cat =  mapa.get("pResult");
		    	  
		    	  if( cat != null ){
		    	  
		    	      if( cat instanceof List<?> ){
              		    
	            	      System.out.println("2.a");
	            	      
	            	      return true;
	            		  	                           		              	            	            	 	            	  
	                  }		    	  		    	  
		    	      
		    	  }
		    	  
		      }            	              	                	  
              
              return false;
		      
	   }

	   
	   public AccesoBean accesoSP(LoginBean loginBean) throws Exception {
		   		     
		      AccesoBean accesoBean = new AccesoBean();
		      		   	
		      try{
		    	   
		    	  Map<String, Object> mapCursor = accesoSP.execute(loginBean.getsUsuario(), loginBean.getsContrasenia());
		    	  
		    	  Object menus = null;
		    	  Object error = null;
		    	  
			      if( mapCursor != null ){
					  menus = mapCursor.get(Constantes.OUT_SP_RESULTADO);
					  error = mapCursor.get(Constantes.OUT_SP_ERROR);
				  }
					
				  @SuppressWarnings("unchecked")
				  List<MenuBean> lPermisos = (List<MenuBean>) menus;
					
			      @SuppressWarnings("unchecked")
				  List<ErrorBDBean> listError = (List<ErrorBDBean>) error;
					
				  accesoBean.setMenus(lPermisos);
				  accesoBean.setErrorBD(listError.get(0));
		    	  
		      }catch(Exception e){ e.printStackTrace(); }
		       
		      return accesoBean;
		      
	   }

}
