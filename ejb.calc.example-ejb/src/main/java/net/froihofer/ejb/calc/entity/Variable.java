package net.froihofer.ejb.calc.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Lorenz Froihofer
 */
@Entity
@Table(name="STORED_VALUE")
public class Variable implements Serializable {
  @Id
  private String name;
  @Column(name="my_value")
  private long value;

  public Variable() {}

  public Variable (String name, long value) {
    this.name = name;
    this.value = value;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the value
   */
  public long getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(long value) {
    this.value = value;
  }

}
