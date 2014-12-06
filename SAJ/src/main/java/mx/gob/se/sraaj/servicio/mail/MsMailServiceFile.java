package mx.gob.se.sraaj.servicio.mail;

public interface MsMailServiceFile extends java.rmi.Remote {
    public mx.gob.se.sraaj.servicio.mail.MailResponse sendMailAttachment(mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMail mail) throws java.rmi.RemoteException;
}
