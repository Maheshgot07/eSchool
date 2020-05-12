
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

ri {
    float: Right;
}

ri a{
	display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
  z-index: 1000;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: #333;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #111;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1000;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body style ="background-color:rgb(204,222,240);">

<!-- <p>Login first 
<a href="login.html" >Login</a>
</p> -->


<!-- <ul>
  <li><a href="home.html">Home</a></li>
  <li><a href="register.html">New Register</a></li>
  <li><a href="studentInfo.html">View Students</a></li>
  <li><a href="detailedResult.html">Result</a></li>
  <li><a href="#about">About</a></li>
  <li class="dropdown">
   <button class="dropbtn">Dropdown 
      <i class="fa fa-caret-down"></i>
    </button></li>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  <ri><a href="logOut.html">LogOut</a></ri>
  
</ul> -->
<div class="navbar">
<a href="home.html">Home</a>
<div class="dropdown">
    <button class="dropbtn">Registration 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="registerInit.html">New Registration</a>
      <a href="studentInfo.html">View Students</a>
    </div>
  </div> 
 
  <a href="studentInfo.html">View Students</a>
 <div class="dropdown">
    <button class="dropbtn">Result 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="detailedResult.html">Add Result</a>
      <a href="showStudentForResult.html">View Result</a>
    </div>
  </div> 
  <a href="addExam.html">Exam</a>
  <a href="clearCache.html">Cache</a>
  <ri><a href="logout">LogOut</a></ri>
  
</div>
 
</body>
</html>
