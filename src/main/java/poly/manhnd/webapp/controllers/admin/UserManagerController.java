package poly.manhnd.webapp.controllers.admin;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.manhnd.webapp.dto.UserDTO;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.services.UserService;

@Controller
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
public class UserManagerController {

	@Autowired
	private UserService service;

	@GetMapping("/user/list")
	public String goUserManager() {
		return "admin/user/user_index";
	}

	@GetMapping("/user/edit")
	public String editUser(@RequestParam("uid") Long uid, Model model) {
		model.addAttribute("user", service.findUser(uid));
		return "admin/user/user_edit_form";
	}

	@PostMapping("/user/update")
	public String updateUser(@RequestParam("uid") Long uid, @RequestParam("enabled") Boolean enabled, Model model) {
		User user = service.findUser(uid);
		user.setEnabled(enabled);
		service.updateUser(user);
		return "redirect:/admin/user/list";
	}

	@ModelAttribute("users")
	public List<UserDTO> getUsers() {
		return service.getAllUsers();
	}

	@ModelAttribute("active_admin_user")
	public String active() {
		System.out.println("active user");
		return "active";
	}

}
