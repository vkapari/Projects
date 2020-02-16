<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />

<style type="text/css">
/* body {
  background-image: url("C:/Users/vkapari/Desktop/bootstrap/Regna/img/hero-bg.jpg");
  background-repeat: no-repeat;
  background-color: #cccddd;
  background-size: cover;
} */
<%-- 
    <%@include file="bootstrap/css/style.css" %>
    <%@include file="bootstrap/css/scss-files.txt" %>
    <%@include file="bootstrap/main.js" %>
 --%>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<title>Management Application</title>
</head>
<body>
<center>
        <h2>
            <a href="/ExamSeatingArrangement/book?action=list">Books Management</a>
            <br/>
            <a href="/ExamSeatingArrangement/user?action=list">User Management</a>
            <br/>
            <a href="/ExamSeatingArrangement/room?action=list">Room Management</a>
        </h2>
    </center>
    
</body>
</html>