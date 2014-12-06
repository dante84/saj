package mx.gob.se.sraaj.comunes.bean;

public class DocumentoBean {
	
	   private Integer    iIdRegDoc;
	   private Integer    iIdJuicio;
	   private Integer    iIdJuzgado;
	   private String 	   sRemitente;
	   private String 	   sAct;
	   private Integer    iEstado;
	   private String 	   sSint;
	   private String 	   sNumeroOficio;
	   private String 	   sFechaOficio;
	   private Integer    iNumeroRegistro;
	   private Integer    iNumeroExpediente;   
	   private Integer    iJuezDto;
	   private String	   sAveriguacionPrevia;	
	   private Integer	   iIdCatRemitente;
	   private String 	   sDesctipojuicio;
	   private Integer 	iOficioSinJuicio;
	   private String 		sFechaRecepcion;
	   private String 		sPath;	   
	   private String		sNomEstado;
	   private String		sNombreUsuario;
	   private String		sApePatUsuario;
	   private String 		sApeMatUsuario;
	   private Integer 	iIncidenteSuspencion;
	   private String 		sFechaNotificacion;
	   private String 		sDescJuzgado;
	   private Integer 		iOrganoJurisdiccional;
	   private String 		sDescOrganoJurisdccional;
	   private String 		sDemandado;
	   private String 		sDescJuezDto;
	   private Integer			iAutoridadResponsable;
	   private String 		sDescAutridadResponsable;
	   private String 		sPromovente;
	   private String 		sDescCatRemitente;
	   private Integer			iIdTribunal;
	   private String		sDecCatTribunal;
	   private Integer 		iIdMateria;
	   private String 		sDescCatMAteria;
	   private String 		sFechaVencimiento;
	   private String 		sFechaConvencional;
	   private String 		sFolio;
	   private String 		sTipoAsunto;
	   private String 		sAcuerdoCitatorio;
	   private Integer 		iNumeroControversia;
	   private Integer 		iIdCJN;
	   private Integer 		iIdAutoridadResponsable;
	   private String 		sDescCatResponsable;
       private Integer 		iIdProcedencia;
       private String 		sDescCatProcencencia;
	   private Integer 		iIdSalasFiscales;
	   private String 		sDescSalasFiscales;
	   private String 		sJuicioDeAmparo;
	   private String		sQuejoso;
	   private String 		sDescripcionTipoJuicio;
	   private String 		sSuspencion;
	   private String      sJuicioAmparo;
	   private String      sCedulaNotificacion;
	   	
       private Integer 		iIdDescargo_nuevo;
       private Integer 		iIdCatDescargo;
       private String 		sExpediente;
       private Integer			iTieneRegistro;
       private Integer 		iNumeroDocumento;
       private Integer 		iOpcion;
       private Integer 		iIdUser;
	   private String  	sNumeroJuicio;
	   private String 		iIdResponsable;	   	
	   private String 		sJuezDTO;
	   	
	   private String 		sOtrosTribunal;
	   private String 		sOtrosJuzgados;
	   private String		sOtrosOrganosJurisdiccionales;
	   private String 		sOtrosRemitente;
	   private String 		sOtrosJuezDTO;
	   private String 		sClasificacionDocumental;
	   private String      sFechaRegistro;
	   	
	   private Integer     iMonto;
	   
	   private Integer     iNumeroRegistroFin;
	   
	   private int         iEstatus;
	   		       
       public DocumentoBean(){
    	    
    	      setiAutoridadResponsable(0);
    	      setiEstado(0);
    	      setiIdAutoridadResponsable(0);
              setiIdCatRemitente(0);
              setiIdCJN(0);
              setiIdJuicio(0);
              setiIdJuzgado(0);
              setiIdMateria(0);
              setiIdProcedencia(0);
              setiIdRegDoc(0);
              setiIdSalasFiscales(0);
              setiIdTribunal(0);
              setiJuezDto(0);
              setiNumeroControversia(0);
              setiNumeroExpediente(0);
              setsNumeroJuicio(null);
              setiNumeroRegistro(0);
              setiOficioSinJuicio(0);
              setiOrganoJurisdiccional(0);
              setsAct(null);
              setsAcuerdoCitatorio(null);
              setsApeMatUsuario(null);
              setsApePatUsuario(null);
              setsAveriguacionPrevia(null);
              setsDecCatTribunal(null);
              setsDemandado(null);
              setsDescAutridadResponsable(null);
              setsDescCatMAteria(null);
              setsDescCatProcencencia(null);
              setsFechaRecepcion(null);
              setsFolio("");
              setiIncidenteSuspencion(0);
              setsClasificacionDocumental(null);
              setsFechaRegistro(null);
              setiMonto(0);
              setsJuicioAmparo("");
              setsCedulaNotificacion("");
              setiNumeroRegistroFin(0);
              setiEstatus(0);
              
    }

	public int getiIdRegDoc() {
		return iIdRegDoc;
	}


	public void setiIdRegDoc(int iIdRegDoc) {
		this.iIdRegDoc = iIdRegDoc;
	}


	public int getiIdJuicio() {
		return iIdJuicio;
	}


	public void setiIdJuicio(int iIdJuicio) {
		this.iIdJuicio = iIdJuicio;
	}


	public int getiIdJuzgado() {
		return iIdJuzgado;
	}


	public void setiIdJuzgado(int iIdJuzgado) {
		this.iIdJuzgado = iIdJuzgado;
	}


	public String getsRemitente() {
		return sRemitente;
	}


	public void setsRemitente(String sRemitente) {
		this.sRemitente = sRemitente;
	}


	public String getsAct() {
		return sAct;
	}


	public void setsAct(String sAct) {
		this.sAct = sAct;
	}


	public int getiEstado() {
		return iEstado;
	}


	public void setiEstado(int iEstado) {
		this.iEstado = iEstado;
	}


	public String getsSint() {
		return sSint;
	}


	public void setsSint(String sSint) {
		this.sSint = sSint;
	}


	public String getsNumeroOficio() {
		return sNumeroOficio;
	}


	public void setsNumeroOficio(String sNumeroOficio) {
		this.sNumeroOficio = sNumeroOficio;
	}


	public String getsFechaOficio() {
		return sFechaOficio;
	}


	public void setsFechaOficio(String sFechaOficio) {
		this.sFechaOficio = sFechaOficio;
	}


	public int getiNumeroRegistro() {
		return iNumeroRegistro;
	}


	public void setiNumeroRegistro(int iNumeroRegistro) {
		this.iNumeroRegistro = iNumeroRegistro;
	}


	public int getiNumeroExpediente() {
		return iNumeroExpediente;
	}


	public void setiNumeroExpediente(int iNumeroExpediente) {
		this.iNumeroExpediente = iNumeroExpediente;
	}


	public int getiJuezDto() {
		return iJuezDto;
	}


	public void setiJuezDto(int iJuezDto) {
		this.iJuezDto = iJuezDto;
	}


	public String getsAveriguacionPrevia() {
		return sAveriguacionPrevia;
	}


	public void setsAveriguacionPrevia(String sAveriguacionPrevia) {
		this.sAveriguacionPrevia = sAveriguacionPrevia;
	}


	public int getiIdCatRemitente() {
		return iIdCatRemitente;
	}


	public void setiIdCatRemitente(int iIdCatRemitente) {
		this.iIdCatRemitente = iIdCatRemitente;
	}


	public String getsDesctipojuicio() {
		return sDesctipojuicio;
	}


	public void setsDesctipojuicio(String sDesctipojuicio) {
		this.sDesctipojuicio = sDesctipojuicio;
	}


	public int getiOficioSinJuicio() {
		return iOficioSinJuicio;
	}


	public void setiOficioSinJuicio(int iOficioSinJuicio) {
		this.iOficioSinJuicio = iOficioSinJuicio;
	}


	public String getsFechaRecepcion() {
		return sFechaRecepcion;
	}


	public void setsFechaRecepcion(String sFechaRecepcion) {
		this.sFechaRecepcion = sFechaRecepcion;
	}


	public String getsPath() {
		return sPath;
	}


	public void setsPath(String sPath) {
		this.sPath = sPath;
	}


	public String getsNomEstado() {
		return sNomEstado;
	}


	public void setsNomEstado(String sNomEstado) {
		this.sNomEstado = sNomEstado;
	}


	public String getsNombreUsuario() {
		return sNombreUsuario;
	}


	public void setsNombreUsuario(String sNombreUsuario) {
		this.sNombreUsuario = sNombreUsuario;
	}


	public String getsApePatUsuario() {
		return sApePatUsuario;
	}


	public void setsApePatUsuario(String sApePatUsuario) {
		this.sApePatUsuario = sApePatUsuario;
	}


	public String getsApeMatUsuario() {
		return sApeMatUsuario;
	}


	public void setsApeMatUsuario(String sApeMatUsuario) {
		this.sApeMatUsuario = sApeMatUsuario;
	}	

	public String getsFechaNotificacion() {
		return sFechaNotificacion;
	}


	public void setsFechaNotificacion(String sFechaNotificacion) {
		this.sFechaNotificacion = sFechaNotificacion;
	}


	public String getsDescJuzgado() {
		return sDescJuzgado;
	}


	public void setsDescJuzgado(String sDescJuzgado) {
		this.sDescJuzgado = sDescJuzgado;
	}


	public int getiOrganoJurisdiccional() {
		return iOrganoJurisdiccional;
	}


	public void setiOrganoJurisdiccional(int iOrganoJurisdiccional) {
		this.iOrganoJurisdiccional = iOrganoJurisdiccional;
	}


	public String getsDescOrganoJurisdccional() {
		return sDescOrganoJurisdccional;
	}


	public void setsDescOrganoJurisdccional(String sDescOrganoJurisdccional) {
		this.sDescOrganoJurisdccional = sDescOrganoJurisdccional;
	}


	public String getsDemandado() {
		return sDemandado;
	}


	public void setsDemandado(String sDemandado) {
		this.sDemandado = sDemandado;
	}


	public String getsDescJuezDto() {
		return sDescJuezDto;
	}


	public void setsDescJuezDto(String sDescJuezDto) {
		this.sDescJuezDto = sDescJuezDto;
	}


	public int getiAutoridadResponsable() {
		return iAutoridadResponsable;
	}


	public void setiAutoridadResponsable(int iAutoridadResponsable) {
		this.iAutoridadResponsable = iAutoridadResponsable;
	}


	public String getsDescAutridadResponsable() {
		return sDescAutridadResponsable;
	}


	public void setsDescAutridadResponsable(String sDescAutridadResponsable) {
		this.sDescAutridadResponsable = sDescAutridadResponsable;
	}


	public String getsPromovente() {
		return sPromovente;
	}


	public void setsPromovente(String sPromovente) {
		this.sPromovente = sPromovente;
	}


	public String getsDescCatRemitente() {
		return sDescCatRemitente;
	}


	public void setsDescCatRemitente(String sDescCatRemitente) {
		this.sDescCatRemitente = sDescCatRemitente;
	}


	public int getiIdTribunal() {
		return iIdTribunal;
	}


	public void setiIdTribunal(int iIdTribunal) {
		this.iIdTribunal = iIdTribunal;
	}


	public String getsDecCatTribunal() {
		return sDecCatTribunal;
	}


	public void setsDecCatTribunal(String sDecCatTribunal) {
		this.sDecCatTribunal = sDecCatTribunal;
	}


	public int getiIdMateria() {
		return iIdMateria;
	}


	public void setiIdMateria(int iIdMateria) {
		this.iIdMateria = iIdMateria;
	}


	public String getsDescCatMAteria() {
		return sDescCatMAteria;
	}


	public void setsDescCatMAteria(String sDescCatMAteria) {
		this.sDescCatMAteria = sDescCatMAteria;
	}


	public String getsFechaVencimiento() {
		return sFechaVencimiento;
	}


	public void setsFechaVencimiento(String sFechaVencimiento) {
		this.sFechaVencimiento = sFechaVencimiento;
	}


	public String getsFechaConvencional() {
		return sFechaConvencional;
	}


	public void setsFechaConvencional(String sFechaConvencional) {
		this.sFechaConvencional = sFechaConvencional;
	}
	

	public String getsTipoAsunto() {
		return sTipoAsunto;
	}


	public void setsTipoAsunto(String sTipoAsunto) {
		this.sTipoAsunto = sTipoAsunto;
	}


	public String getsAcuerdoCitatorio() {
		return sAcuerdoCitatorio;
	}


	public void setsAcuerdoCitatorio(String sAcuerdoCitatorio) {
		this.sAcuerdoCitatorio = sAcuerdoCitatorio;
	}


	public int getiNumeroControversia() {
		return iNumeroControversia;
	}


	public void setiNumeroControversia(int iNumeroControversia) {
		this.iNumeroControversia = iNumeroControversia;
	}


	public int getiIdCJN() {
		return iIdCJN;
	}


	public void setiIdCJN(int iIdCJN) {
		this.iIdCJN = iIdCJN;
	}


	public int getiIdAutoridadResponsable() {
		return iIdAutoridadResponsable;
	}


	public void setiIdAutoridadResponsable(int iIdAutoridadResponsable) {
		this.iIdAutoridadResponsable = iIdAutoridadResponsable;
	}


	public String getsDescCatResponsable() {
		return sDescCatResponsable;
	}


	public void setsDescCatResponsable(String sDescCatResponsable) {
		this.sDescCatResponsable = sDescCatResponsable;
	}


	public int getiIdProcedencia() {
		return iIdProcedencia;
	}


	public void setiIdProcedencia(int iIdProcedencia) {
		this.iIdProcedencia = iIdProcedencia;
	}


	public String getsDescCatProcencencia() {
		return sDescCatProcencencia;
	}


	public void setsDescCatProcencencia(String sDescCatProcencencia) {
		this.sDescCatProcencencia = sDescCatProcencencia;
	}


	public int getiIdSalasFiscales() {
		return iIdSalasFiscales;
	}


	public void setiIdSalasFiscales(int iIdSalasFiscales) {
		this.iIdSalasFiscales = iIdSalasFiscales;
	}


	public String getsDescSalasFiscales() {
		return sDescSalasFiscales;
	}


	public void setsDescSalasFiscales(String sDescSalasFiscales) {
		this.sDescSalasFiscales = sDescSalasFiscales;
	}


	public String getsJuicioDeAmparo() {
		return sJuicioDeAmparo;
	}


	public void setsJuicioDeAmparo(String sJuicioDeAmparo) {
		this.sJuicioDeAmparo = sJuicioDeAmparo;
	}


	public String getsQuejoso() {
		return sQuejoso;
	}


	public void setsQuejoso(String sQuejoso) {
		this.sQuejoso = sQuejoso;
	}


	public String getsDescripcionTipoJuicio() {
		return sDescripcionTipoJuicio;
	}


	public void setsDescripcionTipoJuicio(String sDescripcionTipoJuicio) {
		this.sDescripcionTipoJuicio = sDescripcionTipoJuicio;
	}

	
	public String getsSuspencion() {
		return sSuspencion;
	}


	public void setsSuspencion(String sSuspencion) {
		this.sSuspencion = sSuspencion;
	}


	public int getiIdDescargo_nuevo() {
		return iIdDescargo_nuevo;
	}


	public void setiIdDescargo_nuevo(int iIdDescargo_nuevo) {
		this.iIdDescargo_nuevo = iIdDescargo_nuevo;
	}


	public int getiIdCatDescargo() {
		return iIdCatDescargo;
	}


	public void setiIdCatDescargo(int iIdCatDescargo) {
		this.iIdCatDescargo = iIdCatDescargo;
	}


	public String getsExpediente() {
		return sExpediente;
	}


	public void setsExpediente(String sExpediente) {
		this.sExpediente = sExpediente;
	}


	public int getiTieneRegistro() {
		return iTieneRegistro;
	}


	public void setiTieneRegistro(int iTieneRegistro) {
		this.iTieneRegistro = iTieneRegistro;
	}


	public int getiNumeroDocumento() {
		return iNumeroDocumento;
	}


	public void setiNumeroDocumento(int iNumeroDocumento) {
		this.iNumeroDocumento = iNumeroDocumento;
	}


	public int getiOpcion() {
		return iOpcion;
	}


	public void setiOpcion(int iOpcion) {
		this.iOpcion = iOpcion;
	}


	public int getiIdUser() {
		return iIdUser;
	}


	public void setiIdUser(int iIdUser) {
		this.iIdUser = iIdUser;
	}


	public String getsNumeroJuicio() {
		return sNumeroJuicio;
	}


	public void setsNumeroJuicio(String sNumeroJuicio) {
		this.sNumeroJuicio = sNumeroJuicio;
	}


	public String getiIdResponsable() {
		return iIdResponsable;
	}


	public void setiIdResponsable(String iIdResponsable) {
		this.iIdResponsable = iIdResponsable;
	}


	public String getsJuezDTO() {
		return sJuezDTO;
	}


	public void setsJuezDTO(String sJuezDTO) {
		this.sJuezDTO = sJuezDTO;
	}	

	public Integer getiIncidenteSuspencion() {
		return iIncidenteSuspencion;
	}


	public void setiIncidenteSuspencion(Integer iIncidenteSuspencion) {
		this.iIncidenteSuspencion = iIncidenteSuspencion;
	}


	public String getsOtrosTribunal() {
		return sOtrosTribunal;
	}


	public void setsOtrosTribunal(String sOtrosTribunal) {
		this.sOtrosTribunal = sOtrosTribunal;
	}

	public String getsOtrosJuzgados() {
		return sOtrosJuzgados;
	}

	public void setsOtrosJuzgados(String sOtrosJuzgados) {
		this.sOtrosJuzgados = sOtrosJuzgados;
	}


	public String getsOtrosOrganosJurisdiccionales() {
		return sOtrosOrganosJurisdiccionales;
	}


	public void setsOtrosOrganosJurisdiccionales(
			String sOtrosOrganosJurisdiccionales) {
		this.sOtrosOrganosJurisdiccionales = sOtrosOrganosJurisdiccionales;
	}


	public String getsOtrosRemitente() {
		return sOtrosRemitente;
	}


	public void setsOtrosRemitente(String sOtrosRemitente) {
		this.sOtrosRemitente = sOtrosRemitente;
	}


	public String getsOtrosJuezDTO() {
		return sOtrosJuezDTO;
	}


	public void setsOtrosJuezDTO(String sOtrosJuezDTO) {
		this.sOtrosJuezDTO = sOtrosJuezDTO;
	}


	public String getsFolio() {
		return sFolio;
	}


	public void setsFolio(String sFolio) {
		this.sFolio = sFolio;
	}


	public String getsClasificacionDocumental() {
		return sClasificacionDocumental;
	}


	public void setsClasificacionDocumental(String sClasificacionDocumental) {
		this.sClasificacionDocumental = sClasificacionDocumental;
	}


	public String getsFechaRegistro() {
		return sFechaRegistro;
	}


	public void setsFechaRegistro(String sFechaRegistro) {
		this.sFechaRegistro = sFechaRegistro;
	}


	public Integer getiMonto() {
		return iMonto;
	}


	public void setiMonto(Integer iMonto) {
		this.iMonto = iMonto;
	}


	public String getsJuicioAmparo() {
		return sJuicioAmparo;
	}


	public void setsJuicioAmparo(String sJuicioAmparo) {
		this.sJuicioAmparo = sJuicioAmparo;
	}

	public String getsCedulaNotificacion() {
		return sCedulaNotificacion;
	}

	public void setsCedulaNotificacion(String sCedulaNotificacion) {
		this.sCedulaNotificacion = sCedulaNotificacion;
	}

	public Integer getiNumeroRegistroFin() {
		return iNumeroRegistroFin;
	}

	public void setiNumeroRegistroFin(Integer iNumeroRegistroFin) {
		this.iNumeroRegistroFin = iNumeroRegistroFin;
	}

	public int getiEstatus() {
		return iEstatus;
	}

	public void setiEstatus(int iEstatus) {
		this.iEstatus = iEstatus;
	}


}
