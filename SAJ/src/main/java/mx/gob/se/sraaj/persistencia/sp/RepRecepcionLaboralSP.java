package mx.gob.se.sraaj.persistencia.sp;

import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.RecepcionLaboralMapper;
import mx.gob.se.sraaj.transferencia.bean.RecepcionLaboralBean;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

//	private static String sParam1_sp = "pFecha"; 
public class RepRecepcionLaboralSP extends StoredProcedure {
	
	public RepRecepcionLaboralSP(DataSource ds, String sNomSP){
		super(ds, sNomSP);
//		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.DATE));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new RecepcionLaboralMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(RecepcionLaboralBean recepcionLaboralBean) throws SraajException {
		return super.execute();
	}
	
}
