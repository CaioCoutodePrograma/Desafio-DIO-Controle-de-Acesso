package com.dio.live.controller;


import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.createEmpresa(empresa));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Empresa>> getAllEmpresa(){
        return ResponseEntity.ok(empresaService.getAllEmpresa());
    }

    @GetMapping(value = "/{idEmpresa}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> getByIdEmpresa(@PathVariable long idEmpresa) throws Exception{
        return ResponseEntity.ok(empresaService.getByIdEmpresa(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.updateEmpresa(empresa));
    }


    @DeleteMapping(value = "/{idEmpresa}")
    public ResponseEntity deleteEmpresa(@PathVariable long idEmpresa)throws  Exception{
        try {
            empresaService.deleteCalendario(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }


}
