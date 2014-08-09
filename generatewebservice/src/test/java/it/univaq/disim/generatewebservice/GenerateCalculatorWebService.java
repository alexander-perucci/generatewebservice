package it.univaq.disim.generatewebservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author alexander
 */
public class GenerateCalculatorWebService {
    
    private static final String propertyClient = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "calculator.properties";
    private static final String wsdl = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "calculator.wsdl";
    public static void main (String[] args) throws IOException{
        File filePropertyClient = new File(propertyClient);
        LoadWebService loadWebService = new LoadWebService(new FileInputStream(filePropertyClient),wsdl);
        GenerateWebService generateWebService = new GenerateWebService(loadWebService.getWebService());
        generateWebService.generate();
        
    }
}

