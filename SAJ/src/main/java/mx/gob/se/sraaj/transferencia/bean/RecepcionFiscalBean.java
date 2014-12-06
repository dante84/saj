package mx.gob.se.sraaj.transferencia.bean;

import java.util.Date;

public class RecepcionFiscalBean {

	private Date dFechaRegistro, dFechaDespacho, dFechaConvencional,dFechaReal;
	private String sNumerJucio, sActorDemandado;
	private int iIdDocumentos, iNumeroExpediente;
	
	public Date getdFechaRegistro() {return dFechaRegistro;}
	public void setdFechaRegistro(Date dFechaRegistro) {this.dFechaRegistro = dFechaRegistro;}
	
	public Date getdFechaDespacho() {return dFechaDespacho;}
	public void setdFechaDespacho(Date dFechaDespacho) {this.dFechaDespacho = dFechaDespacho;}
	
	public Date getdFechaConvencional() {return dFechaConvencional;}
	public void setdFechaConvencional(Date dFechaConvencional) {this.dFechaConvencional = dFechaConvencional;}
	
	public Date getdFechaReal() {return dFechaReal;}
	public void setdFechaReal(Date dFechaReal) {this.dFechaReal = dFechaReal;}

	public String getsNumerJucio() {return sNumerJucio;}
	public void setsNumerJucio(String sNumerJucio) {this.sNumerJucio = sNumerJucio;}
	
	public String getsActorDemandado() {return sActorDemandado;}
	public void setsActorDemandado(String sActorDemandado) {this.sActorDemandado = sActorDemandado;}
	
	public int getiIdDocumentos() {return iIdDocumentos;}
	public void setiIdDocumentos(int iIdDocumentos) {this.iIdDocumentos = iIdDocumentos;}
	
	public int getiNumeroExpediente() {return iNumeroExpediente;}
	public void setiNumeroExpediente(int iNumeroExpediente) {this.iNumeroExpediente = iNumeroExpediente;}
	
	
}
