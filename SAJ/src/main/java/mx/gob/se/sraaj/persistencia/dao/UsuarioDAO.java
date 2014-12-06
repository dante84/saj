package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.servicio.beanImpl.UsuarioBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public interface UsuarioDAO {
	
	/**
	 * Metodo que invoca al SP para reestablecer contraseña.
	 * @param sUser Nombre del usuario
	 * @return String con la nueva contraseña
	 * @throws SraajException Excepcion de negocio.
	 */
	public String obtieneNuevoPwd(String sUser) throws Exception;
	
	/**
	 * Metodo que invoca al SP para cambiar contraseña de accceso.
	 * @param sUser Nombre del usuario.
	 * @return boolean True o False segun el caso.
	 * @throws SraajException Excepcion de Negocio.
	 */
	public boolean cambiaPwdDeAcceso(String usuario, String oldPass, String pass) throws Exception;
	
	/**
	 * Metodo que invoca el SP para obtener datos del usuario.
	 * @param sUsuario Nombre del usuario.
	 * @return Objeto con informacion del usuario.
	 * @throws SraajException Excepcion de Negocio.
	 */
	public UsuariosBeanImpl obtieneInfoUsuario(String sUsuario) throws Exception;
	public List<UsuariosBeanImpl> buscarUsuarios() throws Exception;
	
	/** 
	 * 
	 * @param info
	 * @return
	 * @throws SraajException
	 */
	public boolean actualizaMiPerfil(UsuarioBeanImpl info) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws DAOException
	 */
	public ErrorBDBean agregaNuevoUsuario(UsuariosBeanImpl user) throws Exception;

}
