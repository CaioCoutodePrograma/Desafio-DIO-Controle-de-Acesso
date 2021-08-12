package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.ok(bancoHorasService.createBancoHoras(bancoHoras));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BancoHoras>> getAllBancoHoras() {
        return ResponseEntity.ok(bancoHorasService.findAllBancoHoras());
    }

    @GetMapping(value = "/{idBancoHoras}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> getByIdBancoHoras(@PathVariable long idBancoHoras) throws Exception {
        return ResponseEntity.ok(bancoHorasService.finfByIdBancoHoras(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.ok(bancoHorasService.updateBancoHoras(bancoHoras));

    }

    @DeleteMapping(value = "/{idBancoHoras}")
    public ResponseEntity deleteBancoHoras(@PathVariable long idBancoHoras) throws Exception{
        try {
            bancoHorasService.deleteBancoHoras(idBancoHoras);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity) ResponseEntity.ok();
    }

}
