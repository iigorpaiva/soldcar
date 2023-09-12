package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.model.Cor;
import br.com.soldcar.soldcar.service.CorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @SecurityRequirement(name = "Bearer Authentication")
    public List<Cor> buscarTodasAsCores() {
        return corService.buscarTodas();
    }

    @PostMapping("/inserirCor")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Cor> inserirCarro(@RequestBody Cor cor) {
        Cor corCriada = corService.inserirCor(cor);
        return new ResponseEntity<>(cor, HttpStatus.CREATED);
    }
}
