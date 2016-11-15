<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login - Food Waste Prevention</title>

    <!-- Theme CSS -->
    <link href="/foodwasteprevention/resources/css/login.css" rel="stylesheet">
</head>

<body>
	<label style=" color: #18bc9c; font-family: 'Helvetica Neue', sans-serif; font-size: 26px; font-size: 2.1vw; font-weight: bold; letter-spacing: -1px; line-height: 1; text-align: center;text-shadow: 2px 2px white;">Food Waste Prevention</label>
	<div class="form">
      <ul class="tab-group">
		<!-- <li class="tab active"><a href="#forgot">Sign Up</a></li>
		-->
             <li class="tab active"><a href="#login">Sign in</a></li>
         
      </ul>
      
      <div class="tab-content">
      
        <div id="login">   
		  <s:property value="%{err}"/>
          <form action="loginsubmit" method="post">
          
            <div class="field-wrap">
            <label>
              Net ID<span class="req">*</span>
            </label>
            <input name='sessionUID' autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name='sessionPassword' autocomplete="off"/>
          </div>
		
		<div class="field-wrap">
			<div style="padding:5px">
				<label id="radioLabels">Student</label>
				<input name="type" id="typeStudent" value="Student" type="radio" style="width:57%">
			</div>

			<div style="padding:5px">
				<label id="radioLabels">Manager</label>	
				<input name="type" id="typeManager" value="Manager" type="radio" style="width:57%">
			</div>
			
			<div style="padding:5px">
				<label id="radioLabels">Admin</label>
				<input name="type" id="typeAdmin" value="Admin" type="radio" style="width:57%">
			</div>
		</div>
		
          <p class="tab forgot"><a href="#forgot">Forgot Password?</a></p>
          <button class="button button-block">Log In</button>
          </form>
        </div>

          <div id="forgot">   
          <h1>Enter your email address</h1>
          
          <form action="/" method="post">
          
          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input autocomplete="off"/>
          </div>
          
          
          <button type="submit" class="button button-block"/>Reset Password</button>
          </form>
        </div>

      </div><!-- tab-content -->
      
	</div> <!-- /form -->

    <!-- jQuery -->
    <script src="/foodwasteprevention/resources/jquery/jquery.min.js"></script>

	<script>
		$(document).ready(function(){
		$('.form').find('input, textarea').on('keyup blur focus', function (e) {
		  
		  var $this = $(this),
		      label = $this.prev('label');
		
			  if (e.type === 'keyup') {
					if ($this.val() === '') {
		          label.removeClass('active highlight');
		        } else {
		          label.addClass('active highlight');
		        }
		    } else if (e.type === 'blur') {
		    	if( $this.val() === '' ) {
		    		label.removeClass('active highlight'); 
					} else {
				    label.removeClass('highlight');   
					}   
		    } else if (e.type === 'focus') {
		      
		      if( $this.val() === '' ) {
		    		label.removeClass('highlight'); 
					} 
		      else if( $this.val() !== '' ) {
				    label.addClass('highlight');
					}
		    }
		
		});
		
		$('.tab a').on('click', function (e) {
		  
		  e.preventDefault();
		  
		  $(this).parent().addClass('active');
		  $(this).parent().siblings().removeClass('active');
		  
		  target = $(this).attr('href');
		
		  $('.tab-content > div').not(target).hide();
		  
		  $(target).fadeIn(600);
		  });
		});
	</script>
	
</body>
</html>