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
<h1>VIEW MEALCOURSES</h1>
<hr>

<form action="mealCourseInfo"> 
<table style="width:30%">  
  <tr>
    <td>MealCourse Id:</td>
    <td><input type="text" name="id"></td>
  </tr>
  <tr>
    <td>MealCourse Name:</td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td><input type="submit" value="Submit"></td>
  </tr>
</table> 
</form> 
<br><br>
<form action="mealCourseEdit"> 
<table style="width:30%">
  <tr>  
  <th style="color:red;">${status}</th>
  </tr> 
  <tr><td></td></tr>
  <tr><td></td></tr>
  <tr><td></td></tr>
  
  <tr>
    <th>MealCourse Id:</th>
	<th>MealCourse Name:</th>
	<th>Check</th>    
  </tr>
  <s:iterator value="mealCourseList" var="myvar" status="stat">
  <tr>
    <td>${myvar[0]}</td>
    <td><input type="text" name=name_${myvar[0]} value=${myvar[1]}></td>
	<td><input type="radio" name="check" value=${myvar[0]}></td>
  </tr> 
  </s:iterator>
  <tr>
    <td><input type="submit" name="buttonAction" value="Delete"></td>
	<td><input type="submit" name="buttonAction" value="Update"></td>
  </tr>
  
</table>  
</form> 


</body>
</html>