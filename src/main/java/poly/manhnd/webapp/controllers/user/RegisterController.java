package poly.manhnd.webapp.controllers.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.services.UserService;
import poly.manhnd.webapp.validators.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService service;
	
	@GetMapping("/register")
	public String goRegister() {
		return "register_form";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("Invalid!");
			return "register_form";
		}

		if (service.findUser(user.getUsername()) != null) {
			errors.rejectValue("username", "message.error.user.username.exists");
			return "register_form";
		} else if (service.findByEmail(user.getEmailAddress()) != null) {
			errors.rejectValue("emailAddress", "message.error.user.email.exists");
			return "register_form";
		}

		service.saveUser(user);
		Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidator());
	}

	@ModelAttribute("user")
	public User getUser() {
		System.out.println("get user");
		return new User();
	}

}
