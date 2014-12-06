package mx.gob.se.sraaj.persistencia.sp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ActualizarAsuntosJuridicosSP extends StoredProcedure
{
	private String param1  = "Aidregdoc"; 
	private String param2 = "Aidmateria";
	private String param3 = "fechaConven";
	private String param4 = "fechaVencimiento";
	
	public ActualizarAsuntosJuridicosSP(DataSource ds, String sNomSP)
	{
		super(ds, sNomSP);
		
		  declareParameter(new SqlInOutParameter(param1 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param2 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param3 ,  OracleTypes.DATE));
	      declareParameter(new SqlInOutParameter(param4 ,  OracleTypes.DATE));	      
	      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
	      compile();
	}
	
	public Map<String, Object> execute(int idreg, Integer idmateria, Date fechaConv, Date fechaVenc)
	{
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put(param1,idreg);
		parametros.put(param2,idmateria);
		parametros.put(param3,fechaConv);
		parametros.put(param4,fechaVenc);
		return super.execute(parametros);
	}
}
