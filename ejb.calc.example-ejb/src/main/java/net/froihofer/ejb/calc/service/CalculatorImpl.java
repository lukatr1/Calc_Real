package net.froihofer.ejb.calc.service;

import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import net.froihofer.ejb.calc.common.Calculator;
import net.froihofer.ejb.calc.common.CalculatorException;
import net.froihofer.ejb.calc.common.VariableDTO;
import net.froihofer.ejb.calc.entity.Variable;
import net.froihofer.ejb.calc.entity.VariableDAO;
import net.froihofer.ejb.calc.entity.VariableTranslator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lorenz Froihofer
 */
@Stateless(name="CalculatorService")
//Unfortunately, @Remote also required here as Wildfly does not take it correctly from the interface.
@Remote
@PermitAll
public class CalculatorImpl implements Calculator {
  private static final Logger log = LoggerFactory.getLogger(CalculatorImpl.class);
  @Inject VariableDAO variableDAO;
  @Inject VariableTranslator variableTranslator;
  
  public long add(long a, long b) {
    return a + b;
  }
  
  public long sub(long a, long b) {
    return a - b;
  }
  
  public long mul(long a, long b) {
    return a * b;
  }
  
  public long div(long a, long b) throws CalculatorException {
    if (b == 0) throw new CalculatorException("Div by zero.");
    return a / b;
  }

  public void storeVariable(VariableDTO variable) throws CalculatorException {
    if (variable == null || StringUtils.isBlank(variable.getName())) {
      throw new IllegalArgumentException("variable or name cannot be empty");
    }
    try {
      Variable v = variableDAO.findById(variable.getName());
      if (v == null) {
        variableDAO.persist(variableTranslator.toEntity(variable));
      }
      else {
        v.setValue(variable.getValue());
      }
    }
    catch (Exception e) {
      log.error("Problem while storing variable: "+e.getMessage(), e);
      //Do not include the root cause as classes in the stack trace might not be available on the client
      //and lead to ClassNotFoundExceptions when unmarshalling the server response.
      throw new CalculatorException(e.getMessage());
    }
  }

  public long getVariable(String name) throws CalculatorException {
    try {
      Variable result = variableDAO.findById(name);
      if (result == null) throw new CalculatorException("Variable \""+name+"\" not found.");
      return result.getValue();
    }
    catch (Exception e) {
      log.error("Problem while getting variable: "+e.getMessage(), e);
      //Do not include the root cause as classes in the stack trace might not be available on the client
      //and lead to ClassNotFoundExceptions when unmarshalling the server response.
      throw new CalculatorException(e.getMessage());
    }
  }


}