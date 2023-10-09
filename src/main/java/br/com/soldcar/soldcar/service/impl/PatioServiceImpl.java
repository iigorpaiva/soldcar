package br.com.soldcar.soldcar.service.impl;

import br.com.soldcar.soldcar.dto.PatioRequestDTO;
import br.com.soldcar.soldcar.dto.PatioResponseDTO;
import br.com.soldcar.soldcar.exception.CarroInvalidoException;
import br.com.soldcar.soldcar.exception.PatioInvalidoException;
import br.com.soldcar.soldcar.mapper.PatioMapper;
import br.com.soldcar.soldcar.model.Patio;
import br.com.soldcar.soldcar.repository.PatioRepository;
import br.com.soldcar.soldcar.service.PatioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PatioServiceImpl implements PatioService {


    @Autowired
    private PatioRepository patioRepository;
    @Autowired
    private PatioMapper patioMapper;


    @Override
    public Patio inserirPatio(PatioRequestDTO patioRequestDTO) {
        if (validaCamposPatiosACadastrar(patioRequestDTO)) {
            throw new PatioInvalidoException("Patio não pode ser cadastrado devido a informações inválidas");
        }

        Patio patio = patioMapper.patioRequestDTOtoPatio(patioRequestDTO);
        patioRepository.save(patio);
        return patio;
    }

    @Override
    public List<PatioResponseDTO> buscarTodosOsPatios() {
        List<Patio> patios = patioRepository.findAll();
        
        List<PatioResponseDTO> listaTodosOsPatios = patioMapper.patioToPatioResponseDTO(patios);
        
        if (listaTodosOsPatios.isEmpty()) {
            throw new CarroInvalidoException("Nenhum pátio foi encontrado");
        }
        return listaTodosOsPatios;
    }

    private boolean validaCamposPatiosACadastrar(PatioRequestDTO patioRequestDTO) {
        return patioRequestDTO.getNome() == null;
    }
}
