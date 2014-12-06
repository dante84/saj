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

public class InsertarActualizarDesacargoSP extends StoredProcedure{
	
	private String param1 = "AidReg";
	private String param2 = "Aidcatdescargo";
	private String param3 = "Aexpediente";
	private String param4 = "AtieneRegistro";
	private String param5 = "AnumDocumento";	
	
	public InsertarActualizarDesacargoSP (DataSource ds, String sNomSP){
		super(ds, sNomSP);
		

		declareParameter(new SqlInOutParameter(param1,  OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param2,  OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param3,  OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param4,  OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param5,  OracleTypes.VARCHAR));
	    declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
	    compile();
	}
	
	public Map<String, Object> execute(int vIdRegDoc, int vDescargo, String vExpediente, int vTieneRegistro,  String vDocumento){
		System.out.println("========>> en insertaActualizaDescargoSP.execute");
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(param1,  vIdRegDoc);
		parametros.put(param2,  vDescargo);
		parametros.put(param3,  vExpediente);
		parametros.put(param4,  vTieneRegistro);
		parametros.put(param5,  vDocumento);
		
		System.out.println("========>> en Map");
		System.out.println(vIdRegDoc);
		System.out.println(vDescargo);
		System.out.println(vExpediente);
		System.out.println(vTieneRegistro);
		System.out.println(vDocumento);
		
		return super.execute(parametros);
		
	}
}
