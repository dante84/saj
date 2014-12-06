package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.MenuBean;

import org.springframework.jdbc.core.RowMapper;

public class AccesoMapper implements RowMapper<MenuBean> {
		
	   public MenuBean mapRow(ResultSet rs, int idx) throws SQLException{
		    	
		      MenuBean accesoVO = new MenuBean();
		
		      accesoVO.setDescMenu(rs.getString(1));
		      accesoVO.setDescSubMenu(rs.getString(2));
		      accesoVO.setPathMenu(rs.getString(3));
		      accesoVO.setiStatus(rs.getInt(4));
		      		      
		      return accesoVO;
		
	   }

}

