package pl.mzuchnik.communicatorserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.communicatorserver.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


}
