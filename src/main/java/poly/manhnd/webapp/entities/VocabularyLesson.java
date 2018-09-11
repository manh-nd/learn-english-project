package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vocabulary_lessons", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "VOCABULARY_ID", "VOCABULARY_LESSON", "COURSE_ID" }) })
@Data
public class VocabularyLesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_LESSON_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "VOCABULARY_LESSON", nullable = false)
	private Integer vocabularyLesson;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VOCABULARY_ID", nullable = false)
	private Vocabulary vocabulary;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	@OneToMany(mappedBy = "vocabularyLesson", cascade = CascadeType.ALL)
	private List<VocabularyQuestion> vocabularyQuestions;

	@OneToMany(mappedBy = "vocabularyLesson", cascade = CascadeType.ALL)
	private List<VocabularyTranscript> vocabularyTranscripts;

}