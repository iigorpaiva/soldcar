package br.com.soldcar.soldcar.services;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import br.com.soldcar.soldcar.exception.CarroInvalidoException;
import br.com.soldcar.soldcar.mapper.CarroMapper;
import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.repository.CarroRepository;
import br.com.soldcar.soldcar.service.impl.CarroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class CarroServiceImplTest {

    @InjectMocks
    private CarroServiceImpl carroService;

    @Mock
    private CarroRepository carroRepository;

    @Mock
    private CarroMapper carroMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Inserir carro com campos válidos")
    public void testInserirCarro_ComCamposValidos() {
        // Criando um objeto CarroRequestDTO com campos válidos
        CarroRequestDTO requestDTO = CarroRequestDTO.builder()
                .modelo("Modelo válido")
                .marca(Marca.AUDI) // Marca válida
                .anoFabricacao("2020")
                .anoModelo("2021")
                .cor(Cor.PRETO) // Cor válida
                .build();
        Carro carroMock = new Carro(/* preencher com dados do mock */);

        Mockito.when(carroMapper.carroRequestDTOtoCarro(requestDTO)).thenReturn(carroMock);
        Mockito.when(carroRepository.save(any(Carro.class))).thenReturn(carroMock);

        Carro result = carroService.inserirCarro(requestDTO);

        assertNotNull(result);
        // Verifique se o carro foi salvo corretamente
        assertEquals(carroMock, result);
    }

    @Test
    @DisplayName("Inserir carro com campos inválidos")
    public void testInserirCarro_ComCamposInválidos() {
        CarroRequestDTO requestDTO = new CarroRequestDTO(); // Objeto com campos nulos

        CarroInvalidoException exception = assertThrows(CarroInvalidoException.class, () -> {
            carroService.inserirCarro(requestDTO);
        });

        assertEquals("Carro não pode ser cadastrado devido a informações inválidas", exception.getMessage());
    }

    @Test
    @DisplayName("Buscar todos os cararos quando nenhum carro é encontrado")
    public void testBuscarTodosOsCarros_QuandoNenhumCarroEncontrado() {
        Mockito.when(carroRepository.findAll()).thenReturn(new ArrayList<>());

        CarroInvalidoException exception = assertThrows(CarroInvalidoException.class, () -> {
            carroService.buscarTodosOsCarros();
        });

        assertEquals("Nenhum carro foi encontrado", exception.getMessage());
    }

    @Test
    @DisplayName("Buscar todos os carros quando carros encontrados")
    public void testBuscarTodosOsCarros_QuandoCarrosEncontrados() {
        // Criando uma lista de carros de exemplo
        List<Carro> carrosMock = new ArrayList<>();
        carrosMock.add(Carro.builder()
                .modelo("A3")
                .marca(Marca.AUDI)
                .anoFabricacao("2020")
                .anoModelo("2021")
                .cor(Cor.PRETO)
                .build());

        carrosMock.add(Carro.builder()
                .modelo("320i")
                .marca(Marca.BMW)
                .anoFabricacao("2021")
                .anoModelo("2022")
                .cor(Cor.BRANCO)
                .build());

        // Configurando o comportamento do repositório para retornar a lista de carros de exemplo
        Mockito.when(carroRepository.findAll()).thenReturn(carrosMock);

        // Chamando o método a ser testado
        List<Carro> result = carroService.buscarTodosOsCarros();

        // Verificando os resultados
        assertNotNull(result);
        assertEquals(carrosMock.size(), result.size());

        // Verificando se os objetos de carro são iguais
        for (int i = 0; i < carrosMock.size(); i++) {
            Carro expectedCar = carrosMock.get(i);
            Carro actualCar = result.get(i);
            assertEquals(expectedCar.getModelo(), actualCar.getModelo());
            assertEquals(expectedCar.getMarca(), actualCar.getMarca());
            assertEquals(expectedCar.getAnoFabricacao(), actualCar.getAnoFabricacao());
            assertEquals(expectedCar.getAnoModelo(), actualCar.getAnoModelo());
            assertEquals(expectedCar.getCor(), actualCar.getCor());
        }
    }
}
