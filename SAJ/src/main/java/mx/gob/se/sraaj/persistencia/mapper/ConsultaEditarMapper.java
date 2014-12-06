package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.DocumentoBean;

import org.springframework.jdbc.core.RowMapper;

public class ConsultaEditarMapper implements RowMapper<DocumentoBean> {
	
	   public DocumentoBean mapRow(ResultSet rs, int idx) throws SQLException{
		   
		      DocumentoBean documentoBean = new DocumentoBean();
		
		      documentoBean.setsNumeroOficio(rs.getString(1));
		      documentoBean.setiNumeroRegistro(rs.getInt(2));
		      documentoBean.setsFechaRegistro(rs.getString(3));
		      documentoBean.setsDescripcionTipoJuicio(rs.getString(4));
		      documentoBean.setsNumeroJuicio(rs.getString(5));
		      documentoBean.setsAct(rs.getString(6));
		      documentoBean.setsRemitente(rs.getString(7));
		      documentoBean.setiEstatus(rs.getInt(8));
		      documentoBean.setsSint(rs.getString(9));
		      documentoBean.setsFechaOficio(rs.getString(10));
		      documentoBean.setsFolio(rs.getString(11));
		      documentoBean.setsNombreUsuario(rs.getString(12));
		      documentoBean.setsDescCatResponsable(rs.getString(13));
		      
		      return documentoBean;
		
	   }

}
