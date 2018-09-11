package poly.manhnd.webapp.services;

import java.util.List;

import poly.manhnd.webapp.dto.PhraseDTO;
import poly.manhnd.webapp.dto.PhraseExampleDTO;
import poly.manhnd.webapp.dto.PhraseLessonDTO;
import poly.manhnd.webapp.entities.PhraseDetail;
import poly.manhnd.webapp.entities.PhraseExample;
import poly.manhnd.webapp.entities.PhraseLesson;

public interface PhraseService extends CourseService {

	List<PhraseDTO> getAllPhrases();

	List<PhraseExampleDTO> getAllPhraseExample();

	PhraseExampleDTO getPhraseExampleDTO(Long pId, Long sId);

	PhraseExample addPhraseExample(Long pId, Long sId);
	
	PhraseExample updatePhraseExample(Long id, Long pId, Long sId);

	PhraseLesson addPhraseLesson(Integer lesson, PhraseDetail phraseDetail, Integer order);
	
	/**
	 * Get a object phrase detail
	 * @param id
	 * @return
	 */
	PhraseDetail getPhraseDetail(Long id);
	
	/**
	 * Get content of phrase lesson
	 * @param lesson 
	 * @return
	 */
	List<PhraseLessonDTO> getPhraseLessonContent(Integer lesson);

	long getMaxCurrentLesson();
}
