package taskingBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import taskingBoard.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Transactional(readOnly = true)
	User findByUsername(String username);

}
