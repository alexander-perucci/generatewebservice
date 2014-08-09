package it.univaq.disim.generatewebservice.artifact;

import java.io.File;

/**
 *
 * @author alexander
 */
public class Context {
    public static final String ARTIFACT_NAME = "context.xml";
    public static final String ARTIFACT_PATH = "src"+File.separator+"main"+File.separator+"webapp"+File.separator+"META-INF"+File.separator;
    
    private String path;

    public Context() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
