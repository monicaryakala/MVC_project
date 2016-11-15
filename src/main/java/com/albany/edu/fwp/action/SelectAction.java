package com.albany.edu.fwp.action;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import com.albany.edu.fwp.dao.AesEncryption;
import com.albany.edu.fwp.dao.FoodItemsDAO;
import com.albany.edu.fwp.dao.StudentDAO;
import com.albany.edu.fwp.dao.studentXML;
import com.albany.edu.fwp.model.Student;
//import com.albany.edu.fwp.model.QuadInfo;
//import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionSupport;

import javassist.convert.Transformer;

public class SelectAction extends ActionSupport{
	
	private Student student;
	private AesEncryption aesEncryption;
	private StudentDAO studentdao;
	private String result;
	private String destPath; 
	
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public void setStudent(Student student){
		this.student=student;
	}
	public void setStudentDAO(StudentDAO studentdao){
		this.studentdao=studentdao;
	}
	public void setAesEncryption(AesEncryption aesEncryption){
		this.aesEncryption=aesEncryption;
	}
	

	public String execute() {
		try {
			System.out.println(ServletActionContext.getServletContext().getRealPath("/")+"xml");
			String studentonboarding = ServletActionContext.getServletContext().getRealPath("/")+"xml/studentonboarding.xml"; 
			String login = ServletActionContext.getServletContext().getRealPath("/")+"xml/login.xml"; 
			File fXmlFile = new File(studentonboarding);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			create(login);
			
			Document doc1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(login));
			//aesEncryption.setKey("fwp");
			
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			doc1.getDocumentElement().normalize();
			
			
			NodeList nList = doc.getElementsByTagName("studentid");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("studentid : " + eElement.getAttribute("id"));
					System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Address : " + eElement.getElementsByTagName("address").item(0).getTextContent());
					System.out.println("Year : " + eElement.getElementsByTagName("year").item(0).getTextContent());
					
					//Element dataTag=doc1.getDocumentElement();
					Element user=(Element) doc1.getElementsByTagName("Users").item(0);					
					Element studentTag=doc1.createElement("Student");					
					Element username=doc1.createElement("UserName");					
					username.setTextContent(eElement.getAttribute("id"));
					Element password=doc1.createElement("Password");					
					//aesEncryption.encrypt((eElement.getElementsByTagName("name").item(0).getTextContent()).trim());						
					//password.setTextContent(aesEncryption.getEncryptedString());
					password.setTextContent((eElement.getElementsByTagName("password").item(0).getTextContent()).trim()); //uncomment above 2 lines and comment this line to enable encryption
					Element firstTimeUser=doc1.createElement("FirstTimeUser");					
					firstTimeUser.setTextContent("Y");
					studentTag.appendChild(username);
					studentTag.appendChild(password);
					studentTag.appendChild(firstTimeUser);
					user.appendChild(studentTag);					
					
					
					student.setName(eElement.getElementsByTagName("name").item(0).getTextContent().toString());
					student.setStudentEmail(eElement.getElementsByTagName("address").item(0).getTextContent().toString());
					student.setStudentId(eElement.getAttribute("id"));
					student.setYear(Integer.parseInt((eElement.getElementsByTagName("year").item(0).getTextContent()).toString()));
					studentdao.insert(student);
					result="Onboarding Student xml processed. Students are loaded in Database.";
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
			        javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
			        DOMSource source = new DOMSource(doc1);
			        StreamResult result = new StreamResult(new File(login));
			        transformer.transform(source, result);
				}
			}
		} catch (Exception e) 
		{
					result="Student onboarding xml failed to be processed.";
					e.printStackTrace();
		}
		
		return SUCCESS;
	}

	private void create(String login) throws ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		File f = new File(login);
		System.out.println("---->"+f.exists());
		if(!f.exists()&&!f.isDirectory()){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // root elements
        Document doccreate = docBuilder.newDocument();
        Element rootElement = doccreate.createElement("Users");
        doccreate.appendChild(rootElement);
        
//        Element students = doccreate.createElement("student");
//        rootElement.appendChild(students);
        Element manager = doccreate.createElement("Manager");
        rootElement.appendChild(manager);
        Element admin = doccreate.createElement("Admin");
        rootElement.appendChild(admin);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doccreate);
        StreamResult result = new StreamResult(new File(login));
        transformer.transform(source, result);
		}
		
	}
	public String display() {
		return NONE;
	}
	public String getResult() {
		return result;
	}
}
