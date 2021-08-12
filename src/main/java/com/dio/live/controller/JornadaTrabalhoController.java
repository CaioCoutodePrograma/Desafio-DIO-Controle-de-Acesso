package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaService.saveJornada(jornadaTrabalho));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JornadaTrabalho>> getAllJornada(){
        return ResponseEntity.ok(jornadaService.findAll());

    }

    @GetMapping(value = "/{idJornada}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho>  getByIDJornada(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaService.updateJornada(jornadaTrabalho));
    }

    @DeleteMapping(value = "/{idJornada}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> deleteByIDJornada(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

        JornadaTrabalho jornadaTrabalho = new JornadaTrabalho();
        jornadaTrabalho.setId(idJornada);
        return ResponseEntity.ok(jornadaTrabalho);

    }



}
