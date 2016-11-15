/**
 * Feedback Action class to email feedback
 * FoodWastePrevention. All rights reserved.
 */
package com.albany.edu.fwp.action; 


import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.albany.edu.fwp.dao.FeedBackDAO;
import com.albany.edu.fwp.dao.MealCourseDAO;
import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.dao.StudentDAO;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionSupport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


 
public class FeedBackAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession httpSession;
	private QuadInfoDAO quadInfoDAO;
	private FeedBackDAO feedBackDAO;
	private StudentDAO studentDAO;
	private Student student;
	private QuadInfo quadInfo;
	
	public void setQuadInfoDAO(QuadInfoDAO quadInfoDAO) {
		this.quadInfoDAO = quadInfoDAO;
	}
    public void setFeedBackDAO(FeedBackDAO feedBackDAO) {
		this.feedBackDAO = feedBackDAO;
	}
    public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
    public String execute() {
    	
    	
        String quadId;
        String msg;
        String studentId;
        
    	request = ServletActionContext.getRequest();
    	httpSession=request.getSession(false); 
    	
    	quadId=request.getParameter("quadId").toString();     	
    	msg=request.getParameter("msg").toString();
    	studentId=httpSession.getAttribute("studentId").toString();
         try {  
        	 student = studentDAO.getStudent(studentId);
        	 quadInfo=quadInfoDAO.getQuadInfo(Integer.parseInt(quadId));
        	 feedBackDAO.insert(msg, quadInfo, student);
        	 System.out.println("message sent successfully");  
          
         } 
         catch (Exception e) 
         {
        	 
        	 httpSession.setAttribute("emailStatus", "Feedback Not Sent");  
        	 return "error";
         }  
          
         httpSession.setAttribute("emailStatus", "Feedback Sent Successfully.");
        return SUCCESS;
    }
    
    

	
}