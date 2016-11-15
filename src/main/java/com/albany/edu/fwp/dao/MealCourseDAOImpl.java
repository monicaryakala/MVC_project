package com.albany.edu.fwp.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.MealCourse;
import com.albany.edu.fwp.model.QuadInfo;

public class MealCourseDAOImpl implements MealCourseDAO {

    private SessionFactory sessionFactory;
 
    public MealCourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    public List<MealCourse> list() {
        @SuppressWarnings("unchecked")        
        String hql = "FROM MealCourse";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<MealCourse> listMealCourse = (List<MealCourse>) query.list();  
        return listMealCourse;
    }	
    
    @Transactional
    public MealCourse getMealCourse(int mealCourseId){
    	String hql = "FROM MealCourse F WHERE F.mealCourseId = '"+mealCourseId+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        MealCourse mealCourse = (MealCourse) query.list().get(0); 
        return mealCourse;
    	
    }
    
    @Transactional
	public void insert(int mealCourseId, String mealCourseName){
    	MealCourse mealCourse = new MealCourse();
    	mealCourse.setMealCourseId(mealCourseId);
    	mealCourse.setMealCourseName(mealCourseName);
    	sessionFactory.getCurrentSession().save(mealCourse);	    	
    }
    
    @Transactional
	public void delete(int mealCourseId, String mealCourseName){
    	String hql = "DELETE MealCourse F WHERE F.mealCourseId = '"+mealCourseId+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();   	
    }
    
    @Transactional
    public void update(int mealCourseId, String mealCourseName){
    	String hql = "UPDATE MealCourse F set F.mealCourseName='"+mealCourseName+"' WHERE F.mealCourseId = '"+mealCourseId+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();   	
    }

}
