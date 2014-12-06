package mx.gob.se.sraaj.persistencia.daoImpl;

import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.ConsultaDescargoDocBean;
import mx.gob.se.sraaj.comunes.bean.ConsultaExpedienteBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.GestionaExpedienteDAO;
import mx.gob.se.sraaj.persistencia.sp.ReporteDocumentoDescargoSP;
import mx.gob.se.sraaj.persistencia.sp.ConsultaExpedienteGeneralSP;

public class GestionaExpedienteDAOImpl implements GestionaExpedienteDAO {
	
	/**
	 * variables
	 */
	private ReporteDocumentoDescargoSP		reporteDocumentoDescargoSP;
	private ConsultaExpedienteGeneralSP 	consultaExpedienteGeneralSP;
	
	
	public List<ConsultaDescargoDocBean> consultaDocumentoDescargo() throws SraajException{
		  System.out.println("========>> en GestionaExpedienteDAO.consultaDocumentoDescargo");
		  List<ConsultaDescargoDocBean> lCat = null;
		  try{
		   Map<String, Object> mapCursor = reporteDocumentoDescargoSP.execute();
		   if(mapCursor != null){
		    Object retorno = mapCursor.get(Constantes.OUT_SP_RESULTADO);
		    if(retorno instanceof List<?>){
		     lCat = (List<ConsultaDescargoDocBean>) retorno;
		    }
		   }
		   return lCat;
		  }
		  catch(Exception ex){
		   throw new SraajException(ex.getMessage(), ex);
		  }
		 }
	
	
	public List<ConsultaExpedienteBean> consultaExpedienteGeneral() throws SraajException
	{
		List<ConsultaExpedienteBean> consulta = null;
		try 
		{
			Map<String, Object> mapCursor = consultaExpedienteGeneralSP.execute();
			if (mapCursor != null) 
			{
				Object retorno = mapCursor.get(Constantes.OUT_SP_RESULTADO);
				if (retorno instanceof List<?>) 
				{
					consulta = (List<ConsultaExpedienteBean>)retorno;
							
				}
			}
		} 
		catch (Exception e) 
		{
			throw new SraajException(e.getMessage(), e);
		}
		
		return consulta;
		
	}
	
	public List<ConsultaDescargoDocBean> consultaDocumentoDescargo(String busqueda) throws SraajException{

		   System.out.println("========>> en GestionaExpedienteDAO.consultaDocumentoDescargo");
		   List<ConsultaDescargoDocBean> lCat = null;
		   
		   try{
			   
		       Map<String, Object> mapCursor = reporteDocumentoDescargoSP.execute(busqueda);
  		       if( mapCursor != null ) {
		           Object retorno = mapCursor.get(Constantes.OUT_SP_RESULTADO);
		           if( retorno instanceof List<?> ){ lCat = (List<ConsultaDescargoDocBean>) retorno; }
		       }
  		       
		       return lCat;
		       
		    }catch(Exception ex){ throw new SraajException(ex.getMessage(), ex); }
		   
    }

	
	public ConsultaExpedienteGeneralSP getConsultaExpedienteGeneralSP() { return consultaExpedienteGeneralSP; }
	public void setConsultaExpedienteGeneralSP( ConsultaExpedienteGeneralSP consultaExpedienteGeneralSP ) {	this.consultaExpedienteGeneralSP = consultaExpedienteGeneralSP; }
	
	public ReporteDocumentoDescargoSP getReporteDocumentoDescargoSP() { return reporteDocumentoDescargoSP; }
	public void setReporteDocumentoDescargoSP( ReporteDocumentoDescargoSP reporteDocumentoDescargoSP) { this.reporteDocumentoDescargoSP = reporteDocumentoDescargoSP; }

    	
}
