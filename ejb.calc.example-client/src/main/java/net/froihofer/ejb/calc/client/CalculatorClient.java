package net.froihofer.ejb.calc.client;

import net.froihofer.ejb.calc.common.VariableDTO;
import net.froihofer.util.AuthCallbackHandler;
import java.util.Properties;

import javax.naming.InitialContext;

import net.froihofer.ejb.calc.common.Calculator;
import net.froihofer.ejb.calc.common.CalculatorException;
import net.froihofer.util.WildflyJndiLookupHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lorenz Froihofer
 */
public class CalculatorClient {
  private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);
  
  public static void main(String[] args) {
    try {
      Properties props = new Properties();
      AuthCallbackHandler.setUsername("tester");
      AuthCallbackHandler.setPassword("testerpass");
      WildflyJndiLookupHelper jndiHelper = new WildflyJndiLookupHelper(new InitialContext(props), "ejb-calc-ear", "ejb-calc-example-ejb", "");
      Calculator calculator = jndiHelper.lookup("CalculatorService", Calculator.class);
      System.out.print("4-3="); System.out.println(calculator.sub(4, 3));
      System.out.print("4+5="); System.out.println(calculator.add(4, 5));
      System.out.print("3*6="); System.out.println(calculator.mul(3, 6));
      System.out.print("9/3="); System.out.println(calculator.div(9, 3));
      System.out.println("Setting variable 'v1' to 10.");
      calculator.storeVariable(new VariableDTO("v1", 10L));
      System.out.println("Value of 'v1' is now: "+ calculator.getVariable("v1"));
      System.out.println("Setting variable 'v1' to 20.");
      calculator.storeVariable(new VariableDTO("v1", 20L));
      System.out.println("Value of 'v1' is now: "+ calculator.getVariable("v1"));
      System.out.print("5/0="); System.out.println(calculator.div(5, 0));
    } catch (CalculatorException ce) {
      log.error("Calculator threw Exception: "+ce.getMessage());
    } catch (Exception e) {
      log.error("Something did not work, see stack trace.", e);
    }
  }
}

