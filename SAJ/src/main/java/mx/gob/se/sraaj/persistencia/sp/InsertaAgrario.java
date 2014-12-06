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

public class InsertaAgrario extends StoredProcedure{
	
	   private String param1  = "idJuicio";
	   private String param2  = "iIdTribunal";
	   private String param3  = "sRemitente";
	   private String param4  = "sActor";
	   private String param5  = "iIdEstado";	   
	   private String param6  = "sSintesis";
	   private String param7  = "sNumeroOficio";
	   private String param8  = "sFechaOficio";
	   private String param9  = "iNumeroRegistro";
	   private String param10 = "sHoraRecepcion";
	   private String param11 = "sOtrosJuzgados";
	   private String param12 = "sNumeroJuicio";
	   private String param13 = "sFolio";
	   private String param14 = "iOficioJuicio";
	   
	   public InsertaAgrario(DataSource ds, String sNomSP) {
			 
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param2  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.VARCHAR));	
		      declareParameter(new SqlInOutParameter(param5  ,  OracleTypes.INTEGER));		      		      
		      declareParameter(new SqlInOutParameter(param6  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param7  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param8  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param9  ,  OracleTypes.INTEGER));      		      
		      declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.INTEGER));
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		   
	   }
	   
	   public Map<String, Object> execute(DocumentoBean documentoBean) {
		   
		      System.out.println(documentoBean.getsNumeroJuicio());
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();		      
		      parametros.put(param1,documentoBean.getiIdJuicio());
		      parametros.put(param2,documentoBean.getiIdTribunal());
		      parametros.put(param3,documentoBean.getsRemitente());
		      parametros.put(param4,documentoBean.getsAct());
		      parametros.put(param5,documentoBean.getiEstado());
		      parametros.put(param6,documentoBean.getsSint());
		      parametros.put(param7,documentoBean.getsNumeroOficio());
		      parametros.put(param8,documentoBean.getsFechaOficio());
		      parametros.put(param9,documentoBean.getiNumeroRegistro());
		      parametros.put(param10,documentoBean.getsFechaRecepcion());
		      parametros.put(param11,documentoBean.getsOtrosJuzgados());
		      parametros.put(param12,documentoBean.getsNumeroJuicio());
		      parametros.put(param13, documentoBean.getsFolio());
		      parametros.put(param14, documentoBean.getiOficioSinJuicio());
		      
		      return super.execute(parametros);
		      
	   }

}
