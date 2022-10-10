package benedict.zhang.datamodel;

import benedict.zhang.annotation.Param;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitializeInfo {

  // project type
  @Param(name = "type")
  private ProjectType type = ProjectType.GRADLE;

  @Param(name = "language")
  private Language languageName = Language.JAVA;

  @Param(name = "bootVersion")
  private String bootVersion;

  @Param(name = "baseDir")
  private String baseDir;

  @Param(name = "groupId")
  private String groupId;

  @Param(name = "artifactId")
  private String artifactId;

  @Param(name = "name")
  private String name;

  @Param(name = "description")
  private String description;

  @Param(name = "packageName")
  private String packageName;

  @Param(name = "packaging")
  private Packaging packaging = Packaging.JAR;

  @Param(name = "javaVersion")
  private String javaVersion = "17";
  // private String packageName;
  // private String packageName;
  // private String packageName;
  // private String packageName;
  // private String packageName;

  public InitializeInfo(String groupId, String applicationName) {
    this.baseDir = applicationName;
    this.name = applicationName;
    this.artifactId = applicationName;
    this.groupId = groupId;
    this.packageName = groupId + "." + applicationName;
  }
}
