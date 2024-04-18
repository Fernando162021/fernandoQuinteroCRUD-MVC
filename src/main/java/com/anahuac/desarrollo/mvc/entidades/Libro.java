package com.anahuac.desarrollo.mvc.entidades;

public class Libro {
	private int id;
	private String nombre;
	private String autor;
	private String isbn;
	
	public Libro(){}
	
	public Libro(int id, String nombre, String autor, String isbn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.isbn = isbn;
	}
	public Libro(String nombre, String autor, String isbn) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", isbn=" + isbn + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
