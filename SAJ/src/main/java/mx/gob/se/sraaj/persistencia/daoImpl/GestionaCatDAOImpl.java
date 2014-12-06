package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.ResponsableBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.GestionaCatDAO;
import mx.gob.se.sraaj.persistencia.sp.BusquedaDocumentoSP;
import mx.gob.se.sraaj.persistencia.sp.CatCatalogoSP;
import mx.gob.se.sraaj.persistencia.sp.CatCircuitoSP;
import mx.gob.se.sraaj.persistencia.sp.CatDepartamentoSP;
import mx.gob.se.sraaj.persistencia.sp.CatDescargoSP;
import mx.gob.se.sraaj.persistencia.sp.CatEstadosSP;
import mx.gob.se.sraaj.persistencia.sp.CatJuezDTOSP;
import mx.gob.se.sraaj.persistencia.sp.CatMateriaSP;
import mx.gob.se.sraaj.persistencia.sp.CatOrganoJudSP;
import mx.gob.se.sraaj.persistencia.sp.CatPGRSP;
import mx.gob.se.sraaj.persistencia.sp.CatPuestoSP;
import mx.gob.se.sraaj.persistencia.sp.CatInstruccionSP;
import mx.gob.se.sraaj.persistencia.sp.CatRemitenteSP;
import mx.gob.se.sraaj.persistencia.sp.CatResponsableSP;
import mx.gob.se.sraaj.persistencia.sp.CatTipoJuicioSP;
import mx.gob.se.sraaj.persistencia.sp.CatTurnadoSP;
import mx.gob.se.sraaj.persistencia.sp.CatUnidadAdministrativaSP;
import mx.gob.se.sraaj.persistencia.sp.ConsultaEditarDocumentoSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaAgrario;
import mx.gob.se.sraaj.persistencia.sp.InsertaAmparoFLMSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaLaboralSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaNuevoDocumentoMFSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaNuevoDocumentoMLSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaNuevoDocumentoPNSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaNuevoDocumentoSP;
import mx.gob.se.sraaj.persistencia.sp.InsertarActualizarDesacargoSP;
import mx.gob.se.sraaj.persistencia.sp.ObtenNumeroRegistroSP;
import mx.gob.se.sraaj.persistencia.sp.ObtieneJuzgadosSP;
import mx.gob.se.sraaj.persistencia.sp.InsPerfilSP;
import mx.gob.se.sraaj.persistencia.sp.ModPerfilSP;
import mx.gob.se.sraaj.persistencia.sp.RepCJFSP;
import mx.gob.se.sraaj.persistencia.sp.RepCircuitoSP;
import mx.gob.se.sraaj.persistencia.sp.RepClsDocumentalSP;
import mx.gob.se.sraaj.persistencia.sp.RepDelegMetropolitanaSP;
import mx.gob.se.sraaj.persistencia.sp.RepDepartamentoSP;
import mx.gob.se.sraaj.persistencia.sp.RepIncidenteSuspensionSP;
import mx.gob.se.sraaj.persistencia.sp.RepInstruccionSP;
import mx.gob.se.sraaj.persistencia.sp.RepJuntaEspecialSP;
import mx.gob.se.sraaj.persistencia.sp.RepJuntaLocalSP;
import mx.gob.se.sraaj.persistencia.sp.RepJuzgadoTribunalSP;
import mx.gob.se.sraaj.persistencia.sp.RepJuzgadosConciliacionSP;
import mx.gob.se.sraaj.persistencia.sp.RepMateriaSP;
import mx.gob.se.sraaj.persistencia.sp.RepMinistroInstructorSP;
import mx.gob.se.sraaj.persistencia.sp.RepPGJSP;
import mx.gob.se.sraaj.persistencia.sp.RepPuestoSP;
import mx.gob.se.sraaj.persistencia.sp.RepRemitenteSP;
import mx.gob.se.sraaj.persistencia.sp.RepResponsableSP;
import mx.gob.se.sraaj.persistencia.sp.RepSalaSCJNSP;
import mx.gob.se.sraaj.persistencia.sp.RepSalaTribunalConciliacionSP;
import mx.gob.se.sraaj.persistencia.sp.RepSalasFiscalesSP;
import mx.gob.se.sraaj.persistencia.sp.RepTipoJuicioSP;
import mx.gob.se.sraaj.persistencia.sp.RepTribunalesAgrarioSP;
import mx.gob.se.sraaj.persistencia.sp.RepUnidadAdministrativaSP;
import mx.gob.se.sraaj.persistencia.sp.RepUnidadEspecializadaSP;
import mx.gob.se.sraaj.persistencia.sp.SelectNumeroRegistroSP;
import mx.gob.se.sraaj.transferencia.beanImpl.CatGeneralBeanImpl;

public class GestionaCatDAOImpl implements GestionaCatDAO,Serializable {
	
	   private static final long serialVersionUID = 1L;
	
	   private CatTipoJuicioSP					catTipoJuicioSP;	 
	   private CatPuestoSP						catPuestoSP; 
	   private CatDepartamentoSP 				catDepartamentoSP;
	   private CatUnidadAdministrativaSP		catUnidadAdministrativaSP;
	   private CatMateriaSP				    	catMateriaSP;
	   private CatCatalogoSP					catCatalogoSP;
	   private CatPGRSP 						catPGRSP;
	   private CatDescargoSP					catDescargoSP;
	   private CatResponsableSP 				catResponsableSP;
	   private CatEstadosSP				   		catEstadosSP;
	   private CatCircuitoSP					catCircuitoSP;
	   private CatOrganoJudSP               	catOrganoJudSP;
	   
	   private CatInstruccionSP 				catInstruccionSP;
	   private CatRemitenteSP					catRemitenteSP;
	   private CatJuezDTOSP						catJuezDTOSP;
	   
	   private CatTurnadoSP                     catTurnadoSP;
	   	
	   private RepCJFSP							repCJFSP;
	   private RepRemitenteSP 			   		repRemitenteSP;
	   private RepCircuitoSP			    	repCircuitoSP;	
	   private RepClsDocumentalSP				repClsDocumentalSP;
	   private RepDelegMetropolitanaSP			repDelegMetropolitanaSP;
	   private RepDepartamentoSP				repDepartamentoSP;
	   private RepIncidenteSuspensionSP			repIncidenteSuspensionSP;
	   private RepInstruccionSP					repInstruccionSP;
	   private RepJuntaEspecialSP				repJuntaEspecialSP;
	   private RepJuntaLocalSP					repJuntaLocalSP;
	   private RepJuzgadosConciliacionSP		repJuzgadosConciliacionSP;
	   private RepJuzgadoTribunalSP				repJuzgadoTribunalSP;
	   private RepMateriaSP						repMateriaSP;
	   private RepMinistroInstructorSP			repMinistroInstructorSP;
	   private RepPGJSP							repPGJSP;
	   private RepPuestoSP						repPuestoSP;
	   private RepResponsableSP				 	repResponsableSP;
	   private RepSalaSCJNSP				 	repSalaSCJNSP;
	   private RepSalasFiscalesSP				repSalasFiscalesSP;
	   private RepSalaTribunalConciliacionSP	repSalaTribunalConciliacionSP;
	   private RepTribunalesAgrarioSP			repTribunalesAgrarioSP;
	   private RepTipoJuicioSP					repTipoJuicioSP;
	   private RepUnidadAdministrativaSP		repUnidadAdministrativaSP;
	   private RepUnidadEspecializadaSP			repUnidadEspecializadaSP;
	   private BusquedaDocumentoSP          	busquedaDocumentoSP;
	   private ObtieneJuzgadosSP            	obtieneJuzgadosSP;

	   private InsPerfilSP						insPerfilSP;
	   private InsertarActualizarDesacargoSP	insertarActualizarDesacargoSP;
	   private InsertaNuevoDocumentoMFSP		insertaNuevoDocumentoMFSP;
	   private InsertaNuevoDocumentoMLSP		insertaNuevoDocumentoMLSP;
	   private InsertaNuevoDocumentoPNSP		insertaNuevoDocumentoPNSP;
	   private InsertaNuevoDocumentoSP          insertaNuevoDocumentoSP;
	   
	   private InsertaAmparoFLMSP               insertaAmparoFLMSP;
	   private InsertaAgrario                   insertaAgrario;
	   private InsertaLaboralSP                 insertaLaboralSP;
	   
	   private ModPerfilSP						modPerfilSP;
	   	  
	   private ObtenNumeroRegistroSP            obtenNumeroRegistroSP;
	   private SelectNumeroRegistroSP           selectNumeroRegistroSP;
	   
	   private ConsultaEditarDocumentoSP        consultaEditarDocumentoSP;

		
	   public static long getSerialversionuid() { return serialVersionUID; }
	
	
	public List<CatGeneralBean> obtienePuesto() throws SraajException {
		   List<CatGeneralBean> lCat = null;
		   try {
			       Map<String, Object> mapCursor = catPuestoSP.execute();
			       if( mapCursor != null){
			           Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				       if(catalogo instanceof List<?>) { lCat = (List<CatGeneralBean>) catalogo; }
			       }
			       return lCat;
		      } catch(Exception ex) {
		    	      ex.printStackTrace();
		    	      throw new SraajException(ex.getMessage(), ex); 
		      }
	   }
	   
	public List<CatGeneralBean> obtieneDepartamento() throws SraajException{
		List<CatGeneralBean> lCat = null;
		try{
			Map<String, Object> mapCursor = catDepartamentoSP.execute();
			if( mapCursor != null ){
			      Object departamento = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if(departamento instanceof List<?>){ 
			    	  lCat = (List<CatGeneralBean>) departamento; 
			    	  }
		      } 
		      return lCat;
	      }catch (Exception ex){ throw new SraajException(ex.getMessage(), ex);	}			
	}
	
	public List<CatGeneralBean> obtieneDescargo() throws SraajException {
		List<CatGeneralBean> lCat = null;
		try{
			Map<String, Object> mapCursor = catDescargoSP.execute();
			if(mapCursor != null){
				Object descargo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(descargo instanceof List<?>){
					lCat = (List<CatGeneralBean>)descargo;
				}
			}
		}
		catch(Exception ex){
			throw new SraajException(ex.getMessage());
		}
		return lCat;
	}
	   
	public List<CatGeneralBean> obtieneTipoJuicio() throws SraajException {
		   
		List<CatGeneralBean> lCat = null;
		      try{			 
			      Map<String, Object> mapCursor = catTipoJuicioSP.execute();
			      if( mapCursor != null ){
				      Object departamento = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if(departamento instanceof List<?>){ 
				    	  lCat = (List<CatGeneralBean>) departamento; 
				    	  }
			      } 
			      return lCat;
		      }
		      catch (Exception ex){ 
		    	  throw new SraajException(ex.getMessage(), ex);
		    	  }
	   }
	   
	public List<CatGeneralBean> obtieneUnidadAdministrativa() throws SraajException{
		   List<CatGeneralBean> lCat = null;
		   try{
			   Map<String, Object> mapCursor = catUnidadAdministrativaSP.execute();
			   if(mapCursor != null){
				   Object unidadAdministrativa = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				   if(unidadAdministrativa instanceof List<?>){
					   lCat = (List<CatGeneralBean>) unidadAdministrativa;
				   }
			   }
			   return lCat;
		   }
		   catch(Exception ex){
			   throw new SraajException(ex.getMessage(), ex);
		   }
	   }
	   
	public List<CatGeneralBean> obtieneMateria() throws SraajException{
		   List<CatGeneralBean> lCat = null;
		   try{
			   Map<String, Object> mapCursor = catMateriaSP.execute();
			   if(mapCursor != null){
				   Object materia = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				   if(materia instanceof List<?>){
					   lCat = (List<CatGeneralBean>) materia;
				   }
			   }
			   return lCat;
		   }
		   catch(Exception ex){
			   ex.printStackTrace();
			   throw new SraajException(ex.getMessage(), ex);
		   }
	   }
	   
	public List<CatGeneralBean> obtieneCatalogos() throws SraajException{
		   List<CatGeneralBean> lCat = null;
		   try{
			   Map<String, Object> mapCursor = catCatalogoSP.execute();
			   if(mapCursor != null){
				   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				   if(catalogo instanceof List<?>){
					   lCat = (List<CatGeneralBean>) catalogo;
				   }
			   }
			   return lCat;
		   } 
		   catch(Exception ex){
			   throw new SraajException (ex.getMessage(), ex);
		   }
	   }
	   
	public List<CatGeneralBean> obtieneRepCJF() throws SraajException{
		   List<CatGeneralBean> lCat = null;
		   try{
			   Map<String, Object> mapCursor = repCJFSP.execute();
			   if(mapCursor != null){
				   Object repCJF = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				   if(repCJF instanceof List<?>){
					   lCat = (List<CatGeneralBean>) repCJF;
				   }
			   }
			   return lCat;
		   } catch(Exception ex){
			   throw new SraajException(ex.getMessage(), ex);
		   }
	   }

	public List<CatGeneralBean> obtieneRepRemitente() throws SraajException {
		List<CatGeneralBean> lCat = null;
		try{
			Map<String, Object> mapCursor = repRemitenteSP.execute();
			if(mapCursor != null){
				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(catalogo instanceof List<?>){
					lCat = (List<CatGeneralBean>) catalogo;
				}
			}
			return lCat;
		} catch (Exception ex){
			throw new SraajException(ex.getMessage(), ex);
		}
	}
		 
	public List<CatGeneralBean> obtieneInstruccion() throws SraajException {
		   
		      List<CatGeneralBean> lCat = null;
		    
		      try{
				  Map<String, Object> mapCursor = catInstruccionSP.execute();
				  
				  if( mapCursor != null ){
   				      Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
								  
				      if( catalogo instanceof List<?> ) {
					      lCat = (List<CatGeneralBean>) catalogo;
				      }
				  }
				
				return lCat;
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
				throw new SraajException(ex.getMessage(), ex);				
			}
		      
	 }

	@Override
	public List<ResponsableBean> obtieneResponsable(String idCat) throws SraajException {
		
		   List<ResponsableBean> lCat = null;
	    
	       try{
			    Map<String, Object> mapCursor = catResponsableSP.execute(Integer.valueOf(idCat.trim()));
			  
			    if( mapCursor != null ){
			        Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
							  
			        if( catalogo instanceof List<?> ) {
				        lCat = (List<ResponsableBean>) catalogo;
			        }
			    }
			
			    
			    return lCat;
		
		   }catch( Exception ex ) {
			       ex.printStackTrace();
			       throw new SraajException(ex.getMessage(), ex);				
		   }
	       
	 }
	
	public List<CatGeneralBean> obtieneRepCircuito() throws SraajException {
		List<CatGeneralBean> lCat = null;
		try{
			Map<String, Object> mapCursor = repCircuitoSP.execute();
			if(mapCursor != null){
				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(catalogo instanceof List<?>){
					lCat = (List<CatGeneralBean>) catalogo;
				}
			}
			return lCat;
		} catch (Exception ex){
			throw new SraajException(ex.getMessage(), ex);
		}
	}
	
	public List<CatGeneralBean> obtieneRepClsDocumental() throws SraajException{
		List<CatGeneralBean> lCat = null;		
		try{
			Map<String, Object> mapCursor = repClsDocumentalSP.execute();
			if(mapCursor != null){
				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(catalogo instanceof List<?>){
					lCat = (List<CatGeneralBean>) catalogo;
				}
			}
			return lCat;
		} catch (Exception ex){
			throw new SraajException(ex.getMessage(), ex);
		}		
	}
	
	public List<CatGeneralBean> obtieneRepDelegMetropolitana() throws SraajException{
		List<CatGeneralBean> lCat = null;		
		try{
			Map<String, Object> mapCursor = repDelegMetropolitanaSP.execute();
			if(mapCursor != null){
				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(catalogo instanceof List<?>){
					lCat = (List<CatGeneralBean>) catalogo;
				}
			}
			return lCat;
		} catch (Exception ex){
			throw new SraajException(ex.getMessage(), ex);
		}	
	}
	
 	 public List<CatGeneralBean> obtieneRepDepartamento() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
 		try{
 			Map<String, Object> mapCursor = repDepartamentoSP.execute();
 			if(mapCursor != null){
 				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				if(catalogo instanceof List<?>){
 					lCat = (List<CatGeneralBean>) catalogo;
 				}
 			}
 			return lCat;
 		} catch (Exception ex){
 			throw new SraajException(ex.getMessage(), ex);
 		} 		 
 	 }
 	 
  	 public List<CatGeneralBean> obtieneRepIncidenteSuspension() throws SraajException{
  		List<CatGeneralBean> lCat = null;		
 		try{
 			Map<String, Object> mapCursor = repIncidenteSuspensionSP.execute();
 			if(mapCursor != null){
 				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				if(catalogo instanceof List<?>){
 					lCat = (List<CatGeneralBean>) catalogo;
 				}
 			}
 			return lCat;
 		} catch (Exception ex){
 			throw new SraajException(ex.getMessage(), ex);
 		}
  	 }
  	 
  	 public List<CatGeneralBean> obtieneRepInstruccion() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
  		try{
  			Map<String, Object> mapCursor = repInstruccionSP.execute();
  			if(mapCursor != null){
  				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
  				if(catalogo instanceof List<?>){
  					lCat = (List<CatGeneralBean>) catalogo;
  				}
  			}
  			return lCat;
  		} catch (Exception ex){
  			throw new SraajException(ex.getMessage(), ex);
  		} 
  	 }
  	 
  	 public List<CatGeneralBean> obtieneRepJuntaEspecial() throws SraajException{
    		List<CatGeneralBean> lCat = null;		
      		try{
      			Map<String, Object> mapCursor = repJuntaEspecialSP.execute();
      			if(mapCursor != null){
      				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
      				if(catalogo instanceof List<?>){
      					lCat = (List<CatGeneralBean>) catalogo;
      				}
      			}
      			return lCat;
      		} catch (Exception ex){
      			throw new SraajException(ex.getMessage(), ex);
      		} 
  	 }
  	 
  	 public List<CatGeneralBean> obtieneRepJuntaLocal() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
  		try{
  			Map<String, Object> mapCursor = repJuntaLocalSP.execute();
  			if(mapCursor != null){
  				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
  				if(catalogo instanceof List<?>){
  					lCat = (List<CatGeneralBean>) catalogo;
  				}
  			}
  			return lCat;
  		} catch (Exception ex){
  			throw new SraajException(ex.getMessage(), ex);
  		} 
  	 }
  	 
  	 public List<CatGeneralBean> obtieneRepJuzgadosConciliacion() throws SraajException{
  		List<CatGeneralBean> lCat = null;		
  		try{
  			Map<String, Object> mapCursor = repJuzgadosConciliacionSP.execute();
  			if(mapCursor != null){
  				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
  				if(catalogo instanceof List<?>){
  					lCat = (List<CatGeneralBean>) catalogo;
  				}
  			}
  			return lCat;
  		} catch (Exception ex){
  			throw new SraajException(ex.getMessage(), ex);
  		} 
  	 }
  	 
  	public List<CatGeneralBean> obtieneRepJuzgadoTribunal() throws SraajException{
  		List<CatGeneralBean> lCat = null;		
  		try{
  			Map<String, Object> mapCursor = repJuzgadoTribunalSP.execute();
  			if(mapCursor != null){
  				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
  				if(catalogo instanceof List<?>){
  					lCat = (List<CatGeneralBean>) catalogo;
  				}
  			}
  			return lCat;
  		} catch (Exception ex){
  			throw new SraajException(ex.getMessage(), ex);
  		}
  	}
  	
 	 public List<CatGeneralBean> obtieneRepMateria() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repMateriaSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	 }
 	 
 	public List<CatGeneralBean> obtieneRepMinistroInstructor() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repMinistroInstructorSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepPGJ() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repPGJSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtienePGR() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = catPGRSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepPuesto() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repPuestoSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepResponsable() throws SraajException {
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repResponsableSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepSalaSCJN() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repSalaSCJNSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepSalasFiscales() throws SraajException{
   		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repSalasFiscalesSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepSalaTribunalConciliacion() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repSalaTribunalConciliacionSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepTribunalesAgrario() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repTribunalesAgrarioSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepTipoJuicio() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repTipoJuicioSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepUnidadAdministrativa() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repUnidadAdministrativaSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	public List<CatGeneralBean> obtieneRepUnidadEspecializada() throws SraajException{
 		List<CatGeneralBean> lCat = null;		
   		try{
   			Map<String, Object> mapCursor = repUnidadEspecializadaSP.execute();
   			if(mapCursor != null){
   				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(catalogo instanceof List<?>){
   					lCat = (List<CatGeneralBean>) catalogo;
   				}
   			}
   			return lCat;
   		} catch (Exception ex){
   			throw new SraajException(ex.getMessage(), ex);
   		}
 	}
 	
 	@Override
 	public List<CatGeneralBean> obtieneJuzgados(String idTipoJuicio) throws Exception{
 		 		
 		   List<CatGeneralBean> lCat = null;
 		   
   		   try{
   			   
   			   Map<String, Object> mapCursor = obtieneJuzgadosSP.execute(Integer.parseInt(idTipoJuicio));
   			   
   			   if( mapCursor != null ){
   				   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				   if(catalogo instanceof List<?>){ lCat = (List<CatGeneralBean>) catalogo; }
   			   }   			      			  
   			   
   		   } catch (Exception ex){ ex.printStackTrace(); }
   		   
   		   return lCat;
   		   
 	}
 	 	 	
 	public List<CatGeneralBean> obtieneCircuito() throws SraajException{
 		List<CatGeneralBean> lCat = null;
 		try{
 			Map<String, Object> mapCursor = catCircuitoSP.execute();
 			if(mapCursor != null){
 				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				if(catalogo instanceof List<?>){
 					lCat = (List<CatGeneralBean>) catalogo;
 				}
 			}
 			return lCat;
 		}
 		catch(Exception ex){
 			throw new SraajException(ex.getMessage(), ex);
 		}
 	}
 	
	public Map<String, Object> insetarPer(CatGeneralBean catGeneralBean) throws SraajException {
		Map<String, Object> Perfiles = null;
			Perfiles = insPerfilSP.execute();
		return null;
	}
	
	public Map<String,Object> modificarPer(String Id, String Activo, String Descripcion, String Permisos, String Usuario) throws SraajException {
		Map<String, Object> Perfiles = new HashMap<String, Object>();
		try{
			modPerfilSP.execute(Id, Activo, Descripcion, Permisos, Usuario);
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return Perfiles;
	}
			
	public List<CatGeneralBean> obtienePerfiles() {	return null; }
	
	public List<CatGeneralBeanImpl> obtieneTurnados(Integer tipJui) throws SraajException {
	     
	     System.out.println("LLegue al Obtiene Turnados...");
	     
	     
	     List<CatGeneralBeanImpl> lCatT = null;
	        try {                   
	          Map<String, Object> mapCursor = catTurnadoSP.execute(tipJui);
	          for( java.util.Map.Entry<String,Object> entry: mapCursor.entrySet() ){
	            System.out.println(entry.getKey() + " -- " + entry.getValue());            
	          }
	          if( mapCursor != null){
	           lCatT = (List<CatGeneralBeanImpl>)mapCursor.get(Constantes.OUT_SP_RESULTADO);                         
	          }                     
	        } catch(Exception ex) {  ex.printStackTrace(); }
	      return lCatT;    
	    }

	@Override
	public List<DocumentoBean> buscarDocumento(DocumentoBean documentoBean) throws Exception {
		 
		   List<DocumentoBean> lCat = null;
		   		
		   try{
		     
			   Map<String, Object> mapCursor = busquedaDocumentoSP.execute(documentoBean);		
			   if( mapCursor != null ){
	 			   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
	 			   if(catalogo instanceof List<?>){ lCat = (List<DocumentoBean>) catalogo;	}
	 		   }
			   
	 		   return lCat;
		  	   			
		   }catch(Exception e){ e.printStackTrace(); }
		   
		   return null;
				   
	}
	
	@Override
	public List<CatGeneralBean> obtieneOrganoJud() throws Exception {
		   
		   List<CatGeneralBean> lCat = new ArrayList<CatGeneralBean>();
		   
		   try{
		       Map<String, Object> mapCursor = catOrganoJudSP.execute();
		     
		       if( mapCursor != null ){
		    	   
		           Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
		         
		           if( catalogo instanceof List<?> ) { lCat = (List<CatGeneralBean>) catalogo; }
		       }		       		  
		       
	      }catch(Exception e){ e.printStackTrace(); }
		   
		  return lCat;		  
		   
    }
	
	
 	public boolean InsertarActualizarDescargo(int vIdRegDoc, int vDescargo, String vExpediente, int vTieneRegistro, String vDocumento) throws Exception{
 		   try{
   			   Map<String, Object> errorBd = insertarActualizarDesacargoSP.execute(vIdRegDoc, vDescargo, vExpediente, vTieneRegistro, vDocumento);
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   if(errVO != null) { 
				  System.out.println(errVO.getsCodError());
				  System.out.println(errVO.getsDescError());
				  if( errVO.getsCodError().equals("DBSE000") ){ return true; } 
			   } 
		   }catch(Exception e){ e.printStackTrace(); } 
 		   return false; 
 	}
 	
	
	public boolean insertaNuevoDocumentoMF(DocumentoBean nuevoDocumentoBean) throws Exception{
		   try{
			   Map<String, Object> errorBd = insertaNuevoDocumentoMFSP.execute(nuevoDocumentoBean);
		   @SuppressWarnings("unchecked")
		   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		   ErrorBDBean errVO = err.get(0);
		   if(errVO != null) { 
			  System.out.println(errVO.getsCodError());
			  System.out.println(errVO.getsDescError());
			  if( errVO.getsCodError().equals("DBSE000") ){ return true; } 
		   } 
	   }catch(Exception e){ e.printStackTrace(); } 
		   return false; 
	}
	
 	public boolean insertaNuevoDocumentoML(DocumentoBean nuevoDocumentoBean) throws Exception{
 		   try{
   			   Map<String, Object> errorBd = insertaNuevoDocumentoMLSP.execute(nuevoDocumentoBean);
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   if(errVO != null) { 
				  System.out.println(errVO.getsCodError());
				  System.out.println(errVO.getsDescError());
				  if( errVO.getsCodError().equals("DBSE000") ){ return true; } 
			   } 
		   }catch(Exception e){ e.printStackTrace(); } 
 		   return false; 
 	}
 	
 	public boolean insertaNuevoDocumentoPN(DocumentoBean nuevoDocumentoBean) throws Exception{
 		   try{
   			   Map<String, Object> errorBd = insertaNuevoDocumentoPNSP.execute(nuevoDocumentoBean);
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   if(errVO != null) { 
				  System.out.println(errVO.getsCodError());
				  System.out.println(errVO.getsDescError());
				  if( errVO.getsCodError().equals("DBSE000") ){ return true; } 
			   } 
		   }catch(Exception e){ e.printStackTrace(); } 
 		   return false; 
 	}
 	
 	public List<CatGeneralBean> obtieneEdos() throws SraajException{
 		List<CatGeneralBean> lCat = null;
 		try{
 			Map<String, Object> mapCursor = catEstadosSP.execute();
 			if(mapCursor != null){
 				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				if(catalogo instanceof List<?>){
 					lCat = (List<CatGeneralBean>) catalogo;
 				}
 			}
 			return lCat;
 		}
 		catch(Exception ex){
 			throw new SraajException(ex.getMessage(), ex);
 		}
 	}	
 	 	
 	public List<CatGeneralBean> obtieneRemitente(String idTipoJuicio) throws SraajException{
 		
 		   List<CatGeneralBean> lCat = null;
 		
 		   try{
 			   
 			   Map<String, Object> mapCursor = catRemitenteSP.execute(Integer.parseInt(idTipoJuicio));
 			   if( mapCursor != null ){
 				   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				  if( catalogo instanceof List<?> ){
 					  lCat = (List<CatGeneralBean>) catalogo;
 				  }
 			   }
 			   
 			   return lCat;
 			
 		   }catch(Exception ex){ throw new SraajException(ex.getMessage(), ex); }
 		   
 	}	
 	
 	public List<CatGeneralBean> obtieneJuezDTO(String idTipoJuicio) throws SraajException{
 		List<CatGeneralBean> lCat = null;
 		try{
 			Map<String, Object> mapCursor = catJuezDTOSP.execute(Integer.parseInt(idTipoJuicio));
 			if(mapCursor != null){
 				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 				if(catalogo instanceof List<?>){
 					lCat = (List<CatGeneralBean>) catalogo;
 				}
 			}
 			return lCat;
 		}
 		catch(Exception ex){
 			throw new SraajException(ex.getMessage(), ex);
 		}
 	}
 	
	public boolean insertaAFLM(DocumentoBean documentoBean) throws Exception {
 		
 		   try{
		     
			   Map<String, Object> errorBd = insertaAmparoFLMSP.execute(documentoBean);		
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   
			   if( errVO != null ) {
				   
				   System.out.println(errVO.getsCodError());
				   System.out.println(errVO.getsDescError());
				   
				   if( errVO.getsCodError().equals("DBSE000") ){ return true; }
				  
			   }
		  	   			
		   }catch(Exception e){ e.printStackTrace(); }
		   
		   return false;
		   
	}

    @Override
	public boolean insertaAgrario(DocumentoBean documentoBean) throws Exception {
		   		
		   try{
		     
			   Map<String, Object> errorBd = insertaAgrario.execute(documentoBean);		
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   
			   if( errVO != null ) {
				   
				   System.out.println(errVO.getsCodError());
				   System.out.println(errVO.getsDescError());
				   
				   if( errVO.getsCodError().equals("DBSE000") ){ return true; }
				   else{ return false; }
				  
			   }
		  	   			
		   }catch(Exception e){ e.printStackTrace(); }
		   
		   return false;
		   
	}
	  
    
    
    @Override
	public int obtieneNumeroRegistro() throws Exception {
		   
		   List<Integer> lCat = null;
		   		   
		   try{
			   
			   Map<String, Object> mapCursor = obtenNumeroRegistroSP.execute();
			   
 			   if( mapCursor != null ){
 				   
 				   if( mapCursor.containsKey(Constantes.OUT_SP_ERROR ) ){
 					   
 					   List<ErrorBDBean> err = (List<ErrorBDBean>)mapCursor.get(Constantes.OUT_SP_ERROR);
 					   ErrorBDBean errVO = err.get(0);
 					   
 					   if( errVO != null ) {
 						   
 						   System.out.println(errVO.getsCodError());
 						   System.out.println(errVO.getsDescError());
 						    						    						  
 					   } 
 					   
 				   }
 				   
 				   if( mapCursor.containsKey(Constantes.OUT_SP_RESULTADO ) ){
 					    
 					   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
 	 				   if( catalogo instanceof List<?> ){ lCat = (List<Integer>) catalogo; }   
 					   
 				   }
 				    				   
 			   }
 		 
		   }catch(Exception e){ e.printStackTrace(); }
		
		   return lCat.get(0);
		   
	}
	
	@Override
	public boolean insertaLaboral(DocumentoBean documentoBean) throws Exception {
		
		   try{
		     
			   Map<String, Object> errorBd = insertaLaboralSP.execute(documentoBean);		
			   @SuppressWarnings("unchecked")
			   List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
			   ErrorBDBean errVO = err.get(0);
			   
			   if( errVO != null ) {
				   
				   System.out.println( errVO.getsCodError()  );
				   System.out.println( errVO.getsDescError() );
				   
				   if( errVO.getsCodError().equals("DBSE000") ){ return true; }
				  
			   }
		  	   			
		   }catch(Exception e){ e.printStackTrace(); }		       
		
		   return false;
		   
	}
	
	@Override
	public int selectNumeroRegistro()throws Exception {
		
		   List<Integer> lCat = null;
		   
		   try{
			   
			   Map<String, Object> mapCursor = selectNumeroRegistroSP.execute();
			   
			   if( mapCursor != null ){
				   
				   if( mapCursor.containsKey(Constantes.OUT_SP_ERROR ) ){
					   
					   List<ErrorBDBean> err = (List<ErrorBDBean>)mapCursor.get(Constantes.OUT_SP_ERROR);
					   ErrorBDBean errVO = err.get(0);
					   
					   if( errVO != null ) {
						   
						   System.out.println(errVO.getsCodError());
						   System.out.println(errVO.getsDescError());
						    						    						  
					   } 
					   
				   }
				   
				   if( mapCursor.containsKey(Constantes.OUT_SP_RESULTADO ) ){
					    
					   Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
	 				   if( catalogo instanceof List<?> ){ lCat = (List<Integer>) catalogo; }   
					   
				   }
				    				   
			   }
		 
		   }catch(Exception e){ e.printStackTrace(); }
		
		   return lCat.get(0);
		   
	}
	
	@Override
	public List<CatMateriaBean> obtenerMaterias() throws Exception {
 	   
	       List<CatMateriaBean> lCat = null;
	      
	       try{
		   
	    	   Map<String, Object> mapCursor = catMateriaSP.execute();
		       if( mapCursor != null ){
			       Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			       if(seg instanceof List<?>){
				      lCat = (List<CatMateriaBean>) seg;					      
			       }
		       }
		       
		       return lCat;
		       
	       }catch (Exception ex){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	       } 
		   
	}
	
	@Override
	public DocumentoBean consultaDocumentoEditar(int idRegDoc,int iNumeroRegistro) throws Exception {
		
	       List<DocumentoBean> lCat = null;
		      
	       try{
		   	    	   
	    	   Map<String, Object> mapCursor = consultaEditarDocumentoSP.execute(idRegDoc,iNumeroRegistro);
	    	   
		       if( mapCursor != null ){
		    	   
			       Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			    
	               if( seg instanceof List<?> ){
			    	   
				       lCat = (List<DocumentoBean>) seg;
				       System.out.println("Tamaño lCat");
				       System.out.println(lCat.size());
 				       
				       return lCat.get(0);
				       			              			              
				   }
				   
			   }		       
		       		       
	       }catch (Exception ex){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	       }
	       
	       return null;
		   
	}
 	
	public ObtieneJuzgadosSP getObtieneJuzgadosSP() { return obtieneJuzgadosSP; }
	
	public void setObtieneJuzgadosSP(ObtieneJuzgadosSP obtieneJuzgadosSP) {	this.obtieneJuzgadosSP = obtieneJuzgadosSP; }
	
	public BusquedaDocumentoSP getBusquedaDocumentoSP() { return busquedaDocumentoSP; }
	
	public void setBusquedaDocumentoSP(BusquedaDocumentoSP busquedaDocumentoSP) { this.busquedaDocumentoSP = busquedaDocumentoSP; }
	
	public CatPuestoSP getCatPuestoSP() { return catPuestoSP; }
	
	public void setCatPuestoSP(CatPuestoSP catPuestoSP) { this.catPuestoSP = catPuestoSP; }	
	
	public CatDepartamentoSP getCatDepartamentoSP() { return catDepartamentoSP; }
	
	public void setCatDepartamentoSP(CatDepartamentoSP catDepartamentoSP) { this.catDepartamentoSP = catDepartamentoSP; }
	   
	public CatUnidadAdministrativaSP getCatUnidadAdministrativaSP() { return catUnidadAdministrativaSP; }
	
	public void setCatUnidadAdministrativaSP( CatUnidadAdministrativaSP catUnidadAdministrativaSP) { this.catUnidadAdministrativaSP = catUnidadAdministrativaSP; }
	
	public CatMateriaSP getCatMateriaSP() { return catMateriaSP; }
	
	public void setCatMateriaSP(CatMateriaSP catMateriaSP) { this.catMateriaSP = catMateriaSP; }

	public CatCatalogoSP getCatCatalogoSP() { return catCatalogoSP; }
	
	public void setCatCatalogoSP(CatCatalogoSP catCatalogoSP) { this.catCatalogoSP = catCatalogoSP; }
			
	public CatInstruccionSP getCatInstruccionSP() { return catInstruccionSP; }
	
	public void setCatInstruccionSP(CatInstruccionSP catInstruccionSP) { this.catInstruccionSP = catInstruccionSP; }
	
	public CatEstadosSP getCatEstadosSP() { return catEstadosSP; }
	
	public void setCatEstadosSP(CatEstadosSP catEstadosSP) { this.catEstadosSP = catEstadosSP; }
	
	public CatCircuitoSP getCatCircuitoSP() { return catCircuitoSP; }
	
	public void setCatCircuitoSP(CatCircuitoSP catCircuitoSP) { this.catCircuitoSP = catCircuitoSP; }
	
	public RepCJFSP getRepCJFSP() { return repCJFSP; }
	
	public void setRepCJFSP(RepCJFSP repCJFSP) { this.repCJFSP = repCJFSP; }

	public RepRemitenteSP getRepRemitenteSP() { return repRemitenteSP; }
	
	public void setRepRemitenteSP(RepRemitenteSP repRemitenteSP) { this.repRemitenteSP = repRemitenteSP; }

	public RepCircuitoSP getRepCircuitoSP() { return repCircuitoSP; }
	
	public void setRepCircuitoSP(RepCircuitoSP repCircuitoSP) { this.repCircuitoSP = repCircuitoSP; }

	public RepClsDocumentalSP getRepClsDocumentalSP() { return repClsDocumentalSP; }
	
	public void setRepClsDocumentalSP(RepClsDocumentalSP repClsDocumentalSP) { this.repClsDocumentalSP = repClsDocumentalSP; }

	public RepDelegMetropolitanaSP getRepDelegMetropolitanaSP() { return repDelegMetropolitanaSP; }
	
	public void setRepDelegMetropolitanaSP( RepDelegMetropolitanaSP repDelegMetropolitanaSP) { this.repDelegMetropolitanaSP = repDelegMetropolitanaSP; }

	public RepDepartamentoSP getRepDepartamentoSP() { return repDepartamentoSP; }
	
	public void setRepDepartamentoSP(RepDepartamentoSP repDepartamentoSP) { this.repDepartamentoSP = repDepartamentoSP; }

	public RepIncidenteSuspensionSP getRepIncidenteSuspensionSP() { return repIncidenteSuspensionSP; }
	
	public void setRepIncidenteSuspensionSP( RepIncidenteSuspensionSP repIncidenteSuspensionSP) { this.repIncidenteSuspensionSP = repIncidenteSuspensionSP; }

	public RepJuntaEspecialSP getRepJuntaEspecialSP() { return repJuntaEspecialSP; }
	
	public void setRepJuntaEspecialSP(RepJuntaEspecialSP repJuntaEspecialSP) { this.repJuntaEspecialSP = repJuntaEspecialSP; }

	public RepInstruccionSP getRepInstruccionSP() { return repInstruccionSP; }
	
	public void setRepInstruccionSP(RepInstruccionSP repInstruccionSP) { this.repInstruccionSP = repInstruccionSP; }

	public RepJuntaLocalSP getRepJuntaLocalSP() { return repJuntaLocalSP; }
	
	public void setRepJuntaLocalSP(RepJuntaLocalSP repJuntaLocalSP) { this.repJuntaLocalSP = repJuntaLocalSP; }

	public RepJuzgadosConciliacionSP getRepJuzgadosConciliacionSP() { return repJuzgadosConciliacionSP; }
	
	public void setRepJuzgadosConciliacionSP( RepJuzgadosConciliacionSP repJuzgadosConciliacionSP) { this.repJuzgadosConciliacionSP = repJuzgadosConciliacionSP; }

	public RepJuzgadoTribunalSP getRepJuzgadoTribunalSP() { return repJuzgadoTribunalSP; }
	
	public void setRepJuzgadoTribunalSP(RepJuzgadoTribunalSP repJuzgadoTribunalSP) { this.repJuzgadoTribunalSP = repJuzgadoTribunalSP; }

	public RepMateriaSP getRepMateriaSP() { return repMateriaSP; }
	
	public void setRepMateriaSP(RepMateriaSP repMateriaSP) { this.repMateriaSP = repMateriaSP; }

	public RepMinistroInstructorSP getRepMinistroInstructorSP() { return repMinistroInstructorSP; }
	
	public void setRepMinistroInstructorSP( RepMinistroInstructorSP repMinistroInstructorSP) { this.repMinistroInstructorSP = repMinistroInstructorSP; }

	public CatPGRSP getCatPGRSP() { return catPGRSP; }
	
	public void setCatPGRSP(CatPGRSP catPGRSP) { this.catPGRSP = catPGRSP; }

	public RepPGJSP getRepPGJSP() { return repPGJSP; }
	
	public void setRepPGJSP(RepPGJSP repPGJSP) { this.repPGJSP = repPGJSP; }

	public RepPuestoSP getRepPuestoSP() { return repPuestoSP; }
	
	public void setRepPuestoSP(RepPuestoSP repPuestoSP) { this.repPuestoSP = repPuestoSP; }

	public RepResponsableSP getRepResponsableSP() { return repResponsableSP; }
	
	public void setRepResponsableSP(RepResponsableSP repResponsableSP) { this.repResponsableSP = repResponsableSP; }

	public RepSalaSCJNSP getRepSalaSCJNSP() { return repSalaSCJNSP; }
	
	public void setRepSalaSCJNSP(RepSalaSCJNSP repSalaSCJNSP) { this.repSalaSCJNSP = repSalaSCJNSP; }

	public RepSalasFiscalesSP getRepSalasFiscalesSP() { return repSalasFiscalesSP; }
	
	public void setRepSalasFiscalesSP(RepSalasFiscalesSP repSalasFiscalesSP) { this.repSalasFiscalesSP = repSalasFiscalesSP; }

	public RepSalaTribunalConciliacionSP getRepSalaTribunalConciliacionSP() { return repSalaTribunalConciliacionSP; }
	
	public void setRepSalaTribunalConciliacionSP( RepSalaTribunalConciliacionSP repSalaTribunalConciliacionSP) { this.repSalaTribunalConciliacionSP = repSalaTribunalConciliacionSP; }

	public RepTribunalesAgrarioSP getRepTribunalesAgrarioSP() { return repTribunalesAgrarioSP; }
	
	public void setRepTribunalesAgrarioSP( RepTribunalesAgrarioSP repTribunalesAgrarioSP) { this.repTribunalesAgrarioSP = repTribunalesAgrarioSP; }

	public RepTipoJuicioSP getRepTipoJuicioSP() { return repTipoJuicioSP; }
	
	public void setRepTipoJuicioSP(RepTipoJuicioSP repTipoJuicioSP) { this.repTipoJuicioSP = repTipoJuicioSP; }

	public RepUnidadAdministrativaSP getRepUnidadAdministrativaSP() { 	return repUnidadAdministrativaSP; }
	
	public void setRepUnidadAdministrativaSP( 		RepUnidadAdministrativaSP repUnidadAdministrativaSP) { 	this.repUnidadAdministrativaSP = repUnidadAdministrativaSP; }

	public CatTipoJuicioSP getCatTipoJuicioSP() { return catTipoJuicioSP; }
	
	public void setCatTipoJuicioSP(CatTipoJuicioSP catTipoJuicioSP) { this.catTipoJuicioSP = catTipoJuicioSP; }
	
	public CatDescargoSP getCatDescargoSP() { return catDescargoSP; }
	
	public void setCatDescargoSP(CatDescargoSP catDescargoSP) {	this.catDescargoSP = catDescargoSP; }
	
	public CatResponsableSP getCatResponsableSP() {	return catResponsableSP; }
	
	public void setCatResponsableSP(CatResponsableSP catResponsableSP) { this.catResponsableSP = catResponsableSP; }
	
	public RepUnidadEspecializadaSP getRepUnidadEspecializadaSP() {	return repUnidadEspecializadaSP; }
	
	public void setRepUnidadEspecializadaSP( RepUnidadEspecializadaSP repUnidadEspecializadaSP ) { this.repUnidadEspecializadaSP = repUnidadEspecializadaSP; }
	
	public InsPerfilSP getInsPerfilSP() { return insPerfilSP; }
	
	public void setInsPerfilSP(InsPerfilSP insPerfilSP) { this.insPerfilSP = insPerfilSP; }
	
	public ModPerfilSP getModPerfilSP() { return modPerfilSP; }
	
	public void setModPerfilSP(ModPerfilSP modPerfilSP) { this.modPerfilSP = modPerfilSP; }			

	public CatOrganoJudSP getCatOrganoJudSP() { return catOrganoJudSP; }
	
	public void setCatOrganoJudSP(CatOrganoJudSP catOrganoJudSP) { this.catOrganoJudSP = catOrganoJudSP; }

	public CatRemitenteSP getCatRemitenteSP() { return catRemitenteSP; }
	
	public void setCatRemitenteSP(CatRemitenteSP catRemitenteSP) { this.catRemitenteSP = catRemitenteSP; }

	public CatJuezDTOSP getCatJuezDTOSP() { return catJuezDTOSP; }
	
	public void setCatJuezDTOSP(CatJuezDTOSP catJuezDTOSP) { this.catJuezDTOSP = catJuezDTOSP; }

	public InsertarActualizarDesacargoSP getInsertarActualizarDesacargoSP() { return insertarActualizarDesacargoSP; }
	
	public void setInsertarActualizarDesacargoSP( InsertarActualizarDesacargoSP insertarActualizarDesacargoSP) { this.insertarActualizarDesacargoSP = insertarActualizarDesacargoSP; }

	public InsertaNuevoDocumentoMFSP getInsertaNuevoDocumentoMFSP() { return insertaNuevoDocumentoMFSP; }
	
	public void setInsertaNuevoDocumentoMFSP( InsertaNuevoDocumentoMFSP insertaNuevoDocumentoMFSP) { this.insertaNuevoDocumentoMFSP = insertaNuevoDocumentoMFSP; }

	public InsertaNuevoDocumentoMLSP getInsertaNuevoDocumentoMLSP() { return insertaNuevoDocumentoMLSP; }
	
	public void setInsertaNuevoDocumentoMLSP( InsertaNuevoDocumentoMLSP insertaNuevoDocumentoMLSP) { this.insertaNuevoDocumentoMLSP = insertaNuevoDocumentoMLSP; }

	public InsertaNuevoDocumentoPNSP getInsertaNuevoDocumentoPNSP() { return insertaNuevoDocumentoPNSP; }
	
	public void setInsertaNuevoDocumentoPNSP( InsertaNuevoDocumentoPNSP insertaNuevoDocumentoPNSP) { this.insertaNuevoDocumentoPNSP = insertaNuevoDocumentoPNSP; }
	
	public InsertaAmparoFLMSP getInsertaAmparoFLMSP() { return insertaAmparoFLMSP; }

	public void setInsertaAmparoFLMSP(InsertaAmparoFLMSP insertaAmparoFLMSP) { this.insertaAmparoFLMSP = insertaAmparoFLMSP; }

	public InsertaAgrario getInsertaAgrario() { return insertaAgrario; }

	public void setInsertaAgrario(InsertaAgrario insertaAgrario) { this.insertaAgrario = insertaAgrario; }

	public ObtenNumeroRegistroSP getObtenNumeroRegistroSP() { return obtenNumeroRegistroSP; }

	public void setObtenNumeroRegistroSP(ObtenNumeroRegistroSP obtenNumeroRegistroSP) {	this.obtenNumeroRegistroSP = obtenNumeroRegistroSP; }

	public InsertaLaboralSP getInsertaLaboralSP() {	return insertaLaboralSP; }

	public void setInsertaLaboralSP(InsertaLaboralSP insertaLaboralSP) { this.insertaLaboralSP = insertaLaboralSP; }

	public SelectNumeroRegistroSP getSelectNumeroRegistroSP() { return selectNumeroRegistroSP; }

	public void setSelectNumeroRegistroSP(SelectNumeroRegistroSP selectNumeroRegistroSP) { this.selectNumeroRegistroSP = selectNumeroRegistroSP; }

	public CatTurnadoSP getCatTurnadoSP() { return catTurnadoSP; }

	public void setCatTurnadoSP(CatTurnadoSP catTurnadoSP) { this.catTurnadoSP = catTurnadoSP; }

	public InsertaNuevoDocumentoSP getInsertaNuevoDocumentoSP() { return insertaNuevoDocumentoSP; }

	public void setInsertaNuevoDocumentoSP(InsertaNuevoDocumentoSP insertaNuevoDocumentoSP) {
		   this.insertaNuevoDocumentoSP = insertaNuevoDocumentoSP;
	}

	public ConsultaEditarDocumentoSP getConsultaEditarDocumentoSP() { return consultaEditarDocumentoSP; }

	public void setConsultaEditarDocumentoSP(ConsultaEditarDocumentoSP consultaEditarDocumentoSP) {
		   this.consultaEditarDocumentoSP = consultaEditarDocumentoSP;
	}	
		
}