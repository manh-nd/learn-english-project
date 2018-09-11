package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "phrase_questions")
@Data
public class PhraseQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHRASE_QUESTION_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "PHRASE_QUESTION", nullable = false, length = 255)
	private String question;

	@Column(name = "PHRASE_QUESTION_DESCRIPTION", length = 1000)
	private String description;

	@OneToMany(mappedBy = "phraseQuestion", cascade = CascadeType.ALL)
	private List<PhraseAnswer> phraseAnswers;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PHRASE_LESSON_ID", nullable = false)
	private PhraseLesson phraseLesson;

}