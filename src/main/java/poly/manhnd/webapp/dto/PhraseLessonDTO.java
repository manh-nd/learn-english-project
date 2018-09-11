package poly.manhnd.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhraseLessonDTO {
	
	private String phrase;
	private String phraseIPA;
	private String phraseDesc;
	private String phraseMeaning;
	
	private String sentence;
	private String sentenceIPA;
	private String sentenceMeaning;
	
	
}
