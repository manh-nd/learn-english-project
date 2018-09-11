package poly.manhnd.webapp.controllers.admin;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
public class GrammarManagerController {
	
	@GetMapping("/grammar")
	public String goGrammarManager(Model model) {
		model.addAttribute("admin_grammar", "active");
		return "admin/grammar/grammar_index";
	}
	
	@ModelAttribute("active_admin_grammar")
	public String active() {
		System.out.println("active grammar");
		return "active";
	}
	
	
}
