package br.com.ecommerce.Domain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;
import br.com.ecommerce.Domain.Repositories.IProdutoRepository;
import br.com.ecommerce.Util.Handlers.Message;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService {
  private final IProdutoRepository repository;

  @Override
  public ProdutoEntity save(ProdutoDTO produto) {
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
    return this.repository.findById(id);
  }
}
