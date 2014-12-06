package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.RecepcionLaboralBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface RecepcionDAO {
	
	public List<RecepcionLaboralBean> buscaRecepcionAmparosForaneos() throws SraajException;
	public List<RecepcionLaboralBean> buscaRecepcionAmparosLocales() throws SraajException;
	public List<RecepcionLaboralBean> buscaRecepcionMinas() throws SraajException;
	
}
