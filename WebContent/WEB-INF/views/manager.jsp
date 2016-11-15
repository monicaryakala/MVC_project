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

    <title>Manager - Welcome Quad Manager</title>
    
    <!-- Date Picker CSS -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <!-- Bootstrap Core CSS -->
    <link href="/foodwasteprevention/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="/foodwasteprevention/resources/css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/foodwasteprevention/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Droppable CSS -->
    <link rel="stylesheet" href="/foodwasteprevention/resources/css/foodItem.css" />

    <link href="/foodwasteprevention/resources/css/media.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style> table{font-size: 23px} </style>
</head>

<body id="page-top" class="index" onLoad="addToCatalog('${foodItemIdList}', '${foodItemNameList}', '${foodItemMealCourseList}', '${foodItemImagePathList}');">

<nav style="position:fixed;top:105px;box-shadow: 10px 10px 5px #888888;background-color:#18bc9c;padding:4px">
 	<h5 style="margin-left:1em">Menu Creation Deadline</h5>
 	<div id="counter"> </div>
</nav>

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">Manager</a>
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
                        <a href="#portfolio">Create Food Menu</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">Cumulative Report</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Contact Admin</a>
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

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Cook to Order</h2>
                    <h2>${quadName}</h2>
                    <hr class="star-primary">
                </div>
            </div>
            
            	<div class="row">
				<div class="col-lg-12 text-right">
					<form id="dateSelector" action="setDatemanager">
						<p>Date: <input type="text" name="date" id="datepicker" onchange="dateSet()"></p>
					</form>
				</div>
			</div>
            
            <div class="row">				
			
            <div id="container">
                <div class="food-list food-container" id="catalog">
                    <h3>Catalog</h3>                    
                     <!--<s:iterator value="foodList" var="myvar" status="stat">
	                     <div class="menu-item ui-draggable" id=food-id${myvar[0]} style="position: relative;">
							<div style="display: none;"><input type="text" name=foodItemId${myvar[0]} value=${myvar[0]}></div>
							 <div class="food-header">${myvar[1]}</div>
							 <div class="meal-typelabel label-default">${myvar[3]}</div>
						 </div>
					  </s:iterator>		-->			  
					  
                </div>
				<form id="selected" action="manager">
                <div class="food-list food-container" id="menu">
                
                 <h3>Menu</h3>
                 
                </div>
                </form>

                <div class="food-list">
                    <h3>Add a food item</h3>
                    <form id="foodItem-form">
                        <input type="text" id="foodText" class="form-control" placeholder="Name of food item"/>
                        <input id="foodImage" class="form-control" name="foodImage" type="file" style="height: 25%; !important">
						<select  id="foodMeal" name="meal-type" class="form-control" style="margin-left: 25px; width: 83%; !important" required>
						  <option value="">Select Meal</option>
						  <option value="Breakfast">Breakfast</option>
						  <option value="Lunch">Lunch</option>
						  <option value="Dinner">Dinner</option>
						</select>
						
                        <input type="button" class="btn btn-primary" value="Add item" onclick="validationFunction();" />
                    </form>                    
                    
                    <div id="delete-div">
                        Drag Here to Delete
                    </div>
                </div>

                <div style="clear:both;"></div>
            </div>
           <br/>
			<p id="errorMessage" style="text-align: center; max-width: 293px; margin: 0 427px; margin-top: 10px"></p>
			<input type="button" value="Create Menu" onclick="valuesfunction();" class="btn btn-lg btn-block btn-warning" style="max-width: 293px; margin: 0 427px; margin-top: 10px">
            </div>
    </div>
    </section>

    <!-- About Section -->
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Cumulative Report</h2>
                    <hr class="star-light">
					  
					  <table class="table table-responsive">
					    <thead>
					      <tr>
					        <th style="text-align: center">Food Item</th>
					        <th style="text-align: center">Meal Course</th>
					        <th style="text-align: center">Number of Pans</th>
					      </tr>
					    </thead>
					    <tbody>
		                    <s:iterator value="reportData" var="myvar" status="stat">
		                   		<tr>
			                    	<td>${myvar[0]}</td>
									<td>${myvar[1]}</td>
									<td>${myvar[2]}</td>
								</tr>					  
							</s:iterator>
						</tbody>
						</table>
                </div>
            </div>
        </div>
    </section>

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>What Students Are Saying</h2>
                    <hr class="star-primary">
                </div>
            </div>
 	        <div class="row">
                <s:iterator value="feedbackString" var="fbString" status="stat">
	            	<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">	
		            	<blockquote class="oval-quotes"><p><s:property value="fbString" /></p></blockquote>
		            </div>
				</s:iterator>
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
    
    <!-- jQuery -->
    <script src="/foodwasteprevention/resources/jquery/jquery.min.js"></script>
    <script src="/foodwasteprevention/resources/jquery/jquery.ui.min.js"></script>
	<!-- Date Picker -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/foodwasteprevention/resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="/foodwasteprevention/resources/js/jqBootstrapValidation.js"></script>
    <script src="/foodwasteprevention/resources/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="/foodwasteprevention/resources/js/freelancer.js"></script>

    <!-- Droppable JavaScript -->
    <script src="/foodwasteprevention/resources/js/foodItem.js"></script>

    <script src="/foodwasteprevention/resources/js/jquery.countdown.js"></script>

    <script type="text/javascript">
    
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
	var foodItemId = "";
	window.addEventListener('beforeunload', function(event) {
        console.log('I am the 1st one.');
      });
	  
      window.addEventListener('unload', function(event) {
        console.log('I am the 3rd one.');
		//alert('unload')
			var entries = foodItemId.split(",");
			for(var i=0; i < entries.length; i++){
				var tokens = entries[i].replace("[","").replace(["]"],"").replace(" ","");
				//foodItem.add(tokens);
				//alert("add " + tokens)
				foodItem.remove(tokens);
				//alert("remove " + tokens)
			}        
      });
	
    	
	    function validationFunction() {
	        var fI = $("#foodImage").val();
	        var fM = document.getElementById("foodMeal");
	        var fT = $("#foodText").val();

	        if (jQuery.trim(fT).length == 0) {
	            document.getElementById("errorMessage").innerHTML = "<h6>Please enter the name of the food item</h6>";
	        } else if (jQuery.trim(fI).length == 0) {
	            document.getElementById("errorMessage").innerHTML = "<h6>Please upload an image of the food item</h6>";
	        } else if (fM.checkValidity() == false) {
	            document.getElementById("errorMessage").innerHTML = "<h6>Please select the meal type</h6>";
	        } else {
	        	foodItem.add(new Date().getTime());
	        }
	    }
	    
	    function valuesfunction() {
	    	document.forms["selected"].submit();       
	    }
		
		function addToCatalog(foodItemIdTemp, foodItemName, foodItemMeanCourse, foodItemImage) {	
		foodItemId=foodItemIdTemp
		//alert(foodItemMeanCourse)
			var ids = foodItemId.split(",");
			var names = foodItemName.split(",");
			var mealCourses = foodItemMeanCourse.split(",");
			var images = foodItemImage.split(",");
			for(var i=0; i < ids.length; i++){
				var id = ids[i].replace("[","").replace(["]"],"").replace(" ","");
				var name = names[i].replace("[","").replace(["]"],"").replace(" ","");
				var mealCourse = mealCourses[i].replace("[","").replace(["]"],"").replace(" ","");
				var image = images[i].replace("[","").replace(["]"],"").replace(" ","");
				foodItem.addCatalog(id, name, mealCourse, image);
				//alert("add " + tokens)
				//foodItem.remove(tokens);
				//alert("remove " + tokens)
			}        	
	    }
		
		
	  
		$(".food-container").droppable();
        $(".menu-item").draggable({ revert: "valid", revertDuration:200 });
        foodItem.init();
        
        $(".dropdown-menu li h6").click(function(){	  
       		$(".btn:first-child").html($(this).text()+' <span class="caret"></span>');
        });
        
    	$('#counter').countdown({
    	    image: "./resources/img/digits.png",
    	    format: "hh:mm:ss",
    	    endTime: new Date('10/25/16 23:59:59'),
    	    digitWidth: 33.99,
    	    digitHeight: 45
    	  });
    	</script>

</body>

</html>
