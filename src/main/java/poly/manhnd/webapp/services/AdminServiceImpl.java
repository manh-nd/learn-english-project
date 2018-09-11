package poly.manhnd.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.manhnd.webapp.entities.Course;
import poly.manhnd.webapp.repositories.CourseRepository;
import poly.manhnd.webapp.repositories.PhraseDetailRepository;
import poly.manhnd.webapp.repositories.SentenceRepository;
import poly.manhnd.webapp.repositories.UserCourseRepository;
import poly.manhnd.webapp.repositories.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private PhraseDetailRepository pdRepo;
	
	@Autowired
	private SentenceRepository sRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private CourseRepository cRepo;
	
	@Autowired
	private UserCourseRepository ucRepo;
	
	
	@Override
	public long getTotalUser() {
		return uRepo.count();
	}

	@Override
	public long getTotalSentence() {
		return sRepo.count();
	}

	@Override
	public long getTotalPhrase() {
		return pdRepo.count();
	}

	@Override
	public long getTotalUserInCourse(Course course) {
		return ucRepo.countUserInCourse(course);
	}

	@Override
	public Course getCourse(Integer id) {
		return cRepo.getOne(id);
	}

	@Override
	public long getTotalUserRegisteredToday() {
		return uRepo.countTotalUserRegisteredToday();
	}

}
