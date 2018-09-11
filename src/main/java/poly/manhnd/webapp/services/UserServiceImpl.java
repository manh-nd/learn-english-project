package poly.manhnd.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.dto.UserDTO;
import poly.manhnd.webapp.entities.Role;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.repositories.RoleRepository;
import poly.manhnd.webapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		// Default role end-user
		setDefault(user);
		userRepo.save(user);
		return user;
	}

	private void setDefault(User user) {
		Role role = roleRepo.getOne(3);
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUser(username);
		System.out.println(user);
		return user;
	}

	@Override
	public User findUser(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmailAddress(email);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepo.getAllUsers();
	}

	@Override
	public User findUser(Long uid) {
		return userRepo.getOne(uid);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public long getTotalUserRegisteredToday() {
		return userRepo.countTotalUserRegisteredToday();
	}

}