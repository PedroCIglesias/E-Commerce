package br.com.ecommerce.Util.Validation;

import java.util.Objects;

public class Assert {
  public static boolean hasField(Object field) {
    if (field == null || (field instanceof String && ((String) field).trim().isEmpty())) {
      return false;
    }
    return true;
  }

  public static boolean isEmailAddressValid(String email) {
    if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
      return false;
    return true;
  }

  public static boolean isNull(Object object) {
    return Objects.isNull(object);
  }

  public static boolean isNotNull(Object object) {
    return !isNull(object);
  }
}
