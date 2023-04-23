package com.example.punkty;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
//    private List<String> users = new CopyOnWriteArrayList<String>();
    private StudentService service=new StudentService();


    //@RequestMapping(value = "/students", method = RequestMethod.GET)
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers(){
        return this.service.getStudents().asJava();
    }
    //@RequestMapping(value = "/students", method = RequestMethod.POST)
    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(@RequestBody NewStudent user){
        return this.service.addStudent(user);
    }
}
//"Anita Kowalska", "Michał Anioł", "Janusz Kowalski"