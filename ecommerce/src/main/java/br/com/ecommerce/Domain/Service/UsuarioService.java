package br.com.ecommerce.Domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.Application.Service.IUsuarioService;
import br.com.ecommerce.Domain.Repositories.IUsuarioRepository;
import br.com.ecommerce.Util.Handlers.Message;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
  private final IUsuarioRepository repository;
}
