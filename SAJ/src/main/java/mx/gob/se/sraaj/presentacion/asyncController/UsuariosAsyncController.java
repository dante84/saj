package mx.gob.se.sraaj.presentacion.asyncController;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public interface UsuariosAsyncController {
	
	/**
	 * @param UserBean Objeto con informacion a actualizar
	 * @return Path de direccionamiento.
	 * @throws SraajException Excepcion de negocio.
	 */
	public String actualizaMiPerfil(UsuariosBeanImpl userBean) throws SraajException;

}
