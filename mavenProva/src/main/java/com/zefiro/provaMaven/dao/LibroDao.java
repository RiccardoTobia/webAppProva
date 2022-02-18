package com.zefiro.provaMaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zefiro.provaMaven.model.Libro;

public class LibroDao {
	
	public Libro getLibro(int id) {
		Libro l = new Libro();
		
		l.setId(101);
		l.setTitolo("The storyteller");
		l.setAutore("Dave Grohl");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=root&password=@First254");
			Statement insert = connection.createStatement();
			ResultSet rs = insert.executeQuery("select * from libro where id="+id);
			
			if(rs.next()) {
				l.setId(rs.getInt("id"));
				l.setTitolo(rs.getString("titolo"));
				l.setAutore(rs.getString("autore"));
				l.setGenere(rs.getString("genere"));
				l.setAnno(rs.getString("anno"));
				l.setPagine(rs.getInt("pagine"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return l;
	}
}
