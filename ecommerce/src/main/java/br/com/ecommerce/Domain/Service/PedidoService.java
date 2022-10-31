package br.com.ecommerce.Domain.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Application.Service.IPedidoService;
import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Entities.PedidoEntity;
import br.com.ecommerce.Domain.Entities.ProdutoEntity;
import br.com.ecommerce.Domain.Entities.UsuarioEntity;
import br.com.ecommerce.Domain.Repositories.IPedidoRepository;
import br.com.ecommerce.Util.Exceptions.CustomIllegalArgumentException;
import lombok.RequiredArgsConstructor;

import static br.com.ecommerce.Util.Handlers.Message.*;

@Service
@RequiredArgsConstructor
public class PedidoService implements IPedidoService {
  private final IPedidoRepository repository;
  private final IUsuarioService usuarioService;
  private final IProdutoService produtoService;

  @Override
  public List<PedidoEntity> findAll() {
    return this.repository.findAll();
  }

  @Override
  public PedidoEntity save(Long usuarioId) {
    UsuarioEntity usuario = this.usuarioService.findById(usuarioId);
    atualizaProdutos(usuario);
    PedidoEntity pedido = PedidoEntity.builder()
        .usuario(usuario)
        .produtos(usuario.getCarrinho())
        .done(true)
        .build();
    this.usuarioService.limpaCarrinho(usuario);
    return this.repository.save(pedido);
  }

  private void atualizaProdutos(UsuarioEntity usuario) {
    for (ProdutoEntity produto : usuario.getCarrinho()) {
      if (produto.getEstoque() <= 0)
        throw new CustomIllegalArgumentException(SEM_ESTOQUE);
      this.produtoService.decrementaEstoque(produto);
    }
  }
}
