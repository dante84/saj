package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;


public interface AdministracionDAO 
{
	
	public List<CatGeneralBean> obtienePerfiles() throws Exception;

}
