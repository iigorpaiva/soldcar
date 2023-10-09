package br.com.soldcar.soldcar.service.impl;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.exception.CarroInvalidoException;
import br.com.soldcar.soldcar.mapper.CarroMapper;
import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.model.Patio;
import br.com.soldcar.soldcar.repository.CarroRepository;
import br.com.soldcar.soldcar.repository.PatioRepository;
import br.com.soldcar.soldcar.service.CarroService;
import br.com.soldcar.soldcar.util.GenericUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private PatioRepository patioRepository;
    @Autowired
    private CarroMapper carroMapper;

    @Override
    public List<Carro> buscarCarrosPorModelo(String modelo) {
        return carroRepository.findByModelo(modelo);
    }
    
    @Override
    public List<Carro> buscarCarrosPorPatio(Integer patioId) {
        return carroRepository.findByPatioId(patioId);
    }
    
    @Override
    public Carro inserirCarro(CarroRequestDTO carroRequestDTO) {
        if (validaCamposCarroACadastrar(carroRequestDTO)) {
            throw new CarroInvalidoException("Carro não pode ser cadastrado devido a informações inválidas");
        }
        
        List<MultipartFile> fotos = carroRequestDTO.getFotos();
        String nomePasta = UUID.randomUUID().toString() + "_" + carroRequestDTO.getModelo();
        
        String diretorioBase = "src/main/resources/fotos/";
        
        String caminhoCompleto = diretorioBase + nomePasta;
        
        try {
            Files.createDirectories(Path.of(caminhoCompleto));
            
            for (int i = 0; i < fotos.size(); i++) {
                String nomeFoto = "foto" + (i + 1) + ".jpg";
                Files.write(Paths.get(caminhoCompleto, nomeFoto), fotos.get(i).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar fotos do carro");
        }
        
        String patioString = GenericUtils.primeiraLetraMaiuscula(carroRequestDTO.getPatio().toString());
        Patio patio = patioRepository.findByNome(patioString).get(0);
        
        Carro carro = carroMapper.carroRequestDTOtoCarro(carroRequestDTO);
        carro.setPatio(patio);
        carro.setCaminhoFotos(caminhoCompleto);
        carroRepository.save(carro);
        return carro;
    }

    @Override
    public List<Carro> buscarTodosOsCarros() {
        List<Carro> listaTodosOsCarros = carroRepository.findAll();
        if (listaTodosOsCarros.isEmpty()) {
            throw new CarroInvalidoException("Nenhum carro foi encontrado");
        }
        return listaTodosOsCarros;
    }

    private boolean validaCamposCarroACadastrar(CarroRequestDTO carroRequestDTO) {
        return carroRequestDTO.getModelo() == null ||
                carroRequestDTO.getMarca() == null ||
                carroRequestDTO.getAnoFabricacao() == null ||
                carroRequestDTO.getAnoModelo() == null ||
                carroRequestDTO.getCor() == null;
    }

}
