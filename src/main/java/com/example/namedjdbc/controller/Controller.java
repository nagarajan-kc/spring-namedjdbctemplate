package com.example.namedjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.namedjdbc.dao.TeacherRepository;

import com.example.namedjdbc.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    TeacherRepository teacherRepository;


    @PostMapping("/set")
    public void addTeacher(@RequestBody Teacher teacher) {

         teacherRepository.saveTeacher(teacher);

    }
    @PutMapping("/teacher")
    public void updateUser(@RequestBody Teacher teacher) {

         teacherRepository.updateUser(teacher);

    }

    @GetMapping("/teacher") 
    public List<Teacher> getTeacher() {
        return teacherRepository.allTeacher();
    }

    // @DeleteMapping("/teacher/{id}")
    // public void deleteTeacher(@PathVariable("id") int id){
    //      teacherRepository.deleteById(id);
    // }
}
