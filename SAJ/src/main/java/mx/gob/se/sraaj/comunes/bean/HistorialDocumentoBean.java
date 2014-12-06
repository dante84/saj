package mx.gob.se.sraaj.comunes.bean;

import java.sql.Timestamp;

public class HistorialDocumentoBean 
{
	private Timestamp fecha;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}
 