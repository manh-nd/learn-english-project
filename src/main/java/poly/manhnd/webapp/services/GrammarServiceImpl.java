package poly.manhnd.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.entities.GrammarLesson;
import poly.manhnd.webapp.entities.GrammarQuestion;
import poly.manhnd.webapp.entities.GrammarTranscript;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.entities.UserCourse;
import poly.manhnd.webapp.repositories.CourseRepository;
import poly.manhnd.webapp.repositories.GrammarAnswerRepository;
import poly.manhnd.webapp.repositories.GrammarLessonRepository;
import poly.manhnd.webapp.repositories.GrammarQuestionRepository;
import poly.manhnd.webapp.repositories.GrammarTranscriptRepository;
import poly.manhnd.webapp.repositories.UserCourseRepository;

@Service
public class GrammarServiceImpl implements GrammarService {

	@Autowired
	private GrammarLessonRepository glRepo;

	@Autowired
	private GrammarQuestionRepository gqRepo;

	@Autowired
	private GrammarAnswerRepository gaRepo;

	@Autowired
	private GrammarTranscriptRepository gtRepo;

	@Autowired
	private UserCourseRepository ucRepo;

	@Autowired
	private CourseRepository cRepo;

	@Override
	public List<GrammarQuestion> getListGrammarQuestionByLesson(Integer lesson) {
		return gqRepo.findListGrammarQuestionsByLesson(lesson.intValue(), lesson.intValue(), lesson);
	}

	@Override
	public GrammarLesson getGrammarLesson(Integer lesson) {
		return glRepo.findGrammarLesson(lesson);
	}

	@Override
	public boolean isJoined(User user) {
		return ucRepo.existsUser(user, cRepo.getOne(1));
	}

	@Override
	public UserCourse joinCourse(User user) {
		UserCourse userCourse = new UserCourse();
		userCourse.setUser(user);
		userCourse.setCourse(cRepo.getOne(1));
		return ucRepo.save(userCourse);
	}

	@Override
	public boolean isRightAnswer(Long answerId) {
		return gaRepo.getOne(answerId).getRightAnswer();
	}

	@Override
	public GrammarTranscript save(Integer lesson, User user, Float mark) {
		GrammarLesson grammarLesson = getGrammarLesson(lesson);
		UserCourse userCourse = ucRepo.findByUserAndCourse(user, cRepo.getOne(1));
		return gtRepo.save(new GrammarTranscript(grammarLesson, userCourse, mark));
	}

	@Override
	public long countLesson() {
		return glRepo.countLesson();
	}

	@Override
	public long nextLesson(User user) {
		Integer currentLesson = gtRepo.getCurrentGrammarLessonPassed(user);
		if (currentLesson == null)
			currentLesson = 1;
		else
			currentLesson++;
		return currentLesson;
	}

}
