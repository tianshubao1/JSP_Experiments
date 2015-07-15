<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome</title>
</head>
<body>
	<h2 align = "center">Welcome to Insurance Agent System</h2>
	<form action="LoginServlet" method = "post">
		<table border = 1 align = center>
			<tr><td colspan = 4><h3 align = "center">Log in</h3></td></tr>
			<tr><td colspan = 4 align = "center">
				<input type = "submit" name = "btn" value = "log in"/>
				<input type = "submit" name = "btn" value = "log out"/></td>
			</tr>
		</table>
	</form>
</body>
</html>