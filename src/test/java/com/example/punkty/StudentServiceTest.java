package com.example.punkty;

import io.vavr.collection.List;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentRepository repository;
    @Test
    public void getEmptyList(){
        final StudentService service = new StudentService(this.repository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
    @Test
    public void addStudent(){
        final StudentService service = new StudentService(this.repository);
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);
    }
    @Test
    public void addStudentIsReturned(){
        final StudentService service = new StudentService(this.repository);
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        List<Student> all = service.getStudents();
        assertEquals(created.name, all.head().name);
    }
    @Test
    public void addStudentHasNewId(){
        final StudentService service = new StudentService(this.repository);
        final Student created1=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        final Student created2=service.addStudent(new NewStudent("Student2","2-3-4","IP"));
        assertEquals(2,service.getStudents().size());
    }
    @AfterEach
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }



}