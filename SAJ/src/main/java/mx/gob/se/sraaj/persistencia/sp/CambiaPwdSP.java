package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class CambiaPwdSP extends StoredProcedure {
		
	private static String sParam1_sp = "pUsuario";
	
	private static String sParam2_sp = "pOldPassword";
	
	private static String sParam3_sp = "pPassword";
	
	public CambiaPwdSP(DataSource ds, String sNomSP) {
		
		super(ds, sNomSP);
		System.out.println("sp entra");
		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam2_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam3_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute(String sUs, String sOldPwd, String sNewPwd) {
		System.out.println("entro a execute Sp");
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(sParam1_sp, sUs);
		inParams.put(sParam2_sp, sOldPwd);
		inParams.put(sParam3_sp, sNewPwd);
		
		return super.execute(inParams);
	}
	
	

}
