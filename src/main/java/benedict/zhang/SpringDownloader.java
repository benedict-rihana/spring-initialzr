package benedict.zhang;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * SpringDownloader
 */
public class SpringDownloader {

  private final String urlStr;

  public SpringDownloader(String url) {
    this.urlStr = url;
  }

  public void download(String toPath) {
    try {
      final var client = new OkHttpClient();
      final var request = (new Request.Builder()).url(urlStr).build();

      try (var resonse = client.newCall(request).execute()) {
        // try (var fos = new BufferedOutputStream(
        // new FileOutputStream(new File(toPath)))) {
        // final var dis = resonse.body().byteStream();
        // System.out.println("Downloading total size" + dis.available());
        // var buffer = new byte[dis.available()];
        // dis.read(buffer);
        // fos.write(buffer);
        // } catch (Exception e) {
        // throw e;
        // }
        final var file = new File(toPath);
        if (file.exists()) {
          file.delete();
        }
        final var data = resonse.body().bytes();
        Files.write(Paths.get(file.getPath()), data, StandardOpenOption.CREATE);
      } catch (Exception e) {
        throw e;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
