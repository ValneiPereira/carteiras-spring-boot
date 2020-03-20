package com.carteira.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carteira.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

  Optional<Usuario> findByEmailEquals(String email);
  
  

}
