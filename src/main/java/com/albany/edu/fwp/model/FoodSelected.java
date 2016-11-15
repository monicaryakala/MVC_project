package com.albany.edu.fwp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FoodSelected {

	private long selectionId;	
    private int numberOfPlates;
    private Date submitDateTime;
    private FoodItems foodItems;
    private Student student;    
    
 
    public long getSelectionId() {
        return selectionId;
    }
 
    public void setSelectionId(long selectionId) {
        this.selectionId = selectionId;
    }
    
   
 
    public int getNumberOfPlates() {
        return numberOfPlates;
    }
 
    public void setNumberOfPlates(int numberOfPlates) {
        this.numberOfPlates = numberOfPlates;
    }
 
    public Date getSubmitDateTime() {
        return submitDateTime;
    }
 
    public void setSubmitDateTime(Date submitDateTime) {
        this.submitDateTime = submitDateTime;
    }
 
    public FoodItems getFoodItems() {
        return foodItems;
    }
 
    public void setFoodItems(FoodItems foodItems) {
        this.foodItems = foodItems;
    }
    
    public Student getStudent() {
        return student;
    }
 
    public void setStudent(Student student) {
        this.student = student;
    }

}
