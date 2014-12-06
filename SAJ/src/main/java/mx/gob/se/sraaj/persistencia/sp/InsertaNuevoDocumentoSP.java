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

public class InsertaNuevoDocumentoSP extends StoredProcedure{
	
	   private String param1  = "Aidtipojuicio"; 
       private String param2  = "Anumoficio";          
       //private String param3  = "Afecoficio";          
       //private String param4  = "Afecrecep";
       private String param3  = "Anumexpediente";
       private String param4  = "Anumjuicio";            
       private String param5  = "Anumreg";
       private String param6  = "Apatharchivo";
       private String param7  = "Aidestado"; 
       private String param8 = "Aremitente";          
       private String param9 = "Aidusuario";          
       private String param10 = "Aincidentesuspension";
       //private String param13 = "Afecnot";
       private String param11 = "Asintesis";            
       private String param12 = "Aidjuzgado";
       private String param13 = "Aidorganojurisdiccional";
       private String param14 = "Ademandado"; 
       private String param15 = "Aidmp_juezdto";          
       private String param16 = "Aaveriguacionprevia_causapenal";          
       private String param17 = "Aidautoridadresponsable";
       private String param18 = "Apromovente";
       private String param19 = "Aidcatremitente";            
       private String param20 = "Aidtribunal";
       private String param21 = "Aidmateria";
       //private String param25 = "Afecvencimiento"; 
       //private String param26 = "Afecconvencional";          
       private String param22 = "Afolio";          
       private String param23 = "Atipoasunto";
       //private String param29 = "Aacuerdo_citatorio";
       private String param24 = "Anumerocontroversia";            
       private String param25 = "Aidcjn";
       private String param26 = "Aautoridadresponsable";
       private String param27 = "Aidresponsable"; 
       private String param28 = "Aidprocedencia";          
       private String param29 = "Aidsalafiscales";          
       private String param30 = "Ajuiciodeamparo";
       private String param31 = "Aquejoso";
       private String param32 = "Aexpedientelaboral";            
       private String param33 = "Acedulanotificacion";
       
	   public InsertaNuevoDocumentoSP(DataSource ds, String sNomSP) {
			 
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param2  ,  OracleTypes.VARCHAR));
		     // declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.VARCHAR));
		     // declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.VARCHAR));	
		      declareParameter(new SqlInOutParameter(param5  ,  OracleTypes.INTEGER));		      		      
		      declareParameter(new SqlInOutParameter(param6  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param7  ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param8 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param9 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.INTEGER));
		      //declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param15 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param16 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param17 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param18 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param19 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param20 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param21 ,  OracleTypes.INTEGER));
		      //declareParameter(new SqlInOutParameter(param25 ,  OracleTypes.VARCHAR));
		      //declareParameter(new SqlInOutParameter(param26 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param22 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param23 ,  OracleTypes.VARCHAR));
		      //declareParameter(new SqlInOutParameter(param29 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param24 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param25 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param26 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param27 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param28 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param29 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param30 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param31 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param32 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param33 ,  OracleTypes.VARCHAR));      		      
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		      
	   }
	   
	   public Map<String, Object> execute(DocumentoBean nuevoDocumentoBean) {		   		     
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();
		      
		      System.out.println(param1 + " " + nuevoDocumentoBean.getiIdJuicio());
		      System.out.println(param2 + " " + nuevoDocumentoBean.getsNumeroOficio());
		      //System.out.println(param3 + " " + nuevoDocumentoBean.getsFechaOficio());
		      //System.out.println(param4 + " " + nuevoDocumentoBean.getsFechaRecepcion());
		      System.out.println(param3 + " " + nuevoDocumentoBean.getiNumeroExpediente());		     		     		     
		      System.out.println(param4 + " " + nuevoDocumentoBean.getsNumeroJuicio());
		      System.out.println(param5 + " " + nuevoDocumentoBean.getiNumeroRegistro());
		      System.out.println(param6 + " " + nuevoDocumentoBean.getsPath());
		      System.out.println(param7 + " " + nuevoDocumentoBean.getiEstado());
		      System.out.println(param8 + " " + nuevoDocumentoBean.getsRemitente());
		      System.out.println(param9 + " " + nuevoDocumentoBean.getiIdUser());
		      System.out.println(param10 + " " + nuevoDocumentoBean.getiIncidenteSuspencion());
		      //System.out.println(param13 + " " + nuevoDocumentoBean.getsFechaNotificacion());		     		     		     
		      System.out.println(param11 + " " + nuevoDocumentoBean.getsSint());
		      System.out.println(param12 + " " + nuevoDocumentoBean.getiIdJuzgado());
		      System.out.println(param13 + " " + nuevoDocumentoBean.getiOrganoJurisdiccional());
		      System.out.println(param14 + " " + nuevoDocumentoBean.getsDemandado());
		      System.out.println(param15 + " " + nuevoDocumentoBean.getiJuezDto());
		      System.out.println(param16 + " " + nuevoDocumentoBean.getsAveriguacionPrevia());
		      System.out.println(param17 + " " + nuevoDocumentoBean.getiIdAutoridadResponsable());
		      System.out.println(param18 + " " + nuevoDocumentoBean.getsPromovente());		     		     		     
		      System.out.println(param19 + " " + nuevoDocumentoBean.getiIdCatRemitente());
		      System.out.println(param20 + " " + nuevoDocumentoBean.getiIdTribunal());
		      System.out.println(param21 + " " + nuevoDocumentoBean.getiIdMateria());
		      //System.out.println(param25 + " " + nuevoDocumentoBean.getsFechaVencimiento());
		      //System.out.println(param26 + " " + nuevoDocumentoBean.getsFechaConvencional());
		      System.out.println(param22 + " " + nuevoDocumentoBean.getsFolio());
		      System.out.println(param23 + " " + nuevoDocumentoBean.getsTipoAsunto());
		      System.out.println(param24 + " " + nuevoDocumentoBean.getsSint());		     		     		     
		      //System.out.println(param30 + " " + nuevoDocumentoBean.getsAcuerdoCitatorio());
		      System.out.println(param25 + " " + nuevoDocumentoBean.getiNumeroControversia());
		      System.out.println(param26 + " " + nuevoDocumentoBean.getiIdCJN());
		      System.out.println(param27 + " " + nuevoDocumentoBean.getsDescAutridadResponsable());
		      System.out.println(param28 + " " + nuevoDocumentoBean.getiIdAutoridadResponsable());
		      System.out.println(param29 + " " + nuevoDocumentoBean.getiAutoridadResponsable());
		      System.out.println(param30 + " " + nuevoDocumentoBean.getiIdProcedencia());
		      System.out.println(param31 + " " + nuevoDocumentoBean.getiIdSalasFiscales());		     		     		     
		      System.out.println(param32 + " " + nuevoDocumentoBean.getsJuicioDeAmparo());
		      System.out.println(param33 + " " + nuevoDocumentoBean.getsQuejoso());

		      
		      parametros.put(param1,nuevoDocumentoBean.getiIdJuicio());
		      parametros.put(param2,nuevoDocumentoBean.getsNumeroOficio());
		      //parametros.put(param3,nuevoDocumentoBean.getsFechaOficio());
		      //parametros.put(param4,nuevoDocumentoBean.getsFechaRecepcion());
		      parametros.put(param3,nuevoDocumentoBean.getiNumeroExpediente());		     		     		     
		      parametros.put(param4,nuevoDocumentoBean.getsNumeroJuicio());
		      parametros.put(param5,nuevoDocumentoBean.getiNumeroRegistro());
		      parametros.put(param6,nuevoDocumentoBean.getsPath());
		      parametros.put(param7,nuevoDocumentoBean.getiEstado());
		      parametros.put(param8,nuevoDocumentoBean.getsRemitente());
		      parametros.put(param9,nuevoDocumentoBean.getiIdUser()); 
		      parametros.put(param10,nuevoDocumentoBean.getiIncidenteSuspencion());
		      //parametros.put(param13,nuevoDocumentoBean.getsFechaNotificacion());		     		     		     
		      parametros.put(param11,nuevoDocumentoBean.getsSint());
		      parametros.put(param12,nuevoDocumentoBean.getiIdJuzgado());
		      parametros.put(param13,nuevoDocumentoBean.getiOrganoJurisdiccional());
		      parametros.put(param14,nuevoDocumentoBean.getsDemandado());
		      parametros.put(param15,nuevoDocumentoBean.getiJuezDto());
		      parametros.put(param16,nuevoDocumentoBean.getsAveriguacionPrevia());
		      parametros.put(param17,nuevoDocumentoBean.getiIdAutoridadResponsable());
		      parametros.put(param18,nuevoDocumentoBean.getsPromovente());		     		     		     
		      parametros.put(param19,nuevoDocumentoBean.getiIdCatRemitente());
		      parametros.put(param20,nuevoDocumentoBean.getiIdTribunal());
		      parametros.put(param21,nuevoDocumentoBean.getiIdMateria());
		      //parametros.put(param25,nuevoDocumentoBean.getsFechaVencimiento());
		      //parametros.put(param26,nuevoDocumentoBean.getsFechaConvencional());
		      parametros.put(param22,nuevoDocumentoBean.getsFolio());
		      parametros.put(param23,nuevoDocumentoBean.getsTipoAsunto());
		      parametros.put(param24,nuevoDocumentoBean.getsSint());		     		     		     
		      //parametros.put(param30,nuevoDocumentoBean.getsAcuerdoCitatorio());
		      parametros.put(param25,nuevoDocumentoBean.getiNumeroControversia());
		      parametros.put(param26,nuevoDocumentoBean.getiIdCJN());
		      parametros.put(param27,nuevoDocumentoBean.getsDescAutridadResponsable());
		      parametros.put(param28,nuevoDocumentoBean.getiIdAutoridadResponsable());
		      parametros.put(param29,nuevoDocumentoBean.getiAutoridadResponsable());
		      parametros.put(param30,nuevoDocumentoBean.getiIdProcedencia());
		      parametros.put(param31,nuevoDocumentoBean.getiIdSalasFiscales());		     		     		     
		      parametros.put(param32,nuevoDocumentoBean.getsJuicioDeAmparo());
		      parametros.put(param33,nuevoDocumentoBean.getsQuejoso());
		      		      		     
		      return super.execute(parametros);
		      
	   }

}
