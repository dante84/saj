package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.AsuntosJuridicosRepSeg;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.sp.AsuntosJuridicosRepSegSP;

public class AsuntosJuridicosRepSegDAOImpl {
	
	private AsuntosJuridicosRepSegSP asuntosJuridicosRepSegSP;		
	
	public AsuntosJuridicosRepSegSP getAsuntosJuridicosRepSegSP() { return asuntosJuridicosRepSegSP;}
	public void setAsuntosJuridicosRepSegSP( AsuntosJuridicosRepSegSP asuntosJuridicosRepSegSP) {this.asuntosJuridicosRepSegSP = asuntosJuridicosRepSegSP;}
	
	@SuppressWarnings("unchecked")
	public List<AsuntosJuridicosRepSeg> buscarSegAmpForaneo() throws SraajException {			
		      System.out.println("Seguimiento DAO");		      
		      try{
			      List<AsuntosJuridicosRepSeg> lista = null;
			      Map<String, Object> mapCursor = asuntosJuridicosRepSegSP.execute();			      
			      for( java.util.Map.Entry<String,Object> entry: mapCursor.entrySet() ){
			    	    System.out.println(entry.getKey() + " -- " + entry.getValue());			    	    
			      }			    
			      if( mapCursor != null ){
			          Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			          if( datos instanceof List<?>) {
				          lista = (List<AsuntosJuridicosRepSeg>) datos;
			          }
			      }			
			      return lista;			    
		   }catch(Exception ex) { ex.printStackTrace(); throw new SraajException(ex.getMessage(), ex); }		  
	   }
		  
	
}
