package br.com.soldcar.soldcar.service.impl;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.mapper.CarroMapper;
import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.repository.CarroRepository;
import br.com.soldcar.soldcar.service.CarroService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarroMapper carroMapper;

    @Override
    public List<Carro> buscarCarroPorModelo(String modelo) {
        return carroRepository.findByModelo(modelo);
    }

    @Override
    public Carro inserirCarro(CarroRequestDTO carroRequestDTO) {
        Carro carro = carroMapper.carroRequestDTOtoCarro(carroRequestDTO);
        carroRepository.save(carro);
        return carro;
    }

    @Override
    public List<Carro> buscarTodosOsCarros() {
        List<Carro> listaTodosOsCarros = carroRepository.findAll();
        return listaTodosOsCarros;
    }
}
