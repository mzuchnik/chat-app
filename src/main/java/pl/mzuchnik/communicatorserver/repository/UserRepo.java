package pl.mzuchnik.communicatorserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.communicatorserver.entity.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
