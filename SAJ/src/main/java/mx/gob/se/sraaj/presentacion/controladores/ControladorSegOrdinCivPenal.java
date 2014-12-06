package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.PenalTblBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

import org.primefaces.event.RowEditEvent;


@ManagedBean(name="CSegOrdinCiv") 
@SessionScoped
public class ControladorSegOrdinCivPenal implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	private List<CatGenerico> catPenal;
	private CatGenerico penalSelect;
	private CatGenerico turnar;
	private List<CatGenerico> catTurnarA;
	private List<PenalTblBean> penalTbl;
	private java.sql.Date fechaBusqueda;
	private String txtBusqueda;
	private String indiciadoSelect;
	private Boolean bandera;

	private String  sintesisSelect;
	public String getSintesisSelect() { return sintesisSelect; }
	public void setSintesisSelect(String sintesisSelect) { this.sintesisSelect = sintesisSelect; }

	private Double importeSelect; 
	public Double getImporteSelect() { return importeSelect; }
	public void setImporteSelect(Double importeSelect) { this.importeSelect = importeSelect; }

	private java.sql.Date fecvencimientoSelect;
	private String estatusSelect;
	private List<String> instucciones;
	private String[] instruccionesSelect;
	
	public String Load()
	{
		llenacatpenal();
		llenaTurnado();
		CargarTabla(null,null,11);
		return "SegOrdinCivPenal";
	}
	
	public void CargarTabla(java.sql.Date fecha, String busqueda, Integer noJuicio)
	{
		try 
		{
			setPenalTbl(seguimientoDAOImpl.obtenerPenalTbl(fecha, busqueda, noJuicio));
		} 
		catch (SraajException e) 
		{
			System.out.println("Error al cargar la tabla seguimiento ordinario civil penal....");
			e.printStackTrace();
		}
	}
	
	public void llenaTurnado()
	{
		try 
		{
			setCatTurnarA(seguimientoDAOImpl.obtenerTurnarA());
		} 
		catch (SraajException e) 
		{
			System.out.println("Error al llenar turnar en Ordinario Civil Penal...");
			e.printStackTrace();
		}
	}
	
	public void llenacatpenal()
	{
		try 
		{
			setCatPenal(seguimientoDAOImpl.obtenerCatPenal());
		} 
		catch (SraajException e) 
		{
			System.out.println("Error al llenar turnar en Ordinario Civil Penal...");
			e.printStackTrace();
		}
	}
	
	
	public void listenerOtros()
	{
		
	}
	
	public void busquedaPorFecha()
	{
		
	}
	
	public void busquedaPorTexto()
	{
		
	}
	
	@SuppressWarnings("null")
	public void onRowEdit(RowEditEvent event) 
	{
		System.out.println("editar");						
		System.out.println("+++++++++++++++++++++++  Obteniendo Valores   +++++++++++++++++++++++");
		
		System.out.println(getSintesisSelect());
		System.out.println(getImporteSelect());
		System.out.println(getEstatusSelect());
				
		if(sintesisSelect != null){
			setSintesisSelect(getSintesisSelect());}	
		else{
			setSintesisSelect("");}
		
		if(importeSelect != null){
			setImporteSelect(getImporteSelect());}
		else{
			setImporteSelect(null);}
		
		if(estatusSelect != null){
			setEstatusSelect(getEstatusSelect());}
		else{
			setEstatusSelect("");}
		
		System.out.println("----------------------- Obteniendo Valores  --------------------------");
		
		System.out.println("======= >>>>>> " + getSintesisSelect());
		System.out.println("======= >>>>>> " + getImporteSelect());
		System.out.println("======= >>>>>> " + getEstatusSelect());
		
		@SuppressWarnings("unused")
		String st_sintes = null;
		
		@SuppressWarnings("unused")
		String st_estatus = null;
		
		@SuppressWarnings("unused")
		Double st_importe = null;
		
		st_sintes =  getSintesisSelect();
		st_estatus = getEstatusSelect();
		st_importe = getImporteSelect();
		 
		if(getSintesisSelect() != ""){
			st_sintes = getSintesisSelect(); 
		}			
		else{
			st_sintes = ((PenalTblBean)event.getObject()).getSintesis();
		}	
		if(getEstatusSelect() != ""){
			st_estatus = getEstatusSelect(); 
		}			
		else{
			st_estatus = ((PenalTblBean)event.getObject()).getEstatus();
		}
		if(getImporteSelect() != 0.0){
			st_importe = getImporteSelect(); 
		}			
		else{
			st_importe = ((PenalTblBean)event.getObject()).getIMPORTE();
		}
		
		
		Integer idreg =  null;		 
        idreg = ((PenalTblBean)event.getObject()).getIdregdoc();
        
        System.out.println("Id Documento.... ======= >>>>>> " + idreg);
		
		try 
		{					
			seguimientoDAOImpl.actualizarSeguimientoDocument(idreg, getSintesisSelect(), getEstatusSelect(), getImporteSelect());			
			System.out.println("Actualizacion correcta....");
			
			((PenalTblBean)event.getObject()).setSintesis(st_sintes);
			((PenalTblBean)event.getObject()).setEstatus(st_estatus);
			((PenalTblBean)event.getObject()).setIMPORTE(st_importe);
			
		} 
		catch (SraajException e) 
		{
			System.out.println("actualizacion incorrecta"); 
			e.printStackTrace();
		}
		
		
		
	}
	
	public void onRowCancel(RowEditEvent event) 
	{
		System.out.println("cancelar");
    }
	
	
	
	
	
	// sets and gets

	public List<CatGenerico> getCatPenal() {
		return catPenal;
	}

	public void setCatPenal(List<CatGenerico> catPenal) {
		this.catPenal = catPenal;
	}

	public List<PenalTblBean> getPenalTbl() {
		return penalTbl;
	}

	public void setPenalTbl(List<PenalTblBean> penalTbl) {
		this.penalTbl = penalTbl;
	}

	public CatGenerico getPenalSelect() {
		return penalSelect;
	}

	public void setPenalSelect(CatGenerico penalSelect) {
		this.penalSelect = penalSelect;
	}

	public CatGenerico getTurnar() {
		return turnar;
	}

	public void setTurnar(CatGenerico turnar) {
		this.turnar = turnar;
	}

	public List<CatGenerico> getCatTurnarA() {
		return catTurnarA;
	}

	public void setCatTurnarA(List<CatGenerico> catTurnarA) {
		this.catTurnarA = catTurnarA;
	}

	public java.sql.Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(java.sql.Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public String getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(String txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public String getIndiciadoSelect() {
		return indiciadoSelect;
	}

	public void setIndiciadoSelect(String indiciadoSelect) {
		this.indiciadoSelect = indiciadoSelect;
	}


	public java.sql.Date getFecvencimientoSelect() {
		return fecvencimientoSelect;
	}

	public void setFecvencimientoSelect(java.sql.Date fecvencimientoSelect) {
		this.fecvencimientoSelect = fecvencimientoSelect;
	}

	public String getEstatusSelect() {
		return estatusSelect;
	}

	public void setEstatusSelect(String estatusSelect) {
		this.estatusSelect = estatusSelect;
	}

	public SeguimientoDAOImpl getSeguimientoDAOImpl() {
		return seguimientoDAOImpl;
	}

	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) {
		this.seguimientoDAOImpl = seguimientoDAOImpl;
	}
	
	public List<String> getInstucciones() {
		return instucciones;
	}

	public String[] getInstruccionesSelect() {
		return instruccionesSelect;
	}

	public void setInstruccionesSelect(String[] instruccionesSelect) {
		this.instruccionesSelect = instruccionesSelect;
	}

	public Boolean getBandera() {
		return bandera;
	}

	public void setBandera(Boolean bandera) {
		this.bandera = bandera;
	}
	

}
