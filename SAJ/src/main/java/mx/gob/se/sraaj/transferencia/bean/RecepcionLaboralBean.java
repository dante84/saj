package mx.gob.se.sraaj.transferencia.bean;

import java.util.Date;

public class RecepcionLaboralBean {

	private int iIdDocumentos;
	private Date dFechaRegistro, dFechaReal;
	private String sQuejoso;
	
	public int getiIdDocumentos() {return iIdDocumentos;}
	public void setiIdDocumentos(int iIdDocumentos) {this.iIdDocumentos = iIdDocumentos;}
	
	public Date getdFechaRegistro() {return dFechaRegistro;}
	public void setdFechaRegistro(Date dFechaRegistro) {this.dFechaRegistro = dFechaRegistro;}
	
	public Date getdFechaReal() {return dFechaReal;}
	public void setdFechaReal(Date dFechaReal) {this.dFechaReal = dFechaReal;}
	
	public String getsQuejoso() {return sQuejoso;}
	public void setsQuejoso(String sQuejoso) {this.sQuejoso = sQuejoso;}
	
	
}
