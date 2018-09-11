package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.manhnd.webapp.dto.UserDTO;
import poly.manhnd.webapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByEmailAddress(String email);

	@Query("SELECT new poly.manhnd.webapp.dto.UserDTO(u.id, u.username, u.password, "
			+ "u.emailAddress, u.firstName, u.createdDate, u.enabled) " + "FROM User u")
	List<UserDTO> getAllUsers();
	
	@Query("SELECT count(*) FROM User u WHERE DATE(u.createdDate) = CURDATE()")
	long countTotalUserRegisteredToday();
}