/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.dao;
 
import java.util.List; 
import com.albany.edu.fwp.model.Student;
 
public interface StudentDAO {
    List<Student> list();
    Student getStudent(String studentId);
    void insert(Student student);
    //void insert();
}

