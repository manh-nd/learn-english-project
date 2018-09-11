package poly.manhnd.webapp.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_courses", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_ID", "COURSE_ID" }) })
@Data
@NoArgsConstructor
public class UserCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_COURSE_ID", unique = true, nullable = false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JOINED_DATE", insertable = false, updatable = false)
	private Date joinedDate;

	@OneToMany(mappedBy = "userCourse", cascade = CascadeType.ALL)
	private List<GrammarTranscript> grammarTranscripts;

	@OneToMany(mappedBy = "userCourse", cascade = CascadeType.ALL)
	private List<PhraseTranscript> phraseTranscripts;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@OneToMany(mappedBy = "userCourse", cascade = CascadeType.ALL)
	private List<VocabularyTranscript> vocabularyTranscripts;
	

	public UserCourse(Course course, User user) {
		super();
		this.course = course;
		this.user = user;
		joinedDate = new Date();
	}

}