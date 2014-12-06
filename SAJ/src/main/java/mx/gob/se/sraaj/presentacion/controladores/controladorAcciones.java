package mx.gob.se.sraaj.presentacion.controladores;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import mx.gob.se.sraaj.comunes.bean.OrdinarioCivilPenalBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="CAcciones")
@SessionScoped
public class controladorAcciones {

	private List<OrdinarioCivilPenalBean> locpEstudioPGR;
	
	private String txtOficio; 
	private String txtRequerimientoPGR;
	private String txtBusqueda;
	private String txtRegistro;
	
	private Date txtFecha;
	
	@ManagedProperty (value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	public String load(){
		txtFecha = null;
		txtOficio = null;
		txtRequerimientoPGR = null;
		txtBusqueda = null;
		
		return cargar();
	}
	public String cargar(){
		
		llenaTabla(getTxtRegistro(), getTxtBusqueda(), 11);
		return "estudioPGR"; 
	}

	public void llenaTabla(String idregisgtro, String busqueda, Integer idjuicio){
		System.out.println("========>> registro " + idregisgtro);
		System.out.println("========>> busqueda " + busqueda);
		System.out.println("========>> juicio " + idjuicio);
		try{
			setLocpEstudioPGR(seguimientoDAOImpl.ObtieneOrdCivPenal(100, busqueda, 11));
			System.out.println("========>> lista OCP" + locpEstudioPGR);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void busquedaTexto()
	{
//		llenaTabla(100, getTxtBusqueda(), 11);
	}
	
	public void onRowEditActor(RowEditEvent event) 
	{
		System.out.println("========>> En CAcciones.onRowEditActor");
		FacesMessage msg = new FacesMessage("Registro con Folio", ((OrdinarioCivilPenalBean) event.getObject()).getsOficio());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
        Integer idRegDoc = ((OrdinarioCivilPenalBean) event.getObject()).getIdRegDoc();
//        String idcatProcesal = ((OrdinarioCivilPenalBean) event.getObject()).getsDesc_Procesal();
        Integer idProcesal = ((OrdinarioCivilPenalBean)event.getObject()).getIdF_Procesal();
        String requerimiento = null;
        Date fecha = null;
        String oficio = null;
        
        
        if (getTxtRequerimientoPGR() != null){
        	requerimiento = getTxtRequerimientoPGR();
        }
        else{
        	if(((OrdinarioCivilPenalBean)event.getObject()).getsRequerimientoPGR() != null){
        		requerimiento = ((OrdinarioCivilPenalBean)event.getObject()).getsRequerimientoPGR();
        	}
        }
        
        if (getTxtFecha() != null){
        	fecha = getTxtFecha();
        }
        else{
        	if(((OrdinarioCivilPenalBean) event.getObject()).getdFecha() != null){
        		fecha = ((OrdinarioCivilPenalBean) event.getObject()).getdFecha();
        	}
        }
        
        if(getTxtOficio()!= null){
        	oficio = getTxtOficio();
        }
        else{
        	if(((OrdinarioCivilPenalBean)event.getObject()).getsOficio() != null){
        		oficio = ((OrdinarioCivilPenalBean) event.getObject()).getsOficio();
        	}
        }
        System.out.println("========>> registro " + idRegDoc);
        System.out.println("========>> idProcesal " + idProcesal);
        System.out.println("========>> requerimiento " + requerimiento);
        System.out.println("========>> fecha " + fecha);
        System.out.println("========>> oficio " + oficio);
        
        
//		Integer mate = null;
//		String desMate = null;
//        java.sql.Date v = null;
//        Integer idreg =  null;
//        Integer idtribunal = null;
//        String t = null;
//        
//        idreg = ((SeguimientoBean)event.getObject()).getIdregDoc();
//		
//		if(getMateria() != null)
//		{
//			mate = getMateria().getIdmateria();
//			desMate = getMateria().getDescmateria();
//		}
//		else
//		{
//			if(((SeguimientoBean)event.getObject()).getIdmateria() != 0)
//			{
//				mate = ((SeguimientoBean)event.getObject()).getIdmateria();
//				desMate = ((SeguimientoBean)event.getObject()).getDescmateria();
//			}			
//		}
//		
//		if(getTribunal() != null)
//		{
//			idtribunal = getTribunal().getIdTribunal();
//			t = getTribunal().getDecripcion();
//		}
//		else
//		{
//			if(((SeguimientoBean)event.getObject()).getIdtribunal()!= 0)
//			{
//				idtribunal = ((SeguimientoBean)event.getObject()).getIdtribunal(); 
//				t = ((SeguimientoBean)event.getObject()).getDescripcion(); 
//			}			
//		}
//		
//		
//		
//		if(getFechaVencimiento() != null)
//		{
//			v = new java.sql.Date(getFechaVencimiento().getTime());
//		}
//		else
//		{
//			if(((SeguimientoBean)event.getObject()).getFecvencimiento() != null)
//			{
//				v = new java.sql.Date(((SeguimientoBean)event.getObject()).getFecvencimiento().getTime());
//			}
//		}
//		System.out.println("datos a guardar");
//		System.out.println("id materia " + mate);
//		System.out.println("fecha vencimiento " + v);
//		System.out.println("id registro " + idreg);
//		System.out.println("id tribunal " + idtribunal);
//		System.out.println("descripcion tribunal " + t);
//		
//		try 
//		{
//			seguimientoDAOImpl.actualizarJuicioAgrario(idreg, mate, idtribunal, v);
//			
//			System.out.println("actualizacion correcta");
//		} 
//		catch (SraajException e) 
//		{
//			System.out.println("actualizacion incorrecta"); 
//			e.printStackTrace();
//		}
//		
//		((SeguimientoBean)event.getObject()).setDescmateria(desMate);
//		((SeguimientoBean)event.getObject()).setDescripcion(t);
//		((SeguimientoBean)event.getObject()).setFecvencimiento(v);
		
    }
	
	public void onRowCancelActor(RowEditEvent event) 
	{
		
    }
	
	public String getTxtOficio() { return txtOficio; }
	public void setTxtOficio(String txtOficio) { this.txtOficio = txtOficio; }

	public Date getTxtFecha() { return txtFecha; }
	public void setTxtFecha(Date txtFecha) { this.txtFecha = txtFecha; }

	public String getTxtRequerimientoPGR() { return txtRequerimientoPGR; }
	public void setTxtRequerimientoPGR(String txtRequerimientoPGR) { this.txtRequerimientoPGR = txtRequerimientoPGR; }
	
	public String getTxtBusqueda() { return txtBusqueda; }
	public void setTxtBusqueda(String txtBusqueda) { this.txtBusqueda = txtBusqueda; }
	
	public SeguimientoDAOImpl getSeguimientoDAOImpl() { return seguimientoDAOImpl; }
	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) { this.seguimientoDAOImpl = seguimientoDAOImpl; }
	
	public List<OrdinarioCivilPenalBean> getLocpEstudioPGR() { return locpEstudioPGR; }
	public void setLocpEstudioPGR(List<OrdinarioCivilPenalBean> locpEstudioPGR) { this.locpEstudioPGR = locpEstudioPGR; }
	
	public String getTxtRegistro() { return txtRegistro; }
	public void setTxtRegistro(String txtRegistro) { this.txtRegistro = txtRegistro; }
}
