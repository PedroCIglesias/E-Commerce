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

import br.com.ecommerce.Application.DTOs.EnderecoDTO;
import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
  private final IUsuarioService service;

  @PostMapping()
  public UsuarioEntity save(@RequestBody UsuarioDTO usuario) {
    return this.service.save(usuario);
  }

  @PutMapping()
  public UsuarioEntity update(@RequestBody UsuarioDTO usuario) {
    return this.service.update(usuario);
  }

  @GetMapping()
  public List<UsuarioEntity> findAll() {
    return this.service.findAll();
  }

  @DeleteMapping("/{id}")
  public boolean delete(@PathVariable Long id) {
    return this.service.delete(id);
  }

  @GetMapping("/{email}")
  public UsuarioEntity findByEmail(String email) {
    return this.service.findByEmail(email);
  }

  @GetMapping("/{email}")
  public List<EnderecoEntity> getEnderecos(String email) {
    return this.service.getEnderecos(email);
  }

  @PutMapping("/{id}")
  public UsuarioEntity adicionaEndereco(@PathVariable Long id, @RequestBody EnderecoDTO endereco) {
    return this.service.adicionaEndereco(id, endereco);
  }

  @PutMapping("/{idUsuario}/{idProduto}")
  public UsuarioEntity adicionaProduto(@PathVariable Long idUsuario, @PathVariable Long idProduto) {
    return this.service.adicionaProduto(idUsuario, idProduto);
  }
}
