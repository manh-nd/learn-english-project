package poly.manhnd.webapp.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.services.PhraseService;

@Controller
@RequestMapping("/phrase")
public class PhraseController {

	@Autowired
	private PhraseService phraseService;

	@GetMapping
	public String goPhraseIndex(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean joined = phraseService.isJoined(user);
		if (joined) {
			model.addAttribute("totalLesson", phraseService.countLesson());
		}
		model.addAttribute("joined", joined);
		return "user/phrase/phrase_index";
	}

	@PostMapping("/join-course")
	public String joinCourse() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean joined = phraseService.isJoined(user);
		if (!joined) {
			phraseService.joinCourse(user);
		}
		return "redirect:/phrase";
	}

	@GetMapping("/lesson-{lesson}")
	public String goLesson(@PathVariable("lesson") Integer lesson, Model model) {
		if (lesson > phraseService.getMaxCurrentLesson())
			return "redirect:/phrase";

		model.addAttribute("content", phraseService.getPhraseLessonContent(lesson));
		model.addAttribute("lesson", lesson);
		return "user/phrase/phrase_lesson";
	}

	@ModelAttribute("active_phrase")
	public String active() {
		System.out.println("active phrase");
		return "active";
	}

}
