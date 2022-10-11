package benedict.zhang.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Dependecies
 */
public class Dependecies {

  private final List<Dependecy> pDependecies = new ArrayList<>();

  public Dependecies addDependecy(Dependecy dependecy) {
    this.pDependecies.add(dependecy);
    return this;
  }

  public enum Dependecy {
    LOMBOK
  }
}
