package mx.gob.se.sraaj.comunes.bean;

import java.sql.Date;

public class SeguimientoBean 
{
	Integer idtipojuicio;
	Integer numreg;
	String numjuicio;
	Integer numexpediente;
	String juiciodeamparo;
    String fecha;
    String hora;
    Date fecvencimiento;
    Date fecconvencional;
    Date fecregistro;
    String ac_de_pr_qu;
    String nombrecompleto;
    String descripcionautoridad;
    String descremitente;
    String remitente;
    String descjuzgado;
    String asunto;
    String instruccion;
    String descripcion;
    String descmateria;
    String averiguacionprevia_causapenal;
    Integer idregDoc;
    Integer idmateria;
    Integer idtribunal;
    Integer acuseRecivo;
    
    //public SeguimientoBean(){ setAcuseRecivo(new Integer(0)); }
    
	public Integer getIdtribunal() {
		return idtribunal;
	}
	public void setIdtribunal(Integer idtribunal) {
		this.idtribunal = idtribunal;
	}
	public Integer getIdregDoc() {
		return idregDoc;
	}
	public void setIdregDoc(Integer idregDoc) {
		this.idregDoc = idregDoc;
	}
	public Integer getIdtipojuicio() {
		return idtipojuicio;
	}
	public void setIdtipojuicio(Integer idtipojuicio) {
		this.idtipojuicio = idtipojuicio;
	}
	public Integer getNumreg() {
		return numreg;
	}
	public void setNumreg(Integer numreg) {
		this.numreg = numreg;
	}
	public String getNumjuicio() {
		return numjuicio;
	}
	public void setNumjuicio(String numjuicio) {
		this.numjuicio = numjuicio;
	}
	public Integer getNumexpediente() {
		return numexpediente;
	}
	public void setNumexpediente(Integer numexpediente) {
		this.numexpediente = numexpediente;
	}
	public String getJuiciodeamparo() {
		return juiciodeamparo;
	}
	public void setJuiciodeamparo(String juiciodeamparo) {
		this.juiciodeamparo = juiciodeamparo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Date getFecvencimiento() {
		return fecvencimiento;
	}
	public void setFecvencimiento(java.util.Date fecvencimiento) {
		this.fecvencimiento = (Date) fecvencimiento;
	}
	public Date getFecconvencional() {
		return fecconvencional;
	}
	public void setFecconvencional(java.util.Date fecconvencional) {
		this.fecconvencional = (Date) fecconvencional;
	}
	public Date getFecregistro() {
		return fecregistro;
	}
	public void setFecregistro(Date fecregistro) {
		this.fecregistro = fecregistro;
	}
	public String getAc_de_pr_qu() {
		return ac_de_pr_qu;
	}
	public void setAc_de_pr_qu(String ac_de_pr_qu) {
		this.ac_de_pr_qu = ac_de_pr_qu;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getDescripcionautoridad() {
		return descripcionautoridad;
	}
	public void setDescripcionautoridad(String descripcionautoridad) {
		this.descripcionautoridad = descripcionautoridad;
	}
	public String getDescremitente() {
		return descremitente;
	}
	public void setDescremitente(String descremitente) {
		this.descremitente = descremitente;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getDescjuzgado() {
		return descjuzgado;
	}
	public void setDescjuzgado(String descjuzgado) {
		this.descjuzgado = descjuzgado;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescmateria() {
		return descmateria;
	}
	public void setDescmateria(String descmateria) {
		this.descmateria = descmateria;
	}
	public String getAveriguacionprevia_causapenal() {
		return averiguacionprevia_causapenal;
	}
	public void setAveriguacionprevia_causapenal(
			String averiguacionprevia_causapenal) {
		this.averiguacionprevia_causapenal = averiguacionprevia_causapenal;
	}
	public Integer getIdmateria() {
		return idmateria;
	}
	public void setIdmateria(Integer idmateria) {
		this.idmateria = idmateria;
	}
	public Integer getAcuseRecivo() {
		return acuseRecivo;
	}
	public void setAcuseRecivo(Integer acuseRecivo) {
		this.acuseRecivo = acuseRecivo;
	}

}
