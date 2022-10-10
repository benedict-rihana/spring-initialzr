package benedict.zhang.datamodel;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Options
 */
public class SpringInitOptions {

  public static final Options OPTIONS = new Options();

  static {
    OPTIONS.add(Option.builder("GroupId")
        .longOpt("group-id")
        .desc("Project Group Id")
        .hasArg()
        .build());
    OPTIONS.add(Option.builder("ArtifactId")
        .longOpt("artifact-id")
        .desc("Project Artifact Id")
        .hasArg()
        .build());
  }
}
