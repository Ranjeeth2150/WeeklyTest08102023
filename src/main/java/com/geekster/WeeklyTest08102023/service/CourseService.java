package com.geekster.WeeklyTest08102023.service;

import com.geekster.WeeklyTest08102023.model.Course;
import com.geekster.WeeklyTest08102023.model.Student;
import com.geekster.WeeklyTest08102023.repo.ICourseRepository;
import com.geekster.WeeklyTest08102023.repo.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private ICourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public String addCourses(List<Course> courseList) {
        courseRepository.saveAll(courseList);
        return "Courses added";
    }

    public Course updateCourse(String id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());

            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }


    public String addAStudent(Course course , Student student) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        course.setStudent(studentList);
        courseRepository.save(course);
        return "Welcome "+student.getName()+" to "+course.getTitle();

    }

}
