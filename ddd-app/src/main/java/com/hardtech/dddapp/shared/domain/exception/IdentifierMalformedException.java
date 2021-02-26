package com.hardtech.dddapp.shared.domain.exception;


/**
 * Identifier malformed exception
 */
public class IdentifierMalformedException extends RuntimeException {
  /**
   * Constructor.
   *
   * @param identifier the identifier
   */
  public IdentifierMalformedException(String identifier) {
    super(String.format("The identifier <%s> is malformed", identifier));
  }
}
