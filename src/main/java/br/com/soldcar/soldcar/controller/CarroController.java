package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.dto.CarroResponseDTO;
import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.service.CarroService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @SecurityRequirement(name = "Bearer Authentication")
    public List<Carro> buscarCarrosPorModelo(@RequestParam String modelo) {
        List<Carro> listCarrosPorModelo =  carroService.buscarCarrosPorModelo(modelo);
        return new ResponseEntity<>(listCarrosPorModelo, HttpStatus.OK).getBody();
    }
    
    @GetMapping("/buscarCarrosPorPatio")
    @SecurityRequirement(name = "Bearer Authentication")
    public List<CarroResponseDTO> buscarCarrosPorPatio(@RequestParam Integer patioId) {
        List<CarroResponseDTO> listCarrosPorModelo =  carroService.buscarCarrosPorPatio(patioId);
        return new ResponseEntity<>(listCarrosPorModelo, HttpStatus.OK).getBody();
    }
    
    @RequestMapping(value = "/inserirCarro", method = RequestMethod.POST, consumes = "multipart/form-data")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Carro> inserirCarro(@ModelAttribute CarroRequestDTO carroUploadDTO) {
        Carro carroCriado = carroService.inserirCarro(carroUploadDTO);
        return new ResponseEntity<>(carroCriado, HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodosOsCarros")
    @SecurityRequirement(name = "Bearer Authentication")
    public List<Carro> buscaTodosOsCarros() {
        List<Carro> listaTodosOsCarros = carroService.buscarTodosOsCarros();
        return new ResponseEntity<>(listaTodosOsCarros, HttpStatus.OK).getBody();
    }

}
