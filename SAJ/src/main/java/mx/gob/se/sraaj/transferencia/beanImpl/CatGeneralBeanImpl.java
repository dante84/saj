package mx.gob.se.sraaj.transferencia.beanImpl;

import java.io.Serializable;
import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;

public class CatGeneralBeanImpl implements Serializable {		
	
	   private static final long serialVersionUID = 1L;
	   private String sIdCat;
	   private String sDescripcionCat;
	   private int iActivo;
	   private int idMas;
	   private int idCir;
	   private int iEstados;
	   
	   private GestionaCatDAOImpl gestionaCatDAOImpl;
	
	   public String getsIdCat() {return sIdCat;}
	   public void setsIdCat(String sIdCat) {this.sIdCat = sIdCat;}
	
	   public String getsDescripcionCat() {return sDescripcionCat;}
	   public void setsDescripcionCat(String sDescripcionCat) {this.sDescripcionCat = sDescripcionCat;}
	
	   public int getiActivo() {return iActivo;}
	   public void setiActivo(int iActivo) {this.iActivo = iActivo;}
 	
	   public int getIdMas() {return idMas;}
	   public void setIdMas(int idMas) {this.idMas = idMas;}
	
	   public int getIdCir() {return idCir;}
	   public void setIdCir(int idCir) {this.idCir = idCir;}
	
	   public int getiEstados() { return iEstados; }
	   
	   public void setiEstados(int iEstados) { this.iEstados = iEstados; }
	   	
	   public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
	   
	   public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	   	     	
	   public List<CatGeneralBean> obtieneJuicios() throws Exception {		   		  		      
		   
		      return gestionaCatDAOImpl.obtieneTipoJuicio();
		
	   }
		
}
