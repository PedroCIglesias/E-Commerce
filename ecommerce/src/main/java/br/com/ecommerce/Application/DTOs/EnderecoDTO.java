package br.com.ecommerce.Application.DTOs;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
  private String logradouro;
  private int numero;
  private String bairro;
  private String localidade;
  private String uf;
  private String cep;
  private String complemento;
}
