package mx.gob.se.sraaj.comunes.bean;

public class NuevoDocumentoBean {
	
	   private String idJuicio; 
       private int numeroOficio;          
       private String fechaOficio;          
       private int numeroJuicio;
       private int numeroRegistro;
       private String expedidor;
       private String idUser;
       private String suspencion;            
       private String fechaNotificacion;
       private String sintesi;
       
	   public String getIdJuicio() { return idJuicio; }
	   
	   public void setIdJuicio(String idJuicio) { this.idJuicio = idJuicio; }
	   
	   public String getFechaOficio() { return fechaOficio; }
	
	   public void setFechaOficio(String fechaOficio) { this.fechaOficio = fechaOficio; }
	   
	   public String getExpedidor() { return expedidor; }
	   
	   public void setExpedidor(String expedidor) { this.expedidor = expedidor; }
	
	   public String getIdUser() { return idUser; }
	   
	   public void setIdUser(String idUser) { this.idUser = idUser; }
	   
	   public String getSuspencion() { return suspencion; }
	   
	   public void setSuspencion(String suspencion) { this.suspencion = suspencion; }
	   
	   public String getFechaNotificacion() { return fechaNotificacion; }
	   
	   public void setFechaNotificacion(String fechaNotificacion) { this.fechaNotificacion = fechaNotificacion; }
	
	   public String getSintesi() { return sintesi; }
	   
	   public void setSintesi(String sintesi) { this.sintesi = sintesi; }
	   
	   public int getNumeroOficio() { return numeroOficio; }
	   
	   public void setNumeroOficio(int numeroOficio) { this.numeroOficio = numeroOficio; }
	
	   public int getNumeroJuicio() { return numeroJuicio; }
	   
	   public void setNumeroJuicio(int numeroJuicio) { this.numeroJuicio = numeroJuicio; }
	   
	   public int getNumeroRegistro() { return numeroRegistro; }
	   
	   public void setNumeroRegistro(int numeroRegistro) { this.numeroRegistro = numeroRegistro; }
    
}
