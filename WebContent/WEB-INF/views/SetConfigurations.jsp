<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SET TIME</h1>
<hr>
<form action="configEdit"> 
<table style="width:30%"> 
  
  <tr>  
  <th style="color:red;">${status}</th>
  </tr> 
  <tr><td></td></tr>
  <tr><td></td></tr>
  <tr><td></td></tr>
  <tr>   
  	<th>Manager Time</th> 
    <td><input type="text" name=manager value=${managerTime}></td>
  </tr> 
  <tr>   
  	<th>Student Time</th> 
    <td><input type="text" name=student value=${studentTime}></td>
  </tr> 
  <tr>
	<td><input type="submit" name="buttonAction" value="Update"></td>
  </tr>
</table>  
</form> 


</body>
</html>