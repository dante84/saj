package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import mx.gob.se.sraaj.comunes.bean.MediosPruebaBean;

import org.springframework.jdbc.core.RowMapper;


public class MediosPruebaMapper implements RowMapper<MediosPruebaBean>
{
	public MediosPruebaBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		MediosPruebaBean x =  new MediosPruebaBean();
		x.setIdmediosPrueba(rs.getInt(1));
		x.setFecha(rs.getDate(2));
		x.setTestimoniales(rs.getString(3));
		x.setPericiales(rs.getString(4));
		x.setDocumentales(rs.getString(5));
		x.setInspeccion(rs.getString(6));
		x.setOtra(rs.getString(7));
		x.setObservaciones(rs.getString(8));
		x.setIdregdoc(rs.getInt(9));
		
		return x;
	}
}
