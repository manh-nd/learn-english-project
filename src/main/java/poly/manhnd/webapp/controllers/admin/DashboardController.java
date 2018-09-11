package poly.manhnd.webapp.controllers.admin;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.manhnd.webapp.services.AdminService;

@Controller
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
public class DashboardController {

	@Autowired
	private AdminService service;

	@GetMapping
	public String goAdminPage(Model model) {
		model.addAttribute("admin_dashboard", "active");
		
		model.addAttribute("totalUser", service.getTotalUser());
		model.addAttribute("totalSentence", service.getTotalSentence());
		model.addAttribute("totalPhrase", service.getTotalPhrase());
		
		model.addAttribute("totalUserRegisteredToday", service.getTotalUserRegisteredToday());
		model.addAttribute("totalUserInPhraseCourse", service.getTotalUserInCourse(service.getCourse(2)));
		model.addAttribute("totalUserInGrammarCourse", service.getTotalUserInCourse(service.getCourse(1)));
		
		return "admin/dashboard";
	}

	@ModelAttribute("active_admin_dashboard")
	public String active() {
		System.out.println("active dashboard");
		return "active";
	}

}
