package benedict;

import benedict.zhang.RequestURLBuilder;
import benedict.zhang.annotation.Param;
import benedict.zhang.datamodel.InitializeInfo;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Playground
 */
public class Playground {

  @Test
  public void Reflection() {
    final var clazz = InitializeInfo.class;
    final var fields = clazz.getDeclaredFields();
    Arrays.stream(fields).forEach(f -> {
      if (f.isAnnotationPresent(Param.class)) {
        final var paramConfig = f.getAnnotation(Param.class);
        System.out.println(paramConfig.name());
      }
    });
  }

  @Test
  public void QuickBuilderTest() {
    final var initInfo = new InitializeInfo("benedict.zhang", "my-service");
    final var builder = new RequestURLBuilder();
    builder.withInitializeInfo(initInfo);
    System.out.println(builder.build());
  }
}
