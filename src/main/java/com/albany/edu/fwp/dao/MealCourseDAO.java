package com.albany.edu.fwp.dao;

import java.util.List;

import com.albany.edu.fwp.model.FoodItems;
import com.albany.edu.fwp.model.MealCourse;

public interface MealCourseDAO {
	MealCourse getMealCourse(int mealCourseId);
	List<MealCourse> list();
	void insert(int mealCourseId, String mealCourseName);
	void delete(int mealCourseId, String mealCourseName);
	void update(int mealCourseId, String mealCourseName);
}

