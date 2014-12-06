package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.persistencia.daoImpl.UsuarioDAOImpl;
import mx.gob.se.sraaj.servicio.beanImpl.UsuarioBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

@ManagedBean (name="CUsuarios")
@SessionScoped
public class ControladorUsuarios implements Serializable{
	
	/**
	 * variables objetos
	 */
	private String puesto;
	private Object[] puestos;
	private String depto;
	private Object[] deptos;
	private String uniAdiminstrativa;
	private Object[] unidadAdiminstrativa;
	private String materia;
	private Object[] materias;
	
	/**
	 * variables combos
	 */
	
	private String comboPuesto;
	private String comboDepto;
	private String comboUnidadAdministrativa;
	private String comboMateria;
	private String comboEmail;
	private String hdIdUser;
	private String hdIdPerfil;
	private String hdHabUser;
	private String message;
	
	/**
	 * inyeccion de Beans
	 */	
	@ManagedProperty(value="#{usuariosDAOImpl}")
	private UsuarioDAOImpl usuariosDAOImpl;

	@ManagedProperty(value="#{gestionaCatDAOImpl}")
	private GestionaCatDAOImpl gestionaCatDAOImpl;
	
	@ManagedProperty(value="#{sesionBean}")
	private SesionBeanImpl sesionBean; 
	
	@ManagedProperty(value="#{usuarioBean}")
	private UsuarioBeanImpl usuarioBean;
	
	@ManagedProperty(value="#{usuariosBeanImpl}")
	private UsuariosBeanImpl usuariosBeanImpl;
	
	/**
	 * getter's and setter's
	 */
	public String getPuesto() { return puesto; }
	public void setPuesto(String puesto) { this.puesto = puesto; }
	
	public Object[] getPuestos() { return puestos; }
	public void setPuestos(Object[] puestos) { this.puestos = puestos; }
	
	public UsuarioDAOImpl getUsuariosDAOImpl() { return usuariosDAOImpl; }
	public void setUsuariosDAOImpl(UsuarioDAOImpl usuariosDAOImpl) { this.usuariosDAOImpl = usuariosDAOImpl; }

	public GestionaCatDAOImpl getGestionaCatDAOImpl() { return gestionaCatDAOImpl; }
	public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }
	
	public SesionBeanImpl getSesionBean() { return sesionBean; }
	public void setSesionBean(SesionBeanImpl sesionBean) { this.sesionBean = sesionBean; }
		
	public UsuarioBeanImpl getUsuarioBean() { return usuarioBean; }
	public void setUsuarioBean(UsuarioBeanImpl usuarioBean) { this.usuarioBean = usuarioBean; }

	public UsuariosBeanImpl getUsuariosBeanImpl() {
		return usuariosBeanImpl;
	}
	public void setUsuariosBeanImpl(UsuariosBeanImpl usuariosBeanImpl) {
		this.usuariosBeanImpl = usuariosBeanImpl;
	}
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	/**
	 * getter's and setter's objects
	 */
	public String getDepto() { return depto; }
	public void setDepto(String depto) { this.depto = depto; }
	
	public Object[] getDeptos() { return deptos; }
	public void setDeptos(Object[] deptos) { this.deptos = deptos; }
	
	public String getUniAdiminstrativa() { return uniAdiminstrativa; }
	public void setUniAdiminstrativa(String uniAdiminstrativa) { this.uniAdiminstrativa = uniAdiminstrativa; }
	
	public Object[] getUnidadAdiminstrativa() { return unidadAdiminstrativa; }
	public void setUnidadAdiminstrativa(Object[] unidadAdiminstrativa) { this.unidadAdiminstrativa = unidadAdiminstrativa; }

	public String getMateria() { return materia; }
	public void setMateria(String materia) { this.materia = materia; }
	
	public Object[] getMaterias() { return materias; }
	public void setMaterias(Object[] materias) { this.materias = materias; }
	
	/**
	 * getteer's and setter's combos
	 */
	public String getComboPuesto() { return comboPuesto; }
	public void setComboPuesto(String comboPuesto) { this.comboPuesto = comboPuesto; }
	
	public String getComboDepto() { return comboDepto; }
	public void setComboDepto(String comboDepto) { this.comboDepto = comboDepto; }
	
	public String getComboUnidadAdministrativa() { return comboUnidadAdministrativa; }
	public void setComboUnidadAdministrativa(String comboUnidadAdministrativa) { this.comboUnidadAdministrativa = comboUnidadAdministrativa; }
	
	public String getComboMateria() { return comboMateria; }
	public void setComboMateria(String comboMateria) { this.comboMateria = comboMateria; }
	
	public String getComboEmail() { return comboEmail; }
	public void setComboEmail(String comboEmail) { this.comboEmail = comboEmail; }
	
	public String getHdIdUser() { return hdIdUser; }
	public void setHdIdUser(String hdIdUser) { this.hdIdUser = hdIdUser; }
	
	public String getHdIdPerfil() { return hdIdPerfil; }
	public void setHdIdPerfil(String hdIdPerfil) { this.hdIdPerfil = hdIdPerfil; }
	
	public String getHdHabUser() { return hdHabUser; }
	public void setHdHabUser(String hdHabUser) { this.hdHabUser = hdHabUser; }
	
	/**
	 * methods
	 */
	public String doMuestraUsuarios() throws SraajException {
		    
		      System.out.println("-----------------");
		      String ruta = "usuarios";
		
		      try{				
		          System.out.println(usuariosDAOImpl.buscarUsuarios().get(0).getsUsuario());					
		      }catch (Exception ex){ ex.printStackTrace(); }
		
		      return ruta;
			
	   }
	   
	   public String doMuestraMiPerfil() throws SraajException {
		   String ruta= "miPerfil";
		   try{
			   puestos = gestionaCatDAOImpl.obtienePuesto().toArray();
			   deptos = gestionaCatDAOImpl.obtieneDepartamento().toArray();
			   unidadAdiminstrativa = gestionaCatDAOImpl.obtieneUnidadAdministrativa().toArray();
			   materias = gestionaCatDAOImpl.obtieneMateria().toArray();
			   
			   System.out.println(gestionaCatDAOImpl.obtienePuesto().get(0).getsDescripcionCat());
			   System.out.println(gestionaCatDAOImpl.obtieneDepartamento().get(0).getsDescripcionCat());
			   System.out.println(gestionaCatDAOImpl.obtieneUnidadAdministrativa().get(0).getsDescripcionCat());
			   System.out.println(gestionaCatDAOImpl.obtieneMateria().get(0).getsDescripcionCat());
			   System.out.println(usuariosBeanImpl.getsCorreoElectronico());
			   System.out.println(usuarioBean.getsCorreoElectronico());
			   System.out.println(sesionBean.getsCorreoElectronico());
		   }
		   catch(Exception ex){ex.printStackTrace();}
		   return ruta;
	   }
	   
	   public String actualizaMiPerfil() throws SraajException {
//	       FacesContext context = FacesContext.getCurrentInstance();
	        
		   System.out.println("============>>" + getComboPuesto());
		   System.out.println("============>>" + getComboDepto() );
		   System.out.println("============>>" + getComboUnidadAdministrativa() );		   
		   System.out.println("============>>" + getComboMateria() );
		   System.out.println("============>>" + getComboEmail() );		   
		   
		   String ruta ="bienvenido";
		   try{
			   if(comboPuesto.trim().equals("")){
				   System.out.println("if combo puesto");
				   FacesContext.getCurrentInstance().addMessage("forma:comboPuesto", new FacesMessage("El Puesto no puede ser vacio"));
				   }
			   else{
				   if(this.comboDepto.trim().equals("")){
					   System.out.println("if combo Departamento");
					   FacesContext.getCurrentInstance().addMessage("forma:comboDepto", new FacesMessage("El Departamento no puede ser vacio"));
					   }
				   else{
					   if(this.comboUnidadAdministrativa.trim().equals("")){
						   System.out.println("if combo unidad");
						   FacesContext.getCurrentInstance().addMessage("forma:comboUnidadAdministrativa", new FacesMessage("La Unidad Administrativa no puede ser vacio"));
						   }
					   else{
						   if(this.comboMateria.trim().equals("")){
							   System.out.println("if combo materia");
							   FacesContext.getCurrentInstance().addMessage("forma:comboMateria", new FacesMessage("La Materia no puede ser vacio"));
							   }
						   else{
							   if(this.comboEmail.trim().equals("")){
								   System.out.println("if combo email");
								   FacesContext.getCurrentInstance().addMessage("forma:comboEmail", new FacesMessage("El correo no puede ser vacio"));
								   }
							   try{
								   if(usuariosDAOImpl.actualizaMiPerfil(usuarioBean)){
									   System.out.println("en actualiza mi perfil");
//									   context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
//									   context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
									   }
								   }
							   catch(Exception e){e.printStackTrace(); }
							   }
						   }
					   }
				   }
			   }
		   catch (Exception e){ e.printStackTrace(); }
		   return ruta;
	   }
}
