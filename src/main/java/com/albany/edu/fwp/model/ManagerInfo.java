package com.albany.edu.fwp.model;

import java.io.Serializable;

public class ManagerInfo implements Serializable {

	private String managerID;
	private String managerPhoneNumber;
	private String managerName;	
    private String managerEmailID;    
    private QuadInfo Quad;
 
    public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public String getManagerEmailID() {
		return managerEmailID;
	}

	public void setManagerEmailID(String manager_EmailID) {
		this.managerEmailID = manager_EmailID;
	}

	public String getManagerName() {
        return this.managerName;
    }
 
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

	public QuadInfo getQuad() {
		return Quad;
	}

	public void setQuad(QuadInfo Quad) {
		this.Quad = Quad;
	} 
   
}
