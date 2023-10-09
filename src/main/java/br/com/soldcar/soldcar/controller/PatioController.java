package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.dto.PatioRequestDTO;
import br.com.soldcar.soldcar.dto.PatioResponseDTO;
import br.com.soldcar.soldcar.model.Patio;
import br.com.soldcar.soldcar.service.PatioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patio")
public class PatioController {

    @Autowired
    private PatioService patioService;

    @PostMapping("/inserirPatio")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Patio> inserirCarro(@RequestBody PatioRequestDTO patioRequestDTO) {
        Patio patioCriado = patioService.inserirPatio(patioRequestDTO);
        return new ResponseEntity<>(patioCriado, HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodosOsPatios")
    @SecurityRequirement(name = "Bearer Authentication")
    public List<PatioResponseDTO> buscaTodosOsCarros() {
        List<PatioResponseDTO> listaTodosOsPatios = patioService.buscarTodosOsPatios();
        return new ResponseEntity<>(listaTodosOsPatios, HttpStatus.OK).getBody();
    }

}
