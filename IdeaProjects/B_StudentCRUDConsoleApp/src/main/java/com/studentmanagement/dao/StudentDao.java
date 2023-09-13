package com.studentmanagement.dao;

import com.studentmanagement.entities.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao {

    public int insert(Student student);

    public Student getStudent(int studentId);

    public List<Student> getAllStudents();

    public void delete(int studentId);

    public void update(Student student);

}
