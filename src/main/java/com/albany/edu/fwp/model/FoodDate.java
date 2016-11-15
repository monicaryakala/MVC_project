package com.albany.edu.fwp.model;

import java.io.Serializable;
import java.util.Date;

public class FoodDate implements Serializable {

	private Date foodDate;
    private FoodItems foodItems;
 
    public Date getFoodDate() {
        return foodDate;
    }
 
    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }
 
    public FoodItems getFoodItems() {
        return foodItems;
    }
 
    public void setFoodItems(FoodItems foodItems) {
        this.foodItems = foodItems;
    }
    
   
}
