package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.manhnd.webapp.entities.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

}