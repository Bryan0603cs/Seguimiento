package com.seguimiento2;

public class Libro {
    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String autor, int ejemplaresDisponibles) {
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

    public void prestar() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
        }
    }

    public void devolver() {
        ejemplaresDisponibles++;
    }
}
