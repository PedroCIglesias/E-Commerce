package br.com.ecommerce.Domain.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Application.Service.IPedidoService;
import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Entities.PedidoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;
import br.com.ecommerce.Domain.Repositories.IPedidoRepository;
import br.com.ecommerce.Util.Exceptions.CustomIllegalArgumentException;
import br.com.ecommerce.Util.Validation.Assert;
import lombok.RequiredArgsConstructor;

import static br.com.ecommerce.Util.Handlers.Message.*;

@Service
@RequiredArgsConstructor
public class PedidoService implements IPedidoService {
  private final IPedidoRepository repository;
  private final IUsuarioService usuarioService;

  @Override
  public List<PedidoEntity> findAll() {
    return this.repository.findAll();
  }

  @Override
  public PedidoEntity save(Long usuarioId) {
    UsuarioEntity usuario = this.usuarioService.findById(usuarioId);
    validateFields(usuario);
    PedidoEntity pedido = PedidoEntity.builder()
        .usuario(usuario)
        .done(true)
        .build();
    return this.repository.save(pedido);
  }

  private void validateFields(UsuarioEntity usuario) {
  }
}
