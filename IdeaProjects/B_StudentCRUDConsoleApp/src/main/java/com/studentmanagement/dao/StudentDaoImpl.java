package com.studentmanagement.dao;

import com.studentmanagement.entities.Student;

import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

/*
    Name    : Monu KD (monukd01dev)
    Project : B_StudentCRUDConsoleApp
    Date    : 13-Sep-2023
    
    Connect
    Twitter  : https://twitter.com/monukd01dev
    LinkedIN : https://www.linkedin.com/in/monukd01dev/
    GitHub   : https://github.com/monukd01dev
     
*/
public class StudentDaoImpl implements StudentDao {
    private HibernateTemplate hibernateTemplate;

    public StudentDaoImpl() {
        super();
    }
    public StudentDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }



    //write override methods here
    @Override
    @Transactional
    public int insert(Student student) {
        return (Integer) this.hibernateTemplate.save(student);
    }

    @Override
    public Student getStudent(int studentId) {
        return this.hibernateTemplate.get(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.hibernateTemplate.loadAll(Student.class);
    }

    @Override
    @Transactional
    public void delete(int studentId) {
        this.hibernateTemplate.delete(getStudent(studentId));
    }


}
