package br.com.ecommerce.Domain.Service;

import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.Service.IPedidoService;
import br.com.ecommerce.Domain.Repositories.IPedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService implements IPedidoService {
  private final IPedidoRepository repository;
}
