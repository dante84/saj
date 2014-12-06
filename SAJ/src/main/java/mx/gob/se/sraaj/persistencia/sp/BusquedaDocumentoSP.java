package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.BusquedaMapper;
import mx.gob.se.sraaj.persistencia.mapper.DocumentoMapper;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class BusquedaDocumentoSP extends StoredProcedure{
	
	   private static String param1  = "iIdTipoJuicio";	   
	   private static String param2  = "sNumeroJuicio";
	   private static String param3  = "sAC_DE_PR_QU";	
	   private static String param4  = "sRemitente";
	   private static String param5  = "sNumeroOficio";
	   private static String param6  = "sFolio";	
	   private static String param7  = "iNumeroRegistroInicio";
	   private static String param8  = "iNumeroRegistroFin";
	   private static String param9  = "iNumeroExpediente";
	   private static String param10 = "sUsuario";	   
	   
	   public BusquedaDocumentoSP(DataSource ds,String nombreSP) {
			
			  super(ds, nombreSP);
			
			  declareParameter(new SqlParameter(param1,  OracleTypes.INTEGER));
			  declareParameter(new SqlParameter(param2,  OracleTypes.VARCHAR));
			  declareParameter(new SqlParameter(param3,  OracleTypes.VARCHAR));
			  declareParameter(new SqlParameter(param4,  OracleTypes.VARCHAR));
			  declareParameter(new SqlParameter(param5,  OracleTypes.VARCHAR));
			  declareParameter(new SqlParameter(param6,  OracleTypes.VARCHAR));
			  declareParameter(new SqlParameter(param7,  OracleTypes.INTEGER));
			  declareParameter(new SqlParameter(param8,  OracleTypes.INTEGER));
			  declareParameter(new SqlParameter(param9,  OracleTypes.INTEGER));
			  declareParameter(new SqlParameter(param10, OracleTypes.VARCHAR));
			  
			  declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new BusquedaMapper()));
			  declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
			      
			  compile();
			  
	   }
	   
	   public Map<String, Object> execute(DocumentoBean db) throws DataAccessException {			   
 	      
		      Map<String, Object> input = new HashMap<String,Object>();
		      		      		      
		      input.put(param1,  db.getiIdJuicio());
		      input.put(param2,  db.getsNumeroJuicio());
		      input.put(param3,  db.getsQuejoso());
		      input.put(param4,  db.getsRemitente());
		      input.put(param5,  db.getsNumeroOficio());
		      input.put(param6,  db.getsFolio());
		      input.put(param7,  db.getiNumeroRegistro());
		      input.put(param8,  db.getiNumeroRegistro());
		      input.put(param9,  db.getiNumeroExpediente());
		      input.put(param10, db.getsApePatUsuario());
			      
		      return super.execute(input);
			      		
	   }
	   	         	   	
}

