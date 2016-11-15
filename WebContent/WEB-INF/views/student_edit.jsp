<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>   
<%@taglib  prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Student - Edit Food Selection</title>

	<!-- Date Picker CSS -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
    <!-- Bootstrap Core CSS -->
    <link href="/foodwasteprevention/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="/foodwasteprevention/resources/css/freelancer.css" rel="stylesheet">
    <link href="/foodwasteprevention/resources/css/media.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/foodwasteprevention/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

	<s:if test="%{isDeadlinePassed}">
	</s:if>
	<s:else>
		<nav style="position:fixed;top:105px;box-shadow: 10px 10px 5px #888888;background-color:#18bc9c;padding:4px">
		<h5 style="margin-left:1em">Food Selection Deadline</h5>
		<div id="counter"> </div>
		</nav>
	</s:else>

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">Student</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="logout">Logout</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#portfolio">Order Modification</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">Calories Count</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Questions/Feedback</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="/foodwasteprevention/resources/img/profile.png" alt="">
                    <div class="intro-text">
                        <span class="name">Food Waste Prevention</span>
                        <hr class="star-light">
                        <span class="skills">Stop the Rot - And - Waste Not</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    	  <!-- <s:iterator value="mealCourseNames" var="mealCourseName" status="stat">
	          <s:property value="mealCourseName"  />	          
			   	 <s:iterator value="selectedFoodItemsPerMealCourseMap[#mealCourseName]" var="myvar" status="stat">
			        <s:property value="#myvar[1]" />
			        <s:property value="#myvar[2]" />
			   	 </s:iterator>			   	 		   	 
   	 	 </s:iterator> --> 

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
			<div class="row">
				<div class="col-lg-12 text-right">
					<form id="dateSelector" action="setDate">
						<p>Date: <input type="text" name="date" id="datepicker" onchange="dateSet()"></p>
					</form>
				</div>
			</div>
			<s:if test="%{isDeadlinePassed}">
			<div class="col-lg-12 text-center">
				<h2>Selection Time is Over</h2>                    
				<hr class="star-primary">					
			</div>
			</s:if>
			<s:else>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Time to Eat</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
	            <s:iterator value="mealCourseNames" var="mealCourseName" status="stat">
	             <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3" style="width: 31%;">
		          <h3><s:property value="mealCourseName" /></h3>  
				  <s:if test="%{selectedFoodItemsPerMealCourseMap.containsKey(#mealCourseName)}">
					<s:iterator value="selectedFoodItemsPerMealCourseMap[#mealCourseName]" var="myvar" status="stat">
				   	 	<li class="list-group-item">${myvar[1]} <span class="badge"><s:property value="#myvar[2]" /></span></li>	
						<div style="display: none;">${totCal=totCal+myvar[2]*myvar[3]}</div>
						
					</s:iterator>
			       </s:if>	          	 					
				   <s:else>
						<li class="list-group-item">No Item Selected</li> 
				   </s:else>
				 </div> 				 
	   	 	    </s:iterator>         
            </div>
            <br>
            <input type="edit" value="Edit" class="btn btn-lg btn-block btn-warning" onclick="location.href='student?next=studentpage';" style="max-width: 265px; margin: 0 auto;">
    </s:else>
	</div>	
    </section>


	<s:if test="%{isDeadlinePassed}">
	</s:if>
	<s:else>
<!-- About Section -->
    <!-- About Section -->
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                   <h2>Calories Count</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div id=loadCalorie class="row">
                <h2 class="col-lg-12 text-center">${totCal}</h2>
            </div>
        </div>
    </section>
	</s:else>
    
    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Questions/Feedback</h2>
                    <span class="skills">${status}</span>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
					<form name="sentMessage" action="feedback" id="contactForm" novalidate>
                        
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls"> 								
                                <input STYLE="VISIBILITY: hidden;" type="email" name="email" class="form-control" placeholder="Quad Email" id="email" required data-validation-required-message="Please enter your email address.">
                                <h4>Select Quad</h4>
								<select name="quadId" class="form-control" placeholder="Quad Email" id="email">
								  <s:iterator value="quadList" var="myvar" status="stat">
								  	<option value=${myvar[0]}>${myvar[1]}</option>
								  </s:iterator>
								</select>
								<p class="help-block text-danger"></p>
                            </div>
                        </div>
                        
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <h4>Message</h4>
                                <textarea rows="5" name="msg" class="form-control" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</section>


    <!-- Footer -->
    <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        <h3>Location</h3>
                        <p>Whichever Quad You Like</p>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>Around the Web</h3>
                        <ul class="list-inline">
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-dribbble"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>About Developers</h3>
                        <p>To iterate is human, to recurse divine.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; 2016
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

	<input type="text" STYLE="VISIBILITY: hidden;" name="datetime" id="datetimeval" value=${dateTimeVal}>
    <!-- jQuery -->
    <script src="/foodwasteprevention/resources/jquery/jquery.min.js"></script>
	
	<!-- Date Picker -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/foodwasteprevention/resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="/foodwasteprevention/resources/js/jqBootstrapValidation.js"></script>

    <!-- Theme JavaScript -->
    <script src="/foodwasteprevention/resources/js/freelancer.js"></script>
    <script src="/foodwasteprevention/resources/js/jquery.countdown.js"></script>
    
   
   <script>
   var datetime=$( "#datetimeval" ).val()
   	$('#counter').countdown({
	    image: "./resources/img/digits.png",
	    format: "dd:hh:mm:ss",
	    endTime: new Date(datetime),
	    digitWidth: 33.99,
	    digitHeight: 45
	  });
	  
	  $( function() {
	    $( "#datepicker" ).datepicker();
	  } );
	  
	function dateSet(){	
		var date=$( "#datepicker" ).val();
		var breakup = date.split("/");
		var dateMod = breakup[2]+ "-" + breakup[0]+ "-" + breakup[1];
		document.getElementById("datepicker").value = dateMod;
		document.forms["dateSelector"].submit();
	}  
	</script>

</body>

</html>
