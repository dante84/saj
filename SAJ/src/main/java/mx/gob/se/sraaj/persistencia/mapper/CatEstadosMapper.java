package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;

import org.springframework.jdbc.core.RowMapper;

public class CatEstadosMapper implements RowMapper<CatGeneralBean>{

	public CatEstadosMapper(){}
	
	public CatGeneralBean mapRow(ResultSet rs, int ind) throws SQLException{
		
		CatGeneralBean catGeneralBean = new CatGeneralBean();
		catGeneralBean.setiEstados(rs.getInt(1));
		catGeneralBean.setsDescripcionCat(rs.getString(2));
		
		return catGeneralBean;
	}
	
}
