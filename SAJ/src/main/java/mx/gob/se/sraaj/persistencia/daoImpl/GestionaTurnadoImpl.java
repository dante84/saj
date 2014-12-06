package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.sp.InsTurnadoSP;
import mx.gob.se.sraaj.persistencia.sp.InsertaNewTurnado;
import mx.gob.se.sraaj.persistencia.sp.TurnadoSP;
import mx.gob.se.sraaj.transferencia.beanImpl.TurnadoBeanImpl;

public class GestionaTurnadoImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TurnadoSP turnadoSP; 			  
	public TurnadoSP getTurnadoSP() { return turnadoSP;}
	public void setTurnadoSP(TurnadoSP turnadoSP) { this.turnadoSP = turnadoSP; }
	
	private InsTurnadoSP  insTurnadoSP;
	public InsTurnadoSP getInsTurnadoSP() {return insTurnadoSP;}
	public void setInsTurnadoSP(InsTurnadoSP insTurnadoSP) {this.insTurnadoSP = insTurnadoSP;}
	
	@SuppressWarnings("unchecked")
	public List<TurnadoBeanImpl> obtieneTurnado() throws Exception {
			  List<TurnadoBeanImpl> lTur = null;
		      try{		    
			      Map<String, Object> mapCursor = turnadoSP.execute();			      			      
			      if( mapCursor != null ){			    	 
			    	  lTur = (List<TurnadoBeanImpl>)mapCursor.get(Constantes.OUT_SP_RESULTADO);			          			         			          				          			 			          			          
		  	      }					 
		      }catch(Exception ex) { ex.printStackTrace(); }		   
		      return lTur;		
	}
	
	private InsertaNewTurnado insertaNewTurnado;	
	public InsertaNewTurnado getInsertaNewTurnado() { return insertaNewTurnado;}
	public void setInsertaNewTurnado(InsertaNewTurnado insertaNewTurnado) { this.insertaNewTurnado = insertaNewTurnado; }
	
	@SuppressWarnings("unchecked")
	public boolean insertaNewTurnado(TurnadoBeanImpl turnadoBeanImpl) throws Exception{
		   
		   try{
		     System.out.println("LLamando al SP para insertaNewTurnado.... ");
		     
			   Map<String, Object> errorBd = insertaNewTurnado.execute(turnadoBeanImpl);					   
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
	

}
