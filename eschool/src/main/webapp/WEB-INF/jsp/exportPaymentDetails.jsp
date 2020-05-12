<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  width: 50%;
  padding: 5px;
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
  padding: 10px 20px;
  margin: 8px 0;
  margin-left: 35%;
  border: none;
  cursor: pointer;
  width: 15%;
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

.addRowbtn {
  background-color: #4CAF50;
  color: white;
  padding: 14px 16px;
  margin: 8px 0;
  margin-left: 90%;
  border: none;
  cursor: pointer;
  width: 7%;
  opacity: 0.9;
  text-align: center;
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
table#tbl1{
  margin: 6px 32px 16px 32px;
align-self: center;
border : 1px thin black;
border-spacing: 0px;
width:95%;
bordercolor:"black";
background-color: #ccc;
border-collapse: collapse;
}
table#tbl1 td{
  border-collapse: collapse;
  border: 1px solid black;
  border-spacing: 0px;
  font: normal;
}
table#tbl1 th{
	/* display: inline-block; */
    color: white;
    text-align: center;
  /*   padding: 14px 16px; */
  border: 1px thin black;
    text-decoration: none;
}
label{
font: italic;
font-size: 14px;
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
<script type="text/javascript">function SetRollNumFunction() {
  if(document.getElementById("rollNum").value() == null)
	{
	  document.getElementById("rollNum").defaultValue = "-1";
	}
}</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Student</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">
<div class="container">
<p>Search Student</p>
<form:form action="exportPayments.html" method="post" modelAttribute="searchWrapper" enctype="multipart/form-data">
<table style="100%" width="90%">
<tr>
<td><label for="lbl"><b>Standard</b></label></td>
<td><select name="searchStudent.standard" style="width:50%; margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${searchWrapper.searchStudent.standard}" >
			<option value="">--</option>
			<option value="8">8th</option>
			<option value="9">9th</option>
			<option value="10">10th</option>
	</select></td>
	<td><label for="lbl"><b>Academic Year</b></label></td>
	<td><select name="searchStudent.academicYr" style="width:50%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${searchWrapper.searchStudent.academicYr}">
	<option value="">--</option>
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	</select></td>
	
	<td><label for="lbl"><b>Division</b></label></td>
<td><input type="text" placeholder="Search Division" name="searchStudent.division" value = ${searchWrapper.searchStudent.division}><br></td>
</tr>
</table>

<button type="submit" value="export" class="registerbtn">Export</button>
</form:form>


</div>
</body>
</html>