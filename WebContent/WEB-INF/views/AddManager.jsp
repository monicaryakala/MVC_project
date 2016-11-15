<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Managers</title>
</head>
<body>
<h1>ADD MANAGER</h1>
<hr>
<%
String message="";
if(request.getAttribute("MESSAGE")!=null)
{
	message=(String)request.getAttribute("MESSAGE");
}
else
{
	message="";
}
%>
<p><%= message %></p>

<form action="addmanagersubmit" method="post">
<table style="width:30%">  
  <tr>
    <td>* Name:</td>
    <td><input type="managername" name="addmanagername"></td>
  </tr>
  <tr>
    <td>* ManagerID:</td>
    <td><input type="managerid" name="addmanagerid"></td>
  </tr>
  <tr>
    <td>Phone Number:</td>
    <td><input type="managerphonenumber" name="addmanagerphonenumber"></td>
  </tr>
  <tr>
    <td>* Email:</td>
    <td><input type="manageremail" name="addmanageremail"></td>
  </tr>
  <tr>
    <td>* Quad ID:</td>
	<td><s:select name="addmanagerQuad" list="quadName"/></td>
  </tr>
  <tr>
    <td><input type="submit" value="Add"></td>
  </tr>
</table> 
</form>

<hr>
<form action="searchmanagersubmit" method="post">
<h1>SEARCH MANAGER</h1>
<hr>
<%
String smessage="";
if(request.getAttribute("SEARCHERRORMESSAGE")!=null)
{
	smessage=(String)request.getAttribute("SEARCHERRORMESSAGE");
}
else
{
	smessage="";
}
%>
<p><%= smessage %></p>
Name:<input type="text" name="searchmanagername">&nbsp &nbsp
ManagerID:<input type="text" name="searchmanagerid">&nbsp &nbsp
Email ID:<input type="text" name="searchmanageremail">&nbsp &nbsp
Quad ID:<s:select name="searchmanagerQuad" headerKey='-1' headerValue="" list="quadName"/>
&nbsp &nbsp
<input type="submit" value="Search">
<br/><br/>

<table style="width:100%" border="1px solid black">
  <tr>
    <th>Manager ID</th>
    <th>Manager Name</th>
    <th>Quad ID</th>
    <th>Email ID</th>
    <th>Phone Number</th>
  </tr>
 

  <%@ page import="java.util.*" %> 

  <% ArrayList<ArrayList<String>> searchlist=null; %>
    
   <%
   if(request.getAttribute("SEARCHRESULTSMESSAGE")!=null)
   {
	   out.print("<tr><td>"+request.getAttribute("SEARCHRESULTSMESSAGE").toString()+"</td></tr>");
   }
   %>
   
   <s:iterator value="parsesearch" var="var">
	<tr>
	<td><s:property value="#var[0]"/></td>
	<td><s:property value="#var[1]"/></td>
	<td><s:property value="#var[2]"/></td>
	<td><s:property value="#var[3]"/></td>
	<td><s:property value="#var[4]"/></td>
	</tr>
 </s:iterator>
    
</form>
</body>
</html>