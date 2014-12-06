package mx.gob.se.sraaj.persistencia.sp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ActualizaEstudioPGRSP extends StoredProcedure{
	private String sParam1 = "pIdf_procesal";
	private String sParam2 = "pIdRegDoc";
	private String sParam3 = "pOficio";
	private String sParam4 = "pFecha";
	private String sParam5 = "pRequerimientoPGR";
	private String sParam6 = "pIdCatFProcesal";
	
	public ActualizaEstudioPGRSP (DataSource ds, String sNomSP){
		super (ds, sNomSP);
		
		declareParameter(new SqlInOutParameter(sParam1, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(sParam2, OracleTypes.INTEGER));
		declareParameter(new SqlInOutParameter(sParam3, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(sParam4, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(sParam5, OracleTypes.VARCHAR));
		declareParameter(new SqlInOutParameter(sParam6, OracleTypes.INTEGER));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}
	
	public Map<String, Object> execute (int idprocesal, int idregistro, String folio, Date fecha, String requerimiento, int idcatprocesal ){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(sParam1, idprocesal);
		parametros.put(sParam2, idregistro);
		parametros.put(sParam3, folio);
		parametros.put(sParam4, fecha);
		parametros.put(sParam5, requerimiento);
		parametros.put(sParam6, idcatprocesal);
		return super.execute(parametros);
	}

}
