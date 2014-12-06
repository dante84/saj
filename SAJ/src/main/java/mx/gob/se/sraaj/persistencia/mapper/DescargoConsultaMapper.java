package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.ConsultaDescargoDocBean;

import org.springframework.jdbc.core.RowMapper;

public class DescargoConsultaMapper implements RowMapper<ConsultaDescargoDocBean> {
	
	public DescargoConsultaMapper(){
		
	}
	
	public ConsultaDescargoDocBean mapRow(ResultSet rs, int idx) throws SQLException{
		
		ConsultaDescargoDocBean consultaDescargoDocBean = new ConsultaDescargoDocBean();

		consultaDescargoDocBean.setiIdRegDoc(rs.getInt(1));
		consultaDescargoDocBean.setsNumeroOficio(rs.getString(2));
		consultaDescargoDocBean.setiNumeroRegistro(rs.getInt(3));
		consultaDescargoDocBean.setsNumeroJuicio(rs.getString(4));
		consultaDescargoDocBean.setsNombreResposable(rs.getString(5));
		consultaDescargoDocBean.setsFolio(rs.getString(6));
		consultaDescargoDocBean.setsNumExpedienteDescargo(rs.getString(7));
		consultaDescargoDocBean.setiTieneRegistro(rs.getInt(8));
		consultaDescargoDocBean.setsNumDocumentoDescargo(rs.getString(9));
		consultaDescargoDocBean.setsDescDescargo(rs.getString(10));
		
		return consultaDescargoDocBean;
	}

}
