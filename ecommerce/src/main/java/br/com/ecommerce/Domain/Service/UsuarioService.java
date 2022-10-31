package br.com.ecommerce.Domain.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.ecommerce.Application.DTOs.EnderecoDTO;
import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Application.DTOs.UsuarioDTO;
import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;
import br.com.ecommerce.Domain.Repositories.IUsuarioRepository;
import br.com.ecommerce.Util.Exceptions.CustomIllegalArgumentException;
import br.com.ecommerce.Util.Exceptions.EmailAlreadyInUseException;
import br.com.ecommerce.Util.Exceptions.UserNotFoundException;
import br.com.ecommerce.Util.Validation.Assert;
import lombok.RequiredArgsConstructor;

import static br.com.ecommerce.Util.Handlers.Message.*;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
  private final IUsuarioRepository repository;
  private final IProdutoService produtoService;

  @Override
  public UsuarioEntity save(UsuarioDTO usuario) {
    validateFields(usuario, false);
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
    validateFields(usuario, true);
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
    return this.repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
  }

  @Override
  public List<EnderecoEntity> getEnderecos(String email) {
    return findByEmail(email).getEndereco();
  }

  @Override
  public UsuarioEntity findById(Long id) {
    return this.repository.findById((int) (long) id).orElseThrow(UserNotFoundException::new);
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

  @Override
  public UsuarioEntity adicionaProduto(Long idUsuario, Long idProduto) {
    UsuarioEntity usuario = this.findById(idUsuario);
    ProdutoEntity produto = this.produtoService.findById(idProduto);
    List<ProdutoEntity> carrinho = usuario.getCarrinho();
    carrinho.add(produto);
    usuario.setCarrinho(carrinho);
    return this.repository.save(usuario);
  }

  @Override
  public EnderecoEntity pesquisaCep(String cep) {
    try {
      URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
      URLConnection connection = url.openConnection();
      InputStream is = connection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      String aux_cep = "";
      StringBuilder jsonCep = new StringBuilder();

      while ((aux_cep = br.readLine()) != null) {
        jsonCep.append(aux_cep);
      }

      return new Gson().fromJson(jsonCep.toString(), EnderecoEntity.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private void validateFields(UsuarioDTO usuario, boolean update) {
    if (!Assert.hasField(usuario.getEmail()))
      throw new CustomIllegalArgumentException(EMAIL_OBRIGATORIO);
    if (!Assert.hasField(usuario.getNome()))
      throw new CustomIllegalArgumentException(NOME_OBRIGATORIO);
    if (!Assert.hasField(usuario.getCpf()))
      throw new CustomIllegalArgumentException(CPF_OBRIGATORIO);
    if (!Assert.hasField(usuario.getEndereco()))
      throw new CustomIllegalArgumentException(ENDERECO_OBRIGATORIO);

    if (!update) {
      Optional<UsuarioEntity> userRegisteredWithEmail = this.repository.findByEmail(usuario.getEmail());
      if (!userRegisteredWithEmail.isPresent())
        throw new EmailAlreadyInUseException(EMAIL_EXISTENTE);
    }
  }
}
