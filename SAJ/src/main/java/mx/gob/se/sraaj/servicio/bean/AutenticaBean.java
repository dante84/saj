package mx.gob.se.sraaj.servicio.bean;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;


public interface AutenticaBean {
	 
       public SesionBeanImpl ingresaUsuario(String usuario,String contraseña) throws Exception;
	
	   public Map<String, List<MenuBean>> obtieneMenus(List<MenuBean> permDB);
	
	   public String asignaNuevaPwd(LoginBean loginDTO) throws Exception;

}
