package mx.gob.se.sraaj.servicio.beanImpl;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.RecepcionLaboralBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.dao.RecepcionDAO;
import mx.gob.se.sraaj.servicio.bean.RecepcionBean;
import mx.gob.se.sraaj.transferencia.bean.RecepcionFiscalBean;

public class RecepcionBeanImpl implements RecepcionBean {
	
	private RecepcionDAO 		recepcionLaboralDAO;
	
	
	
	public RecepcionDAO getRecepcionLaboralDAO() { return recepcionLaboralDAO; }
	public void setRecepcionLaboralDAO(RecepcionDAO recepcionLaboralDAO) { this.recepcionLaboralDAO = recepcionLaboralDAO; }

	public RecepcionBeanImpl(){}
	
	public List<RecepcionLaboralBean> buscaRecepcionLaboral() throws SraajException{
		List<RecepcionLaboralBean> recepLaboral = null;
		recepLaboral = recepcionLaboralDAO.buscaRecepcionAmparosForaneos();
		return recepLaboral;
	}

	
}
