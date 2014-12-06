package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.AsuntosJuridicosRepSegMapper;
import mx.gob.se.sraaj.persistencia.mapper.CatGeneralUpdateMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;


public class AsuntosJuridicosRepSegSP extends StoredProcedure  {

	//private static String sParam1_sp = "fechaIni";	
	//private static String sParam2_sp = "fechaFin";
	
	public AsuntosJuridicosRepSegSP(DataSource ds,String nombreSP)
	{
		super(ds, nombreSP);				  
		  declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new AsuntosJuridicosRepSegMapper()));		  
		  compile();
	}	
	
	public Map<String, Object> execute(){
		return super.execute(new HashMap<String, Object>());
	}
}
