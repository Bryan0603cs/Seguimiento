package com.seguimiento2;

import java.util.List;

public interface Prestamo {
    boolean prestarLibro(Cliente cliente, Libro libro);
    boolean devolverLibro(Cliente cliente, Libro libro);
    List<PrestamoRegistro> obtenerPrestamosPorLibro(Libro libro);
}


