package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.servicio.beanImpl.CatGeneralBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.CatBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;

@ManagedBean (name="CCatalogos")
@SessionScoped
public class ControladorCatalogos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * variables
	 */
	private String comboCatalogos ;
	private List<CatGeneralBean> lCatalogos;
	private List<CatGeneralBean> lCat;
	
	private String puesto;
	private Object[] puestos;
	private String estado;
	private Object[] estados;
	private String circuito;
	private Object[] circuitos;
	private String catalogo;
	private Object[] catalogos;
	private CatBeanImpl cat;
	
	@ManagedProperty(value="#{gestionaCatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;
	
	@ManagedProperty(value="#{catGeneralBeanImpl}")
	private CatGeneralBeanImpl catGeneralBeanImpl;
	
	@ManagedProperty(value="#{catGeneralBean}")
	private CatGeneralBean catGeneralBean ;
	/**
	 * getter's and setter's
	 */
	
	public List<CatGeneralBean> getlCatalogos() { return lCatalogos; }
	public void setlCatalogos(List<CatGeneralBean> lCatalogos) { this.lCatalogos = lCatalogos; }
	
	public List<CatGeneralBean> getlCat() { return lCat; }
	public void setlCat(List<CatGeneralBean> lCat) { this.lCat = lCat; }
	
	public String getPuesto() { return puesto; }
	public void setPuesto(String puesto) { this.puesto = puesto; }
	
	public Object[] getPuestos() { return puestos; }
	public void setPuestos(Object[] puestos) { this.puestos = puestos; }
	
	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
	
	public Object[] getEstados() { return estados; }
	public void setEstados(Object[] estados) { this.estados = estados; }
	
	public String getCircuito() { return circuito; }
	public void setCircuito(String circuito) { this.circuito = circuito; }
	
	public String getComboCatalogos() { return comboCatalogos; }
	public void setComboCatalogos(String comboCatalogos) { this.comboCatalogos = comboCatalogos; }
	
	public String getCatalogo() { return catalogo; }
	public void setCatalogo(String catalogo) { this.catalogo = catalogo; }

	public Object[] getCatalogos() { return catalogos; }
	public void setCatalogos(Object[] catalogos) { this.catalogos = catalogos; }

	public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	
	public CatBeanImpl getCat() { return cat; }
	public void setCat(CatBeanImpl cat) { this.cat = cat; }
	
	public CatGeneralBeanImpl getCatGeneralBeanImpl() { return catGeneralBeanImpl; }
	public void setCatGeneralBeanImpl(CatGeneralBeanImpl catGeneralBeanImpl) { this.catGeneralBeanImpl = catGeneralBeanImpl; }
	
	public Object[] getCircuitos() { return circuitos; }
	public void setCircuitos(Object[] circuitos) { this.circuitos = circuitos; }
	
	public CatGeneralBean getCatGeneralBean() { return catGeneralBean; }
	public void setCatGeneralBean(CatGeneralBean catGeneralBean) { this.catGeneralBean = catGeneralBean; }
	
	
	public String doMuestraCatalogos () throws SraajException{
		String ruta ="catalogos";
		try{
			setlCatalogos(gestionaCatDAOImpl.obtieneCatalogos());
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return ruta;
	}
	
	public String  muestraCatalogo() throws SraajException{
//			setComboCatalogos(gestionaCatDAOImpl.obtieneCatalogos());
			try{

//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATCJF)){
						setlCat(gestionaCatDAOImpl.obtieneRepCJF());
//					}
//				if(getCatGeneralBean().getsIdCat().equals(Constantes.CAT_REMITENTE)){
//						setlCat(gestionaCatDAOImpl.obtieneRepRemitente()); 
//					}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATCIRCUITOS)){
//					setlCat(gestionaCatDAOImpl.obtieneRepCircuito());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATCLSDOCUMENTAL)){
//					setlCat(gestionaCatDAOImpl.obtieneRepClsDocumental());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATDELEGMETROPOLITANA)){
//					setlCat(gestionaCatDAOImpl.obtieneRepDelegMetropolitana());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATDEPARTAMENTO)){
//					setlCat(gestionaCatDAOImpl.obtieneRepDepartamento());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATINCIDENTESUSPENSION)){
//					setlCat(gestionaCatDAOImpl.obtieneRepIncidenteSuspension());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATINSTRUCCION)){
//					setlCat(gestionaCatDAOImpl.obtieneRepInstruccion());
//				}						
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATJUNTAESPECIAL)){
//					setlCat(gestionaCatDAOImpl.obtieneRepJuntaEspecial());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATJUNTALOCAL)){
//					setlCat(gestionaCatDAOImpl.obtieneRepJuntaLocal());
//				}					
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATJUZGADOSCONCILIACION)){
//					setlCat(gestionaCatDAOImpl.obtieneRepJuzgadosConciliacion());
//				}									
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATJUZGADOTRIBUNAL)){
//					setlCat(gestionaCatDAOImpl.obtieneRepJuzgadoTribunal());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATMATERIA)){
//					setlCat(gestionaCatDAOImpl.obtieneRepMateria());
//				}				
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATMINISTROINSTRUCTOR)){
//					setlCat(gestionaCatDAOImpl.obtieneRepMinistroInstructor());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATPGJ)){
//					setlCat(gestionaCatDAOImpl.obtieneRepPGJ());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATPGR)){
//					setlCat(gestionaCatDAOImpl.obtienePGR());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATPUESTO)){
//					setlCat(gestionaCatDAOImpl.obtieneRepPuesto());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATRESPONSABLE)){
//					setlCat(gestionaCatDAOImpl.obtieneRepResponsable());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATSALASCJN)){
//					setlCat(gestionaCatDAOImpl.obtieneRepSalaSCJN());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATSALASFISCALES)){
//					setlCat(gestionaCatDAOImpl.obtieneRepSalasFiscales());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATSALATRIBUNALCONCILIACION)){
//				setlCat(gestionaCatDAOImpl.obtieneRepSalaTribunalConciliacion());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATTRIBUNALESAGRARIOS)){
//				setlCat(gestionaCatDAOImpl.obtieneRepTribunalesAgrario());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATTIPOJUICIO)){
//				setlCat(gestionaCatDAOImpl.obtieneRepTipoJuicio());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATUNIDADADMINISTRATIVA)){
//				setlCat(gestionaCatDAOImpl.obtieneRepUnidadAdministrativa());
//				}
//				if(getCatGeneralBean().getsDescripcionCat().equals(Constantes.CAT_CATUNIDADESPECIALIZADA)){
//				setlCat(gestionaCatDAOImpl.obtieneRepUnidadEspecializada());
//				}				
				
				setlCatalogos(gestionaCatDAOImpl.obtieneCatalogos());
				
//				doMuestraCatalogos();
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
					return null;
	}
	
	public String doMuestraModificarCatalogo() throws SraajException{
		puestos = gestionaCatDAOImpl.obtienePuesto().toArray();
		estados = gestionaCatDAOImpl.obtieneEdos().toArray();
		//circuitos = gestionaCatDAOImpl.obtieneCircuito().toArray();
		return "modEntidad";
	}
	
	public void listener(){
		System.out.println("=========>> en listener");
	}
}
