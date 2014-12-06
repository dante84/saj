package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.ConsultarBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;
import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.PenalTblBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.SeguimientoDAO;
import mx.gob.se.sraaj.persistencia.sp.ActualizaAmparoAgrarioSegSP;
import mx.gob.se.sraaj.persistencia.sp.ActualizaJuicioAgrarioSP;
import mx.gob.se.sraaj.persistencia.sp.ActualizarAsuntosJuridicosSP;
import mx.gob.se.sraaj.persistencia.sp.ActualizarPenalSP;
import mx.gob.se.sraaj.persistencia.sp.CatMateriaSP;
import mx.gob.se.sraaj.persistencia.sp.CatPenalSP;
import mx.gob.se.sraaj.persistencia.sp.CatTribunalSP;
import mx.gob.se.sraaj.persistencia.sp.CatTurnarASP;
import mx.gob.se.sraaj.persistencia.sp.ConsultarSP;
import mx.gob.se.sraaj.persistencia.sp.DocumentosRelSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaDescargoPenalSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaSegPenalSP;
import mx.gob.se.sraaj.persistencia.sp.PenalTblSP;
import mx.gob.se.sraaj.persistencia.sp.SeguimientoJuiciosSP;
import mx.gob.se.sraaj.persistencia.sp.SeguimientoSP;
import mx.gob.se.sraaj.persistencia.sp.ConsultaRecepcionSP;

public class SeguimientoDAOImpl implements SeguimientoDAO{
		
	   private SeguimientoSP seguimientoSP;
	   private CatMateriaSP catMateriaSP;
	   private ActualizarAsuntosJuridicosSP actualizarAsuntosJuridicosSP;
	   private CatTribunalSP catTribunalSP;
	   private ActualizaJuicioAgrarioSP actualizaJuicioAgrarioSP;
	   private SeguimientoJuiciosSP seguimientoJuiciosSP;
	   private ActualizaAmparoAgrarioSegSP actualizaAmparoAgrarioSegSP;
	   private DocumentosRelSP documentosRelSP;
	   private ConsultarSP consultarSP;
	   private ConsultaRecepcionSP consultaRecepcionSP;
	   private PenalTblSP penalTblSP;
	   private CatPenalSP catPenalSP;
	   private CatTurnarASP catTurnarASP;
	   private InsertaDescargoPenalSP insertaDescargoPenalSP;
	   private InsertaSegPenalSP insertaSegPenalSP;
	   private ActualizarPenalSP actualizarPenalSP;

	   @Override
	   public List<CatTribunalBean> obtenerTribunal()throws SraajException {
		    
		      System.out.println("=====>> en DAO obtener tribunal");
		      List<CatTribunalBean> lCat = null;
		      
  		      try{
  		    	  
			      Map<String, Object> mapCursor = catTribunalSP.execute();
			      if( mapCursor != null ){
				      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if( seg instanceof List<?> ){
					      lCat = (List<CatTribunalBean>) seg;
				      }
			      }
			      
			      return lCat;
			      
		      }catch ( Exception ex ){
 			           ex.printStackTrace();
			           throw new SraajException(ex.getMessage(), ex);
		      }
  		      
	   }
	
	   @Override
	   public List<SeguimientoBean> obtenerSeguimiento(Date sqlfecha,String busqueda, Integer idjuicio) throws SraajException {
		   
		      System.out.println("En obtenerSeguimiento");
		      		    
		      List<SeguimientoBean> lCat = null;		      		      
		  
		      try{
			   
			      Map<String,Object> mapCursor = seguimientoSP.execute(sqlfecha,busqueda,idjuicio);  
			   
			      if( mapCursor != null ){
				      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if( seg instanceof List<?> ){
					      lCat = (List<SeguimientoBean>) seg;					   
				      }
			      }
			   
			      return lCat;
			   
		      }catch( Exception ex ){
			          ex.printStackTrace();
			          throw new SraajException(ex.getMessage(), ex);
		      }
		   
	   }
		
	   @Override
	   public List<CatMateriaBean> obtenerMaterias() throws SraajException {
		   
		      System.out.println("En obtenerMaterias");
    	   
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
	   public Boolean actualizarJuicioAgrario(int idreg, Integer idmateria, Integer idtribunal, Date fechaVenc) throws SraajException{
		   
			  try{
				  Map<String, Object> errorBd = actualizaJuicioAgrarioSP.execute(idreg, idmateria, idtribunal, fechaVenc); 
					 
				 @SuppressWarnings("unchecked")
	  	         List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		         ErrorBDBean errVO = err.get(0);
				      
	    	     if( errVO != null ) {
				       
				     System.out.println(errVO.getsCodError());
				     System.out.println(errVO.getsDescError());
				       
				     if( errVO.getsCodError().equals("DBSE000") ) { return true; }
				     
				 }
				 
		      }catch ( Exception e ){
					   System.out.println("error al actualizar agrario");
					   e.printStackTrace();
			  }
				
			  return false;
			  
	   }
	
	   @Override
	   public Boolean actualizarAsuntosJuridicos(int idreg, Integer idmateria, Date fechaConv, Date fechaVenc) throws SraajException{
			 
		      try{
				
		    	  Map<String, Object> errorBd = actualizarAsuntosJuridicosSP.execute(idreg, idmateria, fechaConv, fechaVenc); 
					 
			      @SuppressWarnings("unchecked")
				  List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
				  ErrorBDBean errVO = err.get(0);
				      
				  if( errVO != null ) {
				       
				      System.out.println(errVO.getsCodError());
				      System.out.println(errVO.getsDescError());
				       
				      if( errVO.getsCodError().equals("DBSE000") ){ return true; }
				      
				  }
				 
		      }catch (Exception e) { e.printStackTrace(); }
		      				
			  return false;
			  
	   }
	
	   @Override
	   public List<SeguimientoJuiciosBean> obtenerSeguimientoJuicios(String busqueda, Integer idjuicio) throws SraajException{
    	   
		      System.out.println("=====>> en DAO seguimiento juicios");
		      List<SeguimientoJuiciosBean> lCat = null;
		      
		      try{
		    	  
			      Map<String, Object> mapCursor = seguimientoJuiciosSP.execute(busqueda, idjuicio);
			      if( mapCursor != null ){
				      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if( seg instanceof List<?> ){
					      lCat = (List<SeguimientoJuiciosBean>) seg;
				      }
			      }
			      
			      return lCat;
			      
		      }catch ( Exception ex ){
			           ex.printStackTrace();
			           throw new SraajException(ex.getMessage(), ex);
		      }
		      
	   }
	
	   @Override
   	   public Boolean actualizarAmparoAgrarioSegSP(int idreg, String expInterno, String estatus) throws SraajException {
			
		      try{
				  Map<String, Object> errorBd = actualizaAmparoAgrarioSegSP.execute(idreg, expInterno, estatus); 
					 
				  @SuppressWarnings("unchecked")
				  List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
				  ErrorBDBean errVO = err.get(0);
				      
				  if( errVO != null ) {
				       
				      System.out.println(errVO.getsCodError());
				      System.out.println(errVO.getsDescError());
				       
				      if( errVO.getsCodError().equals("DBSE000") ){ return true; }
				      
				  }
				 
		      }catch (Exception e) { e.printStackTrace(); }
				
			  return false;
			  
	   }
	
	   @Override
	   public List<DocumentosRelBean> obtenerDocumentos(String noJuicio) throws SraajException {
    	   
		      System.out.println("=====>> en DAO obtenerDocumentos");
		      List<DocumentosRelBean> lCat = null;
		      
		      try{
		    	  
			      Map<String, Object> mapCursor = documentosRelSP.execute(noJuicio);
			      if( mapCursor != null ){
				      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if(seg instanceof List<?>){ lCat = (List<DocumentosRelBean>) seg; }
			      }
			      
			      return lCat;
			      
		      }catch (Exception ex){
			          System.out.println("error al obtener los documentos");
			          ex.printStackTrace();
			          throw new SraajException(ex.getMessage(), ex);
		      }
		      
	   }
	   
	   @Override
	   public DocumentoBean consultarDocumento(int idRegDoc, int idTipoJuicio)throws Exception {
		   		      		     
		      List<DocumentoBean>lCat = null;
		      
              try{
		    	  
			      Map<String, Object> mapCursor = consultaRecepcionSP.execute(idRegDoc,idTipoJuicio);
			      if( mapCursor != null ){
				      Object seg = mapCursor.get( Constantes.OUT_SP_RESULTADO );
				      if( seg instanceof List<?> ){ 
				    	  lCat = (List<DocumentoBean>) seg;
				    	 
				      }
				      
			      }
			      
			      return lCat.get(0);
			      
		      }catch (Exception ex){
			          System.out.println("error al obtener los documentos");
			          ex.printStackTrace();
			          throw new SraajException(ex.getMessage(), ex);
		      }
		      		   			 
	   }
    
    
    @Override
   	public List<ConsultarBean> obtenerConsulta(Integer id) throws SraajException
   	{
   		System.out.println("=====>> en DAO seguimiento juicios");
   		List<ConsultarBean> lCat = null;
   		try{
   			Map<String, Object> mapCursor = consultarSP.execute(id);
   			if(mapCursor != null){
   				Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
   				if(seg instanceof List<?>){
   					lCat = (List<ConsultarBean>) seg;
   				}
   			}
   			return lCat;
   		}
   		catch (Exception ex){
   			ex.printStackTrace();
   			throw new SraajException(ex.getMessage(), ex);
   		}
   	}
    
    @Override
    public List<CatMateriaBean> pasarMaterias() throws Exception{
    	   
           System.out.println("En pasarMaterias");
 	   
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
		       
	       }catch(Exception ex){
		          ex.printStackTrace();
		          throw new SraajException(ex.getMessage(), ex);
	       }
    	
    }
        
	@Override
	public List<PenalTblBean> obtenerPenalTbl(Date fecha,String busqueda, Integer noJuicio) throws SraajException {
		
		   return null;
		   
	}

	@Override
	public List<CatGenerico> obtenerCatPenal() throws SraajException {
		
		   return null;
		   
	}

	@Override
	public List<CatGenerico> obtenerTurnarA() throws SraajException {
		
		   return null;
		   
	}
	
	@Override
	public Boolean actualizarPenalSP(int idreg, Integer idCatPenal,Integer idcatdescargo, String Aindiciado, Integer instruccion1,
			                         Integer instruccion2, Integer instruccion3, Integer instruccion4,Integer instruccion5,Integer instruccion6,
			                         Integer instruccion7, Integer instruccion8, Integer idTurnar, Date fechaTermino,String estatus) throws SraajException {
		
		System.out.println(idreg+","+idCatPenal+","+idcatdescargo+","+Aindiciado+","+instruccion1+","+instruccion2+","+instruccion3+","+instruccion4+","+instruccion5+","+instruccion6+","+instruccion7+","+instruccion8+","+idTurnar+","+fechaTermino+","+estatus);
		
		try{
			Map<String, Object> errorBd = actualizarPenalSP.execute(idreg
					 															, idCatPenal
					 															, idcatdescargo
					 															, Aindiciado
					 															, instruccion1
					 															, instruccion2
					 															, instruccion3 
					 															, instruccion4
					 															, instruccion5
					 															, instruccion6
					 															, instruccion7
					 															, instruccion8
					 															, idTurnar
					 															, fechaTermino
					 															, estatus); 
			 
			 @SuppressWarnings("unchecked")
		      List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		      ErrorBDBean errVO = err.get(0);
		      
		      if( errVO != null ) {
		       
		       System.out.println(errVO.getsCodError());
		       System.out.println(errVO.getsDescError());
		       
		       if( errVO.getsCodError().equals("DBSE000") )
		       { return true; }
		      }
		 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
		    
	}

	@Override
	public Boolean insertaDescargoPenal(int idregdoc, Date fecOficio,Integer numReg, String sentidoOficio, String destinatario,
			                            String observaciones, String archivo, int opc, String comentarios)throws SraajException {
		
		   try{
			   
			   Map<String, Object> errorBd = insertaDescargoPenalSP.execute(idregdoc,fecOficio,numReg,sentidoOficio,destinatario,observaciones,archivo,
					                                                        opc,comentarios); 
			 
			   @SuppressWarnings("unchecked")
		       List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		       ErrorBDBean errVO = err.get(0);
		      
		       if( errVO != null ) {
		       
  		           System.out.println(errVO.getsCodError());
		           System.out.println(errVO.getsDescError());
		       
		           if( errVO.getsCodError().equals("DBSE000") ){ return true; }
		           
		      }
		 
		  }catch (Exception e){	e.printStackTrace(); }
		
		  return false;
		   
	}

	@Override
	public Boolean insertasegPenal(Integer Aidregdoc, String AnumExpPenal,String Adelito, String Adenuncia, Double Aimporte,
			                       String AflujoProcesal) throws SraajException {
		
		   System.out.println(Aimporte);
		
		   try{
			   Map<String, Object> errorBd = insertaSegPenalSP.execute(Aidregdoc,  AnumExpPenal,  Adelito,  Adenuncia, Aimporte,  AflujoProcesal); 
			 
			   @SuppressWarnings("unchecked")
		       List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
		       ErrorBDBean errVO = err.get(0);
		      
		       if( errVO != null ) {
		       
		           System.out.println(errVO.getsCodError());
		           System.out.println(errVO.getsDescError());
		       
		           if( errVO.getsCodError().equals("DBSE000") ){ return true; }
		      }
		 
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
		   
	}
       		
    public SeguimientoSP getSeguimientoSP() { return seguimientoSP; }

	public void setSeguimientoSP(SeguimientoSP seguimientoSP) {	this.seguimientoSP = seguimientoSP; }

	public CatMateriaSP getCatMateriaSP() {	return catMateriaSP; }

	public void setCatMateriaSP(CatMateriaSP catMateriaSP) { this.catMateriaSP = catMateriaSP; }

	public ActualizarAsuntosJuridicosSP getActualizarAsuntosJuridicosSP() {	return actualizarAsuntosJuridicosSP; }

	public void setActualizarAsuntosJuridicosSP( ActualizarAsuntosJuridicosSP actualizarAsuntosJuridicosSP) { this.actualizarAsuntosJuridicosSP = actualizarAsuntosJuridicosSP;	}

	public CatTribunalSP getCatTribunalSP() { return catTribunalSP; }

	public void setCatTribunalSP(CatTribunalSP catTribunalSP) { this.catTribunalSP = catTribunalSP; }

	public ActualizaJuicioAgrarioSP getActualizaJuicioAgrarioSP() {	return actualizaJuicioAgrarioSP; }

	public void setActualizaJuicioAgrarioSP( ActualizaJuicioAgrarioSP actualizaJuicioAgrarioSP ) { this.actualizaJuicioAgrarioSP = actualizaJuicioAgrarioSP; }

	public SeguimientoJuiciosSP getSeguimientoJuiciosSP() { return seguimientoJuiciosSP; }

	public void setSeguimientoJuiciosSP(SeguimientoJuiciosSP seguimientoJuiciosSP) { this.seguimientoJuiciosSP = seguimientoJuiciosSP; }

	public ActualizaAmparoAgrarioSegSP getActualizaAmparoAgrarioSegSP() { return actualizaAmparoAgrarioSegSP; }

	public void setActualizaAmparoAgrarioSegSP(ActualizaAmparoAgrarioSegSP actualizaAmparoAgrarioSegSP) { this.actualizaAmparoAgrarioSegSP = actualizaAmparoAgrarioSegSP; }

	public DocumentosRelSP getDocumentosRelSP() { return documentosRelSP; }

	public void setDocumentosRelSP(DocumentosRelSP documentosRelSP) { this.documentosRelSP = documentosRelSP; }
  	   
	public ConsultarSP getConsultarSP() { return consultarSP; }

    public void setConsultarSP(ConsultarSP consultarSP) { this.consultarSP = consultarSP; }

    public ConsultaRecepcionSP getConsultaRecepcionSP() { return consultaRecepcionSP; }

    public void setConsultaRecepcionSP(ConsultaRecepcionSP consultaRecepcionSP) { this.consultaRecepcionSP = consultaRecepcionSP; }

    public PenalTblSP getPenalTblSP() { return penalTblSP; }

    public void setPenalTblSP(PenalTblSP penalTblSP) { this.penalTblSP = penalTblSP; }

    public CatPenalSP getCatPenalSP() { return catPenalSP; }

    public void setCatPenalSP(CatPenalSP catPenalSP) { this.catPenalSP = catPenalSP; }

    public CatTurnarASP getCatTurnarA() { return catTurnarASP; }

    public void setCatTurnarA(CatTurnarASP catTurnarA) { this.catTurnarASP = catTurnarA; }

    public CatTurnarASP getCatTurnarASP() { return catTurnarASP; }

    public void setCatTurnarASP(CatTurnarASP catTurnarASP) { this.catTurnarASP = catTurnarASP; }

	public InsertaDescargoPenalSP getInsertaDescargoPenalSP() { return insertaDescargoPenalSP; }

	public void setInsertaDescargoPenalSP(InsertaDescargoPenalSP insertaDescargoPenalSP) { this.insertaDescargoPenalSP = insertaDescargoPenalSP; }

	public InsertaSegPenalSP getInsertaSegPenalSP() { return insertaSegPenalSP; }

	public void setInsertaSegPenalSP(InsertaSegPenalSP insertaSegPenalSP) { this.insertaSegPenalSP = insertaSegPenalSP; }

	public ActualizarPenalSP getActualizarPenalSP() { return actualizarPenalSP;	}

	public void setActualizarPenalSP(ActualizarPenalSP actualizarPenalSP) {	this.actualizarPenalSP = actualizarPenalSP; }

}
