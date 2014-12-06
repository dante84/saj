package mx.gob.se.sraaj.transferencia.servicio.bean;

import java.util.List;

import mx.gob.se.sraaj.transferencia.beanImpl.BBitacoraBean;
import mx.gob.se.sraaj.transferencia.beanImpl.BitacoraBean;

public interface BitacoraServicioBean {
	 
 	   public List < BitacoraBean > buscaBit(BBitacoraBean bBitacoraDTO) throws Exception;
	   public String insABitacora(BitacoraBean bitacoraBean) throws Exception;
	   

}
