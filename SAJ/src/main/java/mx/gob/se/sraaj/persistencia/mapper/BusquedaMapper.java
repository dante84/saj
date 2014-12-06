package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.DocumentoBean;

import org.springframework.jdbc.core.RowMapper;

public class BusquedaMapper implements RowMapper<DocumentoBean>{

	   public DocumentoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		    
		      DocumentoBean documentoBean = new DocumentoBean();
		      		      
		      documentoBean.setiIdRegDoc(rs.getInt(1));
		      documentoBean.setiNumeroExpediente(rs.getInt(3));
		      documentoBean.setsDescripcionTipoJuicio(rs.getString(4));
		      documentoBean.setsNumeroJuicio(rs.getString(5));
		      documentoBean.setsAct(rs.getString(6));
		      documentoBean.setiNumeroRegistro(rs.getInt(7));
		      documentoBean.setsSint(rs.getString(8));
		      		      
		      return documentoBean;
		   
	   }


}
