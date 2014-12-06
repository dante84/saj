package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.CatMateriaMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class CatMateriaSP extends StoredProcedure{
	
	   public CatMateriaSP(DataSource ds, String sNomSP) {
		   
		      super (ds, sNomSP);
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new CatMateriaMapper()));
		      
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(){
		
		      System.out.println("Obtenemos las materias");
		
		      return super.execute(new HashMap<String, Object>());
		      
	   }
	
}
