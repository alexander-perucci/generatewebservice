package it.univaq.disim.generatewebservice.artifact;

import java.io.File;

/**
 *
 * @author alexander
 */
public class Sunjaxws {
    public static final String ARTIFACT_NAME = "sun-jaxws.xml";
    public static final String ARTIFACT_PATH = "src"+File.separator+"main"+File.separator+"webapp"+File.separator+"WEB-INF"+File.separator;

    private String name;
    private String implementationClass;
    private String interfaceClass;
    private String urlPattern;
    private String targetNamespace;
    private String port;
    private String service;

    public Sunjaxws() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(String interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public String getImplementationClass() {
        return implementationClass;
    }

    public void setImplementationClass(String implementationClass) {
        this.implementationClass = implementationClass;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    
    

}
