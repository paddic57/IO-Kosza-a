package com.example.punkty;

import io.vavr.collection.*;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentService {
    private List<Student> students = List.empty();
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

//    List<Student> getStudents() {
//        return List.ofAll(this.repository.findAll())
//                .map(getStudentRowStudentFunction());
//    }
    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(dbObj->
                        new Student(
                                dbObj.getId(),
                                dbObj.getName(),
                                dbObj.getNumber(),
                                dbObj.getGroup())
                );
    }

    private static Function<StudentRow, Student> getStudentRowStudentFunction() {
        return x -> new Student(
                x.getId(),
                x.getName(),
                x.getNumber(),
                x.getGroup()
        );
    }
    Student addStudent(final NewStudent newStudent) {
        StudentRow created = this.repository.save(new StudentRow(
                newStudent.name,
                newStudent.number,
                newStudent.groupp
        ));
        return getStudentRowStudentFunction().apply(created);
    }


}
