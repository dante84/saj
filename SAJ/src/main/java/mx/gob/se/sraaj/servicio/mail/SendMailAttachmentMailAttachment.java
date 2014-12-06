package mx.gob.se.sraaj.servicio.mail;

public class SendMailAttachmentMailAttachment  implements java.io.Serializable {
    private java.lang.String fileB64;  // attribute

    private java.lang.String fileName;  // attribute

    private java.lang.String fileContentType;  // attribute

    public SendMailAttachmentMailAttachment() {
    }

    public SendMailAttachmentMailAttachment(
           java.lang.String fileB64,
           java.lang.String fileName,
           java.lang.String fileContentType) {
           this.fileB64 = fileB64;
           this.fileName = fileName;
           this.fileContentType = fileContentType;
    }


    /**
     * Gets the fileB64 value for this SendMailAttachmentMailAttachment.
     * 
     * @return fileB64
     */
    public java.lang.String getFileB64() {
        return fileB64;
    }


    /**
     * Sets the fileB64 value for this SendMailAttachmentMailAttachment.
     * 
     * @param fileB64
     */
    public void setFileB64(java.lang.String fileB64) {
        this.fileB64 = fileB64;
    }


    /**
     * Gets the fileName value for this SendMailAttachmentMailAttachment.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this SendMailAttachmentMailAttachment.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the fileContentType value for this SendMailAttachmentMailAttachment.
     * 
     * @return fileContentType
     */
    public java.lang.String getFileContentType() {
        return fileContentType;
    }


    /**
     * Sets the fileContentType value for this SendMailAttachmentMailAttachment.
     * 
     * @param fileContentType
     */
    public void setFileContentType(java.lang.String fileContentType) {
        this.fileContentType = fileContentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendMailAttachmentMailAttachment)) return false;
        SendMailAttachmentMailAttachment other = (SendMailAttachmentMailAttachment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileB64==null && other.getFileB64()==null) || 
             (this.fileB64!=null &&
              this.fileB64.equals(other.getFileB64()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.fileContentType==null && other.getFileContentType()==null) || 
             (this.fileContentType!=null &&
              this.fileContentType.equals(other.getFileContentType())));
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
        if (getFileB64() != null) {
            _hashCode += getFileB64().hashCode();
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFileContentType() != null) {
            _hashCode += getFileContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendMailAttachmentMailAttachment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", ">>sendMail-Attachment>mail>attachment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fileB64");
        attrField.setXmlName(new javax.xml.namespace.QName("", "file-b64"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fileName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "file-name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fileContentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "file-content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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

}
