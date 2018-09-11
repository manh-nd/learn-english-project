package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phrase_examples")
@Data
@NoArgsConstructor
public class PhraseExample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHRASE_EXAMPLE_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PHRASE_DETAIL_ID", nullable = false)
	private PhraseDetail phraseDetail;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SENTENCE_ID", nullable = false)
	private Sentence sentence;

	public PhraseExample(PhraseDetail phraseDetail, Sentence sentence) {
		super();
		this.phraseDetail = phraseDetail;
		this.sentence = sentence;
	}

}