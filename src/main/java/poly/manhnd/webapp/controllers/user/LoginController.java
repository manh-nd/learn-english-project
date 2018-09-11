package poly.manhnd.webapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import poly.manhnd.webapp.entities.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String goLogin(Model model) {
		model.addAttribute("user", new User());
		return "login_form";
	}
	
}
