package br.com.ecommerce.Domain.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.Domain.Entities.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {
  List<UsuarioEntity> findAll();

  Optional<UsuarioEntity> findByEmail(String email);
}
