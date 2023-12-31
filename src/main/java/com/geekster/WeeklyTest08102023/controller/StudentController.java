package com.geekster.WeeklyTest08102023.controller;

import com.geekster.WeeklyTest08102023.model.Student;
import com.geekster.WeeklyTest08102023.model.dto.Apply;
import com.geekster.WeeklyTest08102023.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping("student")
    public String createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }
    @PostMapping("students")
    public String createStudents(@RequestBody List<Student> studentList)
    {
        return  studentService.createStudents(studentList);
    }
    @PostMapping("apply/course")
    public String enrollInCourse(@RequestBody Apply apply)
    {
        return studentService.enrollInCourse(apply);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
