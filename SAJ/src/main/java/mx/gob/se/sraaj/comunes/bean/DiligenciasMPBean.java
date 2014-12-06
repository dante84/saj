package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class DiligenciasMPBean 
{
	private Integer iddiligencias;
	private Date fecha;
	private String diligencias;
	private String observaciones;
	private Integer idregdoc;
	
	public Integer getIddiligencias() {
		return iddiligencias;
	}
	public void setIddiligencias(Integer iddiligencias) {
		this.iddiligencias = iddiligencias;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDiligencias() {
		return diligencias;
	}
	public void setDiligencias(String diligencias) {
		this.diligencias = diligencias;
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
