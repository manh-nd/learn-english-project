package poly.manhnd.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.entities.Sentence;
import poly.manhnd.webapp.repositories.SentenceRepository;

@Service
public class SentenceServiceImpl implements SentenceService{

	@Autowired
	private SentenceRepository sRepo;
	
	@Override
	public List<Sentence> getAllSentences() {
		return sRepo.findAll();
	}

}
