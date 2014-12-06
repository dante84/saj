package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;

import org.springframework.jdbc.core.RowMapper;

public class CatGenearlMapper implements RowMapper<CatGenerico>
{
	@Override
	public CatGenerico mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		CatGenerico x = new CatGenerico();
		
		x.setId(rs.getInt(1));
		x.setDescripcion(rs.getString(2));
		return x;
	}
}
