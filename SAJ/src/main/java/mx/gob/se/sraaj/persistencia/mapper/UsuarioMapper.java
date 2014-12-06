package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.servicio.bean.UsuarioBean;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper<UsuarioBean>{

//private static Logger logger = LogFactory.getLogger(UsuarioMapper.class);
	
	public UsuarioMapper() {
		//logger.info(Constantes.MSG_LOG_CONSTRUCTOR + "PerfilMapper");
	}

	@Override
	public UsuarioBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}