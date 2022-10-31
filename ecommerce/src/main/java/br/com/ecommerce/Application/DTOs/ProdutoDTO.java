package br.com.ecommerce.Application.DTOs;

import javax.annotation.sql.DataSourceDefinition;

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
public class ProdutoDTO {
  private Long id;
  private String nome;
  private double preco;
  private String descricao;
  private int estoque;
}
