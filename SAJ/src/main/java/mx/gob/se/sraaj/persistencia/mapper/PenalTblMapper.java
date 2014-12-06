package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.PenalTblBean;

import org.springframework.jdbc.core.RowMapper;


public class PenalTblMapper implements RowMapper<PenalTblBean>
{
	public PenalTblBean mapRow(ResultSet rs, int idx) throws SQLException{
    	
	      PenalTblBean x = new PenalTblBean();
	      
	      x.setIdregdoc(rs.getInt(1));
	      x.setNumexpediente(rs.getInt(2));
	      x.setNumoficio(rs.getString(3));
	      x.setFechaRecep(rs.getString(4));
	      x.setDescremitente(rs.getString(5));
	      x.setDescpenal(rs.getString(6));
	      x.setIDCATPENAL(rs.getInt(7));
	      x.setIndiciado(rs.getString(8));
	      x.setIdturnardoc(rs.getInt(9));
	      x.setInstrucciones(rs.getString(10));
	      x.setNombrecompleto(rs.getString(11));
	      x.setFecvencimiento(rs.getDate(12));
	      x.setEstatus(rs.getString(13));
	      x.setDesctipojuicio(rs.getString(14));
	      x.setDemandado(rs.getString(15));
	      x.setDelito(rs.getString(16));
	      x.setSintesis(rs.getString(17));
	      x.setDenuncia(rs.getString(18));
	      x.setAVERIGUACIONPREVIA_CAUSAPENAL(rs.getString(19));
	      x.setIMPORTE(rs.getDouble(20));
	      x.setMporganoJurisdiccional(rs.getString(21));
	      x.setFLUJOPROCESAL(rs.getString(22));
	      x.setSOLICITUDINTPGR(rs.getString(23)); 
	      x.setFECHADENUNCIA(rs.getString(24));
	      x.setOrganoJurisdiccional(rs.getString(25));
	      x.setIdturnado(rs.getInt(26));
	      x.setComentarios(rs.getString(28));
	      x.setNumExpPenal(rs.getString(29));
	      
	      return x;
	
 }
}
