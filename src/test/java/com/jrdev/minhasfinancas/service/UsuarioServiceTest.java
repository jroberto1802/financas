package com.jrdev.minhasfinancas.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jrdev.minhasfinancas.exceptions.RegraNegocioException;
import com.jrdev.minhasfinancas.model.entity.Usuario;
import com.jrdev.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
    void deveValidarEmail() {
        // Cenário
        repository.deleteAll();

        // Ação e verificação
        assertDoesNotThrow(() -> {
            service.validarEmail("email@email.com");
        });
    }
	
	@Test
    void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
        // Cenário
        Usuario usuario = Usuario.builder().nome("usuario").email("email@cadastrado.com").build();
        repository.save(usuario);

        // Ação e verificação
        assertThrows(RegraNegocioException.class, () -> {
            service.validarEmail("email@cadastrado.com");
        });
    }
}
