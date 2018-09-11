package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "phrase_lessons", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PHRASE_DETAIL_ID", "PHRASE_LESSON", "COURSE_ID" }) })
@Data
@NoArgsConstructor
public class PhraseLesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHRASE_LESSON_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "PHRASE_LESSON", nullable = false)
	private Integer lesson;
	
	@Column(name = "PHRASE_LESSON_ORDER", nullable = false)
	private Integer order;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PHRASE_DETAIL_ID", nullable = false)
	private PhraseDetail phraseDetail;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	@OneToMany(mappedBy = "phraseLesson",cascade=CascadeType.ALL)
	private List<PhraseQuestion> phraseQuestions;

	@OneToMany(mappedBy = "phraseLesson",cascade=CascadeType.ALL)
	private List<PhraseTranscript> phraseTranscripts;

	public PhraseLesson(Integer lesson, PhraseDetail phraseDetail, Integer order, Course course) {
		super();
		this.lesson = lesson;
		this.phraseDetail = phraseDetail;
		this.order = order;
		this.course = course;
	}
	
	

}