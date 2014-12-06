package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.RecepcionLaboralBean;

import org.springframework.jdbc.core.RowMapper;

public class RecepcionLaboralMapper implements RowMapper<RecepcionLaboralBean>{
	
	public RecepcionLaboralMapper(){
	}
	
	public RecepcionLaboralBean mapRow (ResultSet rs, int ind) throws SQLException{
		RecepcionLaboralBean recepcionLaboralBean = new RecepcionLaboralBean();
		
		recepcionLaboralBean.setiIdRegDocumentos(rs.getInt(1));
		recepcionLaboralBean.setiNumeroRegistro(rs.getInt(2));
		recepcionLaboralBean.setsFechaRecepcion(rs.getString(3));
		recepcionLaboralBean.setsPromovente(rs.getString(4));
		recepcionLaboralBean.setdFechaVencimiento(rs.getDate(5));
		recepcionLaboralBean.setdFechaConvecional(rs.getDate(6));
		recepcionLaboralBean.setiIdMateria(rs.getInt(7));
		recepcionLaboralBean.setiIdTipoJuicio(rs.getInt(8));
		recepcionLaboralBean.setsDescMateria(rs.getString(9));
		recepcionLaboralBean.setsDescTipoJuicio(rs.getString(10));
		
		return recepcionLaboralBean;
	}

}
