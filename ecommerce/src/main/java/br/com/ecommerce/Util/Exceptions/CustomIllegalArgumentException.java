package br.com.ecommerce.Util.Exceptions;

public class CustomIllegalArgumentException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CustomIllegalArgumentException(String message) {
    super(message);
  }
}
