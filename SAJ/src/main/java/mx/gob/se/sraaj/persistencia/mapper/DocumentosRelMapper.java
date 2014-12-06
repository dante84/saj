package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;

import org.springframework.jdbc.core.RowMapper;

public class DocumentosRelMapper implements RowMapper<DocumentosRelBean>
{
	public DocumentosRelBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		
		DocumentosRelBean x = new DocumentosRelBean();
		
		x.setIdregdoc(rs.getInt(1));
		x.setNumreg(rs.getInt(2));
		x.setFecha(rs.getString(3));
		x.setHora(rs.getString(4));
		x.setNumjuicio(rs.getString(5));
		x.setOrganoj(rs.getString(6));
		x.setInstruccion(rs.getString(7));
		x.setNombrecompleto(rs.getString(8));
		x.setQuejoso(rs.getString(9));
		x.setDescripcionautoridad(rs.getString(10));
		x.setAtendido(rs.getString(11));
		x.setAveriguacionprevia_causapenal(rs.getString(12));
		x.setIndiciado(rs.getString(13));
		x.setNumoficio(rs.getString(14));
		x.setFecoficio(rs.getDate(15));
		x.setFechadenuncia(rs.getDate(16));
		x.setEdoprocesal(rs.getString(17));
		x.setNumexp(rs.getInt(18));
		x.setMateria(rs.getString(19));
		return x;
		
	}
	
	
	
}
