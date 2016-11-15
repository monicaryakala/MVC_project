package com.albany.edu.fwp.model;

import java.util.HashSet;
import java.util.Set;

public class MealCourse {
    private int mealCourseId;
    private String mealCourseName;   
    
    private Set<FoodItems> foodItems =	new HashSet<FoodItems>(0); 
    
    public int getMealCourseId() {
		return mealCourseId;
	}

	public void setMealCourseId(int mealCourseId) {
		this.mealCourseId = mealCourseId;
	}

	public String getMealCourseName() {
		return mealCourseName;
	}

	public void setMealCourseName(String mealCourseName) {
		this.mealCourseName = mealCourseName;
	}
	
	public Set<FoodItems> getFoodItems() {
        return foodItems;
    }
 
    public void setFoodItems(Set<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }


	

	

	
}
