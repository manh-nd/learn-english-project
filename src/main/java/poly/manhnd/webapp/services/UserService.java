package poly.manhnd.webapp.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import poly.manhnd.webapp.dto.UserDTO;
import poly.manhnd.webapp.entities.User;

public interface UserService extends UserDetailsService {

	User findUser(Long uid);
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	User findUser(String username);
	
	User findByEmail(String email);
	
	List<UserDTO> getAllUsers();
	
	long getTotalUserRegisteredToday();

}
