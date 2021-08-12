package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(ocorrenciaService.createOcorrencia(ocorrencia));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ocorrencia>> findAllOcorrencia (){
        return  ResponseEntity.ok(ocorrenciaService.findAllOcorrencia());
    }

    @GetMapping(value = "/{idOcorrencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> getByIdOcorrencia(@PathVariable long idOcorrencia) throws Exception{
        return  ResponseEntity.ok(ocorrenciaService.getByIdOcorrencia(idOcorrencia).orElseThrow(()-> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(ocorrenciaService.updateOcorrencia(ocorrencia));
    }

    @DeleteMapping(value = "/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> deleteOcorrencia(@PathVariable long idOcorrencia) throws Exception{
        try {
            ocorrenciaService.deleteOcorrencia(idOcorrencia);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(idOcorrencia);
        return ResponseEntity.ok(ocorrencia);
    }
}
