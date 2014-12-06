package mx.gob.se.sraaj.transferencia.beanImpl;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.MenuBean;

public class AccesoBean {
	 
	   private List<MenuBean> menus;
	   private ErrorBDBean errorBD;
	   
	   public List<MenuBean> getMenus() { return menus; }
	   
	   public void setMenus(List<MenuBean> menus) {	this.menus = menus; }
	   
	   public ErrorBDBean getErrorBD() { return errorBD; }
	   
	   public void setErrorBD(ErrorBDBean errorBD) { this.errorBD = errorBD; }

}
