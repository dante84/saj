package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.ResponsableMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class CatResponsableSP extends StoredProcedure {
	
	   private String param1 = "iIdJuicio";
	
  	   public CatResponsableSP(DataSource ds, String sNomSP) {
  		   
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1,  OracleTypes.INTEGER));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new ResponsableMapper()));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(int idTipoJuicio) {
		   
		      System.out.println("En responsableSP idTipoJuicio = " + idTipoJuicio );
		      Map<String, Object> parametros = new HashMap<String, Object>();
		      parametros.put(param1, idTipoJuicio);
		      System.out.println(param1 + " -- " + idTipoJuicio);
		      
		      return super.execute(parametros);
		      
	   }
	
}