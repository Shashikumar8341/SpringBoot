<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@page import="com.tm.rpc.beans.ItemBean"%>
 <%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%> --%>
<%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 --%> 
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All address</h1>
	<hr>
	<table border="1px;">
		<tr>
			<th>a_id</th>
			<th>a_area</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<c:forEach items="${address}" var="address">
			<tr>
				<td><c:out value="${address.a_id}"></c:out></td>
				<td><c:out value="${address.a_area}"></c:out></td>
				<td><a href="./deletebyid?a_area=${address.a_area}">Delete</a></td>
				<td><a href="./update?a_area=${address.a_area}">Update</a></td>
			</tr>

		</c:forEach>

	</table>
	<a href="./add">Add Address</a>
</body>
</html>