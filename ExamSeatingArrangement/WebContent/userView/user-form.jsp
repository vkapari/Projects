<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/style.css" />
<head>
 <title>User Management</title>
</head>
<body>
<%
String action="insert";
%>


 	<div align="center">
		<h1>User Management</h1>
        <h2>
         	<a href="${pageContext.request.contextPath}/user?action=list">List All Users</a>
         &nbsp;&nbsp;&nbsp;
         	<a href="${pageContext.request.contextPath}/user?action=new">Add User</a>
        </h2>
	</div>
    <div align="center">
  	<c:if test="${user != null}">
<%  		action = "update"; %>
   		<%-- <form action="${pageContext.request.contextPath}/user?action=update" method="post"> --%>
   	</c:if>
    <c:if test="${user == null}">
<%    	action="insert"; %>
   		<%-- <form action="${pageContext.request.contextPath}/user?action=insert" method="post"> --%>
   	</c:if>
   	<form action="${pageContext.request.contextPath}/user?action=<%=action %>" method="post">
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${user != null}">
               Edit User
              </c:if>
              <c:if test="${user == null}">
               Add New User
              </c:if>
             </h2>
            </caption>
          <c:if test="${user != null}">
           <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
          </c:if>            
            <tr>
                <th>User Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${user.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>User Email: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${user.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                 <input type="text" name="country" size="15"
                   value="<c:out value='${user.country}' />"
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