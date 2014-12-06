package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.AccesoMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class BitacoraSP extends StoredProcedure
{
	private static String sParam1_sp = "fechaIni";	
	private static String sParam2_sp = "fechaFin";
	
	public BitacoraSP(DataSource ds,String nombreSP)
	{
		super(ds, nombreSP);
		
		  declareParameter(new SqlParameter(sParam1_sp, OracleTypes.VARCHAR));
		  declareParameter(new SqlParameter(sParam2_sp, OracleTypes.VARCHAR));
		  declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new AccesoMapper()));
		  declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      
		  compile();
	}
	
	public Map<String, Object> execute(String fechaIni, String fechaFin) throws DataAccessException 
	{			   
	      
	      Map<String, Object> input = new HashMap<String, Object>();
	      		      
	      input.put(sParam1_sp, fechaIni);
	      input.put(sParam2_sp, fechaFin);
		      
	      return super.execute(input);
		      		
	   }
}

