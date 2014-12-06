package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatGralBean;
import mx.gob.se.sraaj.comunes.bean.PerfilBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface PerfilDAO {

	public List<PerfilBean> buscaPermisos(String idP) throws SraajException;
}
