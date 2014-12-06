package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.HistorialDocumentoBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.BitacoraDAO;
import mx.gob.se.sraaj.persistencia.sp.HistorialDocumentoSP;
import mx.gob.se.sraaj.transferencia.beanImpl.BBitacoraBean;
import mx.gob.se.sraaj.transferencia.beanImpl.BitacoraBean;
import mx.gob.se.sraaj.transferencia.servicio.beanImpl.BitacoraServicioBeanImpl;

public class BitacoraDAOImpl implements BitacoraDAO {

	   
	private HistorialDocumentoSP historialDocumentoSP;

	   @SuppressWarnings("unchecked")
	public List<HistorialDocumentoBean> obtenerHistorialDoc(int id) throws SraajException
	   {
		   List<HistorialDocumentoBean> lHist = null;
		   
		   System.out.println(id + " dao");
		   Map<String, Object> mapCursor = historialDocumentoSP.execute(id);
			if(mapCursor != null){
				Object x = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if(x instanceof List<?>){
					lHist = (List<HistorialDocumentoBean>) x;
				}
			}
			return lHist;
	   }

	public HistorialDocumentoSP getHistorialDocumentoSP() {
		return historialDocumentoSP;
	}

	public void setHistorialDocumentoSP(HistorialDocumentoSP historialDocumentoSP) {
		this.historialDocumentoSP = historialDocumentoSP;
	}

	@Override
	public List<BitacoraServicioBeanImpl> buscarBitacora(
			BBitacoraBean bBitacoraDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertaABitacora(BitacoraBean bitacoraDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
