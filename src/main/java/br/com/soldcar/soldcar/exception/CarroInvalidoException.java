package br.com.soldcar.soldcar.exception;

public class CarroInvalidoException extends RuntimeException {

    public CarroInvalidoException(String mensagem) {
        super(mensagem);
    }
}
