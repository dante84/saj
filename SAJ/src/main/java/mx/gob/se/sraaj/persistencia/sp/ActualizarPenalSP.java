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

public class ActualizarPenalSP extends StoredProcedure
{
	private String param1  = "Aidregdoc"; 
	private String param2 = "AidCatPenal";
	private String param3 = "Aidcatdescargo";
	private String param4 = "Aindiciado";
	private String param5 = "Ainstruccion1";
	private String param6 = "Ainstruccion2";
	private String param7 = "Ainstruccion3";
	private String param8 = "Ainstruccion4";
	private String param9 = "Ainstruccion5";
	private String param10 = "Ainstruccion6";
	private String param11 = "Ainstruccion7";
	private String param12 = "Ainstruccion8";
	private String param13  = "AidTurnar"; 
	private String param14 = "AfechaTermino";
	private String param15 = "Aestatus";
	
	
	public ActualizarPenalSP(DataSource ds, String sNomSP)
	{
		super(ds, sNomSP);
		
		  declareParameter(new SqlInOutParameter(param1 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param2 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param3 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param4 ,  OracleTypes.VARCHAR));
	      declareParameter(new SqlInOutParameter(param5 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param6 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param7 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param8 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param9 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param13 ,  OracleTypes.INTEGER));
	      declareParameter(new SqlInOutParameter(param14 ,  OracleTypes.DATE));
	      declareParameter(new SqlInOutParameter(param15 ,  OracleTypes.VARCHAR));
	      declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
	      compile();
	}
	
	public Map<String, Object> execute(int idreg
										, Integer idCatPenal
										, Integer idcatdescargo
										, String Aindiciado
										, Integer instruccion1
										, Integer instruccion2
										, Integer instruccion3
										, Integer instruccion4
										, Integer instruccion5
										, Integer instruccion6
										, Integer instruccion7
										, Integer instruccion8
										, Integer idTurnar
										, Date fechaTermino
										, String estatus
										)
	{
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put(param1,idreg);
		parametros.put(param2,idCatPenal);
		parametros.put(param3,idcatdescargo);
		parametros.put(param4,Aindiciado);
		parametros.put(param5,instruccion1);
		parametros.put(param6,instruccion2);
		parametros.put(param7,instruccion3);
		parametros.put(param8,instruccion4);
		parametros.put(param9,instruccion5);
		parametros.put(param10,instruccion6);
		parametros.put(param11,instruccion7);
		parametros.put(param12,instruccion8);
		parametros.put(param13,idTurnar);
		parametros.put(param14,fechaTermino);
		parametros.put(param15,estatus);
		System.out.println(idreg+","+idCatPenal+","+idcatdescargo+","+Aindiciado+","+instruccion1+","+instruccion2+","+instruccion3+","+instruccion4+","+instruccion5+","+instruccion6+","+instruccion7+","+instruccion8+","+idTurnar+","+fechaTermino+","+estatus);
		return super.execute(parametros);
	}
}
