<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring3MVC with Hibernate3 CRUD Example using Annotations</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script type="text/javascript">
    	function timeTest (){
    		$.ajax({
    			url:"getAjaxTime.html",
    			success: function (data){
    				var prev =$("#result").html();
    				$("#result").html(prev+""+data);
    				console.log(prev+""+data);
    			}
    		})
    	}
    	
    $(function(){
    	
    	var listAvailable = ["ActionScript",
    	                     "AppleScript",
    	                     "Asp",
    	                     "BASIC",
    	                     "C",
    	                     "C++",
    	                     "Clojure",
    	                     "COBOL",
    	                     "ColdFusion",
    	                     "Erlang",
    	                     "Fortran",
    	                     "Groovy",
    	                     "Haskell",
    	                     "Java",
    	                     "JavaScript",
    	                     "Lisp",
    	                     "Perl",
    	                     "PHP",
    	                     "Python",
    	                     "Ruby",
    	                     "Scala",
    	                     "Scheme"
		];
    	
    	$("#listOfEmp").autocomplete({
    		source:listAvailable
    	});
    });
    	
    </script>
  </head>
  <body>
    <h2>Spring3MVC with Hibernate3 CRUD Example using Annotations</h2>
    <h2>1. <a href="employees.html">List of Employees</a></h2>
    <h2>2. <a href="add.html">Add Employee</a></h2>
    <h2>3. <a href="#" id="timeTest" onclick="timeTest()">Display Current Time</a></h2>
    
    <div id="result"></div>
    <div class="ui-widget">
    	<label for="listOfEmp"> List Of employee:</label>
    	<input id="listOfEmp">
    </div>
  </body>
</html>