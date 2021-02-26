package com.hardtech.dddapp.asignatura.domain;

import com.hardtech.dddapp.asignatura.domain.exceptions.AsignaturaCreditNumberCanNotBeLessOrEqualThanZero;
import com.hardtech.dddapp.shared.domain.IntegerValueObject;

/**
 * Class that identifies an asignatura credit number's value object
 */
public class AsignaturaCreditNumber extends IntegerValueObject {
  private static final long serialVersionUID = 4349710907548717780L;

  /**
   * Constructor
   *
   * @param value The value
   */
  public AsignaturaCreditNumber(Integer value) {
    super(value);

    if (value <= 0) {
      throw new AsignaturaCreditNumberCanNotBeLessOrEqualThanZero();
    }
  }
}
