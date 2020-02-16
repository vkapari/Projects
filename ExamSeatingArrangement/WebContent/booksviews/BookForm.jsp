<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />
<head>
    <title>Books Store Application</title>
</head>
<body>
<%
String action="insert";
%>
    <div align="center">
		<h1>Books Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/book?action=list">List All Books</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/book?action=new">Add New Book</a>
        </h2>
	</div>
    <div align="center">
        <c:if test="${book != null}">
        <%  		action = "update"; %>
            <!-- <form action="update" method="post"> -->
        </c:if>
        <c:if test="${book == null}">
        <%  		action = "insert"; %>
            <!-- <form action="insert" method="post"> -->
        </c:if>
        <form action="${pageContext.request.contextPath}/book?action=<%=action %>" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${book.author}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${book.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div align="left">
	    <h2>
			<a href="/ExamSeatingArrangement">Home</a>
		</h2>
	</div>
</body>
</html>