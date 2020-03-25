package com.carteira.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteira.entity.Usuario;
import com.carteira.repository.UsuarioRepository;
import com.carteira.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

  @Autowired
  UsuarioRepository repository;
  
  @Override
  public Usuario save(Usuario usuario) {
    
    return repository.save(usuario);
  }

  @Override
  public Optional<Usuario> findByEmail(String email) {
    
    return repository.findByEmailEquals(email);
  }

}
