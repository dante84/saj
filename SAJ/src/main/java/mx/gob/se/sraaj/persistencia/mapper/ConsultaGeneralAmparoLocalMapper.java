package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import mx.gob.se.sraaj.comunes.bean.ConsultaGeneralAmparoLocal;

import org.springframework.jdbc.core.RowMapper;

public class ConsultaGeneralAmparoLocalMapper implements RowMapper<ConsultaGeneralAmparoLocal>
{
	public ConsultaGeneralAmparoLocalMapper(){}
	
	public ConsultaGeneralAmparoLocal mapRow(ResultSet rs, int idx) throws SQLException
	{
		ConsultaGeneralAmparoLocal consultaGeneralAmparoLocal = new ConsultaGeneralAmparoLocal();
		
		consultaGeneralAmparoLocal.setIdregdoc(rs.getInt(1));
		consultaGeneralAmparoLocal.setIdtipojuicio(rs.getInt(2));
		consultaGeneralAmparoLocal.setNumjuicio(rs.getInt(3));
		consultaGeneralAmparoLocal.setIdremitente(rs.getInt(4));
		consultaGeneralAmparoLocal.setDescremitente(rs.getString(5));
		consultaGeneralAmparoLocal.setFecoficio(rs.getDate(6));
		consultaGeneralAmparoLocal.setNumreg(rs.getInt(7));
		consultaGeneralAmparoLocal.setIdarchivo(rs.getInt(8));
		consultaGeneralAmparoLocal.setDescarchivo(rs.getString(9));
		consultaGeneralAmparoLocal.setPatharchivo(rs.getString(10));
		consultaGeneralAmparoLocal.setUsuario(rs.getString(11));
		consultaGeneralAmparoLocal.setSintesis(rs.getString(12));
		consultaGeneralAmparoLocal.setNumoficio(rs.getInt(13));
		consultaGeneralAmparoLocal.setIdjuzgado(rs.getInt(14));
		consultaGeneralAmparoLocal.setDescjuzgado(rs.getString(15));
		consultaGeneralAmparoLocal.setQuejoso(rs.getString(16));
		consultaGeneralAmparoLocal.setIncidentesuspension(rs.getString(17));
		consultaGeneralAmparoLocal.setFecnot(rs.getDate(18));
		consultaGeneralAmparoLocal.setFecrecep(rs.getDate(19));
		
		
		return consultaGeneralAmparoLocal;
	}
}
