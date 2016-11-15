/**
 * Copyright CodeJava.net To Present
 * All rights reserved.
 */
package com.albany.edu.fwp.action;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.model.ManagerInfo;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.dao.ManagerInfoDAO;
import com.opensymphony.xwork2.ActionSupport;
 
public class AdminAction extends ActionSupport {
private HttpServletRequest request;
private String addmanagerID,searchmanagerID;
private String addmanagerName,searchmanagerName;
private String addmanagerEmail,searchmanagerEmail;
private String addmanagerPhone,searchmanagerPhone;
private int addmanagerQuad,searchmanagerQuad;
private ManagerInfoDAO managerInfoDAO;
private QuadInfoDAO quadInfoDAO;
private List<QuadInfo> quadlist;
private ArrayList<Integer> quadName;
private QuadInfo quadInfo;
private List<QuadInfo> quads;
private HashMap<Integer,String> hm=new HashMap<Integer, String>();
private ArrayList<ArrayList<String>> parsesearch;

	public void setManagerInfoDAO(ManagerInfoDAO managerInfoDAO) {
	    this.managerInfoDAO = managerInfoDAO;
	}
	
	public void setQuadInfoDAO(QuadInfoDAO quadInfoDAO) {
	    this.quadInfoDAO = quadInfoDAO;
	}

    public String execute() {
    	//quad list code
    	quads = quadInfoDAO.list();
    	for(QuadInfo q: quads)
    	{
    		hm.put(q.getQuadId(), q.getQuadName());
    	}
    	return SUCCESS;
    }
    
    public String addManager(){
    	
    	request=ServletActionContext.getRequest();
    	
    	if(request.getParameter("addmanagerid")==null)
    		addmanagerID="";
    	else
    		addmanagerID=request.getParameter("addmanagerid").toString();
    	
    	if(request.getParameter("addmanagername")==null)
    		addmanagerName="";
    	else
    		addmanagerName=request.getParameter("addmanagername").toString();
    	
    	if(request.getParameter("addmanageremail")==null)
    		addmanagerEmail="";
    	else
    		addmanagerEmail=request.getParameter("addmanageremail").toString();
    	
    	if(request.getParameter("addmanagerphonenumber")==null)
    		addmanagerPhone="";
    	else
    		addmanagerPhone=request.getParameter("addmanagerphonenumber").toString();

    	if(addmanagerID.isEmpty()||addmanagerName.isEmpty()||addmanagerQuad==-1||addmanagerEmail.isEmpty())
    		request.setAttribute("MESSAGE","Name, manager ID, Email ID and Quad entries are mandatory");
    	else {
    		quadInfo=new QuadInfo();
    		quadInfo.setQuadId(addmanagerQuad);
    		quadInfo.setQuadName(hm.get(addmanagerQuad));
    		managerInfoDAO.insertManagerInfo(addmanagerID, addmanagerName, addmanagerEmail, addmanagerPhone,quadInfo);
    		request.setAttribute("MESSAGE","Manager creation successful"); 
    		String xmlfile=ServletActionContext.getServletContext().getRealPath("/")+"xml/login.xml";
    		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.parse(xmlfile);
				Element root = document.getDocumentElement();				
				Element newManager = document.createElement("Manager");
				Element UserName = document.createElement("UserName");
				UserName.appendChild(document.createTextNode(addmanagerID));
				newManager.appendChild(UserName);
				Element Password = document.createElement("Password");
				Password.appendChild(document.createTextNode("Test12345"));
				newManager.appendChild(Password);
				Element FirstTimeUser = document.createElement("FirstTimeUser");
				FirstTimeUser.appendChild(document.createTextNode("Y"));
				newManager.appendChild(FirstTimeUser);
				root.appendChild(newManager);
				DOMSource source = new DOMSource(document);
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        StreamResult result = new StreamResult(xmlfile);
		        transformer.transform(source, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            }
    	
    	return SUCCESS;
    }
    
    public String searchManagers(){
    	parsesearch = new ArrayList<ArrayList<String>>();
    	request=ServletActionContext.getRequest();
    	if(request.getParameter("searchmanagerid")==null)
    		searchmanagerID="";    
    	else
    		searchmanagerID=request.getParameter("searchmanagerid").toString();
    	
    	if(request.getParameter("searchmanagername")==null)
    		searchmanagerName="";
    	else
    		searchmanagerName=request.getParameter("searchmanagername").toString();

    	if(request.getParameter("searchmanageremail")==null)
    		searchmanagerEmail="";
    	else
    		searchmanagerEmail=request.getParameter("searchmanageremail").toString();

    	if(searchmanagerID.isEmpty()&&searchmanagerName.isEmpty()&&searchmanagerQuad==-1&&searchmanagerEmail.isEmpty())
    		request.setAttribute("SEARCHERRORMESSAGE","Please provide either manager name, id, email or Quad to search");
    	else {
    		quadInfo=new QuadInfo();
    		quadInfo.setQuadId(searchmanagerQuad);
    		quadInfo.setQuadName(hm.get(searchmanagerQuad));
    		List<ManagerInfo> searchresults=managerInfoDAO.searchManagerInfo(searchmanagerID,searchmanagerName, quadInfo, searchmanagerEmail);
    		System.out.println(searchresults.size());
    		if(searchresults.isEmpty())
    			request.setAttribute("SEARCHRESULTSMESSAGE","No results found");
    		else
    		{
    			for(ManagerInfo m: searchresults)
    			{
    				ArrayList<String> temp = new ArrayList<String>(0);
    				temp.add(m.getManagerID());
    				temp.add(m.getManagerName());
    				temp.add(String.valueOf((m.getQuad().getQuadId())));
    				temp.add(m.getManagerEmailID());
    				temp.add(m.getManagerPhoneNumber());
    				parsesearch.add(temp);
    			}
    		}}
    	return SUCCESS;
    }
    
	public Set<Integer> getQuadName() {
		  return hm.keySet();
	}
	
	public void setAddmanagerQuad(int addmanagerQuad){
		this.addmanagerQuad=addmanagerQuad;
	}
	
	public int getAddmanagerQuad(){
		return this.addmanagerQuad;
	}
	
	public ArrayList<ArrayList<String>> getParsesearch(){
		return parsesearch;
	}
	
	public void setSearchmanagerQuad(int searchmanagerQuad){
		this.searchmanagerQuad=searchmanagerQuad;
	}
	
	public int getSearchmanagerQuad(){
		return this.searchmanagerQuad;
	}
}