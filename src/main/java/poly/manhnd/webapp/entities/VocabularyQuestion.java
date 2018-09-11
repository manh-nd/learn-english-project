package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vocabulary_questions")
@Data
public class VocabularyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_QUESTION_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "VOCABULARY_QUESTION", nullable = false, length = 255)
	private String vocabularyQuestion;

	@OneToMany(mappedBy = "vocabularyQuestion")
	private List<VocabularyAnswer> vocabularyAnswers;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VOCABULARY_LESSON_ID", nullable = false)
	private VocabularyLesson vocabularyLesson;

}