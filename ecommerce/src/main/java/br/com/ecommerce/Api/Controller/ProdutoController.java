package br.com.ecommerce.Api.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {
  private final IProdutoService service;

  @PostMapping()
  public ProdutoEntity save(@RequestBody ProdutoDTO produto) {
    return this.service.save(produto);
  }

  @PutMapping()
  public ProdutoEntity update(@RequestBody ProdutoDTO produto) {
    return this.service.update(produto);
  }

  @GetMapping()
  public List<ProdutoEntity> findAll() {
    return this.service.findAll();
  }

  @DeleteMapping("/{id}")
  public boolean delete(@PathVariable Long id) {
    return this.service.delete(id);
  }
}
