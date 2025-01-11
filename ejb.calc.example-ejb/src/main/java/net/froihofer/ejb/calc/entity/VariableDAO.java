package net.froihofer.ejb.calc.entity;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Data access object for {@link Variable} entity, encapsulating all
 * persistence-related functions for {@link Variable}, i.e., saving,
 * searching, and deleting.
 * @author Lorenz Froihofer
 */
@Dependent
public class VariableDAO {
  @PersistenceContext private EntityManager entityManager;
  
  public Variable findById(String name) {
    return entityManager.find(Variable.class, name);
  }
  
  public void persist(Variable variable) {
    entityManager.persist(variable);
  }
  
  public void delete(Variable variable) {
    entityManager.remove(variable);
  }
}
