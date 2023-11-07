package com.seguimiento2;

import java.sql.Date;
import java.time.LocalDate;

public class PrestamoRegistro {
    private Libro libro;
    private Cliente cliente;
    private LocalDate FechaPrestamo;

    public PrestamoRegistro(Libro libro, Cliente cliente,LocalDate FechaPrestamo) {
        this.libro = libro;
        this.cliente = cliente;
        this.FechaPrestamo = FechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getLocalDate(){
        return FechaPrestamo;
    }
}
