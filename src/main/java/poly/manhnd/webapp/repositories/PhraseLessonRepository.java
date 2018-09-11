package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.dto.PhraseLessonDTO;
import poly.manhnd.webapp.entities.PhraseLesson;

public interface PhraseLessonRepository extends JpaRepository<PhraseLesson, Long> {

	@Query("SELECT count(distinct p.lesson) FROM PhraseLesson p")
	long countLesson();

	@Query("SELECT new poly.manhnd.webapp.dto.PhraseLessonDTO"
		 + "(p.phrase, p.ipa, pd.description, pd.meaning, s.sentence, s.ipa, s.meaning) "
		 + "FROM PhraseLesson pl inner join PhraseDetail pd on pl.phraseDetail = pd "
		 + "inner join PhraseExample px on px.phraseDetail= pd "
		 + "inner join Phrase p on pd.phrase= p "
		 + "inner join Sentence s on px.sentence = s WHERE pl.lesson=:lesson ORDER BY pl.order asc")
	List<PhraseLessonDTO> getPhraseLessonContent(@Param("lesson") Integer lesson);
	
	@Query("SELECT max(p.lesson) FROM PhraseLesson p")
	long getMaxCurrentLesson();

}