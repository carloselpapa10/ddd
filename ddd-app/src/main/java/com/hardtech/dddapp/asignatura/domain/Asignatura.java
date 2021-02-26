package com.hardtech.dddapp.asignatura.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Asignatura's entity
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Asignatura {
  private AsignaturaId id;
  private AsignaturaName name;
  private AsignaturaCreditNumber creditNumber;

  /**
   * Build method
   *
   * @param id           The id
   * @param name         The name
   * @param creditNumber The credit number
   * @return An asignatura
   */
  public static Asignatura build(AsignaturaId id, AsignaturaName name, AsignaturaCreditNumber creditNumber) {
    return new Asignatura(id, name, creditNumber);
  }

}
