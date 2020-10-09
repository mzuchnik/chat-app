package pl.mzuchnik.communicatorserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mzuchnik.communicatorserver.entity.User;
import pl.mzuchnik.communicatorserver.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userRepo.saveAndFlush(user);
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }
}
