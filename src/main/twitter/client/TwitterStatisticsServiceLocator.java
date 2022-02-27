/**
 * TwitterStatisticsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twitter.client;

public class TwitterStatisticsServiceLocator extends org.apache.axis.client.Service implements twitter.client.TwitterStatisticsService {

    public TwitterStatisticsServiceLocator() {
    }


    public TwitterStatisticsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TwitterStatisticsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for twitter
    private java.lang.String twitter_address = "http://localhost:8080/axis/services/twitter";

    public java.lang.String gettwitterAddress() {
        return twitter_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String twitterWSDDServiceName = "twitter";

    public java.lang.String gettwitterWSDDServiceName() {
        return twitterWSDDServiceName;
    }

    public void settwitterWSDDServiceName(java.lang.String name) {
        twitterWSDDServiceName = name;
    }

    public twitter.client.TwitterStatistics gettwitter() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(twitter_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettwitter(endpoint);
    }

    public twitter.client.TwitterStatistics gettwitter(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            twitter.client.TwitterSoapBindingStub _stub = new twitter.client.TwitterSoapBindingStub(portAddress, this);
            _stub.setPortName(gettwitterWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settwitterEndpointAddress(java.lang.String address) {
        twitter_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (twitter.client.TwitterStatistics.class.isAssignableFrom(serviceEndpointInterface)) {
                twitter.client.TwitterSoapBindingStub _stub = new twitter.client.TwitterSoapBindingStub(new java.net.URL(twitter_address), this);
                _stub.setPortName(gettwitterWSDDServiceName());
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
        if ("twitter".equals(inputPortName)) {
            return gettwitter();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/services/twitter", "TwitterStatisticsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/services/twitter", "twitter"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("twitter".equals(portName)) {
            settwitterEndpointAddress(address);
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
