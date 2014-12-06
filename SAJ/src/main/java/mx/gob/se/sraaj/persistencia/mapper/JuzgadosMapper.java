package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;



import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;

import org.springframework.jdbc.core.RowMapper;

public class JuzgadosMapper implements RowMapper<CatGeneralBean>{

	   public CatGeneralBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		    
		      CatGeneralBean cgb = new CatGeneralBean();
		      
		      cgb.setsIdCat(rs.getInt(1));
		      cgb.setsDescripcionCat(rs.getString(2));
		      
		      return cgb;
		      
	   }		   

}
