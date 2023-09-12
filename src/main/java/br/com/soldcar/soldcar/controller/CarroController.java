package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/buscarCarrosPorModelo")
    public List<Carro> buscarCarrosPorModelo(@RequestParam String modelo) {
        return carroService.buscarCarroPorNome(modelo);
    }

    @PostMapping("/inserirCarro")
    public ResponseEntity<Carro> inserirCarro(@RequestBody Carro carro) {
        Carro carroCriado = carroService.inserirCarro(carro);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }
}
