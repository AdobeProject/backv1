package com.adobe.project.service;

import com.adobe.project.entity.Course;
import com.adobe.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course findById(Long id) {
		return courseRepository.getById(id);
	}

	public Course create(Course course) {
		return courseRepository.save(course);
	}

	public void update(Long id, Course update) {
//		Course c = courseRepository.getById(id);
//		courseRepository.save(c);
	}

	public void delete(Long id) {
		Course courseOptional = findById(id);
		courseRepository.delete(courseOptional);
	}
}
