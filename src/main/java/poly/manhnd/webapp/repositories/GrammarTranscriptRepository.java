package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.entities.GrammarTranscript;
import poly.manhnd.webapp.entities.User;

public interface GrammarTranscriptRepository extends JpaRepository<GrammarTranscript, Long> {

	List<GrammarTranscript> findByUserCourseUser(User user);

	@Query("select max(t.grammarLesson.lesson) FROM GrammarTranscript t "
			+ "WHERE t.userCourse.user = :user and t.userCourse.course.id = 1 and t.mark>=8")
	Integer getCurrentGrammarLessonPassed(@Param("user") User user);
	
	@Query("SELECT count(t)>0 FROM GrammarTranscript t WHERE t.userCourse.user=:user")
	boolean existsUser(@Param("user") User user);

}