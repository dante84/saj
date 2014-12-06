package mx.gob.se.sraaj.comunes.bean;

import java.util.Date;

public class DenunciaHechosBean 
{
	private Integer iddenuncia;
	private Date Fecha;
	private String oficio;
	private String averiguacion;
	private String ministerio;
	private String ratifica;
	private Date fechaRatificacion;
	private Integer idregdoc;
	
	public Integer getIddenuncia() {
		return iddenuncia;
	}
	public void setIddenuncia(Integer iddenuncia) {
		this.iddenuncia = iddenuncia;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getAveriguacion() {
		return averiguacion;
	}
	public void setAveriguacion(String averiguacion) {
		this.averiguacion = averiguacion;
	}
	public String getMinisterio() {
		return ministerio;
	}
	public void setMinisterio(String ministerio) {
		this.ministerio = ministerio;
	}
	public String getRatifica() {
		return ratifica;
	}
	public void setRatifica(String ratifica) {
		this.ratifica = ratifica;
	}
	public Date getFechaRatificacion() {
		return fechaRatificacion;
	}
	public void setFechaRatificacion(Date fechaRatificacion) {
		this.fechaRatificacion = fechaRatificacion;
	}
	public Integer getIdregdoc() {
		return idregdoc;
	}
	public void setIdregdoc(Integer idregdoc) {
		this.idregdoc = idregdoc;
	}
}
