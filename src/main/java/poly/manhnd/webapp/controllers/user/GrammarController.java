package poly.manhnd.webapp.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poly.manhnd.webapp.dto.QnA;
import poly.manhnd.webapp.dto.QnAList;
import poly.manhnd.webapp.entities.GrammarQuestion;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.services.GrammarService;

@Controller
@RequestMapping("/grammar")
@SessionAttributes(value = { "qnaList" })
public class GrammarController {

	@Autowired
	private GrammarService grammarService;

	@GetMapping
	public String goGrammarIndex(Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean joined = grammarService.isJoined(user);
		if (joined) {
			long nextLesson = grammarService.nextLesson(user);
			model.addAttribute("nextLesson", nextLesson);
		}

		model.addAttribute("joined", joined);

		return "user/grammar/grammar_index";
	}

	@GetMapping("/lesson-{lesson}")
	public String goGrammarLesson(@PathVariable("lesson") Integer lesson, Model model) {
		model.addAttribute("grammar", "active");

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean joined = grammarService.isJoined(user);
		if (!joined) {
			return "redirect:/grammar";
		} else {
			long nextLesson = grammarService.nextLesson(user);
			if (lesson > nextLesson || lesson >= 180)
				return "redirect:/grammar";
			else if (lesson < 1)
				return "redirect:/grammar";
			else
				model.addAttribute("lesson", lesson);
		}
		return "user/grammar/grammar_lesson";
	}

	@PostMapping("/join-course")
	public String joinGrammarCourse() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean joined = grammarService.isJoined(user);
		if (!joined) {
			grammarService.joinCourse(user);
		}
		return "redirect:/grammar";
	}

	@GetMapping("/lesson-{lesson}-quiz")
	public String doQuizTest(@PathVariable("lesson") Integer lesson, Model model) {
		model.addAttribute("grammar", "active");

		List<GrammarQuestion> questions = grammarService.getListGrammarQuestionByLesson(lesson);

		QnAList qnAList = new QnAList();
		qnAList.setQuestions(questions);

		model.addAttribute("lesson", lesson);
		model.addAttribute("qnaList", qnAList);

		return "user/grammar/grammar_quiz_form";
	}

	@PostMapping("/lesson-{lesson}-quiz")
	public String getResult(@PathVariable("lesson") Integer lesson, @ModelAttribute("qnaList") QnAList qnAList,
			RedirectAttributes attributes) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		final float total = 10.0f;
		final int size = qnAList.getQuestions().size();
		int rightAnswerCount = 0;

		for (QnA e : qnAList.getList()) {
			if (e.getAnswerId() != null)
				if (grammarService.isRightAnswer(e.getAnswerId()))
					rightAnswerCount++;
		}

		float mark = total * rightAnswerCount / size;
		qnAList.setMark(mark);

		grammarService.save(lesson, user, mark);

		return "redirect:/grammar/lesson-" + lesson + "-quiz-result";
	}

	@GetMapping("/lesson-{lesson}-quiz-result")
	public String showResult(@ModelAttribute("qnaList") QnAList qnAList, @PathVariable("lesson") Integer lesson,
			Model model, SessionStatus status) {
		model.addAttribute("grammar", "active");
		status.setComplete();

		model.addAttribute("lesson", lesson);
		model.addAttribute("qnaList", qnAList);
		return "user/grammar/grammar_quiz_result";
	}
	
	@ModelAttribute("active_grammar")
	public String active() {
		System.out.println("active grammar");
		return "active";
	}

}
