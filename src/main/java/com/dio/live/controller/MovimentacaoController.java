package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.createMovimentacao(movimentacao));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movimentacao>> findAllMovimentacao() {
        return ResponseEntity.ok(movimentacaoService.findAllMovimentacao());
    }

    @GetMapping(value = "/{idMovimentacao}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> getByIdMovimentacao(@PathVariable long idMovimentacao) throws Exception {
        return ResponseEntity.ok(movimentacaoService.getByIdMovimentacao(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.updateMovimentacao(movimentacao));
    }

    @DeleteMapping(value = "/{idMovimentacao}")
    public ResponseEntity deleteMovimentacao(@PathVariable long idMovimentacao) throws Exception {
        movimentacaoService.deleteMovimentacao(idMovimentacao);
        return (ResponseEntity) ResponseEntity.ok();
    }

}
