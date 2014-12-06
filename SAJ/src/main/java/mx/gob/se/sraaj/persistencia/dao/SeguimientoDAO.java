package mx.gob.se.sraaj.persistencia.dao;

import java.util.Date;
import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.CatGenerico;
import mx.gob.se.sraaj.comunes.bean.CatTribunalBean;
import mx.gob.se.sraaj.comunes.bean.ConsultarBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;
import mx.gob.se.sraaj.comunes.bean.OrdinarioCivilPenalBean;
import mx.gob.se.sraaj.comunes.bean.PenalTblBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoBean;
import mx.gob.se.sraaj.comunes.bean.SeguimientoJuiciosBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface SeguimientoDAO {
	
	   public List<SeguimientoBean> obtenerSeguimiento(Date fecha, String busqueda,Integer idjuicio) throws SraajException;
	   public Boolean actualizarAsuntosJuridicos(int idreg, Integer idmateria, Date fechaConv, Date fechaVenc) throws SraajException;
	   public Boolean actualizarAmparoAgrarioSegSP(int idreg, String expInterno,String estatus) throws SraajException;
	   public List<CatTribunalBean> obtenerTribunal() throws SraajException;
	   public List<CatMateriaBean> obtenerMaterias() throws SraajException;
	   public Boolean actualizarJuicioAgrario(int idreg, Integer idmateria,Integer idtribunal, Date fechaVenc) throws SraajException;
	   public List<SeguimientoJuiciosBean> obtenerSeguimientoJuicios(String busqueda,Integer idjuicio) throws SraajException;
	   public List<DocumentosRelBean> obtenerDocumentos(String noJuicio)throws SraajException;	  
	   public List<ConsultarBean> obtenerConsulta(Integer id) throws SraajException;
	   public DocumentoBean consultarDocumento(int idRegDoc,int idTipoJuicio) throws Exception;
	   public List<PenalTblBean> obtenerPenalTbl(Date fecha, String busqueda, Integer noJuicio) throws SraajException;
	   public List<CatGenerico> obtenerCatPenal() throws SraajException;
	   public List<CatGenerico> obtenerTurnarA() throws SraajException;
	   public List<CatMateriaBean> pasarMaterias() throws Exception;
	   public Boolean actualizarPenalSP(int idreg, Integer idCatPenal,Integer idcatdescargo, String Aindiciado, Integer instruccion1,
				                        Integer instruccion2, Integer instruccion3, Integer instruccion4,Integer instruccion5,
				                        Integer instruccion6, Integer instruccion7,Integer instruccion8, Integer idTurnar, 
				                        Date fechaTermino, String estatus) throws SraajException;
	   public Boolean insertaDescargoPenal(int idregdoc, Date fecOficio,Integer numReg, String sentidoOficio, String destinatario,
				                           String observaciones, String archivo, int opc, String comentarios) throws SraajException;
	   public Boolean insertasegPenal(Integer Aidregdoc, String AnumExpPenal,String Adelito, String Adenuncia, Double Aimporte,
				                       String AflujoProcesal) throws SraajException; 
}
