package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.DiligenciasMPBean;

import org.springframework.jdbc.core.RowMapper;

public class DiligenciasMPMapper implements RowMapper<DiligenciasMPBean>
{
	public DiligenciasMPBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		DiligenciasMPBean x = new DiligenciasMPBean();
		x.setIddiligencias(rs.getInt(1));
		x.setFecha(rs.getDate(2));
		x.setDiligencias(rs.getString(3));
		x.setObservaciones(rs.getString(4));
		x.setIdregdoc(rs.getInt(5));
		
		return x;
	}
}
