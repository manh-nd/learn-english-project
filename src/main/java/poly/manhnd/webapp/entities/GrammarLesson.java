package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "grammar_lessons", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "GRAMMAR_LESSON", "COURSE_ID" }) })
@Data
public class GrammarLesson implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRAMMAR_LESSON_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "GRAMMAR_LESSON", nullable = false)
	private Integer lesson;

	@Column(name = "GRAMMAR_LESSON_NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "GRAMMAR_PATH", length = 1000)
	private String path;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	@OneToMany(mappedBy = "grammarLesson", cascade = CascadeType.ALL)
	private List<GrammarQuestion> grammarQuestions;

	@OneToMany(mappedBy = "grammarLesson", cascade = CascadeType.ALL)
	private List<GrammarTranscript> grammarTranscripts;

	public GrammarLesson() {
		super();
	}

	public GrammarLesson(Integer id, Integer lesson, String name, String path, Course course) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.name = name;
		this.path = path;
		this.course = course;
	}

}