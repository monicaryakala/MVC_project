package com.albany.edu.fwp.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Set<FeedBack> feedBack;
    private String studentId;
    private String name;
    private String studentEmail;
    private String password;
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private int year;
    private Set<FoodSelected> foodSelections =	new HashSet<FoodSelected>(0);
    
    
    
 
    public String getStudentId() {
        return studentId;
    }
 
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getStudentEmail() {
        return studentEmail;
    }
 
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
 
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
    
    public Set<FoodSelected> getFoodSelections() {
        return foodSelections;
    }
 
    public void setFoodSelections(Set<FoodSelected> foodSelections) {
        this.foodSelections = foodSelections;
    }

	public Set<FeedBack> getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Set<FeedBack> feedBack) {
		this.feedBack = feedBack;
	}
}