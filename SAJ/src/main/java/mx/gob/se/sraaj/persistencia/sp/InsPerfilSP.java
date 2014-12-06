package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsPerfilSP extends StoredProcedure{
	
	public InsPerfilSP (DataSource ds, String sNomSP){
		super(ds, sNomSP);
		declareParameter(new SqlParameter("pDescripcion", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pPermisos", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pUsuario", OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO,  OracleTypes.CURSOR, new ErrorBDMapper()));
	}
	
	public Map<String, Object> execute (String sDescripcion, String sPermisos, String sUsuario) throws DataAccessException{
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("pDescripcion", sDescripcion);
		input.put("pPermisos", sPermisos);
		input.put("pUsuario", sUsuario);
		return super.execute(input);
	}

}
