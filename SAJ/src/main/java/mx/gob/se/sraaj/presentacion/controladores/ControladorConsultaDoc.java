package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.ConsultarBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.HistorialDocumentoBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.BitacoraDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="CConsultar")
@SessionScoped

public class ControladorConsultaDoc implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	private List<ConsultarBean> datos;

	public ConsultarBean dats;	
	public ConsultarBean getDats() { return dats; }
	public void setDats(ConsultarBean dats) { this.dats = dats; }


	public String load(Integer id)
	{
		System.out.println(id);
		try {
			setDatos(seguimientoDAOImpl.obtenerConsulta(id));
			dats = new ConsultarBean();
			for ( int i = 0; i< datos.size(); i++ ) {				

				dats.setIdregdoc(getDatos().get(i).getIdregdoc());
				dats.setDesctipojuicio(getDatos().get(i).getDesctipojuicio());
				dats.setOFICIOSINJUICIO(getDatos().get(i).getOFICIOSINJUICIO());
				dats.setNUMOFICIO(getDatos().get(i).getNUMOFICIO());
				dats.setFechaOficio(getDatos().get(i).getFechaOficio());
				dats.setFechaRecep(getDatos().get(i).getFechaRecep());
				dats.setNumexpediente(getDatos().get(i).getNumexpediente());
				dats.setNumjuicio(getDatos().get(i).getNumjuicio());
				dats.setNumreg(getDatos().get(i).getNumreg());
				dats.setEstatus(getDatos().get(i).getEstatus());
				dats.setRemitente(getDatos().get(i).getRemitente());
				dats.setUsuario(getDatos().get(i).getUsuario());
				dats.setINCIDENTESUSPENSION(getDatos().get(i).getINCIDENTESUSPENSION());
				dats.setFECNOT(getDatos().get(i).getFECNOT());
				dats.setDescjuzgado(getDatos().get(i).getDescjuzgado());
				dats.setOrgano(getDatos().get(i).getOrgano());
				dats.setDemandado(getDatos().get(i).getDemandado());
				dats.setDescripcion(getDatos().get(i).getDescripcion());
				dats.setAVERIGUACIONPREVIA_CAUSAPENAL(getDatos().get(i).getAVERIGUACIONPREVIA_CAUSAPENAL());
				dats.setResponsable(getDatos().get(i).getResponsable());
				dats.setPromovente(getDatos().get(i).getPromovente());
				dats.setTribunal(getDatos().get(i).getTribunal());
				dats.setMateria(getDatos().get(i).getMateria());
				dats.setFecvencimiento(getDatos().get(i).getFecvencimiento());
				dats.setFECCONVENCIONAL(getDatos().get(i).getFECCONVENCIONAL());
				dats.setFOLIO(getDatos().get(i).getFOLIO());
				dats.setTIPOASUNTO(getDatos().get(i).getTIPOASUNTO());				
				dats.setACUERDO_CITATORIO(getDatos().get(i).getACUERDO_CITATORIO());
				dats.setNUMEROCONTROVERSIA(getDatos().get(i).getNUMEROCONTROVERSIA());
				dats.setAutoridadresponsable(getDatos().get(i).getAutoridadresponsable());
				dats.setDescprocedencia(getDatos().get(i).getDescprocedencia());
				dats.setDescsalasfiscales(getDatos().get(i).getDescsalasfiscales());
				dats.setJUICIODEAMPARO(getDatos().get(i).getJUICIODEAMPARO());
				dats.setQuejoso(getDatos().get(i).getQuejoso());
				dats.setEXPEDIENTELABORAL(getDatos().get(i).getEXPEDIENTELABORAL());
				dats.setCEDULANOTIFICACION(getDatos().get(i).getCEDULANOTIFICACION());				 				 			
				//System.out.println(dats.getIdregdoc());
		   }
			System.out.println(dats.getIdregdoc());
			System.out.println("Cargar Bitacora!!!   ==========   >>>>>>    " + id );
			CargarBitacora(id);
		  			
		} catch (SraajException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(getDatos());
		return "consultaDoc";
	}
	
	
	//gets and sets
	public SeguimientoDAOImpl getSeguimientoDAOImpl() { return seguimientoDAOImpl; }
	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) { this.seguimientoDAOImpl = seguimientoDAOImpl; }

	public List<ConsultarBean> getDatos() { return datos; }
	public void setDatos(List<ConsultarBean> datos) { this.datos = datos;}

	
	//Historicos, segumientos y Bitacoras
	
	
	@ManagedProperty(value="#{bitacoraDAOImpl}")
    private BitacoraDAOImpl bitacoraDAOImpl;

   public BitacoraDAOImpl getBitacoraDAOImpl() { return bitacoraDAOImpl; }
   public void setBitacoraDAOImpl(BitacoraDAOImpl bitacoraDAOImpl) { this.bitacoraDAOImpl = bitacoraDAOImpl;}
	
	List<HistorialDocumentoBean> histDoc;	
	public List<HistorialDocumentoBean> getHistDoc() { return histDoc; }
    public void setHistDoc(List<HistorialDocumentoBean> histDoc) { this.histDoc = histDoc; }
    
    DocumentoBean doc;
    
    public String CargarBitacora(Integer idDRegDoc)
    {
    	System.out.println("Cargando inform... de la Bitacora!!!");
		     try 
		     {
		    	 setHistDoc(bitacoraDAOImpl.obtenerHistorialDoc(1));
		    	 System.out.println("lleno bitacora... ");    	
		     }  
		     catch (SraajException e) 
		     {
		    	 e.printStackTrace();
		     }
     
		     return "consultaDoc";
    }


	

}
