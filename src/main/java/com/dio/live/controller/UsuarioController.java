package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> findAllUsuario (){
        return  ResponseEntity.ok(usuarioService.findAllUsuario());
    }

    @GetMapping(value = "/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getByIdUsuario(@PathVariable long idUsuario) throws Exception{
        return  ResponseEntity.ok(usuarioService.getByIdUsuario(idUsuario).orElseThrow(()-> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long idUsuario) throws Exception{
        try {
            usuarioService.deleteUsuario(idUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        return ResponseEntity.ok(usuario);
    }
}
