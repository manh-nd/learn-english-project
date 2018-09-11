package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "vocabulary_examples")
@Data
public class VocabularyExample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_EXAMPLE_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SENTENCE_ID", nullable = false)
	private Sentence sentence;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VOCABULARY_ID", nullable = false)
	private Vocabulary vocabulary;

}