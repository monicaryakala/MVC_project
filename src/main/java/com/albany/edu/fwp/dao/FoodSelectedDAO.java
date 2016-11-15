package com.albany.edu.fwp.dao;

import java.util.List;

import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.FoodSelected;
import com.albany.edu.fwp.model.Student;

public interface FoodSelectedDAO {
	
	List<FoodSelected> listFoodSelected(Student student, String dateTime);
	List<FoodSelected> fetchReportData();
	void deleteStudentSelection(Student student, String dateTime);
	void insertFoodSelected(int Num_Plates, FoodItems foodItems, Student student, String DateTime);

}
