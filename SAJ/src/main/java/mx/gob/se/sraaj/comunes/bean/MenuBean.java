package mx.gob.se.sraaj.comunes.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuBean {
	 
  	   private int iIdMenu;
	   private String descMenu;
	   private String descSubMenu;
	   private String pathMenu;
	   private int iStatus;
	   
	   public int getiIdMenu() { return iIdMenu; }
	   
	   public void setiIdMenu(int iIdMenu) { this.iIdMenu = iIdMenu; }
	   
	   public String getDescMenu() { return descMenu; }
	
	   public void setDescMenu(String descMenu) { this.descMenu = descMenu; }
	
	   public String getDescSubMenu() { return descSubMenu; }
	   
	   public void setDescSubMenu(String descSubMenu) { this.descSubMenu = descSubMenu; }
	
	   public String getPathMenu() { return pathMenu; }
	   
	   public void setPathMenu(String pathMenu) { this.pathMenu = pathMenu; }
	   
	   public int getiStatus() { return iStatus; }
	   
	   public void setiStatus(int iStatus) { this.iStatus = iStatus; }
		   
}
