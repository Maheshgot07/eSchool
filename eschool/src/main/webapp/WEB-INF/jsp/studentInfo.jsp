<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.container {
  padding: 16px;
  background-color: white;
  position: relative;
}

.container2 {
  padding: 16px;
  background-color: #ccc;
}
table th{
	/* display: inline-block; */
    color: white;
    text-align: center;
  /*   padding: 14px 16px; */
  border: 1px thin black;
    text-decoration: none;
}

table td {
border: 1px solid black;
padding-left :16px;
}
table#tbl1 {
margin: 6px 32px 16px 32px;
align-self: center;
border : 1px thin black;
border-spacing: 0px;
width:95%;
bordercolor:"black";
background-color: #ccc;
border-collapse: collapse;
}
.container label{
margin-left: 13%;
}

input button {
width:20%; 
height :28px;
margin-top:22px; 
margin-left:41%; 
align-self: left; 
background-color: green;
color: white; 
border: 1px solid black;
}

table a{
 color: blue;
}

input[type=submit]{
width:20%; 
height :28px;
margin-top:6px; 
margin-left:41%; 
align-self: left; 
background-color: green;
color: white; 
border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">

<c:if test="${empty studentList}">
<div class="container">
<form:form action="studentInfo.html" method="post" modelAttribute="student">
<h2 align="center"><b>Select Standard and Year</b></h2><br><br>
<label for="lbl"><b>Standard</b></label>
	<select name="qualification" style="width:20%;margin-left: 16px;margin-right: 32px; margin-bottom: 10px;background: #f1f1f1; height: 26px" >
			<option value="8">8th</option>
			<option value="9">9th</option>
			<option value="10">10th</option>
	</select>
<label for="lbl"><b>Academic Year</b></label>
	<select name="branch" style="width:20%;margin-left: 16px;margin-bottom: 10px;background: #f1f1f1; height: 26px" >
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	</select>
<div class="button">
<input type="submit" value="VIEW" align="middle" width="20%" >
</div>
</form:form>
</div>
</c:if>
<%-- <c:if test="${null != studentName}">
<p>Student ${studentName} registered successfully!!!</p>
</c:if> --%>

<div class="container">
<div>
	<c:if test="${!empty studentList}">
  <h2 align="center">List of Students</h2>
  <form:form action="classStudents.html" method="post"	modelAttribute="student">
	 <input type="hidden" name="branch" value="${student.branch}">
	 <input type="hidden" name="id" value="${student.id}">
	 <input type="hidden" name="qualification" value="${student.qualification}">
	 <input type="submit" name="export" value="Export" style="margin-left: 32px;background-color:blue;">
	 <label><a href="resultExportOfAllStudents.html?qualification=${student.qualification }&branch=${student.branch}">Click</a> here to Export all students Result</label>
  </form:form>

 <table id="tbl1"  >
  <tr bgcolor="green" >
   <th>Student ID</th>
   <th>Student Name</th>
   <th>Standard</th>
   <th>Academic Year</th>
   <th>Action</th>
  </tr>

  <c:forEach items="${studentList}" var="std">
   <tr>
    <td><a href="edit.html?id=${std.id}" ><c:out value = "${std.id}"/></a></td>
    <td><c:out value = "${std.firstName} ${std.lastName}"/></td>
    <td><c:out value = "${std.qualification}"/></td>
    <td><c:out value = "${std.branch}"/></td>
    <td><a href="delete.html?id=${std.id}" >Delete</a> |<a href="edit.html?id=${std.id}">Edit</a>|<a href="showExams.html?id=${std.id}">result</a>|<a href="addResultForSelectedStudnt.html?id=${std.id}">Add Result</a></td>
    
    <!--
    <td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
   --></tr>
 
  </c:forEach>
 </table>
 

<div>
	<a href="register.html">Register another</a>
	<br/>
</div>
</c:if>
	
</div>

</div>

</body>
</html>