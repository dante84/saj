package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.MenuBean;

import org.springframework.jdbc.core.RowMapper;

public class CatTribunalMapper implements RowMapper<CatTribunalBean>
{

	public CatTribunalBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		CatTribunalBean tribunal = new CatTribunalBean();
		tribunal.setIdTribunal(rs.getInt(1));
		tribunal.setDecripcion(rs.getString(2));
		tribunal.setActivo(rs.getInt(3));
		return tribunal;
	}

}
