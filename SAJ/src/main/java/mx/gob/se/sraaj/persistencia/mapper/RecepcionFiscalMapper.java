package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.transferencia.bean.RecepcionFiscalBean;

import org.springframework.jdbc.core.RowMapper;

public class RecepcionFiscalMapper implements RowMapper<RecepcionFiscalBean>{
	
	public RecepcionFiscalMapper(){}
	
	public RecepcionFiscalBean mapRow(ResultSet rs, int ind) throws SQLException{
		RecepcionFiscalBean recepcionFiscalBean = new RecepcionFiscalBean();
		recepcionFiscalBean.setdFechaRegistro(rs.getDate(1));
		recepcionFiscalBean.setsNumerJucio(rs.getString(2));
		recepcionFiscalBean.setsActorDemandado(rs.getString(3));
		recepcionFiscalBean.setiIdDocumentos(rs.getInt(4));
		recepcionFiscalBean.setdFechaDespacho(rs.getDate(5));
		recepcionFiscalBean.setdFechaConvencional(rs.getDate(6));
		recepcionFiscalBean.setdFechaReal(rs.getDate(7));
		recepcionFiscalBean.setiNumeroExpediente(rs.getInt(8));
		return recepcionFiscalBean;
	}

}
