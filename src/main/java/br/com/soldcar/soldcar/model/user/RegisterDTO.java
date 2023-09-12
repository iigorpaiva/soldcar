package br.com.soldcar.soldcar.model.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
