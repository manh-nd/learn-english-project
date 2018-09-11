package poly.manhnd.webapp.controllers.admin;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import poly.manhnd.webapp.dto.PhraseDTO;
import poly.manhnd.webapp.dto.PhraseExampleDTO;
import poly.manhnd.webapp.services.PhraseService;

@Controller
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
@SessionAttributes(value = { "phrases", "phraseExamples" })
public class PhraseManagerController {

	@Autowired
	private PhraseService phraseService;

	@GetMapping("/phrase/list/phrase-detail")
	public String goPhrase() {
		return "admin/phrase/phrase_index";
	}

	@GetMapping("/phrase/list/phrase-example")
	public String goPhraseExampleForm() {
		return "admin/phrase/phrase_example_form";
	}
	@GetMapping("/phrase/list/phrase-lesson")
	public String goPhraseLesson() {
		return "admin/phrase/phrase_lesson";
	}

	@PostMapping("/phrase/review/phrase-example")
	public @ResponseBody PhraseExampleDTO reviewPhraseExample(@RequestParam("pId") Long pId,
			@RequestParam("sId") Long sId) {
		return phraseService.getPhraseExampleDTO(pId, sId);
	}

	@PostMapping(value = "/phrase/save/phrase-example", params = { "pId", "sId" })
	public String savePhraseExample(@RequestParam("pId") Long pId, @RequestParam("sId") Long sId,
			SessionStatus status) {
		phraseService.addPhraseExample(pId, sId);
		status.setComplete();
		return "redirect:/admin/phrase/list/phrase-example";
	}

	@PostMapping(value = "/phrase/save/phrase-example", params = { "id", "pId", "sId" })
	public String updatePhraseExample(@RequestParam("id") Long id, @RequestParam("pId") Long pId,
			@RequestParam("sId") Long sId, SessionStatus status) {
		phraseService.updatePhraseExample(id, pId, sId);
		status.setComplete();
		return "redirect:/admin/phrase/list/phrase-example";
	}

	@PostMapping(value = "/phrase/save/phrase-lesson", params = { "phrase-detail-id", "phrase-lesson", "phrase-order" })
	public String savePhraseLesson(@RequestParam("phrase-detail-id") Long pdId,
			@RequestParam("phrase-lesson") Integer lesson, @RequestParam("phrase-order") Integer order,
			SessionStatus status) {
		phraseService.addPhraseLesson(lesson, phraseService.getPhraseDetail(pdId), order);
		status.setComplete();
		return "redirect:/admin/phrase/list/phrase-example";

	}

	@ModelAttribute("phrases")
	public List<PhraseDTO> getPhrases() {
		return phraseService.getAllPhrases();
	}

	@ModelAttribute("phraseExamples")
	public List<PhraseExampleDTO> getPhraseExamples() {
		return phraseService.getAllPhraseExample();
	}

	@ModelAttribute("active_admin_phrase")
	public String active() {
		System.out.println("active phrase");
		return "active";
	}

}
