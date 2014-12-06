package mx.gob.se.sraaj.persistencia.sp;

import java.sql.Date;
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

public class InsertarAveriguacionPreviaSP extends StoredProcedure{
	
	   private String param1  = "AfechaComparecencia";
	   private String param2  = "ApruebasComparecencia";
	   private String param3  = "AobservacionesComparecencia";
	   
	   private String param4  = "AfechaRequerimientos";
	   private String param5  = "AoficioRequerimientos";	   
	   private String param6  = "ArequerimientoRequerimientos";
	   private String param7  = "AdesahogoRequerimientos";
	   private String param8  = "AobservacionesRequerimientos";
	   
	   private String param9  = "AfechaDiligencias";
	   private String param10 = "AdiligenciaDiligencias";
	   private String param11 = "AobservacionesDiligencias";
	   
	   private String param12 = "AfechaDenuncia";
	   private String param13 = "AoficioDenuncia";
	   private String param14 = "AratificaDenuncia";
	   private String param15 = "AfecharatificaDenuncia";
	   
	   private String param16 = "AfechaMedios";
	   private String param17 = "AtestimonialesMedios";
	   private String param18 = "ApericialesMedios";
	   private String param19 = "AdocumentalesMedios";
	   private String param20 = "AinspeccionMedios";
	   private String param21 = "AotraMedios";
	   private String param22 = "AobservacionesMedios";
	   
	   private String param23 = "Aidregdoc";
	   private String param24 = "Aidcomparecencia";
	   private String param25 = "Aidrequerimientos";
	   private String param26 = "Aiddiligencia";
	   private String param27 = "Aiddenuncia";
	   private String param28 = "Aidmedios";
	   private String param29 = "Aopc";
	   
	   
	   
	   public InsertarAveriguacionPreviaSP(DataSource ds, String sNomSP) {
			 
		      super(ds, sNomSP);
		      
		      declareParameter(new SqlInOutParameter(param1  ,  OracleTypes.DATE));
		      declareParameter(new SqlInOutParameter(param2  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param3  ,  OracleTypes.VARCHAR));
		      
		      declareParameter(new SqlInOutParameter(param4  ,  OracleTypes.DATE));	
		      declareParameter(new SqlInOutParameter(param5  ,  OracleTypes.VARCHAR));		      		      
		      declareParameter(new SqlInOutParameter(param6  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param7  ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param8  ,  OracleTypes.VARCHAR));
		      
		      declareParameter(new SqlInOutParameter(param9  ,  OracleTypes.DATE));      		      
		      declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.VARCHAR));
		      
		      declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.DATE));
		      declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param15 ,  OracleTypes.DATE));
		      
		      declareParameter(new SqlInOutParameter(param16 ,  OracleTypes.DATE));
		      declareParameter(new SqlInOutParameter(param17 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param18 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param19 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param20 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param21 ,  OracleTypes.VARCHAR));
		      declareParameter(new SqlInOutParameter(param22 ,  OracleTypes.VARCHAR));
		      
		      declareParameter(new SqlInOutParameter(param23 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param24 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param25 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param26 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param27 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param28 ,  OracleTypes.INTEGER));
		      declareParameter(new SqlInOutParameter(param29 ,  OracleTypes.INTEGER));
		      
		      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
		      compile();
		   
	   }
	   
	   public Map<String, Object> execute(Date AfechaComparecencia
										,String ApruebasComparecencia
										,String AobservacionesComparecencia
										   
										,Date AfechaRequerimientos
	   									,String AoficioRequerimientos
	   									,String ArequerimientoRequerimientos
	   									,String AdesahogoRequerimientos
	   									,String AobservacionesRequerimientos
										   
	   									,Date AfechaDiligencias
	   									,String AdiligenciaDiligencias
	   									,String AobservacionesDiligencias
										   
	   									,Date AfechaDenuncia
	   									,String AoficioDenuncia
	   									,String AratificaDenuncia
	   									,Date AfecharatificaDenuncia
										   
	   									,Date AfechaMedios
										,String AtestimonialesMedios
										,String ApericialesMedios
										,String AdocumentalesMedios
										,String AinspeccionMedios
										,String AotraMedios
										,String AobservacionesMedios
										   
										,Integer Aidregdoc
										,Integer Aidcomparecencia
										,Integer Aidrequerimientos
										,Integer Aiddiligencia
										,Integer Aiddenuncia
										,Integer Aidmedios
										,Integer Aopc)
		{
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();		      
		      parametros.put(param1,AfechaComparecencia);
		      parametros.put(param2,ApruebasComparecencia);
		      parametros.put(param3,AobservacionesComparecencia);
		      
		      parametros.put(param4,AfechaRequerimientos);
		      parametros.put(param5,AoficioRequerimientos);
		      parametros.put(param6,ArequerimientoRequerimientos);
		      parametros.put(param7,AdesahogoRequerimientos);
		      parametros.put(param8,AobservacionesRequerimientos);
		      
		      parametros.put(param9,AfechaDiligencias);
		      parametros.put(param10,AdiligenciaDiligencias);
		      parametros.put(param11,AobservacionesDiligencias);
		      
		      parametros.put(param12,AfechaDenuncia);
		      parametros.put(param13,AoficioDenuncia);
		      parametros.put(param14,AratificaDenuncia);
		      parametros.put(param15,AfecharatificaDenuncia);
		      
		      parametros.put(param16,AfechaMedios);
		      parametros.put(param17,AtestimonialesMedios);
		      parametros.put(param18,ApericialesMedios);
		      parametros.put(param19,AdocumentalesMedios);
		      parametros.put(param20,AinspeccionMedios);
		      parametros.put(param21,AotraMedios);
		      parametros.put(param22,AobservacionesMedios);
		      
		      parametros.put(param23,Aidregdoc);
		      parametros.put(param24,Aidcomparecencia);
		      parametros.put(param25,Aidrequerimientos);
		      parametros.put(param26,Aiddiligencia);
		      parametros.put(param27,Aiddenuncia);
		      parametros.put(param28,Aidmedios);
		      parametros.put(param29,Aopc);
		      System.out.println("insertar comparecencia SP " + AfechaComparecencia);
		      return super.execute(parametros);
		      
	   }

}
