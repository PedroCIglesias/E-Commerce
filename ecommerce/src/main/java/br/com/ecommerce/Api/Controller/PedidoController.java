package br.com.ecommerce.Api.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.Application.Service.IPedidoService;
import br.com.ecommerce.Domain.Entities.PedidoEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
  private final IPedidoService service;

  @PostMapping("/{usuarioId}")
  public PedidoEntity save(@PathVariable Long usuarioId) {
    return this.service.save(usuarioId);
  }

  @GetMapping()
  public List<PedidoEntity> findAll() {
    return this.service.findAll();
  }
}
