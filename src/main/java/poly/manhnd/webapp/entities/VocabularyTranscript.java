package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "vocabulary_transcript")
@Data
public class VocabularyTranscript implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOCABULARY_TRANSCRIPT_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VOCABULARY_LESSON_ID", nullable = false)
	private VocabularyLesson vocabularyLesson;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_COURSE_ID", nullable = false)
	private UserCourse userCourse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "VOCABULARY_MARK")
	private Float mark;

}