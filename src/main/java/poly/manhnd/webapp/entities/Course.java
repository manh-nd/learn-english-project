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
@Table(name = "courses")
@Data
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "COURSE_NAME", nullable = false, length = 255)
	private String name;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<GrammarLesson> grammarLessons;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<PhraseLesson> phraseLessons;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<UserCourse> userCourses;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<VocabularyLesson> vocabularyLessons;

}