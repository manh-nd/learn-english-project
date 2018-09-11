package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "word_classes")
@Data
@NoArgsConstructor
public class WordClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORD_CLASS_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "WORD_CLASS_NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "WORD_CLASS_DESCRIPTION", length = 5000)
	private String description;

	@OneToMany(mappedBy = "wordClass", cascade = CascadeType.ALL)
	private List<Vocabulary> vocabularies;

	public WordClass(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

}