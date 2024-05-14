package mk.ukim.finki.usermanagement.domain.repository;

import mk.ukim.finki.usermanagement.domain.models.User;
import mk.ukim.finki.usermanagement.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
