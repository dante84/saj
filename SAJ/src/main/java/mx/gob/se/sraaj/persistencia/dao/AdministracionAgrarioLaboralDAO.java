package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface AdministracionAgrarioLaboralDAO 
{
	public List<CatTribunalBean> obtieneTribunal()throws SraajException;
}
