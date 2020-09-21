package pl.mzuchnik.communicatorserver.service;

import pl.mzuchnik.communicatorserver.entity.User;

public interface UserService {

    User getUserById(Long id);
    void addUser(User user);


}
