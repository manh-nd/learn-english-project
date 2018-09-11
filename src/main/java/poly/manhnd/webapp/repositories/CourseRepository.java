package poly.manhnd.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.manhnd.webapp.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
