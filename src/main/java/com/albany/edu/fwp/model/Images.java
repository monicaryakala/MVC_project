package com.albany.edu.fwp.model;

import java.util.HashSet;
import java.util.Set;

public class Images {
    private int imageId;
    private String imagePath;   
    
    private Set<FoodItems> foodItems =	new HashSet<FoodItems>(0); 
    
    public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Set<FoodItems> getFoodItems() {
	        return foodItems;
	    }
	 
    public void setFoodItems(Set<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }

	

	
}
