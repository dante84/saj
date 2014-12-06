package mx.gob.se.sraaj.servicio.beanImpl;

import javax.faces.bean.ManagedProperty;

import mx.gob.se.sraaj.comunes.exception.DAOException;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.comunes.utils.JavaMail;
import mx.gob.se.sraaj.persistencia.dao.UsuarioDAO;
import mx.gob.se.sraaj.persistencia.daoImpl.UsuarioDAOImpl;
import mx.gob.se.sraaj.servicio.bean.UsuarioBean;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

public class UsuarioBeanImpl implements UsuarioBean {
	
	private JavaMail email;
	
	@ManagedProperty(value="#{usuarioDAOImpl}")
	private UsuarioDAOImpl usuarioDAOImpl;
	
	 
    private String sUsuario;
	private String iContrasenia;
	private String sNombre;	
	private String sApellidoPaterno;	
	private String sApellidoMaterno;	
	private String sCorreoElectronico;	
	private String iIdUser;
	private String sUserSesion;
	private int iUsuarioHabilitado;	
	private int iIdPerfil;
	private int iIdPuesto;
	private int iIdMateria;
	private int iIdunidadAdministrativa;
	private int iIdDepartamento;
	private int iCambiarContrasenia;	
	private String sDescPerfil;
	   
	public String getsUsuario() { return sUsuario; }
	public void setsUsuario(String sUsuario) { this.sUsuario = sUsuario; }
	   
	public String getiContrasenia() { return iContrasenia; }
	public void setiContrasenia(String iContrasenia) { this.iContrasenia = iContrasenia; }
	
	public String getsNombre() { return sNombre; }
	public void setsNombre(String sNombre) { this.sNombre = sNombre; }
	
	public String getsApellidoPaterno() { return sApellidoPaterno; }
	public void setsApellidoPaterno(String sApellidoPaterno) { this.sApellidoPaterno = sApellidoPaterno; }
	
	public String getsApellidoMaterno() { return sApellidoMaterno; }
	public void setsApellidoMaterno(String sApellidoMaterno) { this.sApellidoMaterno = sApellidoMaterno; }
	
	public String getsCorreoElectronico() { return sCorreoElectronico; }
	public void setsCorreoElectronico(String sCorreoElectronico) { this.sCorreoElectronico = sCorreoElectronico; }
	
	public String getiIdUser() { return iIdUser; }
	public void setiIdUser(String iIdUser) {  this.iIdUser = iIdUser; }
	
	public String getsUserSesion() { return sUserSesion; }
	public void setsUserSesion(String sUserSesion) { this.sUserSesion = sUserSesion; }
	
	public int getiUsuarioHabilitado() { return iUsuarioHabilitado; }
	public void setiUsuarioHabilitado(int iUsuarioHabilitado) { this.iUsuarioHabilitado = iUsuarioHabilitado; }
	
	public int getiIdPerfil() { return iIdPerfil; }
	public void setiIdPerfil(int iIdPerfil) { this.iIdPerfil = iIdPerfil; }
	
	public int getiIdPuesto() { return iIdPuesto; }
	public void setiIdPuesto(int iIdPuesto) { this.iIdPuesto = iIdPuesto; }
	
	public int getiIdMateria() { return iIdMateria; }
	public void setiIdMateria(int iIdMateria) { this.iIdMateria = iIdMateria; }
	
	public int getiIdunidadAdministrativa() { return iIdunidadAdministrativa; }
	public void setiIdunidadAdministrativa(int iIdunidadAdministrativa) { this.iIdunidadAdministrativa = iIdunidadAdministrativa; }
	
	public int getiIdDepartamento() { return iIdDepartamento; }
	public void setiIdDepartamento(int iIdDepartamento) { this.iIdDepartamento = iIdDepartamento; }
	
	public int getiCambiarContrasenia() { return iCambiarContrasenia; }
	public void setiCambiarContrasenia(int iCambiarContrasenia) { this.iCambiarContrasenia = iCambiarContrasenia; }
	
	public String getsDescPerfil() { return sDescPerfil; }
	public void setsDescPerfil(String sDescPerfil) { this.sDescPerfil = sDescPerfil; }

	public JavaMail getEmail() { return email; }
	public void setEmail(JavaMail email){ this.email=email; }
	
	public UsuarioDAOImpl getUsuarioDAOImpl() { return usuarioDAOImpl; }
	public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) { this.usuarioDAOImpl = usuarioDAOImpl; }
	
	/**
	 * Constructor de la clase.
	 */
	public UsuarioBeanImpl(){}
	
	public boolean actualizaMiPerfil(UsuariosBeanImpl usuariosBeanImpl) throws SraajException {
		   boolean res;		   
		   try{			 
				    //res = usuarioDAOImpl.actualizaMiPerfil(usuariosBeanImpl);
					return false;
			}
		catch (Exception daoEx){
			throw new SraajException(daoEx.getMessage(), daoEx);
		}
	}
	
	public UsuariosBeanImpl obtieneInfoUser(String sUser) throws SraajException {
		 
		   UsuariosBeanImpl userInfo = null;
		
		   try { userInfo = usuarioDAOImpl.obtieneInfoUsuario(sUser); }
		   catch (Exception e) { e.printStackTrace(); }		   
		   
		   return userInfo;
		   
	}
	@Override
	public boolean actualizaMiPerfil(UsuarioBeanImpl info)
			throws SraajException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
