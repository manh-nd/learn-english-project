package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.manhnd.webapp.entities.Course;
import poly.manhnd.webapp.entities.User;
import poly.manhnd.webapp.entities.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

	UserCourse findByUserAndCourse(User user, Course course);

	@Query("SELECT count(uc)>0 FROM UserCourse uc WHERE uc.user=:user AND uc.course=:course")
	boolean existsUser(@Param("user") User user, @Param("course") Course course);
	
	@Query("SELECT count(*) FROM UserCourse uc WHERE uc.course=:course")
	long countUserInCourse(@Param("course") Course course);

}