package com.geekster.WeeklyTest08102023.service;

import com.geekster.WeeklyTest08102023.model.Course;
import com.geekster.WeeklyTest08102023.model.Student;
import com.geekster.WeeklyTest08102023.model.dto.Apply;
import com.geekster.WeeklyTest08102023.repo.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public String createStudent(Student student) {

        studentRepository.save(student);
        return "New Student Added";
    }
    public String createStudents(List<Student>studentList)
    {
        studentRepository.saveAll(studentList);
        return  "New Students Added";
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());

            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public String enrollInCourse(Apply apply) {
        Integer courseId = apply.getCourseId();
        Course validCourse = courseService.getCourseById(String.valueOf(courseId));
        Integer studentId = apply.getStudentId();
        Student validStudent = getStudentById(String.valueOf(studentId));

        if(validCourse==null )
        {
            return "Not a Valid Course";
        }
        if(validStudent == null)
        {
            return  "Student Not Registered";
        }

        return courseService.addAStudent(validCourse,validStudent);
    }

}
