package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="CSegAmparo")
@SessionScoped

public class ControladorSeguimientoAmparo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	private String rdoSeguimientoAmparo;
	private String txtBusquedaSeg;
	private String estatusS;
	private List<SeguimientoJuiciosBean> datosSeguimientoAmparo;
	private String expinterno;
	
	public String cargarSeguimiento()
	{
		System.out.println("Cargar Seguimiento...");
		
//		if(rdoSeguimientoAmparo == null)
//		{
//			setRdoSeguimientoAmparo("2");
//		}
//	    try {
//			setDatosSeguimientoAmparo(seguimientoDAOImpl.obtenerSeguimientoJuicios(getTxtBusquedaSeg(),Integer.parseInt(getRdoSeguimientoAmparo())));
//		} catch (SraajException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "AmparoLocal";
	}
	
	
	public void busquedaPorTextoSeg()
	{
		
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
		
	}
	
	public void onRowCancelSeg()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public SeguimientoDAOImpl getSeguimientoDAOImpl() {
		return seguimientoDAOImpl;
	}
	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) {
		this.seguimientoDAOImpl = seguimientoDAOImpl;
	}
	public String getRdoSeguimientoAmparo() {
		return rdoSeguimientoAmparo;
	}
	public void setRdoSeguimientoAmparo(String rdoSeguimientoAmparo) {
		this.rdoSeguimientoAmparo = rdoSeguimientoAmparo;
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
	public List<SeguimientoJuiciosBean> getDatosSeguimientoAmparo() {
		return datosSeguimientoAmparo;
	}
	public void setDatosSeguimientoAmparo(
			List<SeguimientoJuiciosBean> datosSeguimientoAmparo) {
		this.datosSeguimientoAmparo = datosSeguimientoAmparo;
	}
	public String getExpinterno() {
		return expinterno;
	}
	public void setExpinterno(String expinterno) {
		this.expinterno = expinterno;
	}

}
