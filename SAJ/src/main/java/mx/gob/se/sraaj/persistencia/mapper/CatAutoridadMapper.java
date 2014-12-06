package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatAutoridadBean;

import org.springframework.jdbc.core.RowMapper;

public class CatAutoridadMapper implements RowMapper<CatAutoridadBean>
{

	public CatAutoridadBean mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		CatAutoridadBean autoridad = new CatAutoridadBean();
		
		autoridad.setIdAutoridad(rs.getInt(1));
		autoridad.setDescripcion(rs.getString(2));
		autoridad.setActivo(rs.getInt(3));
		// TODO Auto-generated method stub
		return autoridad;
	}

}
