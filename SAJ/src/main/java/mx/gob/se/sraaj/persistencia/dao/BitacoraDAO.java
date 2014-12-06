package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.transferencia.beanImpl.BBitacoraBean;
import mx.gob.se.sraaj.transferencia.beanImpl.BitacoraBean;
import mx.gob.se.sraaj.transferencia.servicio.beanImpl.BitacoraServicioBeanImpl;

public interface BitacoraDAO {
	 
	   public List<BitacoraServicioBeanImpl> buscarBitacora(BBitacoraBean bBitacoraDTO)throws Exception;
	   public Map<String,Object> insertaABitacora(BitacoraBean bitacoraDTO) throws Exception;	

}
