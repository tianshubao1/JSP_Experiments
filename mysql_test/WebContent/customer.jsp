<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import = "java.util.*" %>
<%@ page import = "edu.sbu.control.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Customer Info</title>
<script type="text/javascript">

function beforeSubmit(form2){
	if(form2.username2.value == ""){
		alert("username can not be null");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<%
	String error = (String)request.getAttribute("error");
	if(error != null){
		%>
		<h1 align = "center"><%=error %></h1>
	<% }
	%>

<%
	List<Customer> list = (List)session.getAttribute("list");
%>
<h2 align = "center">Customer Information</h2>
		<table border = 1 align = "center">
		<tr>
			<td>Username</td>	
			<td>First Name</td>
			<td>Last Name</td>
			<td>Policy No</td>
			<td>Phone No</td>
			<td>Email</td>
			<td>Policy Coverage</td>
			<td>AAA Member</td>							
		</tr>
		<%
		for(Customer c:list){
			%>
			<tr>
				<td><%=c.getUsername() %></td>
				<td><%=c.getFirstname() %></td>
				<td><%=c.getLastname() %></td>
				<td><%=c.getPolicyno() %></td>
				<td><%=c.getPhoneno() %></td>
				<td><%=c.getEmail() %></td>
				<td><%=c.getPolicyco() %></td>
				<td><%=c.getAAA() %></td>
			</tr>
		<%}
		%>
		</table>
		<br>
	<form action="CustomerSerlvet" method = "post">
		<table border = "1" align = "center">
			<tr>
				<td>Username</td>
				<td colspan = "2">Operation</td>
			</tr>
			<tr>
				<td><input type = "text" name = "username"/></td>
				<td><input type = "submit" name = "btn" value = "view"/></td>
				<td><input type = "submit" name = "btn" value = "delete"/></td>
			</tr>
		</table>
	</form>
	<br>
	<form action = "CustomerSerlvet" method = "post" name = "form2" onSubmit="return beforeSubmit(this);">
		<table border = "1" align = "center">
			<tr>
			<td>Username</td>	
			<td>First Name</td>
			<td>Last Name</td>
			<td>Policy No</td>
			<td>Phone No</td>
			<td>Email</td>
			<td>Policy Coverage</td>
			<td>AAA Member</td>	
			<td colspan = "2">Operation</td>						
		</tr>
		<tr>
			<td><input type = "text" name = "username2"/></td>
			<td><input type = "text" name = "firstname"/></td>
			<td><input type = "text" name = "lastname"/></td>
			<td><input type = "text" name = "policyno"/></td>
			<td><input type = "text" name = "phoneno"/></td>
			<td><input type = "text" name = "email"/></td>
			<td><input type = "text" name = "policyco"/></td>
			<td><input type = "text" name = "AAA"/></td>
			<td><input type = "submit" name = "btn" value = "edit"/></td>
			<td><input type = "submit" name = "btn" value = "new"/></td>
		</tr>
		</table>
	</form>
	<h3><a href = "login.jsp">Log out</a></h3>
</body>
</html>