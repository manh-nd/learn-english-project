package poly.manhnd.webapp.services;

import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.entities.UserCourse;

public interface CourseService {
	
	UserCourse joinCourse(User user);
	
	boolean isJoined(User user);
	
	long countLesson();
	
	long nextLesson(User user);
	
}
