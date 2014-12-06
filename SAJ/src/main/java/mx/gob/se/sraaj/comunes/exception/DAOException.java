package mx.gob.se.sraaj.comunes.exception;

public class DAOException extends SraajException {
	
	/**serial de la clase.*/
	private static final long serialVersionUID = 4493875553677664581L;
	
	/**
	 * @param errorMessage mensaje de error.
	 * @param throwable excepcion.
	 */
	public DAOException(String errorMessage, Throwable throwable){
		super(errorMessage, throwable);
	}
	
	/**
	 * @param errorMessage mensaje de error.
	 */
	public DAOException(String errorMessage){
		super (errorMessage);
	}

}
