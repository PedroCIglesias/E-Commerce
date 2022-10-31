package br.com.ecommerce.Domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.Service.IProdutoService;
import br.com.ecommerce.Domain.Repositories.IProdutoRepository;
import br.com.ecommerce.Util.Handlers.Message;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService {
}
