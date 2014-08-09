package it.univaq.disim.generatewebservice.artifact;

import it.univaq.disim.generatewebservice.model.PomDempendency;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander
 */
public class Pom {
    public static final String ARTIFACT_NAME = "pom.xml";
    
    private String groupId;
    private String artifactId;
    private String version;
    private String name;
    private List<PomDempendency> pomdempendencies;

    public Pom() {
        pomdempendencies = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
                
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public List<PomDempendency> getPomdempendencies() {
        return pomdempendencies;
    }

    public void setPomdempendencies(List<PomDempendency> pomdempendencies) {
        this.pomdempendencies = pomdempendencies;
    }
      
            
            
}
