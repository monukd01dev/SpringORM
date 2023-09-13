package com.studentmanagement.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Name    : Monu KD (monukd01dev)
    Project : B_StudentCRUDConsoleApp
    Date    : 13-Sep-2023
    
    Connect
    Twitter  : https://twitter.com/monukd01dev
    LinkedIN : https://www.linkedin.com/in/monukd01dev/
    GitHub   : https://github.com/monukd01dev
     
*/
@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name="stu_id")
    private int id;

    @Column(name="stu_name")
    private String name;
    @Column(name="stu_clg")
    private String clg;

    public Student() {
        super();
    }

    public Student(int id, String name, String clg) {
        this.id = id;
        this.name = name;
        this.clg = clg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    @Override
    public String toString() {
        return "Student Name : "+name+" ID : "+id+" College : "+clg+".";
    }
}
