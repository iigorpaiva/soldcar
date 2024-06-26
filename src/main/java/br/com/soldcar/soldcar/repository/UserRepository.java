package br.com.soldcar.soldcar.repository;

import br.com.soldcar.soldcar.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
    UserDetails findByEmail(String email);

    void delete(User user);
}
