package net.froihofer.ejb.calc.web;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import net.froihofer.ejb.calc.common.Calculator;

@Named
@RequestScoped
public class CalculatorJsfBean {
  @EJB Calculator calculator;
  
  private long var1, var2, sum;
  private boolean resultsAvailable = false;

  public long getVar1() {
    return var1;
  }

  public void setVar1(long var1) {
    this.var1 = var1;
  }

  public long getVar2() {
    return var2;
  }

  public void setVar2(long var2) {
    this.var2 = var2;
  }
  
  public long getSum() {
    return sum;
  }
  
  public void calculateResults() {
    this.sum = calculator.add(var1, var2);
    this.resultsAvailable = true;
  }
  
  public boolean isResultsAvailable() {
    return resultsAvailable;
  }
}
