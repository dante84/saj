package mx.gob.se.sraaj.transferencia.beanImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.presentacion.beanImpl.PermisosBeanImpl;
import mx.gob.se.sraaj.transferencia.bean.SesionBean;

public class SesionBeanImpl implements Serializable,SesionBean{
	       
	   private static final long serialVersionUID = 1L;
	   
	   private String sUser;
	   private String sContrasenia;	
	   private String sNombreCompl;
	   private String sNombre;
	   private String sApellido1;	
	   private String sApellido2;	
	   private String sIp;	
	   private Map<String, List<MenuBean>> permisos;	
	   private String idSesion;	
	   private String sErrorDB;	
	   private String sDescError;	
	   private String sElimina;
	   private String correoElectronico;
	   private List<PermisosBeanImpl> permisosBean;
	   private String sCorreoElectronico;
	   
	   public String getsUser() { return sUser;	}
	   public void setsUser(String sUser) { this.sUser = sUser; }
	   
	   public String getsContrasenia() { return sContrasenia; }
	   public void setsContrasenia(String sContrasenia) { this.sContrasenia = sContrasenia; }
	   
	   public String getsNombreCompl() { return sNombreCompl; }
	   public void setsNombreCompl(String sNombreCompl) { this.sNombreCompl = sNombreCompl; }
	   
	   public String getsNombre() { return sNombre; }
	   public void setsNombre(String sNombre) { this.sNombre = sNombre; }
	   
	   public String getsApellido1() { return sApellido1; }
	   public void setsApellido1(String sApellido1) { this.sApellido1 = sApellido1; }
	
	   public String getsApellido2() { return sApellido2; }
	   public void setsApellido2(String sApellido2) { this.sApellido2 = sApellido2;	}
	
	   public String getsIp() { return sIp; }
	   public void setsIp(String sIp) { this.sIp = sIp; }
	   
	   public Map<String, List<MenuBean>> getPermisos() { return permisos; }
	   public void setPermisos(Map<String, List<MenuBean>> permisos) { this.permisos = permisos; }
	   
	   public String getIdSesion() { return idSesion; }
	   public void setIdSesion(String idSesion) { this.idSesion = idSesion; }
	   
	   public String getsErrorDB() { return sErrorDB; }
	   public void setsErrorDB(String sErrorDB) { this.sErrorDB = sErrorDB; }
	   
	   public String getsDescError() { return sDescError; }
	   public void setsDescError(String sDescError) { this.sDescError = sDescError; }
	   
	   public String getsElimina() { return sElimina; }
	   public void setsElimina(String sElimina) { this.sElimina = sElimina; }

	   public String getCorreoElectronico() { return correoElectronico; }
	   public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

	   public List<PermisosBeanImpl> getPermisosBean() { return permisosBean; }

	   public void setPermisosBean(List<PermisosBeanImpl> permisosBean) { this.permisosBean = permisosBean; }
	   
	   public String getsCorreoElectronico() { return sCorreoElectronico; }
	   public void setsCorreoElectronico(String sCorreoElectronico) { this.sCorreoElectronico = sCorreoElectronico; }
	   
	   
}