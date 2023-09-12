package br.com.soldcar.soldcar.service.impl;

import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.model.Cor;
import br.com.soldcar.soldcar.repository.CarroRepository;
import br.com.soldcar.soldcar.repository.CorRepository;
import br.com.soldcar.soldcar.service.CarroService;
import br.com.soldcar.soldcar.service.CorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CorServiceImpl implements CorService {

    @Autowired
    private CorRepository corRepository;

    @Override
    public Cor inserirCor(Cor cor) {
        corRepository.save(cor);
        return cor;
    }

    @Override
    public List<Cor> buscarTodas() {
        return corRepository.findAll();
    }


}
