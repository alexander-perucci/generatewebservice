package it.univaq.disim.generatewebservice;

import it.univaq.disim.generatewebservice.artifact.Pom;
import it.univaq.disim.generatewebservice.artifact.Context;
import it.univaq.disim.generatewebservice.artifact.Index;
import it.univaq.disim.generatewebservice.artifact.Sunjaxws;
import it.univaq.disim.generatewebservice.artifact.WebXml;
import it.univaq.disim.generatewebservice.model.WebService;
import it.univaq.disim.generatewebservice.model.Wsdl;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 *
 * @author alexander
 */
public class GenerateWebService {

    //private static final String TEMPLATE_PATH = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    private static final String TEMPLATE_PATH = "/resources/";
    private WebService webService;
    private VelocityEngine velocityEngine;

    public GenerateWebService(WebService webService) {
        this.webService = webService;
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine = new VelocityEngine();
        velocityEngine.init(props);

    }

    public void generate() throws IOException {
        FileUtils.forceMkdir(new File(webService.getFullPath()));
        generatePom();
        generateContext();
        generateWebXml();
        generateSunjaxws();
        generateIndex();
        generateResourceFolder();
        generateWsdl();
        generateJavaFromWsdl();

    }

    private void generatePom() throws IOException, UnsupportedEncodingException {
        Template template = velocityEngine.getTemplate("templates/pom.vm");
        VelocityContext context = new VelocityContext();
        context.put("pom", webService.getPom());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        File file = new File(webService.getFullPath() + File.separator + Pom.ARTIFACT_NAME);
        FileUtils.writeStringToFile(file, writer.toString());

    }

    private void generateContext() throws IOException {
        Template template = velocityEngine.getTemplate("templates/context.vm");
        VelocityContext context = new VelocityContext();
        context.put("context", webService.getContext());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        File file = new File(webService.getFullPath() + File.separator + Context.ARTIFACT_PATH + Context.ARTIFACT_NAME);
        FileUtils.writeStringToFile(file, writer.toString());
    }

    private void generateWebXml() throws IOException {
        Template template = velocityEngine.getTemplate("templates/webxml.vm");
        VelocityContext context = new VelocityContext();
        context.put("webxml", webService.getWebXml());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        File file = new File(webService.getFullPath() + File.separator + WebXml.ARTIFACT_PATH + WebXml.ARTIFACT_NAME);
        FileUtils.writeStringToFile(file, writer.toString());
    }

    private void generateSunjaxws() throws IOException {
        Template template = velocityEngine.getTemplate("templates/sunjaxws.vm");
        VelocityContext context = new VelocityContext();
        context.put("sunjaxws", webService.getSunjaxws());
        context.put("wsdl", webService.getWsdl());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        File file = new File(webService.getFullPath() + File.separator + Sunjaxws.ARTIFACT_PATH + Sunjaxws.ARTIFACT_NAME);
        FileUtils.writeStringToFile(file, writer.toString());
    }

    private void generateIndex() throws IOException {
        Template template = velocityEngine.getTemplate("templates/index.vm");
        VelocityContext context = new VelocityContext();
        context.put("index", webService.getIndex());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        File file = new File(webService.getFullPath() + File.separator + Index.ARTIFACT_PATH + Index.ARTIFACT_NAME);
        FileUtils.writeStringToFile(file, writer.toString());
    }

    private void generateResourceFolder() throws IOException {
        String resourceFolder = webService.getFullPath() + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        FileUtils.forceMkdir(new File(resourceFolder));
    }

    private void generateWsdl() throws IOException {
        File file = new File(webService.getFullPath() + File.separator + Wsdl.ARTIFACT_PATH + webService.getWsdl().getName());
        FileUtils.writeStringToFile(file,webService.getWsdl().getContent());
    }

    private void generateJavaFromWsdl() throws IOException {
        String javaFolder = webService.getFullPath() + File.separator + "src" + File.separator + "main" + File.separator + "java";
        FileUtils.forceMkdir(new File(javaFolder));
        Runtime runtime = Runtime.getRuntime();
        if (webService.getWsimportPackage() !=null){
            Process process = runtime.exec("wsimport -verbose  -Xnocompile -d " + javaFolder + " -p "+webService.getWsimportPackage()+" "+webService.getWsdl().getPath() + "");
        }else{
            Process process = runtime.exec("wsimport -verbose  -Xnocompile -d " + javaFolder + " " + webService.getWsdl().getPath() + "");
        }
        

        Template template = velocityEngine.getTemplate("templates/classimpl.vm");
        VelocityContext context = new VelocityContext();
        context.put("classimpl", webService.getClassImplWebServiceInterface());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String implClassPath = webService.getSunjaxws().getImplementationClass().replace(".", File.separator);
        File file = new File(javaFolder + File.separator + implClassPath + ".java");
        FileUtils.writeStringToFile(file, writer.toString());
    }

}
