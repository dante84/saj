package mx.gob.se.sraaj.persistencia.sp;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.PenalTblMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsertaSegPenalSP extends StoredProcedure
{
	private static String sParam1_sp = "Aidregdoc";
	private static String sParam2_sp = "AnumExpPenal";
	private static String sParam3_sp = "Adelito";
	private static String sParam4_sp = "Adenuncia";
	private static String sParam5_sp = "Aimporte";
	private static String sParam6_sp = "AflujoProcesal";
	 
	
	public InsertaSegPenalSP(DataSource ds, String sNomSP)
	{
		super(ds, sNomSP);
		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam2_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam3_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam4_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam5_sp, OracleTypes.NUMBER));
		declareParameter(new SqlParameter(sParam6_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	 
	public Map<String, Object> execute(Integer Aidregdoc, String AnumExpPenal, String Adelito, String Adenuncia, Double Aimporte, String AflujoProcesal){
		System.out.println("Actualiza segPenal" + Aimporte);
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(sParam1_sp, Aidregdoc);
		inParams.put(sParam2_sp, AnumExpPenal);
		inParams.put(sParam3_sp, Adelito);
		inParams.put(sParam4_sp, Adenuncia);
		inParams.put(sParam5_sp, Aimporte);
		inParams.put(sParam6_sp, AflujoProcesal);
		return super.execute(inParams);
	}
}
