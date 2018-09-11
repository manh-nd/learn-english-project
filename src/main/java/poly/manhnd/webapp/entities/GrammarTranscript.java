package poly.manhnd.webapp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "grammar_transcript")
@Data
public class GrammarTranscript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRAMMAR_TRANSCRIPT_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "GRAMMAR_LESSON_ID", nullable = false)
	private GrammarLesson grammarLesson;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_COURSE_ID", nullable = false)
	private UserCourse userCourse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", insertable = false, updatable = false)
	private Date createdDate;

	@Column(name = "GRAMMAR_MARK", updatable = false)
	private Float mark;

	public GrammarTranscript(GrammarLesson grammarLesson, UserCourse userCourse, Float mark) {
		super();
		this.mark = mark;
		this.grammarLesson = grammarLesson;
		this.userCourse = userCourse;
	}

}