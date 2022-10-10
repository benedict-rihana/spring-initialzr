package benedict.zhang;

import benedict.zhang.datamodel.InitializeInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class Main {
  public static void main(String[] args) {
    System.out.println("Generating Spring Project....");
    // TODO Apache CLI implementation to read value from cmd line
    final var initializeInfo = new InitializeInfo("benedict.zhang", "my-service");
    final var urlBuilder = new RequestURLBuilder();
    final var initUrlStr = urlBuilder.withInitializeInfo(initializeInfo).build();
    if (initUrlStr != null) {
      System.out.println("start downloading project : " + initUrlStr);
      final var downlader = new SpringDownloader(initUrlStr);
      downlader.download(initializeInfo.getBaseDir() + ".zip");
    }
  }
}
