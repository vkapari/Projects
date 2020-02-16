<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />
<head>
    <title>Manage Rooms</title>
</head>
<body>
	<div align="center">
		<h1>Room Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/room?action=list">List All Rooms</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/room?action=new">Add New Room</a>
        </h2>
	</div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Rooms</h2></caption>
            <tr>
                <th>Room ID</th>
                <th>No Of Rows</th>
                <th>No Of Columns</th>
                <th>Room Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="room" items="${listRooms}">
                <tr>
                    <td><c:out value="${room.roomId}" /></td>
                    <td><c:out value="${room.noOfRows}" /></td>
                    <td><c:out value="${room.noOfColumns}" /></td>
                    <td><c:out value="${room.description}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/room?action=edit&roomId=<c:out value='${room.roomId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/room?action=delete&roomId==<c:out value='${room.roomId}' />">Delete</a>                     
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