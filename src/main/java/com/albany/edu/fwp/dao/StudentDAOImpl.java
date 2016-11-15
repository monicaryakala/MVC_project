/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.dao;
 
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
 




import com.albany.edu.fwp.model.Student;
 
public class StudentDAOImpl implements StudentDAO {
    private SessionFactory sessionFactory;
 
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    
    @Transactional
    public List<Student> list() {
        @SuppressWarnings("unchecked")
        List<Student> listProduct = (List<Student>)
            sessionFactory.getCurrentSession().createCriteria(Student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        return listProduct;
    }
    
    @Transactional
    public Student getStudent(String studentId) {
        @SuppressWarnings("unchecked")
        String hql = "FROM Student F WHERE F.studentId = '"+studentId+"'";;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        Student student = (Student) query.list().get(0); 
        return student;
    }

    @Transactional
	public void insert(Student student) {
    	// Creating Random Student Id. Its just for completing the slow.
    	Random RANDOM = new SecureRandom();
    	String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
        String id = "";
        for (int i=0; i<8; i++)
        {
            int index = (int)(RANDOM.nextDouble()*letters.length());
            id += letters.substring(index, index+1);
        }
        
		// TODO Auto-generated method stub
		//Student student = new Student();
		//student.setName("Amit");
		//student.setStudentEmail("asingh7@albany.edu");
		//student.setStudentId(id);
		//student.setYear(Integer.valueOf(1));
		sessionFactory.getCurrentSession().save(student);
		
	}
    public void insert() {
    	// Creating Random Student Id. Its just for completing the slow.
    	Random RANDOM = new SecureRandom();
    	String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
        String id = "";
        for (int i=0; i<8; i++)
        {
            int index = (int)(RANDOM.nextDouble()*letters.length());
            id += letters.substring(index, index+1);
        }
        
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setName("Amit");
		student.setStudentEmail("asingh7@albany.edu");
		student.setStudentId(id);
		student.setYear(Integer.valueOf(1));
		sessionFactory.getCurrentSession().save(student);
		
	}
}