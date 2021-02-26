package com.hardtech.dddapp.asignatura.domain.exceptions;

/**
 * Asignatura Credit Number Can Not Be Less Or Equal Than Zero
 */
public class AsignaturaCreditNumberCanNotBeLessOrEqualThanZero extends RuntimeException {

  /**
   * Constructor
   */
  public AsignaturaCreditNumberCanNotBeLessOrEqualThanZero() {
    super("El número de crédito no puede ser menos o igual a cero");
  }
}
