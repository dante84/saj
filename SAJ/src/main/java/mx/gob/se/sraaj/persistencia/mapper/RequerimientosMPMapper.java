package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.RequerimientosMPBean;

import org.springframework.jdbc.core.RowMapper;

public class RequerimientosMPMapper implements RowMapper<RequerimientosMPBean>
{
	public RequerimientosMPBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		RequerimientosMPBean x = new RequerimientosMPBean();
		
		x.setIdRequerimiento(rs.getInt(1));
		x.setFecha(rs.getDate(2));
		x.setOficio(rs.getString(3));
		x.setRequerimiento(rs.getString(4));
		x.setDesahogo(rs.getString(5));
		x.setObservaciones(rs.getString(6));
		x.setIdregdoc(rs.getInt(7));
		
		return x;
		
		
	}
}
