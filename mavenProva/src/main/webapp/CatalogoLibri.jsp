<%@page import="com.zefiro.provaMaven.model.Libro"%>
<<<<<<< HEAD
<%@page import="com.zefiro.provaMaven.dao.LibroDao"%>
=======
<%@page import="java.util.List"%>
>>>>>>> refs/remotes/origin/branch2
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
=======

	<h1 style="text-align: center;"> ECCO I NOSTRI LIBRI!</h1>
	
	<table align="center" style="padding-top:10px">
		<thead>
			<tr>
				<th style="width: 20em; border: 1px solid black;">Titolo</th>
				<th style="width: 20em; border: 1px solid black;">Autore</th>
				<th style="width: 20em; border: 1px solid black;">Genere</th>
			</tr>
		</thead>
		<tbody>
			
	
		<%
			List<Libro> list = (List<Libro>) request.getAttribute("list"); %>
		<%
			for(Libro l : list){
				
				if(l.getIsLibroOrCd() == 0){
		%>
				<tr>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getTitolo()%></td>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getAutore()%></td>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getGenere()%></td>
				</tr>
		<% 
				}
			}
		%>
	
		</tbody>
	
	</table>
	
>>>>>>> refs/remotes/origin/branch2
	<form action="GetLibro">
		<p>Id del libro da cercare:</p> 
		<input type="text" name="id">
		<input type="submit"> 
	</form>
	
<<<<<<< HEAD
	<%
		LibroDao dao = new LibroDao();
		
		for(Libro l : dao.getAll()){
			if(l.getIsLibroOrCd() == 0){
			out.println(l.presentazione());
			}
		}
	
	%>
=======
	<a href="acquistaLibri.jsp"><input type="button" value="acquista"></a>
	
>>>>>>> refs/remotes/origin/branch2
	
</body>
</html>