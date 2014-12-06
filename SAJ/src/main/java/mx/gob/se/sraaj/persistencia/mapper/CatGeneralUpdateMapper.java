package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;

import org.springframework.jdbc.core.RowMapper;

public class CatGeneralUpdateMapper implements RowMapper<CatGeneralBean> {
	
	public CatGeneralUpdateMapper (){
		
	}
	
	public CatGeneralBean mapRow (ResultSet rs, int ind) throws SQLException {
		
		CatGeneralBean catGeneralBeanImpl = new CatGeneralBean();
		
		catGeneralBeanImpl.setsIdCat(Integer.valueOf(rs.getString(1).trim()));
		catGeneralBeanImpl.setsDescripcionCat(rs.getString(2));
		catGeneralBeanImpl.setiActivo(rs.getInt(3));
		
		return catGeneralBeanImpl;
	}
}
