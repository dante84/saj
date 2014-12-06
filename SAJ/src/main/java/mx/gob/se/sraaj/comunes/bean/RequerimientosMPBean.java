package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class RequerimientosMPBean 
{
	private Integer idRequerimiento;
	private Date fecha;
	private String oficio;
	private String requerimiento;
	private String desahogo;
	private String observaciones;
	private Integer idregdoc;
	
	public Integer getIdRequerimiento() {
		return idRequerimiento;
	}
	public void setIdRequerimiento(Integer idRequerimiento) {
		this.idRequerimiento = idRequerimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getDesahogo() {
		return desahogo;
	}
	public void setDesahogo(String desahogo) {
		this.desahogo = desahogo;
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
