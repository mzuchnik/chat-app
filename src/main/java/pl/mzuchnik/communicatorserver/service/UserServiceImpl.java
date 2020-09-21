package pl.mzuchnik.communicatorserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mzuchnik.communicatorserver.entity.User;
import pl.mzuchnik.communicatorserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NullPointerException("Nie ma użytkownika o id " + id));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
