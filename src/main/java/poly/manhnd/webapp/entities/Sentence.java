package poly.manhnd.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sentences")
@Data
@NoArgsConstructor
public class Sentence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SENTENCE_ID", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 255)
	private String sentence;

	@Column(name = "SENTENCE_IPA", length = 255)
	private String ipa;

	@Column(name = "SENTENCE_MEANING", nullable = false, length = 255)
	private String meaning;

	@Column(name = "SENTENCE_AUDIO_PATH", length = 1000)
	private String audioPath;

	@OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL)
	private List<PhraseExample> phraseExamples;

	@OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL)
	private List<VocabularyExample> vocabularyExamples;

	public Sentence(String sentence, String ipa, String meaning, String audioPath) {
		super();
		this.sentence = sentence;
		this.ipa = ipa;
		this.meaning = meaning;
		this.audioPath = audioPath;
	}

}