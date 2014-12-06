package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.SeguimientoJuiciosMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SeguimientoJuiciosSP extends StoredProcedure{
	
	   private static String sParam1_sp = "busqueda";	
	   private static String sParam2_sp = "injuicio";
	
	   public SeguimientoJuiciosSP(DataSource ds, String sNomSP){
		   
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		      declareParameter(new SqlParameter(sParam2_sp, OracleTypes.INTEGER));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new SeguimientoJuiciosMapper()));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		      
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(String busqueda, Integer idjuicio){
		   
		      System.out.println("En seguimientoSP");
		      
		      Map<String, Object> inParams = new HashMap<String, Object>();
		      inParams.put(sParam1_sp, busqueda);
		      inParams.put(sParam2_sp, idjuicio);
		      
		      return super.execute(inParams);
		      
	   }
	   
}
