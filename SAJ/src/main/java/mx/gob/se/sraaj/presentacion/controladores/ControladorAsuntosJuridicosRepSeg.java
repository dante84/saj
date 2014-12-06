package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.AsuntosJuridicosRepSeg;
import mx.gob.se.sraaj.persistencia.daoImpl.AsuntosJuridicosRepSegDAOImpl;

@ManagedBean(name = "CAsuntosJuridicos2")
@SessionScoped

public class ControladorAsuntosJuridicosRepSeg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{asuntosJuridicosRepSegDAOImpl}")
	
	//Lista del Seguimiento
	private AsuntosJuridicosRepSegDAOImpl asuntosJuridicosRepSegDAOImpl;		
	private List<AsuntosJuridicosRepSeg> ltSeguimiento;
	
	//Getter & Setters	
	public List<AsuntosJuridicosRepSeg> getLtSeguimiento() {return ltSeguimiento;}
	public void setLtSeguimiento(List<AsuntosJuridicosRepSeg> ltSeguimiento) {this.ltSeguimiento = ltSeguimiento;}
	
	public AsuntosJuridicosRepSegDAOImpl getAsuntosJuridicosRepSegDAOImpl() {return asuntosJuridicosRepSegDAOImpl;}
	public void setAsuntosJuridicosRepSegDAOImpl( AsuntosJuridicosRepSegDAOImpl asuntosJuridicosRepSegDAOImpl) {this.asuntosJuridicosRepSegDAOImpl = asuntosJuridicosRepSegDAOImpl;}
	
	//Funcion General para Mostrar Amparos Foraneos
	public String doMuestraAmpForaneos() {		    
	      String ruta = "asuntosJRDMinas";
	      System.out.println("Muestra seguimiento Amparos Foraneos");		
	      try{						          		    		    	 
	    	  setLtSeguimiento(asuntosJuridicosRepSegDAOImpl.buscarSegAmpForaneo());	    	
	      }catch (Exception ex){ 
	    	  ex.printStackTrace();
	    	  System.out.println(ex);
	      }			
	      return ruta;
    }
	
	public String doEnvCons(){			
		String ruta="asuntosJRDMinas";
			System.out.println("Pimer Evento... Consultar Documento");	
		return ruta;
	}
	public String doEnvTurn(){			
		String ruta="asuntosJRDMinas";
			System.out.println("Segundo Evento... Turnar Documento");	
		return ruta;
		}
	 
	 //Connection con = ds.getConnection();
	 //PreparedStatement bitacora = con.prepareStatement("SELECT * FROM bitacora");
	

}
