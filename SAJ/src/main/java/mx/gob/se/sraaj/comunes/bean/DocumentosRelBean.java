package mx.gob.se.sraaj.comunes.bean;

import java.sql.Date;

public class DocumentosRelBean 
{
	Integer idregdoc;
	Integer numreg;
	String fecha;
    String hora;
	String numjuicio;
	String organoj;
	String instruccion;
	String nombrecompleto;
	String quejoso;
	String descripcionautoridad;
	String atendido;
    String averiguacionprevia_causapenal;
	String indiciado;
	String numoficio;
	Date fecoficio;
	Date fechadenuncia;
	String edoprocesal;
	Integer numexp;
	String Materia;
	
	public Integer getNumexp() {
		return numexp;
	}
	public void setNumexp(Integer numexp) {
		this.numexp = numexp;
	}
	public Integer getIdregdoc() {
		return idregdoc;
	}
	public void setIdregdoc(Integer idregdoc) {
		this.idregdoc = idregdoc;
	}
	public Integer getNumreg() {
		return numreg;
	}
	public void setNumreg(Integer numreg) {
		this.numreg = numreg;
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
	public String getNumjuicio() {
		return numjuicio;
	}
	public void setNumjuicio(String numjuicio) {
		this.numjuicio = numjuicio;
	}
	public String getOrganoj() {
		return organoj;
	}
	public void setOrganoj(String organoj) {
		this.organoj = organoj;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getQuejoso() {
		return quejoso;
	}
	public void setQuejoso(String quejoso) {
		this.quejoso = quejoso;
	}
	public String getDescripcionautoridad() {
		return descripcionautoridad;
	}
	public void setDescripcionautoridad(String descripcionautoridad) {
		this.descripcionautoridad = descripcionautoridad;
	}
	public String getAtendido() {
		return atendido;
	}
	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}
	public String getAveriguacionprevia_causapenal() {
		return averiguacionprevia_causapenal;
	}
	public void setAveriguacionprevia_causapenal(
			String averiguacionprevia_causapenal) {
		this.averiguacionprevia_causapenal = averiguacionprevia_causapenal;
	}
	public String getIndiciado() {
		return indiciado;
	}
	public void setIndiciado(String indiciado) {
		this.indiciado = indiciado;
	}
	public String getNumoficio() {
		return numoficio;
	}
	public void setNumoficio(String numoficio) {
		this.numoficio = numoficio;
	}
	public Date getFecoficio() {
		return fecoficio;
	}
	public void setFecoficio(Date fecoficio) {
		this.fecoficio = fecoficio;
	}
	public Date getFechadenuncia() {
		return fechadenuncia;
	}
	public void setFechadenuncia(Date fechadenuncia) {
		this.fechadenuncia = fechadenuncia;
	}
	public String getEdoprocesal() {
		return edoprocesal;
	}
	public void setEdoprocesal(String edoprocesal) {
		this.edoprocesal = edoprocesal;
	}
	public String getMateria() {
		return Materia;
	}
	public void setMateria(String materia) {
		Materia = materia;
	}
	
	public String getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
}
