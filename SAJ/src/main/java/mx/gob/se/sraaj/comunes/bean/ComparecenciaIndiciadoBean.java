package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class ComparecenciaIndiciadoBean 
{
	private Integer idcomparecencia;
	private Date fecha;
	private String pruebas;
	private String observaciones;
	private Integer idregdoc;
	
	
	public Integer getIdcomparecencia() {
		return idcomparecencia;
	}
	public void setIdcomparecencia(Integer idcomparecencia) {
		this.idcomparecencia = idcomparecencia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getPruebas() {
		return pruebas;
	}
	public void setPruebas(String pruebas) {
		this.pruebas = pruebas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getIdregdoc() {
		return idregdoc;
	}
	public void setIdregdoc(Integer idregdoc) {
		this.idregdoc = idregdoc;
	}
}
