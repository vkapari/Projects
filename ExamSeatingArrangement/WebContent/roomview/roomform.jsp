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
<%
String action="insert";
%>
    <div align="center">
		<h1>Room Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/room?action=list">List All Rooms</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/room?action=new">Add New Room</a>
        </h2>
	</div>
    <div align="center">
        <c:if test="${room != null}">
        <%  		action = "update"; %>
            <!-- <form action="update" method="post"> -->
        </c:if>
        <c:if test="${room == null}">
        <%  		action = "insert"; %>
            <!-- <form action="insert" method="post"> -->
        </c:if>
        <form action="${pageContext.request.contextPath}/room?action=<%=action %>" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${room != null}">
                        Edit Room
                    </c:if>
                    <c:if test="${room == null}">
                        Add New Room
                    </c:if>
                </h2>
            </caption>
                <c:if test="${room != null}">
                    <input type="hidden" name="roomId" value="<c:out value='${room.roomId}' />" />
                </c:if>           
            <tr>
                <th>Room Id: </th>
                <c:if test="${room != null}">
                <td>
                    <input type="text" name="roomId" size="45" disabled="disabled"
                            value="<c:out value='${room.roomId}' />"
                        />
                </td>
                </c:if>
                <c:if test="${room == null}">
                <td>
                    <input type="text" name="roomId" size="45"
                            value="<c:out value='${room.roomId}' />"
                        />
                </td>
                </c:if>
            </tr>
            <tr>
                <th>No OF Rows: </th>
                <td>
                    <input type="text" name="noOfRows" size="5"
                            value="<c:out value='${room.noOfRows}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>No Of Columns: </th>
                <td>
                    <input type="text" name="noOfColumns" size="5"
                            value="<c:out value='${room.noOfColumns}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="roomDesc" size="50"
                            value="<c:out value='${room.description}' />"
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