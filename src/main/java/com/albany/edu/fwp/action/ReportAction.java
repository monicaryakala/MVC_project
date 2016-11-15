/**
 * Report Action class to generate Quad specific reports..
 * FoodWastePrevention. All rights reserved.
 */
package com.albany.edu.fwp.action;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.albany.edu.fwp.dao.FoodItemsDAO;
import com.albany.edu.fwp.dao.FoodSelectedDAO;
import com.albany.edu.fwp.dao.MealCourseDAO;
import com.albany.edu.fwp.dao.QuadInfoDAO;
import com.albany.edu.fwp.dao.StudentDAO;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.FoodSelected;
import com.albany.edu.fwp.model.MealCourse;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class ReportAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	//private Connection connection;
    private FoodItemsDAO foodItemsDAO;
    private QuadInfoDAO quadInfoDAO;
    private MealCourseDAO mealCourseDAO;
    private StudentDAO studentDAO;
    private FoodSelectedDAO foodSelectedDAO;
    private List<FoodItems> listFoodItems;
    private List<QuadInfo> listQuad;
    private List<MealCourse> listMealCourse;
    private List<String> quadNames;
    private List<String> mealCourseNames;
    private Student student;
    private FoodItems foodItems;
    private MealCourse mealCourse;
    private HashMap<String, HashMap<String, List<List<String>>>> allFoodItems;
    private HashMap<String, List<List<String>>> selectedFoodItemsPerMealCourseMap;
 
    public void setFoodItemsDAO(FoodItemsDAO foodItemsDAO) {
		this.foodItemsDAO = foodItemsDAO;
	}
    public void setQuadInfoDAO(QuadInfoDAO quadInfoDAO) {
		this.quadInfoDAO = quadInfoDAO;
	}
    public void setMealCourseDAO(MealCourseDAO mealCourseDAO) {
		this.mealCourseDAO = mealCourseDAO;
	}
    public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
    public void setFoodSelectedDAO(FoodSelectedDAO foodSelectedDAO) {
		this.foodSelectedDAO = foodSelectedDAO;
	}
//    public void setConnection(Connection connection) {
//		this.connection = connection;
//	}
 
    public String execute() {
    	System.out.println("----> Inside Report Action.");
    	Connection connection = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fwp", "root", "test123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String jasperFile = ServletActionContext.getServletContext().getRealPath("/")+"report-src/report4.jasper";
		String pdfFile = ServletActionContext.getServletContext().getRealPath("/")+"report-out/report.pdf";
		System.out.println("------>"+pdfFile);

		// params used for passing the parameter.
		Map<String, Object> params = new HashMap<String,Object>();

//		Integer quadId = (Integer) session.getAttribute("quadID");
		params.put("quad_id", 20);

		try {
			JasperPrint print = JasperFillManager.fillReport(jasperFile, params, connection);
			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,pdfFile);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			System.out.println("Created file: " + pdfFile);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return SUCCESS;
    }

	public List<String> getQuadNames() {
		  return quadNames;
	}
	
	public List<String> getMealCourseNames() {
		  return mealCourseNames;
	}
	
    public HashMap<String, HashMap<String, List<List<String>>>> getAllFoodItems() {
          return allFoodItems;
    }
    
    public HashMap<String, List<List<String>>> getSelectedFoodItemsPerMealCourseMap() {
        return selectedFoodItemsPerMealCourseMap;
    }
}