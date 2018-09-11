package poly.manhnd.webapp.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.dto.Dictionary;
import poly.manhnd.webapp.dto.PhraseDTO;
import poly.manhnd.webapp.entities.PhraseDetail;

public interface PhraseDetailRepository extends JpaRepository<PhraseDetail, Long> {
	
	@Query("SELECT new poly.manhnd.webapp.dto.Dictionary(p.phrase.phrase, p.meaning) "
			+ "FROM PhraseDetail p WHERE p.phrase.phrase like :key OR p.meaning like :key")
	List<Dictionary> getDictionary(@Param("key") String key, Pageable pageable);
	
	@Query("SELECT count(p) FROM PhraseDetail p WHERE p.phrase.phrase like :key OR p.meaning like :key")
	int count(@Param("key") String key);
	
	@Query("SELECT new poly.manhnd.webapp.dto.PhraseDTO(p.id,p.phrase.phrase, p.description, p.meaning) "
			+ "FROM PhraseDetail p")
	List<PhraseDTO> getAllPhrases();
	
}