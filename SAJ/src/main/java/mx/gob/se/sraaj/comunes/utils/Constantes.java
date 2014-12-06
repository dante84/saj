package mx.gob.se.sraaj.comunes.utils;


public  class Constantes {
	
	public Constantes() {
		
	}
	
	public static final String MSG_LOG_INICIO = "Inicia";
	
	public static final String MSG_LOG_FIN = "Fin";
	
	public static final String MSG_LOG_CONSTRUCTOR = "Se genera la instancia de ";
	
	public static final String ERRORDB_EXITO = "DBSE000";
	
	public static final String ERRORDB_RENOVAR_PASS = "DBSE002";
	
	public static final String ATTR_SESION_VO = "sesionVO";
	
	public static final String STR_ID_SESION = "SeJuR";

	
	/** JSP's. */
	public static final String JSP_LOGIN = "Login";
	public static final String JSP_BIENVENIDO = "Bienvenido";
	public static final String JSP_RESTPASSW = "RestablecerCon";
	public static final String JSP_BITACORA = "Bitacora";
	public static final String JSP_APERFIL = "AgregarPerfil";
	public static final String JSP_ADMIN_USERS = "AdminUsuarios";
	public static final String JSP_ASIGNA_PWD = "AsignarNuevaCon";
	public static final String JSP_CAMBIAR_PWD = "CambiarContras";
	public static final String JSP_CATALOGOS = "Catalogos";
	public static final String JSP_CONSULTAR_EXPEDIENTE = "ConsultarExp2";
	public static final String JSP_MODIFICAR_EXPEDIENTE = "ModificarExp";
	public static final String JSP_CONSULTAR_EXPEDIENTE2 = "ConsultarExp";
	public static final String JSP_MI_PERFIL = "MiPerfil";
	public static final String JSP_PERFILES = "Perfiles";
	public static final String JSP_REGISTRAR_EXPEDIENTE = "RegistrarExp";
	public static final String JSP_DATOS_REGISTRO_EXPEDIENTE = "DatosRegExp";
	public static final String JSP_AGREGAR_CATALOGO = "AgregarEnt";
	public static final String JSP_MODIFICAR_CATALOGO ="ModEntidad";
	public static final String JSP_MODIFICAR_PERFIL ="ModPerfil";
	public static final String JSP_AGREGAR_EXP_GLOBAL = "RegistraExpG";
	public static final String JSP_DESCARGO = "Descargo";
	
	public static final String JSP_AGREGAR_USR = "RegistrarUsuarios";

	public static final String JSP_MODIFICAR_USUARIO ="ModUsuario";
	
	public static final String PATH_LOGIN = "/SE0001-SRAAJ/ingreso.go?realize=doLogin";
	
	public static final String PATH_PASS_INGRESO = "/SE0001-SRAAJ/pwdIngreso.go?realize=doMuestraUpdPwd";
	
	public static final String PATH_CATALOGO = "/SE0001-SRAAJ/catalogos.go?realize=doMuestraCatalogos";
	
	public static final String PATH_PERFIL = "/SE0001-SRAAJ/admin.go?realize=doMuestraPerfiles";
	
	public static final String PATH_AGREGA_PERFIL = "/SE0001-SRAAJ/perfiles.go?realize=doAgregaPerfil";
	
	public static final String PATH_CIERRA_SESION = "/SE0001-SRAAJ/cerrarSesion.go?realize=doCerrarSesion";
	
	public static final String PATH_BIENVENIDO = "usuario.go?realize=doBienvenido";
	
	public static final String PATH_USUARIOS = "admin.go?realize=doMuestraUsuarios";
	
	public static final String OUT_SP_RESULTADO = "pResult";
	
	public static final String OUT_SP_ERROR = "pMsgError";
	//Catalogos 
	public static final String  CAT_CATCJF="CatCJF";
	public static final String  CAT_CATCLSDOCUMENTAL="CatClsDocumental";
	public static final String  CAT_CATDELEGMETROPOLITANA="CatDelegMetropolitana";
	public static final String  CAT_CATDEPARTAMENTO="CatDepartamento";
	public static final String  CAT_CATINCIDENTESUSPENSION="CatIncidenteSuspension";
	public static final String  CAT_CATINSTRUCCION="CatInstruccion";
	public static final String  CAT_CATJUNTAESPECIAL="CatJuntaEspecial";
	public static final String  CAT_CATJUNTALOCAL="CatJuntaLocal";
	public static final String  CAT_CATJUZGADOSCONCILIACION="CatJuzgadosConciliacion";
	public static final String  CAT_CATJUZGADOTRIBUNAL="CatJuzgadoTribunal";
	public static final String  CAT_CATMATERIA="CatMateria";
	public static final String  CAT_CATMINISTROINSTRUCTOR="CatMinistroInstructor";
	public static final String  CAT_CATPGJ="CatPGJ";
	public static final String  CAT_CATPGR="CatPGR";
	public static final String  CAT_CATPUESTO="CatPuesto";
	public static final String  CAT_CATRESPONSABLE="CatResponsable";
	public static final String  CAT_CATSALASCJN="CatSalaSCJN";
	public static final String  CAT_CATSALASFISCALES="CatSalasFiscales";
	public static final String  CAT_CATSALATRIBUNALCONCILIACION="CatSalaTribunalConciliacion";
	public static final String  CAT_CATTIPOJUICIO="CatTipoJuicio";
	public static final String  CAT_CATUNIDADADMINISTRATIVA="CatUnidadAdministrativa";
	public static final String  CAT_CATUNIDADESPECIALIZADA="CatUnidadEspecializada";
	public static final String  CAT_CATCIRCUITOS="CatCircuitos";
	public static final String  CAT_CATTRIBUNALESAGRARIOS="CatTribunalesAgrario";	
	public static final String  CAT_PERFILES ="CatPerfiles";
	public static final String  CAT_REMITENTE ="CatRemitente";
	
	public static final String  TIPO_JUICIO_AGRARIO = "Agrario";
	public static final String  TIPO_JUICIO_AMP_LOCAL = "AmpLocal";
	public static final String  TIPO_JUICIO_AMP_FOR = "AmpFor";
	public static final String  TIPO_JUICIO_CONTROVERSIA = "ContrConst";
	public static final String  TIPO_JUICIO_FISCAL = "Fiscal";
	public static final String  TIPO_JUICIO_LABORAL = "Laboral";
	public static final String  TIPO_JUICIO_MERC_LOCAL = "MercLocal";
	public static final String  TIPO_JUICIO_MERC_FOR = "MercForaneo";
	public static final String  TIPO_JUICIO_CIVIL = "Civil";
	public static final String  TIPO_JUICIO_CIVIL_FOR = "CivForaneo";
	public static final String  TIPO_JUICIO_CIVIL_PROM = "CivProm";
	public static final String  TIPO_JUICIO_PENAL = "Penal";
	public static final String  TIPO_SIN_JUICIO = "sinJuicioDTO";
	public static final String  TIPO_SUB_AMP = "subAmpLocDTO";
	public static final String  DESCARGO = "Descargo";
	
	public static final String 	PATH_ARCHIVOS = "C:/Users/EISEI/Downloads/";
	
	public static final String ID_DATOCAT = "idDato";
	public static final String ID_CATALOGO = "idCat";
	public static final String NOMBRE_CATALOGO ="sNombreCat";
	public static final String DATO_MODIFICAR = "idDatoMod";
	public static final String DESCRIPCION_DATO = "Desc";
	public static final String ACTIVO_DATO = "Activo";	
	public static final String DESC_PERFIL = "descPerfil";
	public static final String ID_PERFIL = "idPerfil";	
	public static final String NUMERO_REGISTRO ="sNoRegistro";
	public static final String FECHA_REGISTRO="sFechaRegistro";
	public static final String ID_MAS="idMas";
	public static final String ID_CIR="idCir";
	public static final String USU_USUARIO = "idUsuario";	
	public static final String NOMCOMP_USUARIO = "nomCompleto";	

	public static final String CAD_REEMPL_VAL1 = "%%%VALOR1%%%";
	
	public static final String CAD_REEMPL_VAL2 = "%%%VALOR2%%%";
	
	public static final String CAD_REEMPL_VAL3 = "%%%VALOR3%%%";
	
	public static final String EMAIL_TXT_TEMA = "[Recuperación de Contraseña] - Sistema de Recepción y Archivo de Asuntos Jurídicos";
	
	public static final String EMAIL_TXT_TEMA2 = "[Bienvenido al Portal] - Sistema de Recepción y Archivo de Asuntos Jurídicos";
	
	public static final String EMAIL_TXT_MSG = "Estimado (a): %%%VALOR1%%% <br/><br/>" +
						"Te notificamos que se te ha asignado una nueva contraseña para el ingreso al portal. <br/><br/>" +
						"Su nueva contraseña es: %%%VALOR2%%% <br/><br/>" +
						"Atentamente, <br/>" + 
						"Secretaría de Economía <br/>" +
						"________________________________________ <br/><br/>" +
						"Boulevard Adolfo López Mateos N° 3025, Colonia San Jerónimo Aculco, Delegación Magdalena Contreras, C.P. 10700, México, Distrito Federal. <br/>" +
						" \"2013, Año de la Lealtad Institucional y Centenario del Ejército Mexicano\" <br/>" +
						"\"La información de este correo así como la contenida en los documentos que se adjuntan, puede ser objeto de solicitudes de acceso a la información\" <br/>";
	
	public static final String NUMERO_EXPEDIENTE = "numeroExpediente";
	
	public static final String PARAM_MODEL_USER = "InfoUser";
	
	public static final String EMAIL_TXT_MSG2 = "Estimado (a): %%%VALOR1%%% <br/><br/>" +
			"Bienvenido al Sistema de Control de Archivos Jurídicos. Le informamos que para poder acceder al sistema y hacer uso de todos los servicios que le brinda, " + 
			"tome en cuenta los siguientes datos: <br/><br/>" +
			"\t Usuario: %%%VALOR2%%% <br/><br/>" +
			"\t Contrase&ntilde;a: %%%VALOR3%%% <br/><br/>" +
			"Atentamente, <br/>" + 
			"Secretaría de Economía <br/>" +
			"________________________________________ <br/><br/>" +
			"Boulevard Adolfo López Mateos N° 3025, Colonia San Jerónimo Aculco, Delegación Magdalena Contreras, C.P. 10700, México, Distrito Federal. <br/>" +
			" \"2013, Año de la Lealtad Institucional y Centenario del Ejército Mexicano\" <br/>" +
			"\"La información de este correo así como la contenida en los documentos que se adjuntan, puede ser objeto de solicitudes de acceso a la información\" <br/>";
	
	
	public static final String PARAM_TIENE_EXP = "isExpInterno";
	
	public static final String PARAM_NUM_EXP = "NumExp";
	
	public static final String PARAM_CLASIFICACION = "Clasificacion";
	
	public static final String PARAM_DESCPUESTO = "DescCargo";
	
	public static final String PARAM_NUM_REG = "NumRegis";
	
	public static final String PARAM_FECH_REG = "FechRegis";
	
	public static final String PARAM_TIPO_JUICIO = "TipoJuicio";
	
	public static final String PARAM_TIENE_JUICIO = "IsConJuicio";
	
	public static final String PARAM_INSTRUCCION = "Instruccion";
	
	public static final String PARAM_RESPONSABLE = "Responsable";

	public static final String PARAM_PATH = "pathArchivo";
	
	public static final String ARCHIVO_REPORTE_VOLETA = "/mx/gob/se/sraaj/servicio/resource/Prueba.jrxml";	
	public static final String ARCHIVO_REPORTE_PDFEXPORT = "/mx/gob/se/sraaj/servicio/resource/PDFexport.jrxml";
	public static final String ARCHIVO_IMAGEN_LOGOSE = "/mx/gob/se/sraaj/servicio/resource/Logo.png";
	public static final String PARAM_IMAGEN_LOGOSE = "LogoSEParam";
	public static final String HEAD_PDF = "application/pdf";
	public static final String HEAD_EXCEL = "application/vnd.ms-excel";

}
