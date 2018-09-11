package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vocabularies")
@Data
@NoArgsConstructor
public class Vocabulary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WORD_ID", nullable = false)
	private Word word;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WORD_CLASS_ID", nullable = false)
	private WordClass wordClass;

	@Column(name = "VOCABULARY_DESCRIPTION", length = 500)
	private String description;

	@Column(name = "VOCABULARY_MEANING", nullable = false, length = 255)
	private String meaning;

	@Column(name = "VOCABULARY_IMAGE_PATH", length = 1000)
	private String imagePath;

	@OneToMany(mappedBy = "vocabulary", cascade = CascadeType.ALL)
	private List<VocabularyExample> vocabularyExamples;

	@OneToMany(mappedBy = "vocabulary", cascade = CascadeType.ALL)
	private List<VocabularyLesson> vocabularyLessons;

	public Vocabulary(Word word, WordClass wordClass, String description, String meaning, String imagePath) {
		super();
		this.word = word;
		this.wordClass = wordClass;
		this.description = description;
		this.meaning = meaning;
		this.imagePath = imagePath;
	}

}