package com.carteira.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.carteira.entity.Usuario;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

  private static final String EMAIL = "email@teste.com";

  @Autowired
  UsuarioRepository repository;

  @Before
  public void setUp() {
    Usuario usuario = new Usuario();
    usuario.setName("Set up User");
    usuario.setPassword("Senha123");
    usuario.setEmail(EMAIL);
    repository.save(usuario);
  }

  @After
  public void tearDown() {
    
    repository.deleteAll();

  }

  @Test
  public void testSave() {
    Usuario u = new Usuario();
    u.setName("Teste");
    u.setPassword("123456");
    u.setEmail("teste@teste.com");

    Usuario response = repository.save(u);

    assertNotNull(response);
  }

  public void testFindByEmail() {
    Optional<Usuario> response = repository.findByEmailEquals(EMAIL);
    assertTrue(response.isPresent());
    assertEquals(response.get().getEmail(), EMAIL);
  }

}
