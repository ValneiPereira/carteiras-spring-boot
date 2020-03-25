package com.carteira.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.carteira.entity.Usuario;
import com.carteira.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles
public class UsuarioServiceTest {
  
  @MockBean
  UsuarioRepository repository;
  
  @Autowired
  UsuarioService service;
  
  
  @Before
  public void setUp() {
    BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new Usuario()));      
  }
  
  @Test
  public void testFindByEmail() {
    Optional<Usuario> user = service.findByEmail("email@teste.com");
    assertTrue(user.isPresent());
    
    
  }

}
