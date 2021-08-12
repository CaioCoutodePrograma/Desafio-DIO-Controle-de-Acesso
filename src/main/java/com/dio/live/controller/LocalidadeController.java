package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    LocalidadeService localidadeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(localidadeService.createLocalidade(localidade));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Localidade>> getAllLocalidade(){
        return  ResponseEntity.ok(localidadeService.getAllLocalidade());
    }

    @GetMapping(value = "/{idLocalidade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> getByIdLocalidade(@PathVariable long idLocalidade) throws Exception{
        return  ResponseEntity.ok(localidadeService.getByIdLocalidade(idLocalidade).orElseThrow(()-> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> updateLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(localidadeService.updateLocalidade(localidade));
    }

    @DeleteMapping(value = "/{idLocalidade}")
    public ResponseEntity<Localidade> deleteBancoHoras(@PathVariable long idLocalidade) throws Exception{
        try {
            localidadeService.deleteBancoHoras(idLocalidade);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Localidade localidade = new Localidade();
        localidade.setId(idLocalidade);

        return ResponseEntity.ok(localidade);
    }
}
