package mx.gob.se.sraaj.comunes.exception;

public class SraajException extends Exception {
	
	/**Serial de la clase.*/
	private static final long serialVersionUID = -3073628837449209374L;
	/**Mensaje de error.*/
	private String errorMessage;
	/**Objeto de excepcion.*/
	private Throwable throwable;
	
	/**
	 * Constructor sobrecargado.
	 * @param SmSErr nombre del error.
	 * @param throwable Error.
	 */
	public SraajException(String sMsErr, Throwable throwable){
		 super (sMsErr, throwable);
		 this.errorMessage=sMsErr;
		 this.throwable=throwable;
	 }
	
	/**
	 * Constructor sobrecargado.
	 * @param sMsErr Nombre del Error.
	 */
	public SraajException(String sMsErr){
		super(sMsErr);
		this.errorMessage = sMsErr;
	}
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage(){
		return errorMessage;
	}
	
	/**
	 * @return the throwable
	 */
	public Throwable getThrowable(){
		return throwable;
	}

}
