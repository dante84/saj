package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ComparecenciaIndiciadoMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.RequerimientosMPMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class RequerimientosMPSP extends StoredProcedure
{
	private static String sParam1_sp = "Aidregdoc";
	
	public RequerimientosMPSP(DataSource ds, String sNomSP)
	{
		super(ds, sNomSP);
		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.INTEGER));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new RequerimientosMPMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(Integer Aidregdoc){
		System.out.println("RequerimientosMPSP SP");
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(sParam1_sp, Aidregdoc);
		return super.execute(inParams);
	}
}
