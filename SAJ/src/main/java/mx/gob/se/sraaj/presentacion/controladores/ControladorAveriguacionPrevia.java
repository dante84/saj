package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import mx.gob.se.sraaj.comunes.bean.ComparecenciaIndiciadoBean;
import mx.gob.se.sraaj.comunes.bean.DenunciaHechosBean;
import mx.gob.se.sraaj.comunes.bean.DiligenciasMPBean;
import mx.gob.se.sraaj.comunes.bean.MediosPruebaBean;
import mx.gob.se.sraaj.comunes.bean.RequerimientosMPBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.AveriguacionPreviaDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;


@ManagedBean(name="CAve")
@SessionScoped

public class ControladorAveriguacionPrevia implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{avenriguacionPreviaDAO}")
	private AveriguacionPreviaDAOImpl avenriguacionPreviaDAO;
	
	private int id;
	private String opcion;
	private List<ComparecenciaIndiciadoBean> lcomparecencia;
	private List<RequerimientosMPBean> lrequerimientos;
	private List<DiligenciasMPBean> ldiligencia;
	private List<DenunciaHechosBean> ldenuncia;
	private List<MediosPruebaBean> lmedios;
	
	private Date fechacomparecencia;
	private String pruebascomparecencia;
	private String observacionescomparecencia;
	
	private Date requerimientoFecha;
	private String requerimientoOficio;
	private String requerimientoRequerimiento;
	private String requerimientoDesahogo;
	private String requerimientoObservaciones;
	
	private Date fechaDiligencias;
	private String diligenciasDiligencias;
	private String diligenciasObservaciones;
	
	private Date fechaDenuncia;
	private String oficioDenuncia;
	private String ratificaDenuncia;
	private Date fechaRatificacionDenuncia;
	
	private Date fechaMedios;
	private String testimonialesMedios;
	private String pericialesMedios;
	private String documentalesMedios;
	private String inspeccionMedios;
	private String otraMedios;
	private String observacionesMeidos;
	
	private String txtBusqueda;
	private boolean dlgComparecencia;
	private boolean dlgComparecencia2;
	
	
	
	public void onRowEdit(RowEditEvent event)
	{
		int Aidcomparecencia = ((ComparecenciaIndiciadoBean)event.getObject()).getIdcomparecencia();
		if(fechacomparecencia == null)
		{
			if(((ComparecenciaIndiciadoBean)event.getObject()).getFecha() != null)
			{
				fechacomparecencia = ((ComparecenciaIndiciadoBean)event.getObject()).getFecha();
			}
		}
		
		if(pruebascomparecencia.length() == 0)
		{
			if(((ComparecenciaIndiciadoBean)event.getObject()).getPruebas() != null)
			{
				pruebascomparecencia = ((ComparecenciaIndiciadoBean)event.getObject()).getPruebas();
			}
			else
			{
				pruebascomparecencia = null;
			}
		}
		
		if(observacionescomparecencia.length() == 0)
		{
			if(((ComparecenciaIndiciadoBean)event.getObject()).getObservaciones() != null)
			{
				observacionescomparecencia = ((ComparecenciaIndiciadoBean)event.getObject()).getObservaciones();
			}
			else
			{
				observacionescomparecencia = null;
			}
		}
		System.out.println(Aidcomparecencia + ", " + fechacomparecencia + ", " + pruebascomparecencia + ", " + observacionescomparecencia);
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(new java.sql.Date(fechacomparecencia.getTime())
															 , pruebascomparecencia
															 , observacionescomparecencia
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , Aidcomparecencia
															 , null
															 , null
															 , null
															 , null
															 , 1);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
		
	}
	
	public void onRowEditReq(RowEditEvent event)
	{
		int idrequerimiento = ((RequerimientosMPBean)event.getObject()).getIdRequerimiento();
		
		if(requerimientoFecha == null)
		{
			if(((RequerimientosMPBean)event.getObject()).getFecha() != null)
			{
				requerimientoFecha = ((RequerimientosMPBean)event.getObject()).getFecha();
			}
		}
		
		if(requerimientoOficio.length() == 0)
		{
			if(((RequerimientosMPBean)event.getObject()).getOficio() != null)
			{
				requerimientoOficio = ((RequerimientosMPBean)event.getObject()).getOficio();
			}
			else
			{
				requerimientoOficio = null;
			}
		}
		
		if(requerimientoRequerimiento.length() == 0)
		{
			if(((RequerimientosMPBean)event.getObject()).getRequerimiento() != null)
			{
				requerimientoRequerimiento = ((RequerimientosMPBean)event.getObject()).getRequerimiento();
			}
			else
			{
				requerimientoRequerimiento = null;
			}
		}
		
		if(requerimientoDesahogo.length() == 0)
		{
			if(((RequerimientosMPBean)event.getObject()).getDesahogo() != null)
			{
				requerimientoDesahogo = ((RequerimientosMPBean)event.getObject()).getDesahogo();
			}
			else
			{
				requerimientoDesahogo = null;
			}
		}
		
		if(requerimientoObservaciones.length() == 0)
		{
			if(((RequerimientosMPBean)event.getObject()).getObservaciones() != null)
			{
				requerimientoObservaciones = ((RequerimientosMPBean)event.getObject()).getObservaciones();
			}
			else
			{
				requerimientoObservaciones = null;
			}
		}
		
		System.out.println(idrequerimiento +", "+ requerimientoFecha +", "+ requerimientoOficio +", "+ requerimientoRequerimiento +", "+ requerimientoDesahogo +", "+ requerimientoObservaciones);
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(null
															 , null
															 , null
															 
															 , new java.sql.Date(requerimientoFecha.getTime())
															 , requerimientoOficio
															 , requerimientoRequerimiento
															 , requerimientoDesahogo
															 , requerimientoObservaciones
															 
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , idrequerimiento
															 , null
															 , null
															 , null
															 , 2);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
	}
	
	public void onRowEditDiligencias(RowEditEvent event)
	{
		int iddiligencia = ((DiligenciasMPBean)event.getObject()).getIddiligencias();
				
		if(fechaDiligencias == null)
		{
			if(((DiligenciasMPBean)event.getObject()).getFecha() != null)
			{
				fechaDiligencias = ((DiligenciasMPBean)event.getObject()).getFecha();
			}
		}
		
		if(diligenciasDiligencias.length() == 0)
		{
			if(((DiligenciasMPBean)event.getObject()).getDiligencias() != null)
			{
				diligenciasDiligencias = ((DiligenciasMPBean)event.getObject()).getDiligencias();
			}
			else
			{
				diligenciasDiligencias = null;
			}
		}
		
		if(diligenciasObservaciones.length() == 0)
		{
			if(((DiligenciasMPBean)event.getObject()).getObservaciones() != null)
			{
				diligenciasObservaciones = ((DiligenciasMPBean)event.getObject()).getObservaciones();
			}
			else
			{
				diligenciasObservaciones = null;
			}
		}
		
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , new java.sql.Date(fechaDiligencias.getTime())
															 , diligenciasDiligencias
															 , diligenciasObservaciones
															 
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , iddiligencia
															 , null
															 , null
															 , 3);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
	}
	
	public void onRowEditDenuncia(RowEditEvent event)
	{
		int iddenuncia = ((DenunciaHechosBean)event.getObject()).getIddenuncia();
		
		if(fechaDenuncia == null)
		{
			if(((DenunciaHechosBean)event.getObject()).getFecha() != null)
			{
				fechaDenuncia = ((DenunciaHechosBean)event.getObject()).getFecha();
			}
		}
		
		if(oficioDenuncia.length() == 0)
		{
			if(((DenunciaHechosBean)event.getObject()).getOficio() != null)
			{
				oficioDenuncia = ((DenunciaHechosBean)event.getObject()).getOficio();
			}
			else
			{
				oficioDenuncia = null;
			}
		}
		
		if(ratificaDenuncia.length() == 0)
		{
			if(((DenunciaHechosBean)event.getObject()).getRatifica() != null)
			{
				ratificaDenuncia = ((DenunciaHechosBean)event.getObject()).getRatifica();
			}
			else
			{
				ratificaDenuncia = null;
			}
		}
		
		if(fechaRatificacionDenuncia == null)
		{
			if(((DenunciaHechosBean)event.getObject()).getFechaRatificacion() != null)
			{
				fechaRatificacionDenuncia = ((DenunciaHechosBean)event.getObject()).getFechaRatificacion();
			}
		}
		
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 
															 , new java.sql.Date(fechaDenuncia.getTime())
															 , oficioDenuncia
															 , ratificaDenuncia
															 , new java.sql.Date(fechaRatificacionDenuncia.getTime())
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , iddenuncia
															 , null
															 , 4);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
		
	}
	
	public void onRowEditMedios(RowEditEvent event)
	{
		int idmedios = ((MediosPruebaBean)event.getObject()).getIdmediosPrueba();
		
		if(fechaMedios == null)
		{
			if(((DenunciaHechosBean)event.getObject()).getFecha() != null)
			{
				fechaMedios = ((MediosPruebaBean)event.getObject()).getFecha();
			}
		}
		
		if(testimonialesMedios == null)
		{
			if(((MediosPruebaBean)event.getObject()).getDocumentales() != null)
			{
				testimonialesMedios = ((MediosPruebaBean)event.getObject()).getDocumentales();
			}
		}
		
		if(pericialesMedios == null)
		{
			if(((MediosPruebaBean)event.getObject()).getPericiales() != null)
			{
				pericialesMedios = ((MediosPruebaBean)event.getObject()).getPericiales();
			}
		}
		
		if(documentalesMedios == null)
		{
			if(((MediosPruebaBean)event.getObject()).getDocumentales() != null)
			{
				documentalesMedios = ((MediosPruebaBean)event.getObject()).getDocumentales();
			}
		}
		
		if(inspeccionMedios == null)
		{
			if(((MediosPruebaBean)event.getObject()).getInspeccion() != null)
			{
				inspeccionMedios = ((MediosPruebaBean)event.getObject()).getInspeccion();
			}
		}
		
		if(otraMedios == null)
		{
			if(((MediosPruebaBean)event.getObject()).getOtra() != null)
			{
				otraMedios = ((MediosPruebaBean)event.getObject()).getOtra();
			}
		}
		
		if(observacionesMeidos == null)
		{
			if(((MediosPruebaBean)event.getObject()).getObservaciones() != null)
			{
				observacionesMeidos = ((MediosPruebaBean)event.getObject()).getObservaciones();
			}
		}
		
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 
															 , new java.sql.Date(fechaMedios.getTime())
															 , testimonialesMedios
															 , pericialesMedios
															 , documentalesMedios
															 , inspeccionMedios
															 , otraMedios
															 , observacionesMeidos
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , idmedios
															 , 5);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
	}
	
	public void onRowCancel(RowEditEvent event)
	{
		
	}
	
	public String load(int idregdoc)
	{
		System.out.println("averiguacion previa " + idregdoc);
		setId(idregdoc);
		llenaComparecencia(idregdoc);
		llenaRequerimientos(idregdoc);
		llenaDiligencias(idregdoc);
		llenaDenuncia(idregdoc);
		llenaMedios(idregdoc);
		setOpcion("1");
		return "AccionAveriguacionPrevia";
	}
	
	public void busquedaPorTexto()
	{
		System.out.println(opcion);
	}
	
	public void visible()
	{
		setDlgComparecencia(true);
		setDlgComparecencia2(false);
		System.out.println(dlgComparecencia);
		System.out.println(dlgComparecencia2);
	}
	
	private void llenaComparecencia(int idregdoc)
	{
		try 
		{
			setLcomparecencia(avenriguacionPreviaDAO.listaComparecencia(idregdoc));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al llenar la comparecencia");
			e.printStackTrace();
		}
	}
	
	private void llenaRequerimientos(int idregdoc)
	{
		try 
		{
			setLrequerimientos(avenriguacionPreviaDAO.listaRequerimientos(idregdoc));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al llenar la requerimientos");
			e.printStackTrace();
		}
	}

	private void llenaDiligencias(int idregdoc)
	{
		try 
		{
			setLdiligencia(avenriguacionPreviaDAO.listaDiligencias(idregdoc));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al llenar la llenaDiligencias");
			e.printStackTrace();
		}
	}
	
	private void llenaDenuncia(int idregdoc)
	{
		try 
		{
			setLdenuncia(avenriguacionPreviaDAO.listaDenuncias(idregdoc));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al llenar la llenaDenuncia");
			e.printStackTrace();
		}
	}
	
	private void llenaMedios(int idregdoc)
	{
		try 
		{
			setLmedios(avenriguacionPreviaDAO.listaMediosPrueba(idregdoc));
		} 
		catch (SraajException e) 
		{
			System.out.println("error al llenar la llenaMedios");
			e.printStackTrace();
		}
	}
	
	public String guardarComparecencia()
	{
		try 
		{
			avenriguacionPreviaDAO.InsertarAveriguacionPrevia(new java.sql.Date(fechacomparecencia.getTime())
															 , pruebascomparecencia
															 , observacionescomparecencia
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 , null
															 
															 , id
															 , null
															 , null
															 , null
															 , null
															 , null
															 , 1);
		} 
		catch (SraajException e) 
		{
			System.out.println("error al actualizar");
			e.printStackTrace();
		}
		llenaComparecencia(id);
		llenaRequerimientos(id);
		llenaDiligencias(id);
		llenaDenuncia(id);
		llenaMedios(id);
		setOpcion("1");
		
		fechacomparecencia = null;
		pruebascomparecencia = null;
		observacionescomparecencia =  null;
		
		return "AccionAveriguacionPrevia";
	}
	
	
	
	//gets and sets

	public List<ComparecenciaIndiciadoBean> getLcomparecencia() {
		return lcomparecencia;
	}

	public void setLcomparecencia(List<ComparecenciaIndiciadoBean> lcomparecencia) {
		this.lcomparecencia = lcomparecencia;
	}

	public Date getFechacomparecencia() {
		return fechacomparecencia;
	}

	public void setFechacomparecencia(Date fechacomparecencia) {
		this.fechacomparecencia = fechacomparecencia;
	}

	public String getPruebascomparecencia() {
		return pruebascomparecencia;
	}

	public void setPruebascomparecencia(String pruebascomparecencia) {
		this.pruebascomparecencia = pruebascomparecencia;
	}

	public String getObservacionescomparecencia() {
		return observacionescomparecencia;
	}

	public void setObservacionescomparecencia(String observacionescomparecencia) {
		this.observacionescomparecencia = observacionescomparecencia;
	}

	public AveriguacionPreviaDAOImpl getAvenriguacionPreviaDAO() {
		return avenriguacionPreviaDAO;
	}

	public void setAvenriguacionPreviaDAO(
			AveriguacionPreviaDAOImpl avenriguacionPreviaDAO) {
		this.avenriguacionPreviaDAO = avenriguacionPreviaDAO;
	}

	public List<RequerimientosMPBean> getLrequerimientos() {
		return lrequerimientos;
	}

	public void setLrequerimientos(List<RequerimientosMPBean> lrequerimientos) {
		this.lrequerimientos = lrequerimientos;
	}

	public List<DiligenciasMPBean> getLdiligencia() {
		return ldiligencia;
	}

	public void setLdiligencia(List<DiligenciasMPBean> ldiligencia) {
		this.ldiligencia = ldiligencia;
	}

	public List<DenunciaHechosBean> getLdenuncia() {
		return ldenuncia;
	}

	public void setLdenuncia(List<DenunciaHechosBean> ldenuncia) {
		this.ldenuncia = ldenuncia;
	}

	public List<MediosPruebaBean> getLmedios() {
		return lmedios;
	}

	public void setLmedios(List<MediosPruebaBean> lmedios) {
		this.lmedios = lmedios;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(String txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public Date getRequerimientoFecha() {
		return requerimientoFecha;
	}

	public void setRequerimientoFecha(Date requerimientoFecha) {
		this.requerimientoFecha = requerimientoFecha;
	}

	public String getRequerimientoOficio() {
		return requerimientoOficio;
	}

	public void setRequerimientoOficio(String requerimientoOficio) {
		this.requerimientoOficio = requerimientoOficio;
	}

	public String getRequerimientoRequerimiento() {
		return requerimientoRequerimiento;
	}

	public void setRequerimientoRequerimiento(String requerimientoRequerimiento) {
		this.requerimientoRequerimiento = requerimientoRequerimiento;
	}

	public String getRequerimientoDesahogo() {
		return requerimientoDesahogo;
	}

	public void setRequerimientoDesahogo(String requerimientoDesahogo) {
		this.requerimientoDesahogo = requerimientoDesahogo;
	}

	public String getRequerimientoObservaciones() {
		return requerimientoObservaciones;
	}

	public void setRequerimientoObservaciones(String requerimientoObservaciones) {
		this.requerimientoObservaciones = requerimientoObservaciones;
	}

	public Date getFechaDiligencias() {
		return fechaDiligencias;
	}

	public void setFechaDiligencias(Date fechaDiligencias) {
		this.fechaDiligencias = fechaDiligencias;
	}

	public String getDiligenciasDiligencias() {
		return diligenciasDiligencias;
	}

	public void setDiligenciasDiligencias(String diligenciasDiligencias) {
		this.diligenciasDiligencias = diligenciasDiligencias;
	}

	public String getDiligenciasObservaciones() {
		return diligenciasObservaciones;
	}

	public void setDiligenciasObservaciones(String diligenciasObservaciones) {
		this.diligenciasObservaciones = diligenciasObservaciones;
	}

	public Date getFechaDenuncia() {
		return fechaDenuncia;
	}

	public void setFechaDenuncia(Date fechaDenuncia) {
		this.fechaDenuncia = fechaDenuncia;
	}

	public String getOficioDenuncia() {
		return oficioDenuncia;
	}

	public void setOficioDenuncia(String oficioDenuncia) {
		this.oficioDenuncia = oficioDenuncia;
	}

	public String getRatificaDenuncia() {
		return ratificaDenuncia;
	}

	public void setRatificaDenuncia(String ratificaDenuncia) {
		this.ratificaDenuncia = ratificaDenuncia;
	}

	public Date getFechaRatificacionDenuncia() {
		return fechaRatificacionDenuncia;
	}

	public void setFechaRatificacionDenuncia(Date fechaRatificacionDenuncia) {
		this.fechaRatificacionDenuncia = fechaRatificacionDenuncia;
	}

	public Date getFechaMedios() {
		return fechaMedios;
	}

	public void setFechaMedios(Date fechaMedios) {
		this.fechaMedios = fechaMedios;
	}

	public String getTestimonialesMedios() {
		return testimonialesMedios;
	}

	public void setTestimonialesMedios(String testimonialesMedios) {
		this.testimonialesMedios = testimonialesMedios;
	}

	public String getPericialesMedios() {
		return pericialesMedios;
	}

	public void setPericialesMedios(String pericialesMedios) {
		this.pericialesMedios = pericialesMedios;
	}

	public String getDocumentalesMedios() {
		return documentalesMedios;
	}

	public void setDocumentalesMedios(String documentalesMedios) {
		this.documentalesMedios = documentalesMedios;
	}

	public String getInspeccionMedios() {
		return inspeccionMedios;
	}

	public void setInspeccionMedios(String inspeccionMedios) {
		this.inspeccionMedios = inspeccionMedios;
	}

	public String getOtraMedios() {
		return otraMedios;
	}

	public void setOtraMedios(String otraMedios) {
		this.otraMedios = otraMedios;
	}

	public String getObservacionesMeidos() {
		return observacionesMeidos;
	}

	public void setObservacionesMeidos(String observacionesMeidos) {
		this.observacionesMeidos = observacionesMeidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getDlgComparecencia() {
		return dlgComparecencia;
	}

	public void setDlgComparecencia(Boolean dlgComparecencia) {
		this.dlgComparecencia = dlgComparecencia;
	}

	public boolean getDlgComparecencia2() {
		return dlgComparecencia2;
	}

	public void setDlgComparecencia2(boolean dlgComparecencia2) {
		this.dlgComparecencia2 = dlgComparecencia2;
	}
	
}
