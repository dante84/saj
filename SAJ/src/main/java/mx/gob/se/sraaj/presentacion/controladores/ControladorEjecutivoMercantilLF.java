package mx.gob.se.sraaj.presentacion.controladores;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfWriter;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.HistorialDocumentoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.BitacoraDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

import org.primefaces.model.UploadedFile;


@SuppressWarnings("unused")
@ManagedBean(name="CAsuntosJuridicosEjecMerLF")
@SessionScoped
public class ControladorEjecutivoMercantilLF  implements Serializable {

private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	
	private String rdoEjecMerc;	
	private Date fechaBusqueda;
	private List<SeguimientoBean> datosSeguimiento;
	private List<CatMateriaBean> materias;
	private CatMateriaBean materia;
	private Date fechaconven;
	private Date fechaVencimiento;
	private String style;
	private String txtBusqueda;
	
	
	//Seguimiento Ejecutivo Mercantil Local y Foraneo 
	private String rdoSeguimientoMercLF;		
	public String getRdoSeguimientoMercLF() { return rdoSeguimientoMercLF; }
	public void setRdoSeguimientoMercLF(String rdoSeguimientoMercLF) { this.rdoSeguimientoMercLF = rdoSeguimientoMercLF; }
	
	private String txtBusquedaSeg;
	public String getTxtBusquedaSeg() { return txtBusquedaSeg; }
	public void setTxtBusquedaSeg(String txtBusquedaSeg) { this.txtBusquedaSeg = txtBusquedaSeg;}
	
	private String busquedaPorTextoSeg;	
	public String getBusquedaPorTextoSeg() { return busquedaPorTextoSeg; }
	public void setBusquedaPorTextoSeg(String busquedaPorTextoSeg) {this.busquedaPorTextoSeg = busquedaPorTextoSeg;}
	
	private List<SeguimientoJuiciosBean> datosSeguimientoEJMLF;
	public List<SeguimientoJuiciosBean> getDatosSeguimientoEJMLF() { return datosSeguimientoEJMLF;}
	public void setDatosSeguimientoEJMLF(List<SeguimientoJuiciosBean> datosSeguimientoEJMLF) {this.datosSeguimientoEJMLF = datosSeguimientoEJMLF;}
	
	private String expinterno;	
	public String getExpinterno() { return expinterno; }
	public void setExpinterno(String expinterno) { this.expinterno = expinterno; }
	
	private String estatusS;	
	public String getEstatusS() {return estatusS;}
	public void setEstatusS(String estatusS) {this.estatusS = estatusS;}

	public void busquedaPorTextoSeg()
	{
		llenaSeguimientoEMLF(getTxtBusquedaSeg());
	}
	
	public String load()	
	{
		txtBusqueda = null;
		fechaBusqueda = null;
		datosSeguimiento = null;
		materias = null;
		materia = null;
		fechaconven = null;
		fechaVencimiento = null;
		txtBusqueda = null;
		return cargarEjecutivoLF();
	}
	
	public String cargarEjecutivoLF()
	{
		if(rdoEjecMerc == null)
		{
			setRdoEjecMerc("14");			
		}
				
		llenaMateria();	
		llenaTabla(getFechaBusqueda(), getTxtBusqueda(), getRdoEjecMerc());
		
		System.out.println("Muestra Turnados Ejecutivos Mercantiles Foraneos.... ===== >>>>>");
		doMuestraTurnados();
		System.out.println("Muestra Turnados Ejecutivos Mercantiles Locales.... ===== >>>>>");
		
		return "EjecutivoMercantilLF";
	}
	
	
	public void llenaMateria()
	{
		try {
			setMaterias(seguimientoDAOImpl.obtenerMaterias());
			System.out.println(materias.size());
		} catch (SraajException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenaTabla(Date fecha, String txt, String idjuicio)
	{
		System.out.println("llenaTabla fecha de entrada busqueda <--- " + fecha);
		System.out.println("llenaTabla texto de entrada busqueda <--- " + txt);
		System.out.println("llenaTabla tipo juicio busqueda <--- " + idjuicio);
		
		java.sql.Date sqlfecha;
		
		try
		{
			sqlfecha = new java.sql.Date(fecha.getTime());
		}
		catch (Exception e) 
		{
			sqlfecha = null;
		}
		
		try 
		{
			setDatosSeguimiento(seguimientoDAOImpl.obtenerSeguimiento(sqlfecha, txt,Integer.parseInt(idjuicio)));
			
			
			SeguimientoBean x = null;
			for (int i = 0; i< datosSeguimiento.size(); i++) 
			{
				if(getDatosSeguimiento().get(i).getNumexpediente() == 0)
				{
					x = getDatosSeguimiento().get(i);
					x.setNumexpediente(null);
					datosSeguimiento.set(i, x);	
					
					if(getDatosSeguimiento().get(i).getNumreg() == 0)
					{
						x.setNumreg(null);
						datosSeguimiento.set(i, x);	
					}
					x = null;
				}
			}			
		} 
		catch (SraajException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void busquedaPorFecha()
	{
		llenaTabla(getFechaBusqueda(), null, getRdoEjecMerc());
	}
	
	public void busquedaPorTexto()
	{
		llenaTabla(null, getTxtBusqueda(), getRdoEjecMerc());
	}
	
	
	public void onRowEdit(RowEditEvent event) 
	{
		FacesMessage msg = new FacesMessage("Registro Editado", ((SeguimientoBean) event.getObject()).getIdregDoc().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		Integer mate = null;
		String desMate = null;
		java.sql.Date c = null;
        java.sql.Date v = null;
        Integer idreg =  null;
        
        idreg = ((SeguimientoBean)event.getObject()).getIdregDoc();
		
		if(getMateria() != null)
		{
			mate = getMateria().getIdmateria();
			desMate = getMateria().getDescmateria();
		}
		else
		{
			if(((SeguimientoBean)event.getObject()).getIdmateria() != 0)
			{
				mate = ((SeguimientoBean)event.getObject()).getIdmateria();
				desMate = ((SeguimientoBean)event.getObject()).getDescmateria();
			}			
		}
		
		if(getFechaconven() != null)
		{
			c = new java.sql.Date(getFechaconven().getTime());
		}
		else
		{
			if(((SeguimientoBean)event.getObject()).getFecconvencional() != null)
			{
				c = new java.sql.Date(((SeguimientoBean)event.getObject()).getFecconvencional().getTime());
			}
		}
		
		if(getFechaVencimiento() != null)
		{
			v = new java.sql.Date(getFechaVencimiento().getTime());
		}
		else
		{
			if(((SeguimientoBean)event.getObject()).getFecvencimiento() != null)
			{
				v = new java.sql.Date(((SeguimientoBean)event.getObject()).getFecvencimiento().getTime());
			}
		}
		System.out.println("datos a guardar");
		System.out.println("id materia " + mate);
		System.out.println("fecha convencional " + c);
		System.out.println("fecha vencimiento " + v);
		System.out.println("id registro " + idreg);
		
		try 
		{
			seguimientoDAOImpl.actualizarAsuntosJuridicos(idreg, mate, c, v);
			
			System.out.println("actualizacion correcta");
		} 
		catch (SraajException e) 
		{
			System.out.println("actualizacion incorrecta"); 
			e.printStackTrace();
		}
		
		((SeguimientoBean)event.getObject()).setDescmateria(desMate);
		((SeguimientoBean)event.getObject()).setFecconvencional(c);
		((SeguimientoBean)event.getObject()).setFecvencimiento(v);
		
    }
	
	public void onRowCancel(RowEditEvent event) 
	{
		
    }

	
	
	
	
	
	//gets and sets
	
	public String getRdoEjecMerc() {return rdoEjecMerc;}
	public void setRdoEjecMerc(String rdoEjecMerc) {this.rdoEjecMerc = rdoEjecMerc;}
		
	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public List<SeguimientoBean> getDatosSeguimiento() {
		return datosSeguimiento;
	}

	public void setDatosSeguimiento(List<SeguimientoBean> datosSeguimiento) {
		this.datosSeguimiento = datosSeguimiento;
	}

	public SeguimientoDAOImpl getSeguimientoDAOImpl() {
		return seguimientoDAOImpl;
	}

	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) {
		this.seguimientoDAOImpl = seguimientoDAOImpl;
	}

	
	public Date getFechaconven() {
		return fechaconven;
	}

	public void setFechaconven(Date fechaconven) {
		this.fechaconven = fechaconven;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public List<CatMateriaBean> getMaterias() {
		return materias;
	}

	public void setMaterias(List<CatMateriaBean> materias) {
		this.materias = materias;
	}

	public CatMateriaBean getMateria() {
		return materia;
	}

	public void setMateria(CatMateriaBean materia) {
		this.materia = materia;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(String txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}
	
	
	//Seguimiento Ejecutivo Mercantil Local y Foraneo 
	public String cargarSeguimientoEMLF()
	{
		System.out.println("Seguimiento Ejecutivo Mercantil Local y Forane....");		
		if(rdoSeguimientoMercLF == null)
		{
			setRdoSeguimientoMercLF("14");
		}
	    llenaSeguimientoEMLF(null);
		return "SeguimientoEjcMercantilLF";
	}
	
	public void llenaSeguimientoEMLF(String txt)
	{
		try 
		{
			setDatosSeguimientoEJMLF(seguimientoDAOImpl.obtenerSeguimientoJuicios(txt,Integer.parseInt(getRdoSeguimientoMercLF())));
		} 
		catch (SraajException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}
	
	public void onRowEditSeg(RowEditEvent event)
	{
		String expedienteI = null;
		String estatus = null;
		Integer idregS = null;
		
		 idregS = ((SeguimientoJuiciosBean)event.getObject()).getIdregdoc();
			
			if(expinterno != null)
			{
				expedienteI = getExpinterno();
			}
			else
			{
				if(((SeguimientoJuiciosBean)event.getObject()).getExpinterno() != "")
				{
					expedienteI = ((SeguimientoJuiciosBean)event.getObject()).getExpinterno();
				}			
			}
			
			if(estatusS != null)
			{
				estatus = getEstatusS();
			}
			else
			{
				if(((SeguimientoJuiciosBean)event.getObject()).getEstatus() != "")
				{
					estatus = ((SeguimientoJuiciosBean)event.getObject()).getEstatus();
				}			
			}
		
			
		System.out.println(idregS);
		System.out.println(estatus);
		System.out.println(expedienteI);
			
		try 
		{
			seguimientoDAOImpl.actualizarAmparoAgrarioSegSP(idregS, expedienteI, estatus);
			System.out.println("actualizacion correcta");
		} 
		catch (SraajException e) 
		{
			System.out.println("actualizacion incorrecta");
			e.printStackTrace();
		}
		
		((SeguimientoJuiciosBean)event.getObject()).setEstatus(estatus);
		((SeguimientoJuiciosBean)event.getObject()).setExpinterno(expedienteI);
		
		expedienteI = null;
		estatusS = null;
		expinterno = null;
		estatus = null; 
		
	}
	
	public void onRowCancelSeg()
	{
		
	}
	
	
	
	//Cargar Turnados
	private Object[] turnados;	
	public Object[] getTurnados() {return turnados;}
	public void setTurnados(Object[] turnados) {this.turnados = turnados;}
	
	private Object[] lstPuestos;	
	public Object[] getLstPuestos() { return lstPuestos;}
	public void setLstPuestos(Object[] lstPuestos) {this.lstPuestos = lstPuestos;}


	private String cmbTurnado;	
	public String getCmbTurnado() {return cmbTurnado;}
	public void setCmbTurnado(String cmbTurnado) {this.cmbTurnado = cmbTurnado;}


	@ManagedProperty(value="#{gestionaCatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;	  
	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
		
	public void doMuestraTurnados()  {		   		      	      		      		      	
		try {
						
			System.out.println("Entra al Obtener los Turnados.... " +  getRdoEjecMerc());			
			setTurnados(gestionaCatDAOImpl.obtieneTurnados(Integer.parseInt(getRdoEjecMerc())).toArray());
			System.out.println(turnados.length);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	private CatGeneralBean cgbTurna;
	public CatGeneralBean getCgbTurna() {return cgbTurna;}
	public void setCgbTurna(CatGeneralBean cgbTurna) {this.cgbTurna = cgbTurna;}
	
	private String lblCargo;
	public String getLblCargo() {return lblCargo;}
	public void setLblCargo(String lblCargo) {this.lblCargo = lblCargo;}

	public void doCargaPuesto(){
		try {			 
			  System.out.println("Id del Usuario del Turnado === >>   " + getCgbTurna().getsIdCat());
			  System.out.println("Puesto del Usuario del Turnado === >>   " + getCgbTurna().getsDescripcionCat2());
			  setLblCargo(getCgbTurna().getsDescripcionCat2());			 			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	//Historicos, segumientos y Bitacoras
	
	
		@ManagedProperty(value="#{bitacoraDAOImpl}")
	    private BitacoraDAOImpl bitacoraDAOImpl;

	   public BitacoraDAOImpl getBitacoraDAOImpl() { return bitacoraDAOImpl; }
	   public void setBitacoraDAOImpl(BitacoraDAOImpl bitacoraDAOImpl) { this.bitacoraDAOImpl = bitacoraDAOImpl;}
		
		List<HistorialDocumentoBean> histDoc;
		
		public List<HistorialDocumentoBean> getHistDoc() { return histDoc; }
	    public void setHistDoc(List<HistorialDocumentoBean> histDoc) { this.histDoc = histDoc; }
	    //private List<DocumentoBean> listaDocumentos;
	    DocumentoBean doc;
	    
	    public String CargarBitacora(Integer idDRegDoc)
	    {
	    	System.out.println("Cargando inform... de la Bitacora!!!");
	     try 
	     {
	    	 setHistDoc(bitacoraDAOImpl.obtenerHistorialDoc(idDRegDoc));
	    	 System.out.println("lleno bitacora");    	
	     }  
	     catch (SraajException e) 
	     {
	    	 e.printStackTrace();
	     }
	     return "consultaDocVst";
	    }
	
		  /// imagen del Status Turnado	    
		 public String obtenerImg(String x)
		 {
		  int numero = Integer.parseInt(x);
		  System.out.println(numero);
		  if(numero == 1)
		  {
		   System.out.println("entro");
		   return "okdocenpoder.png";
		  }
		  else
		  {
		   return "DocEnSupoderNegro.png";
		  }
		 }
	
	

}
