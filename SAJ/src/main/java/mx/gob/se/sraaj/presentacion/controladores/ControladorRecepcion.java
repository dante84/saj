package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name = "CRecepcion")
@SessionScoped
public class ControladorRecepcion implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CatMateriaBean> lcmbMaterias;
	private List<CatGeneralBean> lcgbMaterias;
	private List<SeguimientoBean> lsbDatosSeguimiento;
	private List<SeguimientoJuiciosBean> lsjbSeguimientoMercantil;

	private CatGeneralBean cgbMateria;
	private CatGeneralBean cgbTurna;
	private CatMateriaBean cmbMateria;

	private String rbMercantil;
	private String rbSeguimientoMercantil;

	private String txtBusqueda;
	private String txtBusquedaSeg;
	private String expInterno;
	private String estatusS;
	private String cmbTurnado;
	private String lblCargo;

	private Date txtFechaConvencional;
	private Date txtFechaVencimiento;
	private Date txtBusquedaFecha;

	private Object[] turnados;
	private Object[] lstPuestos;

	@ManagedProperty(value = "#{gestionaCatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;

	@ManagedProperty(value = "#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;

	
	public String recepcionMercantil() throws SraajException {
		System.out.println("========>> en CRecepcion.recepcionMercantil");

		txtBusqueda = null;
		txtBusquedaFecha = null;
		txtFechaConvencional = null;
		txtFechaVencimiento = null;

		return cargaDatos();

	}

	public String cargaDatos() {
		System.out.println("========>> en CRecepcion.cargarDatos");
		if (rbMercantil == null) {
			setRbMercantil("7");
		}

		llenaMateria();
		llenaTabla(getTxtBusquedaFecha(), getTxtBusqueda(), getRbMercantil());
		doMuestraTurnados();

		return "recepcionMercantil";
	}

	public void llenaMateria() {
		System.out.println("========>> en CRecepcion.llenaMateria ");
		try {

			// setLcgbMaterias(gestionaCatDAOImpl.obtieneMateria());
			setLcmbMaterias(seguimientoDAOImpl.obtenerMaterias());
			// System.out.println("========>> materias " + lcmbMaterias.size());
		} catch (SraajException e) {
			e.printStackTrace();
		}
	}

	public void llenaTabla(Date fecha, String txt, String idJuicio) {
		System.out.println("========>> fecha " + fecha);
		System.out.println("========>> txt " + txt);
		System.out.println("========>> idJuicio " + idJuicio);

		java.sql.Date sqlFecha;
		try {

			sqlFecha = new java.sql.Date(fecha.getTime());

		} catch (Exception e) {

			sqlFecha = null;
		}

		try {
			setLsbDatosSeguimiento(seguimientoDAOImpl.obtenerSeguimiento(
					sqlFecha, txt, Integer.parseInt(idJuicio)));

			SeguimientoBean x = null;
			for (int i = 0; i < lsbDatosSeguimiento.size(); i++) {
				if (getLsbDatosSeguimiento().get(i).getNumexpediente() == 0) {
					x = getLsbDatosSeguimiento().get(i);
					x.setNumexpediente(null);
					lsbDatosSeguimiento.set(i, x);
					if (getLsbDatosSeguimiento().get(i).getNumreg() == 0) {
						x.setNumreg(null);
						lsbDatosSeguimiento.set(i, x);
					}
					x = null;
				}
			}
		} catch (SraajException e) {
			e.printStackTrace();
		}

	}

	public void busquedaFecha() {
		llenaTabla(getTxtBusquedaFecha(), null, getRbMercantil());
	}

	public void buequedaTexto() {
		llenaTabla(null, getTxtBusqueda(), getRbMercantil());
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Registro Editado",
				((SeguimientoBean) event.getObject()).getIdregDoc().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);

		Integer mate = null;
		String desMate = null;
		Date c = null;
		Date v = null;
		Integer idReg = null;

		idReg = ((SeguimientoBean) event.getObject()).getIdregDoc();

		if (getCmbMateria() != null) {
			mate = getCmbMateria().getIdmateria();
			desMate = getCmbMateria().getDescmateria();
		} else {
			if (((SeguimientoBean) event.getObject()).getIdmateria() != 0) {
				mate = ((SeguimientoBean) event.getObject()).getIdmateria();
				desMate = ((SeguimientoBean) event.getObject())
						.getDescmateria();
			}
		}

		System.out.println("=======>> mate " + mate + " " + desMate);

		if (getTxtFechaConvencional() != null) {
			c = new java.sql.Date(getTxtFechaConvencional().getTime());
		} else {
			if (((SeguimientoBean) event.getObject()).getFecconvencional() != null) {
				c = new java.sql.Date(((SeguimientoBean) event.getObject())
						.getFecconvencional().getTime());
			}
		}

		if (getTxtFechaVencimiento() != null) {
			v = new java.sql.Date(getTxtFechaVencimiento().getTime());
		} else {
			if (((SeguimientoBean) event.getObject()).getFecvencimiento() != null) {
				v = new java.sql.Date(((SeguimientoBean) event.getObject())
						.getFecvencimiento().getTime());
			}
		}

		System.out.println("========>>" + desMate);
		System.out.println("========>>" + c);
		System.out.println("========>>" + v);

		try {
			seguimientoDAOImpl.actualizarAsuntosJuridicos(idReg, mate, c, v);
			System.out.println("Actualizacion Correcta");
		} catch (SraajException e) {
			System.out.println("actualizacion incorrecta");
			e.printStackTrace();
		}

		((SeguimientoBean) event.getObject()).setDescmateria(desMate);
		((SeguimientoBean) event.getObject()).setFecconvencional(c);
		((SeguimientoBean) event.getObject()).setFecvencimiento(v);
	}

	public void onRowCancel(RowEditEvent event) {

	}

	public String cargarSeguimiento() {
		System.out.println("led zeppelin");
		if (rbSeguimientoMercantil == null) {
			setRbSeguimientoMercantil("7");
		}

		llenaSeguimiento(null);
		return "seguimientoMercantil";
	}

	public void llenaSeguimiento(String txt) {
		try {
			setLsjbSeguimientoMercantil(seguimientoDAOImpl
					.obtenerSeguimientoJuicios(txt,
							Integer.parseInt(getRbSeguimientoMercantil())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void busquedaTextoSeg() {
		llenaSeguimiento(getTxtBusquedaSeg());
	}

	public void onRowEditSeg(RowEditEvent event) {
		String expedienteI = null;
		String status = null;
		Integer idRegSeg = null;

		idRegSeg = ((SeguimientoJuiciosBean) event.getObject()).getIdregdoc();

		if (expInterno != null) {
			expedienteI = getExpInterno();
		} else {
			if (((SeguimientoJuiciosBean) event.getObject()).getExpinterno() != null) {
				expedienteI = ((SeguimientoJuiciosBean) event.getObject())
						.getExpinterno();
			}
		}

		if (estatusS != null) {
			status = getEstatusS();
		} else {
			if (((SeguimientoJuiciosBean) event.getObject()).getEstatus() != "") {
				status = ((SeguimientoJuiciosBean) event.getObject())
						.getEstatus();
			}
		}
		System.out.println("=======>> idRegSeg " + idRegSeg);
		System.out.println("=======>> estatus " + status);
		System.out.println("=======>> expediente Interno " + expedienteI);

		try {
			seguimientoDAOImpl.actualizarAmparoAgrarioSegSP(idRegSeg,
					expedienteI, status);
			System.out.println("========>> actualizacion corecta ");
		} catch (Exception e) {
			System.out.println("========>> actualiza incorrecta");
			e.printStackTrace();
		}
		((SeguimientoJuiciosBean) event.getObject()).setEstatus(status);
		((SeguimientoJuiciosBean) event.getObject()).setExpinterno(expedienteI);

		expedienteI = null;
		estatusS = null;
		expInterno = null;
		status = null;

	}

	public void onRowCancelSeg() {

	}

	public void listenerMercantil() {
		System.out.println("========>> en CRecepcion.listenerMercantil");
		System.out.println("========>>" + getRbMercantil());
	}

	public void doMuestraTurnados() {
		System.out.println("========>> en CRecepcion.doMuestraTrunados");
		try {
			setTurnados(gestionaCatDAOImpl.obtieneTurnados(
					Integer.parseInt(getRbMercantil())).toArray());
			// System.out.println(turnados.length);
			System.out.println("Muestra Turnados...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void doCargaPuesto() {
//		try {
//			System.out.println("Id del Usuario del Turnado === >>   "
//					+ getCgbTurna().getsIdCat());
//			System.out.println("Puesto del Usuario del Turnado === >>   "
//					+ getCgbTurna().getsDescripcionCat2());
//			setLblCargo(getCgbTurna().getsDescripcionCat2());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public String obtenerImg(String x) {
		int numero = Integer.parseInt(x);
		System.out.println(numero);
		if (numero == 1) {
			System.out.println("entro");
			return "okdocenpoder.png";
		} else {
			return "DocEnSupoderNegro.png";
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CatMateriaBean> getLcmbMaterias() {
		return lcmbMaterias;
	}

	public void setLcmbMaterias(List<CatMateriaBean> lcmbMaterias) {
		this.lcmbMaterias = lcmbMaterias;
	}

	public List<CatGeneralBean> getLcgbMaterias() {
		return lcgbMaterias;
	}

	public void setLcgbMaterias(List<CatGeneralBean> lcgbMaterias) {
		this.lcgbMaterias = lcgbMaterias;
	}

	public List<SeguimientoBean> getLsbDatosSeguimiento() {
		return lsbDatosSeguimiento;
	}

	public void setLsbDatosSeguimiento(List<SeguimientoBean> lsbDatosSeguimiento) {
		this.lsbDatosSeguimiento = lsbDatosSeguimiento;
	}

	public List<SeguimientoJuiciosBean> getLsjbSeguimientoMercantil() {
		return lsjbSeguimientoMercantil;
	}

	public void setLsjbSeguimientoMercantil(
			List<SeguimientoJuiciosBean> lsjbSeguimientoMercantil) {
		this.lsjbSeguimientoMercantil = lsjbSeguimientoMercantil;
	}

	public String getRbMercantil() {
		return rbMercantil;
	}

	public void setRbMercantil(String rbMercantil) {
		this.rbMercantil = rbMercantil;
	}

	public String getRbSeguimientoMercantil() {
		return rbSeguimientoMercantil;
	}

	public void setRbSeguimientoMercantil(String rbSeguimientoMercantil) {
		this.rbSeguimientoMercantil = rbSeguimientoMercantil;
	}

	public CatGeneralBean getCgbMateria() {
		return cgbMateria;
	}

	public void setCgbMateria(CatGeneralBean cgbMateria) {
		this.cgbMateria = cgbMateria;
	}

	public CatMateriaBean getCmbMateria() {
		return cmbMateria;
	}

	public void setCmbMateria(CatMateriaBean cmbMateria) {
		this.cmbMateria = cmbMateria;
	}

	public String getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(String txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public Date getTxtFechaConvencional() {
		return txtFechaConvencional;
	}

	public void setTxtFechaConvencional(Date txtFechaConvencional) {
		this.txtFechaConvencional = txtFechaConvencional;
	}

	public Date getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Date txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public Date getTxtBusquedaFecha() {
		return txtBusquedaFecha;
	}

	public void setTxtBusquedaFecha(Date txtBusquedaFecha) {
		this.txtBusquedaFecha = txtBusquedaFecha;
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

	public String getExpInterno() {
		return expInterno;
	}

	public void setExpInterno(String expInterno) {
		this.expInterno = expInterno;
	}

	public GestionaCatDAOImpl getGestionaCatDAOImpl() {
		return gestionaCatDAOImpl;
	}

	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) {
		this.gestionaCatDAOImpl = gestionaCatDAOImpl;
	}

	public SeguimientoDAOImpl getSeguimientoDAOImpl() {
		return seguimientoDAOImpl;
	}

	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) {
		this.seguimientoDAOImpl = seguimientoDAOImpl;
	}

	public CatGeneralBean getCgbTurna() {
		return cgbTurna;
	}

	public void setCgbTurna(CatGeneralBean cgbTurna) {
		this.cgbTurna = cgbTurna;
	}

	public String getCmbTurnado() {
		return cmbTurnado;
	}

	public void setCmbTurnado(String cmbTurnado) {
		this.cmbTurnado = cmbTurnado;
	}

	public String getLblCargo() {
		return lblCargo;
	}

	public void setLblCargo(String lblCargo) {
		this.lblCargo = lblCargo;
	}

	public Object[] getTurnados() {
		return turnados;
	}

	public void setTurnados(Object[] turnados) {
		this.turnados = turnados;
	}

	public Object[] getLstPuestos() {
		return lstPuestos;
	}

	public void setLstPuestos(Object[] lstPuestos) {
		this.lstPuestos = lstPuestos;
	}

}
