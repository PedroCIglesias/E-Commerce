package br.com.ecommerce.Application.Service;

import java.util.List;

import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Domain.Entities.PedidoEntity;

public interface IPedidoService {
  PedidoEntity save(Long usuarioId);

  List<PedidoEntity> findAll();
}
