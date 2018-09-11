package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.manhnd.webapp.entities.Word;

public interface WordRepository extends JpaRepository<Word, Long> {

}