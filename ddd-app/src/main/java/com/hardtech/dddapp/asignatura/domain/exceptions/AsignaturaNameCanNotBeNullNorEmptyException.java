package com.hardtech.dddapp.asignatura.domain.exceptions;

/**
 * Asignatura Name Can Not Be Null Nor Empty Exception
 */
public class AsignaturaNameCanNotBeNullNorEmptyException extends RuntimeException {

  /**
   * Constructor
   */
  public AsignaturaNameCanNotBeNullNorEmptyException() {
    super("El nombre de la asignatura no puede ser vacio o nulo");
  }
}
