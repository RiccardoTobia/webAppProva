<%@page import="com.zefiro.provaMaven.model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	
	<%
		Libro l = (Libro)request.getAttribute("cd");
		
		if(l == null){
			out.println("ERRORE");
		} else {		
			out.println(l.toString());
		}
	%>
</body>
</html>