package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.DemandaInicialBean;
import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.sp.ActualizaDemandaSegOrdCivPen;
import mx.gob.se.sraaj.persistencia.sp.InsertaDemandaSegOrdCivPen;


public class GestionaDemandaImpl implements Serializable  {

	private static final long serialVersionUID = 1L;
		
	private InsertaDemandaSegOrdCivPen insertaDemandaSegOrdCivPen;			
	public InsertaDemandaSegOrdCivPen getInsertaDemandaSegOrdCivPen() { return insertaDemandaSegOrdCivPen;}
	public void setInsertaDemandaSegOrdCivPen(
			InsertaDemandaSegOrdCivPen insertaDemandaSegOrdCivPen) {
			this.insertaDemandaSegOrdCivPen = insertaDemandaSegOrdCivPen;}
	
	private ActualizaDemandaSegOrdCivPen actualizaDemandaSegOrdCivPen;
	public ActualizaDemandaSegOrdCivPen getActualizaDemandaSegOrdCivPen() { return actualizaDemandaSegOrdCivPen;}
	public void setActualizaDemandaSegOrdCivPen( 
			ActualizaDemandaSegOrdCivPen actualizaDemandaSegOrdCivPen) {
			this.actualizaDemandaSegOrdCivPen = actualizaDemandaSegOrdCivPen;}
	
	
	@SuppressWarnings("unchecked")
	public boolean insertaNewDemanda(DemandaInicialBean demandaInicialBean) throws Exception{
		   
		   try{
		     System.out.println("LLamando al SP para insertaNewDemanda.... ");
		     
			   Map<String, Object> errorBd = insertaDemandaSegOrdCivPen.execute(demandaInicialBean); 					   
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
	
	@SuppressWarnings("unchecked")
	public boolean actualizaNewDemanda(Integer pidfproc, Integer pidopc, String pfecha, String pTexto) throws Exception{
		   
		   try{
		     System.out.println("LLamando al SP para actualizaNewDemanda.... ");
		     
			   Map<String, Object> errorBd = actualizaDemandaSegOrdCivPen.execute(pidfproc, pidopc, pfecha, pTexto); 					   
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
