package poly.manhnd.webapp.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.manhnd.webapp.dto.Dictionary;
import poly.manhnd.webapp.services.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService service;

	@GetMapping
	public String goDictionary() {
		return "user/dictionary/dictionary_index";
	}

	@GetMapping("/search")
	public String search(@RequestParam("key") String key, Model model) {
		key = key.trim();
		if (key.isEmpty()) {
			model.addAttribute("keyEmpty", true);
			return "user/dictionary/dictionary_index";
		}

		long startTime = System.currentTimeMillis();
		int totalResult = service.count(key);
		List<Dictionary> dictionaries = service.findAll(key, 0);
		long endTime = System.currentTimeMillis();
		double totalTime = (double) (endTime - startTime) / 1000;

		model.addAttribute("key", key);
		model.addAttribute("totalResult", totalResult);
		model.addAttribute("totalTime", totalTime);
		model.addAttribute("result", dictionaries);

		return "user/dictionary/dictionary_search";
	}

	@GetMapping("/more-result")
	public @ResponseBody List<Dictionary> ajaxResult(@RequestParam("key") String key,
			@RequestParam("page") Integer page) {
		return service.findAll(key, page);
	}


	@ModelAttribute("active_dictionary")
	public String active() {
		System.out.println("active dictionary");
		return "active";
	}

}
