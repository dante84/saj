package mx.gob.se.sraaj.presentacion.asyncControllerImpl;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.presentacion.asyncController.UsuariosAsyncController;
import mx.gob.se.sraaj.servicio.bean.AutenticaBean;
import mx.gob.se.sraaj.servicio.bean.UsuarioBean;
import mx.gob.se.sraaj.servicio.beanImpl.UsuarioBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public class UsuariosAsyncControllerImpl implements UsuariosAsyncController {
	
	private AutenticaBean autenticaBean;
	private UsuarioBeanImpl usuarioBeanImpl;
	
	
	/**
	 * @param autenticaBean the autenticaBean to set.
	 */
	public void setAutenticaBean(AutenticaBean autenticaBean){
		this.autenticaBean=autenticaBean;
	}
	
	
	public String actualizaMiPerfil(UsuariosBeanImpl userBean) throws SraajException {
		try{
			if(usuarioBeanImpl.actualizaMiPerfil(userBean)) {
				return Constantes.PATH_BIENVENIDO;
			}
		}
		catch (SraajException srEx){
			throw srEx;
		}
		return null;
	}

}
