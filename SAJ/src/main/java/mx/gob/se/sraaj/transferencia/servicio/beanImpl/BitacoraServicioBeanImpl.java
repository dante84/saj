package mx.gob.se.sraaj.transferencia.servicio.beanImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.daoImpl.BitacoraDAOImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.BBitacoraBean;
import mx.gob.se.sraaj.transferencia.beanImpl.BitacoraBean;
import mx.gob.se.sraaj.transferencia.servicio.bean.BitacoraServicioBean;

public class BitacoraServicioBeanImpl implements BitacoraServicioBean {
	
	   private BitacoraDAOImpl bitacoraDAO;

	   public void setBitacoraDAO(BitacoraDAOImpl bitacoraDAO) { this.bitacoraDAO = bitacoraDAO; }

	   
	   public List<BitacoraBean> buscaBit(BBitacoraBean bBitacoraDTO) throws Exception {
		    
		      

		      return null;
		      
	   }

	   
	   public String insABitacora(BitacoraBean bitacoraBean) throws Exception {
		    
			  Map<String, Object> mapR = bitacoraDAO.insertaABitacora(bitacoraBean);
			  Object error = mapR.get(Constantes.OUT_SP_ERROR);
			  List<ErrorBDBean> listError = (List<ErrorBDBean>) error;
			  String sPath = "";
			  
			  return sPath;
		      
	   }

}
