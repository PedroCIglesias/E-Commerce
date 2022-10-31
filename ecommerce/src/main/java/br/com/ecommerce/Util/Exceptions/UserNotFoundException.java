package br.com.ecommerce.Util.Exceptions;

public class UserNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public UserNotFoundException() {
    super("Usuário não encontrado.");
  }
}
