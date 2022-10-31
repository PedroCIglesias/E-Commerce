package br.com.ecommerce.Api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.Application.Service.IEnderecoService;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {
  private final IEnderecoService service;

  @GetMapping("/{cep}")
  public EnderecoEntity pesquisaCep(@PathVariable String cep) {
    return this.service.pesquisaCep(cep);
  }

}
