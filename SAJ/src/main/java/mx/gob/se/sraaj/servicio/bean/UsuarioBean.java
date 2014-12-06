package mx.gob.se.sraaj.servicio.bean;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.servicio.beanImpl.UsuarioBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public interface UsuarioBean {

	public UsuariosBeanImpl obtieneInfoUser(String sUser) throws SraajException;
	public boolean actualizaMiPerfil(UsuarioBeanImpl info) throws SraajException;
	
	
}
