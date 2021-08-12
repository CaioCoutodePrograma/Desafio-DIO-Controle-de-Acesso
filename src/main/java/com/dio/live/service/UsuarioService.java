package com.dio.live.service;

import com.dio.live.model.Usuario;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario) {
        return  usuarioRepository.save(usuario);
    }

    public List<Usuario> findAllUsuario() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getByIdUsuario(long idUsuario) {
        return  usuarioRepository.findById(idUsuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
