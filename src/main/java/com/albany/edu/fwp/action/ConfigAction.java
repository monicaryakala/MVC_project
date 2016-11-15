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



import com.albany.edu.fwp.dao.ConfigDAO;
import com.albany.edu.fwp.dao.MealCourseDAO;
import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.model.Config;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class ConfigAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
    private ConfigDAO configDAO;
    private String managerTime;
    private String studentTime;
    private String status;
 
    
    public void setConfigDAO(ConfigDAO configDAO) {
		this.configDAO = configDAO;
	}
 
    public String execute() {   
    	request = ServletActionContext.getRequest();
    	session = ServletActionContext.getRequest().getSession();
        status="";
    	
    	try{
	    	if(!request.getParameterMap().isEmpty()){ 
	    		String managerTime = request.getParameter("manager").toString();
	    		String studentTime = request.getParameter("student").toString();
	    		configDAO.update(1, managerTime, studentTime);
	    		status="Update Successful";
	    	}
	    	List <Config> configs = configDAO.list();
	    	for (Config config : configs){
	    		managerTime=config.getManagerTime();
	    		studentTime=config.getStudentTime();
	    	}
    	}catch(Exception e){
    		status="Error in Update";
    	}
    	
		return SUCCESS;
	}



	public String getManagerTime() {
		return managerTime;
	}

	public String getStudentTime() {
		return studentTime;
	}

	public String getStatus() {
		return status;
	}
	
	
	
    

}