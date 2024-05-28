<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update address</h1>
	<hr>
	<form action="./update" method="put">
		<table>
			<tr>
				<td>a_id :</td>
				<td><input type="text" name="a_id" value="${address.a_id}"
					readonly="readonly"></td>

			</tr>
			<tr>
				<td>a_area :</td>
				<td><input type="text" name="a_area" value="${address.a_area}"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
		<a href="./findall">All Address</a>
	</form>
</body>
</html>