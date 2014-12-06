package mx.gob.se.sraaj.persistencia.daoImpl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.ComparecenciaIndiciadoBean;
import mx.gob.se.sraaj.comunes.bean.DenunciaHechosBean;
import mx.gob.se.sraaj.comunes.bean.DiligenciasMPBean;
import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.MediosPruebaBean;
import mx.gob.se.sraaj.comunes.bean.RequerimientosMPBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.comunes.utils.Constantes;
import mx.gob.se.sraaj.persistencia.dao.AvenriguacionPreviaDAO;
import mx.gob.se.sraaj.persistencia.sp.ComparecenciaindiciadoTblSP;
import mx.gob.se.sraaj.persistencia.sp.DenunciaHechosSP;
import mx.gob.se.sraaj.persistencia.sp.DiligenciasMPSP;
import mx.gob.se.sraaj.persistencia.sp.InsertarAveriguacionPreviaSP;
import mx.gob.se.sraaj.persistencia.sp.MediosPruebaSP;
import mx.gob.se.sraaj.persistencia.sp.RequerimientosMPSP;

public class AveriguacionPreviaDAOImpl implements AvenriguacionPreviaDAO, Serializable
{
	private static final long serialVersionUID = 1L;
	private ComparecenciaindiciadoTblSP comparecenciaindiciadoTblSP;
	private RequerimientosMPSP requerimientosMPSP;
	private DiligenciasMPSP diligenciasMPSP;
	private DenunciaHechosSP denunciaHechosSP;
	private MediosPruebaSP mediosPruebaSP;
	private InsertarAveriguacionPreviaSP insertarAveriguacionPreviaSP;

	@Override
	public List<ComparecenciaIndiciadoBean> listaComparecencia(Integer idregdoc)throws SraajException 
	{
	    
	      System.out.println("=====>> en DAO obtener listaComparecencia");
	      List<ComparecenciaIndiciadoBean> lCat = null;
	      
	      try{
	    	  
		      Map<String, Object> mapCursor = comparecenciaindiciadoTblSP.execute(idregdoc);
		      if( mapCursor != null ){
			      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if( seg instanceof List<?> ){
				      lCat = (List<ComparecenciaIndiciadoBean>) seg;
			      }
		      }
		      
		      return lCat;
		      
	      }catch ( Exception ex ){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	      }
	      
	}
	
	@Override
	public List<RequerimientosMPBean> listaRequerimientos(Integer idregdoc)throws SraajException 
	{
	    
	      System.out.println("=====>> en DAO obtener listaRequerimientos");
	      List<RequerimientosMPBean> lCat = null;
	      
	      try{
	    	  
		      Map<String, Object> mapCursor = requerimientosMPSP.execute(idregdoc);
		      if( mapCursor != null ){
			      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if( seg instanceof List<?> ){
				      lCat = (List<RequerimientosMPBean>) seg;
			      }
		      }
		      
		      return lCat;
		      
	      }catch ( Exception ex ){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	      }
	      
	}

	
	@Override
	public List<DiligenciasMPBean> listaDiligencias(Integer idregdoc)throws SraajException 
	{
	    
	      System.out.println("=====>> en DAO obtener listaDiligencias");
	      List<DiligenciasMPBean> lCat = null;
	      
	      try{
	    	  
		      Map<String, Object> mapCursor = diligenciasMPSP.execute(idregdoc);
		      if( mapCursor != null ){
			      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if( seg instanceof List<?> ){
				      lCat = (List<DiligenciasMPBean>) seg;
			      }
		      }
		      
		      return lCat;
		      
	      }catch ( Exception ex ){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	      }
	      
	}
	
	@Override
	public List<DenunciaHechosBean> listaDenuncias(Integer idregdoc)throws SraajException 
	{
	    
	      System.out.println("=====>> en DAO obtener listaDenuncias");
	      List<DenunciaHechosBean> lCat = null;
	      
	      try{
	    	  
		      Map<String, Object> mapCursor = denunciaHechosSP.execute(idregdoc);
		      if( mapCursor != null ){
			      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if( seg instanceof List<?> ){
				      lCat = (List<DenunciaHechosBean>) seg;
			      }
		      }
		      
		      return lCat;
		      
	      }catch ( Exception ex ){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	      }
	      
	}
	
	@Override
	public List<MediosPruebaBean> listaMediosPrueba(Integer idregdoc)throws SraajException 
	{
	    
	      System.out.println("=====>> en DAO obtener listaMediosPrueba");
	      List<MediosPruebaBean> lCat = null;
	      
	      try{
	    	  
		      Map<String, Object> mapCursor = mediosPruebaSP.execute(idregdoc);
		      if( mapCursor != null ){
			      Object seg = mapCursor.get(Constantes.OUT_SP_RESULTADO);
			      if( seg instanceof List<?> ){
				      lCat = (List<MediosPruebaBean>) seg;
			      }
		      }
		      
		      return lCat;
		      
	      }catch ( Exception ex ){
		           ex.printStackTrace();
		           throw new SraajException(ex.getMessage(), ex);
	      }
	      
	}
	
	
	@Override
	public Boolean InsertarAveriguacionPrevia(Date AfechaComparecencia
											,String ApruebasComparecencia
											,String AobservacionesComparecencia
			   
											,Date AfechaRequerimientos
											,String AoficioRequerimientos
											,String ArequerimientoRequerimientos
											,String AdesahogoRequerimientos
											,String AobservacionesRequerimientos
			   
											,Date AfechaDiligencias
											,String AdiligenciaDiligencias
											,String AobservacionesDiligencias
			   
											,Date AfechaDenuncia
											,String AoficioDenuncia
											,String AratificaDenuncia
											,Date AfecharatificaDenuncia
			   
											,Date AfechaMedios
											,String AtestimonialesMedios
											,String ApericialesMedios
											,String AdocumentalesMedios
											,String AinspeccionMedios
											,String AotraMedios
											,String AobservacionesMedios
			   
											,Integer Aidregdoc
											,Integer Aidcomparecencia
											,Integer Aidrequerimientos
											,Integer Aiddiligencia
											,Integer Aiddenuncia
											,Integer Aidmedios
											,Integer Aopc) throws SraajException
	{
		System.out.println("insertar comparecencia daoImpl");
				try 
				{
					 Map<String, Object> errorBd = insertarAveriguacionPreviaSP.execute(AfechaComparecencia
																						, ApruebasComparecencia
																						, AobservacionesComparecencia
														
																						, AfechaRequerimientos
																						, AoficioRequerimientos
																						, ArequerimientoRequerimientos
																						, AdesahogoRequerimientos
																						, AobservacionesRequerimientos
														
																						, AfechaDiligencias
																						, AdiligenciaDiligencias
																						, AobservacionesDiligencias
														
																						, AfechaDenuncia
																						, AoficioDenuncia
																						, AratificaDenuncia
																						, AfecharatificaDenuncia
														
																						, AfechaMedios
																						, AtestimonialesMedios
																						, ApericialesMedios
																						, AdocumentalesMedios
																						, AinspeccionMedios
																						, AotraMedios
																						, AobservacionesMedios
														
																						, Aidregdoc
																						, Aidcomparecencia
																						, Aidrequerimientos
																						, Aiddiligencia
																						, Aiddenuncia
																						, Aidmedios
																						, Aopc); 
					 
					 @SuppressWarnings("unchecked")
				      List<ErrorBDBean> err = (List<ErrorBDBean>)errorBd.get(Constantes.OUT_SP_ERROR);
				      ErrorBDBean errVO = err.get(0);
				      
				      if( errVO != null ) {
				       
				       System.out.println(errVO.getsCodError());
				       System.out.println(errVO.getsDescError());
				       
				       if( errVO.getsCodError().equals("DBSE000") )
				       { return true; }
				      }
				 
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				return false;
	}
	
	
	
	
	//gets and sets
	public ComparecenciaindiciadoTblSP getComparecenciaindiciadoTblSP() {
		return comparecenciaindiciadoTblSP;
	}

	public void setComparecenciaindiciadoTblSP(
			ComparecenciaindiciadoTblSP comparecenciaindiciadoTblSP) {
		this.comparecenciaindiciadoTblSP = comparecenciaindiciadoTblSP;
	}

	public RequerimientosMPSP getRequerimientosMPSP() {
		return requerimientosMPSP;
	}

	public void setRequerimientosMPSP(RequerimientosMPSP requerimientosMPSP) {
		this.requerimientosMPSP = requerimientosMPSP;
	}

	public DiligenciasMPSP getDiligenciasMPSP() {
		return diligenciasMPSP;
	}

	public void setDiligenciasMPSP(DiligenciasMPSP diligenciasMPSP) {
		this.diligenciasMPSP = diligenciasMPSP;
	}

	public DenunciaHechosSP getDenunciaHechosSP() {
		return denunciaHechosSP;
	}

	public void setDenunciaHechosSP(DenunciaHechosSP denunciaHechosSP) {
		this.denunciaHechosSP = denunciaHechosSP;
	}

	public MediosPruebaSP getMediosPruebaSP() {
		return mediosPruebaSP;
	}

	public void setMediosPruebaSP(MediosPruebaSP mediosPruebaSP) {
		this.mediosPruebaSP = mediosPruebaSP;
	}

	public InsertarAveriguacionPreviaSP getInsertarAveriguacionPreviaSP() {
		return insertarAveriguacionPreviaSP;
	}

	public void setInsertarAveriguacionPreviaSP(
			InsertarAveriguacionPreviaSP insertarAveriguacionPreviaSP) {
		this.insertarAveriguacionPreviaSP = insertarAveriguacionPreviaSP;
	}
	
	
}
