package com.zefiro.provaMaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zefiro.provaMaven.model.Libro;

public class LibroDao {

	private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/libroocd?user=root&password=@First254";
	
	private Connection connection;
	private PreparedStatement getLibroById;
	private PreparedStatement getCdById;
	private PreparedStatement getByTitle;
	private PreparedStatement insert;
	private PreparedStatement update;
	
	
	
	public Libro GetTitolo(String titolo) {
		Libro result = null;
		
		try {
			getGetByTitle().clearParameters();
			getGetByTitle().setString(1, titolo);
			
			ResultSet rs = getGetByTitle().executeQuery();
			
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
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insert(Libro a) {
		boolean success = false;
		
		try {
			getInsert().clearParameters();
			getInsert().setString(1, a.getTitolo());
			getInsert().setString(2, a.getAutore());
			getInsert().setString(3, a.getGenere());
			getInsert().setString(4, a.getAnno());
			getInsert().setInt(5, a.getIsLibroOrCd());
			getInsert().setInt(6, a.getQuantita());

			getInsert().execute();
			success = true;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
		
	}
	
	public boolean update(Libro a) {
		boolean success = false;
		
		try {
			getUpdate().clearParameters();
			getUpdate().setString(1,a.getTitolo());
			getUpdate().setString(2,a.getAutore());
			getUpdate().setString(3, a.getGenere());
			getUpdate().setString(4, a.getAnno());
			getUpdate().setInt(5, a.getIsLibroOrCd());
			getUpdate().setInt(6, a.getQuantita());
			getUpdate().setLong(7, a.getId());
			
			getUpdate().execute();
			
			success=true;
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	} 
	
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

	public Libro getCd(int id) throws ClassNotFoundException {
		Libro result = null;
		
		
		try {

			getGetCdById().clearParameters();
			getGetCdById().setInt(1, id);
			ResultSet rs = getGetCdById().executeQuery();
			
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
	
	public List<Libro> getAll() throws ClassNotFoundException {
		List<Libro> result = new ArrayList<Libro>();
		
		try {

			ResultSet rs = getConnection().createStatement().executeQuery("select * from campionario");
			
			while(rs.next()) {
				
				Libro l = new Libro();
				
				l.setId(rs.getInt("id"));
				l.setTitolo(rs.getString("titolo"));
				l.setAutore(rs.getString("autore"));
				l.setGenere(rs.getString("genere"));
				l.setAnno(rs.getString("anno"));
				l.setIsLibroOrCd(rs.getInt("isLibroOrCd"));
				l.setQuantita(rs.getInt("quantita"));
				
				result.add(l);
				
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

	public PreparedStatement getGetCdById() throws SQLException {
		if(getCdById == null) {
			getCdById = getConnection().prepareStatement("select * from campionario where id=? and isLibroOrCd=1");
		}
		return getCdById;
	}

	public void setGetCdById(PreparedStatement getCdById) {
		this.getCdById = getCdById;
	}
	
	public PreparedStatement getInsert() throws ClassNotFoundException, SQLException {
		if(insert == null) {
			insert = getConnection().prepareStatement("insert into campionario (titolo, autore, genere, anno, isLibroOrCd, quantita) values(?,?,?,?,?,?)");
		}
		return insert;
	}

	public void setInsert(PreparedStatement insert) {
		this.insert = insert;
	}

	public PreparedStatement getUpdate() throws ClassNotFoundException, SQLException {
		if(update == null) {
			update = getConnection().prepareStatement("update campionario set titolo=?, autore=?, genere=?, anno=?, isLibroOrCd=?, quantita=? where id=?");
		}
		return update;
	}

	public void setUpdate(PreparedStatement update) {
		this.update = update;
	}

	public PreparedStatement getGetByTitle() throws ClassNotFoundException, SQLException {
		if(getByTitle == null) {
			getByTitle = getConnection().prepareStatement("select * from campionario where titolo=?");
		}
		return getByTitle;
	}

	public void setGetByTitle(PreparedStatement getByTitle) {
		this.getByTitle = getByTitle;
	}
	
}
