package com.anahuac.desarrollo.mvc.datos;

import java.util.List;

import com.anahuac.desarrollo.mvc.entidades.Libro;

public interface IDAOLibro {
	public Libro crearLibro(String nombre,String autor,String isbn);
	public Libro obtenerLibro(String isbn);
	public boolean modificarLibro(Libro libro);
	public Libro borrarLibro(String isbn);
	public List<Libro> getAllLibros();
	public Libro findByISBN(String isbn);
}
