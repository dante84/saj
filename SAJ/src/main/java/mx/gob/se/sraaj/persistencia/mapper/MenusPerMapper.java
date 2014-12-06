package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.MenuBean;

import org.springframework.jdbc.core.RowMapper;

public class MenusPerMapper implements RowMapper<MenuBean>{
	
	public MenusPerMapper(){}
	
	public MenuBean mapRow(ResultSet rs, int ind) throws SQLException{
		MenuBean menuBean = new MenuBean();
		menuBean.setiIdMenu(rs.getInt(1));
		menuBean.setDescMenu(rs.getString(2));
		menuBean.setDescSubMenu(rs.getString(3));
		
		return menuBean;
	}

}
