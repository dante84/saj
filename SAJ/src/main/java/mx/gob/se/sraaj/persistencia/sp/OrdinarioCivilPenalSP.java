package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.OrdinarioCivilPenalMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class OrdinarioCivilPenalSP extends StoredProcedure{
	
	private static String sParam1 = "busqueda";
	private static String sParam2 = "idjuicio";
	private static String sParam3 = "idregistro";
	
	public OrdinarioCivilPenalSP (DataSource ds, String sNomSP){
		super (ds, sNomSP);
		declareParameter(new SqlInOutParameter(sParam1, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(sParam2, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(sParam3,  OracleTypes.INTEGER));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new OrdinarioCivilPenalMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(Integer idregistro, String busqueda, Integer idjuicio){
		System.out.println("========>> en OrdinarioCivilPenalSP ");
		System.out.println("========>> registro " +  idregistro);
		System.out.println("========>> busqueda " +  busqueda);
		System.out.println("========>> juicio " +  idjuicio);
		
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(sParam1, busqueda);
		inParams.put(sParam2, idjuicio);
		inParams.put(sParam3, idregistro);
		return super.execute(inParams);
	}
	

}
