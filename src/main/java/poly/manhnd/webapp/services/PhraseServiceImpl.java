package poly.manhnd.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.dto.PhraseDTO;
import poly.manhnd.webapp.dto.PhraseExampleDTO;
import poly.manhnd.webapp.dto.PhraseLessonDTO;
import poly.manhnd.webapp.entities.Course;
import poly.manhnd.webapp.entities.PhraseDetail;
import poly.manhnd.webapp.entities.PhraseExample;
import poly.manhnd.webapp.entities.PhraseLesson;
import poly.manhnd.webapp.entities.Sentence;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.entities.UserCourse;
import poly.manhnd.webapp.repositories.CourseRepository;
import poly.manhnd.webapp.repositories.PhraseDetailRepository;
import poly.manhnd.webapp.repositories.PhraseExampleRepository;
import poly.manhnd.webapp.repositories.PhraseLessonRepository;
import poly.manhnd.webapp.repositories.SentenceRepository;
import poly.manhnd.webapp.repositories.UserCourseRepository;

@Service
public class PhraseServiceImpl implements PhraseService {

	@Autowired
	private PhraseDetailRepository pdRepo;

	@Autowired
	private SentenceRepository sRepo;

	@Autowired
	private PhraseExampleRepository peRepo;

	@Autowired
	private PhraseLessonRepository plRepo;

	@Autowired
	private CourseRepository cRepo;

	@Autowired
	private UserCourseRepository ucRepo;

	@Override
	public List<PhraseDTO> getAllPhrases() {
		return pdRepo.getAllPhrases();
	}

	@Override
	public List<PhraseExampleDTO> getAllPhraseExample() {
		return peRepo.getAllPhraseExamples();
	}

	@Override
	public PhraseExampleDTO getPhraseExampleDTO(Long pId, Long sId) {
		PhraseDetail phrase = pdRepo.getOne(pId);
		Sentence sentence = sRepo.getOne(sId);
		return new PhraseExampleDTO(phrase.getId(), phrase.getPhrase().getPhrase(), phrase.getMeaning(),
				sentence.getId(), sentence.getSentence(), sentence.getMeaning());
	}

	@Override
	public PhraseExample addPhraseExample(Long pId, Long sId) {
		PhraseDetail phrase = pdRepo.getOne(pId);
		Sentence sentence = sRepo.getOne(sId);
		return peRepo.save(new PhraseExample(phrase, sentence));
	}

	@Override
	public PhraseLesson addPhraseLesson(Integer lesson, PhraseDetail phraseDetail, Integer order) {
		Course course = cRepo.getOne(2);
		return plRepo.save(new PhraseLesson(lesson, phraseDetail, order, course));
	}

	@Override
	public PhraseExample updatePhraseExample(Long id, Long pId, Long sId) {
		PhraseExample e = peRepo.getOne(id);
		e.setPhraseDetail(pdRepo.getOne(pId));
		e.setSentence(sRepo.getOne(sId));
		return peRepo.save(e);
	}

	@Override
	public PhraseDetail getPhraseDetail(Long id) {
		return pdRepo.getOne(id);
	}

	@Override
	public UserCourse joinCourse(User user) {
		UserCourse userCourse = new UserCourse();
		userCourse.setUser(user);
		userCourse.setCourse(cRepo.getOne(2));
		return ucRepo.save(userCourse);
	}

	@Override
	public boolean isJoined(User user) {
		return ucRepo.existsUser(user, cRepo.getOne(2));
	}

	@Override
	public long countLesson() {
		return plRepo.countLesson();
	}

	@Override
	public long nextLesson(User user) {
		return 0;
	}

	@Override
	public List<PhraseLessonDTO> getPhraseLessonContent(Integer lesson) {
		return plRepo.getPhraseLessonContent(lesson);
	}

	@Override
	public long getMaxCurrentLesson() {
		return plRepo.getMaxCurrentLesson();
	}

}
