package br.com.ecommerce.Util.Exceptions;

public class ProductNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ProductNotFoundException() {
    super("Produto não encontrado.");
  }
}