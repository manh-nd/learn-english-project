package poly.manhnd.webapp.controllers.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import poly.manhnd.webapp.entities.User;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String goProfile() {
		return "user/profile";
	}
	
	@ModelAttribute("user")
	public User getUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
