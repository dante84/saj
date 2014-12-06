package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class MediosPruebaBean 
{
	private Integer idmediosPrueba;
	private Date fecha;
	private String testimoniales;
	private String periciales;
	private String documentales;
	private String inspeccion;
	private String otra;
	private String observaciones;
	private Integer idregdoc;
	
	public Integer getIdmediosPrueba() {
		return idmediosPrueba;
	}
	public void setIdmediosPrueba(Integer idmediosPrueba) {
		this.idmediosPrueba = idmediosPrueba;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTestimoniales() {
		return testimoniales;
	}
	public void setTestimoniales(String testimoniales) {
		this.testimoniales = testimoniales;
	}
	public String getPericiales() {
		return periciales;
	}
	public void setPericiales(String periciales) {
		this.periciales = periciales;
	}
	public String getDocumentales() {
		return documentales;
	}
	public void setDocumentales(String documentales) {
		this.documentales = documentales;
	}
	public String getInspeccion() {
		return inspeccion;
	}
	public void setInspeccion(String inspeccion) {
		this.inspeccion = inspeccion;
	}
	public String getOtra() {
		return otra;
	}
	public void setOtra(String otra) {
		this.otra = otra;
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
