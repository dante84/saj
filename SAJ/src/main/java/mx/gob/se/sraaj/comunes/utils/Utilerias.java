package mx.gob.se.sraaj.comunes.utils;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import mx.gob.se.sraaj.transferencia.beanImpl.SesionBeanImpl;

/**
 * Clase que implementa el metodo de encripci�n para las contrase�as.
 * @author EISEI
 *
 */
public class Utilerias {
	
	/** Cadena base para encriptar. */
	private static String key = "5ra4J_S3_JuR1dc0";
	
	/**
	 * Metodo que encripta por SHA1.
	 * @param input Cadena sin encriptar
	 * @return Cadena encriptada
	 * @throws NoSuchAlgorithmException Excepcion cuando existe un error.
	 */
	public static String encriptaPassword(String input) throws NoSuchAlgorithmException {
	        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
	    }
	
	/**
	 * Metodo que valida si existe una sesion activa asi como el ID de sesion valido.
	 * @param req Objeto petici�n.
	 * @return True o False segun sea el caso.
	 */
	public static boolean isLogin(HttpServletRequest req) {
		HttpSession sesion = req.getSession(false);
		if(sesion != null) {
			SesionBeanImpl sesionVO = (SesionBeanImpl) sesion.getAttribute(Constantes.ATTR_SESION_VO);
			if(sesionVO != null) {
				String sID = sesionVO.getIdSesion();
				if(sID != null) {
					if(Constantes.STR_ID_SESION.equals(sesionVO.getIdSesion().substring(0, 5))) {
					return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo que encripta una cadena por el algoritmo DES.
	 * @param sCadenaAEncriptar Cadena a encriptar.
	 * @return Cadena encriptada.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 */
    public static String Encripta(String sCadenaAEncriptar) throws NoSuchAlgorithmException, NoSuchPaddingException, 
    		InvalidKeyException, IllegalBlockSizeException, 
    		BadPaddingException, InvalidKeySpecException {

            Key kClaveAux = TransformaClave(key);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, kClaveAux);

            byte[] byteEncriptar = sCadenaAEncriptar.getBytes();
            byte[] byteCipherText = cipher.doFinal(byteEncriptar);

            String sCadenaEncriptada = new String(Base64.encodeBase64(byteCipherText));
            return sCadenaEncriptada;
    }
    
    /**
     * Metodo que desencripta una cadena.
     * @param sTextoEncriptado Cadena encriptada.
     * @return Cadena desencriptada.
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeySpecException
     */
    public static String Desencripta(String sTextoEncriptado) throws NoSuchAlgorithmException, 
    		NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, 
    		BadPaddingException, InvalidKeySpecException {
           
        Key kClaveAux = TransformaClave(key);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, kClaveAux);
        byte[] byteCryptedText1 = Base64.decodeBase64(sTextoEncriptado.getBytes());
        byte[] byteDecryptedText = cipher.doFinal(byteCryptedText1);
        String sCadenaDesencriptada = new String(byteDecryptedText);
        return sCadenaDesencriptada;
    }

    /**
     * Metodo que genera una llave para encripci�n.
     * @param sClave Cadena usada como llave.
     * @return Objeto Key para encriptar.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    private static Key TransformaClave(String sClave) throws NoSuchAlgorithmException, 
    		InvalidKeyException, InvalidKeySpecException {
        Key kClave = null;
        byte[] secret = sClave.getBytes();
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        kClave = skf.generateSecret(new DESKeySpec(secret));
        return kClave;
    }

}
