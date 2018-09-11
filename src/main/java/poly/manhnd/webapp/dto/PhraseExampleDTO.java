package poly.manhnd.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhraseExampleDTO {

	private Long id;
	
	private Long phraseId;
	private String phrase;
	private String phraseMeaning;

	private Long sentenceId;
	private String sentence;
	private String sentenceMeaning;

	public PhraseExampleDTO(Long phraseId, String phrase, String phraseMeaning, String sentence, String sentenceMeaning) {
		super();
		this.phraseId = phraseId;
		this.phrase = phrase;
		this.phraseMeaning = phraseMeaning;
		this.sentence = sentence;
		this.sentenceMeaning = sentenceMeaning;
	}

	public PhraseExampleDTO(Long phraseId, String phrase, String phraseMeaning, Long sentenceId, String sentence,
			String sentenceMeaning) {
		super();
		this.phraseId = phraseId;
		this.phrase = phrase;
		this.phraseMeaning = phraseMeaning;
		this.sentenceId = sentenceId;
		this.sentence = sentence;
		this.sentenceMeaning = sentenceMeaning;
	}
	
	

}
