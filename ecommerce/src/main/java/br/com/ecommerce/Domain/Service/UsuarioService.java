package br.com.ecommerce.Domain.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.DTOs.EnderecoDTO;
import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;
import br.com.ecommerce.Domain.Repositories.IUsuarioRepository;
import br.com.ecommerce.Util.Handlers.Message;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
  private final IUsuarioRepository repository;

  @Override
  public UsuarioEntity save(UsuarioDTO usuario) {
    UsuarioEntity novoUsuario = UsuarioEntity.builder()
        .nome(usuario.getNome())
        .cpf(usuario.getCpf())
        .email(usuario.getEmail())
        .endereco(usuario.getEndereco())
        .build();
    return this.repository.save(novoUsuario);
  }

  @Override
  public UsuarioEntity update(UsuarioDTO usuario) {
    UsuarioEntity updateUsuario = UsuarioEntity.builder()
        .id(usuario.getId())
        .nome(usuario.getNome())
        .cpf(usuario.getCpf())
        .email(usuario.getEmail())
        .endereco(usuario.getEndereco())
        .build();
    return this.repository.save(updateUsuario);
  }

  @Override
  public List<UsuarioEntity> findAll() {
    return this.repository.findAll();
  }

  @Override
  public boolean delete(Long id) {
    this.repository.deleteById((int) (long) id);
    return true;
  }

  @Override
  public UsuarioEntity findByEmail(String email) {
    return this.repository.findByEmail(email);
  }

  @Override
  public List<EnderecoEntity> getEnderecos(String email) {
    return findByEmail(email).getEndereco();
  }

  @Override
  public UsuarioEntity findById(Long id) {
    return this.repository.findById(id);
  }

  @Override
  public UsuarioEntity adicionaEndereco(Long id, EnderecoDTO endereco) {
    UsuarioEntity usuario = this.findById(id);
    EnderecoEntity addEndereco = EnderecoEntity.builder()
        .cep(endereco.getCep())
        .localidade(endereco.getLocalidade())
        .bairro(endereco.getBairro())
        .logradouro(endereco.getLogradouro())
        .numero(endereco.getNumero())
        .complemento(endereco.getComplemento())
        .uf(endereco.getUf())
        .build();
    List<EnderecoEntity> enderecosUsuario = usuario.getEndereco();
    enderecosUsuario.add(addEndereco);
    usuario.setEndereco(enderecosUsuario);
    return this.repository.save(usuario);
  }
}
