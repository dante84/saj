package mx.gob.se.sraaj.persistencia.dao;

import mx.gob.se.sraaj.transferencia.beanImpl.AccesoBean;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;

public interface GestionaAccesoDAO {
	 
	   public boolean verificaUsuario(String usuario,String password);	
	   public AccesoBean accesoSP(LoginBean loginDTO) throws Exception;

}
