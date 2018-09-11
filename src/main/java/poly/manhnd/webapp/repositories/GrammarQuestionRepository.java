package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.entities.GrammarQuestion;

public interface GrammarQuestionRepository extends JpaRepository<GrammarQuestion, Long> {

	@Query("SELECT g FROM GrammarQuestion g WHERE "
			+ "g.grammarLesson.lesson BETWEEN (case when :lc-2 > 0 then (:lm - 2) else 1 end) AND :lesson"
			+ " AND g.grammarLesson.course.id=1")
	List<GrammarQuestion> findListGrammarQuestionsByLesson(@Param("lc") Integer lc, @Param("lm") Integer lm,
			@Param("lesson") Integer lesson);

}