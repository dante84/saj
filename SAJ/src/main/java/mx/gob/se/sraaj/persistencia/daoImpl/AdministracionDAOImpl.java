package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.AdministracionDAO;
import mx.gob.se.sraaj.persistencia.sp.MuestraPerfilesSP;

public class AdministracionDAOImpl  implements AdministracionDAO, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MuestraPerfilesSP muestraPerfilesSP;

	public void setMuestraPerfilesSP(MuestraPerfilesSP muestraPerfilesSP) {
		this.muestraPerfilesSP = muestraPerfilesSP;
	}

	public List<CatGeneralBean> obtienePerfiles() throws SraajException {
		System.out.println("=====>> en DAO ObtienePerfiles");
		List<CatGeneralBean> lCat = null;
		try{
			Map<String, Object> mapCursor = muestraPerfilesSP.execute();
			if(mapCursor != null){
				Object catalogo = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(catalogo instanceof List<?>){
					lCat = (List<CatGeneralBean>) catalogo;
				}
			}
			return lCat;
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new SraajException(ex.getMessage(), ex);
		}
	}
	
}
