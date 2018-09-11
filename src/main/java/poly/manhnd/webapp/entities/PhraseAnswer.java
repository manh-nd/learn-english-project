package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="phrase_answers")
@Data
public class PhraseAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PHRASE_ANSWER_ID", unique=true, nullable=false)
	private Long id;

	@Column(name="PHRASE_ANSWER", nullable=false, length=255)
	private String answer;

	@Column(name="RIGHT_ANSWER", nullable=false)
	private Boolean rightAnswer;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PHRASE_QUESTION_ID", nullable=false)
	private PhraseQuestion phraseQuestion;

}