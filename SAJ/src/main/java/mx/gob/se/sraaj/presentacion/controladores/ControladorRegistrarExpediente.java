package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.ConsultaDescargoDocBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaExpedienteDAOImpl;


@ManagedBean (name="CRegExpediente")
@SessionScoped
public class ControladorRegistrarExpediente implements Serializable{
private static final long serialVersionUID = 1L;
	
	/**
	 * variables
	 */
	private List<ConsultaDescargoDocBean> lDescargo;
	private List<ConsultaDescargoDocBean> filteredDescargo;
	private List<CatGeneralBean> lcgbDescargo;
	
	private CatGeneralBean cgbDescargo;
	
	private String textoExpediente;
	private String textoResponsable;
	private String textoDocumento;
	private String textoBusqueda;
	
	private String[] descargos;
	private String[] descago;
	private String[] sDescripcionCat;
	
	
	private String cmbDescargo;
	private boolean cbTieneRegistro;
	private int idRegDoc;
	

	/**
	 * inyeccion de beans
	 */
	@ManagedProperty(value="#{gestionaCatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;
	
	@ManagedProperty(value="#{gestionaExpedienteDAOImpl}")
	private GestionaExpedienteDAOImpl gestionaExpedienteDAOImpl;

	/**
	 * consultaDocumentoDscargo.
	 * @return descargo.xhtml
	 * @throws SraajException
	 */
	public String consultaDocumentoDescargo() throws SraajException{
		  System.out.println("========>> en CRegExpediente.consultaDocumentoDescargo");
		  String ruta="descargo";
		  String busqueda = getTextoBusqueda();
		  try{
		   setlDescargo(gestionaExpedienteDAOImpl.consultaDocumentoDescargo(busqueda));
		   //llena combo para respuesta en tabla descargo.
		   setLcgbDescargo(gestionaCatDAOImpl.obtieneDescargo());
		  }
		  catch(Exception e){
		   e.printStackTrace();
		  }
		  return ruta;
		 }

	@SuppressWarnings("unused")
	public void onRowEdit(RowEditEvent event) {
		
        FacesMessage msg = new FacesMessage("Registro Editado", ((ConsultaDescargoDocBean) event.getObject()).getsNumeroOficio());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        int vDescargo,  vTieneRegistro, vIdRegDoc;
        String vExpediente , vDocumento;
        
        int x =  ((ConsultaDescargoDocBean) event.getObject()).getiIdRegDoc();
        setIdRegDoc(x);
        
        System.out.println("========>> idRegDoc " + idRegDoc);
    	System.out.println("========>> descripcion catalogo " + getCgbDescargo().getsDescripcionCat());
    	System.out.println("========>> expediente " + getTextoExpediente());
    	System.out.println("========>> tiene registro " + isCbTieneRegistro());
    	System.out.println("========>> docuemtnos " + getTextoDocumento());
    	

    	vIdRegDoc = getIdRegDoc();
    	vDescargo = getCgbDescargo().getsIdCat();
    	vExpediente = getTextoExpediente();
    	vTieneRegistro = isCbTieneRegistro() ? 1 : 0;  	
    	vDocumento = getTextoDocumento();
    	//vIdTurnado = 123;
    	String busqueda = getTextoBusqueda();
    	
    	try {
			gestionaCatDAOImpl.InsertarActualizarDescargo(vIdRegDoc, vDescargo, vExpediente, vTieneRegistro, vDocumento);
			setlDescargo(gestionaExpedienteDAOImpl.consultaDocumentoDescargo(busqueda));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((ConsultaDescargoDocBean) event.getObject()).getsNumeroOficio());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void insertarActualizarDescargo(){
    	System.out.println("========>> en CRegExpediente.insertaActualizaDescargo");
    }
    
	/**
	 * getter's and setter's
	 */
	public static long getSerialversionuid() { return serialVersionUID; }
	
	public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	
	public GestionaExpedienteDAOImpl getGestionaExpedienteDAOImpl() { return gestionaExpedienteDAOImpl; }
	public void setGestionaExpedienteDAOImpl( GestionaExpedienteDAOImpl gestionaExpedienteDAOImpl) { this.gestionaExpedienteDAOImpl = gestionaExpedienteDAOImpl; }
	
	public List<ConsultaDescargoDocBean> getlDescargo() { return lDescargo; }
	public void setlDescargo(List<ConsultaDescargoDocBean> lDescargo) { this.lDescargo = lDescargo; }

	public List<ConsultaDescargoDocBean> getFilteredDescargo() { return filteredDescargo; }
	public void setFilteredDescargo(List<ConsultaDescargoDocBean> filteredDescargo) { this.filteredDescargo = filteredDescargo; }

	public List<CatGeneralBean> getLcgbDescargo() { return lcgbDescargo; }
	public void setLcgbDescargo(List<CatGeneralBean> lcgbDescargo) { this.lcgbDescargo = lcgbDescargo; }
	
	public String getCmbDescargo() { return cmbDescargo; }
	public void setCmbDescargo(String cmbDescargo) { this.cmbDescargo = cmbDescargo; }
	
	public List<String> getDescargos(){ return Arrays.asList(descargos); }
	public void setDescargos(String[] descargos) { this.descargos = descargos; }

	public String[] getDescago() { return descago; } 
	public void setDescago(String[] descago) { this.descago = descago; 	}

	public String getTextoExpediente() { return textoExpediente; }
	public void setTextoExpediente(String textoExpediente) { this.textoExpediente = textoExpediente; }

	public String[] getsDescripcionCat() { return sDescripcionCat; }
	public void setsDescripcionCat(String[] sDescripcionCat) { this.sDescripcionCat = sDescripcionCat; }

	public CatGeneralBean getCgbDescargo() { return cgbDescargo; }
	public void setCgbDescargo(CatGeneralBean cgbDescargo) { this.cgbDescargo = cgbDescargo; }

	public boolean isCbTieneRegistro() { return cbTieneRegistro; }
	public void setCbTieneRegistro(boolean cbTieneRegistro) { this.cbTieneRegistro = cbTieneRegistro; }

	public String getTextoResponsable() { return textoResponsable; }
	public void setTextoResponsable(String textoResponsable) { this.textoResponsable = textoResponsable; }

	public int getIdRegDoc() { return idRegDoc; }
	public void setIdRegDoc(int idRegDoc) { this.idRegDoc = idRegDoc; }

	public String getTextoDocumento() { return textoDocumento; }
	public void setTextoDocumento(String textoDocumento) { this.textoDocumento = textoDocumento; }

	public String getTextoBusqueda() { return textoBusqueda; }
	public void setTextoBusqueda(String textoBusqueda) { this.textoBusqueda = textoBusqueda; }
}
