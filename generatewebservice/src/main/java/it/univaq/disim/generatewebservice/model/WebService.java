package it.univaq.disim.generatewebservice.model;

import it.univaq.disim.generatewebservice.artifact.ClassImplWebServiceInterface;
import it.univaq.disim.generatewebservice.artifact.Context;
import it.univaq.disim.generatewebservice.artifact.Index;
import it.univaq.disim.generatewebservice.artifact.Pom;
import it.univaq.disim.generatewebservice.artifact.Sunjaxws;
import it.univaq.disim.generatewebservice.artifact.WebXml;
import java.io.File;

/**
 *
 * @author alexander
 */
public class WebService {
    private String path;
    private String name;
    private Wsdl wsdl;
    private String wsimportPackage;
    
    private Context context;
    private Index index;
    private Pom pom;
    private Sunjaxws sunjaxws;
    private WebXml webXml;
    private ClassImplWebServiceInterface classImplWebServiceInterface;

    public WebService() {
        
    }

    public Wsdl getWsdl() {
        return wsdl;
    }

    public void setWsdlPath(Wsdl wsdl) {
        this.wsdl = wsdl;
    }

    public String getFullPath(){
        return path + File.separator + name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Pom getPom() {
        return pom;
    }

    public void setPom(Pom pom) {
        this.pom = pom;
    }

    public Sunjaxws getSunjaxws() {
        return sunjaxws;
    }

    public void setSunjaxws(Sunjaxws sunjaxws) {
        this.sunjaxws = sunjaxws;
    }

    public WebXml getWebXml() {
        return webXml;
    }

    public void setWebXml(WebXml webXml) {
        this.webXml = webXml;
    }

    public ClassImplWebServiceInterface getClassImplWebServiceInterface() {
        return classImplWebServiceInterface;
    }

    public void setClassImplWebServiceInterface(ClassImplWebServiceInterface classImplWebServiceInterface) {
        this.classImplWebServiceInterface = classImplWebServiceInterface;
    }

    public String getWsimportPackage() {
        return wsimportPackage;
    }

    public void setWsimportPackage(String wsimportPackage) {
        this.wsimportPackage = wsimportPackage;
    }

   
    
    
}
