package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.manhnd.webapp.dto.PhraseExampleDTO;
import poly.manhnd.webapp.entities.PhraseExample;

public interface PhraseExampleRepository extends JpaRepository<PhraseExample, Long> {

	@Query("SELECT new poly.manhnd.webapp.dto.PhraseExampleDTO("
			+ "p.id, p.phraseDetail.id, p.phraseDetail.phrase.phrase, p.phraseDetail.meaning, p.sentence.id, p.sentence.sentence, p.sentence.meaning) "
			+ "FROM PhraseExample p")
	List<PhraseExampleDTO> getAllPhraseExamples();

}