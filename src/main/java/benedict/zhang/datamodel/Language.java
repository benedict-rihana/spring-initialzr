package benedict.zhang.datamodel;

public enum Language {
  JAVA("java"),
  KOTLIN("kotlin");

  private final String languageName;

  Language(String languageName) {
    this.languageName = languageName;
  }

  @Override
  public String toString() {
    return languageName;
  }
}
