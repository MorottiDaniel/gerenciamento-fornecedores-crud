package com.morotti.fornecedores.controller;


import com.morotti.fornecedores.entity.FornecedoresEntity;
import com.morotti.fornecedores.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {
    @Autowired
    private FornecedoresService fornecedoresService;

    @PostMapping
    public ResponseEntity<FornecedoresEntity> criarFornecedor(@RequestBody FornecedoresEntity entity){
        FornecedoresEntity fornecedor = fornecedoresService.criarFornecedor(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresEntity>> findAll(){
        List<FornecedoresEntity> entities = fornecedoresService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedoresEntity> buscarPorId(@PathVariable Long id){
        try {
            FornecedoresEntity entity = fornecedoresService.buscarPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        fornecedoresService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
