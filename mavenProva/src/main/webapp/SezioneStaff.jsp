<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center">Operazioni sul database</h1>
	
	<form action="postArticolo" method="POST">
		<h5>Titolo: </h5>
		<input type="text" name="titolo">
	
		<h5>Autore: </h5>
		<input type="text" name="autore">
	
		<h5>Genere: </h5>
		<input type="text" name="genere">
		
		<h5>Anno: </h5>
		<input type="text" name="anno">

		<h5>Libro o cd: </h5>
		<input type="text" name="isLibroOrCd">
		
		<h5>Quantità: </h5>
		<input type="text" name="quantita">
		
		<input type="submit">
	</form>

</body>
</html>