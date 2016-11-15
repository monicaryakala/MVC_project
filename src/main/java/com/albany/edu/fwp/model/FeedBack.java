package com.albany.edu.fwp.model;


public class FeedBack {
	
    private long feedBackId;
    private String description; 
    private QuadInfo quadInfo;
    private Student student;
    
	public long getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(long feedBackId) {
		this.feedBackId = feedBackId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public QuadInfo getQuadInfo() {
		return quadInfo;
	}
	public void setQuadInfo(QuadInfo quadInfo) {
		this.quadInfo = quadInfo;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
