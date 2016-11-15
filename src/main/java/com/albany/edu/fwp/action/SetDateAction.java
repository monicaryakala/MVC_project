/**
 * Feedback Action class to email feedback
 * FoodWastePrevention. All rights reserved.
 */
package com.albany.edu.fwp.action; 


import java.util.Properties;

import org.apache.struts2.ServletActionContext;

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


 
public class SetDateAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession httpSession;
	
    public String execute() {
    	
    	String date; 	
        
    	request = ServletActionContext.getRequest();
    	httpSession=request.getSession(false); 
    	date = request.getParameter("date").toString();
    	httpSession.setAttribute("date", date);
    	
        return SUCCESS;
    }
    
    

	
}