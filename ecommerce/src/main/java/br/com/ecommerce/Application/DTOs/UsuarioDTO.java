package br.com.ecommerce.Application.DTOs;

import br.com.ecommerce.Domain.Entities.EnderecoEntity;
import java.util.List;

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
  private String cpf;
  private List<EnderecoEntity> endereco;
}
