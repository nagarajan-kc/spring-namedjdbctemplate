package com.example.namedjdbc.dao;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.namedjdbc.model.Teacher;

@Component
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String sql = "INSERT INTO TEACHER(id,salary,name,subject) values(:id,:salary,:name,:subject)";
    private static final String UPDATE_TEACHER_BY_ID_QUERY = "UPDATE TEACHER SET name=:name WHERE ID=:id";
    private static final String GET_TEACHER_QUERY = "SELECT * FROM TEACHER";
    //   private static final String DELETE_TEACHER_BY_ID_QUERY = "DELETE FROM TEACHER WHERE ID=?";

@Override
    public void saveTeacher(Teacher teacher) {
        MapSqlParameterSource mapParameters = new MapSqlParameterSource();
        mapParameters.addValue("id", teacher.getId());
        mapParameters.addValue("salary", teacher.getSalary());
        mapParameters.addValue("name", teacher.getName());
        mapParameters.addValue("subject", teacher.getSubject());
        jdbcTemplate.update(sql, mapParameters);
    }

    @Override
    public void updateUser(Teacher teacher) {
         MapSqlParameterSource mapParameters = new MapSqlParameterSource();
         mapParameters.addValue("id", teacher.getId());
         mapParameters.addValue("name", teacher.getName());
         jdbcTemplate.update(UPDATE_TEACHER_BY_ID_QUERY, mapParameters);
       
    }

   
    @Override
    public List<Teacher> allTeacher() {
        return jdbcTemplate.query(GET_TEACHER_QUERY, (rs, rowNum) -> {
            return new Teacher(rs.getInt("id"), rs.getInt("Salary"), rs.getString("Name"), rs.getString("Subject"));
        });
    }
     
    // @Override
    // public void deleteById(int id) {
    //     MapSqlParameterSource mapParameters = new MapSqlParameterSource();
    //     mapParameters.addValue("id", id);
    //     jdbcTemplate.update(DELETE_TEACHER_BY_ID_QUERY, mapParameters);
       
    // }

}
