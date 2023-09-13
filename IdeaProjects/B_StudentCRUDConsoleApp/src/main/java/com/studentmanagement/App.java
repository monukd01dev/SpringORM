package com.studentmanagement;


import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.dao.StudentDaoImpl;
import com.studentmanagement.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDaoImpl.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean on = true;
        //Menu
        while (on){
            System.out.println("+------------------------------------------------+\n" +
                    "|               STUDENT MANAGEMENT               |\n" +
                    "+------------------------------------------------+\n" +
                    "|\tPRESS 1 : ADD STUDENT                        |\n" +
                    "|\tPRESS 2 : SEARCH STUDENT                     |\n" +
                    "|\tPRESS 3 : SEE ALL STUDENT                    |\n" +
                    "|\tPRESS 4 : DELETE STUDENT                     |\n" +
                    "|\tPRESS 5 : UPDATE STUDENT                     |\n" +
                    "|\tPRESS 6 : EXIT                               |\n" +
                    "+------------------------------------------------+\n" +
                    "|                  @monukd01dev                  |\n" +
                    "+------------------------------------------------+\n");

            try {
                System.out.print("Enter Your Choice : ");
                int userChoice = Integer.parseInt(br.readLine());

                //switch
                switch (userChoice) {
                    case 1 :{
                        //insert -> add student
                        System.out.print("Enter Student ID        : ");
                        int uId = Integer.parseInt(br.readLine());
                        System.out.print("Enter Student Name      : ");
                        String uName = br.readLine();
                        System.out.print("Enter Student College   : ");
                        String uClg = br.readLine();
                        studentDao.insert(new Student(uId, uName, uClg));
                        break;
                    }
                    case 2 :{
                        //get student by id
                        System.out.print("Enter Student ID  : ");
                        int uId = Integer.parseInt(br.readLine());
                        Student sTemp = studentDao.getStudent(uId);
//                        System.out.println(studentDao.getStudent(uId));
                        if (sTemp != null) {
                            System.out.println(sTemp);
                        } else {
                            System.out.println("Student Not Exists");
                        }
                        break;
                    }
                    case 3 :{
                        // get all student
                        int i =1;
                        for (Student student : studentDao.getAllStudents()) {
                            System.out.println( i+". "+student);
                            i++;
                        }
                        System.out.println(" ");
                        break;
                    }
                    case 4 :{
                        // delete student
                        System.out.print("Enter Student ID  : ");
                        int uId = Integer.parseInt(br.readLine());
//                        showing student
                        Student sTemp = studentDao.getStudent(uId);
//                        System.out.println(studentDao.getStudent(uId));
                        if (sTemp != null) {
                            System.out.println(sTemp);
                        } else {
                            System.out.println("Student Not Exists");
                            break;

                        }
                        System.out.print("Are you sure you want to delete this Student (Y/N) : ");
                        String confirm = br.readLine();
                        if (confirm.equals("Y") || confirm.equals("y")){
                            studentDao.delete(uId);
                            System.out.println("Student Deleted SuccessFully...");
                        }

                        break;
                    }
                    case 5 :{
//                        update
                        System.out.print("Enter Student ID  : ");
                        int uId = Integer.parseInt(br.readLine());
//                        showing student
                        Student sTemp = studentDao.getStudent(uId);
//                        System.out.println(studentDao.getStudent(uId));
                        if (sTemp != null) {
                            System.out.println(sTemp);
                        } else {
                            System.out.println("Student Not Exists");
                            break;

                        }
                        System.out.print("Are you sure you want to update this Student detail (Y/N) : ");
                        String confirm = br.readLine();
                        if (confirm.equals("Y") || confirm.equals("y")){
                            System.out.println("-----Enter the new details-----");
                            System.out.print("Enter Student Name      : ");
                            String uName = br.readLine();
                            System.out.print("Enter Student College   : ");
                            String uClg = br.readLine();
                            studentDao.update(new Student(uId, uName, uClg));
                            System.out.println("Student Details Updated SuccessFully...");
                        }
                        break;
                    }
                    case 6 :{
                        //exit
                         on=false;
                        break;
                    }
                    default:{
                        System.out.println("INVALID INPUT : Try With Another One!!");
                    }
                }
            }
            catch(Exception e){
                System.out.println("INVALID INPUT : Try With Another One!!");
            }
        }
        System.out.println("ThankYou For Using My Application");
        System.out.println("See You Soon....");
    }
}
