package mx.gob.se.sraaj.servicio.bean;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.transferencia.beanImpl.CatBeanImpl;

public interface CatGeneralBean {
	
	public CatBeanImpl obtieneJuicios() throws SraajException;
	public CatBeanImpl obtienePuesto() throws SraajException;
	public CatBeanImpl obtieneDepartamentoSP() throws SraajException;	
	public CatBeanImpl obtieneCatalogos() throws SraajException;
	public CatBeanImpl obtieneReporteCatalogo(String sSelected) throws SraajException;
	public CatBeanImpl obtieneDescargo() throws SraajException;
	public CatBeanImpl obtieneEstados() throws SraajException;
	public CatBeanImpl obtieneCircuito() throws SraajException;

}
