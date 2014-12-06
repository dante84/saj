package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.PenalTblBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

import org.primefaces.event.RowEditEvent;


@ManagedBean(name="COrdCPen")
@SessionScoped

public class ControladorRepOrdCivPenal implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	private List<CatGenerico> catPenal;
	private CatGenerico penalSelect;
	private CatGenerico turnar;
	private List<CatGenerico> catTurnarA;
	private List<PenalTblBean> penalTbl;
	private Date fechaBusqueda;
	private String txtBusqueda;
	private String indiciadoSelect;
	private Boolean bandera;


	private Date fecvencimientoSelect;
	private String estatusSelect;
	private List<String> instucciones;
	private String[] instruccionesSelect;
	
	private Date fecDescargo;
	private Integer numRegDes;
	private String sentidoOfi;
	private String destinatario;
	private String comentarios;
	private Integer idregdoc;
	private String comentariosTabla;
	
	
	
	//seguimiento
	private String numExpPenal;
	private String delito;
	private String denuncia;
	private Double importe; 
	private String flujoProcesal;
	private String idSeleccionado;
	
	public String Load()
	{
		penalSelect = null;
		indiciadoSelect = null;
		turnar =  null;
		fecvencimientoSelect = null;
		llenacatpenal();
		llenaTurnado();
		CargarTabla(null,null,11);
		return "RepOrdinarioCivilPenal";
	}
	
	public void CargarTabla(java.sql.Date fecha, String busqueda, Integer noJuicio)
	{
		try 
		{
			setPenalTbl(seguimientoDAOImpl.obtenerPenalTbl(fecha, busqueda, noJuicio));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al cargar la tabla ordinario civil penal");
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
	
	
	public void listenerOtros()
	{
		
//		for(int i = 0; i < instruccionesSelect.length;i++)
//		{
//			int x = Integer.parseInt(instruccionesSelect[i]);
//			if(x == 1)
//			{
//				System.out.println(x);
//				setBandera(true); 
//			}
//		}
//		System.out.println(getBandera());
	}
	
	public void busquedaPorFecha()
	{
		if (fechaBusqueda != null) 
		{
			CargarTabla(new java.sql.Date(getFechaBusqueda().getTime()),null,12);
		}
		else
		{
			CargarTabla(null, null, 12);
		}
	}
	
	public void busquedaPorTexto()
	{
		if (txtBusqueda != null) 
		{ 
			CargarTabla(null,txtBusqueda,12);
		}
		else
		{
			CargarTabla(null, null, 12);
		}
	}
	
	@SuppressWarnings("null")
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
		
		CatGenerico catpenal = null;
	    CatGenerico catTurnar = null;
	    java.sql.Date v = null;
	    
	    int idreg = ((PenalTblBean)event.getObject()).getIdregdoc();
	    
		
		if (instruccionesSelect != null) 
		{			
			for (int i = 0; i < instruccionesSelect.length; i++) 
			{
				if (Integer.parseInt(instruccionesSelect[i]) == 1) 
				{
					ints1 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 2) 
				{
					ints2 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 3) 
				{
					ints3 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 4) 
				{
					ints4 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 5) 
				{
					ints5 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 6) 
				{
					ints6 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 7) 
				{
					ints7 = 1;
				}
				if (Integer.parseInt(instruccionesSelect[i]) == 8) 
				{
					ints8 = 1;
				}
			}
		}
		System.out.println("xxxxxxxxxxxxxxxxx");
		if(getFecvencimientoSelect() != null)
		{
			v = new java.sql.Date (fecvencimientoSelect.getTime());
		}
		else
		{
			if(((PenalTblBean)event.getObject()).getFecvencimiento() != null)
			{
				v = new java.sql.Date(((PenalTblBean)event.getObject()).getFecvencimiento().getTime());
			}
		}
		
		if (turnar != null) 
		{
			catTurnar = turnar;
		}
		else
		{
			if(((PenalTblBean)event.getObject()).getIdturnado() != 0)
			{
				catTurnar.setId(((PenalTblBean)event.getObject()).getIdturnado());
				catTurnar.setDescripcion(((PenalTblBean)event.getObject()).getNombrecompleto());
			}
			else
			{
				catTurnar = new CatGenerico();
				catTurnar.setId(null);
				catTurnar.setDescripcion(null);
			}
		}
		
		if(penalSelect != null)
		{
			catpenal = penalSelect;
		}
		else
		{
			if(((PenalTblBean)event.getObject()).getIDCATPENAL() != 0)
			{
				catpenal.setId(((PenalTblBean)event.getObject()).getIDCATPENAL());
				catpenal.setDescripcion(((PenalTblBean)event.getObject()).getDescpenal());
			}
			else 
			{
				catpenal = new CatGenerico();
				catpenal.setId(null);
				catpenal.setDescripcion(null);
			}
		}
		System.out.println(indiciadoSelect.length());
		if (indiciadoSelect.length() == 0) 
		{
			System.out.println("es null el indiciado");
			indiciadoSelect = null;
		}
		else
		{
			System.out.println("no es null el indiciado");
			System.out.println(indiciadoSelect);
		}
		System.out.println(estatusSelect.length());
		System.out.println(estatusSelect.length());
		if (estatusSelect.length() == 0) 
		{
			System.out.println("es null el estatus");
			estatusSelect = null;
		}
		else
		{
			System.out.println("no es null el estatus");
			System.out.println(estatusSelect);
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
		
		if (catpenal != null) 
		{
			System.out.println(catpenal.getId() + " " + catpenal.getDescripcion());
		}
		else 
		{
			
			System.out.println(catpenal);
		}		
		System.out.println(indiciadoSelect);

		if (catTurnar != null) 
		{
			System.out.println(catTurnar.getId() + " " + catTurnar.getDescripcion());
		}
		else
		{
			System.out.println(catTurnar);
		}
		System.out.println(v);
		
		String instru = "";
		
		if(ints1 != null)
			instru += " Instruccion 1  ";
		if(ints2 != null)
			instru += " Instruccion 2  ";
		if(ints3 != null)
			instru += " Instruccion 3  ";
		if(ints4 != null)
			instru += " Instruccion 4  ";
		if(ints5 != null)
			instru += " Instruccion 5  ";
		if(ints6 != null)
			instru += " Instruccion 6  ";
		if(ints7 != null)
			instru += " Instruccion 7  ";
		if(ints8 != null)
			instru += " Instruccion 8  ";
		
		instru = instru.replace("   ", ", ");
		System.out.println(instru);
		
		try 
		{
			seguimientoDAOImpl.actualizarPenalSP(idreg, catpenal.getId(), null, indiciadoSelect, ints1, ints2, ints3, ints4, ints5, ints6, ints7, ints8, catTurnar.getId(), v, estatusSelect);
			System.out.println("actualizacion correcta");
		} 
		catch (SraajException e) 
		{
			e.printStackTrace();
			System.out.println("actualizacion incorrecta");
		}
		
		((PenalTblBean)event.getObject()).setDescpenal(catpenal.getDescripcion());
		((PenalTblBean)event.getObject()).setInstrucciones(instru);
		((PenalTblBean)event.getObject()).setIndiciado(indiciadoSelect);
		((PenalTblBean)event.getObject()).setNombrecompleto(catTurnar.getDescripcion());
		((PenalTblBean)event.getObject()).setFecvencimiento(v);
		((PenalTblBean)event.getObject()).setEstatus(estatusSelect);
		
		ints1 = null;
		ints2 = null;
		ints3 = null;
		ints4 = null;
		ints5 = null;
		ints6 = null;
		ints7 = null;
		ints8 = null;
		instruccionesSelect = null;
		penalSelect = null;
		indiciadoSelect = null;
		turnar =  null;
		fecvencimientoSelect = null;
		
	}
	 
	public void onRowCancel(RowEditEvent event) 
	{
		System.out.println("cancelar");
    }
	
	public void insertaDescargo()
	{
		System.out.println(idregdoc +", "+  fecDescargo +", "+ numRegDes +", "+ sentidoOfi +", "+ destinatario +", "+ comentarios +", "+ null);
		try {
			seguimientoDAOImpl.insertaDescargoPenal(idregdoc, fecDescargo, numRegDes, sentidoOfi, destinatario, comentarios, null, 1, null);
		} catch (SraajException e) {
			System.out.println("Error al insertar");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idregdoc = null; 
		fecDescargo = null;
		numRegDes = null;
		sentidoOfi = null;
		destinatario = null;
		comentarios = null;
	}
	
	public void obtieneIdreg(int Aidregdoc, String coment)
	{
		setIdregdoc(Aidregdoc);
		System.out.println("obtieneIdreg AAA" + comentariosTabla);
		setComentariosTabla(coment);
		System.out.println("obtieneIdreg" + comentariosTabla);
		System.out.println("--------");
		
	}
	
	public void insertaComentario()
	{
		System.out.println("insertaComentario " + comentariosTabla);
		try {
			seguimientoDAOImpl.insertaDescargoPenal(idregdoc, null, null, null, null, null, null, 2, comentariosTabla);
		} catch (SraajException e) {
			System.out.println("Error al insertar");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comentariosTabla = null;
	}
	
	//seguimiento
	
	public String LoadSeguimiento()
	{
		CargarTabla(null,null,12);
		return "JuicioPenalSeguimiento";
	}
	
	public void onRowEditSeg(RowEditEvent event)
	{
		System.out.println(((PenalTblBean)event.getObject()).getIdregdoc());
		int idreg = ((PenalTblBean)event.getObject()).getIdregdoc();
		
		if(numExpPenal.length() == 0)
		{
			if(((PenalTblBean)event.getObject()).getNumExpPenal() != null)
			{
				setNumExpPenal(((PenalTblBean)event.getObject()).getNumExpPenal());
			}
			else
			{
				numExpPenal = null;
			}
		}
		
		if(delito.length() == 0)
		{
			if(((PenalTblBean)event.getObject()).getDelito() != null)
			{
				setDelito(((PenalTblBean)event.getObject()).getDelito());
			}
			else
			{
				delito = null;
			}
		}
		
		if(denuncia.length() == 0)
		{
			if(((PenalTblBean)event.getObject()).getDenuncia() != null)
			{
				setDenuncia(((PenalTblBean)event.getObject()).getDenuncia());
			}
			else
			{
				denuncia = null;
			}
		}
		
		if(importe == null)
		{
			if(((PenalTblBean)event.getObject()).getIMPORTE() != 0.0)
			{
				setImporte(((PenalTblBean)event.getObject()).getIMPORTE());
			}
			else
			{
				importe = null;
			}
		}
		
		if(flujoProcesal.length() == 0)
		{
			if(((PenalTblBean)event.getObject()).getFLUJOPROCESAL() != null)
			{
				setFlujoProcesal(((PenalTblBean)event.getObject()).getFLUJOPROCESAL());
			}
			else
			{
				flujoProcesal = null;
			}
		}
		System.out.println(idreg + "," + numExpPenal + ", " + delito + ", " + denuncia + ", " + importe + ", " + flujoProcesal);
		try 
		{
			seguimientoDAOImpl.insertasegPenal(idreg, numExpPenal, delito, denuncia, importe, flujoProcesal);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
		
		((PenalTblBean)event.getObject()).setNumExpPenal(numExpPenal);
		((PenalTblBean)event.getObject()).setDelito(delito);
		((PenalTblBean)event.getObject()).setDenuncia(denuncia);
		((PenalTblBean)event.getObject()).setIMPORTE(importe);
		((PenalTblBean)event.getObject()).setFLUJOPROCESAL(flujoProcesal);
		
		numExpPenal = null;
		delito = null;
		denuncia = null;
		importe = null;
		flujoProcesal = null;
			
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

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
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


	public Date getFecvencimientoSelect() {
		return fecvencimientoSelect;
	}

	public void setFecvencimientoSelect(Date fecvencimientoSelect) {
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

	public Date getFecDescargo() {
		return fecDescargo;
	}

	public void setFecDescargo(Date fecDescargo) {
		this.fecDescargo = fecDescargo;
	}

	public Integer getNumRegDes() {
		return numRegDes;
	}

	public void setNumRegDes(Integer numRegDes) {
		this.numRegDes = numRegDes;
	}

	public void setInstucciones(List<String> instucciones) {
		this.instucciones = instucciones;
	}

	public String getSentidoOfi() {
		return sentidoOfi;
	}

	public void setSentidoOfi(String sentidoOfi) {
		this.sentidoOfi = sentidoOfi;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getIdregdoc() {
		return idregdoc;
	}

	public void setIdregdoc(int idregdoc) {
		this.idregdoc = idregdoc;
	}

	public String getComentariosTabla() {
		return comentariosTabla;
	}

	public void setComentariosTabla(String comentariosTabla) {
		this.comentariosTabla = comentariosTabla;
	}

	public void setIdregdoc(Integer idregdoc) {
		this.idregdoc = idregdoc;
	}

	public String getNumExpPenal() {
		return numExpPenal;
	}

	public void setNumExpPenal(String numExpPenal) {
		this.numExpPenal = numExpPenal;
	}

	public String getDelito() {
		return delito;
	}

	public void setDelito(String delito) {
		this.delito = delito;
	}

	public String getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(String denuncia) {
		this.denuncia = denuncia;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getFlujoProcesal() {
		return flujoProcesal;
	}

	public void setFlujoProcesal(String flujoProcesal) {
		this.flujoProcesal = flujoProcesal;
	}

	public String getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(String idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}
	
	
	
	
	

}
