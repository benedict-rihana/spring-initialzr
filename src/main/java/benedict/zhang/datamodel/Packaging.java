package benedict.zhang.datamodel;

/**
 * Packaging
 */
public enum Packaging {
  JAR("jar"),
  WAR("war");

  private final String packagingName;

  Packaging(String packagingName) {
    this.packagingName = packagingName;
  }

  @Override
  public String toString() {
    return this.packagingName;
  }
}
