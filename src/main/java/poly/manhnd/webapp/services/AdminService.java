package poly.manhnd.webapp.services;

import poly.manhnd.webapp.entities.Course;

public interface AdminService {

	long getTotalUser();

	long getTotalSentence();

	long getTotalPhrase();

	long getTotalUserInCourse(Course course);
	
	long getTotalUserRegisteredToday();

	Course getCourse(Integer id);
	
}
