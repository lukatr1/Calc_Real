package net.froihofer.ejb.calc.common;

import java.io.Serializable;

/**
 * @author Lorenz Froihofer
 */
public class VariableDTO implements Serializable {
  private String name;
  private long value;

  public VariableDTO() {}

  public VariableDTO(String name, long value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }
}
