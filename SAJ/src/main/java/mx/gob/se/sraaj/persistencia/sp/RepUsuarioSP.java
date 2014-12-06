package mx.gob.se.sraaj.persistencia.sp;

import javax.sql.DataSource;

import java.util.Map;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.core.SqlOutParameter;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.UsuarioMapper;

public class RepUsuarioSP extends StoredProcedure  {
	
	   private static String sParam1_sp = "pUsuario";
	
	   public RepUsuarioSP(DataSource ds, String nombreSP) {
		   
		      super(ds, nombreSP);
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new UsuarioMapper()));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(String sUs) {
		   
		      System.out.println("En el execute de RepUsuarioSP");
		   
		      return super.execute();
		      
	   }  	

}
