package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.manhnd.webapp.entities.Phrase;


public interface PhraseRepository extends JpaRepository<Phrase, Long> {

}