package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(tipoDataService.createTipoData(tipoData));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoData>> findAllTipoData (){
        return  ResponseEntity.ok(tipoDataService.findAllTipoData());
    }

    @GetMapping(value = "/{idTipoData}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> getByIdTipoData(@PathVariable long idTipoData) throws Exception{
        return  ResponseEntity.ok(tipoDataService.getByIdTipoData(idTipoData).orElseThrow(()-> new NoSuchElementException("Not Found")));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(tipoDataService.updateTipoData(tipoData));
    }

    @DeleteMapping(value = "/{idTipoData}")
    public ResponseEntity<TipoData> deleteTipoData(@PathVariable long idTipoData) throws Exception{
        try {
            tipoDataService.deleteTipoData(idTipoData);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        TipoData tipoData = new TipoData();
        tipoData.setId(idTipoData);

        return ResponseEntity.ok(tipoData);
    }
}
