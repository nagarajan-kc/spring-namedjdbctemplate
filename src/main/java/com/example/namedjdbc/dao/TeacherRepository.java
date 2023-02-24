package com.example.namedjdbc.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.example.namedjdbc.model.Teacher;

@Component
public interface TeacherRepository  {
    void saveTeacher(Teacher teacher);
    void updateUser(Teacher teacher);
    List<Teacher> allTeacher();
    //  void deleteById(int id);

}
