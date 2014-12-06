package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.PenalTblBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;


@ManagedBean(name="COrdPenal")
@SessionScoped

public class ControladorOrdinCivPenal implements Serializable{
	
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


	private java.sql.Date fecvencimientoSelect;
	private String estatusSelect;
	private List<String> instucciones;
	private String[] instruccionesSelect;
	
	public String Load()
	{
		llenacatpenal();
		llenaTurnado();
		CargarTabla(null,null,12);
		return" OrdinarioCivPenalRep";
	}
	
	public void CargarTabla(java.sql.Date fecha, String busqueda, Integer noJuicio)
	{
		try 
		{
			setPenalTbl(seguimientoDAOImpl.obtenerPenalTbl(fecha, busqueda, noJuicio));
		} 
		catch (SraajException e) 
		{
			System.out.println("Error al cargar la tabla Ordinario Civil Penal");
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
			System.out.println("error al llenar turnar a");
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
			System.out.println("error al llenar turnar a");
			e.printStackTrace();
		}
	}
	
	
	public void listenerOtros(){ }
	
	public void busquedaPorFecha(){	}
	
	public void busquedaPorTexto(){	}
	
	@SuppressWarnings("Null")
	public void onRowEdit(RowEditEvent event) 
	{
		System.out.println("editar");
		Integer ints1 = null;
		Integer ints2 = null;
		Integer ints3 = null;
		Integer ints4 = null;
		Integer ints5 = null;
		Integer ints6 = null;
		Integer ints7 = null;
		Integer ints8 = null;
		
		CatGenerico catpenal =  new CatGenerico();
		
		if (instruccionesSelect != null) 
		{			
			for (int i = 0; i < instruccionesSelect.length; i++) 
			{
				if (Integer.parseInt(instruccionesSelect[i]) == 1) 
				{
					ints1 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 2) 
				{
					ints2 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 3) 
				{
					ints3 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 4) 
				{
					ints4 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 5) 
				{
					ints5 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 6) 
				{
					ints6 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 7) 
				{
					ints7 = Integer.parseInt(instruccionesSelect[i]);
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 8) 
				{
					ints8 = Integer.parseInt(instruccionesSelect[i]);
				}
			}
		}
		System.out.println(penalSelect.getDescripcion());
		if(penalSelect != null)
		{
			catpenal.setId(getPenalSelect().getId());
			catpenal.setDescripcion(getPenalSelect().getDescripcion());
		}
		else
		{
			if(((CatGenerico)event.getObject()).getId() != 0)
			{
				catpenal.setId(((CatGenerico)event.getObject()).getId());
				catpenal.setDescripcion(((CatGenerico)event.getObject()).getDescripcion());
			}			
		}
		
		
		System.out.println("--------------------Instrucciones---------------------------");
		System.out.println(ints1);
		System.out.println(ints2);
		System.out.println(ints3);
		System.out.println(ints4);
		System.out.println(ints5);
		System.out.println(ints6);
		System.out.println(ints7);
		System.out.println(ints8);
		System.out.println("--------------------catPenal---------------------------");
		
		System.out.println(catpenal.getId() + '-' + catpenal.getDescripcion());
		
		ints1 = null;
		ints2 = null;
		ints3 = null;
		ints4 = null;
		ints5 = null;
		ints6 = null;
		ints7 = null;
		ints8 = null;
		
		instruccionesSelect = null;
		
	}
	
	public void onRowCancel(RowEditEvent event) 
	{
		System.out.println("Cancelar");
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
