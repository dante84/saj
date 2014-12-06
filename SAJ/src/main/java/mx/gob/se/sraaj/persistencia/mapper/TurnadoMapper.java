package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.se.sraaj.comunes.bean.TurnadoBean;
import org.springframework.jdbc.core.RowMapper;

public class TurnadoMapper implements RowMapper<TurnadoBean> {
	
	@Override
	public TurnadoBean mapRow(ResultSet rs, int rowNum) throws SQLException {			
		
		TurnadoBean tur = new TurnadoBean();
		tur.setiIdTurnarDoc(rs.getInt(1));
		tur.setiIdTurnado(rs.getInt(2));
		tur.setiIdRegDoc(rs.getInt(3));
		tur.setsInstruccion1(rs.getString(4));
		tur.setsInstruccion2(rs.getString(5));
		tur.setsInstruccion3(rs.getString(6));
		tur.setsInstruccion4(rs.getString(7));
		tur.setsInstruccion5(rs.getString(8));
		tur.setsInstruccion6(rs.getString(9));
		tur.setsInstruccion7(rs.getString(10));
		tur.setsInstruccion8(rs.getString(11));
		tur.setsInstruccion9(rs.getString(12));
		tur.setsInstruccion10(rs.getString(13));
		tur.setsEspecifique(rs.getString(14));
		tur.setsActoReclamado(rs.getString(15));
		tur.setsAcuseRecibo(rs.getString(16));
		
		return tur;
	}

	
}
