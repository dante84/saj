package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.persistencia.mapper.PermisosPerfilMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class PermisosPerfilSP extends StoredProcedure{
	
	public PermisosPerfilSP(DataSource ds, String sNomSP){
		super (ds,sNomSP);
		declareParameter(new SqlParameter("idPerfil", OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter("pDatos", OracleTypes.CURSOR, new PermisosPerfilMapper()));
		compile();
	}
	
	public Map<String, Object> execute (String idP) throws DataAccessException{
		System.out.println("=====>> en PermisosPerfilSP");		
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("idPerfil", idP);
		return super.execute(input);
	}

}
