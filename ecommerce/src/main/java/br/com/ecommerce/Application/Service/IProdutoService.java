package br.com.ecommerce.Application.Service;

import java.util.List;

import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;

public interface IProdutoService {
  ProdutoEntity save(ProdutoDTO produto);

  ProdutoEntity update(ProdutoDTO produto);

  List<ProdutoEntity> findAll();

  boolean delete(Long id);

  ProdutoEntity findById(Long id);

  ProdutoEntity decrementaEstoque(ProdutoEntity produto);
}
