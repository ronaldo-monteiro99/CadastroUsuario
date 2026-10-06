package com.crudproject.cadastro_usuario.business;


import com.crudproject.cadastro_usuario.infrastructure.entitys.Usuario;
import com.crudproject.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario ususario){
        repository.saveAndFlush(ususario);
    }

    public Usuario buscarusuarioPorEmail(String email){
    return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não encontrado!")
    );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }


}
