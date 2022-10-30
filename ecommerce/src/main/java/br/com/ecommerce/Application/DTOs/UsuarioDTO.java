package br.com.ecommerce.Application.DTOs;

import javax.annotation.sql.DataSourceDefinition;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
  private Long id;
  private String nome;
  private String email;
  private String cep;
  private String cpf;
  private String endereco;
}
