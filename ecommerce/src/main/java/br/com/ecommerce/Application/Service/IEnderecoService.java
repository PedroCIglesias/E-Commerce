package br.com.ecommerce.Application.Service;

import br.com.ecommerce.Domain.Entities.EnderecoEntity;

public interface IEnderecoService {
  EnderecoEntity pesquisaCep(String cep);
}
