package com.hardtech.dddapp.asignatura.domain.exceptions;

/**
 * Asignatura Id Already Exists
 */
public class AsignaturaIdAlreadyExistsException extends RuntimeException {

  /**
   * Constructor
   *
   * @param id The id
   */
  public AsignaturaIdAlreadyExistsException(String id) {
    super(String.format("La asignatura con id <%s> ya existe", id));
  }
}
