package it.univaq.disim.generatewebservice.artifact;

import java.io.File;

/**
 *
 * @author alexander
 */
public class WebXml {
    public static final String ARTIFACT_NAME = "web.xml";
    public static final String ARTIFACT_PATH = "src"+File.separator+"main"+File.separator+"webapp"+File.separator+"WEB-INF"+File.separator;

    
    private String dispalyName;
    private String servletName;
    private String urlPattern;

    public WebXml() {
    }

    public String getDispalyName() {
        return dispalyName;
    }

    public void setDispalyName(String dispalyName) {
        this.dispalyName = dispalyName;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }
    
    
}
