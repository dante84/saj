package mx.gob.se.sraaj.persistencia.dao;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.comunes.bean.CatMateriaBean;
import mx.gob.se.sraaj.comunes.bean.ErrorBDBean;
import mx.gob.se.sraaj.comunes.bean.DocumentoBean;
import mx.gob.se.sraaj.comunes.bean.ResponsableBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;


public interface GestionaCatDAO {

  	 public List<CatGeneralBean> obtieneTipoJuicio() throws SraajException;
  	 public List<CatGeneralBean> obtienePuesto() throws SraajException;
  	 public List<CatGeneralBean> obtieneDepartamento() throws SraajException;
  	 public List<CatGeneralBean> obtieneUnidadAdministrativa() throws SraajException;
  	 public List<CatGeneralBean> obtieneMateria() throws SraajException;
  	 public List<CatGeneralBean> obtieneCatalogos() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepCJF() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepRemitente() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepCircuito() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepClsDocumental() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepDelegMetropolitana() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepDepartamento() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepIncidenteSuspension() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepInstruccion() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepJuntaEspecial() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepJuntaLocal() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepJuzgadosConciliacion() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepJuzgadoTribunal() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepMateria() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepMinistroInstructor() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepPGJ() throws SraajException;
  	 public List<CatGeneralBean> obtienePGR() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepPuesto() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepResponsable() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepSalaSCJN() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepSalasFiscales() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepSalaTribunalConciliacion() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepTribunalesAgrario() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepTipoJuicio() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepUnidadAdministrativa() throws SraajException;
  	 public List<CatGeneralBean> obtieneRepUnidadEspecializada() throws SraajException;
  	 public List<CatGeneralBean> obtieneDescargo() throws SraajException;
  	 public List<ResponsableBean> obtieneResponsable(String idCat) throws SraajException;
   	 public List<CatGeneralBean> obtieneJuzgados(String idTipoJuicio) throws Exception;
   	 public List<DocumentoBean> buscarDocumento(DocumentoBean documentoBean) throws Exception;
  	 public List<CatGeneralBean> obtieneOrganoJud() throws Exception;   	 
   	 public boolean insertaAFLM(DocumentoBean documentoBean) throws Exception;
   	 public boolean insertaAgrario(DocumentoBean documentoBean) throws Exception;
   	 public boolean InsertarActualizarDescargo(int vIdRegDoc, int vDescargo, String vExpediente, int vTieneRegistro, String vDocumento) throws Exception;
  	 public boolean insertaNuevoDocumentoMF(DocumentoBean nuevodoBean) throws Exception;
  	 public boolean insertaNuevoDocumentoML(DocumentoBean nuevodoBean) throws Exception;
  	 public boolean insertaNuevoDocumentoPN(DocumentoBean nuevodoBean) throws Exception;
  	 public List<CatGeneralBean> obtieneEdos() throws SraajException;
  	 public List<CatGeneralBean> obtieneRemitente(String idTipoJuicio) throws SraajException;
  	 public List<CatGeneralBean> obtieneJuezDTO(String idTipoJuicio) throws SraajException;
  	 public int obtieneNumeroRegistro() throws Exception;
  	 public boolean insertaLaboral(DocumentoBean documentoBean) throws Exception;
  	 public int selectNumeroRegistro()throws Exception;
	 public List<CatMateriaBean> obtenerMaterias() throws Exception;
	 public DocumentoBean consultaDocumentoEditar(int idRegDoc,int iNumeroRegistro) throws Exception;
   	    	 
}
