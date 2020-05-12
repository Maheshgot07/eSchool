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
  width: 80%;
  padding: 10px;
  margin: 5px 5px 22px 0;
  display: inline-block;
  border: none;
  /*background: #f1f1f1;*/
  background: #ccc;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #f1f1f1;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
table#tblViewPayment{
margin: 6px 32px 16px 32px;
align-self: center;
border : 1px thin black;
border-spacing: 0px;
width:80%;
bordercolor:"black";
/*background-color: #ccc;*/
background-color: aqua;
border-collapse: collapse;
}
table#tblViewPayment td{
  border-collapse: collapse;
  border: 1px solid black;
  border-spacing: 0px;
  font: normal;
  text-align: center;
  
}
table#tblViewPayment th{
    color: white;
    text-align: center;
    padding: 8px 12px; 
 	border: 1px solid black;
    text-decoration: none;
    border-collapse: collapse;	
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
<script src="school.js"></script>
<title>Payment Details</title>
<%@include file="menu.jsp" %>
</head>
<body style ="background-color:rgb(204,222,240);">
<div class="container">
<h2>${paymentWrapper.student.lastName} ${paymentWrapper.student.firstName} ${paymentWrapper.student.middleName}</h2>
<h5>${paymentWrapper.student.rollNum} , ${paymentWrapper.student.standard}, ${paymentWrapper.student.academicYr}, ${paymentWrapper.student.division}</h5>
<hr>

<form:form action="editPayment.html?id=${paymentWrapper.student.id}" >
<div class="row">
<table  width="100%" >
<tr>
<td><label for="lbl"><b>Total Fees</b></label></td>
<td><input name="tot_amt" type="text" disabled="disabled" value = ${paymentWrapper.studentPayment.tot_amt} ></td>
<td><label for="lbl"><b>Paid Fees</b></label></td>
<td><input name="tot_paid_amt" type="text" disabled="disabled" value = ${paymentWrapper.studentPayment.tot_paid_amt} ></td>
<td><label for="lbl"><b>Total Pending Fees</b></label></td>
<td><input name="tot_pending_amt" type="text" disabled="disabled" value = ${paymentWrapper.studentPayment.tot_pending_amt} ></td>
<td><label for="lbl"><b>Previous Year Pending </b></label></td>
<td><input name="prvs_bal" type="text" disabled="disabled" value = ${paymentWrapper.studentPayment.prvs_bal} ></td>
</tr>
</table>
<hr>
</div>
<div class="row">
<table id="tblViewPayment">
<tr bgcolor="gray">
<th>Fee Type</th>
<th>Total Fee</th>
<th>Net Payable (After Discount)</th>
<th>Paid Amount</th>
<th>Pending Amount</th>
<th>Date</th>
<th>Applied Discount</th>
</tr>

  <c:forEach items="${paymentWrapper.studentPayment.payment_item}" var="item" varStatus="i">
   <tr>
    <td><c:out value = "${item.payment_desc}"/></td>
    <td><c:out value = "${item.amount}"/></td>
    <td><c:out value = "${item.net_payable}"/></td>
    <td><c:out value = "${item.amt_paid}"/></td>
    <td><c:out value = "${item.pending_amt}"/></td>
    <td><c:out value = "${item.payment_date}"/></td>
    <td><c:out value = "${item.discount}"/></td>
	</tr>
  </c:forEach>
  <tr bgcolor="lime"><td><c:out value = "Total"/></td>
  <td><c:out value = "${paymentWrapper.studentPayment.tot_amt}"/></td>
  <td><c:out value = "${paymentWrapper.studentPayment.netPayableAmt}"/></td>
  <td><c:out value = "${paymentWrapper.studentPayment.tot_paid_amt}"/></td>
  <td><c:out value = "${paymentWrapper.studentPayment.tot_pending_amt}"/></td>
  <td><c:out value = "--"/></td>
  <td><c:out value = "--"/></td>
  
  </tr>
</table>
</div>
<button value="edit" class="registerbtn">Edit</button>
</form:form>
</div>
</body>
</html>