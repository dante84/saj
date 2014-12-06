package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.se.sraaj.comunes.bean.AsuntosJuridicosRepSeg;


import org.springframework.jdbc.core.RowMapper;

public class AsuntosJuridicosRepSegMapper implements RowMapper<AsuntosJuridicosRepSeg> {
	
	public AsuntosJuridicosRepSegMapper(){
		
	}

	@Override
	public AsuntosJuridicosRepSeg mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AsuntosJuridicosRepSeg Aj= new AsuntosJuridicosRepSeg();
		Aj.setsNoAmparo(rs.getString(1));
		Aj.setsFechaRecepcion(rs.getString(2));
		Aj.setsHoraRecepcion(rs.getString(3));
		Aj.setsMateria(rs.getString(4));
		Aj.setsFechaVencimiento(rs.getString(5));
		Aj.setsNoExpediente(rs.getString(6));
		Aj.setsPromovente(rs.getString(7));		
						
		return Aj;
			

	}

	
}
