package com.anahuac.desarrollo.mvc.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anahuac.desarrollo.mvc.entidades.Libro;

public class IDAOLibroSQLite implements IDAOLibro {
	
	public Connection getConnection(){
		Connection con =null;
		try {
			String url = "jdbc:sqlite:/Users/Ferna/eclipse-workspace/arquitecturas/src/main/resources/Libreria.db";
			con = DriverManager.getConnection(url);
		}
		catch(Exception e) {
			System.out.print("Excepction at conection:" + e);
		}
		return con;
	}
	
	@Override
	public Libro crearLibro(String nombre, String autor, String isbn) {
		Connection con = getConnection();
		int id = -1;
		Libro libro = null;
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("INSERT INTO libros(nombre,autor,isbn) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,nombre);
			ps.setString(2,autor);
			ps.setString(3,isbn);
			
			int rows = ps.executeUpdate();
			if (rows>=1) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					id = rs.getInt(1);
				libro = new Libro(id,nombre,autor,isbn);
			}
			con.close();
			ps.close();
			}
		}
		catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		return libro;
	}

	@Override
	public Libro obtenerLibro(String isbn) {
		Libro libro = null;
		libro = findByISBN(isbn);
		return libro;
	}

	@Override
	public boolean modificarLibro(Libro libro) {
		Connection con = getConnection();
		boolean result = false;
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("UPDATE libros SET nombre = ? , autor = ?, isbn = ? WHERE id = ?");
			ps.setString(1, libro.getNombre());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getIsbn());
			ps.setInt(4,libro.getId());
			
			int rows = ps.executeUpdate();
			if (rows >= 1) {
				result = true;			
			}
			con.close();
			ps.close();			
		}
		catch(Exception e){
		}
		return result;

	}

	@Override
	public Libro borrarLibro(String isbn) {
		Connection con = getConnection();
		Libro libro = null;
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("DELETE FROM libros WHERE isbn = ?");
			ps.setString(1, isbn);
			
			int rows = ps.executeUpdate();
	        if (rows > 0) {
	            libro = new Libro();
	            libro.setIsbn(isbn);
	            System.out.println("Libro con ISBN " + isbn + " eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
	        }
			
			con.close();
			ps.close();
			
		}
		catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		return libro;
	}

	@Override
	public List<Libro> getAllLibros() {
		List<Libro> libros = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = getConnection();
	        ps = con.prepareStatement("SELECT * FROM libros");
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String autor = rs.getString("autor");
	            String isbn = rs.getString("isbn");
	            
	            Libro libro = new Libro(id, nombre, autor, isbn);
	            libros.add(libro);
	        }
	        con.close();
			ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return libros;
	}

	@Override
	public Libro findByISBN(String isbn) {
		Libro libro = null;
		Connection con = getConnection();
		
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM libros WHERE isbn = ?");
			ps.setString(1,isbn);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				libro = new Libro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
			con.close();
			ps.close();			
		}
		catch(Exception e){
		}
		return libro;

	}

}
