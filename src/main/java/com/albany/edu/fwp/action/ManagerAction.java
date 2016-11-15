/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.action;
 
import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;


import com.albany.edu.fwp.dao.FoodDateDAO;

import com.albany.edu.fwp.dao.FeedBackDAO;

import com.albany.edu.fwp.dao.FoodItemsDAO;
import com.albany.edu.fwp.dao.FoodSelectedDAO;
import com.albany.edu.fwp.dao.ImagesDAO;
import com.albany.edu.fwp.dao.MealCourseDAO;
import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.dao.StudentDAO;
import com.albany.edu.fwp.model.FeedBack;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.FoodSelected;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionSupport;
 
public class ManagerAction extends ActionSupport {
    private FoodItemsDAO foodItemsDAO; 
    private ImagesDAO imagesDAO;
    private MealCourseDAO mealCourseDAO;
    private QuadInfoDAO quadInfoDAO;
    private FoodSelectedDAO foodSelectedDAO;
    private FeedBackDAO feedBackDAO;
    private HttpSession session;
    private List<List<String>> foodList;
    private List<String> foodItemIdList;
    private List<String> foodItemNameList;
    private List<String> foodItemMealCourseList;

    private List<String> foodItemImagePathList;    
	private String quadName;
    private HttpServletRequest request;
    private FoodDateDAO foodDateDAO;
	
    public FoodDateDAO getFoodDateDAO() {
		return foodDateDAO;
	}
	public void setFoodDateDAO(FoodDateDAO foodDateDAO) {
		this.foodDateDAO = foodDateDAO;
	}

   
    private List<String> feedbackString;
    private List<List<String>> reportData;
    

    public void setFoodItemsDAO(FoodItemsDAO foodItemsDAO) {
        this.foodItemsDAO = foodItemsDAO;
    }
    public void setImagesDAO(ImagesDAO imagesDAO) {
        this.imagesDAO = imagesDAO;
    }
    public void setMealCourseDAO(MealCourseDAO mealCourseDAO) {
        this.mealCourseDAO = mealCourseDAO;
    }
    public void setQuadInfoDAO(QuadInfoDAO quadInfoDAO) {
        this.quadInfoDAO = quadInfoDAO;
    }
    public void setFoodSelectedDAO(FoodSelectedDAO foodSelectedDAO) {
        this.foodSelectedDAO = foodSelectedDAO;
    }
    public void setFeedBackDAO(FeedBackDAO feedBackDAO) {
        this.feedBackDAO = feedBackDAO;
    }

    public String execute() {
    	
    	try
   	    {	  	
   	    	
    		   
   	   
        
    	session = ServletActionContext.getRequest().getSession();
    	//session.setAttribute("quadID", 10);
    	if(session.getAttribute("quadID")==null){    		
    		return "logout";
    	}
    	

    	 request = ServletActionContext.getRequest();   
       	 String dateString="";
       	 if(session.getAttribute("date")==null){ 
     		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
     		Date date = new Date();
     		Calendar c = Calendar.getInstance();
     		try {
    				c.setTime(dmyFormat.parse(date.toString()));
    			} catch (ParseException e) {
    				e.printStackTrace();
    			}
     		c.add(Calendar.DATE, 1);
     		session.setAttribute("date", dmyFormat.format(c.getTime()).toString());
     		dateString=session.getAttribute("date").toString();
       	 }
       	 else{
     		dateString=session.getAttribute("date").toString();
       	 }
       	 
       	 if( !(request.getParameterMap().isEmpty())){
        		Map<String, String[]> map = request.getParameterMap();
     		Iterator<Entry<String,String[]>> iterator = map.entrySet().iterator();
     		while (iterator.hasNext()) {
     			Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>) iterator.next();
     			System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue()[0]);
     			System.out.println(dateString);
     			System.out.println("hi");
     			FoodItems foodItems= foodItemsDAO.getFoodItem(entry.getValue()[0]);
     			foodDateDAO.insertFoodSelected(foodItems, dateString);
     			//foodItems=foodItemsDAO.getFoodItem(entry.getKey());
     			//foodSelectedDAO.insertFoodSelected(Integer.parseInt(entry.getValue()[0]), foodItems, student, dateString);
     			//foodSelectedDAO.insertFoodSelected(Integer.parseInt(entry.getValue()[0]), foodItems, student, dateFormat.format(date).toString());
     		}
       	 }
     		else
     		{

    	
    	int quadId=Integer.parseInt(session.getAttribute("quadID").toString());
    	quadName=quadInfoDAO.getQuadInfo(quadId).getQuadName();
    	List <FoodItems> foodItems = foodItemsDAO.listByQuadId(quadId);
    	foodList = new ArrayList<List<String>>();
    	foodItemIdList = new ArrayList<String>();
    	foodItemNameList = new ArrayList<String>();
    	foodItemMealCourseList = new ArrayList<String>();
    	foodItemImagePathList = new ArrayList<String>();
    	for (FoodItems foodItem : foodItems){
    		foodItemIdList.add(foodItem.getFoodItemId());
    		foodItemNameList.add(foodItem.getFoodItemName());
    		foodItemMealCourseList.add(mealCourseDAO.getMealCourse(foodItem.getMealCourse().getMealCourseId()).getMealCourseName());
    		foodItemImagePathList.add(imagesDAO.imagePath(foodItem.getImages().getImageId()));
    		List<String> foodItemDetails = new ArrayList();    		
    		foodItemDetails.add(foodItem.getFoodItemId());
    		foodItemDetails.add(foodItem.getFoodItemName());
    		foodItemDetails.add(imagesDAO.imagePath(foodItem.getImages().getImageId()));
    		foodItemDetails.add(mealCourseDAO.getMealCourse(foodItem.getMealCourse().getMealCourseId()).getMealCourseName()); 
    		foodItemDetails.add(Integer.toString(foodItem.getRelativeServingPlates()));
    		foodItemDetails.add(Integer.toString(foodItem.getCalories()));
    		foodList.add(foodItemDetails);
    	}

    	}
   	    }
    	catch (Exception e){		
       		e.printStackTrace();
       	}
    	  	
    	   	
        return SUCCESS;
    }
    /*public String insertdateid(){
    	try
   	    {	  	
   	    	
    		   
   	    request = ServletActionContext.getRequest();   
   	 String dateString="";
   	 if(session.getAttribute("date")==null){ 
 		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
 		Date date = new Date();
 		Calendar c = Calendar.getInstance();
 		try {
				c.setTime(dmyFormat.parse(date.toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
 		c.add(Calendar.DATE, 1);
 		session.setAttribute("date", dmyFormat.format(c.getTime()).toString());
 		dateString=session.getAttribute("date").toString();
   	 }
   	 else{
 		dateString=session.getAttribute("date").toString();
   	 }
 	
   	 if( !(request.getParameterMap().isEmpty())){
   		Map<String, String[]> map = request.getParameterMap();
		Iterator<Entry<String,String[]>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>) iterator.next();
			System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue()[0]);
			System.out.println(dateString);
			FoodItems foodItems= foodItemsDAO.getFoodItem(entry.getValue()[0]);
			fooddateDAO.insertFoodSelected(foodItems, dateString);
			//foodItems=foodItemsDAO.getFoodItem(entry.getKey());
			//foodSelectedDAO.insertFoodSelected(Integer.parseInt(entry.getValue()[0]), foodItems, student, dateString);
			//foodSelectedDAO.insertFoodSelected(Integer.parseInt(entry.getValue()[0]), foodItems, student, dateFormat.format(date).toString());
		}
   	 }
   	    
   	    	
   	      	    	
       	}
       	catch (Exception e){		
       		e.printStackTrace();
       	}
    	return "edit";
    }*/
	/*public List<List<String>> getFoodList() {

    	//Getting the feedback for Quad ID = 10
    	//Needs to be updated to get from session
    	List<FeedBack> feedBackText = feedBackDAO.getFeedback(10);    	
    	List<FoodSelected> fetchReportData = foodSelectedDAO.fetchReportData();
    	
    	reportData = new ArrayList<List<String>>();
    	for (FoodSelected foodSelected : fetchReportData){
    		List<String> eachRow = new ArrayList();
    		eachRow.add(foodItemsDAO.getFoodItem(foodSelected.getFoodItems().getFoodItemId()).getFoodItemName());
    		eachRow.add(mealCourseDAO.getMealCourse(foodItemsDAO.getFoodItem(foodSelected.getFoodItems().getFoodItemId()).getMealCourse().getMealCourseId()).getMealCourseName());
    		
    		Integer totalPlates = 0;
    		Integer relativePlates = 0;
    		
    		relativePlates = foodItemsDAO.getFoodItem(foodSelected.getFoodItems().getFoodItemId()).getRelativeServingPlates();
    		totalPlates += foodSelected.getNumberOfPlates();
    		eachRow.add(Integer.toString(totalPlates/relativePlates));
    		reportData.add(eachRow);
    	}
    	
    	feedbackString = new ArrayList<String>();
    	for (FeedBack feedBack : feedBackText){
    		feedbackString.add(feedBack.getDescription());
    	}
    	
        return SUCCESS;
    }*/

	public List<String> getFeedbackString() {
		return feedbackString;
	}
    public List<List<String>> getReportData() {
		return reportData;
	}
    public List<List<String>> getFoodList() {

		return foodList;
	}
	public List<String> getFoodItemIdList() {
		return foodItemIdList;
	}
	public List<String> getFoodItemNameList() {
		return foodItemNameList;
	}	
	public List<String> getFoodItemMealCourseList() {
		return foodItemMealCourseList;
	}
	public List<String> getFoodItemImagePathList() {
		return foodItemImagePathList;
	}
	public String getQuadName() {
		return quadName;
	}
}