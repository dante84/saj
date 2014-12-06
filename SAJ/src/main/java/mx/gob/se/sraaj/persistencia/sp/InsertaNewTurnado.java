package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.transferencia.beanImpl.TurnadoBeanImpl;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsertaNewTurnado extends StoredProcedure {
	
	private String param1 = "AidTurnardoc";
	private String param2 = "AidTurnado";
	private String param3 = "AidRegdoc";
	private String param4 = "Ains1";
	private String param5 = "Ains2";
	private String param6 = "Ains3";
	private String param7 = "Ains4";
	private String param8 = "Ains5";
	private String param9 = "Ains6";
	private String param10 = "Ains7";
	private String param11 = "Ains8";
	private String param12 = "Ains9";
	private String param13 = "Ains10";
	private String param14 = "Aespecifica";
	private String param15 = "Aacto";
	private String param16 = "Aacuse";
	
	 public InsertaNewTurnado(DataSource ds, String sNomSP) {
		 super(ds, sNomSP);
		 declareParameter(new SqlInOutParameter(param1 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param2 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param3 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param4 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param5 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param6 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param7 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param8 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param9 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param13,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param15 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param16 ,  OracleTypes.INTEGER));	     	     
	     declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
	     compile();
	 }
	
	   public Map<String, Object> execute(TurnadoBeanImpl turnadoBeanImpl) {		   		     
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();
		      Integer op=0;
		      parametros.put(param1,turnadoBeanImpl.getIidTurnardoc());
		      parametros.put(param2,turnadoBeanImpl.getIidTurnado());
		      parametros.put(param3,turnadoBeanImpl.getIidRegdoc());
		      
		      if(turnadoBeanImpl.getIinst1()) op=1;		    	  
		      parametros.put(param4,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst2()) op=1;
		      parametros.put(param5,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst3()) op=1;
		      parametros.put(param6,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst4()) op=1;
		      parametros.put(param7,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst5()) op=1;
		      parametros.put(param8,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst6()) op=1;
		      parametros.put(param9,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst7()) op=1;
		      parametros.put(param10,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst8()) op=1;
		      parametros.put(param11,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst9()) op=1;
		      parametros.put(param12,op); op=0;
		      
		      if(turnadoBeanImpl.getIinst10()) op=1;
		      parametros.put(param13,op); op=0;		   
		      
		      /*
		      parametros.put(param4,turnadoBeanImpl.getIinst1());
		      parametros.put(param5,turnadoBeanImpl.getIinst2());		      
		      parametros.put(param6,turnadoBeanImpl.getIinst3());
		      parametros.put(param7,turnadoBeanImpl.getIinst4());		      
		      parametros.put(param8,turnadoBeanImpl.getIinst5());
		      parametros.put(param9,turnadoBeanImpl.getIinst6());		      
		      parametros.put(param10,turnadoBeanImpl.getIinst7());
		      parametros.put(param11,turnadoBeanImpl.getIinst8());		      
		      parametros.put(param12,turnadoBeanImpl.getIinst9());
		      parametros.put(param13,turnadoBeanImpl.getIinst10());
		      */		      
		      parametros.put(param14,turnadoBeanImpl.getsEspecifique());
		      parametros.put(param15,turnadoBeanImpl.getsActoreclamado());
		      parametros.put(param16,turnadoBeanImpl.getsAcuserecibo());
		      
		      return super.execute(parametros);
		      
	   }

}
