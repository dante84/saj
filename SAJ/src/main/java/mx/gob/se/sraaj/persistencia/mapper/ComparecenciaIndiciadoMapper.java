package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.ComparecenciaIndiciadoBean;

import org.springframework.jdbc.core.RowMapper;


public class ComparecenciaIndiciadoMapper implements RowMapper<ComparecenciaIndiciadoBean>
{
	public ComparecenciaIndiciadoBean mapRow(ResultSet rs, int idx) throws SQLException
	{
		ComparecenciaIndiciadoBean x = new ComparecenciaIndiciadoBean();
		x.setIdcomparecencia(rs.getInt(1));
		x.setFecha(rs.getDate(2));
		x.setPruebas(rs.getString(3));
		x.setObservaciones(rs.getString(4));
		x.setIdregdoc(rs.getInt(5));
		return x;
	}
    	
}
