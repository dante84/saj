package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="COCivilForaneo")
@SessionScoped
public class ControladorOrdinarioCivil implements Serializable{
	 	   
	   private static final long serialVersionUID = 1L;
	   
	   @ManagedProperty(value="#{seguimientoDAOImpl}")
	   private SeguimientoDAOImpl seguimientoDAOImpl;
	   
	   @ManagedProperty(value="#{gestionaCatDAOImpl}")
	   private GestionaCatDAOImpl gestionaCatDAOImpl;
	   	   
	   private List<CatMateriaBean>  materias;
	   private List<SeguimientoBean> datosSeguimiento;
	   
	   private CatMateriaBean materia;
	   
	   private Date fechaconven;
	   private Date fechaVencimiento;			   
	   private Date fechaBusqueda;
	   
	   private String radioOrdinarioCivilForaneo;
	   private String textoBusqueda;
	   private String textoBusquedaFecha;
	   
	   private Object[] puestos;	   	   
	   private Object[] juicios;
	   private Object[] turnados;
	   
	   private DocumentoBean db;
	   
	   private List<DocumentosRelBean> obtenerDocumentos;
	   private List<String> instruc;
	   private String noJuicio;
	   private Integer noExp;
	   private String promo;
		 
	   public String irRecepcion(){
		     
		      String ruta = null;
		      
		      ruta = "recepcionOrdinarioCivil";
		      setRadioOrdinarioCivilForaneo("9");
		      setTextoBusqueda("");
		      setTextoBusquedaFecha("");
		      
		      try{
		    	  
		    	  System.out.println( "En irRecepcion" );		    	  		    		  		    	 
		    	  		    	 
		          setMaterias( seguimientoDAOImpl.obtenerMaterias() );
		   	      llenaTabla( null,null,getRadioOrdinarioCivilForaneo() );
		   				   			   	
		      }catch(Exception e){ e.printStackTrace(); }
		      
		      return ruta;
		      		   
	   }
	   
	   public void llenaTabla(Date fecha, String txt, String idjuicio){
		   
		      System.out.println("llenaTabla fecha de entrada busqueda <--- " + fecha);
		      System.out.println("llenaTabla texto de entrada busqueda <--- " + txt);
		      System.out.println("llenaTabla tipo juicio busqueda      <--- " + idjuicio);
		
		      Date sqlfecha;
		
		      try{ sqlfecha = new Date(fecha.getTime()); }
		      catch (Exception e) {	sqlfecha = null; }
		   						  
			  try{
				  
				  setDatosSeguimiento( seguimientoDAOImpl.obtenerSeguimiento(sqlfecha,txt,new Integer(idjuicio)) );
					
				  for ( int i = 0; i < datosSeguimiento.size(); i++ ) {
					    if( getDatosSeguimiento().get(i).getNumreg() == 0 ){ getDatosSeguimiento().get(i).setNumreg(null); }
					    if( datosSeguimiento.get(i).getAcuseRecivo() == null ){ getDatosSeguimiento().get(i).setAcuseRecivo(null);  }
				  }
				  
			  }catch (Exception e) { e.printStackTrace(); }
			  
	   }
	   
	   public void busquedaPorFecha(){ 
		   
		      System.out.println("En busquedaPorFecha");
		      System.out.println(getFechaBusqueda() + " || " + getRadioOrdinarioCivilForaneo());
		      
		      llenaTabla(getFechaBusqueda(), null, getRadioOrdinarioCivilForaneo());
		      
	   }
		
	   public void busquedaPorTexto() {
		   
		      System.out.println("En busquedaPorTexto");
		      System.out.println(getTextoBusqueda());
		      System.out.println(getRadioOrdinarioCivilForaneo());
		      
			  llenaTabla(null, getTextoBusqueda(), getRadioOrdinarioCivilForaneo());
			  
	   }
	   	  
	   public void listenerRadio(){
		    
		      System.out.println("En listener Radio");
		      System.out.println(getRadioOrdinarioCivilForaneo());
		      
		      llenaTabla(null,null,getRadioOrdinarioCivilForaneo());
		   
	   }
	   
	   public void onRowEdit(RowEditEvent event) {
			
		      FacesMessage msg = new FacesMessage("Registro Editado", ((SeguimientoBean) event.getObject()).getIdregDoc().toString());
              FacesContext.getCurrentInstance().addMessage(null, msg);
		
		      Integer mate = null;
		      String desMate = null;
		      java.sql.Date c = null;
		      java.sql.Date v = null;
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
		
		      if(getFechaconven() != null)	{ c = new java.sql.Date(getFechaconven().getTime()); }
		      else{
			       if(((SeguimientoBean)event.getObject()).getFecconvencional() != null){ 
			       	    c = new java.sql.Date(((SeguimientoBean)event.getObject()).getFecconvencional().getTime());
 			       }
		      }
		
		      if(getFechaVencimiento() != null){ v = new java.sql.Date(getFechaVencimiento().getTime()); }
		      else{
			       if(((SeguimientoBean)event.getObject()).getFecvencimiento() != null){
				        v = new java.sql.Date(((SeguimientoBean)event.getObject()).getFecvencimiento().getTime());
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
	   
	   public String consultarDocumento(String idRegDoc,String idTipoJuicio){ 
		   
		      String ruta = "consultarDocumentoRegistro";
		      
		      System.out.println(idRegDoc + " || " + idTipoJuicio);
		      
		      try{ setDb( seguimientoDAOImpl.consultarDocumento( Integer.valueOf(idRegDoc),Integer.valueOf( idTipoJuicio ))); }
		      catch(Exception e){ e.printStackTrace(); }		 
		      		     
		      return ruta;
		   
	   }
	   
	   public String irSeguimiento(){ 
		    
		      String ruta = "seguimientoOrdinarioCivil";
		      
		      setRadioOrdinarioCivilForaneo("9");
		      setTextoBusqueda("");
		      setTextoBusquedaFecha("");
		      
		      try{ llenaTabla(null,null,getRadioOrdinarioCivilForaneo()); }
		      catch(Exception e){ e.printStackTrace(); }
		      
		      return ruta;
		      
	   }
	   
	   public String obtenerImg(String x) {
		     
		      System.out.println(x);

		      int numero = Integer.parseInt(x);
		      
		      if ( numero == 1 ) {  
		    	   System.out.println("entro");		    
		    	   return "okdocenpoder.png";
		      }else { return "DocEnSupoderNegro.png"; }
		      
	   }
	   
	   public void doMuestraTurnados() throws Exception {
		   
		      //String ruta = "turnarDocumento";		       
		      this.turnados = gestionaCatDAOImpl.obtieneTurnados(Integer.valueOf(getRadioOrdinarioCivilForaneo())).toArray();
		      this.puestos  = gestionaCatDAOImpl.obtienePuesto().toArray();
		      this.juicios  = gestionaCatDAOImpl.obtieneTipoJuicio().toArray();
		      //return "";
		      	
	   }
	   
	   public String cargar(String idfolio, String promo, Integer noX)
		{
			System.out.println(idfolio);
			setNoJuicio(idfolio);
			setPromo(promo);
			setNoExp(noX);
			try 
			{
				setObtenerDocumentos(seguimientoDAOImpl.obtenerDocumentos(idfolio));
			} 
			catch (SraajException e) 
			{
				e.printStackTrace();
			}
			System.out.println(obtenerDocumentos.size());
			obtenerInstruccion();
			return "documetosRel";
		}
		 
		
		public void obtenerInstruccion()
		{
			if(obtenerDocumentos != null)
			{
				for(int i = 0; i < obtenerDocumentos.size(); i++)
				{
					if(getObtenerDocumentos().get(i).getNumreg() == 0)
					{
						getObtenerDocumentos().get(i).setNumreg(null);
					}
				}
			}
		}
	   
	   public void onRowCancel(RowEditEvent event) { }

	   public String getRadioOrdinarioCivilForaneo() { return radioOrdinarioCivilForaneo; }

	   public void setRadioOrdinarioCivilForaneo(String radioOrdinarioCivilForaneo) { this.radioOrdinarioCivilForaneo = radioOrdinarioCivilForaneo; }

	   public SeguimientoDAOImpl getSeguimientoDAOImpl() { return seguimientoDAOImpl; }

	   public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) { this.seguimientoDAOImpl = seguimientoDAOImpl; }

	   public String getTextoBusqueda() { return textoBusqueda; }

	   public void setTextoBusqueda(String textoBusqueda) { this.textoBusqueda = textoBusqueda; }

	   public String getTextoBusquedaFecha() { return textoBusquedaFecha; }

	   public void setTextoBusquedaFecha(String textoBusquedaFecha) { this.textoBusquedaFecha = textoBusquedaFecha; }

	   public List<CatMateriaBean> getMaterias() { return materias; }

	   public void setMaterias(List<CatMateriaBean> materias) { this.materias = materias; }

	   public List<SeguimientoBean> getDatosSeguimiento() { return datosSeguimiento; }

	   public void setDatosSeguimiento(List<SeguimientoBean> datosSeguimiento) { this.datosSeguimiento = datosSeguimiento; }

	   public Date getFechaBusqueda() { return fechaBusqueda; }

	   public void setFechaBusqueda(Date fechaBusqueda) { this.fechaBusqueda = fechaBusqueda; }

	   public CatMateriaBean getMateria() { return materia; }

	   public void setMateria(CatMateriaBean materia) { this.materia = materia; }

	   public Date getFechaconven() { return fechaconven; }

	   public void setFechaconven(Date fechaconven) { this.fechaconven = fechaconven; }

	   public Date getFechaVencimiento() { return fechaVencimiento; }	   

	   public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

	   public DocumentoBean getDb() { return db; }

	   public void setDb(DocumentoBean db) { this.db = db; }

	   public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }

	   public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }

	   public Object[] getPuestos() { return puestos; }

	   public void setPuestos(Object[] puestos) { this.puestos = puestos; }

	   public Object[] getJuicios() { return juicios; }

	   public void setJuicios(Object[] juicios) { this.juicios = juicios; }

	   public Object[] getTurnados() { return turnados;	}

	   public void setTurnados(Object[] turnados) { this.turnados = turnados; }

	   public List<DocumentosRelBean> getObtenerDocumentos() { return obtenerDocumentos; }

	   public void setObtenerDocumentos(List<DocumentosRelBean> obtenerDocumentos) { this.obtenerDocumentos = obtenerDocumentos; }

	   public List<String> getInstruc() { return instruc; }

	   public void setInstruc(List<String> instruc) { this.instruc = instruc; }

	   public String getNoJuicio() { return noJuicio; }

	   public void setNoJuicio(String noJuicio) { this.noJuicio = noJuicio; }

	   public Integer getNoExp() { return noExp; }

	   public void setNoExp(Integer noExp) { this.noExp = noExp; }

	   public String getPromo() { return promo; }

	   public void setPromo(String promo) { this.promo = promo; }
	 	  	  
}
