package mx.gob.se.sraaj.comunes.bean;

import java.sql.Date;

public class RecepcionLaboralBean {
	
	private int iIdRegDocumentos;
	private int iNumeroRegistro;
	private String sFechaRecepcion;
	private String sPromovente;
	private Date dFechaVencimiento;
	private Date dFechaConvecional;
	private int iIdMateria;
	private int iIdTipoJuicio;
	private String sDescMateria;
	private String sDescTipoJuicio;
	private Date dFechaOficio;
	private int iNumeroExpediente;
	private int iNumeroJuicio;
	private int iIdRemitente;	

	public int getiIdRegDocumentos() { return iIdRegDocumentos; }
	public void setiIdRegDocumentos(int iIdRegDocumentos) { this.iIdRegDocumentos = iIdRegDocumentos; }
	
	public int getiIdTipoJuicio() { return iIdTipoJuicio; }
	public void setiIdTipoJuicio(int iIdTipoJuicio) { this.iIdTipoJuicio = iIdTipoJuicio; }
	
	public int getiNumeroJuicio() { return iNumeroJuicio; }
	public void setiNumeroJuicio(int iNumeroJuicio) { this.iNumeroJuicio = iNumeroJuicio; }
	
	public Date getdFechaOficio() { return dFechaOficio; }
	public void setdFechaOficio(Date dFechaOficio) { this.dFechaOficio = dFechaOficio; }
	
	public int getiIdRemitente() { return iIdRemitente; }
	public void setiIdRemitente(int iIdRemitente) { this.iIdRemitente = iIdRemitente; }
	
	public int getiNumeroRegistro() { return iNumeroRegistro; }
	public void setiNumeroRegistro(int iNumeroRegistro) { this.iNumeroRegistro = iNumeroRegistro; }
	
	public int getiNumeroExpediente() { return iNumeroExpediente; }
	public void setiNumeroExpediente(int iNumeroExpediente) { this.iNumeroExpediente = iNumeroExpediente; }
	
	public String getsFechaRecepcion() { return sFechaRecepcion; }
	public void setsFechaRecepcion(String sFechaRecepcion) { this.sFechaRecepcion = sFechaRecepcion; }
	
	public String getsPromovente() { return sPromovente; }
	public void setsPromovente(String sPromovente) { this.sPromovente = sPromovente; }
	
	public int getiIdMateria() { return iIdMateria; }
	public void setiIdMateria(int iIdMateria) { this.iIdMateria = iIdMateria; }
	
	public String getsDescMateria() { return sDescMateria; }
	public void setsDescMateria(String sDescMateria) { this.sDescMateria = sDescMateria; }
	
	public Date getdFechaConvecional() { return dFechaConvecional; }
	public void setdFechaConvecional(Date dFechaConvecional) { this.dFechaConvecional = dFechaConvecional; }
	
	public Date getdFechaVencimiento() { return dFechaVencimiento; }
	public void setdFechaVencimiento(Date dFechaVencimiento) { this.dFechaVencimiento = dFechaVencimiento; }
	
	public String getsDescTipoJuicio() { return sDescTipoJuicio; }
	public void setsDescTipoJuicio(String sDescTipoJuicio) { this.sDescTipoJuicio = sDescTipoJuicio; }
}
