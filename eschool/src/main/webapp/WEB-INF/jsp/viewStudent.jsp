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
  width: 80%;
  padding: 10px;
  margin: 5px 5px 22px 0;
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
padding-right : 16px;
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
                    console.log("The 'date' input type is not supported, so using JQueryUI datepicker instead.");
                    $("#theDate").datepicker();
                }
            });
        </script>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students_Deatils</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">
<div class="container">
<h2>${studentWrapper.student.lastName} ${studentWrapper.student.firstName} ${studentWrapper.student.middleName}</h2>
    <hr>
 


<form:form action="editStudent.html?id=${studentWrapper.student.id}" method="post" modelAttribute="studentWrapper" enctype="multipart/form-data">
<div class="row">
<div class = "col">
<table  width="100%" >
<tr>
<td><label for="lbl"><b>Roll Number :</b></label></td>
<td><input type="text" disabled="disabled" value="${studentWrapper.student.rollNum}"/><br></td>
<td><label for="lbl"><b>Division</b></label></td>
<td> <input type="text" disabled="disabled" value="${studentWrapper.student.division}"/><br></td>
</tr>
<tr></tr>
<tr>
<td><label for="lbl"><b>Standard</b></label></td>
<td><input type="text" disabled="disabled" value="${studentWrapper.student.standard}"/></td>
<td><label for="lbl"><b>Academic Year</b></label></td>
<td><input type="text" disabled="disabled" value="${studentWrapper.student.academicYr}"/></td>
</tr>
<tr></tr>
</table>
<hr><br>
<table  width="100%" style="text-align: left;">
<tr>
<td><label for="lbl"><b>Gender</b></label>	</td>
<td> <input type="text" disabled="disabled" value="${studentWrapper.student.gender}"/></td>
<td><label for="lbl"><b>Birth Date</b></label></td>
<td> <input type="text" disabled="disabled" value="${studentWrapper.student.dob}"/></td>
</tr>
<tr>
<td><label for="lbl"><b>Category</b></label></td>
<td> <input type="text" disabled="disabled" value="${studentWrapper.student.category}"/></td>
<td><label for="lbl"><b>Status</b></label></td>
<td> <input type="text" disabled="disabled" value="${studentWrapper.student.status}"/></td>
</tr>
<tr>
	<td><label for="lbl"><b>Admission Date</b></label></td>
	<td> <input type="text" disabled="disabled" value="${studentWrapper.student.admsnDt}"/></td>
</tr>
</table>
</div>	
<div class="col">
	<img src="${studentWrapper.student.imageId}" alt="default.jfif" onerror="this.src='default.jfif'" align="left" height="155" width="120" border="2px solid black" style="margin-right:100%;margin-bottom:20px;margin-left:20%"/><br>
	 <br>
</div>
</div>
<div class="row">
<div class="col">
<hr></hr>
<label>Other Details</label>	<br><br>
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Father's Name</b></label></td>
<td><input type="text" disabled="disabled" value = ${studentWrapper.student.otherDetail.fatherName}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Mother Name</b></label></td>
<td><input type="text" disabled="disabled" value = ${studentWrapper.student.otherDetail.motherName}><br></td>
</tr>

<tr>
<td><label for="lbl"><b>Mobile Number</b></label></td>
<td><input type="text" disabled="disabled" value = ${studentWrapper.student.mobilNum}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Address</b></label></td>
<td><textarea disabled="disabled" name="student.otherDetail.address"rows="6" cols="30" >${studentWrapper.student.otherDetail.address}</textarea></td>
</tr>
</table>
</div>
<div class="col">
<hr><br>
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Father's Qualification</b></label></td>
<td><input type="text" disabled="disabled" value = ${studentWrapper.student.otherDetail.fatherQualif}><br></td>
</tr>
<tr>
<td><label for="lbl"><b>Mothers's Qualification</b></label></td>
<td><input type="text" disabled="disabled"  value = ${studentWrapper.student.otherDetail.motherQualif}><br></td>
</tr>
</table>
</div>
</div>
<button value="Register" class="registerbtn">Edit</button>
</form:form>


</div>
</body>
</html>