package mx.gob.se.sraaj.transferencia.bean;

import java.util.List;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.transferencia.beanImpl.CatGeneralBeanImpl;

public interface CatGeneralBean {
	 
	   public List<CatGeneralBeanImpl> obtieneJuicios()throws Exception;
	   

}
