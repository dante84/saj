package mx.gob.se.sraaj.servicio.mail;

public class MailAttachServiceServiceLocator extends org.apache.axis.client.Service implements mx.gob.se.sraaj.servicio.mail.MailAttachServiceService {

    public MailAttachServiceServiceLocator() {
    }


    public MailAttachServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MailAttachServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MsMailServiceFilePort
    private java.lang.String MsMailServiceFilePort_address = "http://10.100.12.40:1880/MsMail/MailAttachServiceService?wsdl";

    public java.lang.String getMsMailServiceFilePortAddress() {
        return MsMailServiceFilePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MsMailServiceFilePortWSDDServiceName = "MsMailServiceFilePort";

    public java.lang.String getMsMailServiceFilePortWSDDServiceName() {
        return MsMailServiceFilePortWSDDServiceName;
    }

    public void setMsMailServiceFilePortWSDDServiceName(java.lang.String name) {
        MsMailServiceFilePortWSDDServiceName = name;
    }

    public mx.gob.se.sraaj.servicio.mail.MsMailServiceFile getMsMailServiceFilePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MsMailServiceFilePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMsMailServiceFilePort(endpoint);
    }

    public mx.gob.se.sraaj.servicio.mail.MsMailServiceFile getMsMailServiceFilePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.gob.se.sraaj.servicio.mail.MsMailServiceFilePortBindingStub _stub = new mx.gob.se.sraaj.servicio.mail.MsMailServiceFilePortBindingStub(portAddress, this);
            _stub.setPortName(getMsMailServiceFilePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMsMailServiceFilePortEndpointAddress(java.lang.String address) {
        MsMailServiceFilePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.gob.se.sraaj.servicio.mail.MsMailServiceFile.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.gob.se.sraaj.servicio.mail.MsMailServiceFilePortBindingStub _stub = new mx.gob.se.sraaj.servicio.mail.MsMailServiceFilePortBindingStub(new java.net.URL(MsMailServiceFilePort_address), this);
                _stub.setPortName(getMsMailServiceFilePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MsMailServiceFilePort".equals(inputPortName)) {
            return getMsMailServiceFilePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", "MailAttachServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mail.gob.se.mx/", "MsMailServiceFilePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MsMailServiceFilePort".equals(portName)) {
            setMsMailServiceFilePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
            
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
