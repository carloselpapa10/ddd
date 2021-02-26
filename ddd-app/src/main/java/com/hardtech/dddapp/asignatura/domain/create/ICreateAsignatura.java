package com.hardtech.dddapp.asignatura.domain.create;

import com.hardtech.dddapp.asignatura.domain.Asignatura;

/**
 * Create Asignatura Interface
 */
public interface ICreateAsignatura {

  /**
   * Execute method
   *
   * @param asignaturaCommand The asignatura command
   * @return An asignatura
   */
  Asignatura execute(CreateAsignaturaCommand asignaturaCommand);
}
