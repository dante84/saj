package mx.gob.se.sraaj.presentacion.controladores;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfWriter;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="CAsuntosJuridicos")
@SessionScoped

public class ControladorAsuntosJuridicos implements Serializable{
	
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
	
	   private String rdoSeguimientoAmparo;
	   private String txtBusquedaSeg;
	   private String estatusS;
	   private List<SeguimientoJuiciosBean> datosSeguimientoAmparo;
	   private String expinterno;
	
	   private List<DocumentosRelBean> obtenerdocumentos;
		
	   public String load(){
		   
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
	
	   public String cargar() {
		
		      if( rdoAmparo == null){ setRdoAmparo("2"); }
				
		      llenaMateria();
		
		      llenaTabla(getFechaBusqueda(), getTxtBusqueda(), getRdoAmparo());		
		
		      return "AmparoLocal";
		
	   }
		
	   public void llenaMateria(){
		
		   try{
			   setMaterias(seguimientoDAOImpl.obtenerMaterias());
			   System.out.println( materias.size() );
		   }catch ( Exception e ) { e.printStackTrace(); }
		
	   }
	
	   public void llenaTabla(Date fecha, String txt, String idjuicio){
		   
		      System.out.println("llenaTabla fecha de entrada busqueda <--- " + fecha);
		      System.out.println("llenaTabla texto de entrada busqueda <--- " + txt);
		      System.out.println("llenaTabla tipo juicio busqueda <--- " + idjuicio);
		
		      Date sqlfecha;
		
		      try{ sqlfecha = new Date(fecha.getTime()); }
		      catch (Exception e) {	sqlfecha = null; }
		
		      try{
			      setDatosSeguimiento(seguimientoDAOImpl.obtenerSeguimiento(sqlfecha, txt,Integer.parseInt(idjuicio)));
						
			      for( int i = 0; i< datosSeguimiento.size(); i++ ){
					   if(getDatosSeguimiento().get(i).getNumreg() == 0)
					{
						getDatosSeguimiento().get(i).setNumreg(null);	
					}
			}	
		} 
		catch (Exception e) { e.printStackTrace();	}
		      
	}
	
	public void busquedaPorFecha() { llenaTabla(getFechaBusqueda(), null, getRdoAmparo()); }
	
	public void busquedaPorTexto() { llenaTabla(null, getTxtBusqueda(), getRdoAmparo()); }
		
	public void onRowEdit(RowEditEvent event) {
		
		   FacesMessage msg = new FacesMessage("Registro Editado", ((SeguimientoBean) event.getObject()).getIdregDoc().toString());
           FacesContext.getCurrentInstance().addMessage(null, msg);
		
		   Integer mate = null;
		   String desMate = null;
		   Date c = null;
           Date v = null;
           Integer idreg =  null;
        
           idreg = ((SeguimientoBean)event.getObject()).getIdregDoc();
		
		   if( getMateria() != null ){
			   mate = getMateria().getIdmateria();
			   desMate = getMateria().getDescmateria();
		   }else{
			     if(((SeguimientoBean)event.getObject()).getIdmateria() != 0){
				      mate = ((SeguimientoBean)event.getObject()).getIdmateria();
				      desMate = ((SeguimientoBean)event.getObject()).getDescmateria();
			     }			
		   }
		
		   if(getFechaconven() != null)	{ c = new Date(getFechaconven().getTime()); }
		   else{
			    if(((SeguimientoBean)event.getObject()).getFecconvencional() != null){ 
			    	 c = new Date(((SeguimientoBean)event.getObject()).getFecconvencional().getTime());
 			    }
		   }
		
		   if(getFechaVencimiento() != null){ v = new Date(getFechaVencimiento().getTime()); }
		   else{
			    if(((SeguimientoBean)event.getObject()).getFecvencimiento() != null){
				     v = new Date(((SeguimientoBean)event.getObject()).getFecvencimiento().getTime());
			    }
		   }
		   
		   System.out.println("datos a guardar");
		   System.out.println("id materia " + mate);
		   System.out.println("fecha convencional " + c);
		   System.out.println("fecha vencimiento " + v);
		   System.out.println("id registro " + idreg);
		
		   try{
			    seguimientoDAOImpl.actualizarAsuntosJuridicos(idreg, mate, c, v);			
			    System.out.println("actualizacion correcta");
		   }catch (Exception e){
			       System.out.println("actualizacion incorrecta"); 
			       e.printStackTrace();
		   }
		
		   ((SeguimientoBean)event.getObject()).setDescmateria(desMate);
		   ((SeguimientoBean)event.getObject()).setFecconvencional(c);
		   ((SeguimientoBean)event.getObject()).setFecvencimiento(v);
		
		   mate = null;
		   desMate = null;
		   c = null;
           v = null;
           idreg =  null;
		   fechaconven = null;
		   fechaVencimiento = null;
		   
    }
	
	public void onRowCancel(RowEditEvent event) { }
		
	public String cargarSeguimiento(){
		
		   System.out.println("bubis");
		
		   if( rdoSeguimientoAmparo == null ){ setRdoSeguimientoAmparo("2"); }
		   
	       llenaSeguimiento(null);
	       
		   return "seguimientoAmparo";
		   
	}
	
	public void llenaSeguimiento(String txt)
	{
		try 
		{
			setDatosSeguimientoAmparo(seguimientoDAOImpl.obtenerSeguimientoJuicios(txt,Integer.parseInt(getRdoSeguimientoAmparo())));
		} 
		catch (SraajException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		SeguimientoJuiciosBean x = null;
//		for (int i = 0; i< datosSeguimientoAmparo.size(); i++) 
//		{
//			if(getDatosSeguimientoAmparo().get(i).getNumjuicio() == 0)
//			{
//				x = getDatosSeguimientoAmparo().get(i);
//				x.setNumjuicio(null);
//				datosSeguimientoAmparo.set(i, x);	
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
	
	public void generaVolante() throws Exception {
		   Document pdf = new Document();
		         ByteArrayOutputStream file = new ByteArrayOutputStream();
		      
		         try {
		                          
		             PdfWriter.getInstance(pdf, file);
		             pdf.open();
		             
		             pdf.add(new Paragraph("\n"));
		             
		             pdf.add(new Paragraph("Volante"));
		       
		         } catch (Exception ex) {
		             System.out.println("Error " + ex.getMessage());
		       }
		         pdf.close();
		         
		         FacesContext context = FacesContext.getCurrentInstance();
		         Object response = context.getExternalContext().getResponse();
		         if (response instanceof HttpServletResponse) {
		               HttpServletResponse hsr = (HttpServletResponse) response;
		               hsr.setContentType("application/pdf");
		               hsr.setHeader("Content-disposition", "attachment");
		               hsr.setContentLength(file.size());
		               try {
		                     ServletOutputStream out = hsr.getOutputStream();
		                     file.writeTo(out);
		                     out.flush();
		               } catch (IOException ex) {
		                     System.out.println("Error:  " + ex.getMessage());
		               }
		               context.responseComplete();
		         }
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


	public String getExpinterno() {
		return expinterno;
	}

	public void setExpinterno(String expinterno) {
		this.expinterno = expinterno;
	}


	public String getEstatusS() {
		return estatusS;
	}

	public void setEstatusS(String estatusS) {
		this.estatusS = estatusS;
	}

	public List<DocumentosRelBean> getObtenerdocumentos() {
		return obtenerdocumentos;
	}

	public void setObtenerdocumentos(List<DocumentosRelBean> obtenerdocumentos) {
		this.obtenerdocumentos = obtenerdocumentos;
	}

	public List<SeguimientoJuiciosBean> getDatosSeguimientoAmparo() {
		return datosSeguimientoAmparo;
	}

	public void setDatosSeguimientoAmparo(
			List<SeguimientoJuiciosBean> datosSeguimientoAmparo) {
		this.datosSeguimientoAmparo = datosSeguimientoAmparo;
	}

}
