package mx.gob.se.sraaj.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.se.sraaj.comunes.bean.ConsultarBean;

import org.springframework.jdbc.core.RowMapper;

public class ConsultaMapper implements RowMapper<ConsultarBean>
{
	public ConsultarBean mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		ConsultarBean documento = new ConsultarBean();
		
		documento.setIdregdoc(rs.getInt(1));
		documento.setDesctipojuicio(rs.getString(2));
		documento.setOFICIOSINJUICIO(rs.getString(3));
		documento.setNUMOFICIO(rs.getString(4));
		documento.setFechaOficio(rs.getString(5));
		documento.setFechaRecep(rs.getString(6));
		documento.setNumexpediente(rs.getInt(7));
		documento.setNumjuicio(rs.getString(8));
		documento.setNumreg(rs.getInt(9));
		documento.setEstatus(rs.getString(10));
		documento.setRemitente(rs.getString(11));
		documento.setUsuario(rs.getString(12));
		documento.setINCIDENTESUSPENSION(rs.getString(13));
		documento.setFECNOT(rs.getString(14));
		documento.setDescjuzgado(rs.getString(15));
		documento.setOrgano(rs.getString(16));
		documento.setDemandado(rs.getString(17));
		documento.setDescripcion(rs.getString(18));
		documento.setAVERIGUACIONPREVIA_CAUSAPENAL(rs.getString(19));
		documento.setResponsable(rs.getString(20));
		documento.setPromovente(rs.getString(21));
		documento.setTribunal(rs.getString(22));
		documento.setMateria(rs.getString(23));
		documento.setFecvencimiento(rs.getString(24));
		documento.setFECCONVENCIONAL(rs.getString(25));
		documento.setFOLIO(rs.getInt(26));
		documento.setTIPOASUNTO(rs.getString(27));
		documento.setACUERDO_CITATORIO(rs.getString(28));
		documento.setNUMEROCONTROVERSIA(rs.getInt(29));
		documento.setAutoridadresponsable(rs.getString(30));
		documento.setDescprocedencia(rs.getString(31));
		documento.setDescsalasfiscales(rs.getString(32));
		documento.setJUICIODEAMPARO(rs.getString(33));
		documento.setQuejoso(rs.getString(34));
		documento.setEXPEDIENTELABORAL(rs.getString(35));
		documento.setCEDULANOTIFICACION(rs.getString(36));
		return documento;
	}
}
