package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name="CAgrario")
@SessionScoped

public class ControladorAgrario implements Serializable
{
	private static final long serialVersionUID = 1L;


	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	
	private String rdoAmparo;
	private Date fechaBusqueda;
	private List<SeguimientoBean> datosSeguimiento;
	private List<CatMateriaBean> materias;
	private CatMateriaBean materia;
	private Date fechaconven;
	private Date fechaVencimiento;
	private String style;
	private String txtBusqueda;
	private List<CatTribunalBean> tribunales;
	private CatTribunalBean tribunal;
	int idjuicio;
	
	
	
	//seguimiento
	private String txtBusquedaSeg;
	private String estatusS;
	private List<SeguimientoJuiciosBean> datosSeguimientoAgrario;
	private String expinterno;
	
	
	
	
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
		return cargar();
	}
	
	public String cargar()
	{				
		llenaMateria();
		llenaTribunal();
		
		llenaTabla(getFechaBusqueda(), getTxtBusqueda(), "1");		
		doMuestraTurnados();
		return "juicioAgrario";
	}
	
	public void llenaTribunal()
	{
		try {
			setTribunales(seguimientoDAOImpl.obtenerTribunal());
		} catch (SraajException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		llenaTabla(getFechaBusqueda(), null, "1");
	}
	
	public void busquedaPorTexto()
	{
		llenaTabla(null, getTxtBusqueda(),"1");
	}
	
	
	public void onRowEdit(RowEditEvent event) 
	{
		FacesMessage msg = new FacesMessage("Registro Editado", ((SeguimientoBean) event.getObject()).getIdregDoc().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		Integer mate = null;
		String desMate = null;
        java.sql.Date v = null;
        Integer idreg =  null;
        Integer idtribunal = null;
        String t = null;
        
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
		
		if(getTribunal() != null)
		{
			idtribunal = getTribunal().getIdTribunal();
			t = getTribunal().getDecripcion();
		}
		else
		{
			if(((SeguimientoBean)event.getObject()).getIdtribunal()!= 0)
			{
				idtribunal = ((SeguimientoBean)event.getObject()).getIdtribunal(); 
				t = ((SeguimientoBean)event.getObject()).getDescripcion(); 
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
		System.out.println("fecha vencimiento " + v);
		System.out.println("id registro " + idreg);
		System.out.println("id tribunal " + idtribunal);
		System.out.println("descripcion tribunal " + t);
		
		try 
		{
			seguimientoDAOImpl.actualizarJuicioAgrario(idreg, mate, idtribunal, v);
			
			System.out.println("actualizacion correcta");
		} 
		catch (SraajException e) 
		{
			System.out.println("actualizacion incorrecta"); 
			e.printStackTrace();
		}
		
		((SeguimientoBean)event.getObject()).setDescmateria(desMate);
		((SeguimientoBean)event.getObject()).setDescripcion(t);
		((SeguimientoBean)event.getObject()).setFecvencimiento(v);
		
    }
	
	public void onRowCancel(RowEditEvent event) 
	{
		
    }

	
	//seguimiento
	
	public String cargarSeguimiento()
	{
		System.out.println("bubis");
		
		
	    llenaSeguimiento(null);
		return "seguimientoAgrario";
	}
	
	public void llenaSeguimiento(String txt)
	{
		try 
		{
			setDatosSeguimientoAgrario(seguimientoDAOImpl.obtenerSeguimientoJuicios(txt,1));
		} 
		catch (SraajException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		SeguimientoJuiciosBean x = null;
//		for (int i = 0; i< datosSeguimientoAgrario.size(); i++) 
//		{
//			if(getDatosSeguimientoAgrario().get(i).getNumjuicio() == 0)
//			{
//				x = getDatosSeguimientoAgrario().get(i);
//				x.setNumjuicio(null);
//				datosSeguimientoAgrario.set(i, x);	
//				x = null;
//			}
//		}			
		
	}
	
	
	public void busquedaPorTextoSeg()
	{
		llenaSeguimiento(getTxtBusquedaSeg());
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

	
	
	
	//gets and sets
	public String getRdoAmparo() {
		return rdoAmparo;
	}


	public void setRdoAmparo(String rdoAmparo) {
		this.rdoAmparo = rdoAmparo;
	}

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

	public List<CatTribunalBean> getTribunales() {
		return tribunales;
	}

	public void setTribunales(List<CatTribunalBean> tribunales) {
		this.tribunales = tribunales;
	}

	public CatTribunalBean getTribunal() {
		return tribunal;
	}

	public void setTribunal(CatTribunalBean tribunal) {
		this.tribunal = tribunal;
	}

	public int getIdjuicio() {
		return idjuicio;
	}

	public void setIdjuicio(int idjuicio) {
		this.idjuicio = idjuicio;
	}


	public String getTxtBusquedaSeg() {
		return txtBusquedaSeg;
	}

	public void setTxtBusquedaSeg(String txtBusquedaSeg) {
		this.txtBusquedaSeg = txtBusquedaSeg;
	}

	public String getEstatusS() {
		return estatusS;
	}

	public void setEstatusS(String estatusS) {
		this.estatusS = estatusS;
	}

	public String getExpinterno() {
		return expinterno;
	}

	public void setExpinterno(String expinterno) {
		this.expinterno = expinterno;
	}

	public List<SeguimientoJuiciosBean> getDatosSeguimientoAgrario() {
		return datosSeguimientoAgrario;
	}

	public void setDatosSeguimientoAgrario(
			List<SeguimientoJuiciosBean> datosSeguimientoAgrario) {
		this.datosSeguimientoAgrario = datosSeguimientoAgrario;
	}
	
	//turnar documento
	
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
	   setTurnados(gestionaCatDAOImpl.obtieneTurnados(1).toArray());
	   System.out.println(turnados.length);
	  } catch (SraajException e) {
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
	     System.out.println("Puesto del Usuario del Turnado === >>   " + getCgbTurna().getsDescripcionCat());
	     setLblCargo(getCgbTurna().getsDescripcionCat());         
	     
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  
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
