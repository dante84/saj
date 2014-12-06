package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

import org.springframework.jdbc.core.RowMapper;

public class AccesoUsuarioMapper implements RowMapper<UsuariosBeanImpl> {
		   
	   public UsuariosBeanImpl mapRow(ResultSet rs, int idx) throws SQLException {
		   
		      UsuariosBeanImpl datUser = new UsuariosBeanImpl();
		      
		      datUser.setsNombre(rs.getString(1));
		      datUser.setsApellidoPaterno(rs.getString(2));
		      datUser.setsApellidoMaterno(rs.getString(3));
		      datUser.setsCorreoElectronico(rs.getString(4));
		      datUser.setiUsuarioHabilitado(rs.getInt(5));
		      datUser.setiIdPerfil(rs.getInt(6));
		      datUser.setiIdPuesto(rs.getInt(7));
		      datUser.setiIdDepartamento(rs.getInt(8));
		      datUser.setiIdunidadAdministrativa(rs.getInt(9));
		      		      		     
		      return datUser;
		      
	   }
	   
}
