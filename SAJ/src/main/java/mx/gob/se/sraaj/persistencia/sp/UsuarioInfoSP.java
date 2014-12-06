package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.AccesoUsuarioMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class UsuarioInfoSP extends StoredProcedure {
		
	   private static String sParam1_sp = "pUsuario";
		
	   public UsuarioInfoSP(DataSource ds, String nombreSP) {
		
		      super(ds, nombreSP);
		
		      declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new AccesoUsuarioMapper()));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		      
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(String sUs) {
		    	
		      Map<String, Object> input = new HashMap<String, Object>();
		      input.put(sParam1_sp, sUs);
		   
		      return super.execute(input);
		   
	   }
	   
}
