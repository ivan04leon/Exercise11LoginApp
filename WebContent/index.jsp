<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginApp</title>
</head>
<body>
<!--  %
if(session.getAttribute("user") == null){
	response.sendRedirect("index.jsp");
}

String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("user")) {
			userName = cookie.getValue();
			}
	}
}
%> -->
<h1>Bienvenido</h1>
<p> La fecha actual es: <%=(new java.util.Date()).toLocaleString() %>
<%--comentario para scriplet --%>
	<form action="LoginServlet" method="post">
		<p>User: <input type="text" name="user" placeholder="User" autofocus></p>
		<p>Password: <input type="password" name="password" placeholder="Password"></p>
		<p><input type="submit" value="Log in"></p>
	</form>
	
<div>${mierror}</div>
<c:set var="errorclass" value="${mierror?\"has-error\":\"\"}" />
<c:forEach var="maq"  items="${listaMaquillajesAMostrar}" varStatus="counter">
<li>
<span>${maq.codigo}</span> -<span>${maq.marca}</span> -
</li>
</c:forEach>

</body>
</html>