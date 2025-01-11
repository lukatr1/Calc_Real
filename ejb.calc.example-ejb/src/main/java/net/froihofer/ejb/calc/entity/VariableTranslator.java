package net.froihofer.ejb.calc.entity;

import jakarta.enterprise.context.Dependent;
import net.froihofer.ejb.calc.common.VariableDTO;

/**
 * @author Lorenz Froihofer
 */
@Dependent
public class VariableTranslator {
  /** Converts a DTO instance to an entity instance. */
  public Variable toEntity(VariableDTO variable) {
    if (variable == null) return null;
    return new Variable(variable.getName(), variable.getValue());
  }

  /** Converts an entity instance to a DTO instance. */
  public VariableDTO toDTO(Variable variable) {
    if (variable == null) return null;
    return new VariableDTO(variable.getName(), variable.getValue());
  }
}
