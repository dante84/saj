package mx.gob.se.sraaj.persistencia.sp;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.DocumentosRelMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.SeguimientoMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class DocumentosRelSP extends StoredProcedure
{
private static String sParam1_sp = "noJuicio";
	
	public DocumentosRelSP(DataSource ds, String sNomSP)
	{
		super(ds, sNomSP);
		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new DocumentosRelMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(String noJuicio){
		System.out.println("Documentos SP");
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(sParam1_sp, noJuicio);
		return super.execute(inParams);
	}
}
