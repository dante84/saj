package mx.gob.se.sraaj.servicio.bean;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.RecepcionLaboralBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.transferencia.bean.RecepcionFiscalBean;

public interface RecepcionBean {
	public List<RecepcionLaboralBean> buscaRecepcionLaboral() throws SraajException;

}
