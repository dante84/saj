package mx.gob.se.sraaj.presentacion.controladores;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Utilerias;

import mx.gob.se.sraaj.persistencia.daoImpl.UsuarioDAOImpl;


import mx.gob.se.sraaj.servicio.bean.CatGeneralBean;
import mx.gob.se.sraaj.servicio.bean.RecepcionBean;
import mx.gob.se.sraaj.servicio.bean.UsuarioBean;
import mx.gob.se.sraaj.servicio.beanImpl.CatGeneralBeanImpl;
import mx.gob.se.sraaj.transferencia.bean.CatBean;
import mx.gob.se.sraaj.transferencia.bean.SesionBean;
import mx.gob.se.sraaj.transferencia.beanImpl.LoginBean;
import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;
import mx.gob.se.sraaj.transferencia.beanImpl.UsuariosBeanImpl;

@ManagedBean(name="CUsuario")
//@ViewScoped



public class ControladorUsuario {
	
	private CatGeneralBeanImpl  catGeneralBeanImpl;
	private UsuarioBean usuarioBean;
	private RecepcionBean recepcionBean;
	private List<CatGeneralBean> catGeneralBean;
	private CatBean catalogoBean;
	private String pass;
	private String cPass;
	private String oldPass;
	
	@ManagedProperty (value="#{usuarioDAOImpl}")
	private UsuarioDAOImpl usuarioDAOImpl;
	
	public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
		this.usuarioDAOImpl = usuarioDAOImpl;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getcPass() {
		return cPass;
	}


	public void setcPass(String cPass) {
		this.cPass = cPass;
	}


	public String getOldPass() {
		return oldPass;
	}


	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	
	
	
	@ManagedProperty(value="#{sesionBean}")
	private SesionBeanImpl sesionBean;
	
	//@ManagedProperty(value="#{}")
	
	public void setCatGeneralBeanImpl(CatGeneralBeanImpl catGeneralBeanImpl) {
		this.catGeneralBeanImpl = catGeneralBeanImpl;
	}	

	
	public void setCatalogoBean(CatBean catalogoBean) {
		this.catalogoBean = catalogoBean;
	}


	public UsuarioBean getUsuarioBean() {return usuarioBean;}
	public void setUsuarioBean(UsuarioBean usuarioBean) {this.usuarioBean = usuarioBean;}

	public RecepcionBean getRecepcionBean() {return recepcionBean;}
	public void setRecepcionBean(RecepcionBean recepcionBean) {this.recepcionBean = recepcionBean;}

	public List<CatGeneralBean> getCatGeneralBean() {return catGeneralBean;}
	public void setCatGeneralBean(List<CatGeneralBean> catGeneralBean) {this.catGeneralBean = catGeneralBean;}

	public SesionBeanImpl getSesionBean() {return sesionBean;}
	public void setSesionBean(SesionBeanImpl sesionBean) {this.sesionBean = sesionBean;}
	
	public String doMuestraMiPerfil() throws SraajException {
		String sPath ="miPerfil";
		try{
				
				String sNomUser = sesionBean.getsUser();
				UsuariosBeanImpl infoUser = usuarioBean.obtieneInfoUser(sNomUser);
				
				
				
				
		}
		catch (Exception ex){
			
		}
		
		return sPath;
			
	}	
	
	public String  cambiaContrasenia() {	
		
//	boolean errOldPass = false;
//	boolean errPass = false;
//	boolean erroCpass = false;
		 
		   System.out.println("++++++++++");
	   
		   String sPath = "";
		   
		if(this.oldPass.trim().equals(""))
		{
			System.out.println("contraseña vacia");
			FacesContext.getCurrentInstance().addMessage( "forma:txtPwdAnterior",new FacesMessage("Ingresar la contraseña") );
		}
		else
		{
			//errOldPass = true;
			System.out.println("contraseña bien");
			if(this.pass.trim().equals(""))
			{
				System.out.println("nueva contraseña vacia");
				FacesContext.getCurrentInstance().addMessage( "forma:txtNuevaPwd",new FacesMessage("Ingresar nueva contraseña") );
			}
			else
			{
				//errPass = true;
				System.out.println("nueva contraseña bien");
				if(this.cPass.trim().equals(""))
				{
					System.out.println("Escribir nueva contra vacia");
					FacesContext.getCurrentInstance().addMessage( "forma:txtConfirPwd",new FacesMessage("Escribir de nueva la nueva contraseña") );
				}
				else
				{
					//erroCpass = true;
					System.out.println("Escribir nueva contra bien");
					if(pass.trim().equals(cPass))
					{
						System.out.println("son iguales");
						try {
							
							oldPass = Utilerias.encriptaPassword( oldPass ); 
							
							pass = Utilerias.encriptaPassword( pass ); 
							System.out.println("contraseña vieja: " + oldPass.toUpperCase());
							System.out.println("contraseña nueva: " + pass.toUpperCase());
							System.out.println("usuario: " + sesionBean.getsUser().toString());
							//System.out.println(sesionBean.getsContrasenia().toString());
							if(usuarioDAOImpl.cambiaPwdDeAcceso(sesionBean.getsUser().toString().trim(), oldPass.trim().toUpperCase(), pass.trim().toUpperCase()) == true)
							{
								sPath = "/xhtml/bienvenido"; 
							}
							else
							{
								FacesContext.getCurrentInstance().addMessage( "forma:txtError",new FacesMessage("Ingresar la contraseña") );
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						} 
						
					}
					else
					{
//						if (errOldPass ==  false) {
//							FacesContext.getCurrentInstance().addMessage( "forma:txtPwdAnterior",new FacesMessage("Ingresar la contraseña") );
//						}
//						if (errPass == false) {
//							FacesContext.getCurrentInstance().addMessage( "forma:txtNuevaPwd",new FacesMessage("Ingresar nueva contraseña") );
//						}
//						if (erroCpass == false) {
//							FacesContext.getCurrentInstance().addMessage( "forma:txtConfirPwd",new FacesMessage("Escribir de nueva la nueva contraseña") );
//						}
						System.out.println("no son iguales");
						FacesContext.getCurrentInstance().addMessage( "forma:x",new FacesMessage("No coinciden las contraseñas.") );
					}
				}
			}
		}
		return sPath;
	}	
}