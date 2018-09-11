package poly.manhnd.webapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HomeController {

	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("home", "active");
		return "user/home";
	}

	@ModelAttribute("active_home")
	public String active() {
		System.out.println("active home");
		return "active";
	}

}
