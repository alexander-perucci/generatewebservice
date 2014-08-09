/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.univaq.disim.generatewebservice.model;

import java.io.File;

/**
 *
 * @author alexander
 */
public class Wsdl {
    public static final String ARTIFACT_PATH = "src"+File.separator+"main"+File.separator+"webapp"+File.separator+"WEB-INF"+File.separator+"wsdl"+File.separator;
    private String name;
    private String content;
    private String path;

    public Wsdl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
