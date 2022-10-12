package benedict.zhang;

import benedict.zhang.annotation.Param;
import benedict.zhang.datamodel.InitializeInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RequestURLBuilder {

  private final Map<String, String> paramKV = new HashMap<>();

  public RequestURLBuilder withParamValue(String paramName, String paramValue) {
    if (paramName == null || paramValue == null)
      return this;
    paramKV.put(paramName, paramValue);
    return this;
  }

  public RequestURLBuilder withInitializeInfo(InitializeInfo initializeInfo) {
    final var clazz = InitializeInfo.class;
    final var fields = clazz.getDeclaredFields();
    Arrays.stream(fields).forEach(f -> {
      if (f.isAnnotationPresent(Param.class)) {
        final var paramConfig = f.getAnnotation(Param.class);
        final var paramName = paramConfig.name();
        f.setAccessible(true);
        final Object paramValue;
        try {
          paramValue = f.get(initializeInfo);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
        if (paramName != null && paramValue != null) {
          this.withParamValue(paramName, paramValue.toString());
        }
      }
    });
    return this;
  }

  public String build() {
    var sb = new StringBuilder(Constants.BASE_URL);
    if (!sb.isEmpty()) {
      sb.append("?");
      AtomicBoolean paramInitialized = new AtomicBoolean(false);
      paramKV.forEach((paramName, paramValue) -> {
        if (paramInitialized.get()) {
          sb.append("&").append(paramName).append("=").append(paramValue);
        } else {
          sb.append(paramName).append("=").append(paramValue);
          paramInitialized.set(true);
        }
      });
    }
    return sb.toString();
  }
}
