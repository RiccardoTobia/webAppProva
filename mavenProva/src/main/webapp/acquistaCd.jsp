<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zefiro.provaMaven.dao.LibroDao"%>
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

	<h1 style="text-align: center;">LIBRI DISPONIBILI</h1>

	<% 
		LibroDao dao = new LibroDao();
	
		List<Libro> result = dao.getAll();
		List<Libro> disponibili = new ArrayList<Libro>();
		List<Libro> esauriti = new ArrayList<Libro>();
		
		for(Libro l : result){
			if(l.getIsLibroOrCd() != 0){
				if(l.getQuantita() == 0){
					esauriti.add(l);
				} else{
					disponibili.add(l);
				}
			}
		}
		
		
	%>
	
		<table align="center" style="padding-top:10px">
		<thead>
			<tr>
				<th style="width: 20em; border: 1px solid black;">Titolo</th>
				<th style="width: 20em; border: 1px solid black;">Autore</th>
				<th style="width: 20em; border: 1px solid black;">Quantita</th>
			</tr>
		</thead>
		<tbody>
			
	
		<%
			for(Libro l : disponibili){

		%>
				<tr>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getTitolo()%></td>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getAutore()%></td>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getQuantita()%></td>
				</tr>
		<% 
			}
		%>
	
		</tbody>
	
	</table>

	<% if(esauriti.size() > 0) {%>
	<h1 style="text-align: center;">CD ESAURITI</h1>

	<table align="center" style="padding-top:10px">
		<thead>
			<tr>
				<th style="width: 20em; border: 1px solid black;">Titolo</th>
				<th style="width: 20em; border: 1px solid black;">Autore</th>
			</tr>
		</thead>
		<tbody>
			
	
		<%
			for(Libro l : esauriti){
				
		%>
				<tr style="color: red">
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getTitolo()%></td>
					<td style="width: 20em; border: 1px solid black; text-align: center;"><%= l.getAutore()%></td>
				</tr>
		<% 
			}
		%>
	
		</tbody>
	
	</table>
	<% }%>
</body>
</html>