package com.treino.treino.controller;

import com.treino.treino.model.CarroModel;
import com.treino.treino.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<CarroModel> salvarCarro(@RequestBody CarroModel carro) {
        return ResponseEntity.ok(carroService.salvarCarro(carro));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarroModel>> listarCarros() {
        return ResponseEntity.ok(carroService.listarCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroModel> buscarCarroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.acharPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroModel> atualizarPorId(@PathVariable Long id, @RequestBody CarroModel carro) {
        return ResponseEntity.ok(carroService.atualizarPorId(carro, id));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId (@PathVariable Long id) {
        carroService.deletarPorId(id);
    }
}
