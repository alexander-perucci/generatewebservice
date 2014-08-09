package it.univaq.disim.generatewebservice;

import it.univaq.disim.generatewebservice.artifact.Pom;
import it.univaq.disim.generatewebservice.artifact.Context;
import it.univaq.disim.generatewebservice.artifact.WebXml;
import it.univaq.disim.generatewebservice.artifact.Sunjaxws;
import it.univaq.disim.generatewebservice.artifact.Index;
import it.univaq.disim.generatewebservice.artifact.ClassImplWebServiceInterface;
import it.univaq.disim.generatewebservice.model.WebService;
import it.univaq.disim.generatewebservice.model.Wsdl;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author alexander
 */
public class LoadWebService {
    private Properties properties;
    private WebService webService;
    
    
    public LoadWebService(InputStream propertyfile, String wsdlPath) throws IOException  {
        properties = new Properties();
        properties.load(propertyfile);
        webService = new WebService();
        load(wsdlPath);
    }
    
    public WebService getWebService(){
        return webService;
    }
    
    private void load (String wsdlPath)throws IOException{
        webService.setName(properties.getProperty("webservice.name"));
        webService.setPath(properties.getProperty("webservice.path"));
        
        Wsdl wsdl = new Wsdl();
        wsdl.setPath(wsdlPath);
        File wsdlFile = new File(wsdlPath);
        wsdl.setContent(FileUtils.readFileToString(wsdlFile));
        wsdl.setName(wsdlFile.getName());
        webService.setWsdlPath(wsdl);
        webService.setWsimportPackage(properties.getProperty("wsimport.package"));
        
        setPom();
        setContext();
        setWebXml();
        setSunjaxws();
        setIndex();
        setClassImplWebServiceInterface();
    }

    private void setPom() {
        Pom pom = new Pom();
        pom.setArtifactId(properties.getProperty("pom.artifactId"));
        pom.setName(properties.getProperty("pom.name"));
        pom.setGroupId(properties.getProperty("pom.groupId"));
        pom.setVersion(properties.getProperty("pom.version"));
        webService.setPom(pom);
    }
    
    private void setContext() {
        Context context = new Context();
        context.setPath(properties.getProperty("context.path"));
        webService.setContext(context);
    }

    private void setWebXml() {
        WebXml webXml = new WebXml();
        webXml.setDispalyName(properties.getProperty("webxml.dispalyName"));
        webXml.setServletName(properties.getProperty("webxml.servletName"));
        webXml.setUrlPattern(properties.getProperty("webxml.urlPattern"));
        webService.setWebXml(webXml);
    }
    
    private void setSunjaxws() {
        Sunjaxws sunjaxws = new Sunjaxws();
        sunjaxws.setName(properties.getProperty("sunjaxws.name"));
        sunjaxws.setInterfaceClass(properties.getProperty("sunjaxws.interfaceClass"));
        sunjaxws.setImplementationClass(properties.getProperty("sunjaxws.implementationClass"));
        sunjaxws.setName(properties.getProperty("sunjaxws.name"));
        sunjaxws.setUrlPattern(properties.getProperty("sunjaxws.urlPattern"));
        sunjaxws.setTargetNamespace(properties.getProperty("sunjaxws.targetNamespace"));
        sunjaxws.setPort(properties.getProperty("sunjaxws.port"));
        sunjaxws.setService(properties.getProperty("sunjaxws.service"));
        webService.setSunjaxws(sunjaxws);
    }
    
    private void setIndex() {
        Index index = new Index();
        index.setTitle(properties.getProperty("index.title"));
        index.setContent(properties.getProperty("index.content"));
        webService.setIndex(index);
    }

    private void setClassImplWebServiceInterface() {
        ClassImplWebServiceInterface ciwsi = new ClassImplWebServiceInterface();
        String interfaceClass = webService.getSunjaxws().getInterfaceClass();
        String implementationClass = webService.getSunjaxws().getImplementationClass();
        String packageString = implementationClass.lastIndexOf(".") < 0 ? implementationClass : implementationClass.substring(0, implementationClass.lastIndexOf("."));
        ciwsi.setPackageName(packageString);
        ciwsi.setClassName(implementationClass.substring(implementationClass.lastIndexOf(".")+1));
        ciwsi.setInterfaceName(interfaceClass.substring(interfaceClass.lastIndexOf(".")+1));
        ciwsi.setEndpointInterface(webService.getSunjaxws().getInterfaceClass());
        webService.setClassImplWebServiceInterface(ciwsi);
    }
    
    
}
