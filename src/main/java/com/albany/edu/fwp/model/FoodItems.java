package com.albany.edu.fwp.model;

import java.util.HashSet;
import java.util.Set;

public class FoodItems {
    private String foodItemId;
    private String foodItemName;    
    private int relativeAmount;
    private int relativeServingPlates;
    private int calories;
    private boolean isSelectedInMenu;
    private Set<FoodSelected> foodSelections =	new HashSet<FoodSelected>(0);
    private Set<FoodDate> foodByDate =	new HashSet<FoodDate>(0);
    private Images images;
    private QuadInfo quadInfo;
    private MealCourse mealCourse;
    
    
    
    public String getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(String foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	
	public QuadInfo getQuadInfo() {
		return quadInfo;
	}

	public void setQuadInfo(QuadInfo quadInfo) {
		this.quadInfo = quadInfo;
	}

	public int getRelativeAmount() {
		return relativeAmount;
	}

	public void setRelativeAmount(int relativeAmount) {
		this.relativeAmount = relativeAmount;
	}

	public int getRelativeServingPlates() {
		return relativeServingPlates;
	}

	public void setRelativeServingPlates(int relativeServingPlates) {
		this.relativeServingPlates = relativeServingPlates;
	}
	
	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}


	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public MealCourse getMealCourse() {
		return mealCourse;
	}

	public void setMealCourse(MealCourse mealCourse) {
		this.mealCourse = mealCourse;
	}
   
    
    public Set<FoodSelected> getFoodSelections() {
        return foodSelections;
    }
 
    public void setFoodSelections(Set<FoodSelected> foodSelections) {
        this.foodSelections = foodSelections;
    }

	public boolean getIsSelectedInMenu() {
		return isSelectedInMenu;
	}

	public void setIsSelectedInMenu(boolean isSelectedInMenu) {
		this.isSelectedInMenu = isSelectedInMenu;
	}
	
	public Set<FoodDate> getFoodByDate() {
	        return foodByDate;
	}
	 
	public void setFoodByDate(Set<FoodDate> foodByDate) {
	        this.foodByDate = foodByDate;
	}

	

	
}