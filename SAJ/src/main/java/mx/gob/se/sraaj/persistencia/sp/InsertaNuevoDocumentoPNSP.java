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

public class InsertaNuevoDocumentoPNSP extends StoredProcedure {
	
	private String param1 = "Juicio";
	private String param2 = "numeroOficio";
	private String param3 = "fechaOficio";	
	private String param4 = "remit";
	private String param5 = "sint";
	private String param6 = "numeroExpediente";
	private String param7 = "juezDTO";
	private String param8 = "averiguacionPrevia";
	private String param9 = "numeroRegistro";
	private String param10= "responsable";
	private String param11= "folio";
	private String param12= "sOtrosRemitente";
	private String param13= "sOtrosJuezDTO";	

	public InsertaNuevoDocumentoPNSP(DataSource ds, String sNomSP) {

		super(ds, sNomSP);

		declareParameter(new SqlInOutParameter(param1, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param2, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param3, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param4, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param5, OracleTypes.VARCHAR));	
		declareParameter(new SqlInOutParameter(param6, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param7, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param8, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param9, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param10,  OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param11,  OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param12, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param13, OracleTypes.VARCHAR));

		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,
				OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}

	public Map<String, Object> execute(DocumentoBean nuevoDocumentoBean) {

		   System.out.println("========>> en insertanuevodocumentoPNSP.execute");
		   Map<String, Object> parametros = new HashMap<String, Object>();

	       parametros.put(param1,nuevoDocumentoBean.getiIdJuicio());
	       parametros.put(param2,nuevoDocumentoBean.getsNumeroOficio());
	       parametros.put(param3,nuevoDocumentoBean.getsFechaOficio());	     
	       parametros.put(param4,nuevoDocumentoBean.getiIdCatRemitente());
	       parametros.put(param5,nuevoDocumentoBean.getsSint());
	       parametros.put(param6,nuevoDocumentoBean.getiNumeroExpediente());
	       parametros.put(param7, nuevoDocumentoBean.getiJuezDto());
	       parametros.put(param8,nuevoDocumentoBean.getsAveriguacionPrevia());
	       parametros.put(param9, nuevoDocumentoBean.getiNumeroRegistro());
	       parametros.put(param10, nuevoDocumentoBean.getiIdResponsable());
	       parametros.put(param11, nuevoDocumentoBean.getsFolio());
	       parametros.put(param12, nuevoDocumentoBean.getsOtrosRemitente());
	       parametros.put(param13, nuevoDocumentoBean.getsOtrosJuezDTO());

		   return super.execute(parametros);
		
	}

}
