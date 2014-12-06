package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.exception.DAOException;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.UsuarioDAO;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.sp.CambiaPwdSP;

import mx.gob.se.sraaj.persistencia.sp.UpdUsuarioInfoSP;

import mx.gob.se.sraaj.persistencia.sp.RepUsuarioSP;

import mx.gob.se.sraaj.persistencia.sp.UsuarioInfoSP;
import mx.gob.se.sraaj.servicio.beanImpl.UsuarioBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	   private UsuarioInfoSP 				usuarioInfoSP;
	   private CambiaPwdSP 					cambiaPwdSP;
	   private UpdUsuarioInfoSP				updateUser;
	   private RepUsuarioSP 				repUsuarioSP;
	   
	   public void setUsuarioInfoSP(UsuarioInfoSP usuarioInfoSP) { this.usuarioInfoSP = usuarioInfoSP; }

	   public void setRepUsuarioSP(RepUsuarioSP repUsuarioSP) {	this.repUsuarioSP = repUsuarioSP; }
	   public void setUpdateUser(UpdUsuarioInfoSP updateUser) { this.updateUser = updateUser; }
	   public void setCambiaPwdSP(CambiaPwdSP cambiaPwdSP) { this.cambiaPwdSP = cambiaPwdSP; }
	   
	   public UpdUsuarioInfoSP getUpdateUser() { return updateUser; }

	public String obtieneNuevoPwd(String sUser) throws Exception {
		      // TODO Auto-generated method stub
		      return null;
	   }
	   
	   public boolean cambiaPwdDeAcceso(String usuario, String oldPass, String pass) throws Exception {
		   System.out.println("entro al metodo UsuarioDao");
			Map<String, Object> mapResul = cambiaPwdSP.execute(usuario,oldPass, pass);
			
			@SuppressWarnings("unchecked")
			List<ErrorBDBean> err = (List<ErrorBDBean>)mapResul.get(Constantes.OUT_SP_ERROR);
			
			if(err.get(0).getsDescError() != "OK")
			{
				System.out.println(err.get(0).getsDescError());
					return false;
			}
			
			return true;
			
	   }


	   
	   public UsuariosBeanImpl obtieneInfoUsuario(String sUsuario) throws Exception {
			  Map<String, Object> mapCursor = usuarioInfoSP.execute(sUsuario);
			  @SuppressWarnings("unchecked")
			  List<UsuariosBeanImpl> user = (List<UsuariosBeanImpl>) mapCursor.get(Constantes.OUT_SP_RESULTADO);
			  return user.get(0);
	   }

	   
	   //public List<UsuariosBeanImpl> buscarUsuarios() throws Exception {
		   //return List<UsuariosBeanImpl>();
		   //try {
				//Map<String, Object> mapCursor = repUsuarioSP.execute();
				
				//if(mapCursor != null)
				
				//Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);							
				
				//return lus;
			//	}
				//catch(Exception ex) {
			//		throw new SraajException(ex.getMessage(), ex);		  		  		     
			//	}
	   //}

	   
	   public boolean actualizaMiPerfil(UsuarioBeanImpl info) throws Exception {
		   try{
		      Map<String, Object> errorBd = updateUser.execute(info);
		      
		      @SuppressWarnings("unchecked")
		      List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		      if (err != null){
		    	  if(Constantes.ERRORDB_EXITO.equals(err.get(0).getsCodError().toString())){
		    		  return true;
		    	  }
		      }
		   }
		   catch(Exception ex){
			   throw new DAOException(ex.getMessage(), ex);
		   }
		   return false;
	   }

	   
	   public ErrorBDBean agregaNuevoUsuario(UsuariosBeanImpl user) throws Exception {
		      // TODO Auto-generated method stub
		      return null;
	   }


	   public List<UsuariosBeanImpl> buscarUsuarios() throws Exception {
		    
		      System.out.println("fndsfjsdkjfksdjl");
	
		      try{

			      List<UsuariosBeanImpl> lus = null;
			      Map<String, Object> mapCursor = repUsuarioSP.execute();
			      
			      for( Entry<String,Object> entry: mapCursor.entrySet() ){
			    	   System.out.println(entry.getKey() + " || " + entry.getValue());
			      }
			    			        
			      if( mapCursor != null ){
//			    	  if( mapCursor.get( Constantes.OUT_SP_ERROR ) != null ){
//			    		  List<ErrorBDBean> error = (List<ErrorBDBean>)mapCursor.get( Constantes.OUT_SP_ERROR );
//			    		  System.out.println(error.get(0).getsCodError() + " -- " + error.get(0).getsDescError());
//			    	  }else{
			                Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			                if( datos instanceof List<?>) {
  				                lus = (List<UsuariosBeanImpl>) datos;
  				          
			                }
//			          }
			      }
			
			      return lus;
			    
		   }catch(Exception ex) { throw new SraajException(ex.getMessage(), ex); }
		   
	}

}