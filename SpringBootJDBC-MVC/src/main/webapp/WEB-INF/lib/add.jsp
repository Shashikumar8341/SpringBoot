<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Address</h1>
	<hr>
	<form action="./save" method="post">
		<table>
			<tr>
				<td>a_id :</td>
				<td><input type="text" name="a_id"></td>
			</tr>
			<tr>
				<td>a_area :</td>
				<td><input type="text" name="a_area"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Save"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
		<a href="./findall">All Address</a>
	</form>
</body>
</html>