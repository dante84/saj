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

public class ModPerfilSP extends StoredProcedure {
	
	public ModPerfilSP(){
		super();
	}
	
	public ModPerfilSP(DataSource ds, String sNomSP){
		super(ds, sNomSP);
		declareParameter(new SqlParameter("pId", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pActivo", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pDescripcion", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pPermisos", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("pUsuario", OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,  OracleTypes.CURSOR, new ErrorBDMapper()));
	}
	
	public Map<String, Object> execute(String Id, String Activo, String Descripcion, String Permisos, String Usuario) throws DataAccessException {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("pId", Id);
		input.put("pActivo", Activo);
		input.put("pDescripcion", Descripcion);
		input.put("pPermisos", Permisos);
		input.put("pUsuario", Usuario);
		return super.execute(input);
	}

}
