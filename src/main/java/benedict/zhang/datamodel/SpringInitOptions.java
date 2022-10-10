package benedict.zhang.datamodel;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

/**
 * Options
 */
public class SpringInitOptions {

  public static final Options OPTIONS = new Options();

  static {
    OPTIONS.addOption(OptionBuilder
            .withLongOpt("group-id").withArgName("group-id")
            .withDescription("Project Group Id").hasArg().withValueSeparator().create());
    OPTIONS.addOption(OptionBuilder
        .withLongOpt("artifact-id").withArgName("artifact-id")
        .withDescription("Project Artifact Id")
        .hasArg().withValueSeparator()
        .create());
  }
}
