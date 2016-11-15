package com.albany.edu.fwp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.FoodSelected;
import com.albany.edu.fwp.model.Student;


public class FoodSelectedDAOImpl implements FoodSelectedDAO {
	
	private SessionFactory sessionFactory;
	 
    public FoodSelectedDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
	public void insertFoodSelected(int Num_Plates, FoodItems foodItems,
			Student student, String DateTime) {
    	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
    	
    	FoodSelected foodSelected = new FoodSelected();
    	//foodSelected.setSelectionId(1);
    	foodSelected.setNumberOfPlates(Num_Plates);
    	foodSelected.setStudent(student);
    	foodSelected.setFoodItems(foodItems);
    	try {
			foodSelected.setSubmitDateTime(dmyFormat.parse(DateTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	sessionFactory.getCurrentSession().save(foodSelected);		
	}
    
    @Transactional
    public List<FoodSelected> listFoodSelected(Student student, String dateTime) {
        @SuppressWarnings("unchecked")
        String hql = "FROM FoodSelected F WHERE F.submitDateTime = '"+dateTime+"' AND F.student.studentId = '"+student.getStudentId()+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<FoodSelected> listFoodSelected = (List<FoodSelected>) query.list();  
        return listFoodSelected;
    }
    
    @Transactional
    public void deleteStudentSelection(Student student, String dateTime) {
        @SuppressWarnings("unchecked")
        String hql = "DELETE FoodSelected F WHERE F.submitDateTime = '"+dateTime+"' AND F.student.studentId = '"+student.getStudentId()+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Transactional
    public List<FoodSelected> fetchReportData() {
        @SuppressWarnings("unchecked")
        // Needs to be updated for date.today
        String hql = "FROM FoodSelected F WHERE F.submitDateTime = '2016-11-16'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<FoodSelected> fetchReportData = (List<FoodSelected>) query.list();  
        return fetchReportData;
    }

}
