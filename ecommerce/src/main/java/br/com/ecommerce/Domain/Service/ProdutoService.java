package br.com.ecommerce.Domain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;
import br.com.ecommerce.Domain.Repositories.IProdutoRepository;
import br.com.ecommerce.Util.Exceptions.CustomIllegalArgumentException;
import br.com.ecommerce.Util.Exceptions.ProductNotFoundException;
import br.com.ecommerce.Util.Handlers.Message;
import br.com.ecommerce.Util.Validation.Assert;
import lombok.RequiredArgsConstructor;

import static br.com.ecommerce.Util.Handlers.Message.*;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService {
  private final IProdutoRepository repository;

  @Override
  public ProdutoEntity save(ProdutoDTO produto) {
    validateFields(produto);
    ProdutoEntity novoProduto = ProdutoEntity.builder()
        .nome(produto.getNome())
        .preco(produto.getPreco())
        .descricao(produto.getDescricao())
        .estoque(produto.getEstoque())
        .build();
    return this.repository.save(novoProduto);
  }

  @Override
  public ProdutoEntity update(ProdutoDTO produto) {
    validateFields(produto);
    ProdutoEntity updateProduto = ProdutoEntity.builder()
        .id(produto.getId())
        .nome(produto.getNome())
        .preco(produto.getPreco())
        .descricao(produto.getDescricao())
        .estoque(produto.getEstoque())
        .build();
    return this.repository.save(updateProduto);
  }

  @Override
  public List<ProdutoEntity> findAll() {
    return this.repository.findAll();
  }

  @Override
  public boolean delete(Long id) {
    this.repository.deleteById((int) (long) id);
    return true;
  }

  @Override
  public ProdutoEntity findById(Long id) {
    return this.repository.findById((int) (long) id).orElseThrow(ProductNotFoundException::new);
  }

  private void validateFields(ProdutoDTO produto) {
    if (!Assert.hasField(produto.getEstoque()))
      throw new CustomIllegalArgumentException(ESTOQUE_OBRIGATORIO);
    if (!Assert.hasField(produto.getNome()))
      throw new CustomIllegalArgumentException(NOME_OBRIGATORIO);
    if (!Assert.hasField(produto.getDescricao()))
      throw new CustomIllegalArgumentException(DESCRICAO_OBRIGATORIA);
    if (!Assert.hasField(produto.getPreco()))
      throw new CustomIllegalArgumentException(PRECO_OBRIGATORIO);
    if (produto.getEstoque() < 0) {
      throw new CustomIllegalArgumentException(SEM_ESTOQUE);
    }
  }
}
