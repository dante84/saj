package mx.gob.se.sraaj.persistencia.dao;

import java.sql.Date;
import java.util.List;

import mx.gob.se.sraaj.comunes.bean.ComparecenciaIndiciadoBean;
import mx.gob.se.sraaj.comunes.bean.DenunciaHechosBean;
import mx.gob.se.sraaj.comunes.bean.DiligenciasMPBean;
import mx.gob.se.sraaj.comunes.bean.MediosPruebaBean;
import mx.gob.se.sraaj.comunes.bean.RequerimientosMPBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;

public interface AvenriguacionPreviaDAO 
{


	List<ComparecenciaIndiciadoBean> listaComparecencia(Integer idregdoc)
			throws SraajException;

	List<RequerimientosMPBean> listaRequerimientos(Integer idregdoc)
			throws SraajException;

	List<DiligenciasMPBean> listaDiligencias(Integer idregdoc)
			throws SraajException;

	List<DenunciaHechosBean> listaDenuncias(Integer idregdoc)
			throws SraajException;

	List<MediosPruebaBean> listaMediosPrueba(Integer idregdoc)
			throws SraajException;

	Boolean InsertarAveriguacionPrevia(Date AfechaComparecencia,
			String ApruebasComparecencia, String AobservacionesComparecencia,
			Date AfechaRequerimientos, String AoficioRequerimientos,
			String ArequerimientoRequerimientos,
			String AdesahogoRequerimientos,
			String AobservacionesRequerimientos, Date AfechaDiligencias,
			String AdiligenciaDiligencias, String AobservacionesDiligencias,
			Date AfechaDenuncia, String AoficioDenuncia,
			String AratificaDenuncia, Date AfecharatificaDenuncia,
			Date AfechaMedios, String AtestimonialesMedios,
			String ApericialesMedios, String AdocumentalesMedios,
			String AinspeccionMedios, String AotraMedios,
			String AobservacionesMedios, Integer Aidregdoc,
			Integer Aidcomparecencia, Integer Aidrequerimientos,
			Integer Aiddiligencia, Integer Aiddenuncia, Integer Aidmedios,
			Integer Aopc) throws SraajException;

}
