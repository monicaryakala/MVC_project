/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.action;

import java.io.File;

import com.albany.edu.fwp.dao.ManagerInfoDAO;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.*;

public class LoginAction extends ActionSupport{
	private String sessionUID;
	private String sessionPassword;
	private String redirection;
	private String newPassword;
	private String confirmNewPassword;
	private String type;
	private String err;
	private HttpServletRequest request;
	private HttpSession session;
	private ManagerInfoDAO managerInfoDAO;
	
	//Remove this///
	
	private  String xmlfile;
	
	public void setManagerInfoDAO(ManagerInfoDAO managerInfoDAO) {
	    this.managerInfoDAO = managerInfoDAO;
	}
	
    public String execute() { 
    	xmlfile=ServletActionContext.getServletContext().getRealPath("/")+"xml/login.xml";
    	return SUCCESS;
    	
    }
    
    public String matchUIDandPassword(){
    	this.err="";
    	NodeList loginList=null;
	    try
	    {
	    	xmlfile=ServletActionContext.getServletContext().getRealPath("/")+"xml/login.xml";    
	    	type="Student";
	    	request = ServletActionContext.getRequest(); 
	    	sessionUID=request.getParameter("sessionUID").toString();
	    	sessionPassword=request.getParameter("sessionPassword").toString();	    	
	    	type=request.getParameter("type").toString();
	    	System.out.println(ServletActionContext.getServletContext().getRealPath("/")+"xml/login.xml");
	    	System.out.println("Form Data----->"+request.getParameterMap().values());
	    	
	    	System.out.println("--->"+xmlfile);
	    	File loginFile = new File(xmlfile);
	    	DocumentBuilderFactory logindbf = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder logindb = logindbf.newDocumentBuilder();
	    	Document loginDocument = logindb.parse(loginFile);
	    	loginDocument.getDocumentElement().normalize();
	    	loginList=loginDocument.getElementsByTagName(type);
    	}
    	catch (Exception e){		
    		e.printStackTrace();
    	}
    	for(int i=0;i<loginList.getLength();i++)
    	{
    		Node loginnode=loginList.item(i);
    		if(loginnode.getNodeType()==loginnode.ELEMENT_NODE)
    		{
    			Element user=(Element) loginnode;    			
    			if(sessionUID.toLowerCase().equals(user.getElementsByTagName("UserName").item(0).getTextContent().toLowerCase()))
    				if(sessionPassword.equals(user.getElementsByTagName("Password").item(0).getTextContent()))
    				{
    					this.redirection=type.toLowerCase()+"success";
    					HttpSession session = ServletActionContext.getRequest().getSession();
    					session.setAttribute(type.toLowerCase()+"Id", sessionUID);
    					
    					if(type.toLowerCase().equalsIgnoreCase("manager"))
    					{
    						//request.setAttribute("QuadID", managerInfoDAO.getManagerQuad(sessionUID).get(0));
    						session.setAttribute("quadID", managerInfoDAO.getManagerQuad(sessionUID).get(0));
    					}
    						
    					if("Y".equalsIgnoreCase(user.getElementsByTagName("FirstTimeUser").item(0).getTextContent()))
    						return "newuserredirection";
    					else
    						return redirection;
    				}
    				else
    				{
    					this.err="Invalid Username or Password";
    					return "errorpage";
    				}
    		}
    		
    	}
    	this.err="Invalid Username or Password";
		return "errorpage";
    }
    
    public void decryptPassword()
    {
    	
    }
    
    public String changePassword()
    {
    	return SUCCESS;
    }
    
    public String newPassword()
    {   
    	this.err="";
    	request = ServletActionContext.getRequest(); 
    	System.out.println("Form Data----->"+request.getParameterMap().values());
    	newPassword=request.getParameter("newPassword").toString();
    	confirmNewPassword=request.getParameter("confirmNewPassword").toString();
    	if(newPassword.equals(confirmNewPassword))
    		if(newPassword.length()<8||newPassword.matches("[a-z]") || newPassword.matches("[A-Z]")|| newPassword.matches("[0-9]"))
    		{
    			this.err="Password must be contain 8 or more characters and should be combination of atleast one uppercase letter, one lowercase letter and one number";
    			return "errorpage";
    		}
    		else
    		{
    	    	NodeList loginList=null;
    		    try
    		    {
    		    	System.out.println("--->"+xmlfile);
    		    	File loginFile = new File(xmlfile);
    		    	DocumentBuilderFactory logindbf = DocumentBuilderFactory.newInstance();
    		    	DocumentBuilder logindb = logindbf.newDocumentBuilder();
    		    	Document loginDocument = logindb.parse(loginFile);
    		    	loginDocument.getDocumentElement().normalize();
    		    	loginList=loginDocument.getElementsByTagName(type);

    		   	for(int i=0;i<loginList.getLength();i++)
    	    	{
    	    		Node loginnode=loginList.item(i);
    	    		if(loginnode.getNodeType()==loginnode.ELEMENT_NODE)
    	    		{
    	    			Element user=(Element) loginnode;    			
    	    			if(sessionUID.toLowerCase().equals(user.getElementsByTagName("UserName").item(0).getTextContent().toLowerCase()))
    	    			{
    	    				user.getElementsByTagName("Password").item(0).setTextContent(newPassword);
    	    				user.getElementsByTagName("FirstTimeUser").item(0).setTextContent("N");
    	    				TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	    	            Transformer transformer = transformerFactory.newTransformer();
    	    	            DOMSource source = new DOMSource(loginDocument);
    	    	            StreamResult result = new StreamResult(new File(xmlfile));
    	    	            transformer.transform(source, result);
    	    			}	
    	    		}
    	    	}
    	    	}
    	    	catch (Exception e){		
    	    		e.printStackTrace();
    	    	}
    		    return redirection;
    	}
    	else
    	{
    		return "errorpage";
    	}
    	//set new user to N
    	//replace password
    }
    
   
    public void setRedirection(String redirection)
    {
    	this.redirection=redirection;
    }
    public String getRedirection()
    {
    	return this.redirection;
    }
   
	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}
}