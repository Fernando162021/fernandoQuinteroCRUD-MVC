package com.anahuac.desarrollo.mvc.logica;

import com.anahuac.desarrollo.mvc.datos.IDAOLibroSQLite;
import com.anahuac.desarrollo.mvc.entidades.Libro;

public class ControllerLibro {
private IDAOLibroSQLite dao;
	
	public ControllerLibro() {
		dao = new IDAOLibroSQLite();
	}
	public Libro crearLibro(String nombre,String autor,String isbn) {
		Libro libro = null;
		if(dao.findByISBN(isbn)!= null) {
			System.out.println("Ya existe un libro con el mismo ISBN");
		}else {
			libro = dao.crearLibro(nombre, autor, isbn);
		}
		return libro;
	}
	
	public void eliminarLibro(String isbn) {
		Libro libro = dao.borrarLibro(isbn);
		System.out.println(libro);
	}
	
	public void buscarLibro(String isbn) {
		Libro libro = dao.findByISBN(isbn);
		System.out.println(libro);
	}
	
	public boolean actualizarLibro(Libro nuevoLibro) {
		return dao.modificarLibro(nuevoLibro);
	}
}
