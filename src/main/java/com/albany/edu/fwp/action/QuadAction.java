/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.action;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import com.albany.edu.fwp.dao.MealCourseDAO;
import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class QuadAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
    private QuadInfoDAO quadInfoDAO;
    private MealCourseDAO mealCourseDAO;
    private QuadInfo quadInfo;
    private List<List<String>> quadList;
    private String status;
 
    
    public void setQuadInfoDAO(QuadInfoDAO quadInfoDAO) {
		this.quadInfoDAO = quadInfoDAO;
	}
    public void setMealCourseDAO(MealCourseDAO mealCourseDAO) {
		this.mealCourseDAO = mealCourseDAO;
	}
 
    public String execute() {  
    	status="";
    	request = ServletActionContext.getRequest();
    	if(request.getParameter("id")!=null){ 
    		int id =Integer.parseInt(request.getParameter("id").toString());
    		String name = request.getParameter("name").toString();
    		quadInfoDAO.insert(id, name);
    	}
    	if(request.getParameter("check")!=null){ 
    		int id =Integer.parseInt(request.getParameter("check").toString());
    		String name = request.getParameter("name_"+id).toString();
    		if(request.getParameter("buttonAction").equals("Delete")){
    			quadInfoDAO.delete(id, name);
    		}
    		if(request.getParameter("buttonAction").equals("Update"))
    		{
    			try{
    				quadInfoDAO.update(id, name);
        			status="Update Successful.";
        			}catch(Exception e){
        				status="Error in Update.";
        			}
        	}
    	}
    	List <QuadInfo> quads = quadInfoDAO.list();
    	quadList = new ArrayList<List<String>>();
    	for (QuadInfo quadInfo : quads){
    		List<String> quadDetails = new ArrayList();
    		quadDetails.add(Integer.toString(quadInfo.getQuadId()));
    		quadDetails.add(quadInfo.getQuadName()); 
    		System.out.println("Quad Name :"+quadInfo.getQuadName());
    		quadList.add(quadDetails);
    	}
    	
		return SUCCESS;
	}

	public List<List<String>> getQuadList() {
		  return quadList;
	}
	public String getStatus() {
		return status;
	}
	
	
	
    

}