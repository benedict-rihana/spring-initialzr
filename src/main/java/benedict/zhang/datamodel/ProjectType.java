package benedict.zhang.datamodel;

// TODO Maven
// Not really using Maven
public enum ProjectType {
  GRADLE("gradle-project");

  private final String typeName;
  ProjectType(String typeName) { this.typeName = typeName; }

  @Override
  public String toString() {
    return typeName;
  }
}
