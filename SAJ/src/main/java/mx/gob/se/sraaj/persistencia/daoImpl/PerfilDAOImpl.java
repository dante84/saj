package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.CatGralBean;
import mx.gob.se.sraaj.comunes.bean.PerfilBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.dao.PerfilDAO;
import mx.gob.se.sraaj.persistencia.sp.PermisosPerfilSP;

public class PerfilDAOImpl implements PerfilDAO{
	
	private PermisosPerfilSP permisosPerfilSP;
	
	public PermisosPerfilSP getPermisosPerfilSP() { return permisosPerfilSP; }
	public void setPermisosPerfilSP(PermisosPerfilSP permisosPerfilSP) { this.permisosPerfilSP = permisosPerfilSP; }

	public List<PerfilBean> buscaPermisos(String idP) throws SraajException{
		
		   System.out.println("========>> en PerfilDAO buscaPermisos");
		   List<PerfilBean> lPer = null;
		   
		   try{
			 
			   Map<String, Object> mapCursor = permisosPerfilSP.execute(idP);
			   
			   if( mapCursor != null ){
				   Object datos = mapCursor.get("pDatos");
				   if( datos instanceof List<?> ){
					   lPer = (List<PerfilBean>) datos;
					   for( PerfilBean pb : lPer ){
						    System.out.println(" **** " + pb.getsPermisos());
					   }
					   return lPer;
				   }
			   }   
		   }
		   catch(Exception ex){ 
			   throw new SraajException(ex.getMessage(), ex);
		   }
		   return null;
	}

}
