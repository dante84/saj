package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.ResponsableBean;

import org.springframework.jdbc.core.RowMapper;

public class ResponsableMapper implements RowMapper<ResponsableBean> {
	
	   @Override
	   public ResponsableBean mapRow(ResultSet rs, int ind) throws SQLException{
		
		      ResponsableBean responsableBean = new ResponsableBean();
		      
		      responsableBean.setIdResponsable(String.valueOf(rs.getInt(1)));
		      responsableBean.setNombre(rs.getString(2));
		      
		      System.out.println(responsableBean.getIdResponsable() + " " + responsableBean.getNombre() + " ");
		      
		      try {
		    	  responsableBean.setDescripcionPuesto(rs.getString(3));
		    	  System.out.println(responsableBean.getDescripcionPuesto());
		      } catch (Exception e) {
				// TODO: handle exception
		      }
              		
 		      		      		      	
               
              
              
		      return responsableBean;
		      
	   }
	   
}