package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaTurnadoImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.TurnadoBeanImpl;

@ManagedBean(name="CTurnados")
@SessionScoped

public class ControladorTurnado implements Serializable {
	

	private static final long serialVersionUID = 1L;
		
	private String sNomTurnado;	
	public String getsNomTurnado() {return sNomTurnado;}
	public void setsNomTurnado(String sNomTurnado) {this.sNomTurnado = sNomTurnado;}
	
	private Integer sidTurnadoDocs;
	public Integer getSidTurnadoDocs() {return sidTurnadoDocs;}
	public void setSidTurnadoDocs(Integer sidTurnadoDocs) { this.sidTurnadoDocs = sidTurnadoDocs;}

	private Integer sidTurnado;	
	public Integer getSidTurnado() {return sidTurnado;}
	public void setSidTurnado(Integer sidTurnado) {this.sidTurnado = sidTurnado;}

	private Integer sidRegDoc;			
	public Integer getSidRegDoc() {return sidRegDoc;}
	public void setSidRegDoc(Integer sidRegDoc) {this.sidRegDoc = sidRegDoc;}

	private Boolean sint1;  	
	public Boolean getSint1() {return sint1;}
	public void setSint1(Boolean sint1) {this.sint1 = sint1;}

	private Boolean sint2;	
	public Boolean getSint2() {return sint2;}
	public void setSint2(Boolean sint2) {this.sint2 = sint2;}
	
	private Boolean sint3;
	public Boolean getSint3() {return sint3;}
	public void setSint3(Boolean sint3) {this.sint3 = sint3;}

	private Boolean sint4;
	public Boolean getSint4() {return sint4;}
	public void setSint4(Boolean sint4) {this.sint4 = sint4;}

	private Boolean sint5;
	public Boolean getSint5() {return sint5;}
	public void setSint5(Boolean sint5) {this.sint5 = sint5;}

	private Boolean sint6;
	public Boolean getSint6() {return sint6;}
	public void setSint6(Boolean sint6) {this.sint6 = sint6;}

	private Boolean sint7;
	public Boolean getSint7() {return sint7;}
	public void setSint7(Boolean sint7) {this.sint7 = sint7;}

	private Boolean sint8;
	public Boolean getSint8() {return sint8;}
	public void setSint8(Boolean sint8) {this.sint8 = sint8;}

	private Boolean sint9;
	public Boolean getSint9() {return sint9;}
	public void setSint9(Boolean sint9) {this.sint9 = sint9;}

	private Boolean sint10;		
	public Boolean getSint10() {return sint10;}
	public void setSint10(Boolean sint10) {this.sint10 = sint10;}

	private String sespecifique;
	public String getSespecifique() {return sespecifique;}
	public void setSespecifique(String sespecifique) {this.sespecifique = sespecifique;}

	private String sactoreclamado;	
	public String getSactoreclamado() {return sactoreclamado;}
	public void setSactoreclamado(String sactoreclamado) {this.sactoreclamado = sactoreclamado;}
	
	private int sacuserec;				
	public int getSacuserec() {return sacuserec;}
	public void setSacuserec(int sacuserec) { this.sacuserec = sacuserec;}

	//Primeras Funciones
	private String Turnado;
	public String getTurnado() { return Turnado; }
	public void setTurnado(String turnado) { Turnado = turnado;}
	
	private TurnadoBeanImpl Turnad;	
	public TurnadoBeanImpl getTurnad() { return Turnad;}
	public void setTurnad(TurnadoBeanImpl turnad) {Turnad = turnad;}

	private  List<TurnadoBeanImpl> Turnados;	 		
	public List<TurnadoBeanImpl> getTurnados() { return Turnados;}
	public void setTurnados(List<TurnadoBeanImpl> turnados) { Turnados = turnados;}
	
	@ManagedProperty(value="#{gestionaTurnadoImpl}")
	private GestionaTurnadoImpl gestionaTurnadoImpl;	
	public GestionaTurnadoImpl getGestionaTurnadoImpl() {return gestionaTurnadoImpl;}
	public void setGestionaTurnadoImpl(GestionaTurnadoImpl gestionaTurnadoImpl) { this.gestionaTurnadoImpl = gestionaTurnadoImpl;}
	
	
		
	public void doMuestraTurnados() throws Exception { 
		setTurnados(gestionaTurnadoImpl.obtieneTurnado());	
	}	
	
	public void doPruebaTurnado() throws Exception{		
		System.out.println("doPruebaTurnados.... ");		
	}
			
	public void doEnvId(Integer id) throws Exception{
		System.out.println(" == > " + id);
		setSidRegDoc(id);
		LimpiarVariables();
	}

	
	public void InsertaRegistroTurnado() throws Exception{
		System.out.println("Insertar Registro Turnado...");
		
		try{
			TurnadoBeanImpl tur = new TurnadoBeanImpl();
			//tur.setIidTurnardoc(0);
			tur.setIidTurnado(10);
			tur.setIidRegdoc(getSidRegDoc());			
			tur.setIinst1(getSint1());
			tur.setIinst2(getSint2());
			tur.setIinst3(getSint3());
			tur.setIinst4(getSint4());
			tur.setIinst5(getSint5());
			tur.setIinst6(getSint6());
			tur.setIinst7(getSint7());
			tur.setIinst8(getSint8());
			tur.setIinst9(getSint9());
			tur.setIinst10(false);
			tur.setsEspecifique(getSespecifique());
			tur.setsActoreclamado(getSactoreclamado());;
			tur.setsAcuserecibo(1);			
			
			//Impresion de las propiedades... 
			
			System.out.println(" == > " + tur.getIidRegdoc());
			System.out.println(" == > " + tur.getIidTurnado());
			System.out.println(" == > " + tur.getIidRegdoc());
			System.out.println(" == > " + tur.getIinst1());
			System.out.println(" == > " + tur.getIinst2());
			System.out.println(" == > " + tur.getIinst3());
			System.out.println(" == > " + tur.getIinst4());
			System.out.println(" == > " + tur.getIinst5());
			System.out.println(" == > " + tur.getIinst6());
			System.out.println(" == > " + tur.getIinst7());
			System.out.println(" == > " + tur.getIinst8());
			System.out.println(" == > " + tur.getIinst9());
			System.out.println(" == > " + tur.getIinst10());			
			System.out.println(" == > " + tur.getsEspecifique());			
	        System.out.println(" == > " + tur.getsActoreclamado());
	        System.out.println(" == > " + tur.getsAcuserecibo());
	        		
	        boolean resultadoInsercion = 
	        		gestionaTurnadoImpl.insertaNewTurnado(tur);	          
	         System.out.println("resultadoInsercion " + resultadoInsercion);
	         
	         System.out.println("Limpiando Valores del Turnado");	         
	         LimpiarVariables();	          
	         System.out.println("__________________>>>>>>>" + sespecifique);
		}
		catch(Exception exp){
			
			System.out.println(" ======== >>>>>  " + exp);
			
		}
		
		
		
	}
	
	public void LimpiarVariables(){		
		sNomTurnado = null;
		sidTurnadoDocs = null;
		sidTurnado = null;		
		sint1 = false;
		sint2 = false;
		sint3 = false;
		sint4 = false;
		sint5 = false;		
		sint6 = false;
		sint7 = false;
		sint8 = false;
		sint9 = false;
		sint10 = false;
		sespecifique = null;
		sactoreclamado = null;		
		sacuserec = 1;		
		
	}
	
	
	
}
