package com.albany.edu.fwp.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import com.albany.edu.fwp.model.FoodItems;

public class studentXMLImpl implements studentXML {
	private List<String> comboMeals= new ArrayList<String>();
	public List<String> list() {

		try {
			File fXmlFile = new File("C:/Users/manish chandra/Documents/student.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("studentid");

			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("studentid : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("address").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("year").item(0).getTextContent());
				
					//comboMeals = new ArrayList<String>();
					comboMeals.add(eElement.getAttribute("id"));
					comboMeals.add(eElement.getElementsByTagName("name").item(0).getTextContent());
					comboMeals.add(eElement.getElementsByTagName("address").item(0).getTextContent());
					comboMeals.add(eElement.getElementsByTagName("year").item(0).getTextContent());
					
					
				}
			}
		} catch (Exception e) {
					e.printStackTrace();
				    }
		return comboMeals;
	}

}
