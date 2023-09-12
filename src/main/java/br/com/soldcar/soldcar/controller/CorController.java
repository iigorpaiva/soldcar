package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.model.Cor;
import br.com.soldcar.soldcar.service.CarroService;
import br.com.soldcar.soldcar.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cor")
public class CorController {

    @Autowired
    private CorService corService;

    @GetMapping("/buscarTodasAsCores")
    public List<Cor> buscarTodasAsCores() {
        return corService.buscarTodas();
    }

    @PostMapping("/inserirCor")
    public ResponseEntity<Cor> inserirCarro(@RequestBody Cor cor) {
        Cor corCriada = corService.inserirCor(cor);
        return new ResponseEntity<>(cor, HttpStatus.CREATED);
    }
}
