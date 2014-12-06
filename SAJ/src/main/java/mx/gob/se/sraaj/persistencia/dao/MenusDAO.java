package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.MenuBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface MenusDAO {

	public List<MenuBean> obtenMenus() throws SraajException;
}
