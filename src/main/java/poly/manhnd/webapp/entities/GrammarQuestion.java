package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "grammar_questions")
@Data
public class GrammarQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRAMMAR_QUESTION_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "GRAMMAR_LESSON_ID", nullable = false)
	private GrammarLesson grammarLesson;

	@Column(name = "GRAMMAR_MEANING", length = 255)
	private String meaning;

	@Column(name = "GRAMMAR_QUESTION", nullable = false, length = 255)
	private String question;

	@Column(name = "GRAMMAR_SUGGESTION", length = 500)
	private String suggestion;

	@OneToMany(mappedBy = "grammarQuestion", cascade = CascadeType.ALL)
	private List<GrammarAnswer> grammarAnswers;
	
	public GrammarQuestion() {
	}

	public GrammarQuestion(Long id, GrammarLesson grammarLesson, String question, String meaning, String suggestion) {
		super();
		this.id = id;
		this.grammarLesson = grammarLesson;
		this.question = question;
		this.meaning = meaning;
		this.suggestion = suggestion;
	}

}