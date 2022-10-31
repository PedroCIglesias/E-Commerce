package br.com.ecommerce.Application.Service;

import java.util.List;

import br.com.ecommerce.Application.DTOs.ProdutoDTO;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;

public interface IProdutoService {
  ProdutoEntity save(ProdutoDTO usuario);

  ProdutoEntity update(ProdutoDTO usuario);

  List<ProdutoEntity> findAll();

  boolean delete(Long id);

  ProdutoEntity findById(Long id);
}
