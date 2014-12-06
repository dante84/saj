package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;

import org.springframework.jdbc.core.RowMapper;

public class SeguimientoMapper implements RowMapper<SeguimientoBean>{

	   @Override
	   public SeguimientoBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		   
		      SeguimientoBean seg = new SeguimientoBean();
		
		      seg.setIdtipojuicio(rs.getInt(1));
		      seg.setNumreg(rs.getInt(2));
		      seg.setNumjuicio(rs.getString(3));
		      seg.setNumexpediente(rs.getInt(4));
		      seg.setJuiciodeamparo(rs.getString(5));
		      seg.setFecha(rs.getString(6));
		      seg.setHora(rs.getString(7));
		      seg.setFecvencimiento(rs.getDate(8));
		      seg.setFecconvencional(rs.getDate(9));
		      seg.setFecregistro(rs.getDate(10));
		      seg.setAc_de_pr_qu(rs.getString(11));
		      seg.setNombrecompleto(rs.getString(12));
		      seg.setDescripcionautoridad(rs.getString(13));
		      seg.setDescremitente(rs.getString(14));
		      seg.setRemitente(rs.getString(15));
		      seg.setDescjuzgado(rs.getString(16));
		      seg.setAsunto(rs.getString(17));
		      seg.setInstruccion(rs.getString(18));
		      seg.setDescripcion(rs.getString(19));
		      seg.setDescmateria(rs.getString(20));
		      seg.setAveriguacionprevia_causapenal(rs.getString(21));
		      seg.setIdregDoc(rs.getInt(22));
		      seg.setIdmateria(rs.getInt(23));
		      seg.setIdtribunal(rs.getInt(24));		
			  seg.setAcuseRecivo(rs.getInt(25));

		      return seg;
		
	   }

}
