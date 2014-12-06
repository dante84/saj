package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.ConsultaExpedienteBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import mx.gob.se.sraaj.persistencia.mapper.ExpedienteConsultaMapper;
import oracle.jdbc.OracleTypes;







import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ConsultaExpedienteGeneralSP extends StoredProcedure
{
	

	private static String sParam1_sp = "pNumeroExpediente";
	private static String sParam2_sp = "pIdTipoJuicio";
	private static String sParam3_sp = "pActor";
	private static String sParam4_sp = "pRemitente";
	private static String sParam5_sp = "pNumeroOficio";
	private static String sParam6_sp = "pFolio";
	private static String sParam7_sp = "pNumeroRegistroInicio";
	private static String sParam8_sp = "pNumeroRegistroFin";
	private static String sParam9_sp = "pNumeroJuicio";
	private static String sParam10_sp = "pUsuario";
	private static String sParam11_sp = "pFechaInicio";
	private static String sParam12_sp = "pFechaFin";
	private static String sParam13_sp = "pStatusJuicio";

	public ConsultaExpedienteGeneralSP(DataSource ds, String nombreSP) {
		super(ds, nombreSP);
		logger.info(Constantes.MSG_LOG_CONSTRUCTOR + "ConsultaExpedienteSP");

		declareParameter(new SqlParameter(sParam1_sp, OracleTypes.NUMBER));
		declareParameter(new SqlParameter(sParam2_sp, OracleTypes.NUMBER));
		declareParameter(new SqlParameter(sParam3_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam4_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam5_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam6_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam7_sp, OracleTypes.NUMBER));
		declareParameter(new SqlParameter(sParam8_sp, OracleTypes.NUMBER));
		declareParameter(new SqlParameter(sParam9_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam10_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam11_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam12_sp, OracleTypes.VARCHAR));
		declareParameter(new SqlParameter(sParam13_sp, OracleTypes.NUMBER));

		declareParameter(new SqlOutParameter(Constantes.OUT_SP_RESULTADO, OracleTypes.CURSOR, new ExpedienteConsultaMapper()));
		declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR, OracleTypes.CURSOR, new ErrorBDMapper()));
		compile();
	}

	public Map<String, Object> execute(ConsultaExpedienteBean consultaExpDTO)throws DataAccessException 
	{
		
		Map<String, Object> input = new HashMap<String, Object>();
		
		input.put(sParam1_sp, "".equals(consultaExpDTO.getsNumeroExpediente()) ? null : Integer.parseInt(consultaExpDTO.getsNumeroExpediente()));
		input.put(sParam2_sp, consultaExpDTO.getiIdTipoJuicio());
		input.put(sParam3_sp, "".equals(consultaExpDTO.getsActor()) ? null : consultaExpDTO.getsActor());
		input.put(sParam4_sp, "".equals(consultaExpDTO.getsRemitente()) ? null : consultaExpDTO.getsRemitente());
		input.put(sParam5_sp, "".equals(consultaExpDTO.getsNumeroOficio()) ? null : consultaExpDTO.getsNumeroOficio());
		input.put(sParam6_sp, "".equals(consultaExpDTO.getsFolio()) ? null : consultaExpDTO.getsFolio());
		input.put(sParam7_sp, "".equals(consultaExpDTO.getsNumRegIni()) ? null : consultaExpDTO.getsNumRegIni());
		input.put(sParam8_sp, "".equals(consultaExpDTO.getsNumRegFin()) ? null : consultaExpDTO.getsNumRegFin());
		input.put(sParam9_sp, "".equals(consultaExpDTO.getsNumeroJuicio()) ? null : consultaExpDTO.getsNumeroJuicio());
		input.put(sParam10_sp, "".equals(consultaExpDTO.getsUsuario()) ? null : consultaExpDTO.getsUsuario());
		input.put(sParam11_sp, "".equals(consultaExpDTO.getsFechaIni()) ? null : consultaExpDTO.getsFechaIni());
		input.put(sParam12_sp, "".equals(consultaExpDTO.getsFechaFin()) ? null : consultaExpDTO.getsFechaFin());
		input.put(sParam13_sp, consultaExpDTO.getiStatusJucio());
		
		return super.execute(input);
	}

}
