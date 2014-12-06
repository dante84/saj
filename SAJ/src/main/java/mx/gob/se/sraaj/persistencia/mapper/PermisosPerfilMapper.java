package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.PerfilBean;

import org.springframework.jdbc.core.RowMapper;

public class PermisosPerfilMapper implements RowMapper<PerfilBean>{
	
	public PermisosPerfilMapper(){}
	
	public PerfilBean mapRow(ResultSet rs, int ind) throws SQLException{
		PerfilBean perfilBean = new PerfilBean();
		perfilBean.setsPermisos(rs.getString(1));
		return perfilBean;
	}

}
