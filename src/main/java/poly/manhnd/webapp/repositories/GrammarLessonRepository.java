package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.entities.GrammarLesson;

public interface GrammarLessonRepository extends JpaRepository<GrammarLesson, Long> {
		
	@Query("SELECT g FROM GrammarLesson g WHERE g.lesson=:lesson AND g.course.id=1")
	GrammarLesson findGrammarLesson(@Param("lesson") Integer lesson);
	
	@Query("SELECT count(distinct g.lesson) FROM GrammarLesson g")
	long countLesson();
	
}