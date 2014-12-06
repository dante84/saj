package mx.gob.se.sraaj.presentacion.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.gob.se.sraaj.comunes.bean.DocumentosRelBean;
import mx.gob.se.sraaj.comunes.exception.SraajException;
import mx.gob.se.sraaj.persistencia.daoImpl.SeguimientoDAOImpl;



@ManagedBean(name="CDocumentos")
@SessionScoped
public class ControladorDocumentos implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{seguimientoDAOImpl}")
	private SeguimientoDAOImpl seguimientoDAOImpl;
	
	private List<DocumentosRelBean> obtenerDocumentos;
	private List<String> instruc;
	private String noJuicio;
	private Integer noExp;
	private String promo;
	
	
	public String cargar(String idfolio, String promo, Integer noX)
	{
		System.out.println(idfolio);
		setNoJuicio(idfolio);
		setPromo(promo);
		setNoExp(noX);
		try 
		{
			setObtenerDocumentos(seguimientoDAOImpl.obtenerDocumentos(idfolio));
		} 
		catch (SraajException e) 
		{
			e.printStackTrace();
		}
		System.out.println(obtenerDocumentos.size());
		obtenerInstruccion();
		return "documetosRel";
	}
	 
	
	public void obtenerInstruccion()
	{
		if(obtenerDocumentos != null)
		{
			for(int i = 0; i < obtenerDocumentos.size(); i++)
			{
				if(getObtenerDocumentos().get(i).getNumreg() == 0)
				{
					getObtenerDocumentos().get(i).setNumreg(null);
				}
			}
		}
	}

	public SeguimientoDAOImpl getSeguimientoDAOImpl() {
		return seguimientoDAOImpl;
	}

	public void setSeguimientoDAOImpl(SeguimientoDAOImpl seguimientoDAOImpl) {
		this.seguimientoDAOImpl = seguimientoDAOImpl;
	}

	public List<DocumentosRelBean> getObtenerDocumentos() {
		return obtenerDocumentos;
	}

	public void setObtenerDocumentos(List<DocumentosRelBean> obtenerDocumentos) {
		this.obtenerDocumentos = obtenerDocumentos;
	}

	public void setInstruc(List<String> instruc) {
		this.instruc = instruc;
	}


	public Integer getNoExp() {
		return noExp;
	}


	public void setNoExp(Integer noExp) {
		this.noExp = noExp;
	}


	public String getPromo() {
		return promo;
	}


	public void setPromo(String promo) {
		this.promo = promo;
	}


	public List<String> getInstruc() {
		return instruc;
	}


	public String getNoJuicio() {
		return noJuicio;
	}


	public void setNoJuicio(String noJuicio) {
		this.noJuicio = noJuicio;
	}
	
}
