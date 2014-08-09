package it.univaq.disim.generatewebservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.cli.CommandLineParser;

/**
 *
 * @author alexander
 */
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    private static String propertyClient;
    private static String wsdl;

    public static void printHelp(
            final Options options,
            final int printedRowWidth,
            final String header,
            final String footer,
            final int spacesBeforeOption,
            final int spacesBeforeOptionDescription,
            final boolean displayUsage,
            final OutputStream out) {
        final String commandLineSyntax = "java generateWebService.jar";
        final PrintWriter writer = new PrintWriter(out);
        final HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp(
                writer,
                printedRowWidth,
                commandLineSyntax,
                header,
                options,
                spacesBeforeOption,
                spacesBeforeOptionDescription,
                footer,
                displayUsage);
        writer.flush();
    }

    public static void main(String[] args) throws IOException, ParseException {
        Options options = new Options();
        options.addOption("p", true, "Properties file configuration")
                .addOption("wsdl", true, "Wsdl");

        CommandLineParser parser = new GnuParser();
        CommandLine commandLine = parser.parse(options, args);
        if (commandLine.hasOption("p") && commandLine.hasOption("wsdl")) {
            propertyClient = commandLine.getOptionValue("p");
            wsdl = commandLine.getOptionValue("wsdl");
            File filePropertyClient = new File(propertyClient);
            LoadWebService loadWebService = new LoadWebService(new FileInputStream(filePropertyClient), wsdl);
            GenerateWebService generateWebService = new GenerateWebService(loadWebService.getWebService());
            generateWebService.generate();
        } else {
            printHelp(options, 80, "", "", 5, 3, true, System.out);
        }

    }
}
