package pl.mzuchnik.communicatorserver.service;

import pl.mzuchnik.communicatorserver.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void addUser(User user);

    Optional<User> findById(Long id);
}
