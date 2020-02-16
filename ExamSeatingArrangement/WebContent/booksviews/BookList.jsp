<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />
<head>
    <title>Books Store</title>
</head>
<body>
	<div align="center">
		<h1>Books Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/book?action=list">List All Books</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/book?action=new">Add New Book</a>
        </h2>
	</div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book?action=edit&id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/book?action=edit&id==<c:out value='${book.id}' />">Delete</a>                     
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