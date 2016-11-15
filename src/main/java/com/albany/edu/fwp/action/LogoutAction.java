/**
 * Report Action class to generate Quad specific reports..
 * FoodWastePrevention. All rights reserved.
 */
package com.albany.edu.fwp.action;
 


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


 
public class LogoutAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	
    public String execute() {
    	session = ServletActionContext.getRequest().getSession(false);
    	session.invalidate();
        return SUCCESS;
    }

	
}