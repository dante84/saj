package mx.gob.se.sraaj.servicio.mail;

public class MsMailServiceFileProxy implements mx.gob.se.sraaj.servicio.mail.MsMailServiceFile {
	  private String _endpoint = null;
	  private mx.gob.se.sraaj.servicio.mail.MsMailServiceFile msMailServiceFile = null;
	  
	  public MsMailServiceFileProxy() {
	    _initMsMailServiceFileProxy();
	  }
	  
	  public MsMailServiceFileProxy(String endpoint) {
	    _endpoint = endpoint;
	    _initMsMailServiceFileProxy();
	  }
	  
	  private void _initMsMailServiceFileProxy() {
	    try {
	      msMailServiceFile = null;// (new mx.gob.se.sraaj.servicio.mail.MailAttachServiceServiceLocator()).getMsMailServiceFilePort();
	      if (msMailServiceFile != null) {
	        if (_endpoint != null){}
//	         // ((javax.xml.rpc.Stub)msMailServiceFile)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
//	        else
//	          _endpoint = null;//(String)((javax.xml.rpc.Stub)msMailServiceFile)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (Exception serviceException) {}
	  }
	  
	  public String getEndpoint() {
	    return _endpoint;
	  }
	  
	  public void setEndpoint(String endpoint) {
	    _endpoint = endpoint;
//	    if (msMailServiceFile != null)
//	      ((javax.xml.rpc.Stub)msMailServiceFile)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
//	    
//	  }
	  }
	  
	  public mx.gob.se.sraaj.servicio.mail.MsMailServiceFile getMsMailServiceFile() {
	    if (msMailServiceFile == null)
	      _initMsMailServiceFileProxy();
	    return msMailServiceFile;
	  }
	  
	  public mx.gob.se.sraaj.servicio.mail.MailResponse sendMailAttachment(mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMail mail) throws java.rmi.RemoteException{
	    if (msMailServiceFile == null){
	      _initMsMailServiceFileProxy(); }
	    return msMailServiceFile.sendMailAttachment(mail);
	  }
	  
	  
	}