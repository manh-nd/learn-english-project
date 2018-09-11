package poly.manhnd.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phrase_details")
@Data
@NoArgsConstructor
public class PhraseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHRASE_DETAIL_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PHRASE_ID", nullable = false)
	private Phrase phrase;

	@Column(name = "PHRASE_DESCRIPTION", length = 500)
	private String description;

	@Column(name = "PHRASE_MEANING", length = 255)
	private String meaning;

	@Column(name = "PHRASE_SYNONYMS", length = 1000)
	private String synonyms;

	@Column(name = "PHRASE_NOTE", length = 5000)
	private String note;

	@OneToMany(mappedBy = "phraseDetail",cascade=CascadeType.ALL)
	private List<PhraseExample> phraseExamples;

	@OneToMany(mappedBy = "phraseDetail",cascade=CascadeType.ALL)
	private List<PhraseLesson> phraseLessons;

	public PhraseDetail(String description, String meaning, String note, String synonyms, Phrase phrase) {
		super();
		this.description = description;
		this.meaning = meaning;
		this.note = note;
		this.synonyms = synonyms;
		this.phrase = phrase;
	}

}