package com.hardtech.dddapp.asignatura.domain;

import java.util.Optional;

/**
 * Asignatura Service Interface
 */
public interface IAsignaturaService {

  /**
   * Find asignatura by id
   *
   * @param id The id
   * @return An optional of asignatura
   */
  Optional<Asignatura> findAsignaturaById(AsignaturaId id);

  /**
   * Save asignatura
   *
   * @param asignatura The asignatura
   */
  void saveAsignatura(Asignatura asignatura);
}
