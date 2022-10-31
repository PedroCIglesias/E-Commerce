package br.com.ecommerce.Domain.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.Domain.Entities.ProdutoEntity;

@Repository
public interface IProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
}
