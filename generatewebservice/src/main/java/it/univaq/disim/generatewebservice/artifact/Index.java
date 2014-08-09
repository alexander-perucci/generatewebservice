package it.univaq.disim.generatewebservice.artifact;

import java.io.File;

/**
 *
 * @author alexander
 */
public class Index {
    public static final String ARTIFACT_NAME = "index.jsp";
    public static final String ARTIFACT_PATH = "src"+File.separator+"main"+File.separator+"webapp"+File.separator;

    
    private String title;
    private String content;

    public Index() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
