package benedict.zhang;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * SpringDownloader
 */
public class SpringDownloader {

  private final String urlStr;

  public SpringDownloader(String url) { this.urlStr = url; }

  public void download(String toPath) {
    try {
      final var client = new OkHttpClient();
      final var request = (new Request.Builder()).url(urlStr).build();

      try (var resonse = client.newCall(request).execute()) {
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
