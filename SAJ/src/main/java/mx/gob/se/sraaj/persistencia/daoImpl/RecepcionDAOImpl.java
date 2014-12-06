package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.RecepcionDAO;
import mx.gob.se.sraaj.persistencia.sp.RepRecepcionAmparosForaneosSP;
import mx.gob.se.sraaj.persistencia.sp.RepRecepcionAmparosLocalesSP;
import mx.gob.se.sraaj.persistencia.sp.RepRecepcionFiscalSP;
import mx.gob.se.sraaj.persistencia.sp.RepRecepcionLaboralSP;
import mx.gob.se.sraaj.persistencia.sp.RepRecepcionMinasSP;
import mx.gob.se.sraaj.transferencia.bean.RecepcionFiscalBean;
import mx.gob.se.sraaj.comunes.bean.RecepcionLaboralBean;

public class RecepcionDAOImpl implements RecepcionDAO {
	
	   private RepRecepcionAmparosForaneosSP		repRecepcionAmparosForaneosSP;
	   private RepRecepcionAmparosLocalesSP		repRecepcionAmparosLocalesSP;
	   private RepRecepcionMinasSP					repRecepcionMinasSP;
		
	   public List<RecepcionLaboralBean> buscaRecepcionAmparosForaneos() throws SraajException {
		   
		      System.out.println("========>> en recepcionDAO.buscarRecepcionLaboral");
		      
		      try{
		          List<RecepcionLaboralBean> lCat = new ArrayList<RecepcionLaboralBean>();
			      Map<String, Object> mapCursor = repRecepcionAmparosForaneosSP.execute();
			      
			      if( mapCursor != null ) {
				      Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				      if(datos instanceof List<?>){
					lCat = (List<RecepcionLaboralBean>) datos;
				}
			}
			return lCat;
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex);
		}
	}

	
	public List<RecepcionLaboralBean> buscaRecepcionAmparosLocales() throws SraajException{
		System.out.println("========>> en recepcionDAO.buscaRecepcionAmparosLocales");
		List<RecepcionLaboralBean> aLocal = null;
		try{
			Map<String, Object> mapCursor = repRecepcionAmparosLocalesSP.execute();
			if(mapCursor != null){
				Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(datos instanceof List<?>){
					aLocal = (List<RecepcionLaboralBean>) datos;
				}
			}
			return aLocal;
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex); 
		}
	}
	
	public List<RecepcionLaboralBean> buscaRecepcionMinas() throws SraajException{
		System.out.println("========>> en recepcionDAOImpl.buscaRecepcionMinas");
		List<RecepcionLaboralBean> lMinas = null;
		try{
			Map<String, Object> mapCursor = repRecepcionMinasSP.execute();
			if(mapCursor != null){
				Object datos = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(datos instanceof List<?>){
					lMinas = (List<RecepcionLaboralBean>) datos;
				}
			}
			return lMinas;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex);
		}
	}

	public RepRecepcionAmparosForaneosSP getRepRecepcionAmparosForaneosSP() {
		return repRecepcionAmparosForaneosSP;
	}

	public void setRepRecepcionAmparosForaneosSP(
			RepRecepcionAmparosForaneosSP repRecepcionAmparosForaneosSP) {
		this.repRecepcionAmparosForaneosSP = repRecepcionAmparosForaneosSP;
	}

	public RepRecepcionAmparosLocalesSP getRepRecepcionAmparosLocalesSP() {
		return repRecepcionAmparosLocalesSP;
	}

	public void setRepRecepcionAmparosLocalesSP(
			RepRecepcionAmparosLocalesSP repRecepcionAmparosLocalesSP) {
		this.repRecepcionAmparosLocalesSP = repRecepcionAmparosLocalesSP;
	}

	public RepRecepcionMinasSP getRepRecepcionMinasSP() {
		return repRecepcionMinasSP;
	}

	public void setRepRecepcionMinasSP(RepRecepcionMinasSP repRecepcionMinasSP) {
		this.repRecepcionMinasSP = repRecepcionMinasSP;
	}
}
