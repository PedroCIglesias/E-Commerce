package br.com.ecommerce.Domain.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.Domain.Entities.PedidoEntity;

@Repository
public interface IPedidoRepository extends CrudRepository<PedidoEntity, Integer> {
  List<PedidoEntity> findAll();
}
