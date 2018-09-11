package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "words")
@Data
@NoArgsConstructor
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORD_ID", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 100)
	private String word;

	@Column(name = "WORD_IPA", length = 100)
	private String ipa;

	@Column(name = "WORD_AUDIO_PATH", length = 1000)
	private String audioPath;

	@Column(name = "WORD_SPECIAL_AUDIO_PATH", length = 1000)
	private String specialAudioPath;

	@OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
	private List<Vocabulary> vocabularies;

	public Word(String word, String ipa, String audioPath, String specialAudioPath) {
		super();
		this.word = word;
		this.ipa = ipa;
		this.audioPath = audioPath;
		this.specialAudioPath = specialAudioPath;
	}

}