package br.com.ecommerce.Domain.Entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EnderecoEntity {
  private String logradouro;
  private int numero;
  private String bairro;
  private String localidade;
  private String uf;
  private String cep;
  private String complemento;
}
