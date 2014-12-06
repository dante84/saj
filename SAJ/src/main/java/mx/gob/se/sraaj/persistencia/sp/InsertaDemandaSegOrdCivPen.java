package mx.gob.se.sraaj.persistencia.sp;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import mx.gob.se.sraaj.comunes.bean.DemandaInicialBean;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.mapper.ErrorBDMapper;
import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class InsertaDemandaSegOrdCivPen extends StoredProcedure {

	private String param0 = "pidfproc";
	private String param1 = "pidregdoc";
	private String param2 = "pfecha";
	private String param3 = "pauto";
	private String param4 = "pjuicio";
	private String param5 = "porgano";
	private String param6 = "pemplaza";
	private String param7 = "pembargo";
	private String param8 = "pqembargo";
	private String param9 = "pcontesta";	
	private String param10 = "pidprocesal";
	private String param11 = "pidRegist";
	private String param12 = "pviainter";
	
	 public InsertaDemandaSegOrdCivPen(DataSource ds, String sNomSP) {
		 super(ds, sNomSP);
		 declareParameter(new SqlInOutParameter(param0 ,  OracleTypes.INTEGER));
		 declareParameter(new SqlInOutParameter(param1 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param2 ,  OracleTypes.DATE));
	     declareParameter(new SqlInOutParameter(param3 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param4 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param5 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param6 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param7 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param8 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param9 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param10 ,  OracleTypes.VARCHAR));
	     declareParameter(new SqlInOutParameter(param11 ,  OracleTypes.INTEGER));
	     declareParameter(new SqlInOutParameter(param12 ,  OracleTypes.VARCHAR));
	     	     	     
	     declareParameter(new SqlOutParameter(Constantes.OUT_SP_ERROR,     OracleTypes.CURSOR, new ErrorBDMapper()));
	     compile();
	 }
	
	   public Map<String, Object> execute(DemandaInicialBean demandaInicialBean) {		   		     
		   
		      Map<String,Object> parametros = new HashMap<String, Object>();
		      
		      parametros.put(param0, demandaInicialBean.getIdfProc());
		      parametros.put(param1, demandaInicialBean.getIdregdoc());
		      parametros.put(param2, demandaInicialBean.getDfecha());
		      parametros.put(param3, demandaInicialBean.getsAutoAdmin());		      		      		     		     
		      parametros.put(param4, demandaInicialBean.getSjuicio());
		      parametros.put(param5, demandaInicialBean.getsOrganoJurid());		      
		      parametros.put(param6, demandaInicialBean.getsEmplazamiento());
		      parametros.put(param7, demandaInicialBean.getsEmbargo());		      
		      parametros.put(param8, demandaInicialBean.getsQEmbargo());
		      parametros.put(param9, demandaInicialBean.getsContestacion());		      		
		      parametros.put(param10, demandaInicialBean.getSidprocesal());
		      parametros.put(param11, demandaInicialBean.getSidRegist());
		      parametros.put(param12, demandaInicialBean.getsViaInt());
		      
		      return super.execute(parametros);
		      
	   }
	
}
