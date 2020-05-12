<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password][type =select] {
  width: 100%;
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  margin-left: 40%;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.9;
  text-align: center;
}

.registerbtn:hover {
  opacity: 1;
}
.row:after {
  content: "";
  display: table;
  clear: both;
}
/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
.col {
  float: left;
  width: 50%;
  margin: auto;
  padding: 0 50px;
  margin-top: 6px;
}
@media screen and (max-width: 650px) {
  .col {
    width: 100%;
    margin-top: 0;
  }

.lbl{

padding-right : 20px;
}

</style>
<link rel="stylesheet" type="text/css" href="jquery-ui-1.10.3/themes/base/jquery.ui.all.css"/>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/modernizr/modernizr-1.7-development-only.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
        <script type="text/javascript" src="jquery-ui-1.10.3/ui/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="jquery-ui-1.10.3/ui/jquery.ui.datepicker.js"></script>
        <script type="text/javascript">
            $(function(){
                if(!Modernizr.inputtypes.date) {
                	dateFormat: "yy-mm-dd";
                	console.log("The 'date' input type is not supported, so using JQueryUI datepicker instead.");
                    $("#theDate").datepicker();
                }
            });
        </script>
        <!-- <script type="text/javascript">function validateForm() {
        	  var x = document.forms["register"]["student.dob"].value;
        	  if (x == "" || x == null) {
        		  document.forms["register"]["student.dob"].value = "31-06-1990";
        	    alert(document.forms["register"]["student.dob"].value);
        	    return true;
        	  }
        	}</script> -->
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Students</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">
<div class="container">
<p>Register Students</p>
    <hr>
 


<form:form name ="register" action="saveStudent.html" method="post" modelAttribute="feeStructureWrapper" enctype="multipart/form-data">
<div class="row">
<div class = "col">
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>FirstName</b></label></td>
<td><input type="text" placeholder="Enter First Name" name="student.firstName" required value = ${studentWrapper.student.firstName}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Middle Name</b></label></td>
<td><input type="text" placeholder="Enter Middle Name" name="student.middleName"  value = ${studentWrapper.student.middleName}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Last Name</b></label></td>
<td><input type="text" placeholder="Enter Last Name" name="student.lastName" required value = ${studentWrapper.student.lastName}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Roll Number</b></label></td>
<td><input type="text" placeholder="Enter Roll Number" name="student.rollNum" value = ${studentWrapper.student.rollNum}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Division</b></label></td>
<td><input type="text" placeholder="Enter Division" name="student.division" value = ${studentWrapper.student.division}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Standard</b></label></td>
<td><select name="student.standard" style="width:100%; margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${studentWrapper.student.standard}" >
			<option value="8">8th</option>
			<option value="9">9th</option>
			<option value="10">10th</option>
	</select></td>
</tr>
<tr>
<td><label for="lbl"><b>Academic Year</b></label></td>
<td><select name="student.academicYr" style="width:100%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${studentWrapper.student.academicYr}">
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	</select></td>
</tr>
</table>
	


</div>	
<div class="col">
	<img src="${student.imageId}" alt="default.jfif" onerror="this.src='default.jfif'" align="left" height="155" width="120" border="2px solid black" style="margin-right:100%;margin-bottom:20px;margin-left:20%"/><br>
	 Upload Image <input type="file" name="file" /> <br>
	 <hr>
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Gender</b></label>	</td>
<td><input type="radio" id="male" name="student.gender" value="male">
<label for="male">Male</label>
<input type="radio" id="female" name="student.gender" value="female">
  <label for="female">Female</label>
  <input type="radio" id="other" name="student.gender" value="other">
  <label for="other">Other</label>
</td>
</tr>

<tr>
<td><label for="lbl"><b>Birth Date</b></label></td>
<td><input id="theDate" name="dob" type="date" style="width:100%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value = ${studentWrapper.dob} ></td>
</tr>
<tr>
<td><label for="lbl"><b>Admission Date</b></label></td>
<td><input id="theDate" name="admsnDt" type="date" style="width:100%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value = ${studentWrapper.admsnDt} ></td>
</tr>
<tr>
<td><label for="lbl"><b>Category</b></label></td>
<td>
<select name="student.category" style="width:100%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${studentWrapper.student.category}">
	<option value="OPEN">OPEN</option>
	<option value="SC">SC</option>
	<option value="ST">ST</option>
	<option value="OBC">OBC</option>
	<option value="EBC">EBC</option>
	<option value="NT">NT</option>
</select>
</td>
</tr> 
<tr>
<td><label for="lbl"><b>Status</b></label></td>
<td><input type="radio" id="active" name="student.status" value="ACTIVE" checked="checked">
  <label for="active">ACTIVE</label>
  <input type="radio" id="inactive" name="student.status" value="INACTIVE">
  <label for="inactive">INACTIVE</label></td>
</tr>
</table>
</div>
</div>
<div class="row">
<div class="col">
<hr></hr>
<label>Other Details</label>	<br><br>
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Father's Name</b></label></td>
<td><input type="text" placeholder="Enter Father Name" name="student.otherDetail.fatherName" required value = ${studentWrapper.student.otherDetail.fatherName}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Mother Name</b></label></td>
<td><input type="text" placeholder="Enter Mother Name" name="student.otherDetail.motherName" required value = ${studentWrapper.student.otherDetail.motherName}><br></td>
</tr>

<tr>
<td><label for="lbl"><b>Mobile Number</b></label></td>
<td><input type="text" placeholder="Enter Mobile Number" name="student.mobilNum" value = ${studentWrapper.student.mobilNum}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Address</b></label></td>
<td><textarea placeholder="Enter Full Address" name="student.otherDetail.address" rows="4" cols="50" value = {student.otherDetail.address}></textarea></td>
</tr>
</table>
</div>
<div class="col">
<br><br><br><br>
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Father's Qualification</b></label></td>
<td><input type="text" placeholder="Enter Fathers Qualification" name="student.otherDetail.fatherQualif"  value = ${studentWrapper.student.otherDetail.fatherQualif}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Mothers's Qualification</b></label></td>
<td><input type="text" placeholder="Enter Mothers Qualification" name="student.otherDetail.motherQualif"  value = ${studentWrapper.student.otherDetail.motherQualif}><br></td>
</tr>
</table>
</div>
</div>
	<button type="submit" value="Register" class="registerbtn" onclick="validateForm()">Register</button>
</form:form>


</div>
</body>
</html>