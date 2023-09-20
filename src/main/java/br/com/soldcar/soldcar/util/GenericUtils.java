package br.com.soldcar.soldcar.util;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericUtils {

    // Verifica se uma lista está vazia (ou nula).
    public <T> boolean isEmptyList(List<T> list) {
        return list == null || list.isEmpty();
    }

    // Verifica se uma lista não está vazia.
    public <T> boolean isNotEmptyList(List<T> list) {
        return !isEmptyList(list);
    }

    // Remove espaços em branco no início e no final de uma string.
    public String trimWhitespace(String input) {
        return input.trim();
    }

    // Verifica se uma string está vazia ou nula.
    public boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // Verifica se uma string não está vazia nem nula.
    public boolean isNotEmpty(String input) {
        return !isEmpty(input);
    }

    // Converte uma string em letras maiúsculas.
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // Converte uma string em letras minúsculas.
    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    // Verifica se uma variável é nula.
    public <T> boolean isNull(T variable) {
        return variable == null;
    }

    // Verifica se uma string é nula ou vazia.
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
