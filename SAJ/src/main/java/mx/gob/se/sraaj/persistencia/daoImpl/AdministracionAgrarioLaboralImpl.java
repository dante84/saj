package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;





import mx.gob.se.sraaj.comunes.bean.CatAutoridadBean;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.AdministracionAgrarioLaboralDAO;
import mx.gob.se.sraaj.persistencia.sp.CatTribunalSP;
import mx.gob.se.sraaj.persistencia.sp.obtenerCatAutoridadSP;


public class AdministracionAgrarioLaboralImpl  implements AdministracionAgrarioLaboralDAO, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private CatTribunalSP catTribunalSP;
	private obtenerCatAutoridadSP catAutoridadSP;
	
	
	
	@SuppressWarnings("unchecked")
	public List<CatTribunalBean> obtieneTribunal() throws SraajException {
		System.out.println("=====>> en DAO ObtieneTribunales");
		List<CatTribunalBean> lCat = null;
		try{
			Map<String, Object> mapCursor = catTribunalSP.execute();
			if(mapCursor != null){
				Object tribunales = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(tribunales instanceof List<?>){
					lCat = (List<CatTribunalBean>) tribunales;
				}
			}
			return lCat;
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex);
		}
	}


	@SuppressWarnings("unchecked")
	public List<CatAutoridadBean> obtenerAutoridad() throws SraajException
	{
		List<CatAutoridadBean> lCat = null;
		try{
			Map<String, Object> mapCursor = catAutoridadSP.execute();
			if(mapCursor != null){
				Object autoridad = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(autoridad instanceof List<?>){
					lCat = (List<CatAutoridadBean>) autoridad;
				}
			}
			return lCat;
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex);
		}
	}
	

	public CatTribunalSP getCatTribunalSP() {
		return catTribunalSP;
	}



	public void setCatTribunalSP(CatTribunalSP catTribunalSP) {
		this.catTribunalSP = catTribunalSP;
	}



	public obtenerCatAutoridadSP getCatAutoridadSP() {
		return catAutoridadSP;
	}



	public void setCatAutoridadSP(obtenerCatAutoridadSP catAutoridadSP) {
		this.catAutoridadSP = catAutoridadSP;
	}




	
	

}
