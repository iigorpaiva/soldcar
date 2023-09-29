package br.com.soldcar.soldcar.services;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.mapper.CarroMapper;
import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.repository.CarroRepository;
import br.com.soldcar.soldcar.service.impl.CarroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.verify;

public class CarroServiceImplTest {

    @Mock
    private CarroRepository carroRepository;

    @InjectMocks
    private CarroServiceImpl carroService;

    @Autowired
    CarroMapper carroMapper;

    private Carro carro;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInserirCarro(){
        CarroRequestDTO carroRequestDTO = new CarroRequestDTO();

        carroService.inserirCarro(new CarroRequestDTO());
        verify(carroRepository).save(carro);
    }




}


