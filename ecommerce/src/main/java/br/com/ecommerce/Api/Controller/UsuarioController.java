package br.com.ecommerce.Api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

  @GetMapping
  public String mensagem() {
    return "Hello World!";
  }

}
