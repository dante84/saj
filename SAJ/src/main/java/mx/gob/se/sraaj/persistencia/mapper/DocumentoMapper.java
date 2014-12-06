package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.DocumentoBean;

import org.springframework.jdbc.core.RowMapper;

public class DocumentoMapper implements RowMapper<DocumentoBean>{

	   public DocumentoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
		      DocumentoBean db = new DocumentoBean();
		      
		      db.setiNumeroExpediente(rs.getInt(1));
		      db.setsDescripcionTipoJuicio(rs.getString(2));
		      db.setsNumeroJuicio(rs.getString(3));
		      db.setsPromovente(rs.getString(4));
		      db.setiNumeroRegistro(rs.getInt(5));
		      db.setsSint(rs.getString(6));		    		      
//		      db.setsNumeroOficio(rs.getString(7));		
//		      db.setsClasificacionDocumental(rs.getString(8));
//		      db.setsFechaRegistro(rs.getString(9));
//		      db.setsNumeroJuicio(rs.getString(10));
//		      db.setsRemitente(rs.getString(11));
//		      db.setsSint(rs.getString(12));
//		      db.setiMonto(rs.getInt(13));
//		      db.setsFechaOficio(rs.getString(14));
//		      db.setsFolio(rs.getString(15));
//		      db.setsNombreUsuario(rs.getString(16));
		      		
		      return db;

	   }

}
