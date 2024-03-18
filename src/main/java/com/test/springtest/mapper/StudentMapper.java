package com.test.springtest.mapper;

import com.test.springtest.data.entity.StudentEntity;
import com.test.springtest.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {


     @Mapping(target = "name", source = "name")
     Student mapStudentEntityToStudent(StudentEntity studentEntity);

     StudentEntity mapStudentToStudentEntity(Student student);

     List<Student> mapStudentEntityListToStudentList(List<StudentEntity> studentEntityList);
}
