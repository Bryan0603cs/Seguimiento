package com.seguimiento2;

public class Libro {
    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String autor, int ejemplaresDisponibles) {

        assert titulo != null : "El título del libro es requerido";
        assert autor != null : "El autor del libro es requerido";
        assert ejemplaresDisponibles >=0 : "El numero de ejemplares debe ser mayor a cero";

        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

}
