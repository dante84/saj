package mx.gob.se.sraaj.persistencia.sp;

import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.RecepcionLaboralMapper;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class RepRecepcionMinasSP extends StoredProcedure{
	
//	private static String sParam_sp ="pFecha";
	
	public RepRecepcionMinasSP(DataSource ds, String sNomSP){
		super(ds, sNomSP);
		
//		declareParameter(new SqlParameter(sParam_sp, OracleType.DATE));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new RecepcionLaboralMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(){
		System.out.println("========>> en repRecepcionAmparosMinasSP ");
		return super.execute();
	}	
}
