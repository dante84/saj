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

public class InsertaNuevoDocumentoMFSP extends StoredProcedure {

	private String param1 = "Juicio";
	private String param2 = "numeroJuicio";
	private String param3 = "Juzgado";
	private String param4 = "remit";
	private String param5 = "act";
	private String param6 = "estado";
	private String param7 = "sint";
	private String param8 = "numeroOficio";
	private String param9 = "fechaOficio";
	private String param10 = "numeroRegistro";
	private String param11 = "responsable";
	private String param12 = "fechaRecepcion";
	private String param13 = "folio";
	private String param14 = "sOtrosJuzgados";
	private String param15 = "sOtrosOrganos"; 
	private String param16 = "iOficioJuicio";
	
	public InsertaNuevoDocumentoMFSP(DataSource ds, String sNomSP) {

		super(ds, sNomSP);

		declareParameter(new SqlInOutParameter(param1, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param2, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param3, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param4, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param5, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param6, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param7, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param8, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param9, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param10, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param11, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(param12, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param13, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param14,  OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param15,  OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(param16 , OracleTypes.INTEGER));
		
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,
				OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}

	public Map<String, Object> execute(DocumentoBean nuevoDocumentoBean) {

		   System.out.println("========>> en insertanuevodocumentomfSP.execute");
		   Map<String, Object> parametros = new HashMap<String, Object>();

		   
	       parametros.put(param1,nuevoDocumentoBean.getiIdJuicio());
	       parametros.put(param2,nuevoDocumentoBean.getsNumeroJuicio());
	       parametros.put(param3,nuevoDocumentoBean.getiIdJuzgado());
	       parametros.put(param4,nuevoDocumentoBean.getsRemitente());
	       parametros.put(param5,nuevoDocumentoBean.getsAct());
	       parametros.put(param6,nuevoDocumentoBean.getiEstado());
	       parametros.put(param7,nuevoDocumentoBean.getsSint());
	       parametros.put(param8,nuevoDocumentoBean.getsNumeroOficio());
	       parametros.put(param9,nuevoDocumentoBean.getsFechaOficio());
	       parametros.put(param10, nuevoDocumentoBean.getiNumeroRegistro());
	       parametros.put(param11, nuevoDocumentoBean.getiIdResponsable());
	       parametros.put(param12, nuevoDocumentoBean.getsFechaRecepcion());
	       parametros.put(param13, nuevoDocumentoBean.getsFolio());
	       parametros.put(param14, nuevoDocumentoBean.getsOtrosJuzgados());
	       parametros.put(param15, nuevoDocumentoBean.getsOtrosOrganosJurisdiccionales());
	       parametros.put(param16, nuevoDocumentoBean.getiOficioSinJuicio());

		   return super.execute(parametros);
		
	}
	
}
