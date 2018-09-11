package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="grammar_answers")
@Data
public class GrammarAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GRAMMAR_ANSWER_ID", unique=true, nullable=false)
	private Long id;

	@Column(name="GRAMMAR_ANSWER", nullable=false, length=255)
	private String answer;

	@Column(name="GRAMMAR_ANSWER_DESCRIPTION", length=1000)
	private String description;

	@Column(name="GRAMMAR_ANSWER_MEANING", length=255)
	private String meaning;

	@Column(name="RIGHT_ANSWER", nullable=false)
	private Boolean rightAnswer;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GRAMMAR_QUESTION_ID", nullable=false)
	private GrammarQuestion grammarQuestion;

}