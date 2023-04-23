package com.example.punkty;

import io.vavr.collection.List;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class StudentServiceTest {
    @Test
    public void getEmptyList(){
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
    @Test
    public void addStudent(){
        final StudentService service = new StudentService();
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);
    }
    @Test
    public void addStudentIsReturned(){
        final StudentService service = new StudentService();
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        List<Student> all = service.getStudents();
        assertEquals(created.name, all.head().name);
    }
    @Test
    public void addStudentHasNewId(){
        final StudentService service = new StudentService();
        final Student created1=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        final Student created2=service.addStudent(new NewStudent("Student2","2-3-4","IP"));
        assertEquals(2,service.getStudents().size());
    }



}