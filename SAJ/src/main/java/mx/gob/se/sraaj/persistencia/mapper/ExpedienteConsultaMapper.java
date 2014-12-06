package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.ConsultaExpedienteBean;

import org.springframework.jdbc.core.RowMapper;

public class ExpedienteConsultaMapper implements RowMapper<ConsultaExpedienteBean> 
{
	public ExpedienteConsultaMapper() 
	{
		
	}

	public ConsultaExpedienteBean mapRow(ResultSet rs, int idx) throws SQLException{
		ConsultaExpedienteBean ConsultaExpedienteBean = new ConsultaExpedienteBean();
		ConsultaExpedienteBean.setsNumeroExpediente(rs.getString(1));
		ConsultaExpedienteBean.setsTipoJuicio(rs.getString(2));
		ConsultaExpedienteBean.setsNumeroJuicio(rs.getString(3));
		ConsultaExpedienteBean.setsActor(rs.getString(4));
		ConsultaExpedienteBean.setsNumeroRegistro(rs.getString(5));
		ConsultaExpedienteBean.setsSintesis(rs.getString(6));
		return ConsultaExpedienteBean;		
	}

}
