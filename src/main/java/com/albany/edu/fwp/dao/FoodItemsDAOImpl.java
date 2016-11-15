package com.albany.edu.fwp.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.albany.edu.fwp.model.FoodDate;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.MealCourse;
import com.albany.edu.fwp.model.Images;
import com.albany.edu.fwp.model.Student;

public class FoodItemsDAOImpl implements FoodItemsDAO {

    private SessionFactory sessionFactory;
    private QuadInfoDAO quadInfoDAO;
    private MealCourseDAO mealCourseDAO;
    private ImagesDAO imagesDAO;
    private FoodDateDAO foodDateDAO;
 
    public FoodItemsDAOImpl(SessionFactory sessionFactory, QuadInfoDAO quadInfoDAO,
    		MealCourseDAO mealCourseDAO, ImagesDAO imagesDAO,  FoodDateDAO foodDateDAO) {
        this.sessionFactory = sessionFactory;
        this.quadInfoDAO = quadInfoDAO;
        this.mealCourseDAO = mealCourseDAO;
        this.imagesDAO = imagesDAO;
        this.foodDateDAO = foodDateDAO;
    }
    
    
    
    @Transactional
    public List<FoodItems> list() {
        @SuppressWarnings("unchecked")        
        String hql = "FROM FoodItems F WHERE F.isSelectedInMenu = true";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<FoodItems> listFoodItems = (List<FoodItems>) query.list();  
        return listFoodItems;
    }
    @Transactional
    public List<FoodItems> listByQuadId(int quadId) {
        @SuppressWarnings("unchecked")        
        String hql = "FROM FoodItems F WHERE F.quadInfo.quadId = '"+quadId+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<FoodItems> listFoodItems = (List<FoodItems>) query.list();  
        return listFoodItems;
    }
    
    @Transactional
    public FoodItems getFoodItem(String foodItemId) {
        @SuppressWarnings("unchecked")
        String hql = "FROM FoodItems F WHERE F.foodItemId = '"+foodItemId+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        FoodItems foodItem = (FoodItems) query.list().get(0); 
        return foodItem;
    }
    
	  @Transactional
	  public HashMap<String, HashMap<String, List<List<String>>>> getAllFoodItemsMap(String dateInString) {
	      @SuppressWarnings("unchecked")	      
	      String hql = "FROM FoodItems F WHERE F.isSelectedInMenu = true AND F.quadInfo = <quadId> AND F.mealCourse = <mealCourseId>";
	      Query query;	   	      	      
	      HashMap<String, HashMap<String, List<List<String>>>> allFoodItems = new HashMap<String, HashMap<String, List<List<String>>>>();
	      List<QuadInfo> listQuad = quadInfoDAO.list();
	      List<MealCourse> listMealCourse = mealCourseDAO.list();
		  List<FoodDate> listFoodItemsByDate = foodDateDAO.listFoodByDate(dateInString);
		  String foodItemId = "";
		  for (FoodDate foodDate : listFoodItemsByDate){
			  foodItemId = foodDate.getFoodItems().getFoodItemName();
			  System.out.println("+++++FoodByDate+++++++++ "+ foodItemId); 
		  }
	    
	      
	        for (QuadInfo quad : listQuad){
	        	HashMap<String, List<List<String>>> quadFoodItemsPerMealCourseMap = new HashMap<String, List<List<String>>>();	        	
	        	for (MealCourse mealCourse : listMealCourse){
	        		List<List<String>> quadFoodItemsPerMealCourseList = new ArrayList<List<String>>();
	        		List<FoodItems> foodItems = new ArrayList<FoodItems>();
	        		query = sessionFactory.getCurrentSession().createQuery(hql.replaceAll("<quadId>", Integer.toString(quad.getQuadId())).replaceAll("<mealCourseId>", Integer.toString(mealCourse.getMealCourseId())));
	        		foodItems = (List<FoodItems>)query.list();
	        		for (FoodItems foodItem : foodItems){
	        			List<String> foodItemsImageAndCalorie = new ArrayList<String>();
	        			for (FoodDate foodDate : listFoodItemsByDate){
	        				if(foodItem.getFoodItemId()==foodDate.getFoodItems().getFoodItemId()){
	        					foodItemsImageAndCalorie.add(foodItem.getFoodItemName());
	    		        		foodItemsImageAndCalorie.add(imagesDAO.imagePath(foodItem.getImages().getImageId()));
	    		        		foodItemsImageAndCalorie.add(Integer.toString(foodItem.getCalories()));
	    		        		foodItemsImageAndCalorie.add(foodItem.getFoodItemId());
	    	        			System.out.println("------->"+foodItem.getFoodItemName()+ "  "+imagesDAO.imagePath(foodItem.getImages().getImageId()));
	    	        			quadFoodItemsPerMealCourseList.add(foodItemsImageAndCalorie);
	        				}	        				
	        			}		        		
	        		}	        		
	        		quadFoodItemsPerMealCourseMap.put(mealCourse.getMealCourseName(), quadFoodItemsPerMealCourseList);	        		
	        	}
	        	allFoodItems.put(quad.getQuadName(),quadFoodItemsPerMealCourseMap);
	        }	      
	      return allFoodItems; 
	  }
    
    
    
 
    
//    @Transactional
//    public List<FoodItems> getListQuads() {
//        @SuppressWarnings("unchecked")
//        
//        String hql = "SELECT distinct F.quadId FROM FoodItems F WHERE F.isSelectedInMenu = true";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        List<FoodItems> listQuads = (List<FoodItems>) query.list();
//        
//        return listQuads;
//    }    
//    

//    
//    @Transactional
//    public List<FoodItems> getListBreakfastQuad20() {
//        @SuppressWarnings("unchecked")
//        
//        String hql = "SELECT F.foodItemName FROM FoodItems F WHERE F.isSelectedInMenu = true AND F.quadId = 20 AND F.mealCourseId = 111";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        List<FoodItems> listBreakfastQuad20 = (List<FoodItems>) query.list();
//        
//        return listBreakfastQuad20;
//    }
//    
//    @Transactional
//    public List<FoodItems> getListBreakfastQuad30() {
//        @SuppressWarnings("unchecked")
//        
//        String hql = "SELECT F.foodItemName FROM FoodItems F WHERE F.isSelectedInMenu = true AND F.quadId = 30 AND F.mealCourseId = 111";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        List<FoodItems> listBreakfastQuad30 = (List<FoodItems>) query.list();
//        
//        return listBreakfastQuad30;
//    }
//    
//    @Transactional
//    public List<FoodItems> getListBreakfastQuad40() {
//        @SuppressWarnings("unchecked")
//        
//        String hql = "SELECT F.foodItemName FROM FoodItems F WHERE F.isSelectedInMenu = true AND F.quadId = 40 AND F.mealCourseId = 111";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        List<FoodItems> listBreakfastQuad40 = (List<FoodItems>) query.list();
//        
//        return listBreakfastQuad40;
//    }

   
}
