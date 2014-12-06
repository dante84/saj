package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsertaAmparoFLMSP extends StoredProcedure{
	
	   private String param1  = "Ajucio_amparo";
	   private String param2  = "Aidautoridad";
	   private String param3  = "Aquejoso";
	   private String param4  = "Aacuerdo_citatorio";
	   private String param5  = "Asintesis";	   
	   private String param6  = "Afecha_oficio";
	   private String param7  = "Anumero_registro";
	   private String param8  = "AaveriguacionPcp";
	   private String param9  = "Afolio";
	   private String param10 = "Aexpediente_laboral";
	   private String param11 = "Afecha_notificacion";
	   private String param12 = "Acedula_notificacion";
	   private String param13 = "Anumero_oficio";
	   private String param14 = "iOficioJuicio";
	   
	   public InsertaAmparoFLMSP(DataSource ds, String sNomSP) {
			 
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param2  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.VARCHAR));	
		      declareParameter(new SqlInOutParameter(param5  ,  OracleTypes.INTEGER));		      		      
		      declareParameter(new SqlInOutParameter(param6  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param7  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param8  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param9  ,  OracleTypes.VARCHAR));      		      
		      declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.INTEGER));
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		   
	   }
	   
	   public Map<String, Object> execute(DocumentoBean documentoBean) {
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();
		      
		      parametros.put(param1 , documentoBean.getiIdJuicio());
		      parametros.put(param2 , documentoBean.getsNumeroOficio());
		      parametros.put(param3 , documentoBean.getsFechaOficio());
		      parametros.put(param4 , documentoBean.getsNumeroJuicio());
		      parametros.put(param5 , documentoBean.getiNumeroRegistro());
		      parametros.put(param6 , documentoBean.getsRemitente());
		      parametros.put(param7 , documentoBean.getiIncidenteSuspencion());
		      parametros.put(param8 , documentoBean.getsFechaNotificacion());
		      parametros.put(param9 , documentoBean.getsSint());
		      parametros.put(param10, documentoBean.getsFolio());
		      parametros.put(param11, documentoBean.getsOtrosJuzgados());
		      parametros.put(param12, documentoBean.getsFechaRecepcion());
		      parametros.put(param13, documentoBean.getsPromovente());
		      parametros.put(param14, documentoBean.getiOficioSinJuicio());
		      
		      return super.execute(parametros);
		      
	   }
	   
}
