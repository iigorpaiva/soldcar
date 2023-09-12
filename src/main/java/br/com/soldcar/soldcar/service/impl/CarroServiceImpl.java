package br.com.soldcar.soldcar.service.impl;

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

    private CarroRepository carroRepository;

    @Override
    public List<Carro> buscarCarroPorNome(String modelo) {
        return carroRepository.findByModelo(modelo);
    }

    @Override
    public Carro inserirCarro(Carro carro) {
        carroRepository.save(carro);
        return carro;
    }
}
