package com.hardtech.dddapp.asignatura.domain;

import com.hardtech.dddapp.shared.domain.Identifier;

/**
 * Class that identifies an asignatura id's value object
 */
public class AsignaturaId extends Identifier {
  private static final long serialVersionUID = -7431956386536227675L;

  /**
   * Constructor.
   *
   * @param value the identifier
   */
  public AsignaturaId(String value) {
    super(value);
  }
}
