package poly.manhnd.webapp.services;

import java.util.List;

import poly.manhnd.webapp.entities.GrammarLesson;
import poly.manhnd.webapp.entities.GrammarQuestion;
import poly.manhnd.webapp.entities.GrammarTranscript;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.entities.UserCourse;

public interface GrammarService extends CourseService {

	/**
	 * Get list grammar lesson by lesson
	 * 
	 * @param lesson
	 *            Integer type
	 * @return List GrammarQuestion
	 */
	List<GrammarQuestion> getListGrammarQuestionByLesson(Integer lesson);

	/**
	 * Get grammar lesson by lesson
	 * 
	 * @param lesson
	 *            Integer type
	 * @return GrammarLesson Object
	 */
	GrammarLesson getGrammarLesson(Integer lesson);

	/**
	 * Check users
	 * 
	 * @param user
	 * @return
	 */
	boolean isJoined(User user);

	/**
	 * Join grammar course
	 * 
	 * @param user
	 * @return
	 */
	UserCourse joinCourse(User user);

	/**
	 * Check answer is right
	 * 
	 * @param answerId
	 * @return
	 */
	boolean isRightAnswer(Long answerId);

	GrammarTranscript save(Integer lesson, User user, Float mark);

}