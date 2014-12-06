package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.DemandaInicialBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ActualizaDemandaSegOrdCivPen extends StoredProcedure {

	private String param0 = "pidfproc";
	private String param1 = "pidopc";
	private String param2 = "pfecha";
	private String param3 = "pTexto";
	
	 public ActualizaDemandaSegOrdCivPen(DataSource ds, String sNomSP) {
		 super(ds, sNomSP);
		 declareParameter(new SqlInOutParameter(param0 ,  OracleTypes.INTEGER));
		 declareParameter(new SqlInOutParameter(param1 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param2 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param3 ,  OracleTypes.VARCHAR));

	     	     	     
	     declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
	     compile();
	 }
	
	   public Map<String, Object> execute(Integer pidfproc, Integer pidopc, String pfecha, String pTexto) {		   		     
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();
		      
		      parametros.put(param0, pidfproc);
		      parametros.put(param1, pidopc);
		      parametros.put(param2, pfecha);
		      parametros.put(param3, pTexto);		      		      		     		     		  
		      
		      return super.execute(parametros);
		      
	   }
	
}
