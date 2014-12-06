package mx.gob.se.sraaj.comunes.bean;

public class PerfilBean {
	
	private int iIdPerfil, iActivo;
	private String sDescPerfil, sPermisos, sCreated_Date, sCreated_by, sDate_last_Update, sLast_Update_by;
	
	public int getiIdPerfil() { return iIdPerfil; }
	public void setiIdPerfil(int iIdPerfil) { this.iIdPerfil = iIdPerfil; }
	
	public String getsDescPerfil() { return sDescPerfil; }
	public void setsDescPerfil(String sDescPerfil) { this.sDescPerfil = sDescPerfil; }
	
	public String getsPermisos() { return sPermisos; }
	public void setsPermisos(String sPermisos) { this.sPermisos = sPermisos; }
	
	public String getsCreated_Date() { return sCreated_Date; } 
	public void setsCreated_Date(String sCreated_Date) { this.sCreated_Date = sCreated_Date; }
	
	public String getsCreated_by() { return sCreated_by; }
	public void setsCreated_by(String sCreated_by) { this.sCreated_by = sCreated_by; }
	
	public String getsDate_last_Update() { return sDate_last_Update; }
	public void setsDate_last_Update(String sDate_last_Update) { this.sDate_last_Update = sDate_last_Update; }
	
	public String getsLast_Update_by() { return sLast_Update_by; }
	public void setsLast_Update_by(String sLast_Update_by) { this.sLast_Update_by = sLast_Update_by; }
	
	public int getiActivo() { return iActivo; }
	public void setiActivo(int iActivo) { this.iActivo = iActivo; }
}
