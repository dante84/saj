package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.DescargoConsultaMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ReporteDocumentoDescargoSP extends StoredProcedure{
	
	   private String param1 = "pBusqueda";
	
	   public ReporteDocumentoDescargoSP (DataSource ds, String sNomSP){
		   
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1,  OracleTypes.VARCHAR));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO,  OracleTypes.CURSOR, new DescargoConsultaMapper()));
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,      OracleTypes.CURSOR, new ErrorBDMapper()));
		      
		      compile();
		      
	   }
	
	   public Map<String, Object> execute(String busqueda) throws DataAccessException{
		   
		      Map<String, Object> parametros = new HashMap<String, Object>();
		      parametros.put(param1, busqueda);
		      
		      return super.execute(parametros);
		      
	   }

}
