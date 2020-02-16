<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ include file="../js/jquery-3.3.1.js" %>
<%@ include file="../js/jquery.dataTables.min.js" %> --%>
<%-- <%@ include file="../css/jquery.dataTables.min.css" %> --%>

<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<!-- <style type="text/css" ></style> -->

<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );
</script>

<head>
 <title>User Management</title>
</head>
<body>
	<div align="center">
		<h1>User Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/user?action=list">List All Users</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/user?action=new">Add User</a>
        </h2>
	</div>

    <div align="center">
        <table border="1" cellpadding="5" id="example">
            <caption ><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.country}" /></td>
                    <td>
                     <a href="${pageContext.request.contextPath}/user?action=edit&id=<c:out value='${user.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="${pageContext.request.contextPath}/user?action=delete&id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="left">
	    <h2>
			<a href="/ExamSeatingArrangement">Home</a>
		</h2>
	</div>
</body>
</html>