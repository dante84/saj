package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class OrdinarioCivilPenalBean {
	
	private int idRegDoc;
	private int idF_Procesal;
	private String sOficio;
	private Date dFecha;
	private String sRequerimientoPGR;
	private String sDesc_Procesal;
	
	public int getIdRegDoc() { return idRegDoc; }
	public void setIdRegDoc(int idRegDoc) { this.idRegDoc = idRegDoc; }
	
	public int getIdF_Procesal() { return idF_Procesal; }
	public void setIdF_Procesal(int idF_Procesal) { this.idF_Procesal = idF_Procesal; }

	public String getsOficio() { return sOficio; }
	public void setsOficio(String sOficio) { this.sOficio = sOficio; }

	public Date getdFecha() { return dFecha; }
	public void setdFecha(Date dFecha) { this.dFecha = dFecha; }
	
	public String getsRequerimientoPGR() { return sRequerimientoPGR; }
	public void setsRequerimientoPGR(String sRequerimientoPGR) { this.sRequerimientoPGR = sRequerimientoPGR; }
	
	public String getsDesc_Procesal() { return sDesc_Procesal; }
	public void setsDesc_Procesal(String sDesc_Procesal) { this.sDesc_Procesal = sDesc_Procesal; }
	
	//Propiedades dgl "Demanda Inical y Contestacion"

	//idRegDoc
	//dFecha
	
	private String sAutoAdmin;
	public String getsAutoAdmin() { return sAutoAdmin; }
	public void setsAutoAdmin(String sAutoAdmin) { this.sAutoAdmin = sAutoAdmin;}

	private String sjuicio;
	public String getSjuicio() { return sjuicio; }
	public void setSjuicio(String sjuicio) {this.sjuicio = sjuicio; }

	private String sOrganoJurid;
	public String getsOrganoJurid() {return sOrganoJurid;}
	public void setsOrganoJurid(String sOrganoJurid) {this.sOrganoJurid = sOrganoJurid;}

	private String sEmplazamiento;
	public String getsEmplazamiento() {return sEmplazamiento;}
	public void setsEmplazamiento(String sEmplazamiento) {this.sEmplazamiento = sEmplazamiento;}

	private String sEmbargo; //(Si/No)
	public String getsEmbargo() {return sEmbargo;}
	public void setsEmbargo(String sEmbargo) { this.sEmbargo = sEmbargo;}

	private String sQEmbargo;
	public String getsQEmbargo() { return sQEmbargo;}
	public void setsQEmbargo(String sQEmbargo) { this.sQEmbargo = sQEmbargo; }

	private String sContestacion;
	public String getsContestacion() { return sContestacion; }
	public void setsContestacion(String sContestacion) { this.sContestacion = sContestacion; }				 	
	
	private String sViaInter;
	public String getsViaInter() {return sViaInter;}	
	public void setsViaInter(String sViaInter) {this.sViaInter = sViaInter;}
}
