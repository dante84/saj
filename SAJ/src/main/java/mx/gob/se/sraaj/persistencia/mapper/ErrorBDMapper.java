package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;

import org.springframework.jdbc.core.RowMapper;

public class ErrorBDMapper implements RowMapper<ErrorBDBean> {
		
	   public ErrorBDBean mapRow(ResultSet rs, int idx) throws SQLException {
		   
		      ErrorBDBean error = new ErrorBDBean();		      		      
		      		      
		      error.setsCodError( rs.getString(1));
		      error.setsDescError(rs.getString(2));		      		      
		   
		      return error;
		   
	   }

}
