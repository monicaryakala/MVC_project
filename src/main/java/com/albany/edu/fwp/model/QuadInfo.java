package com.albany.edu.fwp.model;

import java.util.HashSet;
import java.util.Set;

public class QuadInfo {
    private int quadId;
    private String quadName; 
    private Set<FeedBack> feedBack;
    
    private Set<FoodItems> foodItems =	new HashSet<FoodItems>(0); 
    
    
    public int getQuadId() {
		return quadId;
	}

	public void setQuadId(int quadId) {
		this.quadId = quadId;
	}

	public String getQuadName() {
		return quadName;
	}

	public void setQuadName(String quadName) {
		this.quadName = quadName;
	}
    
    public Set<FoodItems> getFoodItems() {
        return foodItems;
    }
 
    public void setFoodItems(Set<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }

	public Set<FeedBack> getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Set<FeedBack> feedBack) {
		this.feedBack = feedBack;
	}

	

	

	
}
