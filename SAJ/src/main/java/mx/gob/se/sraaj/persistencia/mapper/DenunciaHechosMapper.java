package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import mx.gob.se.sraaj.comunes.bean.DenunciaHechosBean;

import org.springframework.jdbc.core.RowMapper;

public class DenunciaHechosMapper implements RowMapper<DenunciaHechosBean>
{
	public DenunciaHechosBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		DenunciaHechosBean x = new DenunciaHechosBean();
		x.setIddenuncia(rs.getInt(1));
		x.setFecha(rs.getDate(2));
		x.setOficio(rs.getString(3));
		x.setAveriguacion(rs.getString(4));
		x.setMinisterio(rs.getString(5));
		x.setRatifica(rs.getString(6));
		x.setFechaRatificacion(rs.getDate(7));
		x.setIdregdoc(rs.getInt(8));
		
		
		return x;
	}
}
