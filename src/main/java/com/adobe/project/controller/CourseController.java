package com.adobe.project.controller;

import com.adobe.project.entity.Course;
import com.adobe.project.service.AuthService;
import com.adobe.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
	private final CourseService courseService;
	private final AuthService authService;

	@Autowired
	public CourseController(CourseService courseService, AuthService authService) {
		this.courseService = courseService;
		this.authService = authService;
	}

	@GetMapping("/")
	public List<Course> getAll() {
		return courseService.getAll();
	}

	@GetMapping("/{id}")
	public Course findById(@PathVariable("id") long id) {
		return courseService.findById(id);
	}

	@PostMapping("/")
	public void create(@RequestBody Course course, @RequestHeader("Authorization") Long token, HttpServletResponse response) {
		if (authService.isAuthorized(token, "admin"))
			courseService.create(course);
		else
			response.setStatus(403);
	}

	@PostMapping("/{id}")
	public void update(@PathVariable("id") long id, @RequestBody Course update, @RequestHeader("Authorization") Long token, HttpServletResponse response) {
		if (authService.isAuthorized(token, "admin"))
			courseService.update(id, update);
		else
			response.setStatus(403);
	}

	@DeleteMapping("/")
	public void delete(@RequestParam long id, @RequestHeader("Authorization") Long token, HttpServletResponse response) {
		if (authService.isAuthorized(token, "admin"))
			courseService.delete(id);
		else
			response.setStatus(403);
	}
}
