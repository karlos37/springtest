package com.test.springtest.service;

import com.test.springtest.data.entity.StudentEntity;
import com.test.springtest.data.repository.StudentRepository;
import com.test.springtest.mapper.StudentMapper;
import com.test.springtest.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentService() {
    }

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAllStudents(){

        List<StudentEntity> studentEntities = studentRepository.findAll();

        return studentMapper.mapStudentEntityListToStudentList(
                studentEntities
        );
    }

    public Student createStudent(Student student) {
        StudentEntity studentEntity = studentMapper.mapStudentToStudentEntity(student);

        StudentEntity savedStudent = studentRepository.save(studentEntity);

        return studentMapper.mapStudentEntityToStudent(savedStudent);
    }
}
