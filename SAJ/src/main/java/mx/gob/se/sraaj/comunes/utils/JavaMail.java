package mx.gob.se.sraaj.comunes.utils;

import java.io.File;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mx.gob.se.sraaj.servicio.mail.MsMailServiceFileProxy;
import mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMail;

public class JavaMail {
	
	private Properties properties;
	private static final String HOST = "mail.smtp.host";
	private static final String ENABLE = "mail.smtp.starttls.enable";
	private static final String PORT = "mail.smtp.port";
	private static final String USER = "mail.smtp.user";
	private static final String AUTH = "mail.smtp.auth";
	private static final String TIPO_TEXT = "text/html";
	private String sUser, sHost, sPwd, sAuth, sPort, sTransport;
	
	public void setsUser(String sUser){this.sUser=sUser; }
	public void setsHost(String sHost){this.sHost=sHost;}
	public void setsAuth(String Auth){this.sAuth=sAuth;}
	public void setsPort(String Port){this.sPort=sPort;}
	public void setsTransport(String STransport){this.sTransport=STransport;}

	/**Constructor de la clase.*/
	public JavaMail(){
		
	}
	
	/**
	 * @param sPwd the sPwd to set
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	public void setsPwd(String sPwd) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
	String sEnc = Utilerias.Desencripta(sPwd);
	this.sPwd = sEnc;
	}
	
	public boolean sendEmail(String sDestinatario, String sTema, String sMensaje, File[] afArchivos, int webService) throws MessagingException, RemoteException {
		
		if(webService == 1){
    		SendMailAttachmentMail mail = new SendMailAttachmentMail(null, null, 1, 23, "jSyMVWxIsy", sDestinatario, "", "", sTema, sMensaje);
    		MsMailServiceFileProxy sendMail = new MsMailServiceFileProxy();
    	
    		try{
    	  		sendMail.sendMailAttachment(mail);
    	  	    			
    		}
    		catch(Exception e){
    		}
    		return true;
    	}
    	else{
	    	properties = new Properties();
	        properties.put(HOST, sHost); 
	        properties.put(ENABLE, sAuth );  
	        properties.put(PORT, sPort);  
	        properties.put(USER, "usuario");  
	        properties.put(AUTH, "true");  
	
	        Session session = Session.getDefaultInstance(properties);
	        session.setDebug(false);
	    
	        MimeMessage mensaje = new MimeMessage(session);
	        mensaje.setFrom(new InternetAddress(sUser));
	        String sCorreoDestino = sDestinatario;
	        
	        String[] asCorreoDestino = null;
	        if( sCorreoDestino.indexOf( "," ) != 1 ) {
	            asCorreoDestino = sCorreoDestino.split("[,]");
	        } 
	        else {
	            asCorreoDestino = new String[1];
	            asCorreoDestino[0] = sCorreoDestino;        
	        }
	        
	        InternetAddress address[] = new InternetAddress[asCorreoDestino.length];  
	        
	        for( int i = 0; i < asCorreoDestino.length; i++ ) {            
	            address[i] = new InternetAddress ( asCorreoDestino[i] );        
	        }                            
	        mensaje.setRecipients (Message.RecipientType.TO, address);
	        
	        mensaje.setSubject(sTema);
	        mensaje.setContent(sMensaje, TIPO_TEXT);
	        BodyPart texto = new MimeBodyPart();
	        texto.setContent(sMensaje, TIPO_TEXT);
	        MimeMultipart correo = new MimeMultipart();
	        correo.addBodyPart(texto);
	        
	        if(afArchivos != null) {
	        	int iCantArchivos = afArchivos.length;
	        	BodyPart[] archivo = new MimeBodyPart[iCantArchivos];
	            for (int i = 0; i < iCantArchivos; i++) {
	                if(afArchivos[i].exists() && afArchivos[i].isFile()) {
	                    archivo[i] = new MimeBodyPart();
	                    archivo[i].setDataHandler(new DataHandler(new FileDataSource(afArchivos[i].getAbsolutePath())));
	                    archivo[i].setFileName(afArchivos[i].getName());
	                    correo.addBodyPart(archivo[i]);
	                }
	            }
	        }
	        
	        mensaje.setContent(correo, TIPO_TEXT);
	        Transport tSMTP = session.getTransport(sTransport);
	        tSMTP.connect(sUser, sPwd);
	        tSMTP.sendMessage(mensaje, mensaje.getAllRecipients());
	        tSMTP.close();
	        return true;
	    }
	}
	
}
