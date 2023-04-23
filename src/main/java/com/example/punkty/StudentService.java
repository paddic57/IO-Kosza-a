package com.example.punkty;

import io.vavr.collection.*;


public class StudentService {
    private List<Student> students = List.empty();

    public List<Student> getStudents(){
        return this.students;
    }
    public Student addStudent(NewStudent student){
        Student created = new Student(students.size()+1, student.name, student.number, student.groupp );
        students = this.students.prepend(created);
        return created;
    }


}
