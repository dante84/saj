package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class DemandaInicialBean {
	
	public int idfProc;
	public int getIdfProc() {return idfProc;}
	public void setIdfProc(int idfProc) {this.idfProc = idfProc;}

	public int idregdoc;
	public int getIdregdoc() { return idregdoc;}
	public void setIdregdoc(int idregdoc) { this.idregdoc = idregdoc;}

	public Date dfecha;	
	public Date getDfecha() {return dfecha;}
	public void setDfecha(Date dfecha) {this.dfecha = dfecha;}

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
	
	private String sidprocesal;
	public String getSidprocesal() {return sidprocesal;}
	public void setSidprocesal(String sidprocesal) { this.sidprocesal = sidprocesal;}

	private Integer sidRegist;
	public Integer getSidRegist() {return sidRegist;}
	public void setSidRegist(Integer sidRegist) {this.sidRegist = sidRegist;}
	
	private String sViaInt;
	public String getsViaInt() {return sViaInt;}
	public void setsViaInt(String sViaInt) { this.sViaInt = sViaInt;}
	
	
}
