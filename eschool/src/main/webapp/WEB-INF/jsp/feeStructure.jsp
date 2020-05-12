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
table#feetbl1{
  margin: 6px 32px 16px 32px;
align-self: center;
border : 1px thin black;
border-spacing: 0px;
width:95%;
bordercolor:"black";
background-color: #ccc;
border-collapse: collapse;
}
table#feetbl1 td{
  border-collapse: collapse;
  border: 1px solid black;
  border-spacing: 0px;
}
table#feetbl1 th{
	/* display: inline-block; */
    color: white;
    text-align: center;
  /*   padding: 14px 16px; */
  border: 1px thin black;
    text-decoration: none;
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
<script src="school.js"></script>
<script type="text/javascript">function myFunction() {
	  var table = document.getElementById("feetbl1");
	  var lastRow = table.rows.length;
	  var count = 0;
	  var status = lastRow-1;
	  var row = table.insertRow(lastRow);
	  var cell1 = row.insertCell(0);
	  cell1.innerHTML = "<input type='text' placeholder='Enter FeeType' name='feeStructure.feeItems["+status+"].itemName'  value =${feeItems.itemName}>";
	  row.insertCell(1).innerHTML = "<input type='text' placeholder='Enter Total Fee' name='feeStructure.feeItems["+status+"].totAmt'  value =${feeItems.itemName} >";
	  row.insertCell(2).innerHTML = "<input type='text' placeholder='Enter Discount' name='feeStructure.feeItems["+status+"].discount'  value =${feeItems.itemName}>";
	  row.insertCell(3).innerHTML = "<td><input type='button' value='Delete' onclick='deleteRow(this)'></td>";
	}</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Config FeeStructure</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">
<div class="container">
<p>Configure FeeStructure</p>
    <hr>
 


<form:form action="createFeeStructure.html" method="post" modelAttribute="feeStructureWrapper">
<div class="row">
<div class = "col">
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Standard</b></label></td>
<td><select name="feeStructure.standard" style="width:100%; margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${feeStructureWrapper.feeStructure.standard}" >
			<option value="8">8th</option>
			<option value="9">9th</option>
			<option value="10">10th</option>
	</select></td>
</tr>
<tr>
<td><label for="lbl"><b>Academic Year</b></label></td>
<td><select name="feeStructure.academicYr" style="width:100%;margin-bottom: 10px;background: #f1f1f1; height: 26px" value="${feeStructureWrapper.feeStructure.academicYr}">
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	</select></td>
</tr>
</table>
</div>
<div class="col">
<table style="100%" width="80%">
<tr>
<td><label for="lbl"><b>Discount</b></label></td>
<td><input type="text" placeholder="Enter Discount" name="feeStructure.discount" value = ${feeStructureWrapper.feeStructure.discount}><br></td>
</tr>
</table>
</div>
</div>

<table id="feetbl1">
<tr bgcolor="green">
<th>Fee Type</th>
<th>Total Fee</th>
<th>Discount</th>
<th>Delete Row</th>
</tr>
<c:forEach items="${feeStructureWrapper.feeStructure.feeItems}" var="item" varStatus="status">
<tr>
<td><input type="text"  name="feeStructure.feeItems[${status.index}].itemName"  value = ${item.itemName}></td>
<td><input type="text"  name="feeStructure.feeItems[${status.index}].totAmt"  value = ${item.totAmt}></td>
<td><input type="text"  name="feeStructure.feeItems[${status.index}].discount"  value = ${item.discount}></td>
 <td><input type="button" value="Delete" onclick="deleteRow(this)"/></td>
</tr>
</c:forEach>
</table>
<button type="button" class="addRowbtn" onclick="myFunction()">Add Row</button><br>
	<button type="submit" value="Register" class="registerbtn">Register</button>
</form:form>


</div>
</body>
</html>