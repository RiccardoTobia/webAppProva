package com.zefiro.provaMaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zefiro.provaMaven.model.Libro;

public class LibroDao {

	private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/libroocd?user=root&password=@First254";
	
	private Connection connection;
	private PreparedStatement getLibroById;
	
	public Libro getLibro(int id) throws ClassNotFoundException {
		Libro result = null;
		
		
		try {

			getGetLibroById().clearParameters();
			getGetLibroById().setInt(1, id);
			ResultSet rs = getGetLibroById().executeQuery();
			
			if(rs.next()) {
				
				result = new Libro();
				
				result.setId(rs.getInt("id"));
				result.setTitolo(rs.getString("titolo"));
				result.setAutore(rs.getString("autore"));
				result.setGenere(rs.getString("genere"));
				result.setAnno(rs.getString("anno"));
				result.setIsLibroOrCd(rs.getInt("isLibroOrCd"));
				result.setQuantita(rs.getInt("quantita"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}

	public Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(CONNECTION_STRING);
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getGetLibroById() throws SQLException, ClassNotFoundException {
		if(getLibroById == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			getLibroById = getConnection().prepareStatement("select * from campionario where id=? and isLibroOrCd=0");
		}
		return getLibroById;
	}

	public void setGetLibroById(PreparedStatement getLibroById) {
		this.getLibroById = getLibroById;
	}
}
