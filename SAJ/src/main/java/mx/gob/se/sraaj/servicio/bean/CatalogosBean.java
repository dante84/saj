package mx.gob.se.sraaj.servicio.bean;

public class CatalogosBean {

	private int iIdCatalogo;
	private String sDesCatalogo, sCreated_Date, sCreated_by;
	
	public CatalogosBean (int iIdCatalogo, String sDescCatalogo, String sCreated_Date, String sCreated_by){
		super ();
		this.iIdCatalogo = iIdCatalogo;
		this.sDesCatalogo = sDescCatalogo;
		this.sCreated_Date = sCreated_Date;
		this.sCreated_by = sCreated_by;
	}

	public int getiIdCatalogo() {return iIdCatalogo;}
	public void setiIdCatalogo(int iIdCatalogo) {this.iIdCatalogo = iIdCatalogo;}

	public String getsDesCatalogo() {return sDesCatalogo;}
	public void setsDesCatalogo(String sDesCatalogo) {this.sDesCatalogo = sDesCatalogo;}

	public String getsCreated_Date() {return sCreated_Date;}
	public void setsCreated_Date(String sCreated_Date) {this.sCreated_Date = sCreated_Date;}

	public String getsCreated_by() {return sCreated_by;}
	public void setsCreated_by(String sCreated_by) {this.sCreated_by = sCreated_by;}
}
