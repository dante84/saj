package mx.gob.se.sraaj.servicio.beanImpl;

import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.daoImpl.GestionaCatDAOImpl;
import mx.gob.se.sraaj.servicio.bean.CatGeneralBean;
import mx.gob.se.sraaj.transferencia.beanImpl.CatBeanImpl;

public class CatGeneralBeanImpl implements CatGeneralBean{
	
	   private GestionaCatDAOImpl gestionaCatDAOImpl;
	   private CatBeanImpl catBeanImpl;
	   
	   public void setGestionaCatDAOImpl(GestionaCatDAOImpl gestionaCatDAOImpl) { this.gestionaCatDAOImpl = gestionaCatDAOImpl; }

	   public void setCatBeanImpl(CatBeanImpl catBeanImpl) { this.catBeanImpl = catBeanImpl; }
	   
	   
	   
	   public CatBeanImpl obtieneJuicios() throws SraajException {
		      try {
				catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneTipoJuicio());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return catBeanImpl;  
	   }
	   
	   public CatBeanImpl obtienePuesto() throws SraajException {
			try{
				catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtienePuesto());
			}
			catch(Exception e){
				e.printStackTrace();
			}
		      return catBeanImpl;
	   }
	   
	   public CatBeanImpl obtieneDepartamentoSP() throws SraajException {
			try{
				catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneDepartamento());
			}
			catch(Exception e){
				e.printStackTrace();
			}
		      return catBeanImpl;
	   }
	   
	   public CatBeanImpl obtieneCatalogos() throws SraajException {
		   try{
			   catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneCatalogos());
		   }catch (Exception e){
			   e.printStackTrace();
		   }
		   return catBeanImpl;
	   }
	   
	  public CatBeanImpl obtieneReporteCatalogo(String sSelected) throws SraajException{
		  try{
			  CatBeanImpl catalogoBean = new CatBeanImpl();
			  
			  if(sSelected.equals(Constantes.CAT_CATCJF)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepCJF());
			  }
			  if(sSelected.equals(Constantes.CAT_REMITENTE)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepRemitente());
			  }
			  if (sSelected.equals(Constantes.CAT_CATCIRCUITOS)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepCircuito());
			  }
			  if (sSelected.equals(Constantes.CAT_CATCLSDOCUMENTAL)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepClsDocumental());
			  }
			  if(sSelected.equals(Constantes.CAT_CATDELEGMETROPOLITANA)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepDelegMetropolitana());
			  }
			  if(sSelected.equals(Constantes.CAT_CATDEPARTAMENTO)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepDepartamento());
			  }
			  if(sSelected.equals(Constantes.CAT_CATINCIDENTESUSPENSION)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepIncidenteSuspension());
			  }
			  if(sSelected.equals(Constantes.CAT_CATINSTRUCCION)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepInstruccion());
			  }
			  if(sSelected.equals(Constantes.CAT_CATJUNTAESPECIAL)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepJuntaEspecial());
			  }
			  if(sSelected.equals(Constantes.CAT_CATJUNTALOCAL)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepJuntaLocal());
			  }
			  if(sSelected.equals(Constantes.CAT_CATJUZGADOSCONCILIACION)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepJuzgadosConciliacion());
			  }
			  if(sSelected.equals(Constantes.CAT_CATJUZGADOTRIBUNAL)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepJuzgadoTribunal());
			  }
			  if(sSelected.equals(Constantes.CAT_CATMATERIA)){
				  	catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepMateria());
			  }
			  if(sSelected.equals(Constantes.CAT_CATMINISTROINSTRUCTOR)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepMinistroInstructor());
			  }
			  if(sSelected.equals(Constantes.CAT_CATPGJ)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepPGJ());
			  }
			  if(sSelected.equals(Constantes.CAT_CATPGR)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtienePGR());
			  }
			  if(sSelected.equals(Constantes.CAT_CATPUESTO)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepPuesto());
			  }
			  if(sSelected.equals(Constantes.CAT_CATRESPONSABLE)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepResponsable());
			  }
			  if(sSelected.equals(Constantes.CAT_CATSALASCJN)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepSalaSCJN());
			  }
			  if(sSelected.equals(Constantes.CAT_CATSALASFISCALES)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepSalasFiscales());
			  }
			  if(sSelected.equals(Constantes.CAT_CATSALATRIBUNALCONCILIACION)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepSalaTribunalConciliacion());
			  }
			  if(sSelected.equals(Constantes.CAT_CATTRIBUNALESAGRARIOS)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepTribunalesAgrario());
			  }
			  if(sSelected.equals(Constantes.CAT_CATTIPOJUICIO)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepTipoJuicio());
			  }
			  if(sSelected.equals(Constantes.CAT_CATUNIDADADMINISTRATIVA)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepUnidadAdministrativa());
			  }
			  if(sSelected.equals(Constantes.CAT_CATUNIDADESPECIALIZADA)){
				  catalogoBean.setCatGeneralBean(gestionaCatDAOImpl.obtieneRepUnidadEspecializada());
			  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		return catBeanImpl;
	  }
	  
	  public CatBeanImpl obtieneDescargo() throws SraajException{
		  try{
			  catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneDescargo());
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return catBeanImpl;
	  }
	  
	  public CatBeanImpl obtieneEstados() throws SraajException{
		  try{
			  catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneEdos());
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return catBeanImpl;
	  }
	  
	  public CatBeanImpl obtieneCircuito() throws SraajException{
		  try{
			  catBeanImpl.setCatGeneralBean(gestionaCatDAOImpl.obtieneCircuito());
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return catBeanImpl;
	  }
}
