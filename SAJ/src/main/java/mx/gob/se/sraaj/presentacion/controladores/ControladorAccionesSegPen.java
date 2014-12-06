package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.itextpdf.text.log.SysoCounter;

import mx.gob.se.sraaj.comunes.bean.DemandaInicialBean;
import mx.gob.se.sraaj.comunes.bean.OrdinarioCivilPenalBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaDemandaImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;

@ManagedBean(name="CAccionesSegPen")
@SessionScoped

public class ControladorAccionesSegPen implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	public SeguimientoDAOImpl getSeguimientoDAOImpl() { return seguimientoDAOImpl; }
	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) { this.seguimientoDAOImpl = seguimientoDAOImpl;}
	
	private List<OrdinarioCivilPenalBean> listDemandaInicContest;	
	public List<OrdinarioCivilPenalBean> getListDemandaInicContest() { return listDemandaInicContest;}
	public void setListDemandaInicContest(List<OrdinarioCivilPenalBean> listDemandaInicContest) {this.listDemandaInicContest = listDemandaInicContest;}

	
	private String txtBusqueda;
	public String getTxtBusqueda() { return txtBusqueda; }
	public void setTxtBusqueda(String txtBusqueda) { this.txtBusqueda = txtBusqueda; }
	
	private String busquedaPorTexto;		
	public String getBusquedaPorTexto() { return busquedaPorTexto; }
	public void setBusquedaPorTexto(String busquedaPorTexto) { this.busquedaPorTexto = busquedaPorTexto; }
	
	 
	public String pagina(){			
			System.out.println("Solo prueba!!!!!!!!");			
			LoadDemandaInicContestacion(91,"",2);
			LimpiarVariables();
		return "demandaInicContest";
	}
	public void LoadDemandaInicContestacion(int idregisgtro, String busqueda, Integer idjuicio){
		System.out.println("========>> Registro " + idregisgtro);		
		System.out.println("========>> Juicio " + idjuicio);
			try{			
				setListDemandaInicContest(seguimientoDAOImpl.ObtieneOrdCivPenal(idregisgtro, busqueda, idjuicio));
				System.out.println("========>> Elementos de la lista" + listDemandaInicContest);
				if(listDemandaInicContest.size()>0){
					setTr_sViaInter(listDemandaInicContest.get(0).getsViaInter());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}				
	}	
	
	public void onRowEdit(RowEditEvent event){
		
		System.out.println("Edicion del deyvt..... " );
		
		Integer idFPr = 0;				
		
		idFPr = ((OrdinarioCivilPenalBean)event.getObject()).getIdF_Procesal();		
		
		if(getTa_dfecha()!=null){
			setTa_dfecha(getTa_dfecha());			
		}else{			
			setTa_dfecha(((OrdinarioCivilPenalBean)event.getObject()).getdFecha());								
		}		
		
		String Aux = null; 
		if((ta_sAutoAdmin.toString() !=null) ||(ta_sAutoAdmin.toString() !="")|| (ta_sAutoAdmin.toString() !=" ")){
			//setTa_sAutoAdmin(getTa_sAutoAdmin());
			Aux = getTa_sAutoAdmin();
		}else{ 
			if(((OrdinarioCivilPenalBean)event.getObject()).getsAutoAdmin() !=""){
				//setTa_sAutoAdmin(((OrdinarioCivilPenalBean)event.getObject()).getsAutoAdmin());
				Aux = ((OrdinarioCivilPenalBean)event.getObject()).getsAutoAdmin();
			}			
		}			
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!   Aux " + Aux);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!   Ata_sAutoAdminux " + ta_sAutoAdmin);
		
		if(ta_sContestacion!=null){
			setTa_sContestacion(getTa_sContestacion());
		}else{			
			if(((OrdinarioCivilPenalBean)event.getObject()).getsContestacion()!=""){
				setTa_sContestacion(((OrdinarioCivilPenalBean)event.getObject()).getsContestacion());
			}
		}
		
		if(ta_sEmplazamiento!=null){
			setTa_sEmplazamiento(getTa_sEmplazamiento());
		}else{
			if(((OrdinarioCivilPenalBean)event.getObject()).getsEmplazamiento()!=""){
				setTa_sEmplazamiento(((OrdinarioCivilPenalBean)event.getObject()).getsEmplazamiento());
			}
		}
		
		if(ta_sEmbargo!=null){
			setTa_sEmbargo(getTa_sEmbargo());
		}else{			
			if(((OrdinarioCivilPenalBean)event.getObject()).getsEmbargo()!=""){
				setTa_sEmbargo(((OrdinarioCivilPenalBean)event.getObject()).getsEmbargo());
			}
		}
		
		if(ta_sQEmbargo!=null){
			setTa_sQEmbargo(getTa_sQEmbargo());
		}else{	
			if(((OrdinarioCivilPenalBean)event.getObject()).getsQEmbargo()!=""){
				setTa_sQEmbargo(((OrdinarioCivilPenalBean)event.getObject()).getsQEmbargo());
			}
		}
		
		if(ta_sjuicio!=null){
			setTa_sjuicio(getTa_sjuicio()); 
		}else{			
			if(((OrdinarioCivilPenalBean)event.getObject()).getSjuicio()!=""){
				setTa_sjuicio(((OrdinarioCivilPenalBean)event.getObject()).getSjuicio());
			}
		}
		
		if(ta_sOrganoJurid!=null){
			setTa_sOrganoJurid(getTa_sOrganoJurid()); 
		}else{	
			if(((OrdinarioCivilPenalBean)event.getObject()).getsOrganoJurid()!=""){
				setTa_sOrganoJurid(((OrdinarioCivilPenalBean)event.getObject()).getsOrganoJurid());
			}
		}
		
		System.out.println("Edicion del deyvt..... " + getTa_dfecha());
		System.out.println("Edicion del deyvt..... " + getTa_sAutoAdmin());
		System.out.println("Edicion del deyvt..... " + getTa_sContestacion());
		System.out.println("Edicion del deyvt..... " + getTa_sEmplazamiento());
		System.out.println("Edicion del deyvt..... " + getTa_sEmbargo());
		System.out.println("Edicion del deyvt..... " + getTa_sQEmbargo());
		System.out.println("Edicion del deyvt..... " + getTa_sjuicio());
		System.out.println("Edicion del deyvt..... " + getTa_sOrganoJurid());
		
		
			
		try {
			
			GuardarDemanda(91, 3, idFPr) ;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public void onRowCancel(){
		System.out.println("Cancelacion del deyvt.....");
	}
	
public void ActualizaCamposTab(Integer pidfproc, Integer pidopc, String pfecha, String pTexto) throws Exception{
		
		boolean resultadoActualizacion = 
				gestionaDemandaImpl.actualizaNewDemanda(pidfproc, pidopc, pfecha, pTexto);	          
         System.out.println("resultadoInsercion " + resultadoActualizacion);         
         System.out.println("Limpiando Valores de Demanda");
         
		 LimpiarVariables();	          
		 refreshPage();         
		 pagina();                  
	}
	 public void onCellEdit(CellEditEvent event) throws Exception {		 	
		 	
		 	//Object idCol = event.getColumn().getFooterText();
		 	Object idCol = event.getColumn().getClientId().replace("forma:tbl1:0:", "");
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            System.out.println("\n\n\nidColm:" + idCol  + " Old: " + oldValue + ", New:" + newValue);	        	        
	        	System.out.println("\n\nEntro... inche deyvittt!!!!" + idCol );
	        	if(idCol.equals(("idCol1").trim())){
	        		ActualizaCamposTab(209,1,"",newValue.toString());
	        	}		        	
	        	if(idCol.equals(("idCol2").trim())){
	        		ActualizaCamposTab(209,2,"",newValue.toString());
	        	}
	        	if(idCol.equals(("idCol3").trim())){
	        		ActualizaCamposTab(209,3,"",newValue.toString());
	        	}
	        	if(idCol.equals(("idCol4").trim())){
	        		ActualizaCamposTab(209,4,"",newValue.toString());
	        	}
	        	if(idCol.equals(("idCol5").trim())){
	        		ActualizaCamposTab(209,5,"",newValue.toString());
	        	}
	        	if(idCol.equals(("idCol6").trim())){
	        		ActualizaCamposTab(209,6,"",newValue.toString());
	        	}
	        	if(idCol.equals(("idCol7").trim())){
	        		ActualizaCamposTab(209,7,"",newValue.toString());
	        	}
	        	
	        
	        }
	        
	    }
	
	
	//------------------------Propiedades para la insertar la nueva demanda------------------------------------
	
	public Date tr_dfecha;		
	public Date getTr_dfecha() { return tr_dfecha;}
	public void setTr_dfecha(Date tr_dfecha) {this.tr_dfecha = tr_dfecha;}
	
	private String tr_sAutoAdmin;	
	public String getTr_sAutoAdmin() {return tr_sAutoAdmin;}
	public void setTr_sAutoAdmin(String tr_sAutoAdmin) {this.tr_sAutoAdmin = tr_sAutoAdmin;}

	private String tr_sjuicio;
	public String getTr_sjuicio() { return tr_sjuicio;}
	public void setTr_sjuicio(String tr_sjuicio) {this.tr_sjuicio = tr_sjuicio;}

	private String tr_sOrganoJurid;
	public String getTr_sOrganoJurid() { return tr_sOrganoJurid;}
	public void setTr_sOrganoJurid(String tr_sOrganoJurid) {this.tr_sOrganoJurid = tr_sOrganoJurid;}

	private String tr_sEmplazamiento;
	public String getTr_sEmplazamiento() {return tr_sEmplazamiento;}
	public void setTr_sEmplazamiento(String tr_sEmplazamiento) {this.tr_sEmplazamiento = tr_sEmplazamiento;}

	private String tr_sEmbargo; //(Si/No)
	public String getTr_sEmbargo() {return tr_sEmbargo;}
	public void setTr_sEmbargo(String tr_sEmbargo) {this.tr_sEmbargo = tr_sEmbargo;}

	private String tr_sQEmbargo;
	public String getTr_sQEmbargo() {return tr_sQEmbargo;}
	public void setTr_sQEmbargo(String tr_sQEmbargo) {this.tr_sQEmbargo = tr_sQEmbargo;}

	private String tr_sContestacion;	
	public String getTr_sContestacion() {return tr_sContestacion;}
	public void setTr_sContestacion(String tr_sContestacion) {this.tr_sContestacion = tr_sContestacion;}

	private String tr_sViaInter;
	public String getTr_sViaInter() { return tr_sViaInter;}
	public void setTr_sViaInter(String tr_sViaInter) {this.tr_sViaInter = tr_sViaInter;}

	@ManagedProperty(value="#{gestionaDemandaImpl}")
	private GestionaDemandaImpl gestionaDemandaImpl;
	
	public GestionaDemandaImpl getGestionaDemandaImpl() {
		return gestionaDemandaImpl;
	}
	public void setGestionaDemandaImpl(GestionaDemandaImpl gestionaDemandaImpl) {
		this.gestionaDemandaImpl = gestionaDemandaImpl;
	}
	public void GuardarDemanda(Integer idregdoc, Integer opcReg, Integer idFPr) throws Exception{ 							  
		
		DemandaInicialBean objDm = new DemandaInicialBean();
		
		if (idFPr == 0)
		{
			objDm.setIdfProc(idFPr);
			objDm.setIdregdoc(idregdoc); 
			objDm.setDfecha(getTr_dfecha());
			objDm.setsAutoAdmin(getTr_sAutoAdmin());
			objDm.setSjuicio(getTr_sjuicio());
			objDm.setsOrganoJurid(getTr_sOrganoJurid());
			objDm.setsEmplazamiento(getTr_sEmplazamiento());
			objDm.setsEmbargo(getTr_sEmbargo());
			objDm.setsQEmbargo(getTr_sQEmbargo());
			objDm.setsContestacion(getTr_sContestacion());
			objDm.setSidprocesal("2");
			objDm.setSidRegist(opcReg);
			objDm.setsViaInt(getTr_sViaInter());
		}		
		
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getIdfProc());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getIdregdoc());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getDfecha());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsAutoAdmin());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getSjuicio());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsOrganoJurid());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsEmplazamiento());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsEmbargo());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsQEmbargo());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsContestacion());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getIdregdoc());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getSidRegist());
		System.out.println("************* ==========  >>>>>>>>  " + objDm.getsViaInt());
		
				boolean resultadoInsercion = 
						gestionaDemandaImpl.insertaNewDemanda(objDm);	          
		         System.out.println("resultadoInsercion " + resultadoInsercion);         
		         System.out.println("Limpiando Valores de Demanda");

		         
         LimpiarVariables();	          
         refreshPage();         
         pagina();                  
	}

	public void doEnvId(Integer id) throws Exception{
		System.out.println(" == > " + id);		
		LimpiarVariables();
	}
	//Refrescar Pantalla.... by dgl
	protected void refreshPage() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String refreshpage = fc.getViewRoot().getViewId();
		System.out.println("  ***************  ========= >>>>>> " + refreshpage);
		ViewHandler ViewH =fc.getApplication().getViewHandler();
		System.out.println("  ***************  ========= >>>>>> " + ViewH);
		UIViewRoot UIV = ViewH.createView(fc,refreshpage);		
		UIV.setViewId(refreshpage);
		fc.setViewRoot(UIV);
		System.out.println("  ***************  ========= >>>>>> " + UIV);		
	}
	
	public void LimpiarVariables(){				
		tr_dfecha = null;
		tr_sAutoAdmin = null;
		tr_sContestacion=null;
		tr_sEmplazamiento=null;
		tr_sEmbargo=null;
		tr_sQEmbargo =null;
		tr_sjuicio = null;
		tr_sOrganoJurid = null;
		//tr_sViaInter = null;
		setTr_sAutoAdmin(null);
		System.out.println("  ***************  ====================  *************  " );
		System.out.println("  ***************  Formulario Clear  *************  " );		
								
	}
	
		
	//------------------------Propiedades para la actualizacion en la tabla de la nueva demanda-----------------------
	
	
	
	private Date ta_dfecha;
	public Date getTa_dfecha() {return ta_dfecha;}
	public void setTa_dfecha(Date ta_dfecha) {this.ta_dfecha = ta_dfecha;}
	
	private String ta_sAutoAdmin;
	public String getTa_sAutoAdmin() {return ta_sAutoAdmin;}	
	public void setTa_sAutoAdmin(String ta_sAutoAdmin) {this.ta_sAutoAdmin = ta_sAutoAdmin;}
	
	private String ta_sContestacion;
	public String getTa_sContestacion() {return ta_sContestacion;}
	public void setTa_sContestacion(String ta_sContestacion) {this.ta_sContestacion = ta_sContestacion;}
	
	private String ta_sEmplazamiento;
	public String getTa_sEmplazamiento() {return ta_sEmplazamiento;}
	public void setTa_sEmplazamiento(String ta_sEmplazamiento) {this.ta_sEmplazamiento = ta_sEmplazamiento;}
	
	private String ta_sEmbargo;
	public String getTa_sEmbargo() { return ta_sEmbargo;}
	public void setTa_sEmbargo(String ta_sEmbargo) { this.ta_sEmbargo = ta_sEmbargo;}
	
	private String ta_sQEmbargo;
	public String getTa_sQEmbargo() { return ta_sQEmbargo;}	
	public void setTa_sQEmbargo(String ta_sQEmbargo) {this.ta_sQEmbargo = ta_sQEmbargo;}
	
	private String ta_sjuicio;
	public String getTa_sjuicio() {return ta_sjuicio;}
	public void setTa_sjuicio(String ta_sjuicio) {this.ta_sjuicio = ta_sjuicio;}
	
	private String ta_sOrganoJurid;
	public String getTa_sOrganoJurid() {return ta_sOrganoJurid;}
	public void setTa_sOrganoJurid(String ta_sOrganoJurid) {this.ta_sOrganoJurid = ta_sOrganoJurid;}

	
}

