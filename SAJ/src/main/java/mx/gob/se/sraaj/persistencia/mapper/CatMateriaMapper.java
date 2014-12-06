package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;

import org.springframework.jdbc.core.RowMapper;

public class CatMateriaMapper implements RowMapper<CatMateriaBean>
{
	public CatMateriaBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		CatMateriaBean materia = new CatMateriaBean();
		
		materia.setIdmateria(rs.getInt(1));
		materia.setDescmateria(rs.getString(2));
		
		return materia;
	}
}
