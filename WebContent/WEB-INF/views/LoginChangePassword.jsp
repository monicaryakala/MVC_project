<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password - Food Waste Prevention</title>
    <!-- Theme CSS -->
    <link href="/foodwasteprevention/resources/css/login.css" rel="stylesheet">
</head>

<body>
	<label style=" color: #18bc9c; font-family: 'Helvetica Neue', sans-serif; font-size: 26px; font-size: 2.1vw; font-weight: bold; letter-spacing: -1px; line-height: 1; text-align: center;text-shadow: 2px 2px white;">Food Waste Prevention</label>

	<div class="form">
      <ul class="tab-group">
        <li class="tab active"><a href="#login">Reset Password</a></li>
      </ul>
      
      <div class="tab-content">
      
        <div id="login" style="display: block">   
		  <s:property value="%{err}"/>
          <form action="LoginChangePasswordSubmit" method="post">
          
            <div class="field-wrap">
            <!-- <label>
              New Password<span class="req">*</span>
            </label> -->
            
            New Password: <input type="password" name='newPassword' autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <!-- <label>
              Confirm New Password<span class="req">*</span>
            </label> -->
            Confirm New Password: <input type="password" name='confirmNewPassword' autocomplete="off"/>
          </div>
		
          <button class="button button-block">Change Password</button>
          </form>
        </div>

      </div><!-- tab-content -->
      
	</div> <!-- /form -->
</body>
</html>