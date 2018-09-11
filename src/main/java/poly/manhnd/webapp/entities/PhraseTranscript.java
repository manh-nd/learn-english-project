package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


@Entity
@Table(name="phrase_transcript")
@Data
public class PhraseTranscript implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PHRASE_TRANSCRIPT_ID", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PHRASE_LESSON_ID", nullable=false)
	private PhraseLesson phraseLesson;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_COURSE_ID", nullable=false)
	private UserCourse userCourse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="PHRASE_MARK")
	private float mark;

}