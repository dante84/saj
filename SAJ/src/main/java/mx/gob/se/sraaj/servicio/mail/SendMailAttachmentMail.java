package mx.gob.se.sraaj.servicio.mail;

import java.util.Arrays;

import org.apache.axis.description.TypeDesc;

public class SendMailAttachmentMail  implements java.io.Serializable {
    private mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment[] attachment;

    private mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml[] imageHtml;

    private int idTipoCorreo;  // attribute

    private int idMailAccount;  // attribute

    private java.lang.String passwordSe;  // attribute

    private java.lang.String destinatario;  // attribute

    private java.lang.String destinatarioCc;  // attribute

    private java.lang.String destinatarioCco;  // attribute

    private java.lang.String asunto;  // attribute

    private java.lang.String mensaje;  // attribute

    public SendMailAttachmentMail() {
    }

    public SendMailAttachmentMail(
           mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment[] attachment,
           mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml[] imageHtml,
           int idTipoCorreo,
           int idMailAccount,
           java.lang.String passwordSe,
           java.lang.String destinatario,
           java.lang.String destinatarioCc,
           java.lang.String destinatarioCco,
           java.lang.String asunto,
           java.lang.String mensaje) {
           this.attachment = attachment;
           this.imageHtml = imageHtml;
           this.idTipoCorreo = idTipoCorreo;
           this.idMailAccount = idMailAccount;
           this.passwordSe = passwordSe;
           this.destinatario = destinatario;
           this.destinatarioCc = destinatarioCc;
           this.destinatarioCco = destinatarioCco;
           this.asunto = asunto;
           this.mensaje = mensaje;
    }


    /**
     * Gets the attachment value for this SendMailAttachmentMail.
     * 
     * @return attachment
     */
    public mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment[] getAttachment() {
        return attachment;
    }


    /**
     * Sets the attachment value for this SendMailAttachmentMail.
     * 
     * @param attachment
     */
    public void setAttachment(mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment[] attachment) {
        this.attachment = attachment;
    }

    public mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment getAttachment(int i) {
        return this.attachment[i];
    }

    public void setAttachment(int i, mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailAttachment _value) {
        this.attachment[i] = _value;
    }


    /**
     * Gets the imageHtml value for this SendMailAttachmentMail.
     * 
     * @return imageHtml
     */
    public mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml[] getImageHtml() {
        return imageHtml;
    }


    /**
     * Sets the imageHtml value for this SendMailAttachmentMail.
     * 
     * @param imageHtml
     */
    public void setImageHtml(mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml[] imageHtml) {
        this.imageHtml = imageHtml;
    }

    public mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml getImageHtml(int i) {
        return this.imageHtml[i];
    }

    public void setImageHtml(int i, mx.gob.se.sraaj.servicio.mail.SendMailAttachmentMailImageHtml _value) {
        this.imageHtml[i] = _value;
    }


    /**
     * Gets the idTipoCorreo value for this SendMailAttachmentMail.
     * 
     * @return idTipoCorreo
     */
    public int getIdTipoCorreo() {
        return idTipoCorreo;
    }


    /**
     * Sets the idTipoCorreo value for this SendMailAttachmentMail.
     * 
     * @param idTipoCorreo
     */
    public void setIdTipoCorreo(int idTipoCorreo) {
        this.idTipoCorreo = idTipoCorreo;
    }


    /**
     * Gets the idMailAccount value for this SendMailAttachmentMail.
     * 
     * @return idMailAccount
     */
    public int getIdMailAccount() {
        return idMailAccount;
    }


    /**
     * Sets the idMailAccount value for this SendMailAttachmentMail.
     * 
     * @param idMailAccount
     */
    public void setIdMailAccount(int idMailAccount) {
        this.idMailAccount = idMailAccount;
    }


    /**
     * Gets the passwordSe value for this SendMailAttachmentMail.
     * 
     * @return passwordSe
     */
    public java.lang.String getPasswordSe() {
        return passwordSe;
    }


    /**
     * Sets the passwordSe value for this SendMailAttachmentMail.
     * 
     * @param passwordSe
     */
    public void setPasswordSe(java.lang.String passwordSe) {
        this.passwordSe = passwordSe;
    }


    /**
     * Gets the destinatario value for this SendMailAttachmentMail.
     * 
     * @return destinatario
     */
    public java.lang.String getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this SendMailAttachmentMail.
     * 
     * @param destinatario
     */
    public void setDestinatario(java.lang.String destinatario) {
        this.destinatario = destinatario;
    }


    /**
     * Gets the destinatarioCc value for this SendMailAttachmentMail.
     * 
     * @return destinatarioCc
     */
    public java.lang.String getDestinatarioCc() {
        return destinatarioCc;
    }


    /**
     * Sets the destinatarioCc value for this SendMailAttachmentMail.
     * 
     * @param destinatarioCc
     */
    public void setDestinatarioCc(java.lang.String destinatarioCc) {
        this.destinatarioCc = destinatarioCc;
    }


    /**
     * Gets the destinatarioCco value for this SendMailAttachmentMail.
     * 
     * @return destinatarioCco
     */
    public java.lang.String getDestinatarioCco() {
        return destinatarioCco;
    }


    /**
     * Sets the destinatarioCco value for this SendMailAttachmentMail.
     * 
     * @param destinatarioCco
     */
    public void setDestinatarioCco(java.lang.String destinatarioCco) {
        this.destinatarioCco = destinatarioCco;
    }


    /**
     * Gets the asunto value for this SendMailAttachmentMail.
     * 
     * @return asunto
     */
    public java.lang.String getAsunto() {
        return asunto;
    }


    /**
     * Sets the asunto value for this SendMailAttachmentMail.
     * 
     * @param asunto
     */
    public void setAsunto(java.lang.String asunto) {
        this.asunto = asunto;
    }


    /**
     * Gets the mensaje value for this SendMailAttachmentMail.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this SendMailAttachmentMail.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendMailAttachmentMail)) return false;
        SendMailAttachmentMail other = (SendMailAttachmentMail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.attachment==null && other.getAttachment()==null) || 
             (this.attachment!=null &&
              java.util.Arrays.equals(this.attachment, other.getAttachment()))) &&
            ((this.imageHtml==null && other.getImageHtml()==null) || 
             (this.imageHtml!=null &&
              java.util.Arrays.equals(this.imageHtml, other.getImageHtml()))) &&
            this.idTipoCorreo == other.getIdTipoCorreo() &&
            this.idMailAccount == other.getIdMailAccount() &&
            ((this.passwordSe==null && other.getPasswordSe()==null) || 
             (this.passwordSe!=null &&
              this.passwordSe.equals(other.getPasswordSe()))) &&
            ((this.destinatario==null && other.getDestinatario()==null) || 
             (this.destinatario!=null &&
              this.destinatario.equals(other.getDestinatario()))) &&
            ((this.destinatarioCc==null && other.getDestinatarioCc()==null) || 
             (this.destinatarioCc!=null &&
              this.destinatarioCc.equals(other.getDestinatarioCc()))) &&
            ((this.destinatarioCco==null && other.getDestinatarioCco()==null) || 
             (this.destinatarioCco!=null &&
              this.destinatarioCco.equals(other.getDestinatarioCco()))) &&
            ((this.asunto==null && other.getAsunto()==null) || 
             (this.asunto!=null &&
              this.asunto.equals(other.getAsunto()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAttachment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImageHtml() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImageHtml());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImageHtml(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getIdTipoCorreo();
        _hashCode += getIdMailAccount();
        if (getPasswordSe() != null) {
            _hashCode += getPasswordSe().hashCode();
        }
        if (getDestinatario() != null) {
            _hashCode += getDestinatario().hashCode();
        }
        if (getDestinatarioCc() != null) {
            _hashCode += getDestinatarioCc().hashCode();
        }
        if (getDestinatarioCco() != null) {
            _hashCode += getDestinatarioCco().hashCode();
        }
        if (getAsunto() != null) {
            _hashCode += getAsunto().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(SendMailAttachmentMail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", ">sendMail-Attachment>mail"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("idTipoCorreo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id-tipo-correo"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("idMailAccount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id-mail-account"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("passwordSe");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password-se"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("destinatario");
        attrField.setXmlName(new javax.xml.namespace.QName("", "destinatario"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("destinatarioCc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "destinatario-cc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("destinatarioCco");
        attrField.setXmlName(new javax.xml.namespace.QName("", "destinatario-cco"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("asunto");
        attrField.setXmlName(new javax.xml.namespace.QName("", "asunto"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mensaje");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", ">>sendMail-Attachment>mail>attachment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imageHtml");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imageHtml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", ">>sendMail-Attachment>mail>imageHtml"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SendMailAttachmentMail [attachment="
				+ Arrays.toString(attachment) + ", imageHtml="
				+ Arrays.toString(imageHtml) + ", idTipoCorreo=" + idTipoCorreo
				+ ", idMailAccount=" + idMailAccount + ", passwordSe="
				+ passwordSe + ", destinatario=" + destinatario
				+ ", destinatarioCc=" + destinatarioCc + ", destinatarioCco="
				+ destinatarioCco + ", asunto=" + asunto + ", mensaje="
				+ mensaje + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

}
