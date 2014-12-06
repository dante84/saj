package mx.gob.se.sraaj.persistencia.sp;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsertaDescargoPenalSP extends StoredProcedure
{
	   private String param1  = "Aidregdoc";
	   private String param2  = "AfecOficio";
	   private String param3  = "AnumReg";
	   private String param4  = "AsentidoOficio";
	   private String param5  = "Adestinatario";	   
	   private String param6  = "Aobservaciones";
	   private String param7  = "Aarchivo";
	   private String param8  = "Aopc";
	   private String param9  = "Acomentarios";
	   
	   public InsertaDescargoPenalSP(DataSource ds, String sNomSP) {
			 
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param2  ,  OracleTypes.DATE));
		      declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.VARCHAR));	
		      declareParameter(new SqlInOutParameter(param5  ,  OracleTypes.VARCHAR));		      		      
		      declareParameter(new SqlInOutParameter(param6  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param7  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param8  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param9  ,  OracleTypes.VARCHAR));
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		   
	   }
	   
	   public Map<String, Object> execute(int idregdoc, Date fecOficio, Integer numReg, String sentidoOficio,String destinatario, String observaciones, String archivo, int opc, String comentarios) {
		   
		      
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();		      
		      parametros.put(param1,idregdoc);
		      parametros.put(param2,fecOficio);
		      parametros.put(param3,numReg);
		      parametros.put(param4,sentidoOficio);
		      parametros.put(param5,destinatario);
		      parametros.put(param6,observaciones);
		      parametros.put(param7,archivo);
		      parametros.put(param8,opc);
		      parametros.put(param9,comentarios);
		      
		      return super.execute(parametros);
		      
	   }

}
