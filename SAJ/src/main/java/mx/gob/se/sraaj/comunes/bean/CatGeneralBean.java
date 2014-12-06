package mx.gob.se.sraaj.comunes.bean;

public class CatGeneralBean {
	 
	   private int sIdCat;
	   private String sDescripcionCat;
	   private int iActivo;
	   private int idMas;
	   private int idCir;
	   private int iEstados;
	   private String sDescripcionCat2;	   
	   

	   public CatGeneralBean(){
		      setsIdCat(0);
	   }

	
	   public int getsIdCat() { return sIdCat; }
	   public void setsIdCat(int sIdCat) { this.sIdCat = sIdCat; }
	   
	   public String getsDescripcionCat() { return sDescripcionCat; }
	   public void setsDescripcionCat(String sDescripcionCat) { this.sDescripcionCat = sDescripcionCat;	}
	   
	   public int getiActivo() { return iActivo; }
	   public void setiActivo(int iActivo) { this.iActivo = iActivo; }
	
	   public int getIdMas() { return idMas; }	   
	   public void setIdMas(int idMas) { this.idMas = idMas; }
	   
	   public int getIdCir() { return idCir; } 	   
	   public void setIdCir(int idCir) { this.idCir = idCir; }
	   
	   public int getiEstados() { return iEstados; } 	   
	   public void setiEstados(int iEstados) { this.iEstados = iEstados; }
	   
	   public String getsDescripcionCat2() {return sDescripcionCat2;}
	   public void setsDescripcionCat2(String sDescripcionCat2) {this.sDescripcionCat2 = sDescripcionCat2;}
	   

}
