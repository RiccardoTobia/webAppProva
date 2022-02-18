<%@page import="com.zefiro.provaMaven.model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	in show libri 
	
	<% 
		Libro l = (Libro)request.getAttribute("libro");
		out.println(l.toString());
	%>
</body>
</html>