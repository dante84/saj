package mx.gob.se.sraaj.servicio.mail;

public class MailResponse  implements java.io.Serializable {
    private java.lang.Integer idMail;

    private java.lang.Integer result;

    private java.lang.String txResult;

    public MailResponse() {
    }

    public MailResponse(
           java.lang.Integer idMail,
           java.lang.Integer result,
           java.lang.String txResult) {
           this.idMail = idMail;
           this.result = result;
           this.txResult = txResult;
    }


    /**
     * Gets the idMail value for this MailResponse.
     * 
     * @return idMail
     */
    public java.lang.Integer getIdMail() {
        return idMail;
    }


    /**
     * Sets the idMail value for this MailResponse.
     * 
     * @param idMail
     */
    public void setIdMail(java.lang.Integer idMail) {
        this.idMail = idMail;
    }


    /**
     * Gets the result value for this MailResponse.
     * 
     * @return result
     */
    public java.lang.Integer getResult() {
        return result;
    }


    /**
     * Sets the result value for this MailResponse.
     * 
     * @param result
     */
    public void setResult(java.lang.Integer result) {
        this.result = result;
    }


    /**
     * Gets the txResult value for this MailResponse.
     * 
     * @return txResult
     */
    public java.lang.String getTxResult() {
        return txResult;
    }


    /**
     * Sets the txResult value for this MailResponse.
     * 
     * @param txResult
     */
    public void setTxResult(java.lang.String txResult) {
        this.txResult = txResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailResponse)) return false;
        MailResponse other = (MailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idMail==null && other.getIdMail()==null) || 
             (this.idMail!=null &&
              this.idMail.equals(other.getIdMail()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
            ((this.txResult==null && other.getTxResult()==null) || 
             (this.txResult!=null &&
              this.txResult.equals(other.getTxResult())));
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
        if (getIdMail() != null) {
            _hashCode += getIdMail().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        if (getTxResult() != null) {
            _hashCode += getTxResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", "mailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "txResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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

}
