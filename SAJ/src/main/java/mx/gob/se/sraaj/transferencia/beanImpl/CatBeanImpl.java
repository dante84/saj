package mx.gob.se.sraaj.transferencia.beanImpl;

import java.util.List;

import mx.gob.se.sraaj.comunes.bean.CatGeneralBean;
import mx.gob.se.sraaj.transferencia.bean.CatBean;

public class CatBeanImpl implements CatBean {
	  
	/**
	 * variables
	 */
	private List<CatGeneralBean> catGeneralBean;

	/**
	 * getter's and setter's
	 * @return catGeneralBean
	 */
	public List<CatGeneralBean> getCatGeneralBean() { return catGeneralBean; }
	public void setCatGeneralBean(List<CatGeneralBean> catGeneralBean) { this.catGeneralBean = catGeneralBean; } 	
}
