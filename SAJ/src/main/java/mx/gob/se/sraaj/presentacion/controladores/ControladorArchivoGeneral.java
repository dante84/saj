package mx.gob.se.sraaj.presentacion.controladores;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import mx.gob.se.sraaj.comunes.bean.CatAutoridadBean;
import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.ConsultarBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.ResponsableBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.AdministracionAgrarioLaboralImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

@ManagedBean(name="CArchivoGeneral")
@SessionScoped
public class ControladorArchivoGeneral implements Serializable{
 
	   private static final long serialVersionUID = 1L;
	   
	   private String juicio;
	   private String instruccion;
	   private String responsable;
		
	   private String textoNumeroJuicio;
	   private String textoQuejoso;
	   private String textoRemitente;
	   private String textoSintesis;
	   private String textoNumeroOficio;
	   private String textoNumeroRegistro;
	   private String textoNumeroRegistroFin;
	   private String textoNumeroExpediente;
	   private String textoUsuario;
	   private String textoNumeroFolio;
	   private String textoJuzgado;
	   private String textoHoraRecepcion;
	   private String textoIncidenteSuspension;
	   private String textoActorDemandantePromovente;
	   private String textojAmparo;	   
	   private String textoPromovente;
	   private String textoAutoridad;
	   private String textoActor;
	   private String textoEstado;	   
	   private String textoAveriguacionPrevia;
	   private String textoMinisterioPublicoJuezDTO;
	   private String textoAcuerdoCitatorio;
	   private String textoJuicioAmparo;
	   private String textoExpedienteLaboral;
	   private String textoCedulaNotificacion;
	   private String textoAsunto;
	   
	   private String radioSuspencion;
	   private String radiosuspencionSi;
	   private String radiosuspencionNo;
	   private String rbRegDocOrdMercForaneo;
	   private String rdoTipoAsunto;
	   private String rdoLaboral;
	   
	   private String puesto;
	   private String area;
	   private String turnado;
	   private String perfil;	   
	   private String materia;
	   private String unidad;
       private String departamento;
       
       private String sIdUsuario;
       
	   private String cbmPuesto;
	   private String cbmTurnado;
	   private String cbmPerfil;
	   private String cmbMaterias;
	   private String cmbUnidad;
	   private String cbmDepartamento;
	   private String cbmArea;
	   
	   private String textoOtrosTribunal;
	   private String textoOtrosJuzgados;
	   private String textoOtrosOrganosJurisdiccionales;
	   private String textoOtrosRemitente;
	   private String textoOtrosJuezDTO;
	   
	   private String fechaImpresionVolante;
	   private String fechaOficioVolante;
	   
	   private String etiquetaBotonEditar;
	   
	   private CatGeneralBean   cgbJuicios;
	   private CatGeneralBean   cgbJuzgados;
	   private ResponsableBean  cgbResponsables;
	   private CatTribunalBean  cgbTribunal;
	   private CatAutoridadBean cgbAutoridad;
	   private CatGeneralBean   cgbEstados;
	   private CatGeneralBean   cgbOrganoJud;
	   
	   private CatGeneralBean cgbRemitente;
	   private CatGeneralBean cgbJuezDTO;
	   private DocumentoBean  cgbDocuementos;
	   private DocumentoBean  editarDocumentoBean;
	   	   
	   private List<CatGeneralBean>   lcgbJuicios;
	   private List<CatGeneralBean>   lcgbJuzgados;
	   private List<ResponsableBean>  lcgbResponsables;
	   private List<CatGeneralBean>   lcgbEstados;
	   private List<CatTribunalBean>  listaTribunal;
	   private List<CatAutoridadBean> listaAutoridad;
	   private List<CatGeneralBean>   lcgbOrganoJud;       
	   private List<DocumentoBean>    listaDocumentos;
	   private List<DocumentoBean>    listaDocumentosTemp;
	   
	   private List<CatGeneralBean> lcgbRemitente;
	   private List<CatGeneralBean> lcgbJuezDTO;
	   private List<DocumentoBean>  lDocBean;	   
   	   	   
	   private Object[] puestos;	   	   
	   private Object[] juicios;
	   private Object[] juzgados;
	   private Object[] responsables;	   	   	   
	   private Object[] turnados;
	   private Object[] perfiles;	   	   	   
	   private Object[] materias;	  	   
	   private Object[] unidades;	   
	   private Object[] departamentos;
	   private Object[] areas;
	   
	   private Object[] estados;
   	   	   	   	   	   	   	   	 
   	   private UploadedFile archivoAdjuntado;

	   private Date fechaNotificacion;
	   private Date fechaOficio;
	   private Date fechaAcuerdo;
	   private Date fechaBusquedaInicio;
	   private Date fechaBusquedaFin;
	   	   
       private UIComponent salvarPresionado;
	   
	   private boolean vieneDeSalvar;	   
	   private boolean cbOficioSNJuicio;
	   private boolean renderDialogoVolante;
	   private boolean editable;
	   
	   private int numeroRegistro;
	   
	   private List<ConsultarBean> datos;

	   public ConsultarBean dats;	
	   
	   @ManagedProperty(value="#{gestionaCatDAOImpl}")
	   private GestionaCatDAOImpl gestionaCatDAOImpl;
	   
	   @ManagedProperty(value="#{administracionAgrarioLaboralDAOImpl}")
	   private AdministracionAgrarioLaboralImpl administracionAgrarioLaboralDAOImpl;
	   
	   @ManagedProperty(value = "#{usuariosBeanImpl}")
	   private UsuariosBeanImpl usuariosBeanImpl;
		
	   @ManagedProperty(value="#{sesionBean}")
	   private SesionBeanImpl sesionBean;
	   
	   @ManagedProperty(value="#{seguimientoDAOImpl}")
	   private SeguimientoDAOImpl seguimientoDAOImpl;
	   	   	   	   	 
	   public String doMuestraRegistraExpediente() {
		   
		      String ruta = "registrarDocumento";
		      
		      System.out.println("En " + ruta);
		      System.out.println(getCgbJuicios());
		      
		      setRenderDialogoVolante(false);
		      
		      try{ llenaListas(); }
		      catch(Exception e){ e.printStackTrace(); }		      		      
		      		      
		      return ruta;
		      
	   }	    
	   	   	   	   	   	  
	   public String doMuestraPuesto() {
		   
		      String ruta = "RegistroUsuario";
		      
		      try { puestos = gestionaCatDAOImpl.obtienePuesto().toArray(); }
		      catch (Exception e) {	e.printStackTrace(); }
		      
		      return ruta;
		      
	   }	    
	    	   	   	   
	   public void llenaListas(){
		   		      
		      try{ 
	    	   
	    	      lcgbJuicios = new ArrayList<CatGeneralBean>();
	    	      lcgbJuzgados = new ArrayList<CatGeneralBean>();
	    	      lcgbEstados = new ArrayList<CatGeneralBean>();
	    	   
	    	      for( CatGeneralBean gcdi : gestionaCatDAOImpl.obtieneTipoJuicio() ){	    	    	   
	    		       CatGeneralBean cgb = new CatGeneralBean();	    		       
	    		       cgb.setiActivo(gcdi.getiActivo());
	    		       cgb.setIdCir(gcdi.getIdCir());
	    		       cgb.setIdMas(gcdi.getIdMas());
	    		       cgb.setiEstados(gcdi.getiEstados());
	    		       cgb.setsDescripcionCat(gcdi.getsDescripcionCat());
	    		       cgb.setsIdCat(gcdi.getsIdCat());
                       lcgbJuicios.add(cgb);     		    		    
	    	      }	    	   	 
	    	      
	    	      for( CatGeneralBean gcdi : gestionaCatDAOImpl.obtieneEdos()) {	    	    	  
	    	    	   CatGeneralBean cgb = new CatGeneralBean();
	    	    	   cgb.setiActivo(gcdi.getiActivo());
	    	    	   cgb.setIdCir(gcdi.getIdCir());
	    	    	   cgb.setIdMas(gcdi.getIdMas());
	    	    	   cgb.setiEstados(gcdi.getiEstados());
	    	    	   cgb.setsDescripcionCat(gcdi.getsDescripcionCat());
	    	    	   cgb.setsIdCat(gcdi.getsIdCat());
	    	    	   lcgbEstados.add(cgb);	    	    	    
	    	      }
	    	   
	          }catch( Exception e ){
	        	      e.printStackTrace(); 
	    	          FacesContext.getCurrentInstance().addMessage("",
	    	    		                                     new FacesMessage("Error",
	    	    		                                                      "Ocurrio un error al acceder a la base de datos.Intenta mas tarde"));	    	         
	          }	   
		   
	   }	   	   
	   
	   public String registraExpediente(){
		   
		      System.out.println("En registraExpediente");
		    
		      String ruta = "dialogo";
		      
		      String pattern = "dd/MM/yyyy";
		      SimpleDateFormat format = new SimpleDateFormat(pattern);
		      
		      SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
		      
		      int juicio = getCgbJuicios().getsIdCat();
		      boolean resultadoInsercion = false;
		      
		      Date fechaActual = new Date(); 		      		      
		      
		      try{
		    	  		          
                  DocumentoBean ndb = new DocumentoBean();
                                    		     
    		      if( getTextoNumeroFolio() == null || getTextoNumeroFolio().equals("") ){ ndb.setsFolio(""); }
    		      else{ ndb.setsFolio(getTextoNumeroFolio().trim() ); }
    		      		      
    		      if( getTextoNumeroRegistro() == null || getTextoNumeroRegistro().equals("") ){ ndb.setiNumeroRegistro(0); }
    		      else{ ndb.setiNumeroRegistro(Integer.valueOf(getTextoNumeroRegistro().trim())); }    		          		      
    		      
    		      if( getTextoNumeroExpediente() == null || getTextoNumeroExpediente().equals("") ){ ndb.setsFechaRecepcion(formatoHora.format(fechaActual)); }
    		      else{ ndb.setiNumeroExpediente(Integer.valueOf(getTextoNumeroExpediente().trim())); }
    		      
    		      if( getTextoHoraRecepcion() == null || getTextoHoraRecepcion().equals("") ){ ndb.setiNumeroExpediente(0); }
    		      else{ ndb.setsFechaRecepcion( formatoHora.format( new SimpleDateFormat("HH:mm").parse(getTextoHoraRecepcion().trim()))); }
    		          		      
    		      if( getRadioSuspencion() == null ) { ndb.setiIncidenteSuspencion(0); }
    		      else{ 
    		    	   if( getRadioSuspencion().trim().equals("0") ){ ndb.setiIncidenteSuspencion(0); }
    		    	   else{ ndb.setiIncidenteSuspencion(1); }
    		      }
    		      
    		      if( getCgbAutoridad() == null ) { ndb.setiIdAutoridadResponsable(0); }
    		      else{
    		           if( getCgbAutoridad().getIdAutoridad() == 0 ){ ndb.setiIdAutoridadResponsable(0); }
    		  	       else{ ndb.setiIdAutoridadResponsable(getCgbAutoridad().getIdAutoridad()); }
    		      }
    		      
    		      if( isCbOficioSNJuicio() ){ ndb.setiOficioSinJuicio(1); }
    		      else{ ndb.setiOficioSinJuicio(0); }
    		      
		          ndb.setiIdJuicio                      ( new Integer(getCgbJuicios().getsIdCat()) != null ? getCgbJuicios().getsIdCat()                    : 0                          );
		          ndb.setsFechaOficio                   ( getFechaOficio()                         != null ? format.format(getFechaOficio())                : format.format(fechaActual) );
		          ndb.setsNumeroJuicio                  ( getTextoNumeroJuicio()                   != null ? getTextoNumeroJuicio().trim()                  : ""                         );
		          ndb.setsPromovente                    ( getTextoPromovente()                     != null ? getTextoPromovente().trim()                    : ""                         );
		          ndb.setsRemitente                     ( getTextoRemitente()                      != null ? getTextoRemitente().trim()                     : ""                         );
		          ndb.setsFechaNotificacion             ( getFechaNotificacion()                   != null ? format.format(getFechaNotificacion())          : format.format(fechaActual) );
		          ndb.setsSint                          ( getTextoSintesis()                       != null ? getTextoSintesis().trim()                      : ""                         );
		          ndb.setsDecCatTribunal                ( getCgbTribunal()                         != null ? getCgbTribunal().getDecripcion().trim()        : ""                         );
		          ndb.setsAct                           ( getTextoActor()                          != null ? getTextoActor().trim()                         : ""                         );
		          ndb.setsNomEstado                     ( getTextoEstado()                         != null ? getTextoEstado().trim()                        : ""                         );
		          ndb.setsDescCatResponsable            ( getResponsable()                         != null ? getResponsable().trim()                        : ""                         );
		          ndb.setsNumeroOficio                  ( getTextoNumeroOficio()                   != null ? getTextoNumeroOficio().trim()                  : ""                         );
		          ndb.setsOtrosTribunal                 ( getTextoOtrosTribunal()                  != null ? getTextoOtrosTribunal().trim()                 : ""                         );
		          ndb.setsOtrosJuzgados                 ( getTextoOtrosJuzgados()                  != null ? getTextoOtrosJuzgados().trim()                 : ""                         );
		          ndb.setsOtrosOrganosJurisdiccionales  ( getTextoOtrosOrganosJurisdiccionales()   != null ? getTextoOtrosOrganosJurisdiccionales().trim()  : ""                         );
		          ndb.setsOtrosRemitente                ( getTextoOtrosRemitente()                 != null ? getTextoOtrosRemitente().trim()                : ""                         );
		          ndb.setsOtrosJuezDTO                  ( getTextoOtrosJuezDTO()                   != null ? getTextoOtrosJuezDTO().trim()                  : ""                         );
		          ndb.setsJuicioAmparo                  ( getTextoJuicioAmparo()                   != null ? getTextoJuicioAmparo().trim()                  : ""                         );
		          ndb.setsAcuerdoCitatorio              ( getFechaAcuerdo()                        != null ? format.format(getFechaAcuerdo())               : format.format(fechaActual) );
		          ndb.setsQuejoso                       ( getTextoQuejoso()                        != null ? getTextoQuejoso().trim()                       : ""                         );
		          ndb.setsCedulaNotificacion            ( getTextoCedulaNotificacion()             != null ? getTextoCedulaNotificacion().trim()            : ""                         );
		          		          		          
		          System.out.println("juicio = " + juicio);
		          System.out.println(ndb.getsFechaOficio() + " || " + ndb.getsFechaNotificacion());
		          
		          switch( juicio ){
		           
		                  case 1: resultadoInsercion = gestionaCatDAOImpl.insertaAgrario(ndb); break;
		                  
		                  case 2: case 3: case 4: resultadoInsercion = gestionaCatDAOImpl.insertaAFLM(ndb); break;
		                  
		                  case 6: 
		                	      System.out.println("En el case 6 de " + juicio);
		                	      resultadoInsercion = gestionaCatDAOImpl.insertaLaboral(ndb);
		                  break;
		                  
		                  case 7: case 9: case 14:  resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoML(ndb); break;
		                  
		                  case 8: case 10: case 15: resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoMF(ndb); break;
		                  		                  
		                  case 11: resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoMF(ndb); break;
		                  
		                  case 12: resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoPN(ndb); break;
		                  
		                  default: break;
		               
		          }
		          		          		          
		           		          
		          System.out.println("resultadoInsercion " + resultadoInsercion);
		          
		          if( resultadoInsercion ){
		        			        	  
		        	  FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		        	  FacesContext.getCurrentInstance().addMessage("",new FacesMessage("","Documento insertado correctamente"));
		        	  		        	 
		        	  //setRenderDialogoVolante(true);
		        	  
		        	  //System.out.println("renderDialogoVolante " + isRenderDialogoVolante());

		        	  setFechaImpresionVolante(format.format(new Date()));
		        	  setFechaOficioVolante(format.format(getFechaOficio()));
		        	  
		        	  return ruta;
		        	  
		          }else{ 
		        	     FacesContext.getCurrentInstance().addMessage("",new FacesMessage("Hubo un error en la base de datos","Intentar mas tarde por favor"));
		          }
		    	    
		      }catch(Exception e){ e.printStackTrace(); }
		      		      
		      return null;
		   
	   }

		public String registraExpedienteMF() {
			
			   String ruta = "bienvenido";

			String pattern = "dd/MM/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);

			try {

				DocumentoBean ndb = new DocumentoBean();

				ndb.setiIdJuicio(getCgbJuicios().getsIdCat());
				ndb.setsNumeroJuicio(getTextoNumeroJuicio());
				ndb.setiIdJuzgado(getCgbJuzgados().getsIdCat());
				ndb.setsRemitente(getTextoRemitente());
				ndb.setsAct(getTextoActor());
				ndb.setiEstado(getCgbEstados().getiEstados());
				ndb.setsSint(getTextoSintesis());
				ndb.setsNumeroOficio(getTextoNumeroOficio());
				ndb.setsFechaOficio(format.format(getFechaOficio()));
				ndb.setiNumeroRegistro(Integer.parseInt(getTextoNumeroRegistro()));
				ndb.setiIdResponsable(getCgbResponsables().getNombre());
				
				boolean resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoMF(ndb);

				System.out.println("resultadoInsercion " + resultadoInsercion);

				if (resultadoInsercion) {
					FacesContext.getCurrentInstance().getExternalContext()
							.getFlash().setKeepMessages(true);
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("",
									"Documento insertado correctamente"));
					limpiaForma();
					return ruta;
				} else {
					limpiaForma();
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("Hubo un error en la base de datos","Intentar mas tarde por favor"));
				}

			} catch (Exception e) { e.printStackTrace(); }

			limpiaForma();

			return null;

		}
		
		public String registraExpedienteML() {
			System.out.println("========>> en CArchivoGeneral.registraExpedienteML");
			
			String ruta = "bienvenido";

			String pattern = "dd/MM/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);

			try {

				DocumentoBean ndb = new DocumentoBean();

				ndb.setiIdJuicio(getCgbJuicios().getsIdCat());
				ndb.setsNumeroJuicio(getTextoNumeroJuicio());
				ndb.setiIdJuzgado(getCgbJuzgados().getsIdCat());
				ndb.setsRemitente(getTextoRemitente());
				ndb.setsAct(getTextoActor());
				ndb.setsSint(getTextoSintesis());
				ndb.setsNumeroOficio(getTextoNumeroOficio());
				ndb.setsFechaOficio(format.format(getFechaOficio()));
				ndb.setiNumeroRegistro(Integer.parseInt(getTextoNumeroRegistro()));
				ndb.setiIdResponsable(getCgbResponsables().getIdResponsable());

				boolean resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoML(ndb);

				System.out.println("resultadoInsercion " + resultadoInsercion);

				if (resultadoInsercion) {
					FacesContext.getCurrentInstance().getExternalContext()
							.getFlash().setKeepMessages(true);
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("",
									"Documento insertado correctamente"));
					limpiaForma();
					return ruta;
				} else {
					limpiaForma();
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("Hubo un error en la base de datos",
									"Intentar mas tarde por favor"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			limpiaForma();

			return null;

		}

		public String registraExpedientePN() {
			
			System.out.println("========>> en CArchivoGeneral.registraExpedientePN");
			
			String ruta = "bienvenido";

			String pattern = "dd/MM/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);

			try {

				DocumentoBean ndb = new DocumentoBean();

				ndb.setiIdJuicio(getCgbJuicios().getsIdCat());
				ndb.setsNumeroOficio(getTextoNumeroOficio());
				ndb.setsFechaOficio(format.format(getFechaOficio()));
				ndb.setiIdCatRemitente(getCgbRemitente().getsIdCat());
				ndb.setsSint(getTextoSintesis());
				ndb.setiNumeroExpediente(Integer.parseInt(getTextoNumeroExpediente()));
//				ndb.setiJuezDto(Integer.parseInt(getCgbJuezDTO().getsIdCat()));
				ndb.setsAveriguacionPrevia(getTextoAveriguacionPrevia());
				ndb.setiNumeroRegistro(Integer.parseInt(getTextoNumeroRegistro()));
				ndb.setiIdResponsable(getCgbResponsables().getNombre());

				boolean resultadoInsercion = gestionaCatDAOImpl.insertaNuevoDocumentoPN(ndb);

				System.out.println("resultadoInsercion " + resultadoInsercion);

				if (resultadoInsercion) {
					FacesContext.getCurrentInstance().getExternalContext()
							.getFlash().setKeepMessages(true);
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("",
									"Documento insertado correctamente"));
					limpiaForma();
					return ruta;
				} else {
					limpiaForma();
					FacesContext.getCurrentInstance().addMessage(
							"",
							new FacesMessage("Hubo un error en la base de datos",
									"Intentar mas tarde por favor"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			limpiaForma();

			return null;

		}
		
	   public String doMuestraArea() throws Exception {
		   
		      String ruta = "RegistroUsuario";		       
		      areas = gestionaCatDAOImpl.obtieneDepartamento().toArray();
		      
		      for( int i = 0; i < puestos.length; i++ ){ System.out.println(puestos[i]); }
		      
		      return ruta;
		      
	   }
	   
	   public void listenerJuicios(){
		   		      
		      int juicio = getCgbJuicios().getsIdCat();
		      
		      System.out.println( juicio );
		      
		      llenaJuzgadosResponsables();
		      
		      try{ 
		    	  setTextoNumeroRegistro( String.valueOf( gestionaCatDAOImpl.selectNumeroRegistro() + 1 ) );
		    	  System.out.println( "getTextoNumeroRegistro() " + getTextoNumeroRegistro() );
		      }catch (Exception e) { e.printStackTrace(); }
		      
		      
		      		      		      
		      switch( juicio ){
		       
		              case 1: case 6: 
		            	             llenaTribunal();
		            	             llenaAutoridad();
		            	             setRdoLaboral("1");
		              break;
		             
		              case 2: case 3: case 4: case 9: case 10: llenaJuzgados(); break;		              
		             
		              case 11: llenaOrganoJurid(); break;
		             
		              case 12: llenaRemitente();
		              		   llenaJuezDTO(); 		              
		              break;
		             
		              default: break;
		      
		      }
    	   		     
	   }

	   public void llenaTribunal(){
	   
  	          try {
	               setListaTribunal(getAdministracionAgrarioLaboralDAOImpl().obtieneTribunal());
	          } catch (Exception e1) { e1.printStackTrace(); }
  	          
	   }
	   
	   public void llenaRemitente(){
		   
		      try {
				setLcgbRemitente(gestionaCatDAOImpl.obtieneRemitente(String.valueOf(getCgbJuicios().getsIdCat())));
			} catch (SraajException e) {
				e.printStackTrace();
			}
	   }
	   
	   public void llenaJuezDTO(){
		try {
			setLcgbJuezDTO(gestionaCatDAOImpl.obtieneJuezDTO(String.valueOf(getCgbJuicios().getsIdCat())));
		} catch (SraajException e) {
			e.printStackTrace();
		}   
	   }

	   public void llenaAutoridad(){

		      try { setListaAutoridad(getAdministracionAgrarioLaboralDAOImpl().obtenerAutoridad()); }
		      catch (Exception e) { e.printStackTrace(); }
	     
	   }
	   
	   public void llenaJuzgadosResponsables() {
		   
		      System.out.println("========>> en llenaJuzgadosResponsables");
		      System.out.println("========>> " + getCgbJuicios().getsIdCat());
		      System.out.println("========>> " + getCgbJuicios().getsDescripcionCat());
		      
		      setLcgbJuzgados(new ArrayList<CatGeneralBean>());
		      setLcgbResponsables(new ArrayList<ResponsableBean>());
		      
		      try {
                   setLcgbJuzgados(gestionaCatDAOImpl.obtieneJuzgados(String.valueOf(getCgbJuicios().getsIdCat())));                                                         
                   setLcgbResponsables(gestionaCatDAOImpl.obtieneResponsable(String.valueOf(getCgbJuicios().getsIdCat())));
                   
		      }catch(Exception e){ e.printStackTrace(); }
		   
	   }
	  
	   public void llenaResponsabel(){
         
		   try {
			setLcgbResponsables(gestionaCatDAOImpl.obtieneResponsable(String.valueOf(getCgbJuicios().getsIdCat())));
		} catch (SraajException e) {
			e.printStackTrace();
		}
	   }
	   
	   public void llenaJuzgados(){
		    
		      setLcgbJuzgados(new ArrayList<CatGeneralBean>());
		      
		      try{		      		          
	    	   
		    	  setLcgbJuzgados(gestionaCatDAOImpl.obtieneJuzgados(String.valueOf(getCgbJuicios().getsIdCat()))); 	                           	        
 	          
		      }catch(Exception e){ e.printStackTrace(); }
		   
	   }
	   	   	   
	   public void procesaArchivoAdjuntado(){ System.out.println(getArchivoAdjuntado().getFileName()); }
	   	   
	   public String doMuestraDepartamento() throws Exception {
		   
		      String ruta = "RegistroUsuario";		       
		      departamentos = gestionaCatDAOImpl.obtieneDepartamento().toArray();
		      
		      return ruta;
		      
	   }
	   	   
  	   public String doMuestraUnidad() throws Exception {
  		   
		      String ruta = "RegistroUsuario";
		      
		      unidades = gestionaCatDAOImpl.obtieneUnidadAdministrativa().toArray();
		      
		      return ruta;
		      
	   } 
                      
	   public String doMuestraMaterias() throws Exception {
		   
		      String ruta = "RegistroUsuario";
		      
		      materias = gestionaCatDAOImpl.obtieneMateria().toArray();
		      
		      return ruta;
		      
	   }
	                 	   
	   public String doMuestraPerfil() throws Exception {
		   
		      String ruta = "RegistroUsuario";
		      
		      perfiles = gestionaCatDAOImpl.obtienePerfiles().toArray();
		      
		      return ruta;
		      
	   }
       
       
	   public String doCargaDdl() throws Exception {
		   
		      String ruta = "RegistroUsuario";
		      
		      this.doMuestraPuesto();
		      this.doMuestraArea();
		      this.doMuestraDepartamento();
		      this.doMuestraMaterias();
		      this.doMuestraPerfil();
		      this.doMuestraUnidad();
		      
		      return ruta;
		      
	   }
	   	   	   	   
	   public void doMuestraTurnados() throws Exception {
		   
		      //String ruta = "turnarDocumento";		       
		      this.turnados = gestionaCatDAOImpl.obtieneTurnados(Integer.valueOf(getTextoNumeroJuicio())).toArray();
		      this.puestos  = gestionaCatDAOImpl.obtienePuesto().toArray();
		      this.juicios  = gestionaCatDAOImpl.obtieneTipoJuicio().toArray();
		      //return "";
		      	
	   }
	   
	   public String consultarDocumento(){
		   		      		   
		      llenaListas();
		   
		      return "consultarDocumento";
		      
	   }
	   
	   public void buscarDocumento(){
		   
		      String pattern = "dd/MM/yyyy";
		      SimpleDateFormat format = new SimpleDateFormat(pattern);
		      
		      SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
		      		      
		      Date fechaActual = new Date();
		   		     
		      DocumentoBean documentoBean = new DocumentoBean();
		      
		      System.out.println(getCgbJuicios().getsIdCat());
		      System.out.println(getTextoNumeroJuicio());
		      System.out.println(getFechaNotificacion());
		      System.out.println(getTextoRemitente());
		      System.out.println(getTextoNumeroRegistro());
		      		      
		      documentoBean.setiIdJuicio       ( new Integer(getCgbJuicios().getsIdCat()) != null ? getCgbJuicios().getsIdCat()               : 0    );
		      documentoBean.setsNumeroJuicio   ( getTextoNumeroJuicio()                   != null ? getTextoNumeroJuicio()                    : null );
		      documentoBean.setsQuejoso        ( getTextoQuejoso()                        != null ? getTextoQuejoso()                         : null );
		      documentoBean.setsRemitente      ( getTextoRemitente()                      != null ? getTextoRemitente()                       : null );
		      documentoBean.setsNumeroOficio   ( getTextoNumeroOficio()                   != null ? getTextoNumeroOficio()                    : null );
		      
		      if( getTextoNumeroFolio() == null || getTextoNumeroFolio().equals("") ){ documentoBean.setsFolio(""); }
		      else{ documentoBean.setsFolio(getTextoNumeroFolio().trim() ); }
		      		      
		      if( getTextoNumeroRegistro() == null || getTextoNumeroRegistro().equals("") ){ documentoBean.setiNumeroRegistro(0); }
		      else{ documentoBean.setiNumeroRegistro(Integer.valueOf(getTextoNumeroRegistro().trim())); }
		      
		      if( getTextoNumeroExpediente() == null || getTextoNumeroExpediente().equals("") ){ documentoBean.setsFechaRecepcion(formatoHora.format(fechaActual)); }
		      else{ documentoBean.setiNumeroExpediente(Integer.valueOf(getTextoNumeroExpediente().trim())); }
		      
		      documentoBean.setsFechaOficio    ( getFechaNotificacion()                   != null ? format.format(getFechaNotificacion())     : null );		      
		      
		      try{
		    	  
		    	  setListaDocumentos(gestionaCatDAOImpl.buscarDocumento(documentoBean));
		    	  setListaDocumentosTemp(getListaDocumentos());
		    	  												  
			  } catch (Exception e) { e.printStackTrace(); }
		      		   
	   }
	   	   
	   public String cancelarRegistro(){
		    		        
		      return "registrarDocumento?faces-redirect=true";
		   
	   }
	   
	   public void limpiaForma1(){
		    
		      UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
		      UIComponent fc = view.findComponent("forma");
		      
		      System.out.println("fc " + fc.getId() );
		      
		      if (null != fc) {
		          List<UIComponent> components = fc.getChildren();
		          for (UIComponent component : components) {
		               if (component instanceof UIInput) {
		            	   
		                   UIInput input = (UIInput) component;
		                    // JSF 1.1+
//		                input.setSubmittedValue(null);
//		                input.setValue(null);
//		                input.setLocalValueSet(false);
//		                input.setValid(true);
		                    // JSF 1.2+
		                   input.resetValue();
		               }
		          }
		     
		      }
		   
	   }
	   
	   public void limpiaForma() {
		   
			setJuicio(""); 
			setInstruccion(""); 
			setResponsable(""); 
			setTextoNumeroJuicio("");
			setTextoQuejoso("");
			setTextoRemitente(""); 
			setTextoActorDemandantePromovente("");
			setTextoSintesis(""); 
			setTextoNumeroOficio ("");
			setTextoNumeroRegistro(""); 
			setTextoNumeroExpediente(""); 
			setTextoUsuario (""); 
			setTextoNumeroFolio(""); 
			setTextoJuzgado(""); 
			setTextoHoraRecepcion("");
			setTextoIncidenteSuspension("");
			setTextoPromovente("");
			setTextoAutoridad("");
			setTextoActor("");
			setTextoEstado("");
			setTextoNumeroRegistro("");
			
			setRadioSuspencion("Si");
//			private String rbRegDocOrdMercForaneo;
			setRdoTipoAsunto("Amparo");
			setPuesto("");
			setArea("");
			setTurnado("");
			setPerfil("");
			setMateria("");
			setUnidad("");
			setDepartamento("");
			
			setsIdUsuario("");
			setCbmPuesto("");
			setCbmTurnado("");
			setCbmPerfil("");
			setCbmDepartamento("");
			setCbmArea("");
			setCmbMaterias("");
			setCmbUnidad("");
			
			setCgbJuicios(new CatGeneralBean());
			setCgbJuzgados(new CatGeneralBean());
			setCgbResponsables(new ResponsableBean());
			setCgbEstados(new CatGeneralBean());
			setCgbDocuementos(new DocumentoBean());

			setLcgbJuicios(new ArrayList<CatGeneralBean>());
			setLcgbJuzgados(new ArrayList<CatGeneralBean>());
			setLcgbResponsables(new ArrayList<ResponsableBean>());
			setLcgbEstados(new ArrayList<CatGeneralBean>());
			setlDocBean(new ArrayList<DocumentoBean>());

//			private Object[] puestos;
//			private Object[] juicios;
//			private Object[] juzgados;
//			private Object[] responsables;
//			private Object[] turnados;
//			private Object[] perfiles;
//			private Object[] materias;
//			private Object[] unidades;
//			private Object[] estados;
//			private Object[] departamentos;
//			private Object[] areas;
			
//			private UploadedFile archivoAdjuntado;

			setFechaNotificacion(new Date());
			setFechaOficio(new Date());
			setFechaBusquedaInicio(new Date());
			setFechaBusquedaFin(new Date());
			
		}
	   
	   public String limpiaCampos(){
		   
		      limpiaForma();
		   
		      return null;
		     
	   }
	   
	   public void generaVolante(){ 
		   		     
		      try{
		    	  
		    	  Document pdf = new Document();
		    	  pdf.setPageSize(PageSize.A4);
		    	  PdfWriter.getInstance(pdf,new FileOutputStream("Reporte.pdf"));
		    	  
		    	  pdf.open();
		    	  
		    	  Paragraph parrafo = new Paragraph();
		    	  
		    	  parrafo.add("Numero de Expediente: " + getTextoNumeroExpediente()              != null ? getTextoNumeroExpediente()            : "");
		    	  parrafo.add("Numero de Registro: "   + getTextoNumeroRegistro()                != null ? getTextoNumeroRegistro()              : "");
		    	  parrafo.add("Tipo de Juicio: "       + getCgbJuicios().getsDescripcionCat()    != null ? getCgbJuicios().getsDescripcionCat()  : "");
		    	  parrafo.add("Numero de Juicio: "     + getTextoNumeroJuicio()                  != null ? getTextoNumeroJuicio()                : "");
		    	  parrafo.add("Tribunal: "             + getCgbJuzgados().getsDescripcionCat()   != null ? getCgbJuzgados().getsDescripcionCat() : "");
		    	  parrafo.add("Remitente: "            + getTextoRemitente()                     != null ? getTextoRemitente()                   : "");
		    	  parrafo.add("Sintesis: "             + getTextoSintesis()                      != null ? getTextoSintesis()                    : "");
		    	  parrafo.add("Folio: "                + getTextoNumeroFolio()                   != null ? getTextoNumeroFolio()                 : "");
		    	  parrafo.add("Numero de Oficio: "     + getTextoNumeroOficio()                  != null ? getTextoNumeroOficio()                : "");
		    	  parrafo.add("Fecha de Oficio: "      + getFechaOficio().toString()             != null ? getFechaOficio().toString()           : "");
		    	  
		    	  pdf.add(parrafo);
		    	  pdf.close();		    	  
		    	  
		      }catch(Exception e){ e.printStackTrace(); } 
		      
	   }
	   
	   public void llenaOrganoJurid(){
		      
	         setLcgbOrganoJud(new ArrayList<CatGeneralBean>());
	        
	         try{ lcgbOrganoJud = gestionaCatDAOImpl.obtieneOrganoJud(); }
	         catch(Exception e){ e.printStackTrace(); }
	     
	   }
	   
	   public void prueba(){		   		      
		   		     
		      Map<String,Object> options = new HashMap<String, Object>();
		      
		      options.put("modal", true);
		      options.put("draggable", false);
		      options.put("resizable", false);
		      options.put("contentHeight", 320);
		         
		      RequestContext.getCurrentInstance().openDialog("dialogo", options, null);
		      
	   }
	   
	   public String editarDocumentoConsulta(String idRegDoc,String iNumeroRegistro){
		    
		      setEditable(true);
		   
		      System.out.println("En editarDocumentoConsulta");
		      System.out.println(idRegDoc);
		      System.out.println(iNumeroRegistro);
		    
		      String ruta = "editarDocumentoConsulta";
		      
		      try{
		    	  
		    	  setEditarDocumentoBean( gestionaCatDAOImpl.consultaDocumentoEditar(Integer.valueOf(idRegDoc),Integer.valueOf(iNumeroRegistro)) );
		    	  		    	  
		      } catch (Exception e) { e.printStackTrace(); }
		      
		      return ruta;
		   
	   }
	   
	   public void editarCampos(){
		   
		      System.out.println( "En editarCampos" );
		      System.out.println( isEditable()      );
		   
		      if( isEditable() ){ 
		    	  
		    	  System.out.println( getEditarDocumentoBean().getsNumeroOficio()   );
		    	  System.out.println( getEditarDocumentoBean().getiNumeroRegistro() );
		    	  setEditable(false);
		    	  
		      }else{ setEditable(true); }
		      
	   }
	   	   
	   public String getResponsable() {	return responsable; }

	   public void setResponsable(String responsable) { this.responsable = responsable; }

	   public String getTextoNumeroJuicio() { return textoNumeroJuicio; }

	   public void setTextoNumeroJuicio(String textoNumeroJuicio) { this.textoNumeroJuicio = textoNumeroJuicio; }

	   public String getTextoQuejoso() { return textoQuejoso; }

	   public void setTextoQuejoso(String textoQuejoso) { this.textoQuejoso = textoQuejoso;	}

	   public String getTextoRemitente() { return textoRemitente; }

	   public void setTextoRemitente(String textoRemitente) { this.textoRemitente = textoRemitente; }

	   public String getTextoSintesis() { return textoSintesis; }

	   public void setTextoSintesis(String textoSintesis) { this.textoSintesis = textoSintesis; }

	   public String getTextoNumeroOficio() { return textoNumeroOficio; }

	   public void setTextoNumeroOficio(String textoNumeroOficio) { this.textoNumeroOficio = textoNumeroOficio; }

	   public String getTextoNumeroRegistro() { return textoNumeroRegistro; }

	   public void setTextoNumeroRegistro(String textoNumeroRegistro) { this.textoNumeroRegistro = textoNumeroRegistro;	}

	   public String getTextoJuzgado() { return textoJuzgado; }

	   public void setTextoJuzgado(String textoJuzgado) { this.textoJuzgado = textoJuzgado;	}

	   public Date getFechaNotificacion() { return fechaNotificacion; }

	   public void setFechaNotificacion(Date fechaNotificacion) { this.fechaNotificacion = fechaNotificacion; }

	   public Date getFechaOficio() { return fechaOficio; }

	   public void setFechaOficio(Date fechaOficio) { this.fechaOficio = fechaOficio; }

	   public Date getFechaBusquedaInicio() { return fechaBusquedaInicio; }

	   public void setFechaBusquedaInicio(Date fechaBusquedaInicio) { this.fechaBusquedaInicio = fechaBusquedaInicio; }

	   public Date getFechaBusquedaFin() { return fechaBusquedaFin; }

	   public void setFechaBusquedaFin(Date fechaBusquedaFin) { this.fechaBusquedaFin = fechaBusquedaFin; }

	   public String getTextoHoraRecepcion() { return textoHoraRecepcion; }

	   public void setTextoHoraRecepcion(String textoHoraRecepcion) { this.textoHoraRecepcion = textoHoraRecepcion;	}

	   public String getTextoIncidenteSuspension() { return textoIncidenteSuspension; }

	   public void setTextoIncidenteSuspension(String textoIncidenteSuspension) { this.textoIncidenteSuspension = textoIncidenteSuspension;	}

	   public String getTextoPromovente() {	return textoPromovente; }

	   public void setTextoPromovente(String textoPromovente) { this.textoPromovente = textoPromovente; }

	   public String getTextoUsuario() { return textoUsuario; }

	   public void setTextoUsuario(String textoUsuario) { this.textoUsuario = textoUsuario; }

	   public String getTextoNumeroExpediente() { return textoNumeroExpediente;	}

	   public void setTextoNumeroExpediente(String textoNumeroExpediente) { this.textoNumeroExpediente = textoNumeroExpediente; }

	   public String getTextoNumeroFolio() { return textoNumeroFolio; }

	   public void setTextoNumeroFolio(String textoNumeroFolio) { this.textoNumeroFolio = textoNumeroFolio; }

	   public String getTextoAutoridad() { return textoAutoridad; }

	   public void setTextoAutoridad(String textoAutoridad) { this.textoAutoridad = textoAutoridad; }

	   public String getRadioSuspencion() { return radioSuspencion; }

	   public void setRadioSuspencion(String radioSuspencion) { this.radioSuspencion = radioSuspencion; }

	   public String getRadiosuspencionSi() { return radiosuspencionSi; }

	   public void setRadiosuspencionSi(String radiosuspencionSi) { this.radiosuspencionSi = radiosuspencionSi; }

	   public String getRadiosuspencionNo() { return radiosuspencionNo; }

	   public void setRadiosuspencionNo(String radiosuspencionNo) { this.radiosuspencionNo = radiosuspencionNo; }

	   public UploadedFile getArchivoAdjuntado() { return archivoAdjuntado; }

	   public void setArchivoAdjuntado(UploadedFile archivoAdjuntado) { this.archivoAdjuntado = archivoAdjuntado; }

	   public Object[] getResponsables() { return responsables; }

	   public void setResponsables(Object[] responsables) { this.responsables = responsables; }

	   public CatGeneralBean getCgbJuicios() { return cgbJuicios; }

	   public void setCgbJuicios(CatGeneralBean cgbJuicios) { this.cgbJuicios = cgbJuicios; }

	   public ResponsableBean getCgbResponsables() { return cgbResponsables; }

	   public void setCgbResponsables(ResponsableBean cgbResponsables) { this.cgbResponsables = cgbResponsables; }

	   public List<CatGeneralBean> getLcgbJuicios() { return lcgbJuicios; }

	   public void setLcgbJuicios(List<CatGeneralBean> lcgbJuicios) { this.lcgbJuicios = lcgbJuicios; }

	   public CatGeneralBean getCgbJuzgados() { return cgbJuzgados; }

	   public void setCgbJuzgados(CatGeneralBean cgbJuzgados) { this.cgbJuzgados = cgbJuzgados;	}

	   public List<ResponsableBean> getLcgbResponsables() { return lcgbResponsables; }

	   public void setLcgbResponsables(List<ResponsableBean> list) { this.lcgbResponsables = list; }

	   public Object[] getJuzgados() { return juzgados; }

	   public void setJuzgados(Object[] juzgados) { this.juzgados = juzgados; }

	   public List<CatGeneralBean> getLcgbJuzgados() { return lcgbJuzgados; }

	   public void setLcgbJuzgados(List<CatGeneralBean> lcgbJuzgados) { this.lcgbJuzgados = lcgbJuzgados; }

	   public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	   
	   public String getJuicio() { return juicio; }
	   
	   public void setJuicio(String juicio) { this.juicio = juicio; }
	   
	   public Object[] getJuicios() { return juicios; }
	   
	   public void setJuicios(Object[] juicios) { this.juicios = juicios; }
	   
	   public String getPuesto() { return puesto; }
	   
	   public void setPuesto(String puesto) { this.puesto = puesto; }
	   
	   public Object[] getPuestos() { return puestos; }
	   
	   public void setPuestos(Object[] puestos) { this.puestos = puestos; }
	   
	   public String getCbmPuesto() { return cbmPuesto; }
	   
	   public void setCbmPuesto(String cbmPuesto) { this.cbmPuesto = cbmPuesto; }
	   
	   public String getArea() { return area; }
	   
	   public void setArea(String area) { this.area = area; }
	   
	   public String getTurnado() { return turnado; }
	   
	   public void setTurnado(String turnado) { this.turnado = turnado; }
	   
	   public Object[] getTurnados() { return turnados; }
	   
	   public void setTurnados(Object[] turnados) { this.turnados = turnados;}
	 	   	   
	   public String getCbmTurnado() { return cbmTurnado; }
	   
	   public void setCbmTurnado(String cbmTurnado) { this.cbmTurnado = cbmTurnado; }
	   
	   public String getPerfil() { return perfil; }
	   
	   public void setPerfil(String perfil) { this.perfil = perfil; }
	   	   	   	 
	   public Object[] getPerfiles() { return perfiles;}
	   
	   public void setPerfiles(Object[] perfiles) { this.perfiles = perfiles;}
	   
	   public String getCbmPerfil() { return cbmPerfil; }
	   
	   public void setCbmPerfil(String cbmPerfil) { this.cbmPerfil = cbmPerfil; }
	   
	   public String getMateria() { return materia; }
	   
	   public void setMateria(String materia) { this.materia = materia; }
	   
	   public Object[] getMaterias() { return materias; }
	   
	   public void setMaterias(Object[] materias) { this.materias = materias; }
	   
	   public String getCmbMaterias() { return cmbMaterias; }
	   
	   public void setCmbMaterias(String cmbMaterias) { this.cmbMaterias = cmbMaterias; }
	   
	   public String getCmbUnidad() { return cmbUnidad; }
	   
       public void setCmbUnidad(String cmbUnidad) { this.cmbUnidad = cmbUnidad; }
       
       public Object[] getUnidades() { return unidades;	}
       
	   public void setUnidades(Object[] unidades) { this.unidades = unidades; }
	   
	   public String getUnidad() { return unidad; }
	   
	   public void setUnidad(String unidad) { this.unidad = unidad; }
	   
	   public String getDepartamento() { return departamento; }
	   
	   public void setDepartamento(String departamento) { this.departamento = departamento; }
	   
	   public Object[] getDepartamentos() { return departamentos; }
	   
	   public void setDepartamentos(Object[] departamentos) { this.departamentos = departamentos; }
	   
	   public Object[] getAreas() { return areas; }
	   
	   public void setAreas(Object[] areas) { this.areas = areas; }
	   	   
	   public String getCbmArea() { return cbmArea; }
	   
	   public void setCbmArea(String cbmArea) { this.cbmPuesto = cbmArea; }
	   
	   public String getCbmDepartamento() { return cbmDepartamento; }
	   
	   public void setCbmDepartamento(String cbmDepartamento) { this.cbmDepartamento = cbmDepartamento; }

	   public List<DocumentoBean> getListaDocumentos() { return listaDocumentos; }

	   public void setListaDocumentos(List<DocumentoBean> listaDocumentos) { this.listaDocumentos = listaDocumentos; }

	   public List<DocumentoBean> getListaDocumentosTemp() { return listaDocumentosTemp; }

	   public void setListaDocumentosTemp(List<DocumentoBean> listaDocumentosTemp) { this.listaDocumentosTemp = listaDocumentosTemp; }

	   public String getTextoActorDemandantePromovente() { return textoActorDemandantePromovente; }

	   public void setTextoActorDemandantePromovente(String textoActorDemandantePromovente) { this.textoActorDemandantePromovente = textoActorDemandantePromovente; }

	   public String getTextoActor() { return textoActor; }

	   public void setTextoActor(String textoActor) { this.textoActor = textoActor; }

	   public String getTextoEstado() { return textoEstado;	}

	   public void setTextoEstado(String textoEstado) { this.textoEstado = textoEstado; }	
	
	   public String getTextojAmparo() { return textojAmparo; }

	   public void setTextojAmparo(String textojAmparo) { this.textojAmparo = textojAmparo;	}

	   public List<CatGeneralBean> getLcgbEstados() { return lcgbEstados; }

	   public void setLcgbEstados(List<CatGeneralBean> lcgbEstados) { this.lcgbEstados = lcgbEstados; }

	   public AdministracionAgrarioLaboralImpl getAdministracionAgrarioLaboralDAOImpl() { return administracionAgrarioLaboralDAOImpl; }

	   public void setAdministracionAgrarioLaboralDAOImpl(AdministracionAgrarioLaboralImpl administracionAgrarioLaboralDAOImpl) {
		      this.administracionAgrarioLaboralDAOImpl = administracionAgrarioLaboralDAOImpl;
	   }

	   public List<CatTribunalBean> getListaTribunal() { return listaTribunal; }

	   public void setListaTribunal(List<CatTribunalBean> listaTribunal) { this.listaTribunal = listaTribunal; }

	   public CatTribunalBean getCgbTribunal() { return cgbTribunal; }

	  public void setCgbTribunal(CatTribunalBean cgbTribunal) { this.cgbTribunal = cgbTribunal; }

	  public CatAutoridadBean getCgbAutoridad() { return cgbAutoridad; }

	  public void setCgbAutoridad(CatAutoridadBean cgbAutoridad) { this.cgbAutoridad = cgbAutoridad; }

	  public List<CatAutoridadBean> getListaAutoridad() { return listaAutoridad; }

	  public void setListaAutoridad(List<CatAutoridadBean> listaAutoridad) { this.listaAutoridad = listaAutoridad; }

	  public CatGeneralBean getCgbEstados() { return cgbEstados; }

	  public void setCgbEstados(CatGeneralBean cgbEstados) { this.cgbEstados = cgbEstados; }

	  public CatGeneralBean getCgbOrganoJud() { return cgbOrganoJud; }

	  public void setCgbOrganoJud(CatGeneralBean cgbOrganoJud) { this.cgbOrganoJud = cgbOrganoJud; }

	  public List<CatGeneralBean> getLcgbOrganoJud() { return lcgbOrganoJud; }

	  public void setLcgbOrganoJud(List<CatGeneralBean> lcgbOrganoJud) { this.lcgbOrganoJud = lcgbOrganoJud; }

	  public String getInstruccion() { return instruccion; }

	  public void setInstruccion(String instruccion) { this.instruccion = instruccion; }

	  public String getTextoAveriguacionPrevia() { return textoAveriguacionPrevia; }

	  public void setTextoAveriguacionPrevia(String textoAveriguacionPrevia) { this.textoAveriguacionPrevia = textoAveriguacionPrevia; }

	  public String getTextoMinisterioPublicoJuezDTO() { return textoMinisterioPublicoJuezDTO; }

	  public void setTextoMinisterioPublicoJuezDTO(String textoMinisterioPublicoJuezDTO) {
		     this.textoMinisterioPublicoJuezDTO = textoMinisterioPublicoJuezDTO;
	  }

	  public String getRbRegDocOrdMercForaneo() { return rbRegDocOrdMercForaneo; }

	  public void setRbRegDocOrdMercForaneo(String rbRegDocOrdMercForaneo) { this.rbRegDocOrdMercForaneo = rbRegDocOrdMercForaneo; }

	  public String getRdoTipoAsunto() { return rdoTipoAsunto; }

	  public void setRdoTipoAsunto(String rdoTipoAsunto) { this.rdoTipoAsunto = rdoTipoAsunto; }

	  public String getsIdUsuario() { return sIdUsuario; }

	  public void setsIdUsuario(String sIdUsuario) { this.sIdUsuario = sIdUsuario; }

	  public CatGeneralBean getCgbRemitente() { return cgbRemitente; }

	  public void setCgbRemitente(CatGeneralBean cgbRemitente) { this.cgbRemitente = cgbRemitente; }

	  public CatGeneralBean getCgbJuezDTO() { return cgbJuezDTO; }

	  public void setCgbJuezDTO(CatGeneralBean cgbJuezDTO) { this.cgbJuezDTO = cgbJuezDTO; }

	  public DocumentoBean getCgbDocuementos() { return cgbDocuementos; }

	  public void setCgbDocuementos(DocumentoBean cgbDocuementos) { this.cgbDocuementos = cgbDocuementos; }

   	  public List<CatGeneralBean> getLcgbRemitente() { return lcgbRemitente; }

	  public void setLcgbRemitente(List<CatGeneralBean> lcgbRemitente) { this.lcgbRemitente = lcgbRemitente; }

	  public List<CatGeneralBean> getLcgbJuezDTO() { return lcgbJuezDTO; }

	  public void setLcgbJuezDTO(List<CatGeneralBean> lcgbJuezDTO) { this.lcgbJuezDTO = lcgbJuezDTO; }

	  public List<DocumentoBean> getlDocBean() { return lDocBean; }

	  public void setlDocBean(List<DocumentoBean> lDocBean) { this.lDocBean = lDocBean; }

	  public Object[] getEstados() { return estados; }

	  public void setEstados(Object[] estados) { this.estados = estados; }

	  public UsuariosBeanImpl getUsuariosBeanImpl() { return usuariosBeanImpl; }

	  public void setUsuariosBeanImpl(UsuariosBeanImpl usuariosBeanImpl) { this.usuariosBeanImpl = usuariosBeanImpl; }

	  public SesionBeanImpl getSesionBean() { return sesionBean; }

	  public void setSesionBean(SesionBeanImpl sesionBean) { this.sesionBean = sesionBean; }

	  public static long getSerialversionuid() { return serialVersionUID; }

	  public GestionaCatDAOImpl getGestionaCatDAOImpl() {	return gestionaCatDAOImpl; }

	  public UIComponent getSalvarPresionado() { return salvarPresionado; }

	  public void setSalvarPresionado(UIComponent salvarPresionado) { this.salvarPresionado = salvarPresionado; }

	  public boolean isVieneDeSalvar() { return vieneDeSalvar; }

	  public void setVieneDeSalvar(boolean vieneDeSalvar) { this.vieneDeSalvar = vieneDeSalvar; }

	  public int getNumeroRegistro() { return numeroRegistro; }

	  public void setNumeroRegistro(int numeroRegistro) { this.numeroRegistro = numeroRegistro; }

	  public String getTextoOtrosTribunal() { return textoOtrosTribunal; }

	  public void setTextoOtrosTribunal(String textoOtrosTribunal) { this.textoOtrosTribunal = textoOtrosTribunal; }

	  public String getTextoOtrosJuzgados() { return textoOtrosJuzgados; }

	  public void setTextoOtrosJuzgados(String textoOtrosJuzgados) { this.textoOtrosJuzgados = textoOtrosJuzgados; }

	  public String getTextoOtrosOrganosJurisdiccionales() { return textoOtrosOrganosJurisdiccionales; }

	  public void setTextoOtrosOrganosJurisdiccionales(String textoOtrosOrganosJurisdiccionales) {
		     this.textoOtrosOrganosJurisdiccionales = textoOtrosOrganosJurisdiccionales;
	  }

	  public String getTextoOtrosRemitente() { return textoOtrosRemitente; }

	  public void setTextoOtrosRemitente(String textoOtrosRemitente) { this.textoOtrosRemitente = textoOtrosRemitente; }

	  public String getTextoOtrosJuezDTO() { return textoOtrosJuezDTO; }

	  public void setTextoOtrosJuezDTO(String textoOtrosJuezDTO) { this.textoOtrosJuezDTO = textoOtrosJuezDTO; }

	  public String getTextoAcuerdoCitatorio() { return textoAcuerdoCitatorio; }

	  public void setTextoAcuerdoCitatorio(String textoAcuerdoCitatorio) { this.textoAcuerdoCitatorio = textoAcuerdoCitatorio; }

	  public String getRdoLaboral() { return rdoLaboral; }

	  public void setRdoLaboral(String rdoLaboral) { this.rdoLaboral = rdoLaboral; }

	  public String getTextoJuicioAmparo() { return textoJuicioAmparo; }

	  public void setTextoJuicioAmparo(String textoJuicioAmparo) { this.textoJuicioAmparo = textoJuicioAmparo; }

	  public Date getFechaAcuerdo() { return fechaAcuerdo; }

	  public void setFechaAcuerdo(Date fechaAcuerdo) { this.fechaAcuerdo = fechaAcuerdo; }

	  public String getTextoExpedienteLaboral() { return textoExpedienteLaboral; }

	  public void setTextoExpedienteLaboral(String textoExpedienteLaboral) { this.textoExpedienteLaboral = textoExpedienteLaboral; }

	  public String getTextoCedulaNotificacion() { return textoCedulaNotificacion; }

	  public void setTextoCedulaNotificacion(String textoCedulaNotificacion) { this.textoCedulaNotificacion = textoCedulaNotificacion; }

	  public String getTextoAsunto() { return textoAsunto; }

	  public void setTextoAsunto(String textoAsunto) { this.textoAsunto = textoAsunto; }

	  public boolean isCbOficioSNJuicio() { return cbOficioSNJuicio; }

	  public void setCbOficioSNJuicio(boolean cbOficioSNJuicio) { this.cbOficioSNJuicio = cbOficioSNJuicio; }

	  public boolean isRenderDialogoVolante() { return renderDialogoVolante; }

	  public void setRenderDialogoVolante(boolean renderDialogoVolante) { this.renderDialogoVolante = renderDialogoVolante; }

	  public String getFechaImpresionVolante() { return fechaImpresionVolante; }

	  public void setFechaImpresionVolante(String fechaImpresionVolante) { this.fechaImpresionVolante = fechaImpresionVolante; }

	  public String getFechaOficioVolante() { return fechaOficioVolante; }

	  public void setFechaOficioVolante(String fechaOficioVolante) { this.fechaOficioVolante = fechaOficioVolante; }

	  public String getTextoNumeroRegistroFin() { return textoNumeroRegistroFin; }

	  public void setTextoNumeroRegistroFin(String textoNumeroRegistroFin) { this.textoNumeroRegistroFin = textoNumeroRegistroFin; }

	  public boolean isEditable() { return editable; }

	  public void setEditable(boolean editable) { this.editable = true; }

	  public String getEtiquetaBotonEditar() { return etiquetaBotonEditar; }

	  public void setEtiquetaBotonEditar(String etiquetaBotonEditar) { this.etiquetaBotonEditar = etiquetaBotonEditar; }

	  public SeguimientoDAOImpl getSeguimientoDAOImpl() { return seguimientoDAOImpl; }

	  public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) { this.seguimientoDAOImpl = seguimientoDAOImpl; }

	  public List<ConsultarBean> getDatos() { return datos; }

	  public void setDatos(List<ConsultarBean> datos) { this.datos = datos; }

	  public ConsultarBean getDats() { return dats; }

	  public void setDats(ConsultarBean dats) { this.dats = dats; }

	  public DocumentoBean getEditarDocumentoBean() { return editarDocumentoBean; }

	  public void setEditarDocumentoBean(DocumentoBean editarDocumentoBean) { this.editarDocumentoBean = editarDocumentoBean; }	
	  	
}
