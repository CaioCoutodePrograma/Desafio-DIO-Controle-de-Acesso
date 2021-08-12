package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> createCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoriaUsuario));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoriaUsuario>> getAllCategoria() {
        return ResponseEntity.ok(categoriaService.getAllCategoria());
    }

    @GetMapping(value = "/{idCategoria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> getByIdCategoria(@PathVariable long idCategoria) throws Exception {
        return ResponseEntity.ok(categoriaService.getByIdCategoria(idCategoria).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return ResponseEntity.ok(categoriaService.updateCategoria(categoriaUsuario));

    }

    @DeleteMapping(value = "/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> deleteCalendario(@PathVariable long idCategoria) throws Exception {
        try {
            categoriaService.deleteCategoria(idCategoria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        CategoriaUsuario categoriaUsuario = new CategoriaUsuario();
        categoriaUsuario.setId(idCategoria);
        return  ResponseEntity.ok(categoriaUsuario);
    }


}
