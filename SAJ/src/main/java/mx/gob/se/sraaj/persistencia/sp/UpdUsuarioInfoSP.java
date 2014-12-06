package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class UpdUsuarioInfoSP extends StoredProcedure {
	
	private static String sParam1_sp = "pIdUsuario";
	private static String sParam2_sp = "pIdPuesto";
	private static String sParam3_sp = "pIdDepartamento";
	private static String sParam4_sp = "pIdUnidadAdministrativa";
	private static String sParam5_sp = "pEmail";
	private static String sParam6_sp = "pIdPerfil";
	private static String sParam7_sp = "pUsuarioHabilitado";
	private static String sParam8_sp = "pUsuario";
	
	
	public UpdUsuarioInfoSP(DataSource ds, String nombreSP) {
		super(ds, nombreSP);
		
		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam2_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam3_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam4_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam5_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam6_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam7_sp, OracleTypes.INTEGER));
		declareParameter(new SqlParameter(sParam8_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}

	
	public Map<String, Object> execute(UsuariosBeanImpl sUs) {
		
		Map<String, Object> input = new HashMap<String, Object>();
		input.put(sParam1_sp, sUs.getsUsuario());
		input.put(sParam2_sp, sUs.getiIdPuesto());
		input.put(sParam3_sp, sUs.getiIdDepartamento());
		input.put(sParam4_sp, sUs.getiIdunidadAdministrativa());
		input.put(sParam5_sp, sUs.getsCorreoElectronico());
		input.put(sParam6_sp, sUs.getiIdPerfil());
		input.put(sParam7_sp, sUs.getiUsuarioHabilitado());
		input.put(sParam8_sp, sUs.getsUsuario());
		return super.execute(input);
	}	

}
