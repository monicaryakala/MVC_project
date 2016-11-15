<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<style>
body {
    font-family: "Lato", sans-serif;
}
 
.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}
 
.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}
 
.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}
 
.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}
 
#main {
    transition: margin-left .5s;
    padding: 16px;
}
 
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}

.h_iframe1 iframe {position:absolute;top:0;left:0;width:100%; height:calc(100% - 200px);}
.h_iframe2 iframe {position:absolute;bottom:0;right:0;width:100%; height:200px;}
 
 
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
 
<div id="mySidenav" class="sidenav">
  <a href="#" class="closebtn" onclick="closeNav() ">&times;</a>

   <!--href="<s:url action="actionName"/>"-->
  <a href="<s:url action="urlTagAction" />" target="frame1">Manager</a>
  <a href="<s:url action="quadInfo" />" target="frame1" >Quads</a>
  <a href="<s:url action="mealCourseInfo" />" target="frame1" >MealCourses</a>
  <a href="<s:url action="configEdit" />" target="frame1" >Configure Time</a>    
  <a href="<s:url action="uploadaction" />" target="frame1" >Add Student</a>    
</div>
 
<div id="main">
  <h2>System Admin</h2>
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span> 
</div>
 
<div id="h_iframe1">
<iframe name="frame1" src="http://ellar.kissr.com/" width="100%" style="height: 100vh;"></iframe>
</div>

 <!-- <div id="h_iframe2">  -->
<!-- <iframe name="frame2" id="frame2" frameborder="0" width="100%" allowfullscreen></iframe>-->
 <!-- </div> --> 
 
<script type="text/javascript">
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
document.getElementById("h_iframe1").style.marginLeft = "250px";
document.getElementById("frame2").style.marginLeft = "250px";
document.body.style.backgroundColor = "rgba(0,0,0,0.4)";    
}
 
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
document.getElementById("h_iframe1").style.marginLeft = "0";
document.getElementById("frame2").style.marginLeft = "0";
document.body.style.backgroundColor = "white"; 
}
 
function Chemisrty() {
	document.getElementById('frame2').src = 'AddManager.jsp';
}
function Json() {
	document.getElementById('frame2').src = 'ViewQuads.jsp';
}
function Physics() {
	document.getElementById('frame2').src = 'SetConfigurations.jsp';
}

</script>

    
</body>
</html>