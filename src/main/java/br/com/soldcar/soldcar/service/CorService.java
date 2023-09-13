package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.model.Cor;

import java.util.List;

public interface CorService {

    /**
     * Método para persistir nova cor
     * @param cor A cor passada como parâmetro a ser persistida
     * @return Cor A entidade persistida
     */
    Cor inserirCor(Cor cor);

    /**
     * Método para buscar uma lista de todas as cores
     * @return Lista de todas as cores
     */
    List<Cor> buscarTodas();
}
