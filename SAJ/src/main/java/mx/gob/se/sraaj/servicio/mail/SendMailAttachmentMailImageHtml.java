package mx.gob.se.sraaj.servicio.mail;

public class SendMailAttachmentMailImageHtml  implements java.io.Serializable {
    private java.lang.String imageB64;  // attribute

    private java.lang.String contentId;  // attribute

    public SendMailAttachmentMailImageHtml() {
    }

    public SendMailAttachmentMailImageHtml(
           java.lang.String imageB64,
           java.lang.String contentId) {
           this.imageB64 = imageB64;
           this.contentId = contentId;
    }


    /**
     * Gets the imageB64 value for this SendMailAttachmentMailImageHtml.
     * 
     * @return imageB64
     */
    public java.lang.String getImageB64() {
        return imageB64;
    }


    /**
     * Sets the imageB64 value for this SendMailAttachmentMailImageHtml.
     * 
     * @param imageB64
     */
    public void setImageB64(java.lang.String imageB64) {
        this.imageB64 = imageB64;
    }


    /**
     * Gets the contentId value for this SendMailAttachmentMailImageHtml.
     * 
     * @return contentId
     */
    public java.lang.String getContentId() {
        return contentId;
    }


    /**
     * Sets the contentId value for this SendMailAttachmentMailImageHtml.
     * 
     * @param contentId
     */
    public void setContentId(java.lang.String contentId) {
        this.contentId = contentId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendMailAttachmentMailImageHtml)) return false;
        SendMailAttachmentMailImageHtml other = (SendMailAttachmentMailImageHtml) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.imageB64==null && other.getImageB64()==null) || 
             (this.imageB64!=null &&
              this.imageB64.equals(other.getImageB64()))) &&
            ((this.contentId==null && other.getContentId()==null) || 
             (this.contentId!=null &&
              this.contentId.equals(other.getContentId())));
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
        if (getImageB64() != null) {
            _hashCode += getImageB64().hashCode();
        }
        if (getContentId() != null) {
            _hashCode += getContentId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendMailAttachmentMailImageHtml.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", ">>sendMail-Attachment>mail>imageHtml"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("imageB64");
        attrField.setXmlName(new javax.xml.namespace.QName("", "image-b64"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anySimpleType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anySimpleType"));
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
