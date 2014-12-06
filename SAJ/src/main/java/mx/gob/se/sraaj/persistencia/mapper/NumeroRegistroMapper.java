package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NumeroRegistroMapper implements RowMapper<Integer> {
	
	   @Override
	   public Integer mapRow(ResultSet rs, int ind) throws SQLException{
				            		      		      	
		      return rs.getInt(1);
		      
	   }

}
