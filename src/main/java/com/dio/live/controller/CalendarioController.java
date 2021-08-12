package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(calendarioService.createCalendario(calendario));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<Calendario>> getAllCalendario(){
        return ResponseEntity.ok(calendarioService.getAll());
    }

    @GetMapping(value = "/{idCalendario}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> getByIdCalendario(@PathVariable long idCalendario) throws Exception{
        return ResponseEntity.ok(calendarioService.getByIdCalendario(idCalendario).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> updateCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(calendarioService.updateCalendario(calendario));
    }

    @DeleteMapping(value = "/{idCalendario}")
    public ResponseEntity<Calendario> deleteCalendario(@PathVariable long idCalendario)throws  Exception{
        try {
            calendarioService.deleteCalendario(idCalendario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
            Calendario calendario = new Calendario();
            calendario.setId(idCalendario);

            return ResponseEntity.ok(calendario);
    }
}
