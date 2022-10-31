package br.com.ecommerce.Application.Service;

import java.util.List;

import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;

public interface IUsuarioService {
  UsuarioEntity save(UsuarioDTO usuario);
  UsuarioEntity update(UsuarioDTO usuario);
  List<UsuarioEntity> findAll();
}
