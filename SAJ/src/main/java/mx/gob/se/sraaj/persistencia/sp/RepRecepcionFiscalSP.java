package mx.gob.se.sraaj.persistencia.sp;

import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.RecepcionFiscalMapper;
import mx.gob.se.sraaj.transferencia.bean.RecepcionFiscalBean;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class RepRecepcionFiscalSP extends StoredProcedure {
	
//	private static String sParam1_sp = "pFecha";
	
	public RepRecepcionFiscalSP (DataSource ds, String sNomSP){
		super(ds, sNomSP);
//		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.DATE));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new RecepcionFiscalMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(RecepcionFiscalBean recepcionFiscalBean) throws DataAccessException{
		return super.execute();
	}

}
