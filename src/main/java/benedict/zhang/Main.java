package benedict.zhang;

import benedict.zhang.datamodel.InitializeInfo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;

import benedict.zhang.datamodel.SpringInitOptions;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {
        var optionParser = new BasicParser();
        String groupId = null;
        String artifactId = null;
        try {
            var cmdLine = optionParser.parse(SpringInitOptions.OPTIONS, args);
            if (cmdLine.hasOption("artifact-id") && cmdLine.hasOption("group-id")) {
                artifactId = cmdLine.getOptionValue("artifact-id");
                groupId = cmdLine.getOptionValue("group-id");
            } else {
                printHelp();
                return;
            }
        } catch (ParseException e) {
            printHelp();
        }
        if (groupId == null && artifactId == null) {
            printHelp();
            return;
        }
        System.out.println("Generating Spring Project: groupId=" + groupId + "\tartifactId=" + artifactId);
        // TODO Apache CLI implementation to read value from cmd line
        final var initializeInfo = new InitializeInfo(groupId, artifactId);
        final var urlBuilder = new RequestURLBuilder();
        final var initUrlStr = urlBuilder.withInitializeInfo(initializeInfo).build();
        if (initUrlStr != null) {
            System.out.println("start downloading project : " + initUrlStr);
            final var downlader = new SpringDownloader(initUrlStr);
            downlader.download(initializeInfo.getBaseDir() + ".zip");
        }
    }

    private static void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("app", SpringInitOptions.OPTIONS);
    }
}
