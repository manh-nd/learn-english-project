package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "vocabulary_answers")
@Data
public class VocabularyAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_ANSWER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "RIGHT_ANSWER", nullable = false)
	private Boolean rightAnswer;

	@Column(name = "VOCABULARY_ANSWER", nullable = false, length = 255)
	private String answer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VOCABULARY_QUESTION_ID", nullable = false)
	private VocabularyQuestion vocabularyQuestion;

}