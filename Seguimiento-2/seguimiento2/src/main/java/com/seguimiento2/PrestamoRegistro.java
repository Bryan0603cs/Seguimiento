package com.seguimiento2;

import java.time.LocalDate;

public class PrestamoRegistro {
    private Libro libro;
    private Cliente cliente;
    private LocalDate FechaPrestamo;
    private LocalDate FechaDevolucion;

    public PrestamoRegistro(Libro libro, Cliente cliente, LocalDate FechaPrestamo, LocalDate FechaDevolucion) {

        assert libro != null : "El libro es requerido";
        assert cliente != null : "El libro es requerido";
        assert FechaPrestamo != null : "El libro es requerido";

        this.libro = libro;
        this.cliente = cliente;
        this.FechaPrestamo = FechaPrestamo;
        this.FechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo(){
        return FechaPrestamo;
    }

    public LocalDate getFechaDevolucion(){
        return FechaDevolucion;
    }
        
    public void setFechaDevolucion(LocalDate fechaDevolucion){
        this.FechaDevolucion = fechaDevolucion;
    }

}
