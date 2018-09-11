package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.dto.Dictionary;
import poly.manhnd.webapp.entities.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {

	@Query("SELECT new poly.manhnd.webapp.dto.Dictionary(s.sentence, s.meaning, s.audioPath) "
			+ "FROM Sentence s WHERE s.sentence like :key OR s.meaning like :key")
	List<Dictionary> getDictionary(@Param("key") String key, Pageable pageable);

	@Query("SELECT count(s) FROM Sentence s WHERE s.sentence like :key OR s.meaning like :key")
	int count(@Param("key") String key);

	@Query("SELECT s.audioPath FROM Sentence s WHERE s.sentence=:sentence")
	String findAudioPathBySentence(@Param("sentence") String sentence);
}