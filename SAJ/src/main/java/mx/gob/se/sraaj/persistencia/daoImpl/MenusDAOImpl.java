package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.MenusDAO;
import mx.gob.se.sraaj.persistencia.sp.SelCatMenuSP;

public class MenusDAOImpl implements MenusDAO{
	
	private SelCatMenuSP selCatMenuSP;

	public SelCatMenuSP getSelCatMenuSP() { return selCatMenuSP; }
	public void setSelCatMenuSP(SelCatMenuSP selCatMenuSP) { this.selCatMenuSP = selCatMenuSP; }
	
	public List<MenuBean> obtenMenus() throws SraajException{
		System.out.println("========>> en menusDAO obtenMenus");
		List<MenuBean> lMen = null;
		try{
			Map<String, Object> mapCursor = selCatMenuSP.execute();
			if(mapCursor != null){
				Object datos=mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(datos instanceof List<?>) {
					lMen = (List<MenuBean>) datos;
				}
			}
			return lMen;
		}
		catch(Exception e){
			throw new SraajException(e.getMessage());
		}
	}

}
