package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;

import org.springframework.jdbc.core.RowMapper;

public class CatGeneralMapper2 implements RowMapper<CatGeneralBean>{

	public CatGeneralMapper2(){}
	
	public CatGeneralBean mapRow(ResultSet rs, int idn) throws SQLException{
		CatGeneralBean catGeneralBean = new CatGeneralBean();
		catGeneralBean.setsIdCat(Integer.valueOf(rs.getString(1).trim()));
		catGeneralBean.setsDescripcionCat(rs.getString(2));
		catGeneralBean.setiActivo(rs.getInt(3));
		catGeneralBean.setIdMas(rs.getInt(4));
		
		return catGeneralBean;
	}
	
	
}
