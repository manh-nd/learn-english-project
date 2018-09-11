package poly.manhnd.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "phrases")
@Data
public class Phrase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHRASE_ID", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 255)
	private String phrase;

	@Column(name = "PHRASE_IPA", length = 255)
	private String ipa;

	@OneToMany(mappedBy = "phrase", cascade = CascadeType.ALL)
	private List<PhraseDetail> phraseDetails;

	public Phrase(String phrase, String ipa) {
		super();
		this.phrase = phrase;
		this.ipa = ipa;
	}

	public Phrase() {
		super();
	}

}