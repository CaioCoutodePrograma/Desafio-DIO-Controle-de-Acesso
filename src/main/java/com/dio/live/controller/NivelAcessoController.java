package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.createNivelAcesso(nivelAcesso));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NivelAcesso>> findAllnivelAcesso (){
        return  ResponseEntity.ok(nivelAcessoService.findAllNivelAcesso());
    }

    @GetMapping(value = "/{idNivelAcesso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> getByIdnivelAcesso(@PathVariable long idNivelAcesso) throws Exception{
        return  ResponseEntity.ok(nivelAcessoService.getByIdNivelAcesso(idNivelAcesso).orElseThrow(()-> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> updatenivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.updatenivelAcesso(nivelAcesso));
    }

    @DeleteMapping(value = "/{idNivelAcesso}")
    public ResponseEntity deleteNivelAcesso(@PathVariable long idNivelAcesso) throws Exception{
        try {
            nivelAcessoService.deleteNivelAcesso(idNivelAcesso);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();
    }
}
