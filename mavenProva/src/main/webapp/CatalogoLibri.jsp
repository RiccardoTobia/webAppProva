<%@page import="com.zefiro.provaMaven.model.Libro"%>
<%@page import="com.zefiro.provaMaven.dao.LibroDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="GetLibro">
		<p>Id del libro da cercare:</p> 
		<input type="text" name="id">
		<input type="submit"> 
	</form>
	
	<%
		LibroDao dao = new LibroDao();
		
		for(Libro l : dao.getAll()){
			if(l.getIsLibroOrCd() == 0){
			out.println(l.presentazione());
			}
		}
	
	%>
	
</body>
</html>