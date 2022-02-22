<%@page import="java.util.List"%>
<%@page import="com.zefiro.provaMaven.model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="GetCd">
		<p>Id del cd da cercare:</p>
		<input type="text" name="id">
		<input type="submit">
	</form>

		<table>
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
				
				if(l.getIsLibroOrCd() != 0){
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
</body>
</html>