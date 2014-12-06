package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.ConsultaDescargoDocBean;
import mx.gob.se.sraaj.comunes.bean.ConsultaExpedienteBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface GestionaExpedienteDAO {

//	public  Map<String,Object> reporteDocumentoDescargo() throws SraajException;
	public List<ConsultaDescargoDocBean> consultaDocumentoDescargo(String busqueda) throws SraajException;
	
	public List<ConsultaExpedienteBean> consultaExpedienteGeneral() throws SraajException;
}
