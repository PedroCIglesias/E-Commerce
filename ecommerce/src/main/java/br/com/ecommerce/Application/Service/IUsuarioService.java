package br.com.ecommerce.Application.Service;

import java.util.List;

import br.com.ecommerce.Application.DTOs.EnderecoDTO;
import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;

public interface IUsuarioService {
  UsuarioEntity save(UsuarioDTO usuario);

  UsuarioEntity update(UsuarioDTO usuario);

  List<UsuarioEntity> findAll();

  boolean delete(Long id);

  UsuarioEntity findByEmail(String email);

  List<EnderecoEntity> getEnderecos(String email);

  UsuarioEntity adicionaEndereco(Long id, EnderecoDTO endereco);

  UsuarioEntity findById(Long id);
}
