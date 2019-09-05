package trainingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainingProject.model.security.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
