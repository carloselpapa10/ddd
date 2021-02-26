package com.hardtech.dddapp.shared.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Generic value object type string.
 */
@EqualsAndHashCode
public abstract class StringValueObject implements Serializable {
  private static final long serialVersionUID = -1294258888710258987L;

  protected final String value;

  /**
   * Constructor.
   *
   * @param value the value.
   */
  public StringValueObject(String value) {
    this.value = value;
  }

  /**
   * Get the value.
   *
   * @return the value.
   */
  public String value() {
    return value;
  }

  @Override
  public String toString() {
    if (null == value) {
      return "";
    }
    return value;
  }

}
