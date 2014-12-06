package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.OrdinarioCivilPenalBean;

import org.springframework.jdbc.core.RowMapper;

public class OrdinarioCivilPenalMapper implements RowMapper<OrdinarioCivilPenalBean>{

	public OrdinarioCivilPenalBean mapRow(ResultSet rs, int rowNum)throws SQLException {
		
		OrdinarioCivilPenalBean ocp = new OrdinarioCivilPenalBean();
		ocp.setIdRegDoc(rs.getInt(1));
		ocp.setIdF_Procesal(rs.getInt(2));
		ocp.setsOficio(rs.getString(3));
		ocp.setdFecha(rs.getDate(4));
		ocp.setsRequerimientoPGR(rs.getString(5));
		ocp.setsDesc_Procesal(rs.getString(6));
		
		//12 - 18
		ocp.setsAutoAdmin(rs.getString(12));
		ocp.setSjuicio(rs.getString(13));
		ocp.setsOrganoJurid(rs.getString(14));
		ocp.setsEmplazamiento(rs.getString(15));
		ocp.setsEmbargo(rs.getString(16));
		ocp.setsQEmbargo(rs.getString(17));
		ocp.setsContestacion(rs.getString(18));
		ocp.setsViaInter(rs.getString(19));
		
		return ocp;
	}

}
