package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.HistorialDocumentoBean;

import org.springframework.jdbc.core.RowMapper;

public class HistorialDocumentoMapper implements RowMapper<HistorialDocumentoBean>
{

	@Override
	public HistorialDocumentoBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		HistorialDocumentoBean contenedor = new HistorialDocumentoBean();
		
		contenedor.setFecha(rs.getTimestamp(1)); 
		contenedor.setDescripcion(rs.getString(2));
		
		return contenedor;
	}
}
