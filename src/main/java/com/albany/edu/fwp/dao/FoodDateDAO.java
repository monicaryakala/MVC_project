package com.albany.edu.fwp.dao;

import java.util.Date;
import java.util.List;

import com.albany.edu.fwp.model.FoodDate;
import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.Student;

public interface FoodDateDAO {
	
	List<FoodDate> listFoodByDate(String date);
	void insertFoodSelected(FoodItems foodItems, String DateTime);

}
