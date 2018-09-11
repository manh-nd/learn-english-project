package poly.manhnd.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.dto.Dictionary;
import poly.manhnd.webapp.repositories.PhraseDetailRepository;
import poly.manhnd.webapp.repositories.SentenceRepository;

@Service
public class DictionaryService {

	@Autowired
	private SentenceRepository sentenceRepo;

	@Autowired
	private PhraseDetailRepository phraseDetailRepo;

	public List<Dictionary> findAll(String key, int page) {
		key = "%" + key + "%";
		List<Dictionary> dictionaries = new ArrayList<>();
		dictionaries.addAll(phraseDetailRepo.getDictionary(key, PageRequest.of(page, 20)));
		dictionaries.addAll(sentenceRepo.getDictionary(key, PageRequest.of(page, 20)));
		return dictionaries;
	}

	public int count(String key) {
		key = "%" + key + "%";
		return phraseDetailRepo.count(key) + sentenceRepo.count(key);
	}
	
	public String getAudioPath(String sentence) {
		return sentenceRepo.findAudioPathBySentence(sentence);
	}

}
