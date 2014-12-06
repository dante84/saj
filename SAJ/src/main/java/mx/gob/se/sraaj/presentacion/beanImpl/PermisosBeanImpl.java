package mx.gob.se.sraaj.presentacion.beanImpl;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.MenuBean;

public class PermisosBeanImpl {
	
	   private String key;
	   private List<MenuBean> listaMenu;
	   
	   public String getKey() { return key; }
	   
	   public void setKey(String key) { this.key = key; }
	   
	   public List<MenuBean> getListaMenu() { return listaMenu; }
	   
	   public void setListaMenu(List<MenuBean> listaMenu) { this.listaMenu = listaMenu; }
	   
}
