package mx.gob.se.sraaj.transferencia.beanImpl;

import javax.faces.bean.ManagedProperty;

import mx.gob.se.sraaj.persistencia.daoImpl.UsuarioDAOImpl;

public class UsuariosBeanImpl {
	
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
	   private int iIdunidadAdministrativa;
	   private int iIdDepartamento;
	   private int iCambiarContrasenia;	
	   private String sDescPerfil;
	
	public UsuarioDAOImpl getUsuarioDAOImpl() { return usuarioDAOImpl; }
	public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) { this.usuarioDAOImpl = usuarioDAOImpl; }
	
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
	public void setiIdUser(String iIdUser) { this.iIdUser = iIdUser; }
	
	public String getsUserSesion() { return sUserSesion; }
	public void setsUserSesion(String sUserSesion) { this.sUserSesion = sUserSesion; }
	
	public int getiUsuarioHabilitado() { return iUsuarioHabilitado; }
	public void setiUsuarioHabilitado(int iUsuarioHabilitado) { this.iUsuarioHabilitado = iUsuarioHabilitado; }
	
	public int getiIdPerfil() { return iIdPerfil; }
	public void setiIdPerfil(int iIdPerfil) { this.iIdPerfil = iIdPerfil; }
	
	public int getiIdPuesto() { return iIdPuesto; }
	public void setiIdPuesto(int iIdPuesto) { this.iIdPuesto = iIdPuesto; }
	
	public int getiIdunidadAdministrativa() { return iIdunidadAdministrativa; }
	public void setiIdunidadAdministrativa(int iIdunidadAdministrativa) { this.iIdunidadAdministrativa = iIdunidadAdministrativa; }
	
	public int getiIdDepartamento() { return iIdDepartamento; }
	public void setiIdDepartamento(int iIdDepartamento) { this.iIdDepartamento = iIdDepartamento; }
	
	public int getiCambiarContrasenia() { return iCambiarContrasenia; }
	public void setiCambiarContrasenia(int iCambiarContrasenia) { this.iCambiarContrasenia = iCambiarContrasenia; }
	
	public String getsDescPerfil() { return sDescPerfil; }
	public void setsDescPerfil(String sDescPerfil) { this.sDescPerfil = sDescPerfil; }


}
