package com.hardtech.dddapp.asignatura.domain;

import com.hardtech.dddapp.asignatura.domain.exceptions.AsignaturaNameCanNotBeNullNorEmptyException;
import com.hardtech.dddapp.shared.domain.StringValueObject;

/**
 * Class that identifies an asignatura name's value object
 */
public class AsignaturaName extends StringValueObject {
  private static final long serialVersionUID = -4185796636085639067L;

  /**
   * Constructor.
   *
   * @param value the value.
   */
  public AsignaturaName(String value) {
    super(value);

    if (value == null || "".equals(value)) {
      throw new AsignaturaNameCanNotBeNullNorEmptyException();
    }
  }
}
