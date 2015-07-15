<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import = "java.util.*" %>
<%@ page import = "edu.sbu.control.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Vehicle Info</title>
<script type="text/javascript">
function beforeSubmit(form2){
	if(form2.vin.value == ""){
		alert("vin can not be null");
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
	List<Vehicle> vlist = (List)session.getAttribute("vlist");
	String username = (String)session.getAttribute("username");
%>
<h2 align = "center"><%=username %>'s Vehicle Information </h2>
	<table border = 1 align = "center">
	<tr>
		<td>VIN</td>
		<td>Make</td>
		<td>Model</td>
		<td>Type</td>
		<td>Year of Make</td>
	</tr>
	<%
		for(Vehicle v:vlist){
			%>
			<tr>
				<td><%=v.getVin() %></td>
				<td><%=v.getMake() %></td>
				<td><%=v.getModel() %></td>
				<td><%=v.getType() %></td>
				<td><%=v.getYearofmake() %></td>
				<td><img src=<%=v.getPciture() %>></td>
			</tr>
		<%}
		%>
	</table>
	<br>
	<form action="VehicleServlet" mothod = "post">
		<table border = 1 align = "center">
			<tr>
			<td>VIN</td>
			<td>Operation</td>
			</tr>
			<tr>
			<td><input type = "text" name = "dvin"/></td>
			<td><input type = "submit" name = "btn" value = "delete"/></td>
			</tr>			
		</table>
	</form>
	<br>
	<form action="VehicleServlet" method = "post" name = "form2" onSubmit="return beforeSubmit(this);">
		<table border = 1 align = "center">
			<tr>
			<td>VIN</td>
			<td>Make</td>
			<td>Model</td>
			<td>Type</td>
			<td>Year of Make</td>
			<td>Picture</td>
			</tr>
			<tr>
			<td><input type = "text" name = "vin"/></td>
			<td><input type = "text" name = "make"/></td>
			<td><input type = "text" name = "model"/></td>
			<td><input type = "text" name = "type"/></td>
			<td><input type = "text" name = "yearofmake"/></td>
			<td><input type = "text" name = "picture"/></td>
			<td><input type = "submit" name = "btn" value = "edit"/></td>
			<td><input type = "submit" name = "btn" value = "new"/></td>
			</tr>
		</table>
	</form>
	<h3><a href = "customer.jsp">Back</a></h3>
</body>
</html>