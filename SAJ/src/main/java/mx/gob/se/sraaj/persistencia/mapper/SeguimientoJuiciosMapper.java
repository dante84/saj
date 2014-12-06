package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;

import org.springframework.jdbc.core.RowMapper;

public class SeguimientoJuiciosMapper  implements RowMapper<SeguimientoJuiciosBean>{
	
 	   public SeguimientoJuiciosBean mapRow(ResultSet rs, int rowNum) throws SQLException{
 		   
	          SeguimientoJuiciosBean x = new SeguimientoJuiciosBean();
	
	          x.setIdregdoc(rs.getInt(1));
              x.setIdtipojuicio(rs.getInt(2));
              x.setNumjuicio(rs.getString(3));
              x.setExpedientelaboral(rs.getString(4));
              x.setAc_de_pr_qu(rs.getString(5));
              x.setDescripcion(rs.getString(6));
              x.setDescmateria(rs.getString(7));
              x.setNombrecompleto(rs.getString(8));
              x.setNombre(rs.getString(9));
              x.setNumexpediente(rs.getInt(10));
              x.setNumreg(rs.getInt(11));
              x.setFecha(rs.getString(12));
              x.setHora(rs.getString(13));
              x.setFecvencimiento(rs.getDate(14));
              x.setDescpuesto(rs.getString(15));
              x.setAcuerdo_citatorio(rs.getString(16));
              x.setAutoridadresponsable(rs.getString(17));
              x.setFecoficio(rs.getDate(18));
              x.setAsunto(rs.getString(19));
              x.setDescjuzgado(rs.getString(20));
              x.setSintesis(rs.getString(21));
              x.setExpinterno(rs.getString(22));
              x.setAtendido(rs.getString(23));
              x.setEdoprocesal(rs.getString(24));
              x.setNoamparo(rs.getString(25));
              x.setFechasesion(rs.getDate(26));
              x.setAudienciacons(rs.getString(27));
              x.setAreadescrip(rs.getString(28));
              x.setAccionprincipal(rs.getString(29));
              x.setEstatus(rs.getString(30));
              x.setIndiciado(rs.getString(31));
              x.setFechadenuncia(rs.getDate(32));
              x.setCausapenal(rs.getString(33));
              x.setImporte(rs.getDouble(34));
              x.setFlujoprocesal(rs.getString(35));
              x.setSolicitudintpgr(rs.getString(36));
              x.setJuicio(rs.getString(37));
              x.setIdtribunal(rs.getInt(38));
              x.setIdmateria(rs.getInt(39));
    
              return x;
              
	   }
 	   
}
