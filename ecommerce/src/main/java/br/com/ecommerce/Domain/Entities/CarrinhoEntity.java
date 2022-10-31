package br.com.ecommerce.Domain.Entities;

import java.util.List;

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
public class CarrinhoEntity {
  List<ProdutoEntity> produtos;
}
