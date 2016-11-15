package com.albany.edu.fwp.action;



import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException; 
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
   private File myFile;
   private String myFileContentType;
   private String myFileFileName;
   private String destPath;  
   private String err;
   private String result;

   
public String execute()
   {
      /* Copy file to a safe location */
      destPath = ServletActionContext.getServletContext().getRealPath("/")+"xml";
	   //destPath="C:/apache-tomcat-6.0.33/work/";
      

      return SUCCESS;
   }
   public String upload(){
	   try{
	     	 System.out.println("Src File name: " + myFile);
	     	myFileFileName="studentonboarding.xml";
	     	 System.out.println("Dst File name: " + myFileFileName);
	     	System.out.println(destPath);
	     	    	 
	     	 File destFile  = new File(destPath, myFileFileName);
	    	 FileUtils.copyFile(myFile, destFile);
	  
	      }catch(IOException e){
	    	  err="There has been an error in uploading the file.";
	         e.printStackTrace();
	         return ERROR;
	      }
	   //succ="You have successfully uploaded"+myFileFileName+".Now Click Submit to finish submission";
	   return SUCCESS;
   }
   
   public File getMyFile() {
      return myFile;
   }
   public void setMyFile(File myFile) {
      this.myFile = myFile;
   }
   public String getMyFileContentType() {
      return myFileContentType;
   }
   public void setMyFileContentType(String myFileContentType) {
      this.myFileContentType = myFileContentType;
   }
   public String getMyFileFileName() {
      return myFileFileName;
   }
   public void setMyFileFileName(String myFileFileName) {
      this.myFileFileName = myFileFileName;
   }
   public String getErr() {
		return err;
	}
   public void setErr(String err) {
		this.err = err;
	}
 
   public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}

