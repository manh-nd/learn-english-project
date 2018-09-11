package poly.manhnd.webapp.controllers.admin;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.manhnd.webapp.entities.Sentence;
import poly.manhnd.webapp.services.SentenceService;

@Controller
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
public class SentenceManagerController {
	
	@Autowired
	private SentenceService serivce;
	
	@GetMapping("/sentence/list")
	public String goSentencePage() {
		return "admin/sentence/sentence_index";
	}
	
	@ModelAttribute("sentences")
	public List<Sentence> getSentences() {
		return serivce.getAllSentences();
	}
	
	@ModelAttribute("active_admin_sentence")
	public String active() {
		System.out.println("active sentence");
		return "active";
	}
	
}
