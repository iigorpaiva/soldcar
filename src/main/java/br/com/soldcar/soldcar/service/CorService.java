package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.model.Cor;

import java.util.List;

public interface CorService {

    Cor inserirCor(Cor cor);
    List<Cor> buscarTodas();
}
