package net.froihofer.ejb.calc.common;

import jakarta.ejb.Remote;

/**
 * @author Lorenz Froihofer
 */
@Remote
public interface Calculator {

  /** Returns the sum of two long values. */
  public long add(long a, long b);

  /** Returns the difference of two long values. */
  public long sub(long a, long b);

  /** Returns the product of two long values. */
  public long mul(long a, long b);

  /** Divides <code>a</code> by <code>b</code> and returns the quotient. */
  public long div(long a, long b) throws CalculatorException;

  /** Persistently stores the value of the given variable. */
  public void storeVariable(VariableDTO variable) throws CalculatorException;

  /** Returns the value of a persisted variable. */
  public long getVariable(String name) throws CalculatorException;
}

