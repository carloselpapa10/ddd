package com.hardtech.dddapp.shared.domain;

import com.hardtech.dddapp.shared.domain.exception.IdentifierMalformedException;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.UUID;

/**
 * Generic value object of type identifier.
 */
@Value
@NonFinal
@EqualsAndHashCode
public abstract class Identifier implements Serializable {

  private static final long serialVersionUID = 2657315167531515199L;

  protected String value;

  /**
   * Constructor.
   *
   * @param value the identifier
   */
  public Identifier(String value) {
    ensureValidUuid(value);

    this.value = value;
  }

  /**
   * Validate the UUID format.
   *
   * @param value the identifier.
   */
  private static void ensureValidUuid(String value) {

    try {
      UUID.fromString(value);
    } catch (IllegalArgumentException ex) {
      var exception = new IdentifierMalformedException(value);
      exception.initCause(ex);
      throw exception;
    }

  }

  /**
   * Get identifier.
   *
   * @return the identifier.
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
