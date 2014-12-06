package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatGralBean;
import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.comunes.bean.PerfilBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.AdministracionDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.MenusDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.PerfilDAOImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;

@ManagedBean(name = "CAdministracion")
@SessionScoped
public class ControladorAdministracion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CatGeneralBean> perfiles;
	private List<MenuBean> permisos;
	private List<CatGralBean> menuPerfil;
	private List<PerfilBean> perfil;
	private List<SelectItem> valores;
	
	private CatGralBean catGralBean;
	
	private String sDescripcionCat;
	private String sIdPerfil;

	private String[] selPerfil;
	
	@ManagedProperty(value="#{administracionDAOImpl}")
	private AdministracionDAOImpl administracionDAOImpl;
	
	@ManagedProperty(value="#{sesionBean}")
	private SesionBeanImpl sesionBean;
	
	@ManagedProperty(value="#{gestionacatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;
	
	@ManagedProperty(value="#{menusDAOImpl}")
	private MenusDAOImpl menusDAOImpl;
	
	@ManagedProperty(value="#{perfilDAOImpl}")
	private PerfilDAOImpl perfilDAOImpl;
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
	public List<CatGeneralBean> getPerfiles() { return perfiles; }
	public void setPerfiles(List<CatGeneralBean> perfiles) { this.perfiles = perfiles; }

	public List<MenuBean> getPermisos() { return permisos; }
	public void setPermisos(List<MenuBean> permisos) { this.permisos = permisos; }

	public List<CatGralBean> getMenuPerfil() { return menuPerfil; }
	public void setMenuPerfil(List<CatGralBean> menuPerfil) { this.menuPerfil = menuPerfil; }

	public List<PerfilBean> getPerfil() { return perfil; }
	public void setPerfil(List<PerfilBean> perfil) { this.perfil = perfil; }

	public List<SelectItem> getValores() { return valores; }
	public void setValores(List<SelectItem> valores) { this.valores = valores; }

	public CatGralBean getCatGralBean() { return catGralBean; }
	public void setCatGralBean(CatGralBean catGralBean) { this.catGralBean = catGralBean; }
	
	public String getsDescripcionCat() { return sDescripcionCat; }
	public void setsDescripcionCat(String sDescripcionCat) { this.sDescripcionCat = sDescripcionCat; }

	public String getsIdPerfil() { return sIdPerfil; }
	public void setsIdPerfil(String sIdPerfil) { this.sIdPerfil = sIdPerfil; }

	public String[] getSelPerfil() { return selPerfil; }
	public void setSelPerfil(String[] selPerfil) { this.selPerfil = selPerfil; }

	public AdministracionDAOImpl getAdministracionDAOImpl() { return administracionDAOImpl; }
	public void setAdministracionDAOImpl(AdministracionDAOImpl administracionDAOImpl) { this.administracionDAOImpl = administracionDAOImpl; }

	public SesionBeanImpl getSesionBean() { return sesionBean; }
	public void setSesionBean(SesionBeanImpl sesionBean) { this.sesionBean = sesionBean; }
	
	public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }

	public MenusDAOImpl getMenusDAOImpl() { return menusDAOImpl; }
	public void setMenusDAOImpl(MenusDAOImpl menusDAOImpl) { this.menusDAOImpl = menusDAOImpl; }

	public PerfilDAOImpl getPerfilDAOImpl() { return perfilDAOImpl; }
	public void setPerfilDAOImpl(PerfilDAOImpl perfilDAOImpl) { this.perfilDAOImpl = perfilDAOImpl; }

	/**
	 * Mehtods
	 */
	public String muestraPerfiles() {
		try  {
			setPerfiles(administracionDAOImpl.obtienePerfiles());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "perfiles";
	}
	
	public String editarPerfil(String x, String y ){
		   
		   try{
			   
			   setsIdPerfil(x);
			   setsDescripcionCat(y);			
			   setPermisos(menusDAOImpl.obtenMenus());
			   setPerfil(perfilDAOImpl.buscaPermisos(x));
			   List<PerfilBean> lTemp = perfilDAOImpl.buscaPermisos(x);
			   String[] sTemp = new String[10];
			   
			   for( PerfilBean pb : lTemp ){
				    String temp = pb.getsPermisos();				 
				    for( int k = 0,j = 0; k < temp.length(); k++ ){					 
				         if( temp.charAt(k) != ',' ){
				             sTemp[j]= String.valueOf(temp.charAt(k));
  				             System.out.println(sTemp[j]);
				             j++;
				         }
				    }
			   }
			   
			   setSelPerfil(sTemp);
			   
		   } catch (SraajException e) { e.printStackTrace(); }
		   
		   return "modPerfil";
		   
	}
	
	public String actualizarPerfil(){

		String vId, vActivo, vDescripcion, vUsuario, vPermisos;
		
		try {
			String cda = "";
			for(int k=0;k < selPerfil.length;k++){
				if(k <= selPerfil.length){
				    cda += selPerfil[k] + ",";
				}
				else{
					cda += selPerfil[k];
				}
			}
			
			vId=sIdPerfil;
			vActivo = "1";
			vDescripcion = sDescripcionCat;
			vUsuario = sesionBean.getsUser();
			vPermisos = cda;

			gestionaCatDAOImpl= new GestionaCatDAOImpl();
			gestionaCatDAOImpl.modificarPer(vId, vActivo, vDescripcion, vPermisos, vUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "perfiles";
	}
	
	public String imprime(){
		
		String Id, Activo, Descripcion, Usuario, Permisos; 
		
		String cda = "";
		for(int k=0;k<selPerfil.length;k++){
			if(k <= selPerfil.length){
			cda += selPerfil[k];
			}
			else{
				cda += selPerfil[k] + ",";
			}
		}
		
		Id=sIdPerfil;
		Activo = "1";
		Descripcion = sDescripcionCat;
		Usuario = sesionBean.getsUser();
		Permisos = cda;	
		
		return "perfiles";
		
	}
}
