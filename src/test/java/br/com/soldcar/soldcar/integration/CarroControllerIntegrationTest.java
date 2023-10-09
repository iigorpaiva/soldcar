package br.com.soldcar.soldcar.integration;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import br.com.soldcar.soldcar.service.CarroService;
import br.com.soldcar.soldcar.util.GenericUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarroService carroService;

    @BeforeEach
    public void setUp() {
        // Inicialize a base de dados de teste ou carregue dados de teste
    }

    @Test
    @DisplayName("Teste de busca de carros por modelo")
    public void testBuscarCarrosPorModelo() throws Exception {
        String modelo = "ModeloTeste"; // Defina um modelo válido

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/carro/buscarCarrosPorModelo")
                .param("modelo", modelo)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Teste de inserção de carro")
    public void testInserirCarro() throws Exception {
        // Criar um objeto CarroRequestDTO válido
        CarroRequestDTO carroRequestDTO = CarroRequestDTO.builder()
                .modelo("ModeloTeste")
                .marca(Marca.TOYOTA)
                .anoFabricacao("2022")
                .anoModelo("2022")
                .cor(Cor.AZUL)
                .build();

        String carroRequestJson = GenericUtils.asJsonString(carroRequestDTO);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/carro/inserirCarro")
                .content(carroRequestJson)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.modelo").value("ModeloTeste"))
                .andExpect(jsonPath("$.marca").value("TOYOTA"))
                .andExpect(jsonPath("$.anoFabricacao").value("2022"))
                .andExpect(jsonPath("$.anoModelo").value("2022"))
                .andExpect(jsonPath("$.cor").value("AZUL"));
    }

    @Test
    public void testBuscarTodosOsCarros() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/carro/buscarTodosOsCarros")
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
