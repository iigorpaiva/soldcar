package br.com.soldcar.soldcar.util;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    // Converte objeto para JSON
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String primeiraLetraMaiuscula(String palavra) {
        if (palavra == null || palavra.isEmpty()) {
            return palavra; // Retorna a palavra original se for nula ou vazia
        }
        
        // Transforma a primeira letra da palavra em maiúscula e o resto em minúsculas
        String primeiraLetra = palavra.substring(0, 1).toUpperCase();
        String restante = palavra.substring(1).toLowerCase();
        
        return primeiraLetra + restante;
    }

}
